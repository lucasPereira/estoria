package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.DoisTestesPassandoPassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassando;

public final class TesteSeletorDeTestes {

	private SeletorDeTestes seletor;

	@Before
	public void prepararCenario() {
		seletor = new SeletorDeTestes();
	}

	@Test
	public void vazio() throws Exception {
		assertEquals(0, seletor.obterSelecoesDeTeste().size());
		assertEquals(0, seletor.obterSelecoesDeTesteIgnorados().size());
	}

	@Test
	public void adicionarUmaClasseComUmMetodoDeTeste() throws Exception {
		seletor.adicionarClasse(UmTestePassando.class);
		assertEquals(1, seletor.obterSelecoesDeTeste().size());
		assertEquals(0, seletor.obterSelecoesDeTesteIgnorados().size());
		assertEquals(UmTestePassando.class, seletor.obterSelecoesDeTeste().get(0).obterClasse());
		assertEquals("testar", seletor.obterSelecoesDeTeste().get(0).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseComDoisMetodosDeTeste() throws Exception {
		seletor.adicionarClasse(DoisTestesPassandoPassando.class);
		assertEquals(2, seletor.obterSelecoesDeTeste().size());
		assertEquals(0, seletor.obterSelecoesDeTesteIgnorados().size());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoesDeTeste().get(0).obterClasse());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoesDeTeste().get(1).obterClasse());
		assertEquals("testar1", seletor.obterSelecoesDeTeste().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterSelecoesDeTeste().get(1).obterMetodoDeTeste());
	}

	@Test
	public void adicionarDuasClasses() throws Exception {
		seletor.adicionarClasse(DoisTestesPassandoPassando.class);
		seletor.adicionarClasse(UmTestePassando.class);
		assertEquals(3, seletor.obterSelecoesDeTeste().size());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoesDeTeste().get(0).obterClasse());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoesDeTeste().get(1).obterClasse());
		assertEquals(UmTestePassando.class, seletor.obterSelecoesDeTeste().get(2).obterClasse());
		assertEquals("testar1", seletor.obterSelecoesDeTeste().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterSelecoesDeTeste().get(1).obterMetodoDeTeste());
		assertEquals("testar", seletor.obterSelecoesDeTeste().get(2).obterMetodoDeTeste());
	}

}
