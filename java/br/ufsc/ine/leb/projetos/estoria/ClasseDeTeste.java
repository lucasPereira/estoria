package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

public final class ClasseDeTeste {

	private Class<?> classe;
	private Boolean singular;
	private Boolean ignorada;
	private List<Metodo> metodosDeTeste;
	private List<Metodo> metodosDeTesteIgnorados;
	private List<Metodo> metodosDeConfiguracao;
	private List<Atributo> atributosProprios;
	private List<Atributo> atributosAcessorios;
	private List<ClasseDeTeste> classesProvedoras;
	private List<ClasseDeTeste> classesConsumidoras;

	public ClasseDeTeste(Class<?> classe, RepositorioDeClassesDeTeste repositorio) {
		this.classe = classe;
		this.classesProvedoras = new LinkedList<>();
		this.classesConsumidoras = new LinkedList<>();
		this.metodosDeTeste = new LinkedList<>();
		this.metodosDeTesteIgnorados = new LinkedList<>();
		this.metodosDeConfiguracao = new LinkedList<>();
		this.atributosProprios = new LinkedList<>();
		this.atributosAcessorios = new LinkedList<>();
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(classe);
		seletor.obterAcessorios().forEach(classeProvedora -> classesProvedoras.add(repositorio.construir(classeProvedora)));
		seletor.obterMetodosTeste().forEach(metodo -> metodosDeTeste.add(new Metodo(metodo, repositorio)));
		seletor.obterMetodosDeTesteIgnorados().forEach(metodo -> metodosDeTesteIgnorados.add(new Metodo(metodo, repositorio)));
		seletor.obterMetodosDeConfiguracao().forEach(metodo -> metodosDeConfiguracao.add(new Metodo(metodo, repositorio)));
		seletor.obterAtributosProprios().forEach(atributo -> atributosProprios.add(new Atributo(atributo, repositorio)));
		seletor.obterAtributosAcessorios().forEach(atributo -> atributosAcessorios.add(new Atributo(atributo, repositorio)));
		this.singular = seletor.classeSingular();
		this.ignorada = seletor.classeIgnorada();
		this.classesProvedoras.forEach(classeProvedora -> classeProvedora.classesConsumidoras.add(this));
	}

	public Class<?> obterClasse() {
		return classe;
	}

	public List<Metodo> obterMetodosDeTeste() {
		return metodosDeTeste;
	}

	public List<Metodo> obterMetodosDeTesteIgnorados() {
		return metodosDeTesteIgnorados;
	}

	public List<Metodo> obterMetodosDeConfiguracao() {
		return metodosDeConfiguracao;
	}

	public List<ClasseDeTeste> obterClassesProvedoras() {
		return classesProvedoras;
	}

	public List<Atributo> obterAtributosProprios() {
		return atributosProprios;
	}

	public List<Atributo> obterAtributosAcessorios() {
		return atributosAcessorios;
	}

	public Boolean singular() {
		return singular;
	}

	public Boolean ignorada() {
		return ignorada;
	}

	public Boolean vazia() {
		return metodosDeTesteIgnorados.isEmpty() && metodosDeTeste.isEmpty();
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

	public List<ClasseDeTeste> obterClassesConsumidoras() {
		return classesConsumidoras;
	}

}
