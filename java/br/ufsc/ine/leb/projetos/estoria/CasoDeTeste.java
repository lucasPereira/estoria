package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;

public final class CasoDeTeste {

	private Class<?> classe;
	private String metodoDeTeste;
	private String metodoDeConfiguracao;
	private Description descricao;

	public CasoDeTeste(Class<?> classe, String metodoDeTeste, String metodoDeConfiguracao) {
		this.classe = classe;
		this.metodoDeTeste = metodoDeTeste;
		this.metodoDeConfiguracao = metodoDeConfiguracao;
		descricao = Description.createTestDescription(classe, metodoDeTeste);
	}

	public Class<?> obterClasse() {
		return classe;
	}

	public String obterMetodoDeTeste() {
		return metodoDeTeste;
	}

	public String obterMetodoDeConfiguracao() {
		return metodoDeConfiguracao;
	}

	public Description obterDescricao() {
		return descricao;
	}

}
