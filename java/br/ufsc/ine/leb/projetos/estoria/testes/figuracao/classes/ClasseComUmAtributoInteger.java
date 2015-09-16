package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComUmAtributoInteger {

	private Integer atributoInteiro;

	public ClasseComUmAtributoInteger() {
		atributoInteiro = 100;
	}

	public Integer obterAtributo() {
		return atributoInteiro;
	}

	public void mudarPara50() {
		atributoInteiro = 50;
	}

}
