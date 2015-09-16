package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Field;

public class EnxertorDeAtributo {

	private Object origem;
	private Object destino;

	public EnxertorDeAtributo(Object origem, Object destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public void enxertar(Field atributoDeOrigem, Field atributoDeDestino) {
		Boolean acessoOrigem = atributoDeOrigem.isAccessible();
		Boolean acessoDestino = atributoDeDestino.isAccessible();
		atributoDeOrigem.setAccessible(true);
		atributoDeDestino.setAccessible(true);
		try {
			atributoDeDestino.set(destino, atributoDeOrigem.get(origem));
		} catch (IllegalArgumentException | IllegalAccessException excecao) {
			new LancadorDeExcecao().lancar(excecao);
		} finally {
			atributoDeOrigem.setAccessible(acessoOrigem);
			atributoDeDestino.setAccessible(acessoDestino);
		}
	}

}
