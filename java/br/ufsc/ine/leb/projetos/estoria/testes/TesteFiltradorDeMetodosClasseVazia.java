package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseSemMetodos;

public final class TesteFiltradorDeMetodosClasseVazia {

	private FiltradorDeMetodos filtrador;

	@Before
	public void prepararCenario() {
		filtrador = new FiltradorDeMetodos(ClasseSemMetodos.class);
	}

	@Test
	public void classeVazia() throws Exception {
		List<Method> metodos = filtrador.obterMetodos();
		assertTrue(filtrador.vazio());
		assertEquals(0, metodos.size());
	}

	@Test
	public void reduzir() throws Exception {
		String reduzido = filtrador.reduzir(metodo -> metodo.getName());
		assertTrue(filtrador.vazio());
		assertEquals(0, filtrador.obterMetodos().size());
		assertNull(reduzido);
	}

}
