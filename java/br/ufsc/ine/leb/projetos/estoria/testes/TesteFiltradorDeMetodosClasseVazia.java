package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;

public final class TesteFiltradorDeMetodosClasseVazia {

	@Test
	public void classeVazia() throws Exception {
		FiltradorDeMetodos filtrador = new FiltradorDeMetodos(ClasseVazia.class);
		List<Method> metodos = filtrador.obterMetodos();
		assertEquals(0, metodos.size());
	}

}
