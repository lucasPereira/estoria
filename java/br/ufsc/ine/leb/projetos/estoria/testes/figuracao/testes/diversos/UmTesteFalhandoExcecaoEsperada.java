package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos;

import static org.junit.Assert.assertTrue;

import org.junit.*;

public class UmTesteFalhandoExcecaoEsperada {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		assertTrue(true);
	}

}
