package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UmaConfiguracaoFalhandoUmTesteFalhando {

	@Before
	public void configurar() {
		assertTrue(true);
		fail("Falha no before");
		assertTrue(true);
	}

	@Test
	public void testar() {
		assertTrue(true);
		fail("Falha no test");
		assertTrue(true);
	}

}
