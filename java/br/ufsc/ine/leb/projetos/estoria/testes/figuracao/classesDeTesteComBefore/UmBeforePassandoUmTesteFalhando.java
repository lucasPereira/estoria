package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTesteComBefore;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UmBeforePassandoUmTesteFalhando {

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
