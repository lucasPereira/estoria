package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.*;

public final class TesteAnotacaoAcessorio {

	@Test
	public void umAcessorioAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComUmaClasseAcessorioUmAtributoAcessorio.class;
		assertEquals(2, classe.getFields().length);
		assertEquals("atributo1", classe.getFields()[0].getName());
		assertEquals("atributo2", classe.getFields()[1].getName());
		assertEquals(1, classe.getFields()[0].getDeclaredAnnotations().length);
		assertEquals(0, classe.getFields()[1].getDeclaredAnnotations().length);
		assertEquals(Acessorio.class, classe.getFields()[0].getDeclaredAnnotations()[0].annotationType());
	}

	@Test
	public void umAcessorioAnotacoes() throws Exception {
		Class<?> classe = ClasseComUmaClasseAcessorioUmAtributoAcessorio.class;
		assertEquals(2, classe.getFields().length);
		assertEquals("atributo1", classe.getFields()[0].getName());
		assertEquals("atributo2", classe.getFields()[1].getName());
		assertEquals(1, classe.getFields()[0].getAnnotations().length);
		assertEquals(0, classe.getFields()[1].getAnnotations().length);
		assertEquals(Acessorio.class, classe.getFields()[0].getAnnotations()[0].annotationType());
	}

	@Test
	public void doisAcessoriosAnotacoesDeclaradas() throws Exception {
		Class<?> classe = ClasseComDuasClassesAcessorioDoisAtributosAcessorios.class;
		assertEquals(2, classe.getFields().length);
		assertEquals("atributo1", classe.getFields()[0].getName());
		assertEquals("atributo2", classe.getFields()[1].getName());
		assertEquals(1, classe.getFields()[0].getAnnotations().length);
		assertEquals(1, classe.getFields()[1].getAnnotations().length);
		assertEquals(Acessorio.class, classe.getFields()[0].getAnnotations()[0].annotationType());
		assertEquals(Acessorio.class, classe.getFields()[1].getAnnotations()[0].annotationType());
	}

	@Test
	public void doisAcessoriosAnotacoes() throws Exception {
		Class<?> classe = ClasseComDuasClassesAcessorioDoisAtributosAcessorios.class;
		assertEquals(2, classe.getFields().length);
		assertEquals("atributo1", classe.getFields()[0].getName());
		assertEquals("atributo2", classe.getFields()[1].getName());
		assertEquals(1, classe.getFields()[0].getAnnotations().length);
		assertEquals(1, classe.getFields()[1].getAnnotations().length);
		assertEquals(Acessorio.class, classe.getFields()[0].getAnnotations()[0].annotationType());
		assertEquals(Acessorio.class, classe.getFields()[1].getAnnotations()[0].annotationType());
	}

}
