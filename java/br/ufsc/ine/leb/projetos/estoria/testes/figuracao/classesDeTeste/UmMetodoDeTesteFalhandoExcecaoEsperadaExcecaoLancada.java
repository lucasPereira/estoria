package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste;

import org.junit.Test;

public class UmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		throw new RuntimeException();
	}

}
