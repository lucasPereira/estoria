package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;

@Acessorios(UmaConfiguracaoPassandoUmTestePassando.class)
public class UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando {

	@Acessorio private int meuBefore10;
	@Acessorio private int meuBefore20Test30;
	@Acessorio private int meuTest40;
	
	private int acessorioBefore10;
	private int acessorioBefore20Test30;
	private int acessorioTest40;

	@Before
	public void configurar() {
		assertTrue(true);
	}

	@Test
	public void testar() {
		assertEquals(40, UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoBefore);
		assertEquals(45, UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoBeforeTest);
		assertEquals(0, UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoTest);
	}

}
