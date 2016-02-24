package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

public final class SuiteDeTeste {

	private Class<?> suite;
	private Boolean ignorada;
	private List<ClasseDeTeste> classesDeTeste;

	public SuiteDeTeste(Class<?> suite) {
		this.suite = suite;
		this.classesDeTeste = new LinkedList<>();
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

	@SemTeste
	public Description obterDescricao(Filter filtro) {
		Description descricao = Description.createSuiteDescription(suite);
		classesDeTeste.forEach(classeDeTeste -> classeDeTeste.criarDescricao(descricao, filtro));
		if (semTestes()) {
			descricao.addChild(Description.EMPTY);
		}
		return classeDeTesteComoSuite() ? descricao.getChildren().iterator().next() : descricao;
	}

	@Override
	public String toString() {
		return suite.getSimpleName();
	}

	private Boolean semTestes() {
		return classesDeTeste.isEmpty();
	}

	private Boolean classeDeTesteComoSuite() {
		return classesDeTeste.size() == 1 && suite.equals(classesDeTeste.iterator().next().obterClasse());
	}

}
