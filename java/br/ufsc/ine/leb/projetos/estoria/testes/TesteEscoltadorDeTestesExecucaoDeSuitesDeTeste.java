package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.Ata;
import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.EscrivaoMalandro;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste104;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste110;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste111;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste116;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste136;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste11;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste12;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste13;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste14;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste15;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste16;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste17;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste18;

@RunWith(JUnit4.class)
public final class TesteEscoltadorDeTestesExecucaoDeSuitesDeTeste {

	private Class<?> suiteDeTeste;
	private Iterator<Notificacao> notificacoes;

	public void configurar(Class<?> classeDeTeste) {
		this.suiteDeTeste = classeDeTeste;
		SuiteDeTeste suiteDeTete = new SuiteDeTeste(classeDeTeste);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suiteDeTete, new Ata(new EscrivaoMalandro()));
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void suiteDeTeste11() throws Exception {
		configurar(SuiteDeTeste11.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(0, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste12() throws Exception {
		configurar(SuiteDeTeste12.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(0, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste13() throws Exception {
		configurar(SuiteDeTeste13.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste101.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste101.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste14() throws Exception {
		configurar(SuiteDeTeste14.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste110.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste110.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste110.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste110.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste15() throws Exception {
		configurar(SuiteDeTeste15.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste101.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste101.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste104.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste104.class, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste16() throws Exception {
		configurar(SuiteDeTeste16.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste101.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste101.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste110.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste110.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste110.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste110.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(3, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste17() throws Exception {
		configurar(SuiteDeTeste17.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(ClasseDeTeste111.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(ClasseDeTeste116.class, "testar3"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste111.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFalha(ClasseDeTeste111.class, "testar1", AssertionError.class, "111 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste111.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste111.class, "testar3"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste111.class, "testar3"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste116.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste116.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(ClasseDeTeste116.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFalha(ClasseDeTeste116.class, "testar2", AssertionError.class, "116 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(ClasseDeTeste116.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(4, 2, 2));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void suiteDeTeste18() throws Exception {
		configurar(SuiteDeTeste18.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(suiteDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(ClasseDeTeste136.class, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(ClasseDeTeste101.class, "testar"));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(ClasseDeTeste136.class, "testar1"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(0, 0, 3));
		assertFalse(notificacoes.hasNext());
	}

}
