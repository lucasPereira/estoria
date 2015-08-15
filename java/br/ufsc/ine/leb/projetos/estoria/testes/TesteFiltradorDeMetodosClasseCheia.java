package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheia;

public final class TesteFiltradorDeMetodosClasseCheia {

	private FiltradorDeMetodos filtrador;

	@Before
	public void prepararCenario() {
		filtrador = new FiltradorDeMetodos(ClasseCheia.class);
	}

	@Test
	public void semFiltro() throws Exception {
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(21, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTeste", iterador.next().getName());
		assertEquals("metodoAnotadoComTeste", iterador.next().getName());
		assertEquals("metodoAnotadoComTesteIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoNoParametroComDeprecated", iterador.next().getName());
		assertEquals("metodoAnotadoNoRetornoComIgnore", iterador.next().getName());
		assertEquals("metodoComExcecao", iterador.next().getName());
		assertEquals("metodoComRetorno", iterador.next().getName());
		assertEquals("metodoComRetornoArrayAntes", iterador.next().getName());
		assertEquals("metodoComRetornoArrayDepois", iterador.next().getName());
		assertEquals("metodoDefault", iterador.next().getName());
		assertEquals("metodoEstatico", iterador.next().getName());
		assertEquals("metodoEstritoDePontoFlutuante", iterador.next().getName());
		assertEquals("metodoFinal", iterador.next().getName());
		assertEquals("metodoGenerico", iterador.next().getName());
		assertEquals("metodoNativo", iterador.next().getName());
		assertEquals("metodoParametrizado", iterador.next().getName());
		assertEquals("metodoPrivado", iterador.next().getName());
		assertEquals("metodoProtegido", iterador.next().getName());
		assertEquals("metodoSincronizado", iterador.next().getName());
	}

	@Test
	public void filtrarMetodosAbstratos() throws Exception {
		filtrador.removerMetodosAbstratos();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(20, metodos.size());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTeste", iterador.next().getName());
		assertEquals("metodoAnotadoComTeste", iterador.next().getName());
		assertEquals("metodoAnotadoComTesteIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoNoParametroComDeprecated", iterador.next().getName());
		assertEquals("metodoAnotadoNoRetornoComIgnore", iterador.next().getName());
		assertEquals("metodoComExcecao", iterador.next().getName());
		assertEquals("metodoComRetorno", iterador.next().getName());
		assertEquals("metodoComRetornoArrayAntes", iterador.next().getName());
		assertEquals("metodoComRetornoArrayDepois", iterador.next().getName());
		assertEquals("metodoDefault", iterador.next().getName());
		assertEquals("metodoEstatico", iterador.next().getName());
		assertEquals("metodoEstritoDePontoFlutuante", iterador.next().getName());
		assertEquals("metodoFinal", iterador.next().getName());
		assertEquals("metodoGenerico", iterador.next().getName());
		assertEquals("metodoNativo", iterador.next().getName());
		assertEquals("metodoParametrizado", iterador.next().getName());
		assertEquals("metodoPrivado", iterador.next().getName());
		assertEquals("metodoProtegido", iterador.next().getName());
		assertEquals("metodoSincronizado", iterador.next().getName());
	}

}
