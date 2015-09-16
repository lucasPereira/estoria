package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComDoisMetodos {

	private int atributo2;
	private int atributo1;

	public void semExcecao() {
		System.out.println("Executou1");
		atributo1 = 10;
	}

	public void comExcecao() {
		System.out.println("Executou2");
		atributo2 = 20;
		throw new RuntimeException();
	}

	public int obterAtributo1() {
		return atributo1;
	}

	public int obterAtributo2() {
		return atributo2;
	}

}
