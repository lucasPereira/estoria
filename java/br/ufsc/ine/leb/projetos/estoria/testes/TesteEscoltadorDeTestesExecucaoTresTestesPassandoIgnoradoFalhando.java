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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.TresTestesPassandoIgnoradoFalhando;

public final class TesteEscoltadorDeTestesExecucaoTresTestesPassandoIgnoradoFalhando {

	private List<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SuiteDeTeste suite = new SuiteDeTeste(TresTestesPassandoIgnoradoFalhando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.get(0), combinaComTestesIniciados(TresTestesPassandoIgnoradoFalhando.class));
		assertThat(notificacoes.get(1), combinaComTesteIgnorado(TresTestesPassandoIgnoradoFalhando.class, "testarIgnorado"));
		assertThat(notificacoes.get(2), combinaComTesteIniciado(TresTestesPassandoIgnoradoFalhando.class, "testarFalhando"));
		assertThat(notificacoes.get(3), combinaComTesteFalha(TresTestesPassandoIgnoradoFalhando.class, "testarFalhando", AssertionError.class));
		assertThat(notificacoes.get(4), combinaComTesteFinalizado(TresTestesPassandoIgnoradoFalhando.class, "testarFalhando"));
		assertThat(notificacoes.get(5), combinaComTesteIniciado(TresTestesPassandoIgnoradoFalhando.class, "testarPassando"));
		assertThat(notificacoes.get(6), combinaComTesteFinalizado(TresTestesPassandoIgnoradoFalhando.class, "testarPassando"));
		assertThat(notificacoes.get(7), combinaComTestesFinalizados(2, 1, 1));
		assertEquals(8, notificacoes.size());
	}

}
