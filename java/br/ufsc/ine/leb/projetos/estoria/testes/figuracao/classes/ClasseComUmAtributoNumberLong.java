package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComUmAtributoNumberLong {

	private Number atributo;

	public ClasseComUmAtributoNumberLong() {
		atributo = new Long(200);
	}

	public Number obterAtributo() {
		return atributo;
	}

	public void mudarPara150() {
		atributo = new Long(150);
	}

}
