package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import org.junit.Ignore;
import org.junit.Test;

public abstract class ClasseCheiaDeMetodosDeTeste {

	@Test
	public void metodoDeTeste() {}

	@Test
	public final void metodoDeTesteFinal() {}

	@Test
	public strictfp void metodoDeTesteEstritoDePontoFlutuante() {}

	@Test
	public void metodoDeTesteComExcecao() throws Exception {}

	@Test
	public abstract void metodoNaoTesteAbstrato();

	@Test
	public native void metodoNaoTesteNativo();

	@Test
	public synchronized void metodoNaoTesteSincronizado() {}

	@Test
	public static void metodoNaoTesteEstatico() {}

	@Test
	public void metodoNaoTesteParametrizado(Object parametro) {}

	@Test
	public <T> void metodoNaoTesteGenerico() {}

	@Test
	public Object metodoNaoTesteComRetorno() {
		return null;
	}

	@Test
	public Object[][] metodoNaoTesteComRetornoArrayAntes() {
		return null;
	}

	@Test
	public Object metodoNaoTesteComRetornoArrayDepois()[][] {
		return null;
	}

	@Test
	void metodoNaoTesteDefault() {}

	@Test
	protected void metodoNaoTesteProtegido() {}

	@Test
	private void metodoNaoTestePrivado() {}

	@Test
	@Ignore
	public void metodoNaoTesteAnotadoComTestIgnore() {}

	@Ignore
	@Test
	public void metodoNaoTesteAnotadoComIgnoreTest() {}

}
