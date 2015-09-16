package br.ufsc.ine.leb.projetos.estoria;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class FiltradorDeMetodos {

	private List<Method> metodos;

	public FiltradorDeMetodos(Class<?> classe) {
		this(Arrays.asList(classe.getDeclaredMethods()));
	}

	private FiltradorDeMetodos(List<Method> metodos) {
		this.metodos = new LinkedList<Method>(metodos);
		ComparadorDeMetodos comparador = new ComparadorDeMetodos();
		Collections.sort(this.metodos, comparador);
	}

	public FiltradorDeMetodos clonar() {
		return new FiltradorDeMetodos(metodos);
	}

	public List<Method> obterMetodos() {
		return metodos;
	}

	public FiltradorDeMetodos removerMetodosAbstratos() {
		metodos.removeIf(metodo -> Modifier.isAbstract(metodo.getModifiers()));
		return this;
	}

	public FiltradorDeMetodos removerMetodosEstaticos() {
		metodos.removeIf(metodo -> Modifier.isStatic(metodo.getModifiers()));
		return this;
	}

	public FiltradorDeMetodos removerMetodosNativos() {
		metodos.removeIf(metodo -> Modifier.isNative(metodo.getModifiers()));
		return this;
	}

	public FiltradorDeMetodos removerMetodosSincronizados() {
		metodos.removeIf(metodo -> Modifier.isSynchronized(metodo.getModifiers()));
		return this;
	}

	public FiltradorDeMetodos removerMetodosPrivados() {
		metodos.removeIf(metodo -> Modifier.isPrivate(metodo.getModifiers()));
		return this;
	}

	public FiltradorDeMetodos removerMetodosProtegidos() {
		metodos.removeIf(metodo -> Modifier.isProtected(metodo.getModifiers()));
		return this;
	}

	public FiltradorDeMetodos removerMetodosDefault() {
		metodos.removeIf(metodo -> !(Modifier.isPublic(metodo.getModifiers()) || Modifier.isProtected(metodo.getModifiers()) || Modifier.isPrivate(metodo.getModifiers())));
		return this;
	}

	public FiltradorDeMetodos removerMetodosComRetorno() {
		metodos.removeIf(metodo -> !metodo.getReturnType().equals(Void.TYPE));
		return this;
	}

	public FiltradorDeMetodos removerMetodosGenericos() {
		metodos.removeIf(metodo -> metodo.getTypeParameters().length > 0);
		return this;
	}

	public FiltradorDeMetodos removerMetodosParametrizados() {
		metodos.removeIf(metodo -> metodo.getParameterCount() > 0);
		return this;
	}

	public FiltradorDeMetodos removerMetodosNaoAnotadosCom(Class<? extends Annotation> classe) {
		metodos.removeIf(metodo -> metodo.getDeclaredAnnotationsByType(classe).length == 0);
		return this;
	}

	public FiltradorDeMetodos removerMetodosAnotadosCom(Class<? extends Annotation> classe) {
		metodos.removeIf(metodo -> metodo.getDeclaredAnnotationsByType(classe).length > 0);
		return this;
	}

}
