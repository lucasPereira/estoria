package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import org.junit.Test;

public class ClasseComUmMetodoDeTesteFalhandoExcecaoEsperadaExcecaoLancada {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		throw new RuntimeException();
	}

}
