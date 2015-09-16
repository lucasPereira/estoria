package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.*;
import java.util.*;

import org.junit.*;
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
		return construirFiltradorDeAtributosBase().removerAtributosAnotadosCom(Acessorio.class).obterAtributos();
	}

	public List<Field> obterAtributosAcessorios() {
		return construirFiltradorDeAtributosBase().removerAtributosNaoAnotadosCom(Acessorio.class).obterAtributos();
	}

	public List<Class<?>> obterClassesDeSuite() {
		SuiteClasses anotacao = classe.getDeclaredAnnotation(SuiteClasses.class);
		return (anotacao == null) ? Arrays.asList(classe) : Arrays.asList(anotacao.value());
	}

	public List<Class<?>> obterAcessorios() {
		List<Class<?>> acessorios = new LinkedList<>();
		List<Acessorios> anotacoesAcessorios = Arrays.asList(classe.getDeclaredAnnotationsByType(Acessorios.class));
		anotacoesAcessorios.forEach(anotacaoAcessorio -> Arrays.asList(anotacaoAcessorio.value()).forEach(classeAcessorio -> acessorios.add(classeAcessorio)));
		return acessorios;
	}

}
