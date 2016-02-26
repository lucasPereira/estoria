package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import org.junit.Test;

public class ClasseDeTeste109 {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		lancarExcecao();
	}

	private void lancarExcecao() {
		throw new RuntimeException();
	}

}
