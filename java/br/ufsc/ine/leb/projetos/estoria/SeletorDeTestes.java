package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public final class SeletorDeTestes {

	private List<SelecaoDeTeste> selecoesDeTeste;
	private List<SelecaoDeTeste> selecoesDeTesteIgnorados;
	private List<SelecaoDeTeste> selecoesDeConfiguracao;

	public SeletorDeTestes() {
		selecoesDeTeste = new LinkedList<>();
		selecoesDeTesteIgnorados = new LinkedList<>();
		selecoesDeConfiguracao = new LinkedList<>();
	}

	public void adicionarClasse(Class<?> classe) {
		FiltradorDeMetodos filtradorBase = construirFiltradorBase(classe);
		FiltradorDeMetodos filtradorDeTestes = filtradorBase.clonar().removerMetodosNaoAnotadosCom(Test.class).removerMetodosAnotadosCom(Ignore.class);
		FiltradorDeMetodos filtradorDeTestesIgnorados = filtradorBase.clonar().removerMetodosNaoAnotadosCom(Test.class).removerMetodosNaoAnotadosCom(Ignore.class);
		FiltradorDeMetodos filtradorDeConfiguracao = filtradorBase.clonar().removerMetodosNaoAnotadosCom(Before.class);
		adicionarSelecao(selecoesDeTeste, filtradorDeTestes, classe);
		adicionarSelecao(selecoesDeTesteIgnorados, filtradorDeTestesIgnorados, classe);
		adicionarSelecao(selecoesDeConfiguracao, filtradorDeConfiguracao, classe);
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

	private void adicionarSelecao(List<SelecaoDeTeste> container, FiltradorDeMetodos filtrador, Class<?> classe) {
		filtrador.obterMetodos().forEach(metodo -> container.add(new SelecaoDeTeste(classe, metodo.getName())));
	}

	public List<SelecaoDeTeste> obterSelecoesDeTeste() {
		return selecoesDeTeste;
	}

	public List<SelecaoDeTeste> obterSelecoesDeTesteIgnorados() {
		return selecoesDeTesteIgnorados;
	}

	public List<SelecaoDeTeste> obterSelecoesDeConfiguracao() {
		return selecoesDeConfiguracao;
	}

}
