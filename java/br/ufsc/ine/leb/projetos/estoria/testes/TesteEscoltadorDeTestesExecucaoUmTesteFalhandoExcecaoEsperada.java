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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.*;

public final class TesteEscoltadorDeTestesExecucaoUmTesteFalhandoExcecaoEsperada {

	private Iterator<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SuiteDeTeste suite = new SuiteDeTeste(UmTesteFalhandoExcecaoEsperada.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.next(), combinaComTestesIniciados(UmTesteFalhandoExcecaoEsperada.class));
		assertThat(notificacoes.next(), combinaComTesteIniciado(UmTesteFalhandoExcecaoEsperada.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(UmTesteFalhandoExcecaoEsperada.class, "testar", AssertionError.class, "expected exception:<java.lang.UnsupportedOperationException>"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(UmTesteFalhandoExcecaoEsperada.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

}
