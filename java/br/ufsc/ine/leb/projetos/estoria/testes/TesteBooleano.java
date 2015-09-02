package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Booleano;

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
