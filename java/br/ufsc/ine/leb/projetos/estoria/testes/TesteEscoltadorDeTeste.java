package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.Description;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseDeTesteUmMetodoDeTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.estoria.SuiteDoEstoriaUmaClasseUmMetodoDeTeste;

public class TesteEscoltadorDeTeste {

	@Test
	public void umaClasseUmMetodoDeTeste() throws Exception {
		EscoltadorDeTeste escoltador = new EscoltadorDeTeste(SuiteDoEstoriaUmaClasseUmMetodoDeTeste.class);
		Description descricao = escoltador.getDescription();

		assertEquals(SuiteDoEstoriaUmaClasseUmMetodoDeTeste.class.getTypeName(), descricao.getDisplayName());
		assertNull(descricao.getTestClass());
		assertNull(descricao.getClassName());
		assertNull(descricao.getMethodName());
		assertTrue(descricao.isSuite());
		assertFalse(descricao.isTest());
		assertEquals(1, descricao.getChildren().size());
		assertEquals(1, descricao.testCount());
		assertFalse(descricao.isEmpty());
		
		assertEquals(ClasseDeTesteUmMetodoDeTestePassando.class.getName(), descricao.getDisplayName());
		assertEquals(ClasseDeTesteUmMetodoDeTestePassando.class, descricao.getChildren().get(0).getTestClass());
		assertEquals(ClasseDeTesteUmMetodoDeTestePassando.class.getName(), descricao.getChildren().get(0).getClassName());
		assertNull(descricao.getChildren().get(0).getMethodName());
		assertTrue(descricao.getChildren().get(0).isSuite());
		assertFalse(descricao.getChildren().get(0).isTest());
		assertEquals(1, descricao.getChildren().get(0).getChildren().size());
		assertEquals(1, descricao.getChildren().get(0).testCount());
		assertFalse(descricao.getChildren().get(0).isEmpty());
		
		assertEquals(ClasseDeTesteUmMetodoDeTestePassando.class, descricao.getChildren().get(0).getChildren().get(0).getTestClass());
		assertEquals(ClasseDeTesteUmMetodoDeTestePassando.class.getName(), descricao.getChildren().get(0).getChildren().get(0).getClassName());
		assertEquals("teste1Passando", descricao.getChildren().get(0).getChildren().get(0).getMethodName());
		assertFalse(descricao.getChildren().get(0).getChildren().get(0).isSuite());
		assertTrue(descricao.getChildren().get(0).getChildren().get(0).isTest());
		assertEquals(0, descricao.getChildren().get(0).getChildren().get(0).getChildren().size());
		assertEquals(1, descricao.getChildren().get(0).getChildren().get(0).testCount());
		assertTrue(descricao.getChildren().get(0).getChildren().get(0).isEmpty());
	}

}
