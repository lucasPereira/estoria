package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ ClasseDeTeste116.class, ClasseDeTeste117.class })
public class ClasseDeTeste135 {

	@Fixture private int numero;

	@Test
	public void testar() throws Exception {
		assertEquals(10, numero);
	}

}
