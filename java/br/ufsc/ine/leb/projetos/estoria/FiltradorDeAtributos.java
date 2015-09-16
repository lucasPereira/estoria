package br.ufsc.ine.leb.projetos.estoria;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FiltradorDeAtributos {

	private List<Field> atributos;

	public FiltradorDeAtributos(Class<?> classe) {
		this(Arrays.asList(classe.getDeclaredFields()));
	}

	public FiltradorDeAtributos(List<Field> atributos) {
		this.atributos = new LinkedList<>(atributos);
		ComparadorDeAtributos comparador = new ComparadorDeAtributos();
		Collections.sort(this.atributos, comparador);
	}

	public FiltradorDeAtributos clonar() {
		return new FiltradorDeAtributos(atributos);
	}

	public List<Field> obterAtributos() {
		return atributos;
	}

	public FiltradorDeAtributos removerAtributosAnotadosCom(Class<? extends Annotation> anotacao) {
		atributos.removeIf(atributo -> atributo.getDeclaredAnnotation(anotacao) != null);
		return this;
	}

	public FiltradorDeAtributos removerAtributosNaoAnotadosCom(Class<? extends Annotation> anotacao) {
		atributos.removeIf(atributo -> atributo.getDeclaredAnnotation(anotacao) == null);
		return this;
	}

}
