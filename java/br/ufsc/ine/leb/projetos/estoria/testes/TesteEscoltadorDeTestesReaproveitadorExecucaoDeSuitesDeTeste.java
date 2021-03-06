package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.*;
import static org.junit.Assert.*;

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
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste137;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste138;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste139;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste140;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste141;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste143;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste142;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste19;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste20;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste21;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste23;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste22;

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
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste138.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste138.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste139.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste139.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(3, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste20() throws Exception {
		configurar(SuiteDeTeste20.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste140.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste140.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste21() throws Exception {
		configurar(SuiteDeTeste21.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste138.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste138.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste141.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste141.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste22() throws Exception {
		configurar(SuiteDeTeste22.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste140.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste140.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste142.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste142.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(3, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste23() throws Exception {
		configurar(SuiteDeTeste23.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste137.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste143.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste143.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste143.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste143.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(3, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

}
