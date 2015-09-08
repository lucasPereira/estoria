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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.*;

public final class TesteEscoltadorDeTestesExecucaoTresTestesPassandoIgnoradoFalhando {

	private Iterator<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SuiteDeTeste suite = new SuiteDeTeste(TresTestesPassandoIgnoradoFalhando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void testar() throws Exception {
		assertThat(notificacoes.next(), combinaComTestesIniciados(TresTestesPassandoIgnoradoFalhando.class));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(TresTestesPassandoIgnoradoFalhando.class, "testarIgnorado"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(TresTestesPassandoIgnoradoFalhando.class, "testarFalhando"));
		assertThat(notificacoes.next(), combinaComTesteFalha(TresTestesPassandoIgnoradoFalhando.class, "testarFalhando", AssertionError.class));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(TresTestesPassandoIgnoradoFalhando.class, "testarFalhando"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(TresTestesPassandoIgnoradoFalhando.class, "testarPassando"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(TresTestesPassandoIgnoradoFalhando.class, "testarPassando"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 1, 1));
		assertFalse(notificacoes.hasNext());
	}

}
