package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseDeTeste112 {

	private int acessorio112Before10;
	private int acessorio112Before20Test30;
	private int acessorio112Test40;

	@Before
	public void configurar() {
		acessorio112Before10 = 10;
		acessorio112Before20Test30 = 20;
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
	}

	@Test
	public void testar() {
		acessorio112Before20Test30 = 30;
		acessorio112Test40 = 40;
		assertEquals(10, acessorio112Before10);
		assertEquals(30, acessorio112Before20Test30);
		assertEquals(40, acessorio112Test40);
	}

}
