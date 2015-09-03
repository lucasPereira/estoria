package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.jUnit.SuiteDoJUnitDuasClassesDoisMetodosDeTeste;

public final class TesteNotificacao {

	private Result resultado;
	private Failure falha;
	private Description descricaoDeTeste;
	private Description descricaoDeSuite;

	@Before
	public void prepararCenario() {
		resultado = new Result();
		descricaoDeTeste = Description.createTestDescription(UmTestePassando.class, "testar");
		descricaoDeSuite = Description.createSuiteDescription(SuiteDoJUnitDuasClassesDoisMetodosDeTeste.class);
		descricaoDeSuite.addChild(descricaoDeTeste);
		falha = new Failure(descricaoDeTeste, null);
	}

	@Test
	public void testesIniciados() throws Exception {
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTES_INICIADOS, descricaoDeSuite);
		assertEquals(TipoDeNotificacao.TESTES_INICIADOS, notificacao.obterTipo());
		assertSame(descricaoDeSuite, notificacao.obterDescricao());
		assertNull(notificacao.obterResultado());
		assertNull(notificacao.obterFalha());
	}

	@Test
	public void testeIniciado() throws Exception {
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_INICIADO, descricaoDeTeste);
		assertEquals(TipoDeNotificacao.TESTE_INICIADO, notificacao.obterTipo());
		assertSame(descricaoDeTeste, notificacao.obterDescricao());
		assertNull(notificacao.obterResultado());
		assertNull(notificacao.obterFalha());
	}

	@Test
	public void testeFinalizado() throws Exception {
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_FINALIZADO, descricaoDeTeste);
		assertEquals(TipoDeNotificacao.TESTE_FINALIZADO, notificacao.obterTipo());
		assertSame(descricaoDeTeste, notificacao.obterDescricao());
		assertNull(notificacao.obterResultado());
		assertNull(notificacao.obterFalha());
	}

	@Test
	public void testeIgnorado() throws Exception {
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_IGNORADO, descricaoDeTeste);
		assertEquals(TipoDeNotificacao.TESTE_IGNORADO, notificacao.obterTipo());
		assertSame(descricaoDeTeste, notificacao.obterDescricao());
		assertNull(notificacao.obterResultado());
		assertNull(notificacao.obterFalha());
	}

	@Test
	public void testeFalha() throws Exception {
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_FALHA, falha);
		assertEquals(TipoDeNotificacao.TESTE_FALHA, notificacao.obterTipo());
		assertSame(descricaoDeTeste, notificacao.obterDescricao());
		assertNull(notificacao.obterResultado());
		assertSame(falha, notificacao.obterFalha());
	}

	@Test
	public void testesFinalizados() throws Exception {
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTES_FINALIZADOS, resultado);
		assertEquals(TipoDeNotificacao.TESTES_FINALIZADOS, notificacao.obterTipo());
		assertNull(notificacao.obterDescricao());
		assertSame(resultado, notificacao.obterResultado());
		assertNull(notificacao.obterFalha());
	}

}
