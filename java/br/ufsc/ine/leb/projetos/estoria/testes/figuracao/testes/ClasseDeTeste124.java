package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste115.class)
public class ClasseDeTeste124 {

	private int acessorio124Before10;
	private int acessorio124Before20Test30;
	private int acessorio124Test40;
	
	@Fixture private int acessorio115Before10;
	@Fixture private int acessorio115Before20Test30;
	@Fixture private int acessorio115Test40;

	@Before
	public void configurar() {
		acessorio124Before10 = 10;
		acessorio124Before20Test30 = 20;
		assertEquals(10, acessorio124Before10);
		assertEquals(20, acessorio124Before20Test30);
		assertEquals(0, acessorio124Test40);
		assertEquals(10, acessorio115Before10);
		assertEquals(20, acessorio115Before20Test30);
		assertEquals(0, acessorio115Test40);
	}

	@Test
	public void testar() {
		acessorio124Before20Test30 = 30;
		acessorio124Test40 = 40;
		assertEquals(10, acessorio124Before10);
		assertEquals(30, acessorio124Before20Test30);
		assertEquals(40, acessorio124Test40);
		assertEquals(10, acessorio115Before10);
		assertEquals(20, acessorio115Before20Test30);
		assertEquals(0, acessorio115Test40);
		fail("124 falha induzida");
	}

}
