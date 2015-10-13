package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.ClasseDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;

public final class TesteClasseDeTeste {

	@Test
	public void igualdade() throws Exception {
		assertEquals(new ClasseDeTeste(ClasseVazia.class), new ClasseDeTeste(ClasseVazia.class));
		assertNotEquals(new ClasseDeTeste(ClasseVazia.class), new ClasseDeTeste(ClasseCheia.class));
	}

	@Test
	public void codigo() throws Exception {
		assertEquals(ClasseVazia.class.hashCode(), new ClasseDeTeste(ClasseVazia.class).hashCode());
		assertEquals(ClasseCheia.class.hashCode(), new ClasseDeTeste(ClasseCheia.class).hashCode());
	}

}
