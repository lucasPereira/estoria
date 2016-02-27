package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste137.class)
public class ClasseDeTeste138 {

	private int meuIndiretoAcessorioBefore10;
	private int meuIndiretoAcessorioBefore20Test30;
	private int meuIndiretoAcessorioTest40;

	@Fixture private int meuAcessorioBefore10;
	@Fixture private int meuAcessorioBefore20Test30;
	@Fixture private int meuAcessorioTest40;

	@Fixture private int acessorioBefore10;
	@Fixture private int acessorioBefore20Test30;
	@Fixture private int acessorioTest40;

	@Before
	public void configurar() {
		meuIndiretoAcessorioBefore10 = 10;
		meuIndiretoAcessorioBefore20Test30 = 20;
		assertEquals(10, meuIndiretoAcessorioBefore10);
		assertEquals(20, meuIndiretoAcessorioBefore20Test30);
		assertEquals(0, meuIndiretoAcessorioTest40);
		assertEquals(10, meuAcessorioBefore10);
		assertEquals(20, meuAcessorioBefore20Test30);
		assertEquals(0, meuAcessorioTest40);
		assertEquals(10, acessorioBefore10);
		assertEquals(30, acessorioBefore20Test30);
		assertEquals(40, acessorioTest40);
	}

	@Test
	public void testar() {
		meuIndiretoAcessorioBefore20Test30 = 30;
		meuIndiretoAcessorioTest40 = 40;
		assertEquals(10, meuIndiretoAcessorioBefore10);
		assertEquals(30, meuIndiretoAcessorioBefore20Test30);
		assertEquals(40, meuIndiretoAcessorioTest40);
		assertEquals(10, meuAcessorioBefore10);
		assertEquals(20, meuAcessorioBefore20Test30);
		assertEquals(0, meuAcessorioTest40);
		assertEquals(10, acessorioBefore10);
		assertEquals(30, acessorioBefore20Test30);
		assertEquals(40, acessorioTest40);
	}

}
