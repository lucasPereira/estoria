package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class TresTestesPassandoIgnoradoFalhando {

	@Test
	public void testarPassando() {
		assertTrue(true);
	}

	@Ignore
	@Test
	public void testarIgnorado() {}

	@Test
	public void testarFalhando() {
		assertEquals(10, 20);
	}

}
