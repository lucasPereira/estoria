package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.Description;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste110;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste11;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste12;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste13;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste14;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste16;

public final class TesteEscoltadorDeTestesDescricoes {

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
	public void zeroClasses() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste11.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(SuiteDeTeste11.class, descricaoDoSeletor.getTestClass());
		assertEquals(SuiteDeTeste11.class.getName(), descricaoDoSeletor.getClassName());
		assertNull(descricaoDoSeletor.getMethodName());
		assertFalse(descricaoDoSeletor.isSuite());
		assertTrue(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(0, descricaoDoSeletor.getChildren().size());
		assertEquals(1, descricaoDoSeletor.testCount());
		assertEquals(1, escoltador.testCount());
	}

	@Test
	public void zeroTestesDeUmaClasse() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste12.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(SuiteDeTeste12.class, descricaoDoSeletor.getTestClass());
		assertEquals(SuiteDeTeste12.class.getName(), descricaoDoSeletor.getClassName());
		assertNull(descricaoDoSeletor.getMethodName());
		assertFalse(descricaoDoSeletor.isSuite());
		assertTrue(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(0, descricaoDoSeletor.getChildren().size());
		assertEquals(1, descricaoDoSeletor.testCount());
		assertEquals(1, escoltador.testCount());
	}

	@Test
	public void umTesteDeUmaClasse() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste13.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(SuiteDeTeste13.class, descricaoDoSeletor.getTestClass());
		assertEquals(SuiteDeTeste13.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(1, descricaoDoSeletor.getChildren().size());
		assertEquals(1, descricaoDoSeletor.testCount());

		Description descricaoDoTeste = descricaoDoSeletor.getChildren().get(0);
		assertEquals(ClasseDeTeste101.class, descricaoDoTeste.getTestClass());
		assertEquals(ClasseDeTeste101.class.getName(), descricaoDoTeste.getClassName());
		assertEquals("testar", descricaoDoTeste.getMethodName());
		assertFalse(descricaoDoTeste.isSuite());
		assertTrue(descricaoDoTeste.isTest());
		assertFalse(descricaoDoTeste.isEmpty());
		assertEquals(0, descricaoDoTeste.getChildren().size());
		assertEquals(1, descricaoDoTeste.testCount());
		assertEquals(1, escoltador.testCount());
	}

	@Test
	public void doisTestesDeUmaClasse() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste14.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(SuiteDeTeste14.class, descricaoDoSeletor.getTestClass());
		assertEquals(SuiteDeTeste14.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(2, descricaoDoSeletor.getChildren().size());
		assertEquals(2, descricaoDoSeletor.testCount());
		assertEquals(2, escoltador.testCount());

		Description descricaoDoTeste1 = descricaoDoSeletor.getChildren().get(0);
		assertEquals(ClasseDeTeste110.class, descricaoDoTeste1.getTestClass());
		assertEquals(ClasseDeTeste110.class.getName(), descricaoDoTeste1.getClassName());
		assertEquals("testar1", descricaoDoTeste1.getMethodName());
		assertFalse(descricaoDoTeste1.isSuite());
		assertTrue(descricaoDoTeste1.isTest());
		assertFalse(descricaoDoTeste1.isEmpty());
		assertEquals(0, descricaoDoTeste1.getChildren().size());
		assertEquals(1, descricaoDoTeste1.testCount());

		Description descricaoDoTeste2 = descricaoDoSeletor.getChildren().get(1);
		assertEquals(ClasseDeTeste110.class, descricaoDoTeste2.getTestClass());
		assertEquals(ClasseDeTeste110.class.getName(), descricaoDoTeste2.getClassName());
		assertEquals("testar2", descricaoDoTeste2.getMethodName());
		assertFalse(descricaoDoTeste2.isSuite());
		assertTrue(descricaoDoTeste2.isTest());
		assertFalse(descricaoDoTeste2.isEmpty());
		assertEquals(0, descricaoDoTeste2.getChildren().size());
		assertEquals(1, descricaoDoTeste2.testCount());
	}

	@Test
	public void doisTesteDeUmaClasseSemSuite() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste110.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(ClasseDeTeste110.class, descricaoDoSeletor.getTestClass());
		assertEquals(ClasseDeTeste110.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(2, descricaoDoSeletor.getChildren().size());
		assertEquals(2, descricaoDoSeletor.testCount());
		assertEquals(2, escoltador.testCount());

		Description descricaoDoTeste1 = descricaoDoSeletor.getChildren().get(0);
		assertEquals(ClasseDeTeste110.class, descricaoDoTeste1.getTestClass());
		assertEquals(ClasseDeTeste110.class.getName(), descricaoDoTeste1.getClassName());
		assertEquals("testar1", descricaoDoTeste1.getMethodName());
		assertFalse(descricaoDoTeste1.isSuite());
		assertTrue(descricaoDoTeste1.isTest());
		assertFalse(descricaoDoTeste1.isEmpty());
		assertEquals(0, descricaoDoTeste1.getChildren().size());
		assertEquals(1, descricaoDoTeste1.testCount());

		Description descricaoDoTeste2 = descricaoDoSeletor.getChildren().get(1);
		assertEquals(ClasseDeTeste110.class, descricaoDoTeste2.getTestClass());
		assertEquals(ClasseDeTeste110.class.getName(), descricaoDoTeste2.getClassName());
		assertEquals("testar2", descricaoDoTeste2.getMethodName());
		assertFalse(descricaoDoTeste2.isSuite());
		assertTrue(descricaoDoTeste2.isTest());
		assertFalse(descricaoDoTeste2.isEmpty());
		assertEquals(0, descricaoDoTeste2.getChildren().size());
		assertEquals(1, descricaoDoTeste2.testCount());
	}

	@Test
	public void tresTestesDeDuasClasses() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste16.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(SuiteDeTeste16.class, descricaoDoSeletor.getTestClass());
		assertEquals(SuiteDeTeste16.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(3, descricaoDoSeletor.getChildren().size());
		assertEquals(3, descricaoDoSeletor.testCount());
		assertEquals(3, escoltador.testCount());

		Description descricaoDoTeste1 = descricaoDoSeletor.getChildren().get(0);
		assertEquals(ClasseDeTeste101.class, descricaoDoTeste1.getTestClass());
		assertEquals(ClasseDeTeste101.class.getName(), descricaoDoTeste1.getClassName());
		assertEquals("testar", descricaoDoTeste1.getMethodName());
		assertFalse(descricaoDoTeste1.isSuite());
		assertTrue(descricaoDoTeste1.isTest());
		assertFalse(descricaoDoTeste1.isEmpty());
		assertEquals(0, descricaoDoTeste1.getChildren().size());
		assertEquals(1, descricaoDoTeste1.testCount());

		Description descricaoDoTeste2 = descricaoDoSeletor.getChildren().get(1);
		assertEquals(ClasseDeTeste110.class, descricaoDoTeste2.getTestClass());
		assertEquals(ClasseDeTeste110.class.getName(), descricaoDoTeste2.getClassName());
		assertEquals("testar1", descricaoDoTeste2.getMethodName());
		assertFalse(descricaoDoTeste2.isSuite());
		assertTrue(descricaoDoTeste2.isTest());
		assertFalse(descricaoDoTeste2.isEmpty());
		assertEquals(0, descricaoDoTeste2.getChildren().size());
		assertEquals(1, descricaoDoTeste2.testCount());

		Description descricaoDoTeste3 = descricaoDoSeletor.getChildren().get(2);
		assertEquals(ClasseDeTeste110.class, descricaoDoTeste3.getTestClass());
		assertEquals(ClasseDeTeste110.class.getName(), descricaoDoTeste3.getClassName());
		assertEquals("testar2", descricaoDoTeste3.getMethodName());
		assertFalse(descricaoDoTeste3.isSuite());
		assertTrue(descricaoDoTeste3.isTest());
		assertFalse(descricaoDoTeste3.isEmpty());
		assertEquals(0, descricaoDoTeste3.getChildren().size());
		assertEquals(1, descricaoDoTeste3.testCount());
	}

}
