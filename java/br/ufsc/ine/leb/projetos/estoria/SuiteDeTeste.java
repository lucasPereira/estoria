package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

public final class SuiteDeTeste {

	private Class<?> suite;
	private Boolean ignorada;
	private List<ClasseDeTeste> classesDeTeste;

	public SuiteDeTeste(Class<?> suite) {
		this.classesDeTeste = new LinkedList<>();
		this.suite = suite;
		SeletorDeComponentesDeTeste seletor = new SeletorDeComponentesDeTeste(suite);
		seletor.obterClassesDeSuite().forEach(classe -> adicionarClasse(classe));
		this.ignorada = seletor.classeIgnorada();
	}

	private void adicionarClasse(Class<?> suite) {
		classesDeTeste.add(new ClasseDeTeste(suite));
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

}
