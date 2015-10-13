package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;

public final class TesteAnotacaoFixture {

	private Class<?> classe;

	@Before
	public void configurar() {
		classe = ClasseDeTeste119.class;
	}

	@Test
	public void anotacoesFixtureDeclaradas() throws Exception {
		assertEquals(0, classe.getDeclaredFields()[0].getDeclaredAnnotations().length);
		assertEquals(0, classe.getDeclaredFields()[1].getDeclaredAnnotations().length);
		assertEquals(0, classe.getDeclaredFields()[2].getDeclaredAnnotations().length);
		assertEquals(1, classe.getDeclaredFields()[3].getDeclaredAnnotations().length);
		assertEquals(1, classe.getDeclaredFields()[4].getDeclaredAnnotations().length);
		assertEquals(1, classe.getDeclaredFields()[5].getDeclaredAnnotations().length);
		assertEquals(Fixture.class, classe.getDeclaredFields()[3].getDeclaredAnnotations()[0].annotationType());
		assertEquals(Fixture.class, classe.getDeclaredFields()[4].getDeclaredAnnotations()[0].annotationType());
		assertEquals(Fixture.class, classe.getDeclaredFields()[5].getDeclaredAnnotations()[0].annotationType());
	}

	@Test
	public void anotacoesFixture() throws Exception {
		assertEquals(0, classe.getDeclaredFields()[0].getAnnotations().length);
		assertEquals(0, classe.getDeclaredFields()[1].getAnnotations().length);
		assertEquals(0, classe.getDeclaredFields()[2].getAnnotations().length);
		assertEquals(1, classe.getDeclaredFields()[3].getAnnotations().length);
		assertEquals(1, classe.getDeclaredFields()[4].getAnnotations().length);
		assertEquals(1, classe.getDeclaredFields()[5].getAnnotations().length);
		assertEquals(Fixture.class, classe.getDeclaredFields()[3].getAnnotations()[0].annotationType());
		assertEquals(Fixture.class, classe.getDeclaredFields()[4].getAnnotations()[0].annotationType());
		assertEquals(Fixture.class, classe.getDeclaredFields()[5].getAnnotations()[0].annotationType());
	}

}
