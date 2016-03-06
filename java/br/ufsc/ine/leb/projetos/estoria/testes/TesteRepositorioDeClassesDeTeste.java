package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.ClasseDeTeste;
import br.ufsc.ine.leb.projetos.estoria.RepositorioDeClassesDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;

@RunWith(JUnit4.class)
public class TesteRepositorioDeClassesDeTeste {

	private RepositorioDeClassesDeTeste repositorio;
	private ClasseDeTeste classeConstruida;

	@Before
	public void configurar() throws Exception {
		repositorio = new RepositorioDeClassesDeTeste();
		classeConstruida = repositorio.construir(ClasseDeTeste101.class);
	}

	@Test
	public void classeDeTesteInexistente() throws Exception {
		assertEquals(new ClasseDeTeste(ClasseDeTeste101.class, new RepositorioDeClassesDeTeste()), classeConstruida);
		assertNotSame(new ClasseDeTeste(ClasseDeTeste101.class, new RepositorioDeClassesDeTeste()), classeConstruida);
	}

	@Test
	public void classeDeTesteExistente() throws Exception {
		assertSame(classeConstruida, repositorio.construir(ClasseDeTeste101.class));
	}

}
