package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class ConstrutorDoEstoria extends RunnerBuilder {

	@Override
	public Runner runnerForClass(Class<?> classe) throws Throwable {
		return new Estoria(classe);
	}

}
