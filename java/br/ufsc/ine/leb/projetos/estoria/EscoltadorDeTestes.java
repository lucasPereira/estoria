package br.ufsc.ine.leb.projetos.estoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestes extends Runner implements Filterable {

	private Result resultado;
	private SuiteDeTeste suiteDeTeste;
	private RunNotifier mensageiroDeEscolta;
	private List<Filter> filtros;
	private Ata ata;

	public EscoltadorDeTestes(SuiteDeTeste suiteDeTeste) {
		this(suiteDeTeste, new Ata());
	}

	public EscoltadorDeTestes(SuiteDeTeste suiteDeTeste, Ata ata) {
		this.ata = ata;
		this.suiteDeTeste = suiteDeTeste;
		this.filtros = new LinkedList<>();
	}

	@Override
	public final Description getDescription() {
		return suiteDeTeste.classeDeTesteComoSuite() ? criarDescicao(suiteDeTeste.obterClassesDeTeste().iterator().next()) : criarDescricao(suiteDeTeste);
	}

	private Description criarDescricao(SuiteDeTeste suiteDeTeste) {
		Description descricao = Description.createSuiteDescription(suiteDeTeste.obterSuite());
		List<Description> filhos = obterFilhos(suiteDeTeste);
		filhos.forEach(filho -> descricao.addChild(filho));
		return descricao;
	}

	private Description criarDescicao(ClasseDeTeste classeDeTeste) {
		Description descricao = Description.createSuiteDescription(classeDeTeste.obterClasse());
		List<Description> filhos = obterFilhos(classeDeTeste);
		filhos.forEach(filho -> descricao.addChild(filho));
		return descricao;
	}

	private List<Description> obterFilhos(SuiteDeTeste suiteDeTeste) {
		List<Description> filhos = new LinkedList<>();
		suiteDeTeste.obterClassesDeTeste().forEach(classeDeTeste -> filhos.add(criarDescicao(classeDeTeste)));
		return filhos.isEmpty() ? Arrays.asList(Description.EMPTY) : filhos;
	}

	public List<Description> obterFilhos(ClasseDeTeste classeDeTeste) {
		List<Description> filhos = new LinkedList<>();
		classeDeTeste.obterMetodosDeTesteIgnorados().forEach(metodo -> filtrar(filhos, criarDescricao(metodo)));
		classeDeTeste.obterMetodosDeTeste().forEach(metodo -> filtrar(filhos, criarDescricao(metodo)));
		return filhos.isEmpty() ? Arrays.asList(Description.EMPTY) : filhos;
	}

	private Description criarDescricao(Metodo metodo) {
		Description descricao = Description.createTestDescription(metodo.obterClasseDeTeste().obterClasse(), metodo.obterNome());
		return descricao;
	}

	private void filtrar(List<Description> filhos, Description descricao) {
		List<Boolean> filtragens = new ArrayList<>(filtros.size());
		filtros.forEach(filtro -> filtragens.add(filtro.shouldRun(descricao)));
		if (!filtragens.contains(false)) {
			filhos.add(descricao);
		}
	}

	@Override
	public final void run(RunNotifier mensageiroDeEscolta) {
		ata.registrar("Estória");
		ata.avancarIndentacao();
		this.mensageiroDeEscolta = mensageiroDeEscolta;
		resultado = new Result();
		mensageiroDeEscolta.addListener(resultado.createListener());
		executarSuite(suiteDeTeste);
	}

	@Override
	public void filter(Filter filtro) throws NoTestsRemainException {
		filtros.add(filtro);
	}

	private void executarSuite(SuiteDeTeste suiteDeTeste) {
		ata.registrar("%s", suiteDeTeste);
		ata.avancarIndentacao();
		mensageiroDeEscolta.fireTestRunStarted(getDescription());
		execuitarTestesIgnorados(suiteDeTeste);
		executarTestes(suiteDeTeste);
		mensageiroDeEscolta.fireTestRunFinished(resultado);
		ata.recuarIndentacao();
	}

	private void execuitarTestesIgnorados(SuiteDeTeste suiteDeTeste) {
		for (ClasseDeTeste classeDeteste : suiteDeTeste.obterClassesDeTeste()) {
			for (Metodo metodoDeTeste : classeDeteste.obterMetodosDeTesteIgnorados()) {
				if (!filtrarExecucao(metodoDeTeste)) {
					executarMetodoDeTesteIgnorado(metodoDeTeste);
				}
			}
		}
	}

	private void executarTestes(SuiteDeTeste suiteDeTeste) {
		for (ClasseDeTeste classeDeTeste : suiteDeTeste.obterClassesDeTeste()) {
			ata.registrar("%s", classeDeTeste);
			ata.avancarIndentacao();
			for (Metodo metodoDeTeste : classeDeTeste.obterMetodosDeTeste()) {
				if (!filtrarExecucao(metodoDeTeste)) {
					executarMetodoDeTeste(classeDeTeste, metodoDeTeste);
				}
			}
			ata.recuarIndentacao();
		}
	}

	private void executarMetodoDeTesteIgnorado(Metodo metodoDeTeste) {
		ata.registrar("@Ignore %s", metodoDeTeste);
		Description descricaoDoMetodoDeTeste = Description.createTestDescription(metodoDeTeste.obterClasseDeTeste().obterClasse(), metodoDeTeste.obterNome());
		mensageiroDeEscolta.fireTestIgnored(descricaoDoMetodoDeTeste);
	}

	private void executarMetodoDeTeste(ClasseDeTeste classeDeTeste, Metodo metodoDeTeste) {
		if (classeDeTeste.ignorada() || suiteDeTeste.ignorada()) {
			executarMetodoDeTesteIgnorado(metodoDeTeste);
		} else {
			ata.registrar("%s", metodoDeTeste);
			ata.avancarIndentacao();
			Map<ClasseDeTeste, InvocadorDeMetodo<?>> classesSingularesExecutadas = new HashMap<>();
			Description descricaoDoMetodoDeTeste = Description.createTestDescription(metodoDeTeste.obterClasseDeTeste().obterClasse(), metodoDeTeste.obterNome());
			TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(descricaoDoMetodoDeTeste, mensageiroDeEscolta);
			TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(descricaoDoMetodoDeTeste, mensageiroDeEscolta);
			InvocadorDeMetodo<?> invocadorParaClasseDeTeste = new InvocadorDeMetodo<>(classeDeTeste.obterClasse());
			mensageiroDeEscolta.fireTestStarted(descricaoDoMetodoDeTeste);
			executarConfiguracaoDaClasseDeTeste(classeDeTeste, tratadorDeConfiguracao, invocadorParaClasseDeTeste, classesSingularesExecutadas);
			invocadorParaClasseDeTeste.executar(metodoDeTeste.obterMetodo(), tratadorDeTeste);
			ata.registrar("@Test %s", metodoDeTeste);
			mensageiroDeEscolta.fireTestFinished(descricaoDoMetodoDeTeste);
			ata.recuarIndentacao();
		}
	}

	private void executarConfiguracaoDaClasseDeTeste(ClasseDeTeste classeDeTeste, TratadorDeInvocacao tratadorDeConfiguracao, InvocadorDeMetodo<?> invocadorParaClasseDeTeste, Map<ClasseDeTeste, InvocadorDeMetodo<?>> classesSingularesExecutadas) {
		Map<Atributo, Boolean> atributosEnxertados = new HashMap<>();
		if (!classesSingularesExecutadas.containsKey(classeDeTeste)) {
			for (ClasseDeTeste classeAcessorio : classeDeTeste.obterClassesProvedoras()) {
				ata.registrar("@FixtureSetup %s", classeAcessorio);
				ata.avancarIndentacao();
				InvocadorDeMetodo<?> invocadorParaAcessorio = classesSingularesExecutadas.containsKey(classeAcessorio) ? classesSingularesExecutadas.get(classeAcessorio) : new InvocadorDeMetodo<>(classeAcessorio.obterClasse());
				executarConfiguracaoDaClasseDeTeste(classeAcessorio, tratadorDeConfiguracao, invocadorParaAcessorio, classesSingularesExecutadas);
				enxertarAcessorios(classeDeTeste, classeAcessorio, invocadorParaClasseDeTeste, invocadorParaAcessorio, atributosEnxertados);
				ata.recuarIndentacao();
			}
			for (Metodo metodoDeConfiguracao : classeDeTeste.obterMetodosDeConfiguracao()) {
				invocadorParaClasseDeTeste.executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao);
				ata.registrar("@Before %s", metodoDeConfiguracao);
			}
			if (classeDeTeste.singular()) {
				classesSingularesExecutadas.put(classeDeTeste, invocadorParaClasseDeTeste);
			}
		}
	}

	private void enxertarAcessorios(ClasseDeTeste classeDeTeste, ClasseDeTeste classeAcessorio, InvocadorDeMetodo<?> invocadorParaClasseDeTeste, InvocadorDeMetodo<?> invocadorParaAcessorio, Map<Atributo, Boolean> atributosEnxertados) {
		EnxertorDeAtributo enxertador = new EnxertorDeAtributo(invocadorParaAcessorio.obterInstancia(), invocadorParaClasseDeTeste.obterInstancia());
		for (Atributo atributoProprio : classeAcessorio.obterAtributosProprios()) {
			enxertarAcessorio(classeDeTeste, classeAcessorio, enxertador, atributoProprio, atributosEnxertados);
		}
		for (Atributo atributoAcessorio : classeAcessorio.obterAtributosAcessorios()) {
			enxertarAcessorio(classeDeTeste, classeAcessorio, enxertador, atributoAcessorio, atributosEnxertados);
		}
	}

	private void enxertarAcessorio(ClasseDeTeste classeDeTeste, ClasseDeTeste classeAcessorio, EnxertorDeAtributo enxertador, Atributo atributoProprio, Map<Atributo, Boolean> atributosEnxertados) {
		for (Atributo atributoAcessorio : classeDeTeste.obterAtributosAcessorios()) {
			if (atributoAcessorio.compativelCom(atributoProprio) && !atributosEnxertados.containsKey(atributoAcessorio)) {
				ata.registrar("@Fixture %s", atributoProprio);
				atributosEnxertados.put(atributoAcessorio, true);
				enxertador.enxertar(atributoProprio.obterAtributo(), atributoAcessorio.obterAtributo());
			}
		}
	}

	private Boolean filtrarExecucao(Metodo metodoDeTeste) {
		for (Filter filtro : filtros) {
			Description descricaoDoMetodoDeTeste = Description.createTestDescription(metodoDeTeste.obterClasseDeTeste().obterClasse(), metodoDeTeste.obterNome());
			if (!filtro.shouldRun(descricaoDoMetodoDeTeste)) {
				return true;
			}
		}
		return false;
	}

}
