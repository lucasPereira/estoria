package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassandoVazio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.SuiteDoJUnitUmaClasseUmMetodoDeTeste;

public final class TesteCombinadorDeNotificacao {

	private Notificacao testeIniciado;
	private Notificacao testeFinalizado;
	private Notificacao testesIniciados;
	private Notificacao testeFalha;

	@Rule public ExpectedException excecao = ExpectedException.none();
	private Notificacao testeIgnorado;
	private Notificacao testesFinalizados;

	@Before
	public void prepararCenario() {
		Description descricaoDoTeste = Description.createTestDescription(UmTestePassando.class, "testar");
		Description descricaoDaSuite = Description.createSuiteDescription(SuiteDoJUnitUmaClasseUmMetodoDeTeste.class);
		descricaoDaSuite.addChild(descricaoDoTeste);
		Failure falha = new Failure(descricaoDoTeste, new AssertionError());
		Result resultado = new Result();
		testesIniciados = new Notificacao(TipoDeNotificacao.TESTES_INICIADOS, descricaoDaSuite);
		testeIniciado = new Notificacao(TipoDeNotificacao.TESTE_INICIADO, descricaoDoTeste);
		testeFinalizado = new Notificacao(TipoDeNotificacao.TESTE_FINALIZADO, descricaoDoTeste);
		testeIgnorado = new Notificacao(TipoDeNotificacao.TESTE_IGNORADO, descricaoDoTeste);
		testeFalha = new Notificacao(TipoDeNotificacao.TESTE_FALHA, falha);
		testesFinalizados = new Notificacao(TipoDeNotificacao.TESTES_FINALIZADOS, resultado);
	}

	@Test
	public void combinaIniciados() throws Exception {
		assertThat(testesIniciados, combinaComTestesIniciados(SuiteDoJUnitUmaClasseUmMetodoDeTeste.class));
	}

	@Test
	public void combinaIniciado() throws Exception {
		assertThat(testeIniciado, combinaComTesteIniciado(UmTestePassando.class, "testar"));
	}

	@Test
	public void combinaFinalizado() throws Exception {
		assertThat(testeFinalizado, combinaComTesteFinalizado(UmTestePassando.class, "testar"));
	}

	@Test
	public void combinaIgnorado() throws Exception {
		assertThat(testeIgnorado, combinaComTesteIgnorado(UmTestePassando.class, "testar"));
	}

	@Test
	public void combinaFalha() throws Exception {
		assertThat(testeFalha, combinaComTesteFalha(UmTestePassando.class, "testar", AssertionError.class));
	}

	@Test
	public void combinaFinalizados() throws Exception {
		assertThat(testesFinalizados, combinaComTestesFinalizados(0, 0, 0));
	}

	@Test
	public void naoCombinaIniciadoComIniciadoDeOutraClasse() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassandoVazio.testar");
		excecao.expectMessage("but: <TESTE_INICIADO> UmTestePassando.testar");
		assertThat(testeIniciado, combinaComTesteIniciado(UmTestePassandoVazio.class, "testar"));
	}

	@Test
	public void naoCombinaIniciadoComIniciadoDeOutroMetodo() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassando.testarFalhando");
		excecao.expectMessage("but: <TESTE_INICIADO> UmTestePassando.testar");
		assertThat(testeIniciado, combinaComTesteIniciado(UmTestePassando.class, "testarFalhando"));
	}

	@Test
	public void naoCombinaIniciadoComIniciados() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassando.testar");
		excecao.expectMessage("but: <TESTES_INICIADOS> SuiteDoJUnitUmaClasseUmMetodoDeTeste.class");
		assertThat(testesIniciados, combinaComTesteIniciado(UmTestePassando.class, "testar"));
	}

	@Test
	public void naoCombinaIniciadoComFinalizado() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassando.testar");
		excecao.expectMessage("but: <TESTE_FINALIZADO> UmTestePassando.testar");
		assertThat(testeFinalizado, combinaComTesteIniciado(UmTestePassando.class, "testar"));
	}

	@Test
	public void naoCombinaIniciadoComIgnorado() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_INICIADO> UmTestePassando.testar");
		excecao.expectMessage("but: <TESTE_IGNORADO> UmTestePassando.testar");
		assertThat(testeIgnorado, combinaComTesteIniciado(UmTestePassando.class, "testar"));
	}

	@Test
	public void naoCombinaFalhaComFalhaDeOutraClasse() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_FALHA> UmTestePassandoVazio.testar lança AssertionError.class");
		excecao.expectMessage("but: <TESTE_FALHA> UmTestePassando.testar lança AssertionError.class");
		assertThat(testeFalha, combinaComTesteFalha(UmTestePassandoVazio.class, "testar", AssertionError.class));
	}

	@Test
	public void naoCombinaFalhaComFalhaDeOutroMetodo() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_FALHA> UmTestePassando.testarFalhando lança AssertionError.class");
		excecao.expectMessage("but: <TESTE_FALHA> UmTestePassando.testar lança AssertionError.class");
		assertThat(testeFalha, combinaComTesteFalha(UmTestePassando.class, "testarFalhando", AssertionError.class));
	}

	@Test
	public void naoCombinaFalhaComFalhaDeOutraExcecao() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_FALHA> UmTestePassando.testar lança RuntimeException.class");
		excecao.expectMessage("but: <TESTE_FALHA> UmTestePassando.testar lança AssertionError.class");
		assertThat(testeFalha, combinaComTesteFalha(UmTestePassando.class, "testar", RuntimeException.class));
	}

	@Test
	public void naoCombinaFalhaComIniciado() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTE_FALHA> UmTestePassando.testar lança AssertionError.class");
		excecao.expectMessage("but: <TESTE_INICIADO> UmTestePassando.testar");
		assertThat(testeIniciado, combinaComTesteFalha(UmTestePassando.class, "testar", AssertionError.class));
	}

	@Test
	public void naoCombinaFinalizadosComTestesDiferentes() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTES_FINALIZADOS> 1 executados, 0 falhas, 0 ignorados");
		excecao.expectMessage("but: <TESTES_FINALIZADOS> 0 executados, 0 falhas, 0 ignorados");
		assertThat(testesFinalizados, combinaComTestesFinalizados(1, 0, 0));
	}

	@Test
	public void naoCombinaFinalizadosComFalhasDiferentes() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTES_FINALIZADOS> 0 executados, 1 falhas, 0 ignorados");
		excecao.expectMessage("but: <TESTES_FINALIZADOS> 0 executados, 0 falhas, 0 ignorados");
		assertThat(testesFinalizados, combinaComTestesFinalizados(0, 1, 0));
	}

	@Test
	public void naoCombinaFinalizadosComIgnoradosDiferentes() throws Exception {
		excecao.expect(AssertionError.class);
		excecao.expectMessage("Expected: <TESTES_FINALIZADOS> 0 executados, 0 falhas, 1 ignorados");
		excecao.expectMessage("but: <TESTES_FINALIZADOS> 0 executados, 0 falhas, 0 ignorados");
		assertThat(testesFinalizados, combinaComTestesFinalizados(0, 0, 1));
	}

}
