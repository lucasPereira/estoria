package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

public final class SuiteDeTeste {

	private Class<?> suite;
	private Boolean ignorada;
	private List<ClasseDeTeste> classesDeTeste;

	public SuiteDeTeste(Class<?> suite) {
		this.suite = suite;
		this.classesDeTeste = new LinkedList<>();
		RepositorioDeClassesDeTeste repositorio = new RepositorioDeClassesDeTeste();
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(suite);
		seletor.obterClassesDeSuite().forEach(classe -> classesDeTeste.add(repositorio.construir(classe)));
		this.ignorada = seletor.classeIgnorada();
	}

	public Class<?> obterSuite() {
		return suite;
	}

	public List<ClasseDeTeste> obterClassesDeTeste() {
		return classesDeTeste;
	}

	public Boolean ignorada() {
		return ignorada;
	}

	public Boolean vazia() {
		return classesDeTeste.isEmpty();
	}

	public Boolean classeDeTesteComoSuite() {
		return classesDeTeste.size() == 1 && suite.equals(classesDeTeste.iterator().next().obterClasse());
	}

	@Override
	public String toString() {
		return suite.getSimpleName();
	}

}
