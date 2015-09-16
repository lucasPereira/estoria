package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComUmAtributoNumberInteger {

	private Number atributoNumero;

	public ClasseComUmAtributoNumberInteger() {
		atributoNumero = 200;
	}

	public Number obterAtributo() {
		return atributoNumero;
	}

	public void mudarPara150() {
		atributoNumero = 150;
	}

}
