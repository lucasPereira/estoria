package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.annotation.Annotation;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Shared;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste130;

public final class TesteAnotacaoShared {

	private Class<?> classe;

	@Before
	public void configurar() {
		classe = ClasseDeTeste130.class;
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
	public void anotacaoShared() throws Exception {
		Shared anotacaoShared = classe.getAnnotation(Shared.class);
		Shared[] anotacoesShared = classe.getAnnotationsByType(Shared.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNotNull(anotacaoShared);
		assertEquals(1, anotacoesShared.length);
		assertEquals(1, anotacoes.length);
		assertEquals(Shared.class, anotacoes[0].annotationType());
	}

}
