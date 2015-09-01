package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public final class EscoltadorDeTestes extends Runner {

	private Description descricao;
	private List<Description> descricoesDosIgnorados;
	private List<Description> descricoesDosExecutados;

	public EscoltadorDeTestes(SeletorDeTestes seletor) {
		descricoesDosIgnorados = new LinkedList<>();
		descricoesDosExecutados = new LinkedList<>();
		descricao = Description.createSuiteDescription(seletor.getClass().getName());
		seletor.obterSelecoesIgnoradas().forEach(selecao -> criarDescricaoDeTeste(selecao, descricoesDosIgnorados));
		seletor.obterSelecoes().forEach(selecao -> criarDescricaoDeTeste(selecao, descricoesDosExecutados));
	}

	private void criarDescricaoDeTeste(SelecaoDeTeste selecao, List<Description> descricoes) {
		Class<?> classeDoTeste = selecao.obterClasse();
		String metodoDeTeste = selecao.obterMetodoDeTeste();
		Description descricaoDoTeste = Description.createTestDescription(classeDoTeste, metodoDeTeste);
		descricao.addChild(descricaoDoTeste);
		descricoes.add(descricaoDoTeste);
	}

	@Override
	public Description getDescription() {
		return descricao;
	}

	@Override
	public void run(RunNotifier mensageiroDeEscolta) {
		Result resultado = new Result();
		mensageiroDeEscolta.addListener(resultado.createListener());
		mensageiroDeEscolta.fireTestRunStarted(descricao);
		ExecutorDeTeste executor = new ExecutorDeTeste(mensageiroDeEscolta);
		descricoesDosIgnorados.forEach(descricaoDoTeste -> mensageiroDeEscolta.fireTestIgnored(descricaoDoTeste));
		descricoesDosExecutados.forEach(descricaoDoTeste -> executor.executar(descricaoDoTeste));
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

}
