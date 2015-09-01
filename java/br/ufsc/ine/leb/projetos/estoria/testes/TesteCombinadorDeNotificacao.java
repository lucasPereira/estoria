package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.Description;

import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.NotificacaoTesteIniciado;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.SuiteDoJUnitUmaClasseUmMetodoDeTeste;

public final class TesteCombinadorDeNotificacao {

	private Notificacao testeIniciado;
	private Notificacao testeFinalizado;
	private Notificacao testesIniciados;

	@Rule public ExpectedException excecao = ExpectedException.none();

	@Before
	public void prepararCenario() {
		Description descricaoDoTeste = Description.createTestDescription(UmTestePassando.class, "testar");
		Description descricaoDaSuite = Description.createSuiteDescription(SuiteDoJUnitUmaClasseUmMetodoDeTeste.class);
		descricaoDaSuite.addChild(descricaoDoTeste);
		testeIniciado = new Notificacao(TipoDeNotificacao.TESTE_INICIADO, descricaoDoTeste);
		testeFinalizado = new Notificacao(TipoDeNotificacao.TESTE_FINALIZADO, descricaoDoTeste);
		testesIniciados = new Notificacao(TipoDeNotificacao.TESTES_INICIADOS, descricaoDaSuite);
	}

	@Test
	public void combinaIniciado() throws Exception {
		assertThat(testeIniciado, new NotificacaoTesteIniciado(UmTestePassando.class, "testar"));
	}

	@Test
	public void naoCombinaIniciadoComIniciadoFalhando() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassando.testarFalhando");
		excecao.expectMessage("but: <TESTE_INICIADO> UmTestePassando.testar");
		assertThat(testeIniciado, new NotificacaoTesteIniciado(UmTestePassando.class, "testarFalhando"));
	}

	@Test
	public void naoCombinaIniciadoComFinalizado() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassando.testar");
		excecao.expectMessage("but: <TESTE_FINALIZADO> UmTestePassando.testar");
		assertThat(testeFinalizado, new NotificacaoTesteIniciado(UmTestePassando.class, "testar"));
	}

	@Test
	public void naoCombinaIniciadoComIniciados() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassando.testar");
		excecao.expectMessage("but: <TESTES_INICIADOS> UmTestePassando.class");
		assertThat(testesIniciados, new NotificacaoTesteIniciado(UmTestePassando.class, "testar"));
	}

}
