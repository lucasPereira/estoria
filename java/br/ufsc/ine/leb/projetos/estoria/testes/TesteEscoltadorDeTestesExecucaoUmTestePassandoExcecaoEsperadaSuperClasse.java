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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassandoExcecaoEsperadaSuperClasse;

public final class TesteEscoltadorDeTestesExecucaoUmTestePassandoExcecaoEsperadaSuperClasse {

	private List<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SuiteDeTeste suite = new SuiteDeTeste(UmTestePassandoExcecaoEsperadaSuperClasse.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suite);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes();
	}

	@Test
	public void testar() throws Exception {
		assertEquals(4, notificacoes.size());
		assertThat(notificacoes.get(0), combinaComTestesIniciados(UmTestePassandoExcecaoEsperadaSuperClasse.class));
		assertThat(notificacoes.get(1), combinaComTesteIniciado(UmTestePassandoExcecaoEsperadaSuperClasse.class, "testar"));
		assertThat(notificacoes.get(2), combinaComTesteFinalizado(UmTestePassandoExcecaoEsperadaSuperClasse.class, "testar"));
		assertThat(notificacoes.get(3), combinaComTestesFinalizados(1, 0, 0));
	}

}
