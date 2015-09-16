package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.*;
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
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
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
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosZeroConfiguracoesUmTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste.class);
		assertEquals(UmaClasseZeroAcessoriosZeroConfiguracoesUmTeste.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(UmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosUmaConfiguracaoSeisTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(DuasClassesZeroAcessoriosUmaConfiguracaoSeisTestes.class);
		assertEquals(DuasClassesZeroAcessoriosUmaConfiguracaoSeisTestes.class, suite.obterSuite());
		assertEquals(2, suite.obterClassesDeTeste().size());

		assertEquals(TresTestesPassandoIgnoradoFalhando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(2, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertEquals("testarFalhando", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testarPassando", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(1).obterNome());
		assertEquals("testarIgnorado", suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().get(0).obterNome());

		assertEquals(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, suite.obterClassesDeTeste().get(1).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeConfiguracao().size());
		assertEquals(2, suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().size());
		assertEquals("configurar", suite.obterClassesDeTeste().get(1).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar1", suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testar2", suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().get(1).obterNome());
		assertEquals("testar3", suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().get(0).obterNome());
	}

	@Test
	public void classeUmAcessoriosUmaConfiguracaoUmTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class);
		assertEquals(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());

		assertEquals(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(0).obterClasse());
		assertEquals("configurar", suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

}
