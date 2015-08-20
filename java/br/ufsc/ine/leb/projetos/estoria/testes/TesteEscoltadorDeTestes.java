package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.Description;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisMetodosDeTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassando;

public final class TesteEscoltadorDeTestes {

	@Test
	public void semTestesJunit() throws Exception {
		Description descricao = Description.EMPTY;
		assertNull(descricao.getTestClass());
		assertEquals("No Tests", descricao.getDisplayName());
		assertEquals("No Tests", descricao.getClassName());
		assertNull(descricao.getMethodName());
		assertFalse(descricao.isSuite());
		assertTrue(descricao.isTest());
		assertTrue(descricao.isEmpty());
		assertEquals(0, descricao.getChildren().size());
		assertEquals(1, descricao.testCount());
	}

	@Test
	public void semTestes() throws Exception {
		SeletorDeTestes seletor = new SeletorDeTestes();
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(seletor);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(seletor.getClass(), descricaoDoSeletor.getTestClass());
		assertEquals(seletor.getClass().getName(), descricaoDoSeletor.getClassName());
		assertNull(descricaoDoSeletor.getMethodName());
		// assertTrue(descricaoDoSeletor.isSuite());
		// assertFalse(descricaoDoSeletor.isTest());
		// assertTrue(descricaoDoSeletor.isEmpty());
		assertEquals(0, descricaoDoSeletor.getChildren().size());
		// assertEquals(0, descricaoDoSeletor.testCount());
	}

	@Test
	public void umTesteDeUmaClasse() throws Exception {
		SeletorDeTestes seletor = new SeletorDeTestes();
		seletor.adicionarClasse(ClasseComUmMetodoDeTestePassando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(seletor);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(seletor.getClass(), descricaoDoSeletor.getTestClass());
		assertEquals(seletor.getClass().getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(1, descricaoDoSeletor.getChildren().size());
		assertEquals(1, descricaoDoSeletor.testCount());

		Description descricaoDoTeste = descricaoDoSeletor.getChildren().get(0);
		assertEquals(ClasseComUmMetodoDeTestePassando.class, descricaoDoTeste.getTestClass());
		assertEquals(ClasseComUmMetodoDeTestePassando.class.getName(), descricaoDoTeste.getClassName());
		assertEquals("testar", descricaoDoTeste.getMethodName());
		assertFalse(descricaoDoTeste.isSuite());
		assertTrue(descricaoDoTeste.isTest());
		assertFalse(descricaoDoTeste.isEmpty());
		assertEquals(0, descricaoDoTeste.getChildren().size());
		assertEquals(1, descricaoDoTeste.testCount());
	}

	@Test
	public void doisTestesDeUmaClasse() throws Exception {
		SeletorDeTestes seletor = new SeletorDeTestes();
		seletor.adicionarClasse(ClasseComDoisMetodosDeTestePassando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(seletor);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(seletor.getClass(), descricaoDoSeletor.getTestClass());
		assertEquals(seletor.getClass().getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(2, descricaoDoSeletor.getChildren().size());
		assertEquals(2, descricaoDoSeletor.testCount());

		Description descricaoDoTeste1 = descricaoDoSeletor.getChildren().get(0);
		assertEquals(ClasseComDoisMetodosDeTestePassando.class, descricaoDoTeste1.getTestClass());
		assertEquals(ClasseComDoisMetodosDeTestePassando.class.getName(), descricaoDoTeste1.getClassName());
		assertEquals("testar1", descricaoDoTeste1.getMethodName());
		assertFalse(descricaoDoTeste1.isSuite());
		assertTrue(descricaoDoTeste1.isTest());
		assertFalse(descricaoDoTeste1.isEmpty());
		assertEquals(0, descricaoDoTeste1.getChildren().size());
		assertEquals(1, descricaoDoTeste1.testCount());

		Description descricaoDoTeste2 = descricaoDoSeletor.getChildren().get(1);
		assertEquals(ClasseComDoisMetodosDeTestePassando.class, descricaoDoTeste2.getTestClass());
		assertEquals(ClasseComDoisMetodosDeTestePassando.class.getName(), descricaoDoTeste2.getClassName());
		assertEquals("testar2", descricaoDoTeste2.getMethodName());
		assertFalse(descricaoDoTeste2.isSuite());
		assertTrue(descricaoDoTeste2.isTest());
		assertFalse(descricaoDoTeste2.isEmpty());
		assertEquals(0, descricaoDoTeste2.getChildren().size());
		assertEquals(1, descricaoDoTeste2.testCount());
	}

}
