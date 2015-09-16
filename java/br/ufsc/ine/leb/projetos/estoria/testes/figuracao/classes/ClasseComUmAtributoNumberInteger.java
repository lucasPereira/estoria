package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComUmAtributoNumberInteger {

	private Number atributo;

	public ClasseComUmAtributoNumberInteger() {
		atributo = new Integer(200);
	}

	public Number obterAtributo() {
		return atributo;
	}

	public void mudarPara150() {
		atributo = new Integer(150);
	}

}
