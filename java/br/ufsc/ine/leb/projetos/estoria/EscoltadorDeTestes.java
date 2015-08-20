package br.ufsc.ine.leb.projetos.estoria;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public final class EscoltadorDeTestes extends Runner {

	private Description descricao;

	public EscoltadorDeTestes(SeletorDeTestes seletor) {
		List<SelecaoDeTeste> selecoes = seletor.obterSelecoes();
		descricao = Description.createSuiteDescription(seletor.getClass().getName());
		for (SelecaoDeTeste selecao : selecoes) {
			Class<?> classeDoTeste = selecao.obterClasse();
			String metodoDeTeste = selecao.obterMetodoDeTeste();
			Description descricaoDoTeste = Description.createTestDescription(classeDoTeste, metodoDeTeste);
			descricao.addChild(descricaoDoTeste);
		}
	}

	@Override
	public Description getDescription() {
		return descricao;
	}

	@Override
	public void run(RunNotifier mensageiroDeEscolta) {

	}

}
