package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine.leb.projetos.estoria.Ata;
import br.ufsc.ine.leb.projetos.estoria.EscrivaoMalandro;
import br.ufsc.ine.leb.projetos.estoria.ExcecaoRecuoDeAtaMaiorDoQuePermitido;

@RunWith(JUnit4.class)
public final class TesteAta {

	private Ata ata;

	@Before
	public void prepararCenario() {
		ata = new Ata(new EscrivaoMalandro(), "-");
	}

	@Test
	public void umaLinha() throws Exception {
		ata.registrar("Registro 1");

		assertEquals(1, ata.obterRegistros().size());
		assertEquals("Registro 1", ata.obterRegistros().get(0));
	}

	@Test
	public void comParametros() throws Exception {
		ata.registrar("%s: %d", "Contador", 10);

		assertEquals(1, ata.obterRegistros().size());
		assertEquals("Contador: 10", ata.obterRegistros().get(0));
	}

	@Test
	public void incrementarEspacamento() throws Exception {
		ata.registrar("Nível %d", 1);
		ata.avancarIndentacao();
		ata.registrar("Nível %d.%d", 1, 1);
		ata.registrar("Nível %d.%d", 1, 2);
		ata.avancarIndentacao();
		ata.registrar("Nível %d.%d.%d", 1, 2, 1);

		assertEquals(4, ata.obterRegistros().size());
		assertEquals("Nível 1", ata.obterRegistros().get(0));
		assertEquals("-Nível 1.1", ata.obterRegistros().get(1));
		assertEquals("-Nível 1.2", ata.obterRegistros().get(2));
		assertEquals("--Nível 1.2.1", ata.obterRegistros().get(3));
	}

	@Test
	public void decrementarEspacamento() throws Exception {
		ata.registrar("Nível %d", 1);
		ata.avancarIndentacao();
		ata.registrar("Nível %d.%d", 1, 1);
		ata.recuarIndentacao();
		ata.registrar("Nível %d", 2);
		ata.registrar("Nível %d", 3);

		assertEquals(4, ata.obterRegistros().size());
		assertEquals("Nível 1", ata.obterRegistros().get(0));
		assertEquals("-Nível 1.1", ata.obterRegistros().get(1));
		assertEquals("Nível 2", ata.obterRegistros().get(2));
		assertEquals("Nível 3", ata.obterRegistros().get(3));
	}

	@Test(expected = ExcecaoRecuoDeAtaMaiorDoQuePermitido.class)
	public void decrementarEspacamentoMaisDoQuePermitido() throws Exception {
		ata.avancarIndentacao();
		ata.recuarIndentacao();
		ata.recuarIndentacao();
	}

}
