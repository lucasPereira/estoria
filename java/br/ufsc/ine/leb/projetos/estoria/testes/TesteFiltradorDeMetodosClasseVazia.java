package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;

@RunWith(JUnit4.class)
public final class TesteFiltradorDeMetodosClasseVazia {

	private FiltradorDeMetodos filtrador;

	@Before
	public void prepararCenario() {
		filtrador = new FiltradorDeMetodos(ClasseVazia.class);
	}

	@Test
	public void classeVazia() throws Exception {
		List<Method> metodos = filtrador.obterMetodos();
		assertEquals(0, metodos.size());
	}

}
