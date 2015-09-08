package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Acessorio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoFalhandoUmTesteFalhando;

@Acessorio(UmaConfiguracaoFalhandoUmTesteFalhando.class)
public class UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTesteFalhando {

	public static int numeroEstaticoBefore;
	public static int numeroEstaticoBeforeTest;
	public static int numeroEstaticoTest;

	@Before
	public void configurar() {
		assertTrue(true);
		fail("Falha no super before");
		assertTrue(true);
	}

	@Test
	public void testar() {
		assertTrue(true);
		fail("Falha no super test");
		assertTrue(true);
	}

}
