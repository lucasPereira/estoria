package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SeletorDeTestes {

	private List<CasoDeTeste> casosDeTeste;
	private List<CasoDeTeste> casosDeTesteIgnorados;

	public SeletorDeTestes() {
		casosDeTeste = new LinkedList<>();
		casosDeTesteIgnorados = new LinkedList<>();
	}

	SeletorDeTestes(Class<?> classe) {
		this();
		adicionarClasse(classe);
	}

	public void adicionarClasse(Class<?> classe) {
		FiltradorDeMetodos filtradorBase = construirFiltradorBase(classe);
		FiltradorDeMetodos filtradorDeTestes = filtradorBase.clonar().removerMetodosNaoAnotadosCom(Test.class).removerMetodosAnotadosCom(Ignore.class);
		FiltradorDeMetodos filtradorDeTestesIgnorados = filtradorBase.clonar().removerMetodosNaoAnotadosCom(Test.class).removerMetodosNaoAnotadosCom(Ignore.class);
		FiltradorDeMetodos filtradorDeConfiguracao = filtradorBase.clonar().removerMetodosNaoAnotadosCom(Before.class);
		String metodoDeConfiguracao = filtradorDeConfiguracao.reduzir(metodo -> metodo.getName());
		adicionarSelecao(casosDeTeste, filtradorDeTestes, classe, metodoDeConfiguracao);
		adicionarSelecao(casosDeTesteIgnorados, filtradorDeTestesIgnorados, classe, metodoDeConfiguracao);
	}

	private FiltradorDeMetodos construirFiltradorBase(Class<?> classe) {
		FiltradorDeMetodos filtradorBase = new FiltradorDeMetodos(classe);
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
		return filtradorBase;
	}

	private void adicionarSelecao(List<CasoDeTeste> container, FiltradorDeMetodos filtrador, Class<?> classe, String metodoDeConfiguracao) {
		filtrador.obterMetodos().forEach(metodo -> container.add(new CasoDeTeste(classe, metodo.getName(), metodoDeConfiguracao)));
	}

	public List<CasoDeTeste> obterCasosDeTeste() {
		return casosDeTeste;
	}

	public List<CasoDeTeste> obterCasosDeTesteIgnorados() {
		return casosDeTesteIgnorados;
	}

}
