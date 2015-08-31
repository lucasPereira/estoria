package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheiaDeMetodosDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisMetodosDeTestePassandoPassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassando;

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
		seletor.adicionarClasse(ClasseComUmMetodoDeTestePassando.class);
		assertEquals(1, seletor.obterSelecoes().size());
		assertEquals(0, seletor.obterSelecoesIgnoradas().size());
		assertEquals(ClasseComUmMetodoDeTestePassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals("testar", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseComDoisMetodosDeTeste() throws Exception {
		seletor.adicionarClasse(ClasseComDoisMetodosDeTestePassandoPassando.class);
		assertEquals(2, seletor.obterSelecoes().size());
		assertEquals(0, seletor.obterSelecoesIgnoradas().size());
		assertEquals(ClasseComDoisMetodosDeTestePassandoPassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals(ClasseComDoisMetodosDeTestePassandoPassando.class, seletor.obterSelecoes().get(1).obterClasse());
		assertEquals("testar1", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterSelecoes().get(1).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseCheiaSelecoes() throws Exception {
		seletor.adicionarClasse(ClasseCheiaDeMetodosDeTeste.class);
		assertEquals(4, seletor.obterSelecoes().size());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, seletor.obterSelecoes().get(1).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, seletor.obterSelecoes().get(2).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, seletor.obterSelecoes().get(3).obterClasse());
		assertEquals("metodoDeTeste", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
		assertEquals("metodoDeTesteComExcecao", seletor.obterSelecoes().get(1).obterMetodoDeTeste());
		assertEquals("metodoDeTesteEstritoDePontoFlutuante", seletor.obterSelecoes().get(2).obterMetodoDeTeste());
		assertEquals("metodoDeTesteFinal", seletor.obterSelecoes().get(3).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseCheiaSelecoesIgnoradas() throws Exception {
		seletor.adicionarClasse(ClasseCheiaDeMetodosDeTeste.class);
		assertEquals(2, seletor.obterSelecoesIgnoradas().size());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, seletor.obterSelecoesIgnoradas().get(0).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, seletor.obterSelecoesIgnoradas().get(1).obterClasse());
		assertEquals("metodoNaoTesteAnotadoComIgnoreTest", seletor.obterSelecoesIgnoradas().get(0).obterMetodoDeTeste());
		assertEquals("metodoNaoTesteAnotadoComTestIgnore", seletor.obterSelecoesIgnoradas().get(1).obterMetodoDeTeste());
	}

	@Test
	public void adicionarDuasClasses() throws Exception {
		seletor.adicionarClasse(ClasseComDoisMetodosDeTestePassandoPassando.class);
		seletor.adicionarClasse(ClasseComUmMetodoDeTestePassando.class);
		assertEquals(3, seletor.obterSelecoes().size());
		assertEquals(ClasseComDoisMetodosDeTestePassandoPassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals(ClasseComDoisMetodosDeTestePassandoPassando.class, seletor.obterSelecoes().get(1).obterClasse());
		assertEquals(ClasseComUmMetodoDeTestePassando.class, seletor.obterSelecoes().get(2).obterClasse());
		assertEquals("testar1", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
		assertEquals("testar2", seletor.obterSelecoes().get(1).obterMetodoDeTeste());
		assertEquals("testar", seletor.obterSelecoes().get(2).obterMetodoDeTeste());
	}

}
