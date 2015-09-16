package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class InvocadorDeMetodo<T> {

	private Class<T> classe;
	private T instancia;

	public InvocadorDeMetodo(Class<T> classe) {
		this.classe = classe;
		this.instancia = null;
	}

	public void executar(Method metodo, TratadorDeInvocacao tratador) {
		try {
			T objeto = criarInstancia();
			invocar(metodo, objeto, tratador);
		} catch (IllegalAccessException | IllegalArgumentException | SecurityException | InstantiationException excecao) {
			new LancadorDeExcecao().lancar(excecao);
		}
	}

	private void invocar(Method metodo, T objeto, TratadorDeInvocacao tratador) throws IllegalAccessException {
		try {
			metodo.invoke(objeto);
			tratador.tratarInvocacaoSemExcecao(metodo);
		} catch (InvocationTargetException excecao) {
			tratador.tratarInvocacaoComExcecao(metodo, excecao.getCause());
		}
	}

	private T criarInstancia() throws InstantiationException, IllegalAccessException {
		return (instancia == null) ? instancia = classe.newInstance() : instancia;
	}

	public T obterInstancia() {
		return instancia;
	}

}
