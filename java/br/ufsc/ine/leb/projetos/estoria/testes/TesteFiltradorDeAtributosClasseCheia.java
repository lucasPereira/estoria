package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Acessorio;
import br.ufsc.ine.leb.projetos.estoria.FiltradorDeAtributos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheia;

public final class TesteFiltradorDeAtributosClasseCheia {

	private FiltradorDeAtributos filtrador;

	@Before
	public void prepararCenario() {
		filtrador = new FiltradorDeAtributos(ClasseCheia.class);
	}

	@Test
	public void semFiltro() throws Exception {
		List<Field> atributos = filtrador.obterAtributos();
		assertEquals(5, atributos.size());
		assertEquals("atributoAnotadoComAcessorio", atributos.get(0).getName());
		assertEquals("atributoDefault", atributos.get(1).getName());
		assertEquals("atributoPrivado", atributos.get(2).getName());
		assertEquals("atributoProtegido", atributos.get(3).getName());
		assertEquals("atributoPublico", atributos.get(4).getName());
	}

	@Test
	public void filtrarAtributosAnotadosComAcessorio() throws Exception {
		filtrador.removerAtributosAnotadosCom(Acessorio.class);
		List<Field> atributos = filtrador.obterAtributos();
		assertEquals(4, atributos.size());
		assertEquals("atributoDefault", atributos.get(0).getName());
		assertEquals("atributoPrivado", atributos.get(1).getName());
		assertEquals("atributoProtegido", atributos.get(2).getName());
		assertEquals("atributoPublico", atributos.get(3).getName());
	}

	@Test
	public void filtrarAtributosNaoAnotadosComAcessorio() throws Exception {
		filtrador.removerAtributosNaoAnotadosCom(Acessorio.class);
		List<Field> atributos = filtrador.obterAtributos();
		assertEquals(1, atributos.size());
		assertEquals("atributoAnotadoComAcessorio", atributos.get(0).getName());
	}

}
