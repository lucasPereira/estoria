package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.annotation.Annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste112;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste117;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste127;

@RunWith(JUnit4.class)
public final class TesteAnotacaoFixtureSetup {

	@Test
	public void anotacaoFixtureSetupDeclaradaUmaClasse() throws Exception {
		Class<?> classe = ClasseDeTeste119.class;
		FixtureSetup anotacaoAcessorios = classe.getDeclaredAnnotation(FixtureSetup.class);
		FixtureSetup[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(1, anotacaoAcessorios.value().length);
		assertEquals(1, anotacoesAcessorios[0].value().length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseDeTeste112.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseDeTeste112.class, anotacoesAcessorios[0].value()[0]);
	}

	@Test
	public void anotacaoFixtureSetupUmaClasse() throws Exception {
		Class<?> classe = ClasseDeTeste119.class;
		FixtureSetup anotacaoAcessorios = classe.getAnnotation(FixtureSetup.class);
		FixtureSetup[] anotacoesAcessorios = classe.getAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(1, anotacaoAcessorios.value().length);
		assertEquals(1, anotacoesAcessorios[0].value().length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseDeTeste112.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseDeTeste112.class, anotacoesAcessorios[0].value()[0]);
	}

	@Test
	public void anotacaoFixtureSetupDeclaradaDuasClasses() throws Exception {
		Class<?> classe = ClasseDeTeste127.class;
		FixtureSetup anotacaoAcessorios = classe.getDeclaredAnnotation(FixtureSetup.class);
		FixtureSetup[] anotacoesAcessorios = classe.getDeclaredAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getDeclaredAnnotations();
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(2, anotacaoAcessorios.value().length);
		assertEquals(2, anotacoesAcessorios[0].value().length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseDeTeste112.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseDeTeste112.class, anotacoesAcessorios[0].value()[0]);
		assertEquals(ClasseDeTeste117.class, anotacaoAcessorios.value()[1]);
		assertEquals(ClasseDeTeste117.class, anotacoesAcessorios[0].value()[1]);
	}

	@Test
	public void anotacaoFixtureSetupDuasClasses() throws Exception {
		Class<?> classe = ClasseDeTeste127.class;
		FixtureSetup anotacaoAcessorios = classe.getAnnotation(FixtureSetup.class);
		FixtureSetup[] anotacoesAcessorios = classe.getAnnotationsByType(FixtureSetup.class);
		Annotation[] anotacoes = classe.getAnnotations();
		assertNotNull(anotacaoAcessorios);
		assertEquals(1, anotacoes.length);
		assertEquals(1, anotacoesAcessorios.length);
		assertEquals(2, anotacaoAcessorios.value().length);
		assertEquals(2, anotacoesAcessorios[0].value().length);
		assertEquals(FixtureSetup.class, anotacoes[0].annotationType());
		assertEquals(ClasseDeTeste112.class, anotacaoAcessorios.value()[0]);
		assertEquals(ClasseDeTeste112.class, anotacoesAcessorios[0].value()[0]);
		assertEquals(ClasseDeTeste117.class, anotacaoAcessorios.value()[1]);
		assertEquals(ClasseDeTeste117.class, anotacoesAcessorios[0].value()[1]);
	}

}
