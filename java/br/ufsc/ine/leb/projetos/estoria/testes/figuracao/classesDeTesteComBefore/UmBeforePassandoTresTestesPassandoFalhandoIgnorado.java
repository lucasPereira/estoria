package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTesteComBefore;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UmBeforePassandoTresTestesPassandoFalhandoIgnorado {

	private int numero = 0;

	@Before
	public void configurar() {
		numero = 10;
	}

	@Test
	public void testar1() {
		numero = 20;
		assertEquals(20, numero);
	}

	@Test
	public void testar2() {
		assertEquals(20, numero);
	}

	@Ignore
	@Test
	public void testar3() {
		assertEquals(20, numero);
	}

}
