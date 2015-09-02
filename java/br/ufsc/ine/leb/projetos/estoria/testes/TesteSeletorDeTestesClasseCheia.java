package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.CasoDeTeste;
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
		List<CasoDeTeste> casosDeTeste = seletor.obterCasosDeTeste();
		assertEquals(5, casosDeTeste.size());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(0).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(1).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(2).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(3).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(4).obterClasse());
		assertEquals("metodoDeConfiguracaoComTest", casosDeTeste.get(0).obterMetodoDeTeste());
		assertEquals("metodoDeTeste", casosDeTeste.get(1).obterMetodoDeTeste());
		assertEquals("metodoDeTesteComExcecao", casosDeTeste.get(2).obterMetodoDeTeste());
		assertEquals("metodoDeTesteEstritoDePontoFlutuante", casosDeTeste.get(3).obterMetodoDeTeste());
		assertEquals("metodoDeTesteFinal", casosDeTeste.get(4).obterMetodoDeTeste());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(0).obterMetodoDeConfiguracao());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(1).obterMetodoDeConfiguracao());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(2).obterMetodoDeConfiguracao());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(3).obterMetodoDeConfiguracao());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(4).obterMetodoDeConfiguracao());
	}

	@Test
	public void selecoesDeTesteIgnorados() throws Exception {
		List<CasoDeTeste> casosDeTeste = seletor.obterCasosDeTesteIgnorados();
		assertEquals(3, casosDeTeste.size());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(0).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(1).obterClasse());
		assertEquals(ClasseCheiaDeMetodosDeTeste.class, casosDeTeste.get(2).obterClasse());
		assertEquals("metodoDeConfiguracaoComIgnoreTest", casosDeTeste.get(0).obterMetodoDeTeste());
		assertEquals("metodoNaoTesteAnotadoComIgnoreTest", casosDeTeste.get(1).obterMetodoDeTeste());
		assertEquals("metodoNaoTesteAnotadoComTestIgnore", casosDeTeste.get(2).obterMetodoDeTeste());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(0).obterMetodoDeConfiguracao());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(1).obterMetodoDeConfiguracao());
		assertEquals("metodoDeConfiguracao", casosDeTeste.get(2).obterMetodoDeConfiguracao());
	}

}
