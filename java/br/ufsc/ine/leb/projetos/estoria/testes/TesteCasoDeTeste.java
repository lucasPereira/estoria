package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.Description;

import br.ufsc.ine.leb.projetos.estoria.CasoDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;

public final class TesteCasoDeTeste {

	@Test
	public void semBefore() throws Exception {
		CasoDeTeste casoDeTeste = new CasoDeTeste(UmTestePassando.class, "testar", null);
		Description descricaoDoTeste = casoDeTeste.obterDescricao();
		assertEquals(UmTestePassando.class, casoDeTeste.obterClasse());
		assertEquals("testar", casoDeTeste.obterMetodoDeTeste());
		assertNull(casoDeTeste.obterMetodoDeConfiguracao());
		assertEquals(UmTestePassando.class, descricaoDoTeste.getTestClass());
		assertEquals(UmTestePassando.class.getName(), descricaoDoTeste.getClassName());
		assertEquals("testar", descricaoDoTeste.getMethodName());
		assertFalse(descricaoDoTeste.isSuite());
		assertTrue(descricaoDoTeste.isTest());
		assertFalse(descricaoDoTeste.isEmpty());
		assertEquals(0, descricaoDoTeste.getChildren().size());
		assertEquals(1, descricaoDoTeste.testCount());
	}

	@Test
	public void comBefore() throws Exception {
		CasoDeTeste casoDeTeste = new CasoDeTeste(UmaConfiguracaoPassandoUmTestePassando.class, "testar", "configurar");
		Description descricaoDoTeste = casoDeTeste.obterDescricao();
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, casoDeTeste.obterClasse());
		assertEquals("testar", casoDeTeste.obterMetodoDeTeste());
		assertEquals("configurar", casoDeTeste.obterMetodoDeConfiguracao());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, descricaoDoTeste.getTestClass());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class.getName(), descricaoDoTeste.getClassName());
		assertEquals("testar", descricaoDoTeste.getMethodName());
		assertFalse(descricaoDoTeste.isSuite());
		assertTrue(descricaoDoTeste.isTest());
		assertFalse(descricaoDoTeste.isEmpty());
		assertEquals(0, descricaoDoTeste.getChildren().size());
		assertEquals(1, descricaoDoTeste.testCount());
	}

}
