package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import org.junit.Test;

public class ClasseComUmMetodoDeTestePassandoExecaoEsperada {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		 throw new UnsupportedOperationException();
	}

}
