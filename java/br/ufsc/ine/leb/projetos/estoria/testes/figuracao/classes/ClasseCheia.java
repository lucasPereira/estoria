package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("unused")
public class ClasseCheia {

	protected void metodoProtegido() {}

	void metodoDefault() {}

	private void metodoPrivado() {}

	public void metodoComParametro(Object parametro) {}

	public Object metodoComRetorno() {
		return null;
	}

	public <T> void metodoComGenerico() {}

	@Ignore
	public void metodoComAnotacaoIgnore() {}

	@Ignore
	@Test
	public void metodoComAnotacoesIgnoreTeste() {}

	@Test
	@Ignore
	public void metodoComAnotacoesTesteIgnore() {}

	@Test
	public void metodoComAnotacaoTeste() {}

}
