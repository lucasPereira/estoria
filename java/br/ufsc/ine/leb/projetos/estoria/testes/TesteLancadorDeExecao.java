package br.ufsc.ine.leb.projetos.estoria.testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.ExcecaoChecadaQueNaoDeveriaSerLancada;
import br.ufsc.ine.leb.projetos.estoria.LancadorDeExcecao;

@RunWith(JUnit4.class)
public final class TesteLancadorDeExecao {

	@Test(expected = ExcecaoChecadaQueNaoDeveriaSerLancada.class)
	public void testar() {
		new LancadorDeExcecao().lancar(new Exception());
	}

}
