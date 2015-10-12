package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorioIndireto.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesCompartilhadas.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.TresTestesPassandoIgnoradoFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.DuasClassesZeroAcessoriosUmaConfiguracaoSeisTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.ZeroClasses;

public final class TesteSuiteDeTeste {

	@Test
	public void classeZeroAcessoriosZeroConfiguracoesUmTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmTestePassando.class);
		assertEquals(UmTestePassando.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(UmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void suiteZeroClasses() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ZeroClasses.class);
		assertEquals(ZeroClasses.class, suite.obterSuite());
		assertEquals(0, suite.obterClassesDeTeste().size());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes.class);
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(ClasseVazia.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosZeroConfiguracoesUmTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste.class);
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(UmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosUmaConfiguracaoSeisTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(DuasClassesZeroAcessoriosUmaConfiguracaoSeisTestes.class);
		assertEquals(DuasClassesZeroAcessoriosUmaConfiguracaoSeisTestes.class, suite.obterSuite());
		assertEquals(2, suite.obterClassesDeTeste().size());

		assertEquals(TresTestesPassandoIgnoradoFalhando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(2, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals("testarFalhando", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testarPassando", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(1).obterNome());
		assertEquals("testarIgnorado", suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().get(0).obterNome());

		assertEquals(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, suite.obterClassesDeTeste().get(1).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeConfiguracao().size());
		assertEquals(2, suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals("numero", suite.obterClassesDeTeste().get(1).obterAtributosProprios().get(0).obterNome());
		assertEquals("configurar", suite.obterClassesDeTeste().get(1).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar1", suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testar2", suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().get(1).obterNome());
		assertEquals("testar3", suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().get(0).obterNome());
	}

	@Test
	public void classeUmAcessorioUmaConfiguracaoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class);
		assertEquals(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(3, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(3, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(0).obterClasse());
		assertEquals("meuAcessorioBefore10", suite.obterClassesDeTeste().get(0).obterAtributosProprios().get(0).obterNome());
		assertEquals("meuAcessorioBefore20Test30", suite.obterClassesDeTeste().get(0).obterAtributosProprios().get(1).obterNome());
		assertEquals("meuAcessorioTest40", suite.obterClassesDeTeste().get(0).obterAtributosProprios().get(2).obterNome());
		assertEquals("acessorioBefore10", suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().get(0).obterNome());
		assertEquals("acessorioBefore20Test30", suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().get(1).obterNome());
		assertEquals("acessorioTest40", suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().get(2).obterNome());
		assertEquals("configurar", suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void classeCompartilhadaUmaConfiguracaoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(CompartilhadaUmaConfiguracaoPassandoUmTestePassando.class);
		assertEquals(CompartilhadaUmaConfiguracaoPassandoUmTestePassando.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(CompartilhadaUmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertTrue(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals("numeros", suite.obterClassesDeTeste().get(0).obterAtributosProprios().get(0).obterNome());
		assertEquals("configurar", suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void classeUmAcessorioCompartilhadoUmaConfiguracaoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTestePassando.class);
		assertEquals(UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTestePassando.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals(CompartilhadaUmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(0).obterClasse());
		assertEquals("numeros", suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().get(0).obterNome());
		assertEquals("configurar", suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void classeDoisAcessoriosUmAcessorioIndiretoCompartilhadoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(DoisAcessoriosPassandoPassandoUmAcessorioIndiretoCompartilhadoPassandoUmTestePassando.class);
		assertEquals(DoisAcessoriosPassandoPassandoUmAcessorioIndiretoCompartilhadoPassandoUmTestePassando.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(DoisAcessoriosPassandoPassandoUmAcessorioIndiretoCompartilhadoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(2, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).compartilhada());
		assertEquals(UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(0).obterClasse());
		assertEquals(UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTesteFalhando.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(1).obterClasse());
		assertEquals("numeros", suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

}
