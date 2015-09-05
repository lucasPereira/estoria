package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.EspiaoDeInvocacao;
import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.InvocadorDeMetodo;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisMetodos;

public final class TesteInvocadorDeMetodo {

	private List<Method> metodos;

	@Before
	public void prepararCenario() {
		metodos = new FiltradorDeMetodos(ClasseComDoisMetodos.class).obterMetodos();
	}

	@Test
	public void comExcecao() throws Exception {
		EspiaoDeInvocacao espiaoDeInvocao = new EspiaoDeInvocacao();
		InvocadorDeMetodo invocador = new InvocadorDeMetodo(ClasseComDoisMetodos.class);
		invocador.executar(metodos.get(0), espiaoDeInvocao);
		assertFalse(espiaoDeInvocao.executouSemExcecao());
		assertTrue(espiaoDeInvocao.executouComExcecao());
		assertEquals(RuntimeException.class, espiaoDeInvocao.obterExcecao().getClass());
	}

	@Test
	public void semExcecao() throws Exception {
		EspiaoDeInvocacao espiaoDeInvocao = new EspiaoDeInvocacao();
		InvocadorDeMetodo invocador = new InvocadorDeMetodo(ClasseComDoisMetodos.class);
		invocador.executar(metodos.get(1), espiaoDeInvocao);
		assertTrue(espiaoDeInvocao.executouSemExcecao());
		assertFalse(espiaoDeInvocao.executouComExcecao());
	}

}
