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
import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTesteFalhando;

public final class TesteEscoltadorDeTestesExecucaoUmBeforePassandoUmTesteFalhando {

	private List<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SeletorDeTestes seletor = new SeletorDeTestes();
		seletor.adicionarClasse(UmaConfiguracaoPassandoUmTesteFalhando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(seletor);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.get(0), combinaComTestesIniciados(SeletorDeTestes.class));
		assertThat(notificacoes.get(1), combinaComTesteIniciado(UmaConfiguracaoPassandoUmTesteFalhando.class, "testarDeTesteFalhando"));
		assertThat(notificacoes.get(2), combinaComTesteFalha(UmaConfiguracaoPassandoUmTesteFalhando.class, "testarDeTesteFalhando", AssertionError.class));
		assertThat(notificacoes.get(3), combinaComTesteFinalizado(UmaConfiguracaoPassandoUmTesteFalhando.class, "testarDeTesteFalhando"));
		assertThat(notificacoes.get(4), combinaComTestesFinalizados(1, 1, 0));
		assertEquals(5, notificacoes.size());
	}

}
