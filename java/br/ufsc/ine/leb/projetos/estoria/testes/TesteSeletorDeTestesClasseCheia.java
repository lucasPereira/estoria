package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SeletorDeComponentesDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheiaDeMetodosDeTeste;

public final class TesteSeletorDeTestesClasseCheia {

	private SeletorDeComponentesDeTestes seletor;

	@Before
	public void prepararCenario() {
		seletor = new SeletorDeComponentesDeTestes(ClasseCheiaDeMetodosDeTeste.class);
	}

	@Test
	public void metodosDeTeste() throws Exception {
		List<Method> metodos = seletor.obterMetodosTeste();
		assertEquals(5, metodos.size());
		assertEquals("metodoDeConfiguracaoComTest", metodos.get(0).getName());
		assertEquals("metodoDeTeste", metodos.get(1).getName());
		assertEquals("metodoDeTesteComExcecao", metodos.get(2).getName());
		assertEquals("metodoDeTesteEstritoDePontoFlutuante", metodos.get(3).getName());
		assertEquals("metodoDeTesteFinal", metodos.get(4).getName());
	}

	@Test
	public void metodosDeTesteIgnorados() throws Exception {
		List<Method> metodos = seletor.obterMetodosDeTesteIgnorados();
		assertEquals(3, metodos.size());
		assertEquals("metodoDeConfiguracaoComIgnoreTest", metodos.get(0).getName());
		assertEquals("metodoNaoTesteAnotadoComIgnoreTest", metodos.get(1).getName());
		assertEquals("metodoNaoTesteAnotadoComTestIgnore", metodos.get(2).getName());
	}

	@Test
	public void metodosDeConfiguracao() throws Exception {
		List<Method> metodos = seletor.obterMetodosDeConfiguracao();
		assertEquals(4, metodos.size());
		assertEquals("metodoDeConfiguracao", metodos.get(0).getName());
		assertEquals("metodoDeConfiguracaoComIgnore", metodos.get(1).getName());
		assertEquals("metodoDeConfiguracaoComIgnoreTest", metodos.get(2).getName());
		assertEquals("metodoDeConfiguracaoComTest", metodos.get(3).getName());
	}

	@Test
	public void classesDeSuite() throws Exception {
		assertEquals(0, seletor.obterClassesDeSuite().size());
		assertFalse(seletor.possuiAnotacaoClassesDeSuite());
	}

}
