package br.ufsc.ine.leb.projetos.estoria.testes;

import java.lang.annotation.Annotation;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTeste extends Runner {

	
	private Description descricao;

	public EscoltadorDeTeste(Class<?> classe) {
		descricao = Description.createSuiteDescription(classe.getName(), classe.getAnnotations());
	}

	@Override
	public Description getDescription() {
		return descricao;
	}

	@Override
	public void run(RunNotifier mensageiroDeEscolta) {
		
	}

}
