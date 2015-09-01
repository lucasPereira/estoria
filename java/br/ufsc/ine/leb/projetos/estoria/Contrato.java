package br.ufsc.ine.leb.projetos.estoria;

import java.util.Iterator;
import java.util.Stack;

public final class Contrato {

	private Object escopo;
	private Boolean condicaoSe;
	private Stack<Boolean> validacoes;
	private Stack<Boolean> condicoesParaValidacao;

	public Contrato() {
		condicaoSe = true;
		validacoes = new Stack<>();
		condicoesParaValidacao = new Stack<>();
	}

	public Contrato assegureQue(Boolean clausula) {
		condicoesParaValidacao.push(condicaoSe);
		validacoes.push(clausula);
		condicaoSe = true;
		return this;
	}

	public Contrato e(Boolean clausula) {
		Boolean atual = validacoes.pop();
		validacoes.push(atual && clausula);
		return this;
	}

	public Contrato ou(Boolean clausula) {
		Boolean atual = validacoes.pop();
		validacoes.push(atual || clausula);
		return this;
	}

	public Contrato assegureIguais(Object objeto1, Object objeto2) {
		escopo = objeto1;
		assegureQue(objeto1.equals(objeto2));
		return this;
	}

	public Contrato e(Object objeto1, Object objeto2) {
		e(objeto1.equals(objeto2));
		return this;
	}

	public Contrato ou(Object objeto1, Object objeto2) {
		ou(objeto1.equals(objeto2));
		return this;
	}

	public Contrato e(Object objeto) {
		e(escopo, objeto);
		return this;
	}

	public Contrato ou(Object objeto) {
		ou(escopo, objeto);
		return this;
	}

	public Contrato se(Boolean condicaoSe) {
		this.condicaoSe = condicaoSe;
		return this;
	}

	public void garantir() {
		Iterator<Boolean> iteradorValidacoes = validacoes.iterator();
		Iterator<Boolean> iteradorCondicoesDeValidacao = condicoesParaValidacao.iterator();
		while (iteradorValidacoes.hasNext() && iteradorCondicoesDeValidacao.hasNext()) {
			Boolean condicao = iteradorCondicoesDeValidacao.next();
			Boolean resultado = iteradorValidacoes.next();
			if (condicao) {
				if (!resultado) {
					throw new ExcecaoClausulaDeContratoViolada();
				}
			}
		}
	}

}
