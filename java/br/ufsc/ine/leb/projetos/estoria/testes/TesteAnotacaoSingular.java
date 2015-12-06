package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.annotation.Annotation;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Singular;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste130;

public final class TesteAnotacaoSingular {

	private Class<?> classe;

	@Before
	public void configurar() {
		classe = ClasseDeTeste130.class;
	}

	@Test
	public void anotacaoSingularDeclarada() throws Exception {
		Singular anotacaoSingular = classe.getDeclaredAnnotation(Singular.class);
		Singular[] anotacoesSingular = classe.getDeclaredAnnotationsByType(Singular.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNotNull(anotacaoSingular);
		assertEquals(1, anotacoesSingular.length);
		assertEquals(1, anotacoes.length);
		assertEquals(Singular.class, anotacoes[0].annotationType());
	}

	@Test
	public void anotacaoSingular() throws Exception {
		Singular anotacaoSingular = classe.getAnnotation(Singular.class);
		Singular[] anotacoesSingular = classe.getAnnotationsByType(Singular.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNotNull(anotacaoSingular);
		assertEquals(1, anotacoesSingular.length);
		assertEquals(1, anotacoes.length);
		assertEquals(Singular.class, anotacoes[0].annotationType());
	}

}
