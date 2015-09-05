package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.DoisTestesPassandoPassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.DuasClassesZeroAcessoriosZeroConfiguracoesTresTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.UmaClasseZeroAcessoriosZeroConfiguracoesDoisTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.ZeroClasses;

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
		SuiteDeTeste suite = new SuiteDeTeste(ZeroClasses.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		escoltador.run(new RunNotifier());

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(ZeroClasses.class, descricaoDoSeletor.getTestClass());
		assertEquals(ZeroClasses.class.getName(), descricaoDoSeletor.getClassName());
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
		SuiteDeTeste suite = new SuiteDeTeste(UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		escoltador.run(new RunNotifier());

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes.class, descricaoDoSeletor.getTestClass());
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes.class.getName(), descricaoDoSeletor.getClassName());
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
		SuiteDeTeste suite = new SuiteDeTeste(UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		escoltador.run(new RunNotifier());

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste.class, descricaoDoSeletor.getTestClass());
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(1, descricaoDoSeletor.getChildren().size());
		assertEquals(1, descricaoDoSeletor.testCount());

		Description descricaoDoTeste = descricaoDoSeletor.getChildren().get(0);
		assertEquals(UmTestePassando.class, descricaoDoTeste.getTestClass());
		assertEquals(UmTestePassando.class.getName(), descricaoDoTeste.getClassName());
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
		SuiteDeTeste suite = new SuiteDeTeste(UmaClasseZeroAcessoriosZeroConfiguracoesDoisTestes.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		escoltador.run(new RunNotifier());

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesDoisTestes.class, descricaoDoSeletor.getTestClass());
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesDoisTestes.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(2, descricaoDoSeletor.getChildren().size());
		assertEquals(2, descricaoDoSeletor.testCount());
		assertEquals(2, escoltador.testCount());

		Description descricaoDoTeste1 = descricaoDoSeletor.getChildren().get(0);
		assertEquals(DoisTestesPassandoPassando.class, descricaoDoTeste1.getTestClass());
		assertEquals(DoisTestesPassandoPassando.class.getName(), descricaoDoTeste1.getClassName());
		assertEquals("testar1", descricaoDoTeste1.getMethodName());
		assertFalse(descricaoDoTeste1.isSuite());
		assertTrue(descricaoDoTeste1.isTest());
		assertFalse(descricaoDoTeste1.isEmpty());
		assertEquals(0, descricaoDoTeste1.getChildren().size());
		assertEquals(1, descricaoDoTeste1.testCount());

		Description descricaoDoTeste2 = descricaoDoSeletor.getChildren().get(1);
		assertEquals(DoisTestesPassandoPassando.class, descricaoDoTeste2.getTestClass());
		assertEquals(DoisTestesPassandoPassando.class.getName(), descricaoDoTeste2.getClassName());
		assertEquals("testar2", descricaoDoTeste2.getMethodName());
		assertFalse(descricaoDoTeste2.isSuite());
		assertTrue(descricaoDoTeste2.isTest());
		assertFalse(descricaoDoTeste2.isEmpty());
		assertEquals(0, descricaoDoTeste2.getChildren().size());
		assertEquals(1, descricaoDoTeste2.testCount());
	}

	@Test
	public void doisTesteDeUmaClasseSemSuite() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(DoisTestesPassandoPassando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		escoltador.run(new RunNotifier());

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(DoisTestesPassandoPassando.class, descricaoDoSeletor.getTestClass());
		assertEquals(DoisTestesPassandoPassando.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(2, descricaoDoSeletor.getChildren().size());
		assertEquals(2, descricaoDoSeletor.testCount());
		assertEquals(2, escoltador.testCount());

		Description descricaoDoTeste1 = descricaoDoSeletor.getChildren().get(0);
		assertEquals(DoisTestesPassandoPassando.class, descricaoDoTeste1.getTestClass());
		assertEquals(DoisTestesPassandoPassando.class.getName(), descricaoDoTeste1.getClassName());
		assertEquals("testar1", descricaoDoTeste1.getMethodName());
		assertFalse(descricaoDoTeste1.isSuite());
		assertTrue(descricaoDoTeste1.isTest());
		assertFalse(descricaoDoTeste1.isEmpty());
		assertEquals(0, descricaoDoTeste1.getChildren().size());
		assertEquals(1, descricaoDoTeste1.testCount());

		Description descricaoDoTeste2 = descricaoDoSeletor.getChildren().get(1);
		assertEquals(DoisTestesPassandoPassando.class, descricaoDoTeste2.getTestClass());
		assertEquals(DoisTestesPassandoPassando.class.getName(), descricaoDoTeste2.getClassName());
		assertEquals("testar2", descricaoDoTeste2.getMethodName());
		assertFalse(descricaoDoTeste2.isSuite());
		assertTrue(descricaoDoTeste2.isTest());
		assertFalse(descricaoDoTeste2.isEmpty());
		assertEquals(0, descricaoDoTeste2.getChildren().size());
		assertEquals(1, descricaoDoTeste2.testCount());
	}

	@Test
	public void tresTestesDeDuasClasses() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(DuasClassesZeroAcessoriosZeroConfiguracoesTresTestes.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		escoltador.run(new RunNotifier());

		Description descricaoDoSeletor = escoltador.getDescription();
		assertEquals(DuasClassesZeroAcessoriosZeroConfiguracoesTresTestes.class, descricaoDoSeletor.getTestClass());
		assertEquals(DuasClassesZeroAcessoriosZeroConfiguracoesTresTestes.class.getName(), descricaoDoSeletor.getClassName());
		assertEquals(null, descricaoDoSeletor.getMethodName());
		assertTrue(descricaoDoSeletor.isSuite());
		assertFalse(descricaoDoSeletor.isTest());
		assertFalse(descricaoDoSeletor.isEmpty());
		assertEquals(3, descricaoDoSeletor.getChildren().size());
		assertEquals(3, descricaoDoSeletor.testCount());
		assertEquals(3, escoltador.testCount());

		Description descricaoDoTeste1 = descricaoDoSeletor.getChildren().get(0);
		assertEquals(UmTestePassando.class, descricaoDoTeste1.getTestClass());
		assertEquals(UmTestePassando.class.getName(), descricaoDoTeste1.getClassName());
		assertEquals("testar", descricaoDoTeste1.getMethodName());
		assertFalse(descricaoDoTeste1.isSuite());
		assertTrue(descricaoDoTeste1.isTest());
		assertFalse(descricaoDoTeste1.isEmpty());
		assertEquals(0, descricaoDoTeste1.getChildren().size());
		assertEquals(1, descricaoDoTeste1.testCount());

		Description descricaoDoTeste2 = descricaoDoSeletor.getChildren().get(1);
		assertEquals(DoisTestesPassandoPassando.class, descricaoDoTeste2.getTestClass());
		assertEquals(DoisTestesPassandoPassando.class.getName(), descricaoDoTeste2.getClassName());
		assertEquals("testar1", descricaoDoTeste2.getMethodName());
		assertFalse(descricaoDoTeste2.isSuite());
		assertTrue(descricaoDoTeste2.isTest());
		assertFalse(descricaoDoTeste2.isEmpty());
		assertEquals(0, descricaoDoTeste2.getChildren().size());
		assertEquals(1, descricaoDoTeste2.testCount());

		Description descricaoDoTeste3 = descricaoDoSeletor.getChildren().get(2);
		assertEquals(DoisTestesPassandoPassando.class, descricaoDoTeste3.getTestClass());
		assertEquals(DoisTestesPassandoPassando.class.getName(), descricaoDoTeste3.getClassName());
		assertEquals("testar2", descricaoDoTeste3.getMethodName());
		assertFalse(descricaoDoTeste3.isSuite());
		assertTrue(descricaoDoTeste3.isTest());
		assertFalse(descricaoDoTeste3.isEmpty());
		assertEquals(0, descricaoDoTeste3.getChildren().size());
		assertEquals(1, descricaoDoTeste3.testCount());
	}

}
