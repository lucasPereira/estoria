package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioFalhandoUmaConfiguracaoPassandoUmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioFalhandoUmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoFalhandoUmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoFalhandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoPassandoUmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoFalhandoUmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoFalhandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTesteFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;

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
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioFalhandoUmaConfiguracaoPassandoUmTestePassando() throws Exception {
		configurar(UmAcessorioFalhandoUmaConfiguracaoPassandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioFalhandoUmaConfiguracaoPassandoUmTesteFalhando() throws Exception {
		configurar(UmAcessorioFalhandoUmaConfiguracaoPassandoUmTesteFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioFalhandoUmaConfiguracaoFalhandoUmTestePassando() throws Exception {
		configurar(UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTestePassando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void umAcessorioFalhandoUmaConfiguracaoFalhandoUmTesteFalhando() throws Exception {
		configurar(UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTesteFalhando.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite, "testar", AssertionError.class, "falha pai induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 3, 0));
		assertFalse(notificacoes.hasNext());
	}

}
