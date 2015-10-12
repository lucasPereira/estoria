package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

public abstract class Metodo {

	private Method metodo;

	public Metodo(Method metodo) {
		this.metodo = metodo;
	}

	public final String obterNome() {
		return metodo.getName();
	}

	public final Method obterMetodo() {
		return metodo;
	}

	@Override
	public String toString() {
		return obterNome();
	}

}
