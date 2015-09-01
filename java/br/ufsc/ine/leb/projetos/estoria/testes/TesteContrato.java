package br.ufsc.ine.leb.projetos.estoria.testes;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Contrato;
import br.ufsc.ine.leb.projetos.estoria.ExcecaoClausulaDeContratoViolada;

public class TesteContrato {

	private Contrato contrato;

	@Before
	public void prepararCenario() {
		contrato = new Contrato();
	}

	@Test
	public void naoViolar() throws Exception {
		contrato.assegureQue(true);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void violar() throws Exception {
		contrato.assegureQue(false).garantir();
	}

	@Test
	public void ouValidoValido() throws Exception {
		contrato.assegureQue(true).ou(true);
		contrato.garantir();
	}

	@Test
	public void ouValidoInvalido() throws Exception {
		contrato.assegureQue(true).ou(false);
		contrato.garantir();
	}

	@Test
	public void ouInvalidoValido() throws Exception {
		contrato.assegureQue(false).ou(true);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void ouInvalidoInvalido() throws Exception {
		contrato.assegureQue(false).ou(false);
		contrato.garantir();
	}

	@Test
	public void eValidoValido() throws Exception {
		contrato.assegureQue(true).e(true);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void eValidoInvalido() throws Exception {
		contrato.assegureQue(true).e(false);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void eInvalidoValido() throws Exception {
		contrato.assegureQue(false).e(true);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void eInvalidoInvalido() throws Exception {
		contrato.assegureQue(false).e(false);
		contrato.garantir();
	}

	@Test
	public void duasNaoViolar() {
		contrato.assegureQue(true);
		contrato.assegureQue(true);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void duasViolarUltima() throws Exception {
		contrato.assegureQue(true);
		contrato.assegureQue(false);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void duasViolarPrimeira() throws Exception {
		contrato.assegureQue(false);
		contrato.assegureQue(true);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void duasViolarPrimeiraTerminandoComOuValido() throws Exception {
		contrato.assegureQue(false);
		contrato.assegureQue(true).ou(true);
		contrato.garantir();
	}

	@Test
	public void assegureIguais() throws Exception {
		contrato.assegureIguais("1", "1");
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void assegureIguaisViolar() throws Exception {
		contrato.assegureIguais("1", "2");
		contrato.garantir();
	}

	@Test
	public void eIguais() {
		contrato.assegureQue(true).e("1", "1");
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void eIguaisViolarPrimeira() {
		contrato.assegureQue(false).e("1", "1");
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void eIguaisViolarUltima() {
		contrato.assegureQue(true).e("1", "2");
		contrato.garantir();
	}

	@Test
	public void ouIguaisPrimeiraCorreta() {
		contrato.assegureQue(true).ou("1", "2");
		contrato.garantir();
	}

	@Test
	public void ouIguaisSegundaCorreta() {
		contrato.assegureQue(false).ou("1", "1");
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void ouIguaisViolar() {
		contrato.assegureQue(false).ou("1", "2");
		contrato.garantir();
	}

	@Test
	public void ouUsarEscopo() throws Exception {
		contrato.assegureIguais("1", "2").ou("3").ou("1").ou("5");
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void ouUsarEscopoViolar() throws Exception {
		contrato.assegureIguais("1", "2").ou("3").ou("4");
		contrato.garantir();
	}

	@Test
	public void eUsarEscopo() throws Exception {
		contrato.assegureIguais("1", "1").e("1").e("1");
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void eUsarEscopoViolar() throws Exception {
		contrato.assegureIguais("1", "1").e("2").e("1");
		contrato.garantir();
	}

	@Test
	public void seEntaoTrueTrue() throws Exception {
		contrato.se(true).assegureQue(true);
		contrato.garantir();
	}

	@Test
	public void seEntaoFalseTrue() throws Exception {
		contrato.se(false).assegureQue(true);
		contrato.garantir();
	}

	@Test
	public void seEntaoFalseFalse() throws Exception {
		contrato.se(false).assegureQue(false);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void seEntaoTrueFalse() throws Exception {
		contrato.se(true).assegureQue(false);
		contrato.garantir();
	}

	@Test
	public void seEntaoNaoAfetaOProximoQue() throws Exception {
		contrato.se(false).assegureQue(false);
		contrato.assegureQue(true);
		contrato.garantir();
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void seEntaoNaoAfetaOProximoQueViola() throws Exception {
		contrato.se(false).assegureQue(false);
		contrato.assegureQue(false);
		contrato.garantir();
	}

}
