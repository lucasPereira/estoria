package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.annotation.*;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.*;

public final class TesteAnotacaoAcessorios {

	@Test
	public void umAcessorioAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComUmaClasseAcessorioUmAtributoAcessorio.class;
		Acessorio anotacaoAcessorio = classe.getDeclaredAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getDeclaredAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getDeclaredAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(Acessorios.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
	}

	@Test
	public void umAcessorioAnotacoes() throws Exception {
		Class<?> classe = ClasseComUmaClasseAcessorioUmAtributoAcessorio.class;
		Acessorio anotacaoAcessorio = classe.getAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(Acessorios.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
	}

	@Test
	public void doisAcessoriosAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComDuasClassesAcessorioDoisAtributosAcessorios.class;
		Acessorio anotacaoAcessorio = classe.getDeclaredAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getDeclaredAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getDeclaredAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(Acessorios.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
		assertEquals(ClasseSemMetodos.class, anotacoesAcessorios[0].value()[1]);
		assertEquals(ClasseComUmMetodo.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseSemMetodos.class, anotacaoAcessorios.value()[1]);
	}

	@Test
	public void doisAcessoriosAnotacoes() throws Exception {
		Class<?> classe = ClasseComDuasClassesAcessorioDoisAtributosAcessorios.class;
		Acessorio anotacaoAcessorio = classe.getAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(0, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(Acessorios.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0]);
		assertEquals(ClasseSemMetodos.class, anotacoesAcessorios[0].value()[1]);
		assertEquals(ClasseComUmMetodo.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseSemMetodos.class, anotacaoAcessorios.value()[1]);
	}

}
