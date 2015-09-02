package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.EspiaoDeInvocacao;
import br.ufsc.ine.leb.projetos.estoria.InvocadorDeMetodo;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisMetodos;

public class TesteInvocadorDeMetodo {

	@Test
	public void semExcecao() throws Exception {
		EspiaoDeInvocacao espiaoDeInvocao = new EspiaoDeInvocacao();
		InvocadorDeMetodo invocador = new InvocadorDeMetodo(ClasseComDoisMetodos.class);
		invocador.executar("semExcecao", espiaoDeInvocao);
		assertTrue(espiaoDeInvocao.executouSemExcecao());
		assertFalse(espiaoDeInvocao.executouComExcecao());
	}

	@Test
	public void comExcecao() throws Exception {
		EspiaoDeInvocacao espiaoDeInvocao = new EspiaoDeInvocacao();
		InvocadorDeMetodo invocador = new InvocadorDeMetodo(ClasseComDoisMetodos.class);
		invocador.executar("comExcecao", espiaoDeInvocao);
		assertFalse(espiaoDeInvocao.executouSemExcecao());
		assertTrue(espiaoDeInvocao.executouComExcecao());
		assertEquals(RuntimeException.class, espiaoDeInvocao.obterExcecao().getClass());
	}

}
