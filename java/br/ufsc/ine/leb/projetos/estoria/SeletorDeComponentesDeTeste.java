package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;

public final class SeletorDeComponentesDeTeste {

	private Class<?> classe;
	private FiltradorDeMetodos filtradorDeMetodos;
	private FiltradorDeAtributos filtradorDeAtributos;

	public SeletorDeComponentesDeTeste(Class<?> classe) {
		this.classe = classe;
	}

	private FiltradorDeMetodos construirFiltradorBase() {
		if (filtradorDeMetodos == null) {
			filtradorDeMetodos = new FiltradorDeMetodos(classe);
			filtradorDeMetodos.removerMetodosAbstratos();
			filtradorDeMetodos.removerMetodosNativos();
			filtradorDeMetodos.removerMetodosComRetorno();
			filtradorDeMetodos.removerMetodosPrivados();
			filtradorDeMetodos.removerMetodosDefault();
			filtradorDeMetodos.removerMetodosProtegidos();
			filtradorDeMetodos.removerMetodosEstaticos();
			filtradorDeMetodos.removerMetodosGenericos();
			filtradorDeMetodos.removerMetodosParametrizados();
			filtradorDeMetodos.removerMetodosSincronizados();
		}
		return filtradorDeMetodos.clonar();
	}

	private FiltradorDeAtributos construirFiltradorDeAtributosBase() {
		if (filtradorDeAtributos == null) {
			filtradorDeAtributos = new FiltradorDeAtributos(classe);
		}
		return filtradorDeAtributos.clonar();
	}

	public List<Method> obterMetodosTeste() {
		return construirFiltradorBase().removerMetodosNaoAnotadosCom(Test.class).removerMetodosAnotadosCom(Ignore.class).obterMetodos();
	}

	public List<Method> obterMetodosDeTesteIgnorados() {
		return construirFiltradorBase().removerMetodosNaoAnotadosCom(Test.class).removerMetodosNaoAnotadosCom(Ignore.class).obterMetodos();
	}

	public List<Method> obterMetodosDeConfiguracao() {
		return construirFiltradorBase().removerMetodosNaoAnotadosCom(Before.class).obterMetodos();
	}

	public List<Field> obterAtributosProprios() {
		return construirFiltradorDeAtributosBase().removerAtributosAnotadosCom(Fixture.class).obterAtributos();
	}

	public List<Field> obterAtributosAcessorios() {
		return construirFiltradorDeAtributosBase().removerAtributosNaoAnotadosCom(Fixture.class).obterAtributos();
	}

	public List<Class<?>> obterClassesDeSuite() {
		SuiteClasses anotacao = classe.getDeclaredAnnotation(SuiteClasses.class);
		return (anotacao == null) ? Arrays.asList(classe) : Arrays.asList(anotacao.value());
	}

	public List<Class<?>> obterAcessorios() {
		List<Class<?>> acessorios = new LinkedList<>();
		List<FixtureSetup> anotacoesAcessorios = Arrays.asList(classe.getDeclaredAnnotationsByType(FixtureSetup.class));
		anotacoesAcessorios.forEach(anotacaoAcessorio -> Arrays.asList(anotacaoAcessorio.value()).forEach(classeAcessorio -> acessorios.add(classeAcessorio)));
		return acessorios;
	}

	public Boolean classeSingular() {
		return classe.getDeclaredAnnotation(Singular.class) != null;
	}

	public Boolean classeIgnorada() {
		return classe.getDeclaredAnnotation(Ignore.class) != null;
	}

}
