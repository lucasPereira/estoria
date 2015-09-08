package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

public final class ClasseDeTeste {

	private Class<?> classe;
	private List<ClasseDeTeste> acessorios;
	private List<MetodoDeTeste> metodosDeTeste;
	private List<MetodoDeTeste> metodosDeTesteIgnorados;
	private List<MetodoDeConfiguracao> metodosDeConfiguracao;

	public ClasseDeTeste(Class<?> classe) {
		this.classe = classe;
		this.acessorios = new LinkedList<>();
		this.metodosDeTeste = new LinkedList<>();
		this.metodosDeTesteIgnorados = new LinkedList<>();
		this.metodosDeConfiguracao = new LinkedList<>();
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(classe);
		seletor.obterMetodosTeste().forEach(metodo -> metodosDeTeste.add(new MetodoDeTeste(this, metodo)));
		seletor.obterMetodosDeTesteIgnorados().forEach(metodo -> metodosDeTesteIgnorados.add(new MetodoDeTeste(this, metodo)));
		seletor.obterMetodosDeConfiguracao().forEach(metodo -> metodosDeConfiguracao.add(new MetodoDeConfiguracao(metodo)));
		seletor.obterAcessorios().forEach(classeDoAcessorio -> acessorios.add(new ClasseDeTeste(classeDoAcessorio)));
	}

	public Class<?> obterClasse() {
		return classe;
	}

	public List<MetodoDeTeste> obterMetodosDeTeste() {
		return metodosDeTeste;
	}

	public List<MetodoDeTeste> obterMetodosDeTesteIgnorados() {
		return metodosDeTesteIgnorados;
	}

	public List<MetodoDeConfiguracao> obterMetodosDeConfiguracao() {
		return metodosDeConfiguracao;
	}

	public List<ClasseDeTeste> obterAcessorios() {
		return acessorios;
	}

}
