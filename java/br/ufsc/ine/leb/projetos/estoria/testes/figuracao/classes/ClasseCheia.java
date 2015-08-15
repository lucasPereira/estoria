package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import org.junit.Ignore;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.anotacoes.Anotacao;

public abstract class ClasseCheia {

	public abstract void metodoAbstrato();

	public native void metodoNativo();

	public final void metodoFinal() {}

	public synchronized void metodoSincronizado() {}

	public strictfp void metodoEstritoDePontoFlutuante() {}

	public static void metodoEstatico() {}

	public void metodoParametrizado(Object parametro) {}

	public <T> void metodoGenerico() {}

	public void metodoComExcecao() throws Exception {}

	public Object metodoComRetorno() {
		return null;
	}

	public Object[][] metodoComRetornoArrayAntes() {
		return null;
	}

	public Object metodoComRetornoArrayDepois()[][] {
		return null;
	}

	void metodoDefault() {}

	protected void metodoProtegido() {}

	private void metodoPrivado() {}

	@Ignore
	public void metodoAnotadoComIgnore() {}

	@Ignore
	@Test
	public void metodoAnotadoComIgnoreTeste() {}

	@Test
	@Ignore
	public void metodoAnotadoComTesteIgnore() {}

	public @Test void metodoAnotadoComTest() {}

	@Anotacao(valor = "methodBeforeAccessModifier")
	public @Anotacao(valor = "methodAfterAccessModifier") <@Anotacao(valor = "identifierOfTypeParameterOfMethod") T> @Anotacao(valor = "typeParameter") Object metodoAnotadoEmTudo(@Anotacao(valor = "parameter") Class<@Anotacao(valor = "identifierOfTypeParameterOfParameterType") T> parametro) throws @Anotacao(valor = "exception") Exception {
		@Anotacao(valor = "variable") Object variavel = null;
		return variavel;
	}

}
