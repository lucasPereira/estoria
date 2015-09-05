package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

public final class MetodoDeTeste {

	private Method metodo;

	public MetodoDeTeste(Method metodo) {
		this.metodo = metodo;
	}

	public String obterNome() {
		return metodo.getName();
	}

	public Method obterMetodo() {
		return metodo;
	}

}
