package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Singular;

@Singular
public class ClasseDeTeste130 {

	private List<Integer> numeros;

	@Before
	public void configurar() {
		numeros = new LinkedList<Integer>();
	}

	@Test
	public void testar() throws Exception {
		assertTrue(numeros.isEmpty());
	}

}
