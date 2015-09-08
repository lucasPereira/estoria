package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UmaConfiguracaoFalhandoUmTesteFalhando {

	@Before
	public void configurar() {
		fail("Falha no before");
	}

	@Test
	public void testar() {
		fail("Falha no test");
	}

}
