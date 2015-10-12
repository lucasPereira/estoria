package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesCompartilhadas;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;

@Shared
public class CompartilhadaUmaConfiguracaoPassandoUmTestePassando {

	private List<Integer> numeros;

	@Before
	public void configurar() {
		numeros = new LinkedList<Integer>();
	}

	@Test
	public void testar() throws Exception {
		assertTrue(numeros.isEmpty());
	}

}
