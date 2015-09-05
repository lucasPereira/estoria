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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado;

public final class TesteEscoltadorDeTestesExecucaoUmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado {

	private List<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SuiteDeTeste suite = new SuiteDeTeste(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.get(0), combinaComTestesIniciados(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class));
		assertThat(notificacoes.get(1), combinaComTesteIgnorado(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, "testar3"));
		assertThat(notificacoes.get(2), combinaComTesteIniciado(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, "testar1"));
		assertThat(notificacoes.get(3), combinaComTesteFinalizado(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, "testar1"));
		assertThat(notificacoes.get(4), combinaComTesteIniciado(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, "testar2"));
		assertThat(notificacoes.get(5), combinaComTesteFalha(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, "testar2", AssertionError.class));
		assertThat(notificacoes.get(6), combinaComTesteFinalizado(UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class, "testar2"));
		assertThat(notificacoes.get(7), combinaComTestesFinalizados(2, 1, 1));
		assertEquals(8, notificacoes.size());
	}

}
