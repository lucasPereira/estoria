package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste;

import static org.junit.Assert.*;

import org.junit.Test;

public class UmMetodoDeTesteFalhandoExcecaoEsperada {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		assertTrue(true);
	}

}
