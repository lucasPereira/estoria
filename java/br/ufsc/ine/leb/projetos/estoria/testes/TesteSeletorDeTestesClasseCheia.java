package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SelecaoDeTeste;
import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheiaDeMetodosDeTeste;

public final class TesteSeletorDeTestesClasseCheia {

	private SeletorDeTestes seletor;

	@Before
	public void prepararCenario() {
		seletor = new SeletorDeTestes();
		seletor.adicionarClasse(ClasseCheiaDeMetodosDeTeste.class);
	}

	@Test
	public void selecoesDeTeste() throws Exception {
		List<SelecaoDeTeste> selecoes = seletor.obterSelecoesDeTeste();
		assertEquals(5, selecoes.size());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(0).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(1).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(2).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(3).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(4).obterClasse());
		assertEquals("metodoDeConfiguracaoComTest", selecoes.get(0).obterMetodoDeTeste());
		assertEquals("metodoDeTeste", selecoes.get(1).obterMetodoDeTeste());
		assertEquals("metodoDeTesteComExcecao", selecoes.get(2).obterMetodoDeTeste());
		assertEquals("metodoDeTesteEstritoDePontoFlutuante", selecoes.get(3).obterMetodoDeTeste());
		assertEquals("metodoDeTesteFinal", selecoes.get(4).obterMetodoDeTeste());
	}

	@Test
	public void selecoesDeTesteIgnorados() throws Exception {
		List<SelecaoDeTeste> selecoes = seletor.obterSelecoesDeTesteIgnorados();
		assertEquals(3, selecoes.size());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(0).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(1).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(2).obterClasse());
		assertEquals("metodoDeConfiguracaoComIgnoreTest", selecoes.get(0).obterMetodoDeTeste());
		assertEquals("metodoNaoTesteAnotadoComIgnoreTest", selecoes.get(1).obterMetodoDeTeste());
		assertEquals("metodoNaoTesteAnotadoComTestIgnore", selecoes.get(2).obterMetodoDeTeste());
	}

	@Test
	public void selecoesDeConfiguracao() throws Exception {
		List<SelecaoDeTeste> selecoes = seletor.obterSelecoesDeConfiguracao();
		assertEquals(4, selecoes.size());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(0).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(1).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(2).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, selecoes.get(3).obterClasse());
		assertEquals("metodoDeConfiguracao", selecoes.get(0).obterMetodoDeTeste());
		assertEquals("metodoDeConfiguracaoComIgnore", selecoes.get(1).obterMetodoDeTeste());
		assertEquals("metodoDeConfiguracaoComIgnoreTest", selecoes.get(2).obterMetodoDeTeste());
		assertEquals("metodoDeConfiguracaoComTest", selecoes.get(3).obterMetodoDeTeste());
	}

}
