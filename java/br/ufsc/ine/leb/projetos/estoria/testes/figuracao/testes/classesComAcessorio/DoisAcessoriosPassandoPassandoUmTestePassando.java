package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;

@Acessorios({ UmaConfiguracaoPassandoUmTestePassando.class, UmaConfiguracaoPassandoUmTesteFalhando.class })
public class DoisAcessoriosPassandoPassandoUmTestePassando {

	@Test
	public void testar() {
		assertEquals(40, UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoBefore);
		assertEquals(45, UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoBeforeTest);
		assertEquals(0, UmaConfiguracaoPassandoUmTestePassando.numeroEstaticoTest);
		assertEquals(80, UmaConfiguracaoPassandoUmTesteFalhando.numeroEstaticoBefore);
		assertEquals(90, UmaConfiguracaoPassandoUmTesteFalhando.numeroEstaticoBeforeTest);
		assertEquals(0, UmaConfiguracaoPassandoUmTesteFalhando.numeroEstaticoTest);
	}

}
