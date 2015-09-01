package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.VariosMetodosDeTeste;
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
		assertEquals(0, seletor.obterSelecoes().size());
		assertEquals(0, seletor.obterSelecoesIgnoradas().size());
	}

	@Test
	public void adicionarUmaClasseComUmMetodoDeTeste() throws Exception {
		seletor.adicionarClasse(UmTestePassando.class);
		assertEquals(1, seletor.obterSelecoes().size());
		assertEquals(0, seletor.obterSelecoesIgnoradas().size());
		assertEquals(UmTestePassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals("testar", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseComDoisMetodosDeTeste() throws Exception {
		seletor.adicionarClasse(DoisTestesPassandoPassando.class);
		assertEquals(2, seletor.obterSelecoes().size());
		assertEquals(0, seletor.obterSelecoesIgnoradas().size());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoes().get(1).obterClasse());
		assertEquals("testar1", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterSelecoes().get(1).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseCheiaSelecoes() throws Exception {
		seletor.adicionarClasse(VariosMetodosDeTeste.class);
		assertEquals(4, seletor.obterSelecoes().size());
		assertEquals(VariosMetodosDeTeste.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals(VariosMetodosDeTeste.class, seletor.obterSelecoes().get(1).obterClasse());
		assertEquals(VariosMetodosDeTeste.class, seletor.obterSelecoes().get(2).obterClasse());
		assertEquals(VariosMetodosDeTeste.class, seletor.obterSelecoes().get(3).obterClasse());
		assertEquals("metodoDeTeste", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
		assertEquals("metodoDeTesteComExcecao", seletor.obterSelecoes().get(1).obterMetodoDeTeste());
		assertEquals("metodoDeTesteEstritoDePontoFlutuante", seletor.obterSelecoes().get(2).obterMetodoDeTeste());
		assertEquals("metodoDeTesteFinal", seletor.obterSelecoes().get(3).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseCheiaSelecoesIgnoradas() throws Exception {
		seletor.adicionarClasse(VariosMetodosDeTeste.class);
		assertEquals(2, seletor.obterSelecoesIgnoradas().size());
		assertEquals(VariosMetodosDeTeste.class, seletor.obterSelecoesIgnoradas().get(0).obterClasse());
		assertEquals(VariosMetodosDeTeste.class, seletor.obterSelecoesIgnoradas().get(1).obterClasse());
		assertEquals("metodoNaoTesteAnotadoComIgnoreTest", seletor.obterSelecoesIgnoradas().get(0).obterMetodoDeTeste());
		assertEquals("metodoNaoTesteAnotadoComTestIgnore", seletor.obterSelecoesIgnoradas().get(1).obterMetodoDeTeste());
	}

	@Test
	public void adicionarDuasClasses() throws Exception {
		seletor.adicionarClasse(DoisTestesPassandoPassando.class);
		seletor.adicionarClasse(UmTestePassando.class);
		assertEquals(3, seletor.obterSelecoes().size());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals(DoisTestesPassandoPassando.class, seletor.obterSelecoes().get(1).obterClasse());
		assertEquals(UmTestePassando.class, seletor.obterSelecoes().get(2).obterClasse());
		assertEquals("testar1", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterSelecoes().get(1).obterMetodoDeTeste());
		assertEquals("testar", seletor.obterSelecoes().get(2).obterMetodoDeTeste());
	}

}
