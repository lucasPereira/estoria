package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Acessorio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoUmTestePassando;

public final class TesteAnotacaoAcessorio {

	private Acessorio anotacao;
	private Acessorio[] anotacoes;

	@Before
	public void prepararCenario() {
		Class<?> classe = UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class;
		anotacao = classe.getDeclaredAnnotation(Acessorio.class);
		anotacoes = classe.getDeclaredAnnotationsByType(Acessorio.class);
	}

	@Test
	public void testar() throws Exception {
		assertEquals(1, anotacoes.length);
		assertEquals(Acessorio.class, anotacoes[0].annotationType());
		assertEquals(Acessorio.class, anotacao.annotationType());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, anotacoes[0].classe());
		assertEquals(UmaConfiguracaoPassandoUmTestePassando.class, anotacao.classe());
	}

}
