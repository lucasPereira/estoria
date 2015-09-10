package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste;

import static org.junit.Assert.fail;

import org.junit.*;

public final class UmTesteIgnorado {

	@Ignore
	@Test
	public void testar() {
		fail("falha ignorada");
	}

}
