package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.EnxertorDeAtributo;
import br.ufsc.ine.leb.projetos.estoria.ExcecaoChecadaQueNaoDeveriaSerLancada;
import br.ufsc.ine.leb.projetos.estoria.FiltradorDeAtributos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberLong;

public final class TesteEnxertorDeAtributoClassesDiferentes {

	private ClasseComUmAtributoInteger comInteiro100;
	private ClasseComUmAtributoInteger comInteiro50;
	private ClasseComUmAtributoNumberLong comNumeroLongo200;
	private ClasseComUmAtributoNumberInteger comNumeroInteiro200;
	private Field atributoDeInteiro;
	private Field atributoDeNumeroLongo;
	private Field atributoDeNumeroInteiro;
	private Integer inteiro50;
	private Number numeroInteiro200;

	@Before
	public void prepararCenario() {
		comInteiro100 = new ClasseComUmAtributoInteger();
		comInteiro50 = new ClasseComUmAtributoInteger();
		comInteiro50.mudarPara50();

		comNumeroLongo200 = new ClasseComUmAtributoNumberLong();
		comNumeroInteiro200 = new ClasseComUmAtributoNumberInteger();

		atributoDeInteiro = new FiltradorDeAtributos(ClasseComUmAtributoInteger.class).obterAtributos().get(0);
		atributoDeNumeroLongo = new FiltradorDeAtributos(ClasseComUmAtributoNumberLong.class).obterAtributos().get(0);
		atributoDeNumeroInteiro = new FiltradorDeAtributos(ClasseComUmAtributoNumberInteger.class).obterAtributos().get(0);

		inteiro50 = 50;
		numeroInteiro200 = 200;
	}

	@Test
	public void enxertarInteiroEmInteiro() throws Exception {
		new EnxertorDeAtributo(comInteiro50, comInteiro100).enxertar(atributoDeInteiro, atributoDeInteiro);
		assertEquals(inteiro50, comInteiro50.obterAtributo());
		assertEquals(inteiro50, comInteiro100.obterAtributo());
	}

	@Test
	public void enxertarInteiroEmNumeroInteiro() throws Exception {
		new EnxertorDeAtributo(comInteiro50, comNumeroInteiro200).enxertar(atributoDeInteiro, atributoDeNumeroInteiro);
		assertEquals(inteiro50, comInteiro50.obterAtributo());
		assertEquals(inteiro50, comNumeroInteiro200.obterAtributo());
	}

	@Test
	public void enxertarInteiroEmNumeroLongo() throws Exception {
		new EnxertorDeAtributo(comInteiro50, comNumeroLongo200).enxertar(atributoDeInteiro, atributoDeNumeroLongo);
		assertEquals(inteiro50, comInteiro50.obterAtributo());
		assertEquals(inteiro50, comNumeroLongo200.obterAtributo());
	}

	@Test
	public void enxertarNumeroInteiroEmInteiro() throws Exception {
		new EnxertorDeAtributo(comNumeroInteiro200, comInteiro100).enxertar(atributoDeNumeroInteiro, atributoDeInteiro);
		assertEquals(numeroInteiro200, comNumeroInteiro200.obterAtributo());
		assertEquals(numeroInteiro200, comInteiro100.obterAtributo());
	}

	@Test(expected = ExcecaoChecadaQueNaoDeveriaSerLancada.class)
	public void incompativelEnxertarNumeroLongoEmInteiro() throws Exception {
		new EnxertorDeAtributo(comNumeroLongo200, comInteiro100).enxertar(atributoDeNumeroLongo, atributoDeInteiro);
	}

	@Test(expected = ExcecaoChecadaQueNaoDeveriaSerLancada.class)
	public void enxertarInteiroEmInteiroComCampoNaoExistenteNaOrigem() throws Exception {
		new EnxertorDeAtributo(comInteiro50, comInteiro100).enxertar(atributoDeNumeroLongo, atributoDeInteiro);
	}

	@Test(expected = ExcecaoChecadaQueNaoDeveriaSerLancada.class)
	public void enxertarInteiroEmInteiroComCampoNaoExistenteNoDestino() throws Exception {
		new EnxertorDeAtributo(comInteiro50, comInteiro100).enxertar(atributoDeInteiro, atributoDeNumeroInteiro);
	}

	@Test(expected = ExcecaoChecadaQueNaoDeveriaSerLancada.class)
	public void enxertarInteiroEmInteiroComCampoNaoExistenteNaOrigemNoDestino() throws Exception {
		new EnxertorDeAtributo(comInteiro50, comInteiro100).enxertar(atributoDeNumeroInteiro, atributoDeNumeroLongo);
	}

}
