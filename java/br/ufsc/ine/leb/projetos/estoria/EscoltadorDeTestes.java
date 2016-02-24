package br.ufsc.ine.leb.projetos.estoria;

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
	private Description descricaoDaSuite;
	private RunNotifier mensageiroDeEscolta;
	private List<Filter> filtros;
	private Ata ata;

	public EscoltadorDeTestes(SuiteDeTeste suiteDeTeste) {
		this.suiteDeTeste = suiteDeTeste;
		this.descricaoDaSuite = suiteDeTeste.obterDescricao(new FilterVazio());
		this.filtros = new LinkedList<>();
		this.ata = new Ata();
	}

	@Override
	public final Description getDescription() {
		return descricaoDaSuite;
	}

	@Override
	public final void run(RunNotifier mensageiroDeEscolta) {
		this.mensageiroDeEscolta = mensageiroDeEscolta;
		resultado = new Result();
		mensageiroDeEscolta.addListener(resultado.createListener());
		executarSuite(suiteDeTeste);
	}

	@Override
	public void filter(Filter filtro) throws NoTestsRemainException {
		filtros.add(filtro);
		this.descricaoDaSuite = suiteDeTeste.obterDescricao(filtro);
	}

	private void executarSuite(SuiteDeTeste suiteDeTeste) {
		ata.registrar("%s", suiteDeTeste);
		ata.avancarIndentacao();
		mensageiroDeEscolta.fireTestRunStarted(descricaoDaSuite);
		execuitarTestesIgnorados(suiteDeTeste);
		executarTestes(suiteDeTeste);
		mensageiroDeEscolta.fireTestRunFinished(resultado);
		ata.recuarIndentacao();
	}

	private void execuitarTestesIgnorados(SuiteDeTeste suiteDeTeste) {
		for (ClasseDeTeste classeDeteste : suiteDeTeste.obterClassesDeTeste()) {
			for (MetodoDeTeste metodoDeTeste : classeDeteste.obterMetodosDeTesteIgnorados()) {
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
			for (MetodoDeTeste metodoDeTeste : classeDeTeste.obterMetodosDeTeste()) {
				if (!filtrarExecucao(metodoDeTeste)) {
					executarMetodoDeTeste(classeDeTeste, metodoDeTeste);
				}
			}
			ata.recuarIndentacao();
		}
	}

	private void executarMetodoDeTesteIgnorado(MetodoDeTeste metodoDeTeste) {
		mensageiroDeEscolta.fireTestIgnored(metodoDeTeste.obterDescricao());
	}

	private void executarMetodoDeTeste(ClasseDeTeste classeDeTeste, MetodoDeTeste metodoDeTeste) {
		if (classeDeTeste.ignorada() || suiteDeTeste.ignorada()) {
			executarMetodoDeTesteIgnorado(metodoDeTeste);
		} else {
			ata.registrar("%s", metodoDeTeste);
			ata.avancarIndentacao();
			Map<ClasseDeTeste, InvocadorDeMetodo<?>> classesSingularesExecutadas = new HashMap<>();
			TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
			TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
			InvocadorDeMetodo<?> invocadorParaClasseDeTeste = new InvocadorDeMetodo<>(classeDeTeste.obterClasse());
			mensageiroDeEscolta.fireTestStarted(metodoDeTeste.obterDescricao());
			executarConfiguracaoDaClasseDeTeste(classeDeTeste, tratadorDeConfiguracao, invocadorParaClasseDeTeste, classesSingularesExecutadas);
			invocadorParaClasseDeTeste.executar(metodoDeTeste.obterMetodo(), tratadorDeTeste);
			ata.registrar("@Test %s", metodoDeTeste);
			mensageiroDeEscolta.fireTestFinished(metodoDeTeste.obterDescricao());
			ata.recuarIndentacao();
		}
	}

	private void executarConfiguracaoDaClasseDeTeste(ClasseDeTeste classeDeTeste, TratadorDeInvocacao tratadorDeConfiguracao, InvocadorDeMetodo<?> invocadorParaClasseDeTeste, Map<ClasseDeTeste, InvocadorDeMetodo<?>> classesSingularesExecutadas) {
		Map<AtributoAcessorio, Boolean> atributosEnxertados = new HashMap<>();
		if (!classesSingularesExecutadas.containsKey(classeDeTeste)) {
			for (ClasseDeTeste classeAcessorio : classeDeTeste.obterAcessorios()) {
				ata.registrar("@FixtureSetup %s", classeAcessorio);
				ata.avancarIndentacao();
				InvocadorDeMetodo<?> invocadorParaAcessorio = classesSingularesExecutadas.containsKey(classeAcessorio) ? classesSingularesExecutadas.get(classeAcessorio) : new InvocadorDeMetodo<>(classeAcessorio.obterClasse());
				executarConfiguracaoDaClasseDeTeste(classeAcessorio, tratadorDeConfiguracao, invocadorParaAcessorio, classesSingularesExecutadas);
				enxertarAcessorios(classeDeTeste, classeAcessorio, invocadorParaClasseDeTeste, invocadorParaAcessorio, atributosEnxertados);
				ata.recuarIndentacao();
			}
			for (MetodoDeConfiguracao metodoDeConfiguracao : classeDeTeste.obterMetodosDeConfiguracao()) {
				invocadorParaClasseDeTeste.executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao);
				ata.registrar("@Before %s", metodoDeConfiguracao);
			}
			if (classeDeTeste.singular()) {
				classesSingularesExecutadas.put(classeDeTeste, invocadorParaClasseDeTeste);
			}
		}
	}

	private void enxertarAcessorios(ClasseDeTeste classeDeTeste, ClasseDeTeste classeAcessorio, InvocadorDeMetodo<?> invocadorParaClasseDeTeste, InvocadorDeMetodo<?> invocadorParaAcessorio, Map<AtributoAcessorio, Boolean> atributosEnxertados) {
		EnxertorDeAtributo enxertador = new EnxertorDeAtributo(invocadorParaAcessorio.obterInstancia(), invocadorParaClasseDeTeste.obterInstancia());
		for (AtributoProprio atributoProprio : classeAcessorio.obterAtributosProprios()) {
			enxertarAcessorio(classeDeTeste, classeAcessorio, enxertador, atributoProprio, atributosEnxertados);
		}
		for (AtributoAcessorio atributoAcessorio : classeAcessorio.obterAtributosAcessorios()) {
			enxertarAcessorio(classeDeTeste, classeAcessorio, enxertador, atributoAcessorio, atributosEnxertados);
		}
	}

	private void enxertarAcessorio(ClasseDeTeste classeDeTeste, ClasseDeTeste classeAcessorio, EnxertorDeAtributo enxertador, Atributo atributoProprio, Map<AtributoAcessorio, Boolean> atributosEnxertados) {
		for (AtributoAcessorio atributoAcessorio : classeDeTeste.obterAtributosAcessorios()) {
			if (atributoAcessorio.compativelCom(atributoProprio) && !atributosEnxertados.containsKey(atributoAcessorio)) {
				ata.registrar("@Fixture %s", atributoProprio);
				atributosEnxertados.put(atributoAcessorio, true);
				enxertador.enxertar(atributoProprio.obterAtributo(), atributoAcessorio.obterAtributo());
			}
		}
	}

	private Boolean filtrarExecucao(MetodoDeTeste metodoDeTeste) {
		for (Filter filtro : filtros) {
			if (!filtro.shouldRun(metodoDeTeste.obterDescricao())) {
				return true;
			}
		}
		return false;
	}

}
