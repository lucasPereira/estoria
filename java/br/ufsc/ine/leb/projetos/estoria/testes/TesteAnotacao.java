package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.anotacoes.Anotacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.anotacoes.Anotacoes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheia;

public final class TesteAnotacao {

	@Test
	public void anotacaoIgnore() throws Exception {
		Method metodo = ClasseCheia.class.getMethod("metodoAnotadoComIgnore");
		Ignore anotacaoIgnore = metodo.getAnnotation(Ignore.class);
		Ignore[] anotacoesIgnore = metodo.getAnnotationsByType(Ignore.class);
		Annotation[] anotacoes = metodo.getAnnotations();

		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesIgnore.length);
		assertEquals(Ignore.class, anotacoes[0].annotationType());
		assertEquals(Ignore.class, anotacoesIgnore[0].annotationType());
		assertEquals(Ignore.class, anotacaoIgnore.annotationType());
	}

	@Test
	public void anotacaoTest() throws Exception {
		Method metodo = ClasseCheia.class.getMethod("metodoAnotadoComTest");
		Test anotacaoTest = metodo.getAnnotation(Test.class);
		Test[] anotacoesTest = metodo.getAnnotationsByType(Test.class);
		Annotation[] anotacoes = metodo.getAnnotations();

		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesTest.length);
		assertEquals(Test.class, anotacoes[0].annotationType());
		assertEquals(Test.class, anotacoesTest[0].annotationType());
		assertEquals(Test.class, anotacaoTest.annotationType());
	}

	@Test
	public void anotacaoIgnoreTeste() throws Exception {
		Method metodo = ClasseCheia.class.getMethod("metodoAnotadoComIgnoreTeste");
		Ignore anotacaoIgnore = metodo.getAnnotation(Ignore.class);
		Ignore[] anotacoesIgnore = metodo.getAnnotationsByType(Ignore.class);
		Test anotacaoTest = metodo.getAnnotation(Test.class);
		Test[] anotacoesTest = metodo.getAnnotationsByType(Test.class);
		Annotation[] anotacoes = metodo.getAnnotations();

		assertEquals(2, anotacoes.length);
		assertEquals(1, anotacoesIgnore.length);
		assertEquals(1, anotacoesTest.length);
		assertEquals(Ignore.class, anotacoes[0].annotationType());
		assertEquals(Ignore.class, anotacoesIgnore[0].annotationType());
		assertEquals(Ignore.class, anotacaoIgnore.annotationType());
		assertEquals(Test.class, anotacoes[1].annotationType());
		assertEquals(Test.class, anotacoesTest[0].annotationType());
		assertEquals(Test.class, anotacaoTest.annotationType());
	}

	@Test
	public void anotacaoDeclaradaTesteIgnore() throws Exception {
		Method metodo = ClasseCheia.class.getMethod("metodoAnotadoComTesteIgnore");
		Test anotacaoTest = metodo.getDeclaredAnnotation(Test.class);
		Test[] anotacoesTest = metodo.getDeclaredAnnotationsByType(Test.class);
		Ignore anotacaoIgnore = metodo.getDeclaredAnnotation(Ignore.class);
		Ignore[] anotacoesIgnore = metodo.getDeclaredAnnotationsByType(Ignore.class);
		Annotation[] anotacoes = metodo.getDeclaredAnnotations();

		assertEquals(2, anotacoes.length);
		assertEquals(1, anotacoesTest.length);
		assertEquals(1, anotacoesIgnore.length);
		assertEquals(Test.class, anotacoes[0].annotationType());
		assertEquals(Test.class, anotacoesTest[0].annotationType());
		assertEquals(Test.class, anotacaoTest.annotationType());
		assertEquals(Ignore.class, anotacoes[1].annotationType());
		assertEquals(Ignore.class, anotacoesIgnore[0].annotationType());
		assertEquals(Ignore.class, anotacaoIgnore.annotationType());
	}

	@Test
	public void anotacaoCompleta() throws Exception {
		Method metodo = ClasseCheia.class.getMethod("metodoAnotadoEmTudo", Class.class);
		Anotacao anotacaoAnotacao = metodo.getAnnotation(Anotacao.class);
		Anotacoes anotacaoAnotacoes = metodo.getAnnotation(Anotacoes.class);
		Anotacao[] anotacoesAnotacao = metodo.getAnnotationsByType(Anotacao.class);
		Anotacoes[] anotacoesAnotacoes = metodo.getAnnotationsByType(Anotacoes.class);
		Annotation[] anotacoes = metodo.getAnnotations();

		assertEquals(1, anotacoes.length);
		assertEquals(2, anotacoesAnotacao.length);
		assertEquals(1, anotacoesAnotacoes.length);
		assertEquals(Anotacoes.class, anotacoes[0].annotationType());
		assertEquals("methodBeforeAccessModifier", anotacoesAnotacao[0].valor());
		assertEquals("methodAfterAccessModifier", anotacoesAnotacao[1].valor());
		assertEquals("methodBeforeAccessModifier", anotacaoAnotacoes.value()[0].valor());
		assertEquals("methodAfterAccessModifier", anotacaoAnotacoes.value()[1].valor());
		assertEquals("methodBeforeAccessModifier", anotacoesAnotacoes[0].value()[0].valor());
		assertEquals("methodAfterAccessModifier", anotacoesAnotacoes[0].value()[1].valor());
		assertNull(anotacaoAnotacao);
	}

}
