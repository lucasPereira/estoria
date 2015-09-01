package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Notificacao {

	private Failure falha;
	private Result resultado;
	private Description descricao;
	private TipoDeNotificacao tipo;

	public Notificacao(TipoDeNotificacao tipo, Description descricao) {
		Contrato contrato = new Contrato();
		contrato.assegureIguais(tipo, TipoDeNotificacao.TESTE_INICIADO).ou(TipoDeNotificacao.TESTE_FINALIZADO).ou(TipoDeNotificacao.TESTE_IGNORADO).ou(TipoDeNotificacao.TESTES_INICIADOS);
		contrato.se(tipo.equals(TipoDeNotificacao.TESTES_INICIADOS)).assegureQue(descricao.isSuite());
		contrato.se(tipo.equals(TipoDeNotificacao.TESTE_INICIADO)).assegureQue(descricao.isTest());
		contrato.se(tipo.equals(TipoDeNotificacao.TESTE_FINALIZADO)).assegureQue(descricao.isTest());
		contrato.se(tipo.equals(TipoDeNotificacao.TESTE_IGNORADO)).assegureQue(descricao.isTest());
		contrato.garantir();
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Notificacao(TipoDeNotificacao tipo, Result resultado) {
		this.tipo = tipo;
		this.resultado = resultado;
	}

	public Notificacao(TipoDeNotificacao tipo, Failure falha) {
		this.tipo = tipo;
		this.falha = falha;
		this.descricao = falha.getDescription();
	}

	public TipoDeNotificacao obterTipo() {
		return tipo;
	}

	public Description obterDescricao() {
		return descricao;
	}

	public Result obterResultado() {
		return resultado;
	}

	public Failure obterFalha() {
		return falha;
	}

}
