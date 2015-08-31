package br.ufsc.ine.leb.projetos.estoria;

import java.lang.annotation.Annotation;
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

	private FiltradorDeMetodos(List<Method> metodos) {
		this.metodos = new LinkedList<Method>(metodos);
	}

	public List<Method> obterMetodos() {
		ComparadorDeMetodos comparador = new ComparadorDeMetodos();
		Collections.sort(metodos, comparador);
		return metodos;
	}

	public void removerMetodosAbstratos() {
		metodos.removeIf(metodo -> Modifier.isAbstract(metodo.getModifiers()));
	}

	public void removerMetodosEstaticos() {
		metodos.removeIf(metodo -> Modifier.isStatic(metodo.getModifiers()));
	}

	public void removerMetodosNativos() {
		metodos.removeIf(metodo -> Modifier.isNative(metodo.getModifiers()));
	}

	public void removerMetodosSincronizados() {
		metodos.removeIf(metodo -> Modifier.isSynchronized(metodo.getModifiers()));
	}

	public void removerMetodosPrivados() {
		metodos.removeIf(metodo -> Modifier.isPrivate(metodo.getModifiers()));
	}

	public void removerMetodosProtegidos() {
		metodos.removeIf(metodo -> Modifier.isProtected(metodo.getModifiers()));
	}

	public void removerMetodosDefault() {
		metodos.removeIf(metodo -> !(Modifier.isPublic(metodo.getModifiers()) || Modifier.isProtected(metodo.getModifiers()) || Modifier.isPrivate(metodo.getModifiers())));
	}

	public void removerMetodosComRetorno() {
		metodos.removeIf(metodo -> !metodo.getReturnType().equals(Void.TYPE));
	}

	public void removerMetodosGenericos() {
		metodos.removeIf(metodo -> metodo.getTypeParameters().length > 0);
	}

	public void removerMetodosParametrizados() {
		metodos.removeIf(metodo -> metodo.getParameterCount() > 0);
	}

	public void removerMetodosNaoAnotadosCom(Class<? extends Annotation> classe) {
		metodos.removeIf(metodo -> metodo.getDeclaredAnnotationsByType(classe).length == 0);
	}

	public void removerMetodosAnotadosCom(Class<? extends Annotation> classe) {
		metodos.removeIf(metodo -> metodo.getDeclaredAnnotationsByType(classe).length > 0);
	}

	public FiltradorDeMetodos clonar() {
		return new FiltradorDeMetodos(metodos);
	}

}
