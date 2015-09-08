package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class UmaConfiguracaoFalhandoUmTestePassando {

	@Before
	public void configurar() {
		assertTrue(true);
		fail("Falha no before");
		assertTrue(true);
	}

	@Test
	public void testar() {
		assertTrue(true);
	}

}
