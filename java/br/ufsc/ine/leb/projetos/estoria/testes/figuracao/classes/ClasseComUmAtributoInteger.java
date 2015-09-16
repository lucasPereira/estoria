package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComUmAtributoInteger {

	private Integer atributo;

	public ClasseComUmAtributoInteger() {
		atributo = 100;
	}

	public Integer obterAtributo() {
		return atributo;
	}

	public void mudarPara50() {
		atributo = 50;
	}

}
