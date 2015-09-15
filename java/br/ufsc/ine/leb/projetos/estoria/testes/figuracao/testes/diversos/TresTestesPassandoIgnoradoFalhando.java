package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.*;

public class TresTestesPassandoIgnoradoFalhando {

	@Test
	public void testarPassando() {
		assertTrue(true);
	}

	@Ignore
	@Test
	public void testarIgnorado() {
		fail("falha ignorada");
	}

	@Test
	public void testarFalhando() {
		fail("falha induzida");
	}

}
