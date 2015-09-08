package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.*;
import org.junit.runners.model.*;

public class ConstrutorDoEstoria extends RunnerBuilder {

	@Override
	public Runner runnerForClass(Class<?> classe) throws Throwable {
		return new Estoria(classe);
	}

}
