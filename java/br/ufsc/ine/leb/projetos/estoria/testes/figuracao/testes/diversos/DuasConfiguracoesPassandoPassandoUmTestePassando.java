package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DuasConfiguracoesPassandoPassandoUmTestePassando {

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
