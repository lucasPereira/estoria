package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;

public final class TesteFiltradorDeMetodos {

	@Test
	public void classeVazia() throws Exception {
		FiltradorDeMetodos filtrador = new FiltradorDeMetodos(ClasseVazia.class);
		List<Method> metodos = filtrador.obterMetodos();
		assertEquals(0, metodos.size());
	}

	@Test
	public void classeCheia() throws Exception {
		FiltradorDeMetodos filtrador = new FiltradorDeMetodos(ClasseCheia.class);
		List<Method> metodos = filtrador.obterMetodos();
		assertEquals(10, metodos.size());
		assertEquals("metodoComAnotacaoIgnore", metodos.get(0).getName());
		assertEquals("metodoComAnotacaoTeste", metodos.get(1).getName());
		assertEquals("metodoComAnotacoesIgnoreTeste", metodos.get(2).getName());
		assertEquals("metodoComAnotacoesTesteIgnore", metodos.get(3).getName());
		assertEquals("metodoComGenerico", metodos.get(4).getName());
		assertEquals("metodoComParametro", metodos.get(5).getName());
		assertEquals("metodoComRetorno", metodos.get(6).getName());
		assertEquals("metodoDefault", metodos.get(7).getName());
		assertEquals("metodoPrivado", metodos.get(8).getName());
		assertEquals("metodoProtegido", metodos.get(9).getName());
	}

	@Test
	public void filtrarMetodoPrivado() throws Exception {
		fail();
	}

}
