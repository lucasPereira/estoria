package br.ufsc.ine.leb.projetos.estoria;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CombinadorDeNotificacao extends TypeSafeMatcher<Notificacao> {

	private TipoDeNotificacao tipoEsperado;
	private Integer executadosEsperados;
	private Integer falhasEsperadas;
	private Integer ignoradosEsperados;
	private Boolean sucessoEsperado;
	private String metodoEsperado;
	private Class<?> classeEsperada;
	private Class<? extends Throwable> excecaoEsperada;

	public static Matcher<Notificacao> combinaComTestesIniciados(Class<?> classeEsperada) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTES_INICIADOS, classeEsperada, null, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteIniciado(Class<?> classeEsperada, String metodoEsperado) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_INICIADO, classeEsperada, metodoEsperado, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteFinalizado(Class<?> classeEsperada, String metodoEsperado) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_FINALIZADO, classeEsperada, metodoEsperado, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteIgnorado(Class<?> classeEsperada, String metodoEsperado) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_IGNORADO, classeEsperada, metodoEsperado, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteFalha(Class<?> classeEsperada, String metodoEsperado, Class<? extends Throwable> excecaoEsperada) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_FALHA, classeEsperada, metodoEsperado, excecaoEsperada, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTestesFinalizados(Integer executadosEsperados, Integer falhasEsperadas, Integer ignoradosEsperados) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTES_FINALIZADOS, null, null, null, executadosEsperados, falhasEsperadas, ignoradosEsperados, falhasEsperadas == 0);
	}

	private CombinadorDeNotificacao(TipoDeNotificacao tipoEsperado, Class<?> classeEsperada, String metodoEsperado, Class<? extends Throwable> excecaoEsperada, Integer executadosEsperados, Integer falhasEsperadas, Integer ignoradosEsperados, Boolean sucessoEsperado) {
		this.tipoEsperado = tipoEsperado;
		this.metodoEsperado = metodoEsperado;
		this.classeEsperada = classeEsperada;
		this.excecaoEsperada = excecaoEsperada;
		this.executadosEsperados = executadosEsperados;
		this.falhasEsperadas = falhasEsperadas;
		this.ignoradosEsperados = ignoradosEsperados;
		this.sucessoEsperado = sucessoEsperado;
	}

	@Override
	public void describeTo(Description casamento) {
		casamento.appendValue(tipoEsperado);
		if (tipoEsperado.possuiDescricao()) {
			adicionarRepresentacaoTextualDeDescricao(casamento, classeEsperada, metodoEsperado);
		}
		if (tipoEsperado.possuiFalha()) {
			adicionarRepresentacaoTextualDeFalha(casamento, excecaoEsperada);
		}
		if (tipoEsperado.possuiResultado()) {
			adicionarRepresentacaoTextualDeResultado(casamento, executadosEsperados, falhasEsperadas, ignoradosEsperados);
		}
	}

	@Override
	protected void describeMismatchSafely(Notificacao notificacao, Description casamento) {
		casamento.appendValue(notificacao.obterTipo());
		if (notificacao.obterTipo().possuiDescricao()) {
			adicionarRepresentacaoTextualDeDescricao(casamento, notificacao.obterDescricao().getTestClass(), notificacao.obterDescricao().getMethodName());
		}
		if (notificacao.obterTipo().possuiFalha()) {
			adicionarRepresentacaoTextualDeFalha(casamento, notificacao.obterFalha().getException().getClass());
		}
		if (notificacao.obterTipo().possuiResultado()) {
			adicionarRepresentacaoTextualDeResultado(casamento, notificacao.obterResultado().getRunCount(), notificacao.obterResultado().getFailureCount(), notificacao.obterResultado().getIgnoreCount());
		}
	}

	@Override
	protected boolean matchesSafely(Notificacao notificacao) {
		return casarTipo(notificacao) && casarDescricao(notificacao) && casarFalha(notificacao) && casarResultado(notificacao);
	}

	private Boolean casarTipo(Notificacao notificacao) {
		return notificacao.obterTipo().equals(tipoEsperado);
	}

	private Boolean casarDescricao(Notificacao notificacaoRecebida) {
		return !tipoEsperado.possuiDescricao() || (casarClasse(notificacaoRecebida) && casarMetodo(notificacaoRecebida));
	}

	private Boolean casarResultado(Notificacao notificacaoRecebida) {
		return !tipoEsperado.possuiResultado() || (casarExecutados(notificacaoRecebida) && casarFalhas(notificacaoRecebida) && casarIgnorados(notificacaoRecebida) && casarSucesso(notificacaoRecebida));
	}

	private Boolean casarFalha(Notificacao notificacaoRecebida) {
		return !tipoEsperado.possuiFalha() || casarExcecao(notificacaoRecebida);
	}

	private Boolean casarSucesso(Notificacao notificacaoRecebida) {
		return notificacaoRecebida.obterResultado().wasSuccessful() == sucessoEsperado;
	}

	private Boolean casarExecutados(Notificacao notificacaoRecebida) {
		return notificacaoRecebida.obterResultado().getRunCount() == executadosEsperados;
	}

	private Boolean casarFalhas(Notificacao notificacaoRecebida) {
		return notificacaoRecebida.obterResultado().getFailureCount() == falhasEsperadas;
	}

	private Boolean casarIgnorados(Notificacao notificacaoRecebida) {
		return notificacaoRecebida.obterResultado().getIgnoreCount() == ignoradosEsperados;
	}

	private Boolean casarExcecao(Notificacao notificacaoRecebida) {
		return notificacaoRecebida.obterFalha().getException().getClass().equals(excecaoEsperada);
	}

	private Boolean casarClasse(Notificacao notificacaoRecebida) {
		return notificacaoRecebida.obterDescricao().getTestClass().equals(classeEsperada);
	}

	private Boolean casarMetodo(Notificacao notificacaoRecebida) {
		return (notificacaoRecebida.obterDescricao().getMethodName() == null && metodoEsperado == null) || notificacaoRecebida.obterDescricao().getMethodName().equals(metodoEsperado);
	}

	private void adicionarRepresentacaoTextualDeDescricao(Description casamento, Class<?> classe, String metodo) {
		String representacaoDaClasse = classe.getSimpleName();
		String representacaoDoMetodo = metodo == null ? "class" : metodo;
		String representacao = String.format(" %s.%s", representacaoDaClasse, representacaoDoMetodo);
		casamento.appendText(representacao);
	}

	private void adicionarRepresentacaoTextualDeFalha(Description casamento, Class<? extends Throwable> excecao) {
		String representacaoDaExcecao = excecao.getSimpleName();
		String representacao = String.format(" lança %s.class", representacaoDaExcecao);
		casamento.appendText(representacao);
	}

	private void adicionarRepresentacaoTextualDeResultado(Description casamento, Integer executados, Integer falhas, Integer ignorados) {
		String representacao = String.format(" %d executados, %d falhas, %d ignorados", executados, falhas, ignorados);
		casamento.appendText(representacao);
	}

}
