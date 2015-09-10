package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste;

import org.junit.*;

public class UmTesteFalhandoExcecaoEsperadaSubclasse {

	@Test(expected = UnsupportedOperationException.class)
	public void testar() {
		throw new RuntimeException();
	}

}
