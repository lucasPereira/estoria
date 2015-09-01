package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste;

import org.junit.Test;

public class UmTesteFalhandoExcecaoEsperadaExcecaoLancada {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		throw new RuntimeException();
	}

}
