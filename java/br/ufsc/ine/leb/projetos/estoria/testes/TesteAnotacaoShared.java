package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.annotation.*;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.*;

public final class TesteAnotacaoShared {

	private Class<?> classe;

	@Before
	public void configurar() {
		classe = ClasseCompartilhada.class;
	}

	@Test
	public void anotacaoSharedDeclarada() throws Exception {
		Shared anotacaoShared = classe.getDeclaredAnnotation(Shared.class);
		Shared[] anotacoesShared = classe.getDeclaredAnnotationsByType(Shared.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNotNull(anotacaoShared);
		assertEquals(1, anotacoesShared.length);
		assertEquals(1, anotacoes.length);
		assertEquals(Shared.class, anotacoes[0].annotationType());
	}

	@Test
	public void anotacoesShared() throws Exception {
		Shared anotacaoShared = classe.getAnnotation(Shared.class);
		Shared[] anotacoesShared = classe.getAnnotationsByType(Shared.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNotNull(anotacaoShared);
		assertEquals(1, anotacoesShared.length);
		assertEquals(1, anotacoes.length);
		assertEquals(Shared.class, anotacoes[0].annotationType());
	}

}
