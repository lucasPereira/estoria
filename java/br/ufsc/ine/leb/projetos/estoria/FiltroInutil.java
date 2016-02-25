package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

public final class FiltroInutil extends Filter {

	@Override
	public boolean shouldRun(Description description) {
		return true;
	}

	@Override
	public String describe() {
		return null;
	}

}
