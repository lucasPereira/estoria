package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.OuvinteDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTesteFalhando;

public final class TesteEscoltadorDeTestesExecucaoUmTesteFalhando {

	private List<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SeletorDeTestes seletor = new SeletorDeTestes();
		seletor.adicionarClasse(ClasseComUmMetodoDeTesteFalhando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(seletor);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		OuvinteDeEscolta ouvinteDeEscolta = new OuvinteDeEscolta();
		mensageiroDeEscolta.addListener(ouvinteDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = ouvinteDeEscolta.obterNotificacoes();
	}

	@Test
	public void notificacoes() throws Exception {
		assertEquals(5, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTES_INICIADOS, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(2).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(3).obterTipo());
		assertEquals(TipoDeNotificacao.TESTES_FINALIZADOS, notificacoes.get(4).obterTipo());
	}

	@Test
	public void descricoesDasNotificacoes() throws Exception {
		assertNotNull(notificacoes.get(0).obterDescricao());
		assertNotNull(notificacoes.get(1).obterDescricao());
		assertNull(notificacoes.get(2).obterDescricao());
		assertNotNull(notificacoes.get(3).obterDescricao());
		assertNull(notificacoes.get(4).obterDescricao());
	}

	@Test
	public void resultadosDasNotificacoes() throws Exception {
		assertNull(notificacoes.get(0).obterResultado());
		assertNull(notificacoes.get(1).obterResultado());
		assertNull(notificacoes.get(2).obterResultado());
		assertNull(notificacoes.get(3).obterResultado());
		assertNotNull(notificacoes.get(4).obterResultado());
	}

	@Test
	public void falhasDasNotificacoes() throws Exception {
		assertNull(notificacoes.get(0).obterFalha());
		assertNull(notificacoes.get(1).obterFalha());
		assertNotNull(notificacoes.get(2).obterFalha());
		assertNull(notificacoes.get(3).obterFalha());
		assertNull(notificacoes.get(4).obterFalha());
	}

	@Test
	public void classesDasDescricoes() throws Exception {
		assertEquals(SeletorDeTestes.class.getName(), notificacoes.get(0).obterDescricao().getClassName());
		assertEquals(ClasseComUmMetodoDeTesteFalhando.class.getName(), notificacoes.get(1).obterDescricao().getClassName());
		assertEquals(ClasseComUmMetodoDeTesteFalhando.class.getName(), notificacoes.get(3).obterDescricao().getClassName());
	}

	@Test
	public void metodosDasDescricoes() throws Exception {
		assertEquals(null, notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(1).obterDescricao().getMethodName());
		assertEquals("testar", notificacoes.get(3).obterDescricao().getMethodName());
	}

	@Test
	public void falhaDoTeste() throws Exception {

	}

	@Test
	public void resultadoDosTestes() throws Exception {
		assertEquals(1, notificacoes.get(4).obterResultado().getFailureCount());
		assertEquals(0, notificacoes.get(4).obterResultado().getIgnoreCount());
		assertEquals(1, notificacoes.get(4).obterResultado().getRunCount());
		assertFalse(notificacoes.get(4).obterResultado().wasSuccessful());
	}

}
