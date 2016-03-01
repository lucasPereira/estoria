package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFinalizado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteIniciado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesFinalizados;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesIniciados;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.Ata;
import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestesReaproveitador;
import br.ufsc.ine.leb.projetos.estoria.EscrivaoMalandro;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste112;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste137;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste138;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste19;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste20;

@RunWith(JUnit4.class)
public final class TesteEscoltadorDeTestesReaproveitadorExecucaoDeSuitesDeTeste {

	private Class<?> suiteDeTeste;
	private Iterator<Notificacao> notificacoes;

	public void configurar(Class<?> classeDeTeste) {
		this.suiteDeTeste = classeDeTeste;
		SuiteDeTeste suiteDeTete = new SuiteDeTeste(classeDeTeste);
		EscoltadorDeTestesReaproveitador escoltador = new EscoltadorDeTestesReaproveitador(suiteDeTete, new Ata(new EscrivaoMalandro()));
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void suiteDeTeste19() throws Exception {
		configurar(SuiteDeTeste19.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste112.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste112.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste20() throws Exception {
		configurar(SuiteDeTeste20.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste112.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste112.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste138.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste138.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

}
