package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.*;

public class UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado {

	private int numero;

	@Before
	public void configurar() {
		numero = 10;
	}

	@Test
	public void testar1() {
		assertEquals(10, numero);
		numero = 20;
	}

	@Test
	public void testar2() {
		assertEquals(10, numero);
		numero = 20;
		fail("falha induzida");
	}

	@Ignore
	@Test
	public void testar3() {
		assertEquals(10, numero);
		numero = 20;
		fail("falha ignorada");
	}

}
