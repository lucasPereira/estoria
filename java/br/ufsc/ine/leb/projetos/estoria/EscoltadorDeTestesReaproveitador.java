package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestesReaproveitador extends Runner implements Filterable {

	public EscoltadorDeTestesReaproveitador(SuiteDeTeste suiteDeTeste) {
		this(suiteDeTeste, new Ata());
	}

	public EscoltadorDeTestesReaproveitador(SuiteDeTeste suiteDeTeste, Ata ata) {}

	@Override
	public final Description getDescription() {
		return null;
	}

	@Override
	public final void run(RunNotifier mensageiroDeEscolta) {}

	@Override
	public void filter(Filter filtro) throws NoTestsRemainException {}

}
