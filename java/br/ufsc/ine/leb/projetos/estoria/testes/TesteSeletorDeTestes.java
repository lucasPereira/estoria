package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.DoisTestesPassandoPassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;

public final class TesteSeletorDeTestes {

	private SeletorDeTestes seletor;

	@Before
	public void prepararCenario() {
		seletor = new SeletorDeTestes();
	}

	@Test
	public void vazio() throws Exception {
		assertEquals(0, seletor.obterCasosDeTeste().size());
		assertEquals(0, seletor.obterCasosDeTesteIgnorados().size());
	}

	@Test
	public void adicionarUmaClasseComUmMetodoDeTeste() throws Exception {
		seletor.adicionarClasse(UmTestePassando.class);
		assertEquals(1, seletor.obterCasosDeTeste().size());
		assertEquals(0, seletor.obterCasosDeTesteIgnorados().size());
		assertEquals(UmTestePassando.class, seletor.obterCasosDeTeste().get(0).obterClasse());
		assertEquals("testar", seletor.obterCasosDeTeste().get(0).obterMetodoDeTeste());
		assertNull(seletor.obterCasosDeTeste().get(0).obterMetodoDeConfiguracao());
	}

	@Test
	public void adicionarUmaClasseComDoisMetodosDeTeste() throws Exception {
		seletor.adicionarClasse(DoisTestesPassandoPassando.class);
		assertEquals(2, seletor.obterCasosDeTeste().size());
		assertEquals(0, seletor.obterCasosDeTesteIgnorados().size());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterCasosDeTeste().get(0).obterClasse());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterCasosDeTeste().get(1).obterClasse());
		assertEquals("testar1", seletor.obterCasosDeTeste().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterCasosDeTeste().get(1).obterMetodoDeTeste());
		assertNull(seletor.obterCasosDeTeste().get(0).obterMetodoDeConfiguracao());
		assertNull(seletor.obterCasosDeTeste().get(1).obterMetodoDeConfiguracao());
	}

	@Test
	public void adicionarDuasClasses() throws Exception {
		seletor.adicionarClasse(DoisTestesPassandoPassando.class);
		seletor.adicionarClasse(UmTestePassando.class);
		assertEquals(3, seletor.obterCasosDeTeste().size());
		assertEquals(0, seletor.obterCasosDeTesteIgnorados().size());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterCasosDeTeste().get(0).obterClasse());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterCasosDeTeste().get(1).obterClasse());
		assertEquals(UmTestePassando.class, seletor.obterCasosDeTeste().get(2).obterClasse());
		assertEquals("testar1", seletor.obterCasosDeTeste().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterCasosDeTeste().get(1).obterMetodoDeTeste());
		assertEquals("testar", seletor.obterCasosDeTeste().get(2).obterMetodoDeTeste());
		assertNull(seletor.obterCasosDeTeste().get(0).obterMetodoDeConfiguracao());
		assertNull(seletor.obterCasosDeTeste().get(1).obterMetodoDeConfiguracao());
		assertNull(seletor.obterCasosDeTeste().get(2).obterMetodoDeConfiguracao());
	}

	@Test
	public void adicionarDuasClassesComBefore() throws Exception {
		seletor.adicionarClasse(UmaConfiguracaoPassandoUmTestePassando.class);
		seletor.adicionarClasse(UmaConfiguracaoPassandoUmTesteFalhando.class);
		assertEquals(2, seletor.obterCasosDeTeste().size());
		assertEquals(0, seletor.obterCasosDeTesteIgnorados().size());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, seletor.obterCasosDeTeste().get(0).obterClasse());
		assertEquals(UmaConfiguracaoPassandoUmTesteFalhando.class, seletor.obterCasosDeTeste().get(1).obterClasse());
		assertEquals("testar", seletor.obterCasosDeTeste().get(0).obterMetodoDeTeste());
		assertEquals("testarDeTesteFalhando", seletor.obterCasosDeTeste().get(1).obterMetodoDeTeste());
		assertEquals("configurar", seletor.obterCasosDeTeste().get(0).obterMetodoDeConfiguracao());
		assertEquals("configurarDeTesteFalhando", seletor.obterCasosDeTeste().get(1).obterMetodoDeConfiguracao());
	}

}
