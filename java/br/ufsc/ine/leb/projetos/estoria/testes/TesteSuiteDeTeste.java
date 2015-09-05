package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites.ZeroClasses;

public final class TesteSuiteDeTeste {

	@Test
	public void suiteZeroClasses() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ZeroClasses.class);
		assertEquals(0, suite.obterClassesDeTeste().size());
	}

	@Test
	public void suiteUmaClasseZeroAcessoriosZeroTestesZeroConfiguracoes() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(UmaClasseZeroAcessoriosZeroConfiguracoesZeroTestes.class);
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeTeste().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterMetodosDeConfiguracao().size());
		assertEquals(0, suite.obterClassesDeTeste().get(0).obterAcessorios().size());
	}

}
