package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ ClasseDeTeste131.class, ClasseDeTeste132.class })
public class ClasseDeTeste134 {

	@Fixture private List<Integer> numeros;

	@Test
	public void testar1() throws Exception {
		assertEquals(2, numeros.size());
		assertTrue(numeros.contains(1));
		assertTrue(numeros.contains(2));
	}

	@Test
	public void testar2() throws Exception {
		assertEquals(2, numeros.size());
		assertTrue(numeros.contains(1));
		assertTrue(numeros.contains(2));
	}

}
