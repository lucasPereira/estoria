package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class InvocadorDeMetodo<T> {

	private Class<T> classe;
	private T instancia;

	public InvocadorDeMetodo(Class<T> classe) {
		this.classe = classe;
		criarInstancia();
	}

	public void executar(Method metodo, TratadorDeInvocacao tratador) {
		try {
			invocar(metodo, instancia, tratador);
		} catch (IllegalAccessException excecao) {
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

	private void criarInstancia() {
		try {
			instancia = (instancia == null) ? classe.newInstance() : instancia;
		} catch (InstantiationException | IllegalAccessException excecao) {
			new LancadorDeExcecao().lancar(excecao);
		}
	}

	public T obterInstancia() {
		return instancia;
	}

}
