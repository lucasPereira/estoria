package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

public final class Metodo {

	private Method metodo;
	private RepositorioDeClassesDeTeste repositorio;

	public Metodo(Method metodo, RepositorioDeClassesDeTeste repositorio) {
		this.metodo = metodo;
		this.repositorio = repositorio;
	}

	public ClasseDeTeste obterClasseDeTeste() {
		return repositorio.construir(metodo.getDeclaringClass());
	}

	public Method obterMetodo() {
		return metodo;
	}

	public String obterNome() {
		return metodo.getName();
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

	@Override
	public String toString() {
		return metodo.getName();
	}

}
