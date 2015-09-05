package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

public final class MetodoDeConfiguracao {

	private Method metodo;

	public MetodoDeConfiguracao(Method metodo) {
		this.metodo = metodo;
	}

	public String obterNome() {
		return metodo.getName();
	}

	public Method obterMetodo() {
		return metodo;
	}

}
