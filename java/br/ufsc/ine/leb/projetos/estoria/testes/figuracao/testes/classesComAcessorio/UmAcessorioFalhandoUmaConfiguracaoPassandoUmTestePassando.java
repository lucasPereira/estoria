package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;

@FixtureSetup(UmaConfiguracaoFalhandoUmTesteFalhando.class)
public class UmAcessorioFalhandoUmaConfiguracaoPassandoUmTestePassando {

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
