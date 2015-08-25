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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTesteFalhandoExcecaoEsperada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTesteFalhandoExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassandoExcecaoEsperada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassandoVazio;

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
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTestePassando.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(ClasseComUmMetodoDeTestePassando.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTestePassando.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoVazio() throws Exception {
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTestePassandoVazio.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(ClasseComUmMetodoDeTestePassandoVazio.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTestePassandoVazio.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoExcecaoEsperada() throws Exception {
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTestePassandoExcecaoEsperada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(ClasseComUmMetodoDeTestePassandoExcecaoEsperada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTestePassandoExcecaoEsperada.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void passandoExcecaoEsperadaExcecaoLancada() throws Exception {
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(2, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(1).obterTipo());
		assertEquals(ClasseComUmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(1).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
	}

	@Test
	public void falhando() throws Exception {
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTesteFalhando.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(ClasseComUmMetodoDeTesteFalhando.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhando.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhando.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("expected:<10> but was:<20>", notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

	@Test
	public void falhandoExcecaoEsperada() throws Exception {
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("expected exception:<java.lang.UnsupportedOperationException>", notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

	@Test
	public void falhandoExcecaoEsperadaExcecaoLancada() throws Exception {
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(AssertionError.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertEquals("unexpected exception, expected:<java.lang.UnsupportedOperationException> but was:<java.lang.RuntimeException>", notificacoes.get(1).obterFalha().getMessage());
		assertEquals(RuntimeException.class, notificacoes.get(1).obterFalha().getException().getCause().getClass());
	}

	@Test
	public void falhandoExcecaoLancada() throws Exception {
		executor.executar(Description.createTestDescription(ClasseComUmMetodoDeTesteFalhandoExcecaoLancada.class, "testar"));
		List<Notificacao> notificacoes = espiaoDeEscolta.obterNotificacoes();
		assertEquals(3, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(2).obterTipo());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoLancada.class, notificacoes.get(0).obterDescricao().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoLancada.class, notificacoes.get(1).obterFalha().getDescription().getTestClass());
		assertEquals(ClasseComUmMetodoDeTesteFalhandoExcecaoLancada.class, notificacoes.get(2).obterDescricao().getTestClass());
		assertEquals("testar", notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterFalha().getDescription().getMethodName());
		assertEquals("testar", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals(UnsupportedOperationException.class, notificacoes.get(1).obterFalha().getException().getClass());
		assertNull(notificacoes.get(1).obterFalha().getMessage());
		assertNull(notificacoes.get(1).obterFalha().getException().getCause());
	}

}
