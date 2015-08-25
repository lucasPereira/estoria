package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import org.junit.Test;

public class ClasseComUmMetodoDeTestePassandoExcecaoEsperadaExcecaoLancada {

	@Test(expected = RuntimeException.class)
	public void testar() {
		throw new UnsupportedOperationException();
	}

}
