package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class UmaConfiguracaoPassandoUmTestePassando {

	private int acessorioBefore10;
	private int acessorioBefore20Test30;
	private int acessorioTest40;

	@Before
	public void configurar() {
		acessorioBefore10 = 10;
		acessorioBefore20Test30 = 20;
		assertEquals(10, acessorioBefore10);
		assertEquals(20, acessorioBefore20Test30);
		assertEquals(0, acessorioTest40);
	}

	@Test
	public void testar() {
		acessorioBefore20Test30 = 30;
		acessorioTest40 = 40;
		assertEquals(10, acessorioBefore10);
		assertEquals(30, acessorioBefore20Test30);
		assertEquals(40, acessorioTest40);
	}

}
