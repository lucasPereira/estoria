package br.ufsc.ine.leb.projetos.estoria.testes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;

import br.ufsc.ine.leb.projetos.estoria.ExcecaoClausulaDeContratoViolada;
import br.ufsc.ine.leb.projetos.estoria.Notificacao;
import br.ufsc.ine.leb.projetos.estoria.TipoDeNotificacao;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.SuiteDoJUnitDuasClassesDoisMetodosDeTeste;

public class TesteNotificacaoExcecoes {

	private Description descricaoDeTeste;
	private Description descricaoDeSuite;

	@Before
	public void prepararCenario() {
		descricaoDeTeste = Description.createTestDescription(UmTestePassando.class, "testar");
		descricaoDeSuite = Description.createSuiteDescription(SuiteDoJUnitDuasClassesDoisMetodosDeTeste.class);
		descricaoDeSuite.addChild(descricaoDeTeste);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoFalha() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_FALHA, descricaoDeTeste);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoFinalizados() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTES_FINALIZADOS, descricaoDeTeste);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoTestesIniciadosDeveSerDeSuite() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTES_INICIADOS, descricaoDeTeste);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoTesteIniciadoDeveSerDeTeste() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_INICIADO, descricaoDeSuite);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoTesteFinalizadoDeveSerDeTeste() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_FINALIZADO, descricaoDeSuite);
	}

	@Test(expected = ExcecaoClausulaDeContratoViolada.class)
	public void descricaoTesteIgnoradoDeveSerDeTeste() throws Exception {
		new Notificacao(TipoDeNotificacao.TESTE_IGNORADO, descricaoDeSuite);
	}

}
