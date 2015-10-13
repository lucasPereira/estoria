package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(ClasseDeTeste130.class)
public class ClasseDeTeste132 {

	@Fixture private List<Integer> numeros;

	@Before
	public void configurar() {
		numeros.add(2);
		assertTrue(numeros.contains(2));
	}

	@Test
	public void testar() throws Exception {
		assertTrue(numeros.contains(2));
		fail("132 falha induzida");
	}

}
