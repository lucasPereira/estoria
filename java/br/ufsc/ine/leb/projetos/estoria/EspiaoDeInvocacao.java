package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

public class EspiaoDeInvocacao implements TratadorDeInvocacao {

	private Boolean executouSemExcecao;
	private Boolean executouComExcecao;
	private Throwable excecao;

	public EspiaoDeInvocacao() {
		executouSemExcecao = false;
		executouComExcecao = false;
	}

	public Boolean executouSemExcecao() {
		return executouSemExcecao;
	}

	public Boolean executouComExcecao() {
		return executouComExcecao;
	}

	public Throwable obterExcecao() {
		return excecao;
	}

	@Override
	public void tratarInvocacaoSemExcecao(Method metodo) {
		executouSemExcecao = true;
	}

	@Override
	public void tratarInvocacaoComExcecao(Method metodo, Throwable excecao) {
		executouComExcecao = true;
		this.excecao = excecao;
	}

}
