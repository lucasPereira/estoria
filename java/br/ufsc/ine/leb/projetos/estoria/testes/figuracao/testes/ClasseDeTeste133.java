package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ ClasseDeTeste131.class, ClasseDeTeste132.class })
public class ClasseDeTeste133 {

	@Fixture private List<Integer> numeros;

	@Test
	public void testar() throws Exception {
		assertTrue(numeros.contains(1));
		assertTrue(numeros.contains(2));
	}

}
