package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public final class EscoltadorDeTestes extends Runner {

	private Description descricao;

	public EscoltadorDeTestes(SeletorDeTestes seletor) {
		descricao = Description.createSuiteDescription(seletor.getClass().getName(), seletor.getClass().getAnnotations());
	}

	@Override
	public Description getDescription() {
		return descricao;
	}

	@Override
	public void run(RunNotifier mensageiroDeEscolta) {
		
	}

}
