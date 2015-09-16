package br.ufsc.ine.leb.projetos.estoria;

public class ExcecaoChecadaQueNaoDeveriaSerLancada extends RuntimeException {

	private static final long serialVersionUID = -2505352841948067876L;

	public ExcecaoChecadaQueNaoDeveriaSerLancada(Throwable excecao) {
		super(excecao);
	}

}
