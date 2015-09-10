package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class DuasConfiguracoesFalhandoPassandoUmTestePassando {

	private int numero = 10;

	@Before
	public void configurar2() {
		numero = numero + 10;
	}

	@Before
	public void configurar1() {
		numero = numero * 5;
		fail("falha configurada");
	}

	@Test
	public void testar() {
		assertEquals(60, numero);
	}

}
