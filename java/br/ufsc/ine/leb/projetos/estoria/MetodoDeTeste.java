package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

import org.junit.runner.Description;

public final class MetodoDeTeste extends Metodo {

	private Description descricao;

	public MetodoDeTeste(ClasseDeTeste classeDeTeste, Method metodo) {
		super(metodo);
		this.descricao = Description.createTestDescription(classeDeTeste.obterClasse(), obterNome());
	}

	public Description obterDescricao() {
		return descricao;
	}

}
