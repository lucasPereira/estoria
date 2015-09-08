package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class UmaConfiguracaoPassandoUmTestePassando {

	private int numeroBefore;
	private int numeroTest;
	private int numeroBeforeTest;
	public static int numeroEstaticoBefore;
	public static int numeroEstaticoBeforeTest;
	public static int numeroEstaticoTest;

	@Before
	public void configurar() {
		numeroBefore = 10;
		numeroBeforeTest = 15;
		numeroEstaticoBefore = 40;
		numeroEstaticoBeforeTest = 45;
	}

	@Test
	public void testar() {
		numeroTest = 30;
		numeroBeforeTest = 20;
		numeroEstaticoBeforeTest = 50;
		numeroEstaticoTest = 60;
		assertEquals(10, numeroBefore);
		assertEquals(20, numeroBeforeTest);
		assertEquals(30, numeroTest);
		assertEquals(40, numeroEstaticoBefore);
		assertEquals(50, numeroEstaticoBeforeTest);
		assertEquals(60, numeroEstaticoTest);
	}

}
