package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseDeTeste137 {

	private int classe137AcessorioBefore1Test1;
	private int classe137AcessorioBefore2Test3;
	private int classe137AcessorioBefore0Test4;

	@Before
	public void configurar() {
		classe137AcessorioBefore1Test1 = 1;
		classe137AcessorioBefore2Test3 = 2;
		assertEquals(1, classe137AcessorioBefore1Test1);
		assertEquals(2, classe137AcessorioBefore2Test3);
		assertEquals(0, classe137AcessorioBefore0Test4);
	}

	@Test
	public void testar() {
		classe137AcessorioBefore2Test3 = 3;
		classe137AcessorioBefore0Test4 = 4;
		assertEquals(1, classe137AcessorioBefore1Test1);
		assertEquals(3, classe137AcessorioBefore2Test3);
		assertEquals(4, classe137AcessorioBefore0Test4);
	}

}
