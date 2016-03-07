package br.ufsc.ine.leb.projetos.estoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestesReaproveitador extends Runner implements Filterable {

	private SuiteDeTeste suiteDeTeste;
	private RunNotifier mensageiroDeEscolta;

	public EscoltadorDeTestesReaproveitador(SuiteDeTeste suiteDeTeste, Ata ata) {
		this.suiteDeTeste = suiteDeTeste;
	}

	@Override
	public void filter(Filter filtro) throws NoTestsRemainException {}

	@Override
	public final Description getDescription() {
		return suiteDeTeste.classeDeTesteComoSuite() ? criarDescricao(suiteDeTeste.obterClassesDeTeste().iterator().next()) : criarDescricao(suiteDeTeste);
	}

	@Override
	public final void run(RunNotifier mensageiroDeEscolta) {
		this.mensageiroDeEscolta = mensageiroDeEscolta;
		Result resultado = new Result();
		mensageiroDeEscolta.addFirstListener(resultado.createListener());
		mensageiroDeEscolta.fireTestRunStarted(getDescription());
		executar();
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

	private Set<ClasseDeTeste> obterRamosDeExecucao() {
		Set<ClasseDeTeste> ramosDeExecucao = new HashSet<>();
		suiteDeTeste.obterClassesDeTeste().forEach(classeDeTeste -> {
			if (classeDeTeste.obterClassesConsumidoras().isEmpty()) {
				ramosDeExecucao.add(classeDeTeste);
			}
		});
		return ramosDeExecucao;
	}

	private Set<Metodo> obterTestes() {
		Set<Metodo> testes = new HashSet<>();
		suiteDeTeste.obterClassesDeTeste().forEach(classeDeTeste -> {
			testes.addAll(classeDeTeste.obterMetodosDeTeste());
		});
		return testes;
	}

	private void executar() {
		List<ClasseDeTeste> ramosDeExecucao = new ArrayList<>(obterRamosDeExecucao());
		List<Metodo> testes = new ArrayList<>(obterTestes());
		Collections.sort(ramosDeExecucao, construirOrdenadorDeRamoDeExecucao());
		Collections.sort(testes, construirComparadorDeMetodo());
		System.out.println(ramosDeExecucao);
		System.out.println(testes);
		ramosDeExecucao.forEach(classeDeTeste -> {
			Map<ClasseDeTeste, InvocadorDeMetodo<?>> invocadores = new HashMap<>();
			executar(classeDeTeste, testes, invocadores);
		});
		testes.forEach(metodoDeTeste -> {
			Map<ClasseDeTeste, InvocadorDeMetodo<?>> invocadores = new HashMap<>();
			executar(metodoDeTeste.obterClasseDeTeste(), testes, invocadores);
		});
	}

	private void executar(ClasseDeTeste classeDeTeste, List<Metodo> testes, Map<ClasseDeTeste, InvocadorDeMetodo<?>> invocadores) {
		if (!invocadores.containsKey(classeDeTeste)) {
			InvocadorDeMetodo<?> invocador = new InvocadorDeMetodo<>(classeDeTeste.obterClasse());
			invocadores.put(classeDeTeste, invocador);
		}
		classeDeTeste.obterClassesProvedoras().forEach(classeProvedora -> {
			executar(classeProvedora, testes, invocadores);
		});
		classeDeTeste.obterAtributosAcessorios().forEach(atributoAcessorio -> {
			enxertar(atributoAcessorio, invocadores);
		});
		classeDeTeste.obterMetodosDeConfiguracao().forEach(metodoDeConfiguracao -> {
			executar(metodoDeConfiguracao, invocadores);
		});
		classeDeTeste.obterMetodosDeTeste().forEach(metodoDeTeste -> {
			executar(metodoDeTeste, testes, invocadores);
		});
	}

	private void executar(Metodo metodoDeTeste, List<Metodo> testes, Map<ClasseDeTeste, InvocadorDeMetodo<?>> invocadores) {
		if (testes.contains(metodoDeTeste)) {
			Description descricao = criarDescricao(metodoDeTeste);
			mensageiroDeEscolta.fireTestStarted(descricao);
			TratadorDeInvocacao tratador = new TratadorDeInvocacaoDeTeste(descricao, mensageiroDeEscolta);
			InvocadorDeMetodo<?> invocador = invocadores.get(metodoDeTeste.obterClasseDeTeste());
			invocador.executar(metodoDeTeste.obterMetodo(), tratador);
			mensageiroDeEscolta.fireTestFinished(descricao);
			testes.remove(metodoDeTeste);
		}
	}

	private void executar(Metodo metodoDeConfiguracao, Map<ClasseDeTeste, InvocadorDeMetodo<?>> invocadores) {
		Description descricao = criarDescricao(metodoDeConfiguracao);
		TratadorDeInvocacao tratador = new TratadorDeInvocacaoDeConfiguracao(descricao, mensageiroDeEscolta);
		InvocadorDeMetodo<?> invocador = invocadores.get(metodoDeConfiguracao.obterClasseDeTeste());
		invocador.executar(metodoDeConfiguracao.obterMetodo(), tratador);
	}

	private void enxertar(Atributo atributoClasseConsumidora, Map<ClasseDeTeste, InvocadorDeMetodo<?>> invocadores) {
		ClasseDeTeste classeConsumidora = atributoClasseConsumidora.obterClasseDeTeste();
		classeConsumidora.obterClassesProvedoras().forEach(classeProvedora -> {
			Object instanciaClasseProvedora = invocadores.get(classeProvedora).obterInstancia();
			Object instanciaClasseConsumidora = invocadores.get(classeConsumidora).obterInstancia();
			EnxertorDeAtributo enxertor = new EnxertorDeAtributo(instanciaClasseProvedora, instanciaClasseConsumidora);
			exertar(atributoClasseConsumidora, classeProvedora, enxertor);
		});
	}

	private void exertar(Atributo atributoClasseConsumidora, ClasseDeTeste classeProvedora, EnxertorDeAtributo enxertador) {
		classeProvedora.obterAtributosProprios().forEach(atributoClasseProvedora -> {
			enxertar(atributoClasseConsumidora, atributoClasseProvedora, enxertador);
		});
		classeProvedora.obterAtributosAcessorios().forEach(atributoClasseProvedora -> {
			enxertar(atributoClasseConsumidora, atributoClasseProvedora, enxertador);
		});
	}

	private void enxertar(Atributo atributoClasseConsumidora, Atributo atributoClasseProvedora, EnxertorDeAtributo enxertador) {
		if (atributoClasseConsumidora.compativelCom(atributoClasseProvedora)) {
			enxertador.enxertar(atributoClasseProvedora.obterAtributo(), atributoClasseConsumidora.obterAtributo());
		}
	}

	private Description criarDescricao(SuiteDeTeste suiteDeTeste) {
		Description descricao = Description.createSuiteDescription(suiteDeTeste.obterSuite());
		List<Description> filhos = obterFilhos(suiteDeTeste);
		filhos.forEach(filho -> descricao.addChild(filho));
		return descricao;
	}

	private Description criarDescricao(ClasseDeTeste classeDeTeste) {
		Description descricao = Description.createSuiteDescription(classeDeTeste.obterClasse());
		List<Description> filhos = obterFilhos(classeDeTeste);
		filhos.forEach(filho -> descricao.addChild(filho));
		return descricao;
	}

	private Description criarDescricao(Metodo metodo) {
		Description descricao = Description.createTestDescription(metodo.obterClasseDeTeste().obterClasse(), metodo.obterNome());
		return descricao;
	}

	private List<Description> obterFilhos(SuiteDeTeste suiteDeTeste) {
		List<Description> filhos = new LinkedList<>();
		suiteDeTeste.obterClassesDeTeste().forEach(classeDeTeste -> filhos.add(criarDescricao(classeDeTeste)));
		return filhos.isEmpty() ? Arrays.asList(Description.EMPTY) : filhos;
	}

	public List<Description> obterFilhos(ClasseDeTeste classeDeTeste) {
		List<Description> filhos = new LinkedList<>();
		classeDeTeste.obterMetodosDeTesteIgnorados().forEach(metodo -> filtrar(filhos, criarDescricao(metodo)));
		classeDeTeste.obterMetodosDeTeste().forEach(metodo -> filtrar(filhos, criarDescricao(metodo)));
		return filhos.isEmpty() ? Arrays.asList(Description.EMPTY) : filhos;
	}

	private void filtrar(List<Description> filhos, Description descricao) {
		filhos.add(descricao);
	}

	private Comparator<Metodo> construirComparadorDeMetodo() {
		return new Comparator<Metodo>() {

			@Override
			public int compare(Metodo metodo1, Metodo metodo2) {
				Integer nomeClasseDeTeste = metodo1.obterClasseDeTeste().obterClasse().getSimpleName().compareTo(metodo2.obterClasseDeTeste().obterClasse().getSimpleName());
				Integer nomeMetodo = metodo1.obterNome().compareTo(metodo2.obterNome());
				return nomeClasseDeTeste == 0 ? nomeMetodo : nomeClasseDeTeste;
			}

		};
	}

	private Comparator<ClasseDeTeste> construirOrdenadorDeRamoDeExecucao() {
		return new Comparator<ClasseDeTeste>() {

			@Override
			public int compare(ClasseDeTeste classeDeTeste1, ClasseDeTeste classeDeTeste2) {
				Integer nomeClasseDeTeste = classeDeTeste1.obterClasse().getSimpleName().compareTo(classeDeTeste2.obterClasse().getSimpleName());
				return nomeClasseDeTeste;
			}

		};
	}

}
