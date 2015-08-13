package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class SeletorDeTestes {

	private List<SelecaoDeTeste> selecoes;
	
	
	public SeletorDeTestes() {
		selecoes = new LinkedList<>();
	}
	
	public void adicionarClasse(Class<?> classe) {
		Method[] metodos = classe.getDeclaredMethods();
		for (Method metodo : metodos) {
			selecoes.add(new SelecaoDeTeste(classe, metodo.getName()));
		}
	}

	public List<SelecaoDeTeste> obterSelecoes() {
		return selecoes;
	}

}
