package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

public final class ClasseDeTeste {

	private Class<?> classe;
	private Boolean singular;
	private Boolean ignorada;
	private List<ClasseDeTeste> acessorios;
	private List<MetodoDeTeste> metodosDeTeste;
	private List<MetodoDeTeste> metodosDeTesteIgnorados;
	private List<MetodoDeConfiguracao> metodosDeConfiguracao;
	private List<AtributoProprio> atributosProprios;
	private List<AtributoAcessorio> atributosAcessorios;

	public ClasseDeTeste(Class<?> classe) {
		this.classe = classe;
		this.acessorios = new LinkedList<>();
		this.metodosDeTeste = new LinkedList<>();
		this.metodosDeTesteIgnorados = new LinkedList<>();
		this.metodosDeConfiguracao = new LinkedList<>();
		this.atributosProprios = new LinkedList<>();
		this.atributosAcessorios = new LinkedList<>();
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(classe);
		seletor.obterAcessorios().forEach(classeDoAcessorio -> acessorios.add(new ClasseDeTeste(classeDoAcessorio)));
		seletor.obterMetodosTeste().forEach(metodo -> metodosDeTeste.add(new MetodoDeTeste(this, metodo)));
		seletor.obterMetodosDeTesteIgnorados().forEach(metodo -> metodosDeTesteIgnorados.add(new MetodoDeTeste(this, metodo)));
		seletor.obterMetodosDeConfiguracao().forEach(metodo -> metodosDeConfiguracao.add(new MetodoDeConfiguracao(metodo)));
		seletor.obterAtributosProprios().forEach(atributo -> atributosProprios.add(new AtributoProprio(atributo)));
		seletor.obterAtributosAcessorios().forEach(atributo -> atributosAcessorios.add(new AtributoAcessorio(atributo)));
		this.singular = seletor.classeSingular();
		this.ignorada = seletor.classeIgnorada();
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

	public List<AtributoProprio> obterAtributosProprios() {
		return atributosProprios;
	}

	public List<AtributoAcessorio> obterAtributosAcessorios() {
		return atributosAcessorios;
	}

	public Boolean singular() {
		return singular;
	}

	public Boolean ignorada() {
		return ignorada;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof ClasseDeTeste) {
			ClasseDeTeste outra = (ClasseDeTeste) objeto;
			return classe.equals(outra.classe);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return classe.hashCode();
	}

	@Override
	public String toString() {
		return classe.getSimpleName();
	}

}
