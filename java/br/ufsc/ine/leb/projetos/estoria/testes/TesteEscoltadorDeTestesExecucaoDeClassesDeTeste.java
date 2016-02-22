package br.ufsc.ine.leb.projetos.estoria.testes;

import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFalha;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteFinalizado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteIgnorado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTesteIniciado;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesFinalizados;
import static br.ufsc.ine.leb.projetos.estoria.CombinadorDeNotificacao.combinaComTestesIniciados;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste102;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste103;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste104;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste105;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste106;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste107;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste108;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste109;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste110;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste111;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste112;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste113;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste114;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste115;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste116;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste117;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste118;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste120;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste121;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste122;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste123;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste124;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste125;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste126;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste127;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste128;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste129;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste130;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste131;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste132;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste133;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste134;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste135;

public final class TesteEscoltadorDeTestesExecucaoDeClassesDeTeste {

	private Class<?> classeDeTeste;
	private Iterator<Notificacao> notificacoes;

	public void configurar(Class<?> classeDeTeste) {
		this.classeDeTeste = classeDeTeste;
		SuiteDeTeste suiteDeTete = new SuiteDeTeste(classeDeTeste);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suiteDeTete);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes().iterator();
	}

	@Test
	public void classeDeTeste101() throws Exception {
		configurar(ClasseDeTeste101.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste102() throws Exception {
		configurar(ClasseDeTeste102.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "102 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste103() throws Exception {
		configurar(ClasseDeTeste103.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(0, 0, 1));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste104() throws Exception {
		configurar(ClasseDeTeste104.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste105() throws Exception {
		configurar(ClasseDeTeste105.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste106() throws Exception {
		configurar(ClasseDeTeste106.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste107() throws Exception {
		configurar(ClasseDeTeste107.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", UnsupportedOperationException.class));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste108() throws Exception {
		configurar(ClasseDeTeste108.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "expected exception:<java.lang.UnsupportedOperationException>"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste109() throws Exception {
		configurar(ClasseDeTeste109.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "unexpected exception, expected:<java.lang.UnsupportedOperationException> but was:<java.lang.RuntimeException>"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste110() throws Exception {
		configurar(ClasseDeTeste110.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste111() throws Exception {
		configurar(ClasseDeTeste111.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar1", AssertionError.class, "111 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar3"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar3"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 1, 1));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste112() throws Exception {
		configurar(ClasseDeTeste112.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste113() throws Exception {
		configurar(ClasseDeTeste113.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "113 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste114() throws Exception {
		configurar(ClasseDeTeste114.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "114 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste115() throws Exception {
		configurar(ClasseDeTeste115.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "115 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "115 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste116() throws Exception {
		configurar(ClasseDeTeste116.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(classeDeTeste, "testar3"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar2", AssertionError.class, "116 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 1, 1));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste117() throws Exception {
		configurar(ClasseDeTeste117.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste118() throws Exception {
		configurar(ClasseDeTeste118.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "118 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste119() throws Exception {
		configurar(ClasseDeTeste119.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste120() throws Exception {
		configurar(ClasseDeTeste120.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "120 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste121() throws Exception {
		configurar(ClasseDeTeste121.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "121 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste122() throws Exception {
		configurar(ClasseDeTeste122.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "122 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "122 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste123() throws Exception {
		configurar(ClasseDeTeste123.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "115 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste124() throws Exception {
		configurar(ClasseDeTeste124.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "115 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "124 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste125() throws Exception {
		configurar(ClasseDeTeste125.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "115 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "125 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 2, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste126() throws Exception {
		configurar(ClasseDeTeste126.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "115 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "126 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "126 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 3, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste127() throws Exception {
		configurar(ClasseDeTeste127.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste128() throws Exception {
		configurar(ClasseDeTeste128.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste129() throws Exception {
		configurar(ClasseDeTeste129.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "115 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "126 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "129 falha configurada"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "129 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 4, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste130() throws Exception {
		configurar(ClasseDeTeste130.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste131() throws Exception {
		configurar(ClasseDeTeste131.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste132() throws Exception {
		configurar(ClasseDeTeste132.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class, "132 falha induzida"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 1, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste133() throws Exception {
		configurar(ClasseDeTeste133.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(1, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste134() throws Exception {
		configurar(ClasseDeTeste134.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTesteIniciado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteFinalizado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(2, 0, 0));
		assertFalse(notificacoes.hasNext());
	}

	@Test
	public void classeDeTeste135() throws Exception {
		configurar(ClasseDeTeste135.class);
		assertThat(notificacoes.next(), combinaComTestesIniciados(classeDeTeste));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(classeDeTeste, "testar2"));
		assertThat(notificacoes.next(), combinaComTesteIgnorado(classeDeTeste, "testar1"));
		assertThat(notificacoes.next(), combinaComTestesFinalizados(0, 0, 2));
		assertFalse(notificacoes.hasNext());
	}

}
