package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class EspiaoDeEscolta extends RunListener {

	private List<Notificacao> notificacoes;

	public EspiaoDeEscolta() {
		notificacoes = new LinkedList<>();
	}

	@Override
	public void testRunStarted(Description descricao) throws Exception {
		super.testRunStarted(descricao);
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTES_INICIADOS, descricao);
		notificacoes.add(notificacao);
	}

	@Override
	public void testStarted(Description descricao) throws Exception {
		super.testStarted(descricao);
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_INICIADO, descricao);
		notificacoes.add(notificacao);
	}

	@Override
	public void testFinished(Description descricao) throws Exception {
		super.testFinished(descricao);
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_FINALIZADO, descricao);
		notificacoes.add(notificacao);
	}

	@Override
	public void testIgnored(Description descricao) throws Exception {
		super.testIgnored(descricao);
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_IGNORADO, descricao);
		notificacoes.add(notificacao);
	}

	@Override
	public void testFailure(Failure falha) throws Exception {
		super.testFailure(falha);
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTE_FALHA, falha);
		notificacoes.add(notificacao);
	}

	@Override
	public void testRunFinished(Result resultado) throws Exception {
		super.testRunFinished(resultado);
		Notificacao notificacao = new Notificacao(TipoDeNotificacao.TESTES_FINALIZADOS, resultado);
		notificacoes.add(notificacao);
	}

	@Override
	public void testAssumptionFailure(Failure falha) {
		super.testAssumptionFailure(falha);
		notificacoes.add(null);
	}

	public List<Notificacao> obterNotificacoes() {
		return notificacoes;
	}

}
