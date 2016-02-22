package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste111;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste112;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste116;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste130;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste131;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste132;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste133;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste135;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste11;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste12;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste13;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste17;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste18;

public final class TesteSuiteDeTeste {

	@Test
	public void classeZeroAcessoriosZeroConfiguracoesUmTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste101.class);
		assertEquals(ClasseDeTeste101.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseDeTeste101.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void suiteZeroClasses() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste11.class);
		assertEquals(SuiteDeTeste11.class, suite.obterSuite());
		assertEquals(0, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste12.class);
		assertEquals(SuiteDeTeste12.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseVazia.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosZeroConfiguracoesUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste13.class);
		assertEquals(SuiteDeTeste13.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseDeTeste101.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosUmaConfiguracaoSeisTestes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste17.class);
		assertEquals(SuiteDeTeste17.class, suite.obterSuite());
		assertEquals(2, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseDeTeste111.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(2, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals("testar1", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testar3", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(1).obterNome());
		assertEquals("testar2", suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().get(0).obterNome());

		assertEquals(ClasseDeTeste116.class, suite.obterClassesDeTeste().get(1).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeConfiguracao().size());
		assertEquals(2, suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals("numero", suite.obterClassesDeTeste().get(1).obterAtributosProprios().get(0).obterNome());
		assertEquals("configurar", suite.obterClassesDeTeste().get(1).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar1", suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testar2", suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().get(1).obterNome());
		assertEquals("testar3", suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().get(0).obterNome());
	}

	@Test
	public void suiteIgnoradaUmaClasseUmaClasseIgnoradaDoisTestesUmTesteIgnorado() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste18.class);
		assertEquals(SuiteDeTeste18.class, suite.obterSuite());
		assertEquals(2, suite.obterClassesDeTeste().size());
		assertTrue(suite.ignorada());

		assertEquals(ClasseDeTeste101.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());

		assertEquals(ClasseDeTeste135.class, suite.obterClassesDeTeste().get(1).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(1).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(1).singular());
		assertTrue(suite.obterClassesDeTeste().get(1).ignorada());
		assertEquals("testar1", suite.obterClassesDeTeste().get(1).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testar2", suite.obterClassesDeTeste().get(1).obterMetodosDeTesteIgnorados().get(0).obterNome());
	}

	@Test
	public void classeUmAcessorioUmaConfiguracaoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste119.class);
		assertEquals(ClasseDeTeste119.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseDeTeste119.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(3, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(3, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals(ClasseDeTeste112.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(0).obterClasse());
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
	public void classeSingularUmaConfiguracaoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste130.class);
		assertEquals(ClasseDeTeste130.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseDeTeste130.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertTrue(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals("numeros", suite.obterClassesDeTeste().get(0).obterAtributosProprios().get(0).obterNome());
		assertEquals("configurar", suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void classeUmAcessorioCompartilhadoUmaConfiguracaoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste131.class);
		assertEquals(ClasseDeTeste131.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseDeTeste131.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals(ClasseDeTeste130.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(0).obterClasse());
		assertEquals("numeros", suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().get(0).obterNome());
		assertEquals("configurar", suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void classeDoisAcessoriosUmAcessorioIndiretoCompartilhadoUmTeste() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste133.class);
		assertEquals(ClasseDeTeste133.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());

		assertEquals(ClasseDeTeste133.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(2, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertFalse(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals(ClasseDeTeste131.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(0).obterClasse());
		assertEquals(ClasseDeTeste132.class, suite.obterClassesDeTeste().get(0).obterAcessorios().get(1).obterClasse());
		assertEquals("numeros", suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().get(0).obterNome());
		assertEquals("testar", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
	}

	@Test
	public void classeIgnoradaUmTesteUmTesteIgnorado() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste135.class);
		assertEquals(ClasseDeTeste135.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertTrue(suite.ignorada());

		assertEquals(ClasseDeTeste135.class, suite.obterClassesDeTeste().get(0).obterClasse());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosProprios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAtributosAcessorios().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(1, suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().size());
		assertFalse(suite.obterClassesDeTeste().get(0).singular());
		assertTrue(suite.obterClassesDeTeste().get(0).ignorada());
		assertEquals("testar1", suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().get(0).obterNome());
		assertEquals("testar2", suite.obterClassesDeTeste().get(0).obterMetodosDeTesteIgnorados().get(0).obterNome());
	}

}
