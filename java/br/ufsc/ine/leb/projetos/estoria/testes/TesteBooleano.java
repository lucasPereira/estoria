package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Booleano;

public class TesteBooleano {

	@Test
	public void reduzirFalso() throws Exception {
		Booleano booleano = new Booleano();
		booleano.e(false);
		booleano.e(true);
		assertFalse(booleano.reduzir());
	}

	@Test
	public void reduzirVerdadeiro() throws Exception {
		Booleano booleano = new Booleano();
		booleano.e(true);
		booleano.e(true);
		assertTrue(booleano.reduzir());
	}

	@Test
	public void reduzirPadrao() throws Exception {
		Booleano booleano = new Booleano();
		assertTrue(booleano.reduzir());
	}

}
