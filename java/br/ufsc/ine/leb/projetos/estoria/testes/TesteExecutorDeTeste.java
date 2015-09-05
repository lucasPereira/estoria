package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.CasoDeTeste;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.ExecutorDeTeste;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTesteFalhandoExcecaoEsperada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTesteFalhandoExcecaoEsperadaExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTesteFalhandoExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassandoExcecaoEsperada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassandoExcecaoEsperadaExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassandoVazio;

public final class TesteExecutorDeTeste {

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
		executor.executar(new CasoDeTeste(UmTestePassando.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmTestePassando.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTestePassando.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoVazio() throws Exception {
		executor.executar(new CasoDeTeste(UmTestePassandoVazio.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmTestePassandoVazio.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTestePassandoVazio.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoExcecaoEsperada() throws Exception {
		executor.executar(new CasoDeTeste(UmTestePassandoExcecaoEsperada.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmTestePassandoExcecaoEsperada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTestePassandoExcecaoEsperada.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoExcecaoEsperadaExcecaoLancada() throws Exception {
		executor.executar(new CasoDeTeste(UmTestePassandoExcecaoEsperadaExcecaoLancada.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(UmTestePassandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTestePassandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void falhando() throws Exception {
		executor.executar(new CasoDeTeste(UmTesteFalhando.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmTesteFalhando.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTesteFalhando.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmTesteFalhando.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("expected:<10> but was:<20>", notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

	@Test
	public void falhandoExcecaoEsperada() throws Exception {
		executor.executar(new CasoDeTeste(UmTesteFalhandoExcecaoEsperada.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmTesteFalhandoExcecaoEsperada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTesteFalhandoExcecaoEsperada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmTesteFalhandoExcecaoEsperada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("expected exception:<java.lang.UnsupportedOperationException>", notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

	@Test
	public void falhandoExcecaoEsperadaExcecaoLancada() throws Exception {
		executor.executar(new CasoDeTeste(UmTesteFalhandoExcecaoEsperadaExcecaoLancada.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("unexpected exception, expected:<java.lang.UnsupportedOperationException> but was:<java.lang.RuntimeException>", notificacoes.get(1).obterFalha().getMessage());
		assertEquals(RuntimeException.class, notificacoes.get(1).obterFalha().getException().getCause().getClass());
	}

	@Test
	public void falhandoExcecaoLancada() throws Exception {
		executor.executar(new CasoDeTeste(UmTesteFalhandoExcecaoLancada.class, "testar", null));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(UmTesteFalhandoExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(UmTesteFalhandoExcecaoLancada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(UmTesteFalhandoExcecaoLancada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(UnsupportedOperationException.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertNull(notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

}
