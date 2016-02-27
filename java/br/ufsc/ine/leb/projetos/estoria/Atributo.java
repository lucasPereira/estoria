package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Field;

public final class Atributo {

	private Field atributo;
	private RepositorioDeClassesDeTeste repositorio;

	public Atributo(Field atributo, RepositorioDeClassesDeTeste repositorio) {
		this.atributo = atributo;
		this.repositorio = repositorio;
	}

	public ClasseDeTeste obterClasseDeTeste() {
		return repositorio.construir(atributo.getDeclaringClass());
	}

	public Field obterAtributo() {
		return atributo;
	}

	public String obterNome() {
		return atributo.getName();
	}

	public Boolean compativelCom(Atributo atributo) {
		Class<?> tipoDoDestipo = obterAtributo().getType();
		Class<?> tipoDaOrigem = atributo.obterAtributo().getType();
		Boolean nomeCompativel = obterNome().equals(atributo.obterNome());
		Boolean tipoCompativel = tipoDoDestipo.isAssignableFrom(tipoDaOrigem);
		return nomeCompativel && tipoCompativel;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Atributo) {
			Atributo outro = (Atributo) objeto;
			return atributo.equals(outro.atributo);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return atributo.hashCode();
	}

	@Override
	public String toString() {
		return atributo.getName();
	}

}
