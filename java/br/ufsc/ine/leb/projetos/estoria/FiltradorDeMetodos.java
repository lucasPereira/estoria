package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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

	public void removerMetodosAbstratos() {
		metodos.get(0).getAnnotation(null);
		metodos.get(0).getAnnotations();
		metodos.get(0).getAnnotationsByType(null);
		metodos.get(0).getDeclaredAnnotation(null);
		metodos.get(0).getDeclaredAnnotations();
		metodos.get(0).getDeclaredAnnotationsByType(null);
		metodos.get(0).getParameterAnnotations();
		metodos.removeIf(metodo -> metodo.getDeclaredAnnotation(null) != null || Modifier.isAbstract(metodo.getModifiers()));
	}

}
