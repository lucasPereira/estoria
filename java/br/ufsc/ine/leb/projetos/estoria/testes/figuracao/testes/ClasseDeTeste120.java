package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste112.class)
public class ClasseDeTeste120 {

	private int acessorio120Before10;
	private int acessorio120Before20Test30;
	private int acessorio120Test40;
	
	@Fixture private int acessorio112Before10;
	@Fixture private int acessorio112Before20Test30;
	@Fixture private int acessorio112Test40;

	@Before
	public void configurar() {
		acessorio120Before10 = 10;
		acessorio120Before20Test30 = 20;
		assertEquals(10, acessorio120Before10);
		assertEquals(20, acessorio120Before20Test30);
		assertEquals(0, acessorio120Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
	}

	@Test
	public void testar() {
		acessorio120Before20Test30 = 30;
		acessorio120Test40 = 40;
		assertEquals(10, acessorio120Before10);
		assertEquals(30, acessorio120Before20Test30);
		assertEquals(40, acessorio120Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
		fail("120 falha induzida");
	}

}
