package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.FiltradorDeAtributos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;

public final class TesteFiltradorDeAtributosClasseVazia {

	private FiltradorDeAtributos filtrador;

	@Before
	public void prepararCenario() {
		filtrador = new FiltradorDeAtributos(ClasseVazia.class);
	}

	@Test
	public void classeVazia() throws Exception {
		List<Field> metodos = filtrador.obterAtributos();
		assertEquals(0, metodos.size());
	}

}
