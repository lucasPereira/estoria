package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.ExecutorDeTeste;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTesteFalhandoExcecaoEsperada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTesteFalhandoExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTestePassandoExcecaoEsperada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTestePassandoVazio;

public class TesteExecutorDeTeste {

	private ExecutorDeTeste executor;
	private EspiaoDeEscolta espiaoDeEscolta;

	@Before
	public void prepararCenario() {
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addListener(espiaoDeEscolta);
		executor = new ExecutorDeTeste(mensageiroDeEscolta);
	}

	@Test
	public void passando() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTestePassando.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmMetodoDeTestePassando.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTestePassando.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoVazio() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTestePassandoVazio.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmMetodoDeTestePassandoVazio.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTestePassandoVazio.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoExcecaoEsperada() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTestePassandoExcecaoEsperada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmMetodoDeTestePassandoExcecaoEsperada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTestePassandoExcecaoEsperada.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoExcecaoEsperadaExcecaoLancada() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void falhando() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTesteFalhando.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmMetodoDeTesteFalhando.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTesteFalhando.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmMetodoDeTesteFalhando.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("expected:<10> but was:<20>", notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

	@Test
	public void falhandoExcecaoEsperada() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTesteFalhandoExcecaoEsperada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoEsperada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoEsperada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoEsperada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("expected exception:<java.lang.UnsupportedOperationException>", notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

	@Test
	public void falhandoExcecaoEsperadaExcecaoLancada() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("unexpected exception, expected:<java.lang.UnsupportedOperationException> but was:<java.lang.RuntimeException>", notificacoes.get(1).obterFalha().getMessage());
		assertEquals(RuntimeException.class, notificacoes.get(1).obterFalha().getException().getCause().getClass());
	}

	@Test
	public void falhandoExcecaoLancada() throws Exception {
		executor.executar(Description.createTestDescription(UmMetodoDeTesteFalhandoExcecaoLancada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoLancada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmMetodoDeTesteFalhandoExcecaoLancada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(UnsupportedOperationException.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertNull(notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

}
