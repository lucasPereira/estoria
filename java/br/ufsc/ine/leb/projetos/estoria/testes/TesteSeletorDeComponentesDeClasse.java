package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeComponentesDeClasse;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.DoisTestesPassandoPassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.UmTesteIgnorado;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.UmTestePassandoVazio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.DuasClassesZeroAcessoriosZeroConfiguracoesDoisTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.ZeroClasses;

public final class TesteSeletorDeComponentesDeClasse {

	@Test
	public void vazio() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(ClasseVazia.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals(ClasseVazia.class, seletor.obterClassesDeSuite().get(0));
	}

	@Test
	public void UmTeste() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(UmTestePassando.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
		assertEquals(UmTestePassando.class, seletor.obterClassesDeSuite().get(0));
	}

	@Test
	public void UmTesteIgnorado() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(UmTesteIgnorado.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(1, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals("testar", seletor.obterMetodosDeTesteIgnorados().get(0).getName());
		assertEquals(UmTesteIgnorado.class, seletor.obterClassesDeSuite().get(0));
	}

	@Test
	public void doisTestes() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(DoisTestesPassandoPassando.class);
		assertEquals(2, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals("testar1", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("testar2", seletor.obterMetodosTeste().get(1).getName());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterClassesDeSuite().get(0));
	}

	@Test
	public void umaConfiguracaoUmTeste() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(UmaConfiguracaoPassandoUmTestePassando.class);
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
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, seletor.obterClassesDeSuite().get(0));
	}

	@Test
	public void umaClasseDeSuiteTeste() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(DuasClassesZeroAcessoriosZeroConfiguracoesDoisTestes.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(2, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
		assertEquals(UmTestePassando.class, seletor.obterClassesDeSuite().get(0));
		assertEquals(UmTestePassandoVazio.class, seletor.obterClassesDeSuite().get(1));
	}

	@Test
	public void zeroClassesDeSuiteTeste() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(ZeroClasses.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertEquals(0, seletor.obterAcessorios().size());
		assertEquals(0, seletor.obterAtributosProprios().size());
		assertEquals(0, seletor.obterAtributosAcessorios().size());
	}

	@Test
	public void umAcessorio() throws Exception {
		SeletorDeComponentesDeClasse seletor = new SeletorDeComponentesDeClasse(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(1, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(1, seletor.obterClassesDeSuite().size());
		assertEquals(1, seletor.obterAcessorios().size());
		assertEquals(3, seletor.obterAtributosProprios().size());
		assertEquals(3, seletor.obterAtributosAcessorios().size());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("configurar", seletor.obterMetodosDeConfiguracao().get(0).getName());
		assertEquals("acessorioBefore10", seletor.obterAtributosAcessorios().get(0).getName());
		assertEquals("acessorioBefore20Test30", seletor.obterAtributosAcessorios().get(1).getName());
		assertEquals("acessorioTest40", seletor.obterAtributosAcessorios().get(2).getName());
		assertEquals("meuAcessorioBefore10", seletor.obterAtributosProprios().get(0).getName());
		assertEquals("meuAcessorioBefore20Test30", seletor.obterAtributosProprios().get(1).getName());
		assertEquals("meuAcessorioTest40", seletor.obterAtributosProprios().get(2).getName());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, seletor.obterAcessorios().get(0));
		assertEquals(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class, seletor.obterClassesDeSuite().get(0));
	}

}
