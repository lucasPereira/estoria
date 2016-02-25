package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.Ata;
import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.EscrivaoMalandro;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste102;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste107;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste108;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste109;

public final class TesteEscoltadorDeTestesExecucaoStackTraceDeFalhas {

	private Class<?> classeDeTeste;
	private Notificacao excecao;
	private List<StackTraceElement> pilha;

	public void configurar(Class<?> classeDeTeste) {
		this.classeDeTeste = classeDeTeste;
		SuiteDeTeste suiteDeTete = new SuiteDeTeste(classeDeTeste);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suiteDeTete, new Ata(new EscrivaoMalandro()));
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		excecao = espiaoDeEscolta.obterNotificacoes().get(3);
		pilha = Arrays.asList(excecao.obterFalha().getException().getStackTrace());
	}

	@Test
	public void classeDeTeste102() throws Exception {
		configurar(ClasseDeTeste102.class);

		assertEquals(2, pilha.size());
		assertEquals(AssertionError.class, pilha.get(0).getClass());
		assertEquals("fail", pilha.get(0).getMethodName());
		assertEquals(ClasseDeTeste102.class, pilha.get(1).getClass());
		assertEquals("testar", pilha.get(1).getMethodName());
	}

	@Test
	public void classeDeTeste107() throws Exception {
		configurar(ClasseDeTeste107.class);
		// assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", UnsupportedOperationException.class));
	}

	@Test
	public void classeDeTeste108() throws Exception {
		configurar(ClasseDeTeste108.class);
		// assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class,
		// "expected exception:<java.lang.UnsupportedOperationException>"));
	}

	@Test
	public void classeDeTeste109() throws Exception {
		configurar(ClasseDeTeste109.class);
		// assertThat(notificacoes.next(), combinaComTesteFalha(classeDeTeste, "testar", AssertionError.class,
		// "unexpected exception, expected:<java.lang.UnsupportedOperationException> but was:<java.lang.RuntimeException>"));
	}

}
