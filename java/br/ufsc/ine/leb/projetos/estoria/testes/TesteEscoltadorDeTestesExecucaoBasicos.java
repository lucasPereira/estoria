package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFalha;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFinalizado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteIniciado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesFinalizados;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesIniciados;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.*;
import org.junit.runner.notification.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.*;

public final class TesteEscoltadorDeTestesExecucaoBasicos {

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
	public void umTestePassando() throws Exception {
		configurar(UmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umTesteFalhando() throws Exception {
		configurar(UmTesteFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umaConfiguracaoPassandoUmTestePassando() throws Exception {
		configurar(UmaConfiguracaoPassandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umaConfiguracaoPassandoUmTesteFalhando() throws Exception {
		configurar(UmaConfiguracaoPassandoUmTesteFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umaConfiguracaoFalhandoUmTestePassando() throws Exception {
		configurar(UmaConfiguracaoFalhandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umaConfiguracaoFalhandoUmTesteFalhando() throws Exception {
		configurar(UmaConfiguracaoFalhandoUmTesteFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando() throws Exception {
		configurar(UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioPassandoUmaConfiguracaoPassandoUmTesteFalhando() throws Exception {
		configurar(UmAcessorioPassandoUmaConfiguracaoPassandoUmTesteFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioPassandoUmaConfiguracaoFalhandoUmTestePassando() throws Exception {
		configurar(UmAcessorioPassandoUmaConfiguracaoFalhandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioPassandoUmaConfiguracaoFalhandoUmTesteFalhando() throws Exception {
		configurar(UmAcessorioPassandoUmaConfiguracaoFalhandoUmTesteFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

}
