package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste;

import static org.junit.Assert.*;

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
