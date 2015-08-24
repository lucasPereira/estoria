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
