package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ClasseDeTeste116 {

	private int numero;

	@Before
	public void configurar() {
		numero = 10;
	}

	@Test
	public void testar1() {
		assertEquals(10, numero);
		numero = 20;
	}

	@Test
	public void testar2() {
		assertEquals(10, numero);
		numero = 20;
		fail("116 falha induzida");
	}

	@Ignore
	@Test
	public void testar3() {
		assertEquals(10, numero);
		numero = 20;
		fail("116 falha ignorada");
	}

}
