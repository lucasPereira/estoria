package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFalha;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFinalizado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteIniciado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesFinalizados;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesIniciados;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTesteFalhando;

public final class TesteEscoltadorDeTestesExecucaoUmAcessorioFalhandoUmaConfiguracaoPassandoUmTesteFalhando {

	private SuiteDeTeste suite;
	private Iterator<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		suite = new SuiteDeTeste(UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTesteFalhando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.next(), combinaComTestesIniciados(suite.obterSuite()));
		assertThat(notificacoes.next(), combinaComTesteIniciado(suite.obterSuite(), "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite.obterSuite(), "testar", AssertionError.class, "Falha no before"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite.obterSuite(), "testar", AssertionError.class, "Falha no super before"));
		assertThat(notificacoes.next(), combinaComTesteFalha(suite.obterSuite(), "testar", AssertionError.class, "Falha no super test"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(suite.obterSuite(), "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 3, 0));
		assertFalse(notificacoes.hasNext());
	}

}
