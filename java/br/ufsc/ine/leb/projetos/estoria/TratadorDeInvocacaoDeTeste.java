package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public final class TratadorDeInvocacaoDeTeste implements TratadorDeInvocacao {

	private Description descricao;
	private RunNotifier mensageiroDeEscolta;

	public TratadorDeInvocacaoDeTeste(Description descricao, RunNotifier mensageiroDeEscolta) {
		this.descricao = descricao;
		this.mensageiroDeEscolta = mensageiroDeEscolta;
	}

	@Override
	public void tratarInvocacaoSemExcecao(Method metodo) {
		Class<?> excecaoEsperada = obterExcecaoEsperada(metodo);
		Boolean esperavaUmaExcecao = esperavaUmaExcecao(excecaoEsperada);
		if (esperavaUmaExcecao) {
			Failure falha = criarFalhaDeExcecaoEsperadaMasNaoLancadaNenhuma(excecaoEsperada);
			mensageiroDeEscolta.fireTestFailure(falha);
		}
	}

	@Override
	public void tratarInvocacaoComExcecao(Method metodo, Throwable excecaoLancada) {
		Class<?> excecaoEsperada = obterExcecaoEsperada(metodo);
		Boolean esperavaUmaExcecao = esperavaUmaExcecao(excecaoEsperada);
		Boolean excecaoEsperadaFoiLancada = excecaoEsperadaFoiLancada(excecaoEsperada, excecaoLancada);
		if (esperavaUmaExcecao && !excecaoEsperadaFoiLancada) {
			Failure falha = criarFalhaDeExcecaoEsperadaMasLancadaOutra(excecaoLancada, excecaoEsperada);
			mensageiroDeEscolta.fireTestFailure(falha);
		} else if (!esperavaUmaExcecao) {
			Failure falha = criarFalhaDeExcecaoNaoEsperadaMasLancada(excecaoLancada);
			mensageiroDeEscolta.fireTestFailure(falha);
		}
	}

	private Class<?> obterExcecaoEsperada(Method metodo) {
		return metodo.getDeclaredAnnotation(Test.class).expected();
	}

	private Boolean excecaoEsperadaFoiLancada(Class<?> excecaoEsperada, Throwable excecaoLancada) {
		return excecaoEsperada.isInstance(excecaoLancada);
	}

	private Boolean esperavaUmaExcecao(Class<?> excecaoEsperada) {
		return !excecaoEsperada.equals(Test.None.class);
	}

	private Failure criarFalhaDeExcecaoNaoEsperadaMasLancada(Throwable excecaoLancada) {
		Failure falha = new Failure(descricao, excecaoLancada);
		return falha;
	}

	private Failure criarFalhaDeExcecaoEsperadaMasNaoLancadaNenhuma(Class<?> excecaoEsperada) {
		String mensagemDeFalha = String.format("expected exception:<%s>", excecaoEsperada.getName());
		Throwable excecaoLancada = new AssertionError(mensagemDeFalha);
		Failure falha = new Failure(descricao, excecaoLancada);
		return falha;
	}

	private Failure criarFalhaDeExcecaoEsperadaMasLancadaOutra(Throwable excecaoLancada, Class<?> excecaoEsperada) {
		String mesagemDeFalha = String.format("unexpected exception, expected:<%s> but was:<%s>", excecaoEsperada.getName(), excecaoLancada.getClass().getName());
		Throwable excecaoPaiLancada = new AssertionError(mesagemDeFalha, excecaoLancada);
		Failure falha = new Failure(descricao, excecaoPaiLancada);
		return falha;
	}

}
