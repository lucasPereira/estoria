package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.*;
import java.util.*;

import org.junit.*;
import org.junit.runners.Suite.SuiteClasses;

public final class SeletorDeComponentesDeTestes {

	private Class<?> classe;
	private FiltradorDeMetodos filtradorBase;

	public SeletorDeComponentesDeTestes(Class<?> classe) {
		this.classe = classe;
	}

	private FiltradorDeMetodos construirFiltradorBase() {
		if (filtradorBase == null) {
			filtradorBase = new FiltradorDeMetodos(classe);
			filtradorBase.removerMetodosAbstratos();
			filtradorBase.removerMetodosNativos();
			filtradorBase.removerMetodosComRetorno();
			filtradorBase.removerMetodosPrivados();
			filtradorBase.removerMetodosDefault();
			filtradorBase.removerMetodosProtegidos();
			filtradorBase.removerMetodosEstaticos();
			filtradorBase.removerMetodosGenericos();
			filtradorBase.removerMetodosParametrizados();
			filtradorBase.removerMetodosSincronizados();
		}
		return filtradorBase.clonar();
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
