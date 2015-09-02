package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.FiltradorDeMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseCheiaDeMetodos;

public final class TesteFiltradorDeMetodosClasseCheia {

	private FiltradorDeMetodos filtrador;

	@Before
	public void prepararCenario() {
		filtrador = new FiltradorDeMetodos(ClasseCheiaDeMetodos.class);
	}

	@Test
	public void semFiltro() throws Exception {
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(20, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
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
		assertFalse(filtrador.vazio());
	}

	@Test
	public void filtrarMetodosAbstratos() throws Exception {
		filtrador.removerMetodosAbstratos();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(19, metodos.size());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
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
	public void filtrarMetodosNaoAnotadosComTest() throws Exception {
		filtrador.removerMetodosNaoAnotadosCom(Test.class);
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(4, metodos.size());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
	}

	@Test
	public void clonarFiltrador() throws Exception {
		filtrador.removerMetodosNaoAnotadosCom(Test.class);
		FiltradorDeMetodos filtradorClone = filtrador.clonar();
		filtrador.removerMetodosAnotadosCom(Ignore.class);
		filtradorClone.removerMetodosNaoAnotadosCom(Ignore.class);

		assertEquals(1, filtrador.obterMetodos().size());
		assertEquals("metodoAnotadoComTest", filtrador.obterMetodos().get(0).getName());
		assertEquals(3, filtradorClone.obterMetodos().size());
		assertEquals("metodoAnotadoComIgnoreTest", filtradorClone.obterMetodos().get(0).getName());
		assertEquals("metodoAnotadoComTestIgnore", filtradorClone.obterMetodos().get(1).getName());
		assertEquals("metodoAnotadoEmTudo", filtradorClone.obterMetodos().get(2).getName());
	}

	@Test
	public void filtrarMetodosAnotadosComIgnore() throws Exception {
		filtrador.removerMetodosAnotadosCom(Ignore.class);
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(16, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
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
	public void filtrarMetodosComRetorno() throws Exception {
		filtrador.removerMetodosComRetorno();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(16, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoComExcecao", iterador.next().getName());
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
	public void filtrarMetodosDefault() throws Exception {
		filtrador.removerMetodosDefault();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(19, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
		assertEquals("metodoComExcecao", iterador.next().getName());
		assertEquals("metodoComRetorno", iterador.next().getName());
		assertEquals("metodoComRetornoArrayAntes", iterador.next().getName());
		assertEquals("metodoComRetornoArrayDepois", iterador.next().getName());
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
	public void filtrarMetodosEstaticos() throws Exception {
		filtrador.removerMetodosEstaticos();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(19, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
		assertEquals("metodoComExcecao", iterador.next().getName());
		assertEquals("metodoComRetorno", iterador.next().getName());
		assertEquals("metodoComRetornoArrayAntes", iterador.next().getName());
		assertEquals("metodoComRetornoArrayDepois", iterador.next().getName());
		assertEquals("metodoDefault", iterador.next().getName());
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
	public <T> void filtrarMetodosGenericos() throws Exception {
		filtrador.removerMetodosGenericos();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(18, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoComExcecao", iterador.next().getName());
		assertEquals("metodoComRetorno", iterador.next().getName());
		assertEquals("metodoComRetornoArrayAntes", iterador.next().getName());
		assertEquals("metodoComRetornoArrayDepois", iterador.next().getName());
		assertEquals("metodoDefault", iterador.next().getName());
		assertEquals("metodoEstatico", iterador.next().getName());
		assertEquals("metodoEstritoDePontoFlutuante", iterador.next().getName());
		assertEquals("metodoFinal", iterador.next().getName());
		assertEquals("metodoNativo", iterador.next().getName());
		assertEquals("metodoParametrizado", iterador.next().getName());
		assertEquals("metodoPrivado", iterador.next().getName());
		assertEquals("metodoProtegido", iterador.next().getName());
		assertEquals("metodoSincronizado", iterador.next().getName());
	}

	@Test
	public void filtrarMetodosNativos() throws Exception {
		filtrador.removerMetodosNativos();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(19, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
		assertEquals("metodoComExcecao", iterador.next().getName());
		assertEquals("metodoComRetorno", iterador.next().getName());
		assertEquals("metodoComRetornoArrayAntes", iterador.next().getName());
		assertEquals("metodoComRetornoArrayDepois", iterador.next().getName());
		assertEquals("metodoDefault", iterador.next().getName());
		assertEquals("metodoEstatico", iterador.next().getName());
		assertEquals("metodoEstritoDePontoFlutuante", iterador.next().getName());
		assertEquals("metodoFinal", iterador.next().getName());
		assertEquals("metodoGenerico", iterador.next().getName());
		assertEquals("metodoParametrizado", iterador.next().getName());
		assertEquals("metodoPrivado", iterador.next().getName());
		assertEquals("metodoProtegido", iterador.next().getName());
		assertEquals("metodoSincronizado", iterador.next().getName());
	}

	@Test
	public void filtrarMetodosParametrizados() throws Exception {
		filtrador.removerMetodosParametrizados();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(18, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
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
		assertEquals("metodoPrivado", iterador.next().getName());
		assertEquals("metodoProtegido", iterador.next().getName());
		assertEquals("metodoSincronizado", iterador.next().getName());
	}

	@Test
	public void filtrarMetodosPrivados() throws Exception {
		filtrador.removerMetodosPrivados();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(19, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
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
		assertEquals("metodoProtegido", iterador.next().getName());
		assertEquals("metodoSincronizado", iterador.next().getName());
	}

	@Test
	public void filtrarMetodosProtegidos() throws Exception {
		filtrador.removerMetodosProtegidos();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(19, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
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
		assertEquals("metodoSincronizado", iterador.next().getName());
	}

	@Test
	public void filtrarMetodosSincronizados() throws Exception {
		filtrador.removerMetodosSincronizados();
		List<Method> metodos = filtrador.obterMetodos();
		Iterator<Method> iterador = metodos.iterator();
		assertEquals(19, metodos.size());
		assertEquals("metodoAbstrato", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoComIgnoreTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTest", iterador.next().getName());
		assertEquals("metodoAnotadoComTestIgnore", iterador.next().getName());
		assertEquals("metodoAnotadoEmTudo", iterador.next().getName());
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
	}

	@Test
	public void reduzir() throws Exception {
		String reduzido = filtrador.reduzir(metodo -> metodo.getName());
		List<Method> metodos = filtrador.obterMetodos();
		assertFalse(filtrador.vazio());
		assertEquals(1, metodos.size());
		assertEquals("metodoAbstrato", metodos.get(0).getName());
		assertEquals("metodoAbstrato", reduzido);
	}

}
