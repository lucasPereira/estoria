package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.Booleano;

@RunWith(JUnit4.class)
public final class TesteBooleano {

	private Booleano booleano;

	@Before
	public void prepararCenario() {
		booleano = new Booleano();
	}

	@Test
	public void reduzirFalso() throws Exception {
		booleano.e(false);
		booleano.e(true);
		assertFalse(booleano.reduzir());
	}

	@Test
	public void reduzirVerdadeiro() throws Exception {
		booleano.e(true);
		booleano.e(true);
		assertTrue(booleano.reduzir());
	}

	@Test
	public void reduzirPadrao() throws Exception {
		assertTrue(booleano.reduzir());
	}

}
