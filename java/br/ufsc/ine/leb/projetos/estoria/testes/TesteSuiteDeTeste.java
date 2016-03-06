package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.ClasseDeTeste;
import br.ufsc.ine.leb.projetos.estoria.RepositorioDeClassesDeTeste;
import br.ufsc.ine.leb.projetos.estoria.SuiteDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste111;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste116;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste130;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste131;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste133;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste136;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste137;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste140;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste11;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste12;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste13;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste17;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste18;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.SuiteDeTeste20;

@RunWith(JUnit4.class)
public final class TesteSuiteDeTeste {

	private ClasseDeTeste classeDeTeste101;
	private ClasseDeTeste classeDeTeste111;
	private ClasseDeTeste classeDeTeste116;
	private ClasseDeTeste classeDeTeste119;
	private ClasseDeTeste classeDeTeste130;
	private ClasseDeTeste classeDeTeste131;
	private ClasseDeTeste classeDeTeste133;
	private ClasseDeTeste classeDeTeste136;
	private ClasseDeTeste classeDeTeste137;
	private ClasseDeTeste classeDeTeste140;
	private ClasseDeTeste classeDeTesteVazia;

	@Before
	public void configurar() throws Exception {
		RepositorioDeClassesDeTeste repositorio = new RepositorioDeClassesDeTeste();
		classeDeTeste101 = new ClasseDeTeste(ClasseDeTeste101.class, repositorio);
		classeDeTeste111 = new ClasseDeTeste(ClasseDeTeste111.class, repositorio);
		classeDeTeste116 = new ClasseDeTeste(ClasseDeTeste116.class, repositorio);
		classeDeTeste119 = new ClasseDeTeste(ClasseDeTeste119.class, repositorio);
		classeDeTeste130 = new ClasseDeTeste(ClasseDeTeste130.class, repositorio);
		classeDeTeste131 = new ClasseDeTeste(ClasseDeTeste131.class, repositorio);
		classeDeTeste133 = new ClasseDeTeste(ClasseDeTeste133.class, repositorio);
		classeDeTeste136 = new ClasseDeTeste(ClasseDeTeste136.class, repositorio);
		classeDeTeste137 = new ClasseDeTeste(ClasseDeTeste137.class, repositorio);
		classeDeTeste140 = new ClasseDeTeste(ClasseDeTeste140.class, repositorio);
		classeDeTesteVazia = new ClasseDeTeste(ClasseVazia.class, repositorio);
	}

	@Test
	public void suiteDeTeste11() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste11.class);
		assertEquals(SuiteDeTeste11.class, suite.obterSuite());
		assertEquals(0, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());
		assertTrue(suite.vazia());
		assertFalse(suite.classeDeTesteComoSuite());
	}

	@Test
	public void suiteDeTeste12() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste12.class);
		assertEquals(SuiteDeTeste12.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTesteVazia, suite.obterClassesDeTeste().get(0));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertFalse(suite.classeDeTesteComoSuite());
	}

	@Test
	public void suiteDeTeste13() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste13.class);
		assertEquals(SuiteDeTeste13.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste101, suite.obterClassesDeTeste().get(0));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertFalse(suite.classeDeTesteComoSuite());
	}

	@Test
	public void suiteDeTeste17() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste17.class);
		assertEquals(SuiteDeTeste17.class, suite.obterSuite());
		assertEquals(2, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste111, suite.obterClassesDeTeste().get(0));
		assertEquals(classeDeTeste116, suite.obterClassesDeTeste().get(1));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertFalse(suite.classeDeTesteComoSuite());
	}

	@Test
	public void suiteDeTeste18() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste18.class);
		assertEquals(SuiteDeTeste18.class, suite.obterSuite());
		assertEquals(2, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste101, suite.obterClassesDeTeste().get(0));
		assertEquals(classeDeTeste136, suite.obterClassesDeTeste().get(1));
		assertTrue(suite.ignorada());
		assertFalse(suite.vazia());
		assertFalse(suite.classeDeTesteComoSuite());
	}

	@Test
	public void suiteDeTeste20() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(SuiteDeTeste20.class);
		assertEquals(SuiteDeTeste20.class, suite.obterSuite());
		assertEquals(2, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste137, suite.obterClassesDeTeste().get(0));
		assertEquals(classeDeTeste140, suite.obterClassesDeTeste().get(1));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertFalse(suite.classeDeTesteComoSuite());
		assertSame(suite.obterClassesDeTeste().get(0).obterClassesConsumidoras().get(0), suite.obterClassesDeTeste().get(1).obterClassesProvedoras().get(0));
	}

	@Test
	public void classeDeTeste101() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste101.class);
		assertEquals(ClasseDeTeste101.class, suite.obterSuite());
		assertEquals(classeDeTeste101, suite.obterClassesDeTeste().get(0));
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertTrue(suite.classeDeTesteComoSuite());
	}

	@Test
	public void classeDeTeste119() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste119.class);
		assertEquals(ClasseDeTeste119.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste119, suite.obterClassesDeTeste().get(0));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertTrue(suite.classeDeTesteComoSuite());
	}

	@Test
	public void classeDeTeste130() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste130.class);
		assertEquals(ClasseDeTeste130.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste130, suite.obterClassesDeTeste().get(0));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertTrue(suite.classeDeTesteComoSuite());
	}

	@Test
	public void classeDeTeste131() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste131.class);
		assertEquals(ClasseDeTeste131.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste131, suite.obterClassesDeTeste().get(0));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertTrue(suite.classeDeTesteComoSuite());
	}

	@Test
	public void classeDeTeste133() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste133.class);
		assertEquals(ClasseDeTeste133.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste133, suite.obterClassesDeTeste().get(0));
		assertFalse(suite.ignorada());
		assertFalse(suite.vazia());
		assertTrue(suite.classeDeTesteComoSuite());

		ClasseDeTeste classeDeTesteProvedora131 = suite.obterClassesDeTeste().get(0).obterClassesProvedoras().get(0);
		ClasseDeTeste classeDeTesteProvedora132 = suite.obterClassesDeTeste().get(0).obterClassesProvedoras().get(1);
		assertEquals(1, classeDeTesteProvedora131.obterClassesProvedoras().size());
		assertEquals(1, classeDeTesteProvedora132.obterClassesProvedoras().size());
		assertEquals(1, classeDeTesteProvedora131.obterClassesConsumidoras().size());
		assertEquals(1, classeDeTesteProvedora132.obterClassesConsumidoras().size());
		assertEquals(0, classeDeTesteProvedora131.obterClassesProvedoras().get(0).obterClassesProvedoras().size());
		assertEquals(0, classeDeTesteProvedora132.obterClassesProvedoras().get(0).obterClassesProvedoras().size());
		assertEquals(2, classeDeTesteProvedora131.obterClassesProvedoras().get(0).obterClassesConsumidoras().size());
		assertEquals(2, classeDeTesteProvedora132.obterClassesProvedoras().get(0).obterClassesConsumidoras().size());
		assertEquals(2, classeDeTesteProvedora131.obterClassesConsumidoras().get(0).obterClassesProvedoras().size());
		assertEquals(2, classeDeTesteProvedora132.obterClassesConsumidoras().get(0).obterClassesProvedoras().size());
		assertEquals(0, classeDeTesteProvedora131.obterClassesConsumidoras().get(0).obterClassesConsumidoras().size());
		assertEquals(0, classeDeTesteProvedora132.obterClassesConsumidoras().get(0).obterClassesConsumidoras().size());
		assertSame(classeDeTesteProvedora131.obterClassesConsumidoras().get(0), suite.obterClassesDeTeste().get(0));
		assertSame(classeDeTesteProvedora132.obterClassesConsumidoras().get(0), suite.obterClassesDeTeste().get(0));
		assertSame(classeDeTesteProvedora131.obterClassesProvedoras().get(0), classeDeTesteProvedora132.obterClassesProvedoras().get(0));
		assertSame(classeDeTesteProvedora132.obterClassesConsumidoras().get(0), classeDeTesteProvedora131.obterClassesConsumidoras().get(0));
		assertSame(classeDeTesteProvedora131, classeDeTesteProvedora131.obterClassesProvedoras().get(0).obterClassesConsumidoras().get(0));
		assertSame(classeDeTesteProvedora132, classeDeTesteProvedora132.obterClassesProvedoras().get(0).obterClassesConsumidoras().get(1));
		assertSame(classeDeTesteProvedora131, classeDeTesteProvedora131.obterClassesConsumidoras().get(0).obterClassesProvedoras().get(0));
		assertSame(classeDeTesteProvedora132, classeDeTesteProvedora132.obterClassesConsumidoras().get(0).obterClassesProvedoras().get(1));
	}

	@Test
	public void classeDeTeste136() throws Exception {
		SuiteDeTeste suite = new SuiteDeTeste(ClasseDeTeste136.class);
		assertEquals(ClasseDeTeste136.class, suite.obterSuite());
		assertEquals(1, suite.obterClassesDeTeste().size());
		assertEquals(classeDeTeste136, suite.obterClassesDeTeste().get(0));
		assertTrue(suite.ignorada());
		assertFalse(suite.vazia());
		assertTrue(suite.classeDeTesteComoSuite());
	}

}
