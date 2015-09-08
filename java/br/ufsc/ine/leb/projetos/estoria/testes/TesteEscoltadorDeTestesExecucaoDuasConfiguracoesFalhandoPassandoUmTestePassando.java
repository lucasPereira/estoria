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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;

public final class TesteEscoltadorDeTestesExecucaoDuasConfiguracoesFalhandoPassandoUmTestePassando {

	private Iterator<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SuiteDeTeste suite = new SuiteDeTeste(DuasConfiguracoesFalhandoPassandoUmTestePassando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.next(), combinaComTestesIniciados(DuasConfiguracoesFalhandoPassandoUmTestePassando.class));
		assertThat(notificacoes.next(), combinaComTesteIniciado(DuasConfiguracoesFalhandoPassandoUmTestePassando.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(DuasConfiguracoesFalhandoPassandoUmTestePassando.class, "testar", AssertionError.class, "Falha no before 1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(DuasConfiguracoesFalhandoPassandoUmTestePassando.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

}
