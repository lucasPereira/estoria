package br.ufsc.ine.leb.projetos.estoria;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestes extends Runner {

	private Result resultado;
	private SuiteDeTeste suiteDeTeste;
	private Description descricaoDaSuite;
	private RunNotifier mensageiroDeEscolta;

	public EscoltadorDeTestes(SuiteDeTeste suiteDeTeste) {
		this.suiteDeTeste = suiteDeTeste;
		this.descricaoDaSuite = Description.createSuiteDescription(suiteDeTeste.obterSuite());
		suiteDeTeste.obterClassesDeTeste().forEach(classeDeTeste -> classeDeTeste.obterMetodosDeTesteIgnorados().forEach(metodoDeTeste -> descricaoDaSuite.addChild(metodoDeTeste.obterDescricao())));
		suiteDeTeste.obterClassesDeTeste().forEach(classeDeTeste -> classeDeTeste.obterMetodosDeTeste().forEach(metodoDeTeste -> descricaoDaSuite.addChild(metodoDeTeste.obterDescricao())));
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

	private void executarSuite(SuiteDeTeste suiteDeTeste) {
		mensageiroDeEscolta.fireTestRunStarted(descricaoDaSuite);
		execuitarTestesIgnorados(suiteDeTeste);
		executarTestes(suiteDeTeste);
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

	private void execuitarTestesIgnorados(SuiteDeTeste suiteDeTeste) {
		for (ClasseDeTeste classeDeteste : suiteDeTeste.obterClassesDeTeste()) {
			executarClasseDeTesteIgnorados(classeDeteste);
		}
	}

	private void executarTestes(SuiteDeTeste suiteDeTeste) {
		for (ClasseDeTeste classeDeTeste : suiteDeTeste.obterClassesDeTeste()) {
			executarClasseDeTeste(classeDeTeste);
		}
	}

	private void executarClasseDeTeste(ClasseDeTeste classeDeTeste) {
		for (MetodoDeTeste metodoDeTeste : classeDeTeste.obterMetodosDeTeste()) {
			executarMetodoDeTeste(classeDeTeste, metodoDeTeste);
		}
	}

	private void executarMetodoDeTeste(ClasseDeTeste classeDeTeste, MetodoDeTeste metodoDeTeste) {
		Map<ClasseDeTeste, InvocadorDeMetodo<?>> classesSingularesExecutadas = new HashMap<>();
		TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
		TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
		InvocadorDeMetodo<?> invocadorParaClasseDeTeste = new InvocadorDeMetodo<>(classeDeTeste.obterClasse());
		mensageiroDeEscolta.fireTestStarted(metodoDeTeste.obterDescricao());
		executarConfiguracaoDaClasseDeTeste(classeDeTeste, tratadorDeConfiguracao, invocadorParaClasseDeTeste, classesSingularesExecutadas);
		invocadorParaClasseDeTeste.executar(metodoDeTeste.obterMetodo(), tratadorDeTeste);
		System.out.println(String.format("Teste %s.%s", classeDeTeste, metodoDeTeste));
		mensageiroDeEscolta.fireTestFinished(metodoDeTeste.obterDescricao());
	}

	private void executarConfiguracaoDaClasseDeTeste(ClasseDeTeste classeDeTeste, TratadorDeInvocacao tratadorDeConfiguracao, InvocadorDeMetodo<?> invocadorParaClasseDeTeste, Map<ClasseDeTeste, InvocadorDeMetodo<?>> classesSingularesExecutadas) {
		Map<AtributoAcessorio, Boolean> atributosEnxertados = new HashMap<>();
		if (!classesSingularesExecutadas.containsKey(classeDeTeste)) {
			for (ClasseDeTeste classeAcessorio : classeDeTeste.obterAcessorios()) {
				InvocadorDeMetodo<?> invocadorParaAcessorio = classesSingularesExecutadas.containsKey(classeAcessorio) ? classesSingularesExecutadas.get(classeAcessorio) : new InvocadorDeMetodo<>(classeAcessorio.obterClasse());
				executarConfiguracaoDaClasseDeTeste(classeAcessorio, tratadorDeConfiguracao, invocadorParaAcessorio, classesSingularesExecutadas);
				enxertarAcessorios(classeDeTeste, classeAcessorio, invocadorParaClasseDeTeste, invocadorParaAcessorio, atributosEnxertados);
			}
			for (MetodoDeConfiguracao metodoDeConfiguracao : classeDeTeste.obterMetodosDeConfiguracao()) {
				invocadorParaClasseDeTeste.executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao);
				System.out.println(String.format("Configuração %s.%s", classeDeTeste, metodoDeConfiguracao));
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
				System.out.println(String.format("Enxerto: %s.%s em %s.%s", classeAcessorio, atributoProprio, classeDeTeste, atributoAcessorio));
				atributosEnxertados.put(atributoAcessorio, true);
				enxertador.enxertar(atributoProprio.obterAtributo(), atributoAcessorio.obterAtributo());
			}
		}
	}

	private void executarClasseDeTesteIgnorados(ClasseDeTeste classeDeteste) {
		for (MetodoDeTeste metodoDeTeste : classeDeteste.obterMetodosDeTesteIgnorados()) {
			mensageiroDeEscolta.fireTestIgnored(metodoDeTeste.obterDescricao());
		}
	}

}
