package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

import org.junit.runner.Description;

public final class MetodoDeTeste extends Metodo {

	private ClasseDeTeste classeDeTeste;
	private Description descricao;

	public MetodoDeTeste(ClasseDeTeste classeDeTeste, Method metodo) {
		super(metodo);
		this.classeDeTeste = classeDeTeste;
		this.descricao = Description.createTestDescription(classeDeTeste.obterClasse(), obterNome());
	}

	public Description obterDescricao() {
		return descricao;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof MetodoDeTeste) {
			MetodoDeTeste outro = (MetodoDeTeste) objeto;
			Boolean mesmoNome = super.equals(outro);
			Boolean mesmaClasse = classeDeTeste.equals(outro.classeDeTeste);
			return mesmoNome && mesmaClasse;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
