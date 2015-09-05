package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeComponentesDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseSemMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.DoisTestesPassandoPassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTesteIgnorado;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassandoVazio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.DuasClassesZeroAcessoriosZeroConfiguracoesDoisTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.ZeroClasses;;

public final class TesteSeletorDeTestes {

	@Test
	public void vazio() throws Exception {
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(ClasseSemMetodos.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertFalse(seletor.possuiAnotacaoClassesDeSuite());
	}

	@Test
	public void UmTeste() throws Exception {
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(UmTestePassando.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertFalse(seletor.possuiAnotacaoClassesDeSuite());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
	}

	@Test
	public void UmTesteIgnorado() throws Exception {
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(UmTesteIgnorado.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(1, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertFalse(seletor.possuiAnotacaoClassesDeSuite());
		assertEquals("testar", seletor.obterMetodosDeTesteIgnorados().get(0).getName());
	}

	@Test
	public void doisTestes() throws Exception {
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(DoisTestesPassandoPassando.class);
		assertEquals(2, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertFalse(seletor.possuiAnotacaoClassesDeSuite());
		assertEquals("testar1", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("testar2", seletor.obterMetodosTeste().get(1).getName());
	}

	@Test
	public void umaConfiguracaoUmTeste() throws Exception {
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(UmaConfiguracaoPassandoUmTestePassando.class);
		assertEquals(1, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(1, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertFalse(seletor.possuiAnotacaoClassesDeSuite());
		assertEquals("testar", seletor.obterMetodosTeste().get(0).getName());
		assertEquals("configurar", seletor.obterMetodosDeConfiguracao().get(0).getName());
	}

	@Test
	public void umaClasseDeSuiteTeste() throws Exception {
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(DuasClassesZeroAcessoriosZeroConfiguracoesDoisTestes.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(2, seletor.obterClassesDeSuite().size());
		assertTrue(seletor.possuiAnotacaoClassesDeSuite());
		assertEquals(UmTestePassando.class, seletor.obterClassesDeSuite().get(0));
		assertEquals(UmTestePassandoVazio.class, seletor.obterClassesDeSuite().get(1));
	}

	@Test
	public void zeroClassesDeSuiteTeste() throws Exception {
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(ZeroClasses.class);
		assertEquals(0, seletor.obterMetodosTeste().size());
		assertEquals(0, seletor.obterMetodosDeTesteIgnorados().size());
		assertEquals(0, seletor.obterMetodosDeConfiguracao().size());
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertTrue(seletor.possuiAnotacaoClassesDeSuite());
	}

}
