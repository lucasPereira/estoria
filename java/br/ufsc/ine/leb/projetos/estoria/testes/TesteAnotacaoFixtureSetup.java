package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.annotation.*;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.*;

public final class TesteAnotacaoFixtureSetup {

	@Test
	public void umAcessorioAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComUmaClasseAcessorioUmAtributoAcessorio.class;
		Fixture anotacaoAcessorio = classe.getDeclaredAnnotation(Fixture.class);
		FixtureSetup anotacaoAcessorios = classe.getDeclaredAnnotation(FixtureSetup.class);
		Fixture[] anotacoesAcessorio = classe.getDeclaredAnnotationsByType(Fixture.class);
		FixtureSetup[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
	}

	@Test
	public void umAcessorioAnotacoes() throws Exception {
		Class<?> classe = ClasseComUmaClasseAcessorioUmAtributoAcessorio.class;
		Fixture anotacaoAcessorio = classe.getAnnotation(Fixture.class);
		FixtureSetup anotacaoAcessorios = classe.getAnnotation(FixtureSetup.class);
		Fixture[] anotacoesAcessorio = classe.getAnnotationsByType(Fixture.class);
		FixtureSetup[] anotacoesAcessorios = classe.getAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
	}

	@Test
	public void doisAcessoriosAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComDuasClassesAcessorioDoisAtributosAcessorios.class;
		Fixture anotacaoAcessorio = classe.getDeclaredAnnotation(Fixture.class);
		FixtureSetup anotacaoAcessorios = classe.getDeclaredAnnotation(FixtureSetup.class);
		Fixture[] anotacoesAcessorio = classe.getDeclaredAnnotationsByType(Fixture.class);
		FixtureSetup[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
		assertEquals(ClasseVazia.class, anotacoesAcessorios[0].value()[1]);
		assertEquals(ClasseComUmMetodo.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseVazia.class, anotacaoAcessorios.value()[1]);
	}

	@Test
	public void doisAcessoriosAnotacoes() throws Exception {
		Class<?> classe = ClasseComDuasClassesAcessorioDoisAtributosAcessorios.class;
		Fixture anotacaoAcessorio = classe.getAnnotation(Fixture.class);
		FixtureSetup anotacaoAcessorios = classe.getAnnotation(FixtureSetup.class);
		Fixture[] anotacoesAcessorio = classe.getAnnotationsByType(Fixture.class);
		FixtureSetup[] anotacoesAcessorios = classe.getAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
		assertEquals(ClasseVazia.class, anotacoesAcessorios[0].value()[1]);
		assertEquals(ClasseComUmMetodo.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseVazia.class, anotacaoAcessorios.value()[1]);
	}

}
