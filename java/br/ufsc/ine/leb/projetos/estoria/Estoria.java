package br.ufsc.ine.leb.projetos.estoria;

public final class Estoria extends EscoltadorDeTestesReaproveitador {

	public Estoria(Class<?> classe) throws InstantiationException, IllegalAccessException {
		super(new SuiteDeTeste(classe), new Ata());
	}

}
