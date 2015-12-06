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

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Metodo) {
			Metodo outro = (Metodo) objeto;
			return metodo.equals(outro.metodo);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return metodo.hashCode();
	}

}
