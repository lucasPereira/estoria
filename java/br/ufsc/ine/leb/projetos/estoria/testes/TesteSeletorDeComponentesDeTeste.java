package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeComponentesDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste103;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste104;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste110;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste112;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste130;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste11;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste15;

public final class TesteSeletorDeComponentesDeTeste {

	@Test
	public void vazio() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(ClasseVazia.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals(ClasseVazia.class, seletor.obterClassesDeSuite().get(0));
		assertFalse(seletor.classeSingular());
	}

	@Test
	public void UmTeste() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(ClasseDeTeste101.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
		assertEquals(ClasseDeTeste101.class, seletor.obterClassesDeSuite().get(0));
		assertFalse(seletor.classeSingular());
	}

	@Test
	public void UmTesteIgnorado() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(ClasseDeTeste103.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(1, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals("testar", seletor.obterMetodosDeTesteIgnorados().get(0).getName());
		assertEquals(ClasseDeTeste103.class, seletor.obterClassesDeSuite().get(0));
		assertFalse(seletor.classeSingular());
	}

	@Test
	public void doisTestes() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(ClasseDeTeste110.class);
		assertEquals(2, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals("testar1", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("testar2", seletor.obterMetodosTeste().get(1).getName());
		assertEquals(ClasseDeTeste110.class, seletor.obterClassesDeSuite().get(0));
		assertFalse(seletor.classeSingular());
	}

	@Test
	public void umaConfiguracaoUmTeste() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(ClasseDeTeste112.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(1, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(3, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("configurar", seletor.obterMetodosDeConfiguracao().get(0).getName());
		assertEquals("acessorioBefore10", seletor.obterAtributosProprios().get(0).getName());
		assertEquals("acessorioBefore20Test30", seletor.obterAtributosProprios().get(1).getName());
		assertEquals("acessorioTest40", seletor.obterAtributosProprios().get(2).getName());
		assertEquals(ClasseDeTeste112.class, seletor.obterClassesDeSuite().get(0));
		assertFalse(seletor.classeSingular());
	}

	@Test
	public void umaClasseDeSuiteTeste() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(SuiteDeTeste15.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(2, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals(ClasseDeTeste101.class, seletor.obterClassesDeSuite().get(0));
		assertEquals(ClasseDeTeste104.class, seletor.obterClassesDeSuite().get(1));
		assertFalse(seletor.classeSingular());
	}

	@Test
	public void zeroClassesDeSuiteTeste() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(SuiteDeTeste11.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertFalse(seletor.classeSingular());
	}

	@Test
	public void umAcessorio() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(ClasseDeTeste119.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(1, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(1, seletor.obterAcessorios().size());
		assertEquals(3, seletor.obterAtributosProprios().size());
		assertEquals(3, seletor.obterAtributosAcessorios().size());
		assertFalse(seletor.classeSingular());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("configurar", seletor.obterMetodosDeConfiguracao().get(0).getName());
		assertEquals("acessorioBefore10", seletor.obterAtributosAcessorios().get(0).getName());
		assertEquals("acessorioBefore20Test30", seletor.obterAtributosAcessorios().get(1).getName());
		assertEquals("acessorioTest40", seletor.obterAtributosAcessorios().get(2).getName());
		assertEquals("meuAcessorioBefore10", seletor.obterAtributosProprios().get(0).getName());
		assertEquals("meuAcessorioBefore20Test30", seletor.obterAtributosProprios().get(1).getName());
		assertEquals("meuAcessorioTest40", seletor.obterAtributosProprios().get(2).getName());
		assertEquals(ClasseDeTeste112.class, seletor.obterAcessorios().get(0));
		assertEquals(ClasseDeTeste119.class, seletor.obterClassesDeSuite().get(0));
	}

	@Test
	public void classeCompartilhada() throws Exception {
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(ClasseDeTeste130.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(1, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(1, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertTrue(seletor.classeSingular());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("configurar", seletor.obterMetodosDeConfiguracao().get(0).getName());
		assertEquals("numeros", seletor.obterAtributosProprios().get(0).getName());
	}

}
