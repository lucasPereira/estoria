package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public final class SeletorDeTestes {

	private List<SelecaoDeTeste> selecoes;
	private List<SelecaoDeTeste> selecoesIgnoradas;

	public SeletorDeTestes() {
		selecoes = new LinkedList<>();
		selecoesIgnoradas = new LinkedList<>();
	}

	public void adicionarClasse(Class<?> classe) {
		FiltradorDeMetodos filtrador = new FiltradorDeMetodos(classe);
		filtrador.removerMetodosAbstratos();
		filtrador.removerMetodosNativos();
		filtrador.removerMetodosNaoAnotadosCom(Test.class);
		filtrador.removerMetodosComRetorno();
		filtrador.removerMetodosPrivados();
		filtrador.removerMetodosDefault();
		filtrador.removerMetodosProtegidos();
		filtrador.removerMetodosEstaticos();
		filtrador.removerMetodosGenericos();
		filtrador.removerMetodosParametrizados();
		filtrador.removerMetodosSincronizados();
		FiltradorDeMetodos filtradorDeIgnorados = filtrador.clonar();
		filtrador.removerMetodosAnotadosCom(Ignore.class);
		filtradorDeIgnorados.removerMetodosNaoAnotadosCom(Ignore.class);
		filtrador.obterMetodos().forEach(metodo -> selecoes.add(new SelecaoDeTeste(classe, metodo.getName())));
		filtradorDeIgnorados.obterMetodos().forEach(metodo -> selecoesIgnoradas.add(new SelecaoDeTeste(classe, metodo.getName())));
	}

	public List<SelecaoDeTeste> obterSelecoes() {
		return selecoes;
	}

	public List<SelecaoDeTeste> obterSelecoesIgnoradas() {
		return selecoesIgnoradas;
	}

}
