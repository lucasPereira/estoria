package br.ufsc.ine.leb.projetos.estoria;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestes extends Runner {

	private Description descricao;
	private List<CasoDeTeste> casosDeTeste;
	private List<CasoDeTeste> casosDeTesteIgnorados;

	private static SeletorDeTestes construirSeletor(Class<?> classe) throws InstantiationException, IllegalAccessException {
		return SeletorDeTestes.class.isAssignableFrom(classe) ? (SeletorDeTestes) classe.newInstance() : new SeletorDeTestes(classe);
	}

	EscoltadorDeTestes(Class<?> classe) throws InstantiationException, IllegalAccessException {
		this(construirSeletor(classe));
	}

	public EscoltadorDeTestes(SeletorDeTestes seletor) {
		descricao = Description.createSuiteDescription(seletor.getClass().getName());
		casosDeTeste = seletor.obterCasosDeTeste();
		casosDeTesteIgnorados = seletor.obterCasosDeTesteIgnorados();
		casosDeTesteIgnorados.forEach(casoDeTeste -> descricao.addChild(casoDeTeste.obterDescricao()));
		casosDeTeste.forEach(casoDeTeste -> descricao.addChild(casoDeTeste.obterDescricao()));
	}

	@Override
	public final Description getDescription() {
		return descricao;
	}

	@Override
	public final void run(RunNotifier mensageiroDeEscolta) {
		Result resultado = new Result();
		mensageiroDeEscolta.addListener(resultado.createListener());
		mensageiroDeEscolta.fireTestRunStarted(descricao);
		ExecutorDeTeste executor = new ExecutorDeTeste(mensageiroDeEscolta);
		casosDeTesteIgnorados.forEach(casoDeTeste -> mensageiroDeEscolta.fireTestIgnored(casoDeTeste.obterDescricao()));
		casosDeTeste.forEach(casoDeTeste -> executor.executar(casoDeTeste));
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

}
