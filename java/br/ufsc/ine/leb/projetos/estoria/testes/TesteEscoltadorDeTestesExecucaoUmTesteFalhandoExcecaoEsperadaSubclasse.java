package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTesteFalhandoExcecaoEsperadaSubclasse;

public final class TesteEscoltadorDeTestesExecucaoUmTesteFalhandoExcecaoEsperadaSubclasse {

	private List<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SuiteDeTeste suite = new SuiteDeTeste(UmTesteFalhandoExcecaoEsperadaSubclasse.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.get(0), combinaComTestesIniciados(UmTesteFalhandoExcecaoEsperadaSubclasse.class));
		assertThat(notificacoes.get(1), combinaComTesteIniciado(UmTesteFalhandoExcecaoEsperadaSubclasse.class, "testar"));
		assertThat(notificacoes.get(2), combinaComTesteFalha(UmTesteFalhandoExcecaoEsperadaSubclasse.class, "testar", AssertionError.class, "unexpected exception, expected:<java.lang.UnsupportedOperationException> but was:<java.lang.RuntimeException>"));
		assertThat(notificacoes.get(3), combinaComTesteFinalizado(UmTesteFalhandoExcecaoEsperadaSubclasse.class, "testar"));
		assertThat(notificacoes.get(4), combinaComTestesFinalizados(1, 1, 0));
		assertEquals(5, notificacoes.size());
	}

}
