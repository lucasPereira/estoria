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
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste102;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste107;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste108;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste109;

public final class TesteEscoltadorDeTestesExecucaoStackTraceDeFalhas {

	private List<StackTraceElement> pilha;
	private List<StackTraceElement> pilhaCausa;

	private void configurar(Class<?> classeDeTeste) {
		SuiteDeTeste suiteDeTete = new SuiteDeTeste(classeDeTeste);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(suiteDeTete, new Ata(new EscrivaoMalandro()));
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addFirstListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		Notificacao notificacao = espiaoDeEscolta.obterNotificacoes().get(2);
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacao.obterTipo());
		Throwable excecao = notificacao.obterFalha().getException();
		Throwable excecaoCausa = excecao.getCause();
		pilha = Arrays.asList(excecao.getStackTrace());
		pilhaCausa = excecaoCausa != null ? Arrays.asList(excecaoCausa.getStackTrace()) : Arrays.asList();
	}

	private String obterNome(StackTraceElement elemento) {
		return String.format("%s.%s", elemento.getClassName(), elemento.getMethodName());
	}

	private String obterNomeComLinha(StackTraceElement elemento) {
		return String.format("%s.%s:%d", elemento.getClassName(), elemento.getMethodName(), elemento.getLineNumber());
	}

	@Test
	public void classeDeTeste102() throws Exception {
		configurar(ClasseDeTeste102.class);
		assertEquals(3, pilha.size());
		assertEquals(0, pilhaCausa.size());
		assertEquals("org.junit.Assert.fail", obterNome(pilha.get(0)));
		assertEquals("br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste102.lancarExcecao:15", obterNomeComLinha(pilha.get(1)));
		assertEquals("br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste102.testar:11", obterNomeComLinha(pilha.get(2)));
	}

	@Test
	public void classeDeTeste107() throws Exception {
		configurar(ClasseDeTeste107.class);
		assertEquals(2, pilha.size());
		assertEquals(0, pilhaCausa.size());
		assertEquals("br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste107.lancarExcecao:13", obterNomeComLinha(pilha.get(0)));
		assertEquals("br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste107.testar:9", obterNomeComLinha(pilha.get(1)));
	}

	@Test
	public void classeDeTeste108() throws Exception {
		configurar(ClasseDeTeste108.class);
		assertEquals(0, pilha.size());
		assertEquals(0, pilhaCausa.size());
	}

	@Test
	public void classeDeTeste109() throws Exception {
		configurar(ClasseDeTeste109.class);
		assertEquals(0, pilha.size());
		assertEquals(2, pilhaCausa.size());
		assertEquals("br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste109.lancarExcecao:13", obterNomeComLinha(pilhaCausa.get(0)));
		assertEquals("br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste109.testar:9", obterNomeComLinha(pilhaCausa.get(1)));
	}

}
