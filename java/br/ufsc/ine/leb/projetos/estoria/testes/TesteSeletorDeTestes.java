package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisMetodosDeTestePassando;
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
	}

	@Test
	public void adicionarUmaClasseComUmMetodoDeTeste() throws Exception {
		seletor.adicionarClasse(ClasseComUmMetodoDeTestePassando.class);
		assertEquals(1, seletor.obterSelecoes().size());
		assertEquals(ClasseComUmMetodoDeTestePassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals("testar", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
	}

	@Test
	public void adicionarUmaClasseComDoisMetodosDeTeste() throws Exception {
		seletor.adicionarClasse(ClasseComDoisMetodosDeTestePassando.class);
		assertEquals(2, seletor.obterSelecoes().size());
		assertEquals(ClasseComDoisMetodosDeTestePassando.class, seletor.obterSelecoes().get(0).obterClasse());
		assertEquals("testar1", seletor.obterSelecoes().get(0).obterMetodoDeTeste());
		assertEquals(ClasseComDoisMetodosDeTestePassando.class, seletor.obterSelecoes().get(1).obterClasse());
		assertEquals("testar2", seletor.obterSelecoes().get(1).obterMetodoDeTeste());
	}

}
