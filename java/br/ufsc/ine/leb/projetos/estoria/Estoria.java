package br.ufsc.ine.leb.projetos.estoria;

public final class Estoria extends EscoltadorDeTestes {

	public Estoria(Class<?> classe) throws InstantiationException, IllegalAccessException {
		super(new SuiteDeTeste(classe));
		System.out.println("Estória");
	}

}
