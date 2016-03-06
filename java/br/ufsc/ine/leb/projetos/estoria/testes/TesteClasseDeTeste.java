package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.Atributo;
import br.ufsc.ine.leb.projetos.estoria.ClasseDeTeste;
import br.ufsc.ine.leb.projetos.estoria.Metodo;
import br.ufsc.ine.leb.projetos.estoria.RepositorioDeClassesDeTeste;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseVazia;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste112;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste130;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste131;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste132;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste133;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste136;

@RunWith(JUnit4.class)
public final class TesteClasseDeTeste {

	private Metodo classeDeTeste119Configurar;
	private Metodo classeDeTeste130Configurar;
	private Metodo classeDeTeste131Configurar;
	private Metodo classeDeTeste119Testar;
	private Metodo classeDeTeste130Testar;
	private Metodo classeDeTeste131Testar;
	private Metodo classeDeTeste133Testar;
	private Metodo classeDeTeste136Testar1;
	private Metodo classeDeTeste136Testar2;
	private ClasseDeTeste classeDeTeste119;
	private ClasseDeTeste classeDeTeste112;
	private ClasseDeTeste classeDeTeste130;
	private ClasseDeTeste classeDeTeste131;
	private ClasseDeTeste classeDeTeste132;
	private ClasseDeTeste classeDeTeste133;
	private ClasseDeTeste classeDeTeste136;
	private ClasseDeTeste classeDeTesteVazia;
	private ClasseDeTeste classeDeTesteCheia;
	private Atributo classeDeTeste119Acessorio119Before10;
	private Atributo classeDeTeste119Acessorio119Before20Test30;
	private Atributo classeDeTeste119Acessorio119Test40;
	private Atributo classeDeTeste119Acessorio112Before10;
	private Atributo classeDeTeste119Acessorio112Before20Test30;
	private Atributo classeDeTeste119Acessorio112Test40;
	private Atributo classeDeTeste130Numeros;
	private Atributo classeDeTeste131Numeros;
	private Atributo classeDeTeste133Numeros;
	private RepositorioDeClassesDeTeste repositorio;

	@Before
	public void configurar() throws Exception {
		repositorio = new RepositorioDeClassesDeTeste();
		classeDeTeste112 = new ClasseDeTeste(ClasseDeTeste112.class, repositorio);
		classeDeTeste119 = new ClasseDeTeste(ClasseDeTeste119.class, repositorio);
		classeDeTeste130 = new ClasseDeTeste(ClasseDeTeste130.class, repositorio);
		classeDeTeste131 = new ClasseDeTeste(ClasseDeTeste131.class, repositorio);
		classeDeTeste132 = new ClasseDeTeste(ClasseDeTeste132.class, repositorio);
		classeDeTeste133 = new ClasseDeTeste(ClasseDeTeste133.class, repositorio);
		classeDeTeste136 = new ClasseDeTeste(ClasseDeTeste136.class, repositorio);
		classeDeTesteVazia = new ClasseDeTeste(ClasseVazia.class, repositorio);
		classeDeTesteCheia = new ClasseDeTeste(ClasseCheia.class, repositorio);
		classeDeTeste119Acessorio119Before10 = new Atributo(ClasseDeTeste119.class.getDeclaredField("acessorio119Before10"), repositorio);
		classeDeTeste119Acessorio119Before20Test30 = new Atributo(ClasseDeTeste119.class.getDeclaredField("acessorio119Before20Test30"), repositorio);
		classeDeTeste119Acessorio119Test40 = new Atributo(ClasseDeTeste119.class.getDeclaredField("acessorio119Test40"), repositorio);
		classeDeTeste119Acessorio112Before10 = new Atributo(ClasseDeTeste119.class.getDeclaredField("acessorio112Before10"), repositorio);
		classeDeTeste119Acessorio112Before20Test30 = new Atributo(ClasseDeTeste119.class.getDeclaredField("acessorio112Before20Test30"), repositorio);
		classeDeTeste119Acessorio112Test40 = new Atributo(ClasseDeTeste119.class.getDeclaredField("acessorio112Test40"), repositorio);
		classeDeTeste130Numeros = new Atributo(ClasseDeTeste130.class.getDeclaredField("numeros"), repositorio);
		classeDeTeste131Numeros = new Atributo(ClasseDeTeste131.class.getDeclaredField("numeros"), repositorio);
		classeDeTeste133Numeros = new Atributo(ClasseDeTeste133.class.getDeclaredField("numeros"), repositorio);
		classeDeTeste119Configurar = new Metodo(ClasseDeTeste119.class.getDeclaredMethod("configurar"), repositorio);
		classeDeTeste130Configurar = new Metodo(ClasseDeTeste130.class.getDeclaredMethod("configurar"), repositorio);
		classeDeTeste131Configurar = new Metodo(ClasseDeTeste131.class.getDeclaredMethod("configurar"), repositorio);
		classeDeTeste119Testar = new Metodo(ClasseDeTeste119.class.getDeclaredMethod("testar"), repositorio);
		classeDeTeste130Testar = new Metodo(ClasseDeTeste130.class.getDeclaredMethod("testar"), repositorio);
		classeDeTeste131Testar = new Metodo(ClasseDeTeste131.class.getDeclaredMethod("testar"), repositorio);
		classeDeTeste133Testar = new Metodo(ClasseDeTeste133.class.getDeclaredMethod("testar"), repositorio);
		classeDeTeste136Testar1 = new Metodo(ClasseDeTeste136.class.getDeclaredMethod("testar1"), repositorio);
		classeDeTeste136Testar2 = new Metodo(ClasseDeTeste136.class.getDeclaredMethod("testar2"), repositorio);
	}

	@Test
	public void identidade() throws Exception {
		assertEquals(new ClasseDeTeste(ClasseVazia.class, repositorio), classeDeTesteVazia);
		assertEquals(new ClasseDeTeste(ClasseCheia.class, repositorio), classeDeTesteCheia);
		assertNotEquals(new ClasseDeTeste(ClasseVazia.class, repositorio), classeDeTesteCheia);
		assertNotEquals(new ClasseDeTeste(ClasseCheia.class, repositorio), classeDeTesteVazia);
	}

	@Test
	public void codigo() throws Exception {
		assertEquals(ClasseVazia.class.hashCode(), classeDeTesteVazia.hashCode());
		assertEquals(ClasseCheia.class.hashCode(), classeDeTesteCheia.hashCode());
	}

	@Test
	public void classeDeTeste119() throws Exception {
		assertEquals(ClasseDeTeste119.class, classeDeTeste119.obterClasse());
		assertEquals(1, classeDeTeste119.obterClassesProvedoras().size());
		assertEquals(0, classeDeTeste119.obterClassesConsumidoras().size());
		assertEquals(3, classeDeTeste119.obterAtributosProprios().size());
		assertEquals(3, classeDeTeste119.obterAtributosAcessorios().size());
		assertEquals(1, classeDeTeste119.obterMetodosDeConfiguracao().size());
		assertEquals(1, classeDeTeste119.obterMetodosDeTeste().size());
		assertEquals(0, classeDeTeste119.obterMetodosDeTesteIgnorados().size());
		assertEquals(classeDeTeste112, classeDeTeste119.obterClassesProvedoras().get(0));
		assertEquals(classeDeTeste119Acessorio119Before10, classeDeTeste119.obterAtributosProprios().get(0));
		assertEquals(classeDeTeste119Acessorio119Before20Test30, classeDeTeste119.obterAtributosProprios().get(1));
		assertEquals(classeDeTeste119Acessorio119Test40, classeDeTeste119.obterAtributosProprios().get(2));
		assertEquals(classeDeTeste119Acessorio112Before10, classeDeTeste119.obterAtributosAcessorios().get(0));
		assertEquals(classeDeTeste119Acessorio112Before20Test30, classeDeTeste119.obterAtributosAcessorios().get(1));
		assertEquals(classeDeTeste119Acessorio112Test40, classeDeTeste119.obterAtributosAcessorios().get(2));
		assertEquals(classeDeTeste119Configurar, classeDeTeste119.obterMetodosDeConfiguracao().get(0));
		assertEquals(classeDeTeste119Testar, classeDeTeste119.obterMetodosDeTeste().get(0));
		assertFalse(classeDeTeste119.singular());
		assertFalse(classeDeTeste119.ignorada());
		assertFalse(classeDeTeste119.vazia());
	}

	@Test
	public void classeDeTeste130() throws Exception {
		assertEquals(ClasseDeTeste130.class, classeDeTeste130.obterClasse());
		assertEquals(0, classeDeTeste119.obterClassesConsumidoras().size());
		assertEquals(0, classeDeTeste130.obterClassesProvedoras().size());
		assertEquals(1, classeDeTeste130.obterAtributosProprios().size());
		assertEquals(0, classeDeTeste130.obterAtributosAcessorios().size());
		assertEquals(1, classeDeTeste130.obterMetodosDeConfiguracao().size());
		assertEquals(1, classeDeTeste130.obterMetodosDeTeste().size());
		assertEquals(0, classeDeTeste130.obterMetodosDeTesteIgnorados().size());
		assertEquals(classeDeTeste130Numeros, classeDeTeste130.obterAtributosProprios().get(0));
		assertEquals(classeDeTeste130Configurar, classeDeTeste130.obterMetodosDeConfiguracao().get(0));
		assertEquals(classeDeTeste130Testar, classeDeTeste130.obterMetodosDeTeste().get(0));
		assertTrue(classeDeTeste130.singular());
		assertFalse(classeDeTeste130.ignorada());
		assertFalse(classeDeTeste119.vazia());
	}

	@Test
	public void classeDeTeste131() throws Exception {
		assertEquals(ClasseDeTeste131.class, classeDeTeste131.obterClasse());
		assertEquals(0, classeDeTeste119.obterClassesConsumidoras().size());
		assertEquals(1, classeDeTeste131.obterClassesProvedoras().size());
		assertEquals(0, classeDeTeste131.obterAtributosProprios().size());
		assertEquals(1, classeDeTeste131.obterAtributosAcessorios().size());
		assertEquals(1, classeDeTeste131.obterMetodosDeConfiguracao().size());
		assertEquals(1, classeDeTeste131.obterMetodosDeTeste().size());
		assertEquals(0, classeDeTeste131.obterMetodosDeTesteIgnorados().size());
		assertEquals(classeDeTeste130, classeDeTeste131.obterClassesProvedoras().get(0));
		assertEquals(classeDeTeste131Numeros, classeDeTeste131.obterAtributosAcessorios().get(0));
		assertEquals(classeDeTeste131Configurar, classeDeTeste131.obterMetodosDeConfiguracao().get(0));
		assertEquals(classeDeTeste131Testar, classeDeTeste131.obterMetodosDeTeste().get(0));
		assertFalse(classeDeTeste131.singular());
		assertFalse(classeDeTeste131.ignorada());
		assertFalse(classeDeTeste119.vazia());
	}

	@Test
	public void classeDeTeste133() throws Exception {
		assertEquals(ClasseDeTeste133.class, classeDeTeste133.obterClasse());
		assertEquals(0, classeDeTeste119.obterClassesConsumidoras().size());
		assertEquals(2, classeDeTeste133.obterClassesProvedoras().size());
		assertEquals(0, classeDeTeste133.obterAtributosProprios().size());
		assertEquals(1, classeDeTeste133.obterAtributosAcessorios().size());
		assertEquals(0, classeDeTeste133.obterMetodosDeConfiguracao().size());
		assertEquals(1, classeDeTeste133.obterMetodosDeTeste().size());
		assertEquals(0, classeDeTeste133.obterMetodosDeTesteIgnorados().size());
		assertEquals(classeDeTeste131, classeDeTeste133.obterClassesProvedoras().get(0));
		assertEquals(classeDeTeste132, classeDeTeste133.obterClassesProvedoras().get(1));
		assertEquals(classeDeTeste133Numeros, classeDeTeste133.obterAtributosAcessorios().get(0));
		assertEquals(classeDeTeste133Testar, classeDeTeste133.obterMetodosDeTeste().get(0));
		assertFalse(classeDeTeste133.singular());
		assertFalse(classeDeTeste133.ignorada());
		assertFalse(classeDeTeste119.vazia());
	}

	@Test
	public void classeDeTeste136() throws Exception {
		assertEquals(ClasseDeTeste136.class, classeDeTeste136.obterClasse());
		assertEquals(0, classeDeTeste119.obterClassesConsumidoras().size());
		assertEquals(0, classeDeTeste136.obterClassesProvedoras().size());
		assertEquals(0, classeDeTeste136.obterAtributosProprios().size());
		assertEquals(0, classeDeTeste136.obterAtributosAcessorios().size());
		assertEquals(0, classeDeTeste136.obterMetodosDeConfiguracao().size());
		assertEquals(1, classeDeTeste136.obterMetodosDeTeste().size());
		assertEquals(1, classeDeTeste136.obterMetodosDeTesteIgnorados().size());
		assertEquals(classeDeTeste136Testar1, classeDeTeste136.obterMetodosDeTeste().get(0));
		assertEquals(classeDeTeste136Testar2, classeDeTeste136.obterMetodosDeTesteIgnorados().get(0));
		assertFalse(classeDeTeste136.singular());
		assertTrue(classeDeTeste136.ignorada());
		assertFalse(classeDeTeste119.vazia());
	}

}
