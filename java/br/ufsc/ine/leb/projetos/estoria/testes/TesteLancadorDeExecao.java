package br.ufsc.ine.leb.projetos.estoria.testes;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.ExcecaoChecadaQueNaoDeveriaSerLancada;
import br.ufsc.ine.leb.projetos.estoria.LancadorDeExcecao;

public final class TesteLancadorDeExecao {

	@Test(expected = ExcecaoChecadaQueNaoDeveriaSerLancada.class)
	public void testar() {
		new LancadorDeExcecao().lancar(new Exception());
	}

}
