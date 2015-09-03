package br.ufsc.ine.leb.projetos.estoria;

public class Estoria extends EscoltadorDeTestes {

	public Estoria(Class<?> classe) throws InstantiationException, IllegalAccessException {
		super(construirSeletor(classe));
		System.out.println("eu rodei");
	}

	private static SeletorDeTestes construirSeletor(Class<?> classe) throws InstantiationException, IllegalAccessException {
		return SeletorDeTestes.class.isAssignableFrom(classe) ? (SeletorDeTestes) classe.newInstance() : new SeletorDeTestes(classe);
	}

}
