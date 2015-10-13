package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ClasseDeTeste111 {

	@Test
	public void testar1() {
		fail("111 falha induzida");
	}

	@Ignore
	@Test
	public void testar2() {
		fail("111 falha ignorada");
	}

	@Test
	public void testar3() {
		assertTrue(true);
	}

}
