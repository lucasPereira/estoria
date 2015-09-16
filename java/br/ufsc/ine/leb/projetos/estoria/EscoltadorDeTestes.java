package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestes extends Runner {

	private SuiteDeTeste suiteDeTeste;
	private Description descricaoDaSuite;
	private RunNotifier mensageiroDeEscolta;
	private Result resultado;

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
		TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
		TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
		InvocadorDeMetodo<?> invocadorParaClasseDeTeste = new InvocadorDeMetodo<>(classeDeTeste.obterClasse());
		mensageiroDeEscolta.fireTestStarted(metodoDeTeste.obterDescricao());
		executarConfiguracaoDaClasseDeTeste(classeDeTeste, tratadorDeConfiguracao, invocadorParaClasseDeTeste);
		invocadorParaClasseDeTeste.executar(metodoDeTeste.obterMetodo(), tratadorDeTeste);
		mensageiroDeEscolta.fireTestFinished(metodoDeTeste.obterDescricao());
	}

	private void executarConfiguracaoDaClasseDeTeste(ClasseDeTeste classeDeTeste, TratadorDeInvocacao tratadorDeConfiguracao, InvocadorDeMetodo<?> invocadorParaClasseDeTeste) {
		for (ClasseDeTeste classeAcessorio : classeDeTeste.obterAcessorios()) {
			InvocadorDeMetodo<?> invocadorParaAcessorio = new InvocadorDeMetodo<>(classeAcessorio.obterClasse());
			executarConfiguracaoDaClasseDeTeste(classeAcessorio, tratadorDeConfiguracao, invocadorParaAcessorio);
			enxertarAcessorios(classeDeTeste, classeAcessorio, invocadorParaClasseDeTeste, invocadorParaAcessorio);
		}
		for (MetodoDeConfiguracao metodoDeConfiguracao : classeDeTeste.obterMetodosDeConfiguracao()) {
			invocadorParaClasseDeTeste.executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao);
		}
	}

	private void enxertarAcessorios(ClasseDeTeste classeDeTeste, ClasseDeTeste classeAcessorio, InvocadorDeMetodo<?> invocadorParaClasseDeTeste, InvocadorDeMetodo<?> invocadorParaAcessorio) {
		EnxertorDeAtributo enxertador = new EnxertorDeAtributo(invocadorParaAcessorio.obterInstancia(), invocadorParaClasseDeTeste.obterInstancia());
		for (AtributoProprio atributoProprio : classeAcessorio.obterAtributosProprios()) {
			enxertarAcessorio(classeDeTeste, enxertador, atributoProprio);
		}
		for (AtributoAcessorio atributoAcessorio : classeAcessorio.obterAtributosAcessorios()) {
			enxertarAcessorio(classeDeTeste, enxertador, atributoAcessorio);
		}
	}

	private void enxertarAcessorio(ClasseDeTeste classeDeTeste, EnxertorDeAtributo enxertador, Atributo atributoProprio) {
		for (AtributoAcessorio atributoAcessorio : classeDeTeste.obterAtributosAcessorios()) {
			if (atributoAcessorio.compativelCom(atributoProprio)) {
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
