package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.ClasseDeTeste;
import br.ufsc.ine.leb.projetos.estoria.MetodoDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberLong;

public final class TesteMetodoDeTeste {

	private ClasseDeTeste classeDeTesteLong;
	private ClasseDeTeste classeDeTesteInteger;
	private Method metodoLong;
	private Method metodoInteger;

	@Before
	public void reflexaoDoJava() throws Exception {
		assertSame(ClasseComUmAtributoNumberLong.class, ClasseComUmAtributoNumberLong.class);
		assertEquals(ClasseComUmAtributoNumberLong.class, ClasseComUmAtributoNumberLong.class);
		assertNotSame(ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo"), ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo"));
		assertEquals(ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo"), ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo"));
		classeDeTesteLong = new ClasseDeTeste(ClasseComUmAtributoNumberLong.class);
		classeDeTesteInteger = new ClasseDeTeste(ClasseComUmAtributoNumberInteger.class);
		metodoLong = ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo");
		metodoInteger = ClasseComUmAtributoNumberInteger.class.getDeclaredMethod("obterAtributo");
		assertNotEquals(metodoLong.hashCode(), metodoInteger.hashCode());
	}

	@Test
	public void classesDiferentesMetodosDiferentesComMesmoNome() throws Exception {
		assertNotEquals(new MetodoDeTeste(classeDeTesteLong, metodoLong), new MetodoDeTeste(classeDeTesteInteger, metodoInteger));
	}

	@Test
	public void classesIguaisMetodosDiferentesComMesmoNome() throws Exception {
		assertNotEquals(new MetodoDeTeste(classeDeTesteLong, metodoLong), new MetodoDeTeste(classeDeTesteLong, metodoInteger));
	}

	@Test
	public void classesDiferentesMetodosIguais() throws Exception {
		assertNotEquals(new MetodoDeTeste(classeDeTesteLong, metodoLong), new MetodoDeTeste(classeDeTesteInteger, metodoLong));
	}

	@Test
	public void objetosDiferentesPropriedadesIguais() throws Exception {
		assertEquals(new MetodoDeTeste(classeDeTesteLong, metodoLong), new MetodoDeTeste(new ClasseDeTeste(ClasseComUmAtributoNumberLong.class), ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo")));
	}

	@Test
	public void codigo() throws Exception {
		assertEquals(new MetodoDeTeste(classeDeTesteLong, metodoLong).hashCode(), metodoLong.hashCode());
		assertEquals(new MetodoDeTeste(classeDeTesteInteger, metodoInteger).hashCode(), metodoInteger.hashCode());
		assertNotEquals(new MetodoDeTeste(classeDeTesteLong, metodoLong).hashCode(), metodoInteger.hashCode());
		assertNotEquals(new MetodoDeTeste(classeDeTesteInteger, metodoInteger).hashCode(), metodoLong.hashCode());
	}

}
