package br.ufsc.ine.leb.projetos.estoria;

public final class EstoriaPadrao extends EscoltadorDeTestesPadrao {

	public EstoriaPadrao(Class<?> classe) throws InstantiationException, IllegalAccessException {
		super(new SuiteDeTeste(classe), new Ata());
		System.out.println("Padrão");
	}

}
