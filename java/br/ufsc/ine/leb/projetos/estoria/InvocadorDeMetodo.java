package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class InvocadorDeMetodo {

	private Class<?> classe;
	private Object instancia;

	public InvocadorDeMetodo(Class<?> classe) {
		this.classe = classe;
		this.instancia = null;
	}

	public void executar(Method metodo, TratadorDeInvocacao tratador) {
		try {
			Object objeto = obterInstancia();
			invocar(metodo, objeto, tratador);
		} catch (IllegalAccessException | IllegalArgumentException | SecurityException | InstantiationException excecao) {
			excecao.printStackTrace();
		}
	}

	private void invocar(Method metodo, Object objeto, TratadorDeInvocacao tratador) throws IllegalAccessException {
		try {
			metodo.invoke(objeto);
			tratador.tratarInvocacaoSemExcecao(metodo);
		} catch (InvocationTargetException excecao) {
			tratador.tratarInvocacaoComExcecao(metodo, excecao.getCause());
		}
	}

	private Object obterInstancia() throws InstantiationException, IllegalAccessException {
		return (instancia == null) ? instancia = classe.newInstance() : instancia;
	}

}
