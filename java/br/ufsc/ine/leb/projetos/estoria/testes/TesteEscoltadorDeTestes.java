package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;

public final class TesteEscoltadorDeTestes {

	private EscoltadorDeTestes escoltador;
	private Description descricao;

	@Before
	public void prepararCenario() {
		escoltador = new EscoltadorDeTestes(new SeletorDeTestes());
		descricao = escoltador.getDescription();
	}

	@Test
	public void descricaoDoTeste() throws Exception {
		fail();
		assertNull(descricao.getDisplayName());
		assertNull(descricao.getTestClass());
		assertNull(descricao.getClassName());
		assertNull(descricao.getMethodName());
		assertTrue(descricao.isSuite());
		assertFalse(descricao.isTest());
		assertEquals(1, descricao.getChildren().size());
		assertEquals(1, descricao.testCount());
		assertFalse(descricao.isEmpty());
	}

}
