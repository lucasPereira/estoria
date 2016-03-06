package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ ClasseDeTeste112.class, ClasseDeTeste117.class })
public class ClasseDeTeste127 {

	private int acessorio127Before10;
	private int acessorio127Before20Test30;
	private int acessorio127Test40;

	@Fixture private int numero;
	@Fixture private int acessorio112Before10;
	@Fixture private int acessorio112Before20Test30;
	@Fixture private int acessorio112Test40;

	@Before
	public void configurar() {
		acessorio127Before10 = 10;
		acessorio127Before20Test30 = 20;
		assertEquals(10, acessorio127Before10);
		assertEquals(20, acessorio127Before20Test30);
		assertEquals(0, acessorio127Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
		assertEquals(60, numero);
	}

	@Test
	public void testar() {
		acessorio127Before20Test30 = 30;
		acessorio127Test40 = 40;
		assertEquals(10, acessorio127Before10);
		assertEquals(30, acessorio127Before20Test30);
		assertEquals(40, acessorio127Test40);
		assertEquals(10, acessorio112Before10);
		assertEquals(20, acessorio112Before20Test30);
		assertEquals(0, acessorio112Test40);
		assertEquals(60, numero);
	}

}
