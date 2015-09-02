package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.notification.RunNotifier;

public class ExecutorDeTeste {

	private RunNotifier mensageiroDeEscolta;

	public ExecutorDeTeste(RunNotifier mensageiroDeEscolta) {
		this.mensageiroDeEscolta = mensageiroDeEscolta;
	}

	public void executar(CasoDeTeste casoDeTeste) {
		TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(casoDeTeste, mensageiroDeEscolta);
		TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(casoDeTeste, mensageiroDeEscolta);
		InvocadorDeMetodo invocadorParaClasse = new InvocadorDeMetodo(casoDeTeste.obterClasse());
		mensageiroDeEscolta.fireTestStarted(casoDeTeste.obterDescricao());
		if (casoDeTeste.obterMetodoDeConfiguracao() != null) {
			invocadorParaClasse.executar(casoDeTeste.obterMetodoDeConfiguracao(), tratadorDeConfiguracao);
		}
		invocadorParaClasse.executar(casoDeTeste.obterMetodoDeTeste(), tratadorDeTeste);
		mensageiroDeEscolta.fireTestFinished(casoDeTeste.obterDescricao());
	}

}
