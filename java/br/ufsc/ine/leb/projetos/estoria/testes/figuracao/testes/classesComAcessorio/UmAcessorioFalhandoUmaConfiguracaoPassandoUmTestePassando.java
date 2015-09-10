package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoFalhandoUmTesteFalhando;

@Acessorios(UmaConfiguracaoFalhandoUmTesteFalhando.class)
public class UmAcessorioFalhandoUmaConfiguracaoPassandoUmTestePassando {

	@Before
	public void configurar() {
		assertTrue(true);
	}

	@Test
	public void testar() {
		assertTrue(true);
	}

}
