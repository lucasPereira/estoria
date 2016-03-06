package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste112.class)
public class ClasseDeTeste121 {

	private int acessorio121Before10;
	private int acessorio121Before20Test30;
	private int acessorio121Test40;
	
	@Fixture private int acessorio112Before10;
	@Fixture private int acessorio112Before20Test30;
	@Fixture private int acessorio112Test40;

	@Before
	public void configurar() {
		acessorio121Before10 = 10;
		acessorio121Before20Test30 = 20;
		assertEquals(10, acessorio121Before10);
		assertEquals(20, acessorio121Before20Test30);
		assertEquals(0, acessorio121Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
		fail("121 falha configurada");
	}

	@Test
	public void testar() {
		acessorio121Before20Test30 = 30;
		acessorio121Test40 = 40;
		assertEquals(10, acessorio121Before10);
		assertEquals(30, acessorio121Before20Test30);
		assertEquals(40, acessorio121Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
	}

}
