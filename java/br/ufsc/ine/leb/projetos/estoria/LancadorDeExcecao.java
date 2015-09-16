package br.ufsc.ine.leb.projetos.estoria;

public class LancadorDeExcecao {

	public void lancar(Throwable exception) {
		throw new ExcecaoChecadaQueNaoDeveriaSerLancada(exception);
	}

}
