package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesCompartilhadas.*;

@FixtureSetup(CompartilhadaUmaConfiguracaoPassandoUmTestePassando.class)
public class UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTestePassando {

	@Fixture private List<Integer> numeros;

	@Before
	public void configurar() {
		numeros.add(1);
	}

	@Test
	public void testar() throws Exception {
		assertTrue(numeros.contains(1));
	}

}
