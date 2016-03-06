package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste112.class)
public class ClasseDeTeste119 {

	private int acessorio119Before10;
	private int acessorio119Before20Test30;
	private int acessorio119Test40;
	
	@Fixture private int acessorio112Before10;
	@Fixture private int acessorio112Before20Test30;
	@Fixture private int acessorio112Test40;

	@Before
	public void configurar() {
		acessorio119Before10 = 10;
		acessorio119Before20Test30 = 20;
		assertEquals(10, acessorio119Before10);
		assertEquals(20, acessorio119Before20Test30);
		assertEquals(0, acessorio119Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
	}

	@Test
	public void testar() {
		acessorio119Before20Test30 = 30;
		acessorio119Test40 = 40;
		assertEquals(10, acessorio119Before10);
		assertEquals(30, acessorio119Before20Test30);
		assertEquals(40, acessorio119Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
	}

}
