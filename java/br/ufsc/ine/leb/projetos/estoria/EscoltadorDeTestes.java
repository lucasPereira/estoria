package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestes extends Runner {

	private SuiteDeTeste suiteDeTeste;
	private Description descricaoDaSuite;

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
		Result resultado = new Result();
		mensageiroDeEscolta.addListener(resultado.createListener());
		mensageiroDeEscolta.fireTestRunStarted(descricaoDaSuite);
		rodarTestesIgnorados(mensageiroDeEscolta);
		rodarTestes(mensageiroDeEscolta);
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

	private void rodarTestes(RunNotifier mensageiroDeEscolta) {
		for (ClasseDeTeste classeDeTeste : suiteDeTeste.obterClassesDeTeste()) {
			for (MetodoDeTeste metodoDeTeste : classeDeTeste.obterMetodosDeTeste()) {
				TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
				TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
				InvocadorDeMetodo invocadorParaClasseDeTeste = new InvocadorDeMetodo(classeDeTeste.obterClasse());
				mensageiroDeEscolta.fireTestStarted(metodoDeTeste.obterDescricao());
				for (ClasseDeTeste acessorio : classeDeTeste.obterAcessorios()) {
					InvocadorDeMetodo invocadorParaAcessorio = new InvocadorDeMetodo(acessorio.obterClasse());
					for (MetodoDeConfiguracao metodoDeConfiguracao : acessorio.obterMetodosDeConfiguracao()) {
						invocadorParaAcessorio.executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao);
					}
				}
				for (MetodoDeConfiguracao metodoDeConfiguracao : classeDeTeste.obterMetodosDeConfiguracao()) {
					invocadorParaClasseDeTeste.executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao);
				}
				invocadorParaClasseDeTeste.executar(metodoDeTeste.obterMetodo(), tratadorDeTeste);
				mensageiroDeEscolta.fireTestFinished(metodoDeTeste.obterDescricao());
			}
		}
	}

	private void rodarTestesIgnorados(RunNotifier mensageiroDeEscolta) {
		for (ClasseDeTeste classeDeteste : suiteDeTeste.obterClassesDeTeste()) {
			for (MetodoDeTeste metodoDeTeste : classeDeteste.obterMetodosDeTesteIgnorados()) {
				mensageiroDeEscolta.fireTestIgnored(metodoDeTeste.obterDescricao());
			}
		}
	}

}
