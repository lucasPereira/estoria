package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste112.class)
public class ClasseDeTeste121 {

	private int meuAcessorioBefore10;
	private int meuAcessorioBefore20Test30;
	private int meuAcessorioTest40;
	
	@Fixture private int acessorioBefore10;
	@Fixture private int acessorioBefore20Test30;
	@Fixture private int acessorioTest40;

	@Before
	public void configurar() {
		meuAcessorioBefore10 = 10;
		meuAcessorioBefore20Test30 = 20;
		assertEquals(10, meuAcessorioBefore10);
		assertEquals(20, meuAcessorioBefore20Test30);
		assertEquals(0, meuAcessorioTest40);
		assertEquals(10, acessorioBefore10);
		assertEquals(20, acessorioBefore20Test30);
		assertEquals(0, acessorioTest40);
		fail("121 falha configurada");
	}

	@Test
	public void testar() {
		meuAcessorioBefore20Test30 = 30;
		meuAcessorioTest40 = 40;
		assertEquals(10, meuAcessorioBefore10);
		assertEquals(30, meuAcessorioBefore20Test30);
		assertEquals(40, meuAcessorioTest40);
		assertEquals(10, acessorioBefore10);
		assertEquals(20, acessorioBefore20Test30);
		assertEquals(0, acessorioTest40);
	}

}
