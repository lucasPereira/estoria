package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;
import java.util.Comparator;

public final class ComparadorDeMetodos implements Comparator<Method> {

	@Override
	public int compare(Method metodo1, Method metodo2) {
		return metodo1.getName().compareTo(metodo2.getName());
	}

}
