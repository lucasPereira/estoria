package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.EspiaoDeInvocacao;
import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.InvocadorDeMetodo;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisAtributosDoisMetodos;

public final class TesteInvocadorDeMetodo {

	private List<Method> metodos;
	private EspiaoDeInvocacao espiaoDeInvocao;
	private InvocadorDeMetodo<ClasseComDoisAtributosDoisMetodos> invocador;

	@Before
	public void prepararCenario() {
		metodos = new FiltradorDeMetodos(ClasseComDoisAtributosDoisMetodos.class).removerMetodosComRetorno().obterMetodos();
		espiaoDeInvocao = new EspiaoDeInvocacao();
		invocador = new InvocadorDeMetodo<>(ClasseComDoisAtributosDoisMetodos.class);
	}

	@Test
	public void executarMetodoComExcecao() throws Exception {
		invocador.executar(metodos.get(0), espiaoDeInvocao);
		assertEquals("comExcecao", metodos.get(0).getName());
		assertFalse(espiaoDeInvocao.executouSemExcecao());
		assertTrue(espiaoDeInvocao.executouComExcecao());
		assertEquals(RuntimeException.class, espiaoDeInvocao.obterExcecao().getClass());
		assertEquals(0, invocador.obterInstancia().obterAtributo1());
		assertEquals(20, invocador.obterInstancia().obterAtributo2());
	}

	@Test
	public void executarMetodoSemExcecao() throws Exception {
		invocador.executar(metodos.get(1), espiaoDeInvocao);
		assertEquals("semExcecao", metodos.get(1).getName());
		assertTrue(espiaoDeInvocao.executouSemExcecao());
		assertFalse(espiaoDeInvocao.executouComExcecao());
		assertEquals(10, invocador.obterInstancia().obterAtributo1());
		assertEquals(0, invocador.obterInstancia().obterAtributo2());
	}

}
