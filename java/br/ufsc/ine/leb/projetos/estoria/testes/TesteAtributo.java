package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.Atributo;
import br.ufsc.ine.leb.projetos.estoria.ClasseDeTeste;
import br.ufsc.ine.leb.projetos.estoria.RepositorioDeClassesDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberLong;

@RunWith(JUnit4.class)
public final class TesteAtributo {

	private Atributo atributoNumberLong;
	private Atributo atributoNumberInteger;
	private Atributo atributoInteger;
	private ClasseDeTeste classeNumberLong;
	private ClasseDeTeste classeNumberInteger;
	private ClasseDeTeste classeInteger;
	private RepositorioDeClassesDeTeste repositorio;

	@Before
	public void configurar() throws Exception {
		repositorio = new RepositorioDeClassesDeTeste();
		classeNumberLong = new ClasseDeTeste(ClasseComUmAtributoNumberLong.class, repositorio);
		classeNumberInteger = new ClasseDeTeste(ClasseComUmAtributoNumberInteger.class, repositorio);
		classeInteger = new ClasseDeTeste(ClasseComUmAtributoInteger.class, repositorio);
		atributoNumberLong = new Atributo(ClasseComUmAtributoNumberLong.class.getDeclaredField("atributo"), repositorio);
		atributoNumberInteger = new Atributo(ClasseComUmAtributoNumberInteger.class.getDeclaredField("atributo"), repositorio);
		atributoInteger = new Atributo(ClasseComUmAtributoInteger.class.getDeclaredField("atributo"), repositorio);
	}

	@Test
	public void identidade() throws Exception {
		assertEquals(new Atributo(ClasseComUmAtributoNumberLong.class.getDeclaredField("atributo"), repositorio), atributoNumberLong);
		assertEquals(new Atributo(ClasseComUmAtributoNumberInteger.class.getDeclaredField("atributo"), repositorio), atributoNumberInteger);
		assertNotEquals(atributoNumberLong, atributoNumberInteger);
	}

	@Test
	public void codigo() throws Exception {
		assertEquals(ClasseComUmAtributoNumberLong.class.getDeclaredField("atributo").hashCode(), atributoNumberLong.hashCode());
		assertEquals(ClasseComUmAtributoNumberInteger.class.getDeclaredField("atributo").hashCode(), atributoNumberInteger.hashCode());
	}

	@Test
	public void compativelCom() throws Exception {
		assertTrue(atributoNumberLong.compativelCom(atributoInteger));
		assertTrue(atributoNumberInteger.compativelCom(atributoInteger));
		assertTrue(atributoInteger.compativelCom(atributoInteger));
		assertFalse(atributoInteger.compativelCom(atributoNumberInteger));
		assertFalse(atributoInteger.compativelCom(atributoNumberLong));
	}

	@Test
	public void classeDeTeste() throws Exception {
		assertEquals(classeNumberLong, atributoNumberLong.obterClasseDeTeste());
		assertEquals(classeNumberInteger, atributoNumberInteger.obterClasseDeTeste());
		assertEquals(classeInteger, atributoInteger.obterClasseDeTeste());
		assertNotSame(classeNumberLong, atributoNumberLong.obterClasseDeTeste());
		assertNotSame(classeNumberInteger, atributoNumberInteger.obterClasseDeTeste());
		assertNotSame(classeInteger, atributoInteger.obterClasseDeTeste());
	}

}
