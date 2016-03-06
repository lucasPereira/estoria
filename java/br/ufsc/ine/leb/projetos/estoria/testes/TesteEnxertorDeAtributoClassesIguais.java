package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.EnxertorDeAtributo;
import br.ufsc.ine.leb.projetos.estoria.FiltradorDeAtributos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisAtributosDoisMetodos;

@RunWith(JUnit4.class)
public final class TesteEnxertorDeAtributoClassesIguais {

	private List<Field> atributos;
	private ClasseComDoisAtributosDoisMetodos origem;
	private ClasseComDoisAtributosDoisMetodos destino;
	private EnxertorDeAtributo enxertor;

	@Before
	public void prepararCenario() {
		origem = new ClasseComDoisAtributosDoisMetodos();
		destino = new ClasseComDoisAtributosDoisMetodos();
		origem.semExcecao();
		atributos = new FiltradorDeAtributos(ClasseComDoisAtributosDoisMetodos.class).obterAtributos();
		enxertor = new EnxertorDeAtributo(origem, destino);
	}

	@Test
	public void naoEnxertar() throws Exception {
		assertEquals("atributo1", atributos.get(0).getName());
		assertEquals("atributo2", atributos.get(1).getName());
		assertEquals(10, origem.obterAtributo1());
		assertEquals(0, destino.obterAtributo1());
		assertEquals(0, origem.obterAtributo2());
		assertEquals(0, destino.obterAtributo2());
	}

	@Test
	public void enxertar() throws Exception {
		enxertor.enxertar(atributos.get(0), atributos.get(0));
		assertEquals("atributo1", atributos.get(0).getName());
		assertEquals("atributo2", atributos.get(1).getName());
		assertEquals(10, origem.obterAtributo1());
		assertEquals(10, destino.obterAtributo1());
		assertEquals(0, origem.obterAtributo2());
		assertEquals(0, destino.obterAtributo2());
	}

}
