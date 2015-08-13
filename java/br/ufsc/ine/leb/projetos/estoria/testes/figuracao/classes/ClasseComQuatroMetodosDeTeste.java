package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClasseComQuatroMetodosDeTeste {

	@Test
	public void testarVazio() {}

	@Test
	protected void testarPassando() {
		assertTrue(true);
	}

	@Test
	void testarFalhando() {
		fail();
	}

	@Test
	private void testarExcecao() {
		throw new RuntimeException();
	}

}
