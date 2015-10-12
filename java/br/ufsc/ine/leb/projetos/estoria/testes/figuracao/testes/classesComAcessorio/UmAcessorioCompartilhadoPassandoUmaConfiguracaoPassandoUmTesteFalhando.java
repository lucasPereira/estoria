package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesCompartilhadas.*;

@FixtureSetup(CompartilhadaUmaConfiguracaoPassandoUmTestePassando.class)
public class UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTesteFalhando {

	@Fixture private List<Integer> numeros;

	@Before
	public void configurar() {
		numeros.add(2);
		assertTrue(numeros.contains(2));
	}

	@Test
	public void testar() throws Exception {
		assertTrue(numeros.contains(2));
		fail("falha compartilhamento induzida");
	}

}
