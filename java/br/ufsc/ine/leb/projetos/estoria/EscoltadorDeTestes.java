package br.ufsc.ine.leb.projetos.estoria;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestes extends Runner {

	private SuiteDeTeste suiteDeTeste;
	private Description descricaoDaSuite;

	public EscoltadorDeTestes(SuiteDeTeste suiteDeTeste) {
		this.suiteDeTeste = suiteDeTeste;
		this.descricaoDaSuite = Description.createSuiteDescription(suiteDeTeste.obterSuite().getName());
	}

	@Override
	public final Description getDescription() {
		return descricaoDaSuite;
	}

	@Override
	public final void run(RunNotifier mensageiroDeEscolta) {
		Result resultado = new Result();
		mensageiroDeEscolta.addListener(resultado.createListener());
		mensageiroDeEscolta.fireTestRunStarted(descricaoDaSuite);
		rodarTestesIgnorados(mensageiroDeEscolta);
		rodarTestes(mensageiroDeEscolta);
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

	private void rodarTestes(RunNotifier mensageiroDeEscolta) {
		for (ClasseDeTeste classeDeteste : suiteDeTeste.obterClassesDeTeste()) {
			for (MetodoDeTeste metodoDeTeste : classeDeteste.obterMetodosDeTeste()) {
				Description descricaoDoTeste = criarDescricao(classeDeteste, metodoDeTeste);
				TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(descricaoDoTeste, mensageiroDeEscolta);
				TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(descricaoDoTeste, mensageiroDeEscolta);
				InvocadorDeMetodo invocadorParaClasse = new InvocadorDeMetodo(classeDeteste.obterClasse());
				mensageiroDeEscolta.fireTestStarted(descricaoDoTeste);
				classeDeteste.obterMetodosDeConfiguracao().forEach(metodoDeConfiguracao -> invocadorParaClasse.executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao));
				invocadorParaClasse.executar(metodoDeTeste.obterMetodo(), tratadorDeTeste);
				mensageiroDeEscolta.fireTestFinished(descricaoDoTeste);
			}
		}
	}

	private void rodarTestesIgnorados(RunNotifier mensageiroDeEscolta) {
		for (ClasseDeTeste classeDeteste : suiteDeTeste.obterClassesDeTeste()) {
			for (MetodoDeTeste metodoDeTeste : classeDeteste.obterMetodosDeTesteIgnorados()) {
				Description descricaoDoTeste = criarDescricao(classeDeteste, metodoDeTeste);
				mensageiroDeEscolta.fireTestIgnored(descricaoDoTeste);
			}
		}
	}

	private Description criarDescricao(ClasseDeTeste classeDeTeste, MetodoDeTeste metodoDeTeste) {
		Description descricaoDoTeste = Description.createTestDescription(classeDeTeste.obterClasse(), metodoDeTeste.obterNome());
		descricaoDaSuite.addChild(descricaoDoTeste);
		return descricaoDoTeste;
	}

}
