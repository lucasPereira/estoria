package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;

@Acessorios(UmaConfiguracaoPassandoUmTestePassando.class)
public class UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando {

	@Rule private String herdado;

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
