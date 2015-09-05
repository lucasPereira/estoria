package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

import org.junit.runner.Description;

public final class MetodoDeTeste {

	private Method metodo;
	private Description descricao;

	public MetodoDeTeste(ClasseDeTeste classeDeTeste, Method metodo) {
		this.metodo = metodo;
		this.descricao = Description.createTestDescription(classeDeTeste.obterClasse(), obterNome());
	}

	public String obterNome() {
		return metodo.getName();
	}

	public Method obterMetodo() {
		return metodo;
	}

	public Description obterDescricao() {
		return descricao;
	}

}
