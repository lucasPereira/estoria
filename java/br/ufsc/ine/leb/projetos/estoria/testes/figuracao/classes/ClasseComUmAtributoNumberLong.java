package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComUmAtributoNumberLong {

	private Number atributoNumero;

	public ClasseComUmAtributoNumberLong() {
		atributoNumero = 200L;
	}

	public Number obterAtributo() {
		return atributoNumero;
	}

	public void mudarPara150() {
		atributoNumero = 150L;
	}

}
