package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;

public final class TesteTipoDeNotificacao {

	@Test
	public void falharParaAdicionarTesteSeMudar() throws Exception {
		assertEquals(6, TipoDeNotificacao.values().length);
	}

	@Test
	public void testesIniciados() throws Exception {
		TipoDeNotificacao tipo = TipoDeNotificacao.TESTES_INICIADOS;
		assertTrue(tipo.possuiDescricao());
		assertFalse(tipo.possuiFalha());
		assertFalse(tipo.possuiResultado());
	}

	@Test
	public void testeIniciado() throws Exception {
		TipoDeNotificacao tipo = TipoDeNotificacao.TESTE_INICIADO;
		assertTrue(tipo.possuiDescricao());
		assertFalse(tipo.possuiFalha());
		assertFalse(tipo.possuiResultado());
	}

	@Test
	public void testeFinalizado() throws Exception {
		TipoDeNotificacao tipo = TipoDeNotificacao.TESTE_FINALIZADO;
		assertTrue(tipo.possuiDescricao());
		assertFalse(tipo.possuiFalha());
		assertFalse(tipo.possuiResultado());
	}

	@Test
	public void testeIgnorado() throws Exception {
		TipoDeNotificacao tipo = TipoDeNotificacao.TESTE_IGNORADO;
		assertTrue(tipo.possuiDescricao());
		assertFalse(tipo.possuiFalha());
		assertFalse(tipo.possuiResultado());
	}

	@Test
	public void testeFalha() throws Exception {
		TipoDeNotificacao tipo = TipoDeNotificacao.TESTE_FALHA;
		assertTrue(tipo.possuiDescricao());
		assertTrue(tipo.possuiFalha());
		assertFalse(tipo.possuiResultado());
	}

	@Test
	public void testesFinalizados() throws Exception {
		TipoDeNotificacao tipo = TipoDeNotificacao.TESTES_FINALIZADOS;
		assertFalse(tipo.possuiDescricao());
		assertFalse(tipo.possuiFalha());
		assertTrue(tipo.possuiResultado());
	}

}
