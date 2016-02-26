package br.ufsc.ine.leb.projetos.estoria;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;

public class EscoltadorDeTestesReaproveitador extends Runner implements Filterable {

	private Result resultado;
	private SuiteDeTeste suiteDeTeste;
	private Description descricaoDaSuite;
	private RunNotifier mensageiroDeEscolta;
	private List<Filter> filtros;

	public EscoltadorDeTestesReaproveitador(SuiteDeTeste suiteDeTeste) {
		this(suiteDeTeste, new Ata());
	}

	public EscoltadorDeTestesReaproveitador(SuiteDeTeste suiteDeTeste, Ata ata) {
		this.suiteDeTeste = suiteDeTeste;
		descricaoDaSuite = suiteDeTeste.obterDescricao(new FiltroInutil());
		filtros = new LinkedList<>();
	}

	@Override
	public final Description getDescription() {
		return descricaoDaSuite;
	}

	@Override
	public final void run(RunNotifier mensageiroDeEscolta) {
		this.mensageiroDeEscolta = mensageiroDeEscolta;
		resultado = new Result();
		mensageiroDeEscolta.addListener(resultado.createListener());
		executarSuite(suiteDeTeste);
	}

	@Override
	public void filter(Filter filtro) throws NoTestsRemainException {
		filtros.add(filtro);
		descricaoDaSuite = suiteDeTeste.obterDescricao(filtro);
	}

	private void executarSuite(SuiteDeTeste suiteDeTeste) {
		mensageiroDeEscolta.fireTestRunStarted(descricaoDaSuite);
		executarTestes(suiteDeTeste);
		mensageiroDeEscolta.fireTestRunFinished(resultado);
	}

	private void executarTestes(SuiteDeTeste suiteDeTeste) {
		List<ClasseDeTeste> classesDeTeste = suiteDeTeste.obterClassesDeTeste();
		Collections.sort(classesDeTeste, new Comparator<ClasseDeTeste>() {

			@Override
			public int compare(ClasseDeTeste elemento1, ClasseDeTeste elemento2) {
				Boolean dependente = elemento1.obterAcessorios().contains(elemento2);
				Boolean dependencia = elemento2.obterAcessorios().contains(elemento1);
				return dependente ? 1 : dependencia ? -1 : 0;
			}

		});
		List<MetodoDeTeste> metodosDeTeste = new LinkedList<>();
		classesDeTeste.forEach(classeDeTeste -> classeDeTeste.obterMetodosDeTeste().forEach(metodoDeTeste -> metodosDeTeste.add(metodoDeTeste)));
		Map<ClasseDeTeste, InvocadorDeMetodo<?>> invocadores = new HashMap<>();
		for (MetodoDeTeste metodoDeTeste : metodosDeTeste) {
			if (!filtrarExecucao(metodoDeTeste)) {
				mensageiroDeEscolta.fireTestStarted(metodoDeTeste.obterDescricao());
				Map<AtributoAcessorio, Boolean> atributosEnxertados = new HashMap<>();
				ClasseDeTeste classeDeTeste = metodoDeTeste.obterClasseDeTeste();
				TratadorDeInvocacao tratadorDeTeste = new TratadorDeInvocacaoDeTeste(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
				TratadorDeInvocacao tratadorDeConfiguracao = new TratadorDeInvocacaoDeConfiguracao(metodoDeTeste.obterDescricao(), mensageiroDeEscolta);
				invocadores.put(classeDeTeste, new InvocadorDeMetodo<>(classeDeTeste.obterClasse()));
				for (ClasseDeTeste classeAcessorio : classeDeTeste.obterAcessorios()) {
					Object instanciaClasseAcessorio = invocadores.get(classeAcessorio).obterInstancia();
					Object instanciaClasseDeTeste = invocadores.get(classeDeTeste).obterInstancia();
					EnxertorDeAtributo enxertador = new EnxertorDeAtributo(instanciaClasseAcessorio, instanciaClasseDeTeste);
					for (AtributoProprio atributoProprio : classeAcessorio.obterAtributosProprios()) {
						enxertarAcessorio(classeDeTeste, classeAcessorio, enxertador, atributoProprio, atributosEnxertados);
					}
					for (AtributoAcessorio atributoAcessorio : classeAcessorio.obterAtributosAcessorios()) {
						enxertarAcessorio(classeDeTeste, classeAcessorio, enxertador, atributoAcessorio, atributosEnxertados);
					}
				}
				for (MetodoDeConfiguracao metodoDeConfiguracao : classeDeTeste.obterMetodosDeConfiguracao()) {
					invocadores.get(classeDeTeste).executar(metodoDeConfiguracao.obterMetodo(), tratadorDeConfiguracao);
				}
				invocadores.get(classeDeTeste).executar(metodoDeTeste.obterMetodo(), tratadorDeTeste);
				mensageiroDeEscolta.fireTestFinished(metodoDeTeste.obterDescricao());
			}
		}
	}

	private void enxertarAcessorio(ClasseDeTeste classeDeTeste, ClasseDeTeste classeAcessorio, EnxertorDeAtributo enxertador, Atributo atributoProprio, Map<AtributoAcessorio, Boolean> atributosEnxertados) {
		for (AtributoAcessorio atributoAcessorio : classeDeTeste.obterAtributosAcessorios()) {
			if (atributoAcessorio.compativelCom(atributoProprio) && !atributosEnxertados.containsKey(atributoAcessorio)) {
				atributosEnxertados.put(atributoAcessorio, true);
				enxertador.enxertar(atributoProprio.obterAtributo(), atributoAcessorio.obterAtributo());
			}
		}
	}

	private Boolean filtrarExecucao(MetodoDeTeste metodoDeTeste) {
		for (Filter filtro : filtros) {
			if (!filtro.shouldRun(metodoDeTeste.obterDescricao())) {
				return true;
			}
		}
		return false;
	}

}
