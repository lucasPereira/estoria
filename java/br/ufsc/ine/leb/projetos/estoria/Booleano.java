package br.ufsc.ine.leb.projetos.estoria;

public final class Booleano {

	private Boolean valorReduzido;

	public Booleano() {
		valorReduzido = true;
	}

	public void e(Boolean valor) {
		valorReduzido = valorReduzido && valor;
	}

	public Boolean reduzir() {
		return valorReduzido;
	}

}
