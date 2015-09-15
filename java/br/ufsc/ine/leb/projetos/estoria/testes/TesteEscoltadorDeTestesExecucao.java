package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFalha;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFinalizado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteIgnorado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteIniciado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesFinalizados;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesIniciados;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.*;
import org.junit.runner.notification.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.*;

public final class TesteEscoltadorDeTestesExecucao {

	private Class<?> suite;
	private Iterator<Notificacao> notificacoes;

	public void configurar(Class<?> suite) {
		this.suite = suite;
		SuiteDeTeste suiteDeTete = new SuiteDeTeste(suite);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suiteDeTete);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void umTesteIgnorado() throws Exception {
		configurar(UmTesteIgnorado.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(0, 0, 1));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umTestePassandoExcecaoEsperada() throws Exception {
		configurar(UmTestePassandoExcecaoEsperada.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umTestePassandoExcecaoEsperadaSuperClasse() throws Exception {
		configurar(UmTestePassandoExcecaoEsperadaSuperClasse.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umTesteFalhandoExcecaoLancada() throws Exception {
		configurar(UmTesteFalhandoExcecaoLancada.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", UnsupportedOperationException.class));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umTesteFalhandoExcecaoEsperada() throws Exception {
		configurar(UmTesteFalhandoExcecaoEsperada.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "expected exception:<java.lang.UnsupportedOperationException>"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umTesteFalhandoExcecaoEsperadaSubclasse() throws Exception {
		configurar(UmTesteFalhandoExcecaoEsperadaSubclasse.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "unexpected exception, expected:<java.lang.UnsupportedOperationException> but was:<java.lang.RuntimeException>"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void tresTestesPassandoIgnoradoFalhando() throws Exception {
		configurar(TresTestesPassandoIgnoradoFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(suite, "testarIgnorado"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testarFalhando"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testarFalhando", AssertionError.class, "falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testarFalhando"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testarPassando"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testarPassando"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 1, 1));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado() throws Exception {
		configurar(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(suite, "testar3"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar2", AssertionError.class, "falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 1, 1));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void duasConfiguracoesPassandoPassandoUmTestePassando() throws Exception {
		configurar(DuasConfiguracoesPassandoPassandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void duasConfiguracoesFalhandoPassandoUmTestePassando() throws Exception {
		configurar(DuasConfiguracoesFalhandoPassandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

}
