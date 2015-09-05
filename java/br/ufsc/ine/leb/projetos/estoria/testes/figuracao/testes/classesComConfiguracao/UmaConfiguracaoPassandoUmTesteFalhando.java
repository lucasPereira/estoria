package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UmaConfiguracaoPassandoUmTesteFalhando {

	private int numero = 0;

	@Before
	public void configurarDeTesteFalhando() {
		numero = 10;
	}

	@Test
	public void testarDeTesteFalhando() {
		assertEquals(0, numero);
	}

}
