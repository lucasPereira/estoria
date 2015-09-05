package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

public final class SuiteDeTeste {

	private Class<?> suite;
	private List<ClasseDeTeste> classesDeTeste;

	public SuiteDeTeste(Class<?> suite) {
		this.classesDeTeste = new LinkedList<>();
		this.suite = suite;
		SeletorDeComponentesDeTestes seletor = new SeletorDeComponentesDeTestes(suite);
		seletor.obterClassesDeSuite().forEach(classe -> adicionarClasse(classe));
		if (!seletor.possuiAnotacaoClassesDeSuite()) {
			adicionarClasse(suite);
		}
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

}
