package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseDeTeste115 {

	private int acessorio115Before10;
	private int acessorio115Before20Test30;
	private int acessorio115Test40;

	@Before
	public void configurar() {
		acessorio115Before10 = 10;
		acessorio115Before20Test30 = 20;
		assertEquals(10, acessorio115Before10);
		assertEquals(20, acessorio115Before20Test30);
		assertEquals(0, acessorio115Test40);
		fail("115 falha configurada");
	}

	@Test
	public void testar() {
		acessorio115Before20Test30 = 30;
		acessorio115Test40 = 40;
		assertEquals(10, acessorio115Before10);
		assertEquals(30, acessorio115Before20Test30);
		assertEquals(40, acessorio115Test40);
		fail("115 falha induzida");
	}

}
