package br.ufsc.ine.leb.projetos.estoria;

public final class EstoriaReaproveitador extends EscoltadorDeTestesReaproveitador {

	public EstoriaReaproveitador(Class<?> classe) throws InstantiationException, IllegalAccessException {
		super(new SuiteDeTeste(classe), new Ata());
	}

}
