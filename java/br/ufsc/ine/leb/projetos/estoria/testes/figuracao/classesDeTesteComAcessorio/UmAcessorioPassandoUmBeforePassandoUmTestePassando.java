package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTesteComAcessorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Acessorio;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTesteComBefore.UmBeforePassandoUmTestePassando;

@Acessorio(classe = UmBeforePassandoUmTestePassando.class)
public class UmAcessorioPassandoUmBeforePassandoUmTestePassando {

	private int numero = 0;
	public static int numeroEstatico;

	@Before
	public void configurar() {
		numero = 10;
		numeroEstatico = 20;
	}

	@Test
	public void testar() throws Exception {
		assertEquals(10, numero);
		assertEquals(20, numeroEstatico);
		assertEquals(30, UmBeforePassandoUmTestePassando.numeroEstatico);
	}

}
