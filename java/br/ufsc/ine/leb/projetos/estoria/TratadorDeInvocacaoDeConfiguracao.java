package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public final class TratadorDeInvocacaoDeConfiguracao implements TratadorDeInvocacao {

	private Description descricao;
	private RunNotifier mensageiroDeEscolta;

	public TratadorDeInvocacaoDeConfiguracao(Description descricao, RunNotifier mensageiroDeEscolta) {
		this.descricao = descricao;
		this.mensageiroDeEscolta = mensageiroDeEscolta;
	}

	@Override
	public void tratarInvocacaoSemExcecao(Method metodo) {}

	@Override
	public void tratarInvocacaoComExcecao(Method metodo, Throwable excecaoLancada) {
		Failure falha = new Failure(descricao, excecaoLancada);
		mensageiroDeEscolta.fireTestFailure(falha);
	}

}
