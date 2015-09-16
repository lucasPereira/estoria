package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Field;

public final class AtributoAcessorio extends Atributo {

	public AtributoAcessorio(Field atributo) {
		super(atributo);
	}

	public Boolean compativelCom(AtributoProprio atributoProprio) {
		Class<?> tipoDoDestipo = obterAtributo().getType();
		Class<?> tipoDaOrigem = atributoProprio.obterAtributo().getType();
		Boolean nomeCompativel = obterNome().equals(atributoProprio.obterNome());
		Boolean tipoCompativel = tipoDoDestipo.isAssignableFrom(tipoDaOrigem);
		return nomeCompativel && tipoCompativel;
	}

}
