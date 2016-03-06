package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.ClasseDeTeste;
import br.ufsc.ine.leb.projetos.estoria.Metodo;
import br.ufsc.ine.leb.projetos.estoria.RepositorioDeClassesDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisAtributosDoisMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberLong;

@RunWith(JUnit4.class)
public final class TesteMetodo {

	private Metodo metodoObterAtributo1;
	private Metodo metodoObterAtributo2;
	private Metodo metodoObterAtributoLong;
	private Metodo metodoObterAtributoInteger;
	private ClasseDeTeste classeNumberLong;
	private ClasseDeTeste classeNumberInteger;
	private ClasseDeTeste classeComDoisMetodos;
	private RepositorioDeClassesDeTeste repositorio;

	@Before
	public void configurar() throws Exception {
		repositorio = new RepositorioDeClassesDeTeste();
		classeNumberLong = new ClasseDeTeste(ClasseComUmAtributoNumberLong.class, repositorio);
		classeNumberInteger = new ClasseDeTeste(ClasseComUmAtributoNumberInteger.class, repositorio);
		classeComDoisMetodos = new ClasseDeTeste(ClasseComDoisAtributosDoisMetodos.class, repositorio);
		metodoObterAtributo1 = new Metodo(ClasseComDoisAtributosDoisMetodos.class.getDeclaredMethod("obterAtributo1"), repositorio);
		metodoObterAtributo2 = new Metodo(ClasseComDoisAtributosDoisMetodos.class.getDeclaredMethod("obterAtributo2"), repositorio);
		metodoObterAtributoLong = new Metodo(ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo"), repositorio);
		metodoObterAtributoInteger = new Metodo(ClasseComUmAtributoNumberInteger.class.getDeclaredMethod("obterAtributo"), repositorio);
	}

	@Test
	public void identidade() throws Exception {
		assertEquals(new Metodo(ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo"), repositorio), metodoObterAtributoLong);
		assertEquals(new Metodo(ClasseComUmAtributoNumberInteger.class.getDeclaredMethod("obterAtributo"), repositorio), metodoObterAtributoInteger);
		assertEquals(new Metodo(ClasseComDoisAtributosDoisMetodos.class.getDeclaredMethod("obterAtributo1"), repositorio), metodoObterAtributo1);
		assertEquals(new Metodo(ClasseComDoisAtributosDoisMetodos.class.getDeclaredMethod("obterAtributo2"), repositorio), metodoObterAtributo2);
		assertNotEquals(metodoObterAtributoLong, metodoObterAtributoInteger);
		assertNotEquals(metodoObterAtributo1, metodoObterAtributo2);
	}

	@Test
	public void codigo() throws Exception {
		assertEquals(ClasseComUmAtributoNumberLong.class.getDeclaredMethod("obterAtributo").hashCode(), metodoObterAtributoLong.hashCode());
		assertEquals(ClasseComUmAtributoNumberInteger.class.getDeclaredMethod("obterAtributo").hashCode(), metodoObterAtributoInteger.hashCode());
		assertEquals(ClasseComDoisAtributosDoisMetodos.class.getDeclaredMethod("obterAtributo1").hashCode(), metodoObterAtributo1.hashCode());
		assertEquals(ClasseComDoisAtributosDoisMetodos.class.getDeclaredMethod("obterAtributo2").hashCode(), metodoObterAtributo2.hashCode());
	}

	@Test
	public void classeDeTeste() throws Exception {
		assertSame(metodoObterAtributo1.obterClasseDeTeste(), metodoObterAtributo2.obterClasseDeTeste());
		assertEquals(classeNumberLong, metodoObterAtributoLong.obterClasseDeTeste());
		assertEquals(classeNumberInteger, metodoObterAtributoInteger.obterClasseDeTeste());
		assertEquals(classeComDoisMetodos, metodoObterAtributo1.obterClasseDeTeste());
		assertEquals(classeComDoisMetodos, metodoObterAtributo2.obterClasseDeTeste());
		assertNotSame(classeNumberLong, metodoObterAtributoLong.obterClasseDeTeste());
		assertNotSame(classeNumberInteger, metodoObterAtributoInteger.obterClasseDeTeste());
		assertNotSame(classeComDoisMetodos, metodoObterAtributo1.obterClasseDeTeste());
		assertNotSame(classeComDoisMetodos, metodoObterAtributo2.obterClasseDeTeste());
	}

}
