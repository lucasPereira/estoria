package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RepositorioDeClassesDeTeste {

	private Map<Class<?>, ClasseDeTeste> classesDeTeste;
	private Map<Method, Metodo> metodosDeTeste;

	public RepositorioDeClassesDeTeste() {
		classesDeTeste = new HashMap<>();
		metodosDeTeste = new HashMap<>();
	}

	public ClasseDeTeste construir(Class<?> classe) {
		if (!classesDeTeste.containsKey(classe)) {
			ClasseDeTeste classeDeTeste = new ClasseDeTeste(classe, this);
			classesDeTeste.put(classe, classeDeTeste);
		}
		return classesDeTeste.get(classe);
	}

	public Metodo construir(Method metodo) {
		if (!metodosDeTeste.containsKey(metodo)) {
			Metodo metodoDeTeste = new Metodo(metodo, this);
			metodosDeTeste.put(metodo, metodoDeTeste);
		}
		return metodosDeTeste.get(metodo);
	}

}
