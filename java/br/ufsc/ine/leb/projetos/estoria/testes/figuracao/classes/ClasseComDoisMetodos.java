package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

public class ClasseComDoisMetodos {

	public void semExcecao() {}

	public void comExcecao() {
		throw new RuntimeException();
	}

}
