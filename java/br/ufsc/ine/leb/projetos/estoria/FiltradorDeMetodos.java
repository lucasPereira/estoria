package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class FiltradorDeMetodos {

	private List<Method> metodos;

	public FiltradorDeMetodos(Class<?> classe) {
		metodos = new LinkedList<>();
		for (Method metodo : classe.getDeclaredMethods()) {
			metodos.add(metodo);
		}
	}

	public List<Method> obterMetodos() {
		ComparadorDeMetodos comparador = new ComparadorDeMetodos();
		Collections.sort(metodos, comparador);
		return metodos;
	}

}
