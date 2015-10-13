package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseDeTeste117 {

	private int numero = 10;

	@Before
	public void configurar2() {
		numero = numero + 10;
	}

	@Before
	public void configurar1() {
		numero = numero * 5;
	}

	@Test
	public void testar() {
		assertEquals(60, numero);
	}

}
