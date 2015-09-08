package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class UmaConfiguracaoPassandoUmTesteFalhando {

	public static int numeroEstaticoBefore;
	public static int numeroEstaticoBeforeTest;
	public static int numeroEstaticoTest;

	@Before
	public void configurarDeTesteFalhando() {
		numeroEstaticoBefore = UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoBefore + 40;
		numeroEstaticoBeforeTest = UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoBeforeTest + 45;
	}

	@Test
	public void testarDeTesteFalhando() {
		numeroEstaticoBeforeTest = UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoBeforeTest + 50;
		numeroEstaticoTest = UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoTest + 60;
		assertEquals(40, numeroEstaticoBefore);
		assertEquals(50, numeroEstaticoBeforeTest);
		assertEquals(60, numeroEstaticoTest);
	}

}
