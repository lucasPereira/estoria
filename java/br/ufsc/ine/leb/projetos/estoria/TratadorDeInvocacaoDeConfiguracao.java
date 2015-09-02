package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class TratadorDeInvocacaoDeConfiguracao implements TratadorDeInvocacao {

	private CasoDeTeste casoDeTeste;
	private RunNotifier mensageiroDeEscolta;

	public TratadorDeInvocacaoDeConfiguracao(CasoDeTeste casoDeTeste, RunNotifier mensageiroDeEscolta) {
		this.casoDeTeste = casoDeTeste;
		this.mensageiroDeEscolta = mensageiroDeEscolta;
	}

	@Override
	public void tratarInvocacaoSemExcecao(Method metodo) {}

	@Override
	public void tratarInvocacaoComExcecao(Method metodo, Throwable excecaoLancada) {
		Failure falha = new Failure(casoDeTeste.obterDescricao(), excecaoLancada);
		mensageiroDeEscolta.fireTestFailure(falha);
	}

}
