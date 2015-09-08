package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Acessorio;
import br.ufsc.ine.leb.projetos.estoria.Acessorios;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDuasAnotacoesAcessorio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodo;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmaAnotacaoAcessorio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseSemMetodos;

public final class TesteAnotacaoAcessorio {

	@Test
	public void umAcessorioAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComUmaAnotacaoAcessorio.class;
		Acessorio anotacaoAcessorio = classe.getDeclaredAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getDeclaredAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getDeclaredAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNotNull(anotacaoAcessorio);
		assertNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesAcessorio.length);
		assertEquals(0, anotacoesAcessorios.length);
		assertEquals(Acessorio.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorio[0].value());
	}

	@Test
	public void umAcessorioAnotacoesclaradas() throws Exception {
		Class<?> classe = ClasseComUmaAnotacaoAcessorio.class;
		Acessorio anotacaoAcessorio = classe.getAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNotNull(anotacaoAcessorio);
		assertNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesAcessorio.length);
		assertEquals(0, anotacoesAcessorios.length);
		assertEquals(Acessorio.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorio[0].value());
	}

	@Test
	public void doisAcessoriosAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComDuasAnotacoesAcessorio.class;
		Acessorio anotacaoAcessorio = classe.getDeclaredAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getDeclaredAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getDeclaredAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(2, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(Acessorios.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorio[0].value());
		assertEquals(ClasseSemMetodos.class, anotacoesAcessorio[1].value());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0].value());
		assertEquals(ClasseSemMetodos.class, anotacoesAcessorios[0].value()[1].value());
		assertEquals(ClasseComUmMetodo.class, anotacaoAcessorios.value()[0].value());
		assertEquals(ClasseSemMetodos.class, anotacaoAcessorios.value()[1].value());
	}

	@Test
	public void doisAcessoriosAnotacoes() throws Exception {
		Class<?> classe = ClasseComDuasAnotacoesAcessorio.class;
		Acessorio anotacaoAcessorio = classe.getAnnotation(Acessorio.class);
		Acessorios anotacaoAcessorios = classe.getAnnotation(Acessorios.class);
		Acessorio[] anotacoesAcessorio = classe.getAnnotationsByType(Acessorio.class);
		Acessorios[] anotacoesAcessorios = classe.getAnnotationsByType(Acessorios.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNull(anotacaoAcessorio);
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(2, anotacoesAcessorio.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(Acessorios.class, anotacoes[0].annotationType());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorio[0].value());
		assertEquals(ClasseSemMetodos.class, anotacoesAcessorio[1].value());
		assertEquals(ClasseComUmMetodo.class, anotacoesAcessorios[0].value()[0].value());
		assertEquals(ClasseSemMetodos.class, anotacoesAcessorios[0].value()[1].value());
		assertEquals(ClasseComUmMetodo.class, anotacaoAcessorios.value()[0].value());
		assertEquals(ClasseSemMetodos.class, anotacaoAcessorios.value()[1].value());
	}

}
