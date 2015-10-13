package br.ufsc.ine.leb.projetos.estoria.testes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.ufsc.ine.leb.projetos.estoria.ExcecaoClausulaDeContratoViolada;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;

public final class TesteNotificacaoExcecoes {

	private Failure falha;
	private Result resultado;
	private Description descricao;

	@Before
	public void prepararCenario() {
		resultado = new Result();
		descricao = Description.createTestDescription(ClasseDeTeste101.class, "testar");
		falha = new Failure(descricao, new AssertionError());
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoFalha() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_FALHA, descricao);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoFinalizados() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTES_FINALIZADOS, descricao);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void falhaIniciados() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTES_INICIADOS, falha);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void falhaIniciado() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_INICIADO, falha);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void falhaFinalizado() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_FINALIZADO, falha);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void falhaIgnorado() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_IGNORADO, falha);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void falhaFinalizados() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTES_FINALIZADOS, falha);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void resultadoIniciados() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTES_INICIADOS, resultado);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void resultadoIniciado() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_INICIADO, resultado);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void resultadoFinalizado() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_FINALIZADO, resultado);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void resultadoIgnorado() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_IGNORADO, resultado);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void resultadoFalha() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_FALHA, resultado);
	}

}
