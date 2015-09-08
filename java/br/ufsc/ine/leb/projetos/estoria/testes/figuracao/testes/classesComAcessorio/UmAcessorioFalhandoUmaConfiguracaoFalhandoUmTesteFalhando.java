package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio;

import static org.junit.Assert.fail;

import org.junit.*;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;

@Acessorio(UmaConfiguracaoFalhandoUmTesteFalhando.class)
public class UmAcessorioFalhandoUmaConfiguracaoFalhandoUmTesteFalhando {

	public static int numeroEstaticoBefore;
	public static int numeroEstaticoBeforeTest;
	public static int numeroEstaticoTest;

	@Before
	public void configurar() {
		fail("Falha no super before");
	}

	@Test
	public void testar() {
		fail("Falha no super test");
	}

}
