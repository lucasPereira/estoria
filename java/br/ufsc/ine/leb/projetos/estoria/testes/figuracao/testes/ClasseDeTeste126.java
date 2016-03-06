package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste115.class)
public class ClasseDeTeste126 {

	private int acessorio126Before10;
	private int acessorio126Before20Test30;
	private int acessorio126Test40;
	
	@Fixture private int acessorio115Before10;
	@Fixture private int acessorio115Before20Test30;
	@Fixture private int acessorio115Test40;

	@Before
	public void configurar() {
		acessorio126Before10 = 10;
		acessorio126Before20Test30 = 20;
		assertEquals(10, acessorio126Before10);
		assertEquals(20, acessorio126Before20Test30);
		assertEquals(0, acessorio126Test40);
		assertEquals(10, acessorio115Before10);
		assertEquals(20, acessorio115Before20Test30);
		assertEquals(0, acessorio115Test40);
		fail("126 falha configurada");
	}

	@Test
	public void testar() {
		acessorio126Before20Test30 = 30;
		acessorio126Test40 = 40;
		assertEquals(10, acessorio126Before10);
		assertEquals(30, acessorio126Before20Test30);
		assertEquals(40, acessorio126Test40);
		assertEquals(10, acessorio115Before10);
		assertEquals(20, acessorio115Before20Test30);
		assertEquals(0, acessorio115Test40);
		fail("126 falha induzida");
	}

}
