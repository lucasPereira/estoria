package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Field;
import java.util.Comparator;

public class ComparadorDeAtributos implements Comparator<Field> {

	@Override
	public int compare(Field atributo1, Field atributo2) {
		return atributo1.getName().compareTo(atributo2.getName());
	}

}
