package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public final class EscoltadorDeTestes extends Runner {

	private Description descricao;

	public EscoltadorDeTestes(SeletorDeTestes seletor) {
		List<SelecaoDeTeste> selecoes = seletor.obterSelecoes();
		descricao = Description.createSuiteDescription(seletor.getClass().getName());
		for (SelecaoDeTeste selecao : selecoes) {
			Class<?> classeDoTeste = selecao.obterClasse();
			String metodoDeTeste = selecao.obterMetodoDeTeste();
			Description descricaoDoTeste = Description.createTestDescription(classeDoTeste, metodoDeTeste);
			descricao.addChild(descricaoDoTeste);
		}
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
		for (Description descricaoDoTeste : descricao.getChildren()) {
			try {
				Class<?> classeDoCasoDeTeste = descricaoDoTeste.getTestClass();
				String casoDeTeste = descricaoDoTeste.getMethodName();
				Method metodoDeTeste = classeDoCasoDeTeste.getMethod(casoDeTeste);
				Object objetoDoCasoDeTeste = classeDoCasoDeTeste.newInstance();
				try {
					mensageiroDeEscolta.fireTestStarted(descricaoDoTeste);
					metodoDeTeste.invoke(objetoDoCasoDeTeste);
					mensageiroDeEscolta.fireTestFinished(descricaoDoTeste);
				} catch (InvocationTargetException excecao) {
					Failure falha = new Failure(descricaoDoTeste, excecao);
					mensageiroDeEscolta.fireTestFailure(falha);
					mensageiroDeEscolta.fireTestFinished(descricaoDoTeste);
				}
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException excecao) {
				excecao.printStackTrace();
			}
		}
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

}
