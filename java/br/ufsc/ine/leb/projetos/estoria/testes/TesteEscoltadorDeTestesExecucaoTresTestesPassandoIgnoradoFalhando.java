package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import br.ufsc.ine.leb.projetos.estoria.EscoltadorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.EspiaoDeEscolta;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.TresTestesPassandoIgnoradoFalhando;

public final class TesteEscoltadorDeTestesExecucaoTresTestesPassandoIgnoradoFalhando {

	private List<Notificacao> notificacoes;

	@Before
	public void prepararCenario() {
		SeletorDeTestes seletor = new SeletorDeTestes();
		seletor.adicionarClasse(TresTestesPassandoIgnoradoFalhando.class);
		EscoltadorDeTestes escoltador = new EscoltadorDeTestes(seletor);
		RunNotifier mensageiroDeEscolta = new RunNotifier();
		EspiaoDeEscolta espiaoDeEscolta = new EspiaoDeEscolta();
		mensageiroDeEscolta.addListener(espiaoDeEscolta);
		escoltador.run(mensageiroDeEscolta);
		notificacoes = espiaoDeEscolta.obterNotificacoes();
	}

	@Test
	public void notificacoes() throws Exception {
		assertEquals(8, notificacoes.size());
		assertEquals(TipoDeNotificacao.TESTES_INICIADOS, notificacoes.get(0).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_IGNORADO, notificacoes.get(1).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(2).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacoes.get(3).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(4).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacoes.get(5).obterTipo());
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacoes.get(6).obterTipo());
		assertEquals(TipoDeNotificacao.TESTES_FINALIZADOS, notificacoes.get(7).obterTipo());
	}

	@Test
	public void descricoesDasNotificacoes() throws Exception {
		assertNotNull(notificacoes.get(0).obterDescricao());
		assertNotNull(notificacoes.get(1).obterDescricao());
		assertNotNull(notificacoes.get(2).obterDescricao());
		assertNull(notificacoes.get(3).obterDescricao());
		assertNotNull(notificacoes.get(4).obterDescricao());
		assertNotNull(notificacoes.get(5).obterDescricao());
		assertNotNull(notificacoes.get(6).obterDescricao());
		assertNull(notificacoes.get(7).obterDescricao());
	}

	@Test
	public void resultadosDasNotificacoes() throws Exception {
		assertNull(notificacoes.get(0).obterResultado());
		assertNull(notificacoes.get(1).obterResultado());
		assertNull(notificacoes.get(2).obterResultado());
		assertNull(notificacoes.get(3).obterResultado());
		assertNull(notificacoes.get(4).obterResultado());
		assertNull(notificacoes.get(5).obterResultado());
		assertNull(notificacoes.get(6).obterResultado());
		assertNotNull(notificacoes.get(7).obterResultado());
	}

	@Test
	public void falhasDasNotificacoes() throws Exception {
		assertNull(notificacoes.get(0).obterFalha());
		assertNull(notificacoes.get(1).obterFalha());
		assertNull(notificacoes.get(2).obterFalha());
		assertNotNull(notificacoes.get(3).obterFalha());
		assertNull(notificacoes.get(4).obterFalha());
		assertNull(notificacoes.get(5).obterFalha());
		assertNull(notificacoes.get(6).obterFalha());
		assertNull(notificacoes.get(7).obterFalha());
	}

	@Test
	public void classesDasDescricoes() throws Exception {
		assertEquals(SeletorDeTestes.class.getName(), notificacoes.get(0).obterDescricao().getClassName());
		assertEquals(TresTestesPassandoIgnoradoFalhando.class.getName(), notificacoes.get(1).obterDescricao().getClassName());
		assertEquals(TresTestesPassandoIgnoradoFalhando.class.getName(), notificacoes.get(2).obterDescricao().getClassName());
		assertEquals(TresTestesPassandoIgnoradoFalhando.class.getName(), notificacoes.get(3).obterFalha().getDescription().getClassName());
		assertEquals(TresTestesPassandoIgnoradoFalhando.class.getName(), notificacoes.get(4).obterDescricao().getClassName());
		assertEquals(TresTestesPassandoIgnoradoFalhando.class.getName(), notificacoes.get(5).obterDescricao().getClassName());
		assertEquals(TresTestesPassandoIgnoradoFalhando.class.getName(), notificacoes.get(6).obterDescricao().getClassName());
	}

	@Test
	public void metodosDasDescricoes() throws Exception {
		assertEquals(null, notificacoes.get(0).obterDescricao().getMethodName());
		assertEquals("testarIgnorado", notificacoes.get(1).obterDescricao().getMethodName());
		assertEquals("testarFalhando", notificacoes.get(2).obterDescricao().getMethodName());
		assertEquals("testarFalhando", notificacoes.get(3).obterFalha().getDescription().getMethodName());
		assertEquals("testarFalhando", notificacoes.get(4).obterDescricao().getMethodName());
		assertEquals("testarPassando", notificacoes.get(5).obterDescricao().getMethodName());
		assertEquals("testarPassando", notificacoes.get(6).obterDescricao().getMethodName());
	}

	@Test
	public void falhaDoTeste() throws Exception {
		assertEquals(AssertionError.class, notificacoes.get(3).obterFalha().getException().getClass());
	}

	@Test
	public void resultadoDosTestes() throws Exception {
		assertEquals(1, notificacoes.get(7).obterResultado().getFailures().size());
		assertEquals(1, notificacoes.get(7).obterResultado().getFailureCount());
		assertEquals(1, notificacoes.get(7).obterResultado().getIgnoreCount());
		assertEquals(2, notificacoes.get(7).obterResultado().getRunCount());
		assertFalse(notificacoes.get(7).obterResultado().wasSuccessful());
	}

}
