package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTesteComBefore;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UmBeforePassandoUmTestePassando {

	private int numero;

	@Before
	public void configurar() {
		numero = 10;
	}

	@Test
	public void testar() {
		assertEquals(10, numero);
	}

}
