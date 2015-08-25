package br.ufsc.ine.leb.projetos.estoria.testes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class ExecutorDeTeste {

	private RunNotifier mensageiroDeEscolta;

	public ExecutorDeTeste(RunNotifier mensageiroDeEscolta) {
		this.mensageiroDeEscolta = mensageiroDeEscolta;
	}

	public void executar(Description descricaoDoTeste) {
		try {
			Class<?> classeDoCasoDeTeste = descricaoDoTeste.getTestClass();
			String casoDeTeste = descricaoDoTeste.getMethodName();
			Method metodoDeTeste = classeDoCasoDeTeste.getMethod(casoDeTeste);
			Object objetoDoCasoDeTeste = classeDoCasoDeTeste.newInstance();
			Test anotacaoTeste = metodoDeTeste.getDeclaredAnnotation(Test.class);
			Class<? extends Throwable> excecaoEsperada = anotacaoTeste.expected();
			mensageiroDeEscolta.fireTestStarted(descricaoDoTeste);
			executarMetodoDeTeste(descricaoDoTeste, metodoDeTeste, objetoDoCasoDeTeste, excecaoEsperada);
			mensageiroDeEscolta.fireTestFinished(descricaoDoTeste);
		} catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InstantiationException excecao) {
			excecao.printStackTrace();
		}
	}

	private void executarMetodoDeTeste(Description descricaoDoTeste, Method metodoDeTeste, Object objetoDoCasoDeTeste, Class<? extends Throwable> excecaoEsperada) throws IllegalAccessException, IllegalArgumentException {
		try {
			metodoDeTeste.invoke(objetoDoCasoDeTeste);
			terminarTesteSemExcecaoLancada(descricaoDoTeste, excecaoEsperada);
		} catch (InvocationTargetException excecao) {
			terminarTesteComExcecaoLancada(descricaoDoTeste, excecaoEsperada, excecao);
		}
	}

	private void terminarTesteSemExcecaoLancada(Description descricaoDoTeste, Class<? extends Throwable> excecaoEsperada) {
		Boolean esperavaExcecao = !excecaoEsperada.equals(Test.None.class);
		if (esperavaExcecao) {
			Throwable excecaoLancada = new AssertionError("Expected exception: " + excecaoEsperada.getName());
			Failure falha = new Failure(descricaoDoTeste, excecaoLancada);
			mensageiroDeEscolta.fireTestFailure(falha);
		}
	}

	private void terminarTesteComExcecaoLancada(Description descricaoDoTeste, Class<? extends Throwable> excecaoEsperada, InvocationTargetException excecao) {
		Throwable excecaoLancada = excecao.getCause();
		Boolean esperavaExcecao = !excecaoEsperada.equals(Test.None.class);
		Boolean excecaoLancadaEraEsperada = excecaoEsperada.isInstance(excecaoLancada);
		if ((esperavaExcecao && !excecaoLancadaEraEsperada) || !esperavaExcecao) {
			Failure falha = new Failure(descricaoDoTeste, excecaoLancada);
			mensageiroDeEscolta.fireTestFailure(falha);
		}
	}

}
