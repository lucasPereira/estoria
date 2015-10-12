package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorioIndireto;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.*;

@FixtureSetup({ UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTestePassando.class, UmAcessorioCompartilhadoPassandoUmaConfiguracaoPassandoUmTesteFalhando.class })
public class DoisAcessoriosPassandoFalhandoUmAcessorioIndiretoCompartilhadoPassandoUmTestePassando {

	@Fixture private List<Integer> numeros;

	@Test
	public void testar() throws Exception {
		assertTrue(numeros.contains(1));
		assertTrue(numeros.contains(2));
	}

}
