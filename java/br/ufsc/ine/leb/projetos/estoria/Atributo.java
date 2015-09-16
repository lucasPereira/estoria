package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Field;

public abstract class Atributo {

	private Field atributo;

	public Atributo(Field atributo) {
		this.atributo = atributo;
	}

	public final String obterNome() {
		return atributo.getName();
	}

	public final Field obterAtributo() {
		return atributo;
	}

}
