package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseDeTeste114 {

	private int acessorio114Before10;
	private int acessorio114Before20Test30;
	private int acessorio114Test40;
	
	@Before
	public void configurar() {
		acessorio114Before10 = 10;
		acessorio114Before20Test30 = 20;
		assertEquals(10, acessorio114Before10);
		assertEquals(20, acessorio114Before20Test30);
		assertEquals(0, acessorio114Test40);
		fail("114 falha configurada");
	}

	@Test
	public void testar() {
		acessorio114Before20Test30 = 30;
		acessorio114Test40 = 40;
		assertEquals(10, acessorio114Before10);
		assertEquals(30, acessorio114Before20Test30);
		assertEquals(40, acessorio114Test40);
	}

}
