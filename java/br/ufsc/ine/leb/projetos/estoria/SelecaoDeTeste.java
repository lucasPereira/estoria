package br.ufsc.ine.leb.projetos.estoria;

public final class SelecaoDeTeste {

	private Class<?> classe;
	private String metodoDeTeste;

	public SelecaoDeTeste(Class<?> classe, String metodoDeTeste) {
		this.classe = classe;
		this.metodoDeTeste = metodoDeTeste;
	}

	public Class<?> obterClasse() {
		return classe;
	}

	public String obterMetodoDeTeste() {
		return metodoDeTeste;
	}

}
