package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste;

import org.junit.Test;

public class UmTestePassandoExcecaoEsperadaSuperClasse {

	@Test(expected = RuntimeException.class)
	public void testar() {
		throw new UnsupportedOperationException();
	}

}
