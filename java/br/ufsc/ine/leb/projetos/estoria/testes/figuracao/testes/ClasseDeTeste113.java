package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseDeTeste113 {

	private int acessorio113Before10;
	private int acessorio113Before20Test30;
	private int acessorio113Test40;

	@Before
	public void configurar() {
		acessorio113Before10 = 10;
		acessorio113Before20Test30 = 20;
		assertEquals(10, acessorio113Before10);
		assertEquals(20, acessorio113Before20Test30);
		assertEquals(0, acessorio113Test40);
	}

	@Test
	public void testar() {
		acessorio113Before20Test30 = 30;
		acessorio113Test40 = 40;
		assertEquals(10, acessorio113Before10);
		assertEquals(30, acessorio113Before20Test30);
		assertEquals(40, acessorio113Test40);
		fail("113 falha induzida");
	}

}
