package br.ufsc.ine.leb.projetos.estoria;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public final class CombinadorDeNotificacao extends BaseMatcher<Notificacao> {

	private TipoDeNotificacao tipoEsperado;
	private Integer executadosEsperados;
	private Integer falhasEsperadas;
	private Integer ignoradosEsperados;
	private Boolean sucessoEsperado;
	private String metodoEsperado;
	private Class<?> classeEsperada;
	private Class<? extends Throwable> excecaoEsperada;
	private String mensagemDaExcecaoEsperada;

	private TipoDeNotificacao tipoRecebido;
	private Integer executadosRecebidos;
	private Integer falhasRecebidas;
	private Integer ignoradosRecebidos;
	private Boolean sucessoRecebido;
	private String metodoRecebido;
	private Class<?> classeRecebida;
	private Class<? extends Throwable> excecaoRecebida;
	private String mensagemDaExcecaoRecebida;

	private CombinadorDeNotificacao(TipoDeNotificacao tipoEsperado, Class<?> classeEsperada, String metodoEsperado, Class<? extends Throwable> excecaoEsperada, String mensagemDaExcecaoEsperada, Integer executadosEsperados, Integer falhasEsperadas, Integer ignoradosEsperados, Boolean sucessoEsperado) {
		this.tipoEsperado = tipoEsperado;
		this.metodoEsperado = metodoEsperado;
		this.classeEsperada = classeEsperada;
		this.excecaoEsperada = excecaoEsperada;
		this.mensagemDaExcecaoEsperada = mensagemDaExcecaoEsperada;
		this.executadosEsperados = executadosEsperados;
		this.falhasEsperadas = falhasEsperadas;
		this.ignoradosEsperados = ignoradosEsperados;
		this.sucessoEsperado = sucessoEsperado;
	}

	public static Matcher<Notificacao> combinaComTestesIniciados(Class<?> classeEsperada) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTES_INICIADOS, classeEsperada, null, null, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteIniciado(Class<?> classeEsperada, String metodoEsperado) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_INICIADO, classeEsperada, metodoEsperado, null, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteFinalizado(Class<?> classeEsperada, String metodoEsperado) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_FINALIZADO, classeEsperada, metodoEsperado, null, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteIgnorado(Class<?> classeEsperada, String metodoEsperado) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_IGNORADO, classeEsperada, metodoEsperado, null, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteFalha(Class<?> classeEsperada, String metodoEsperado, Class<? extends Throwable> excecaoEsperada) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_FALHA, classeEsperada, metodoEsperado, excecaoEsperada, null, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTesteFalha(Class<?> classeEsperada, String metodoEsperado, Class<? extends Throwable> excecaoEsperada, String mensagemDaExcecaoEsperada) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTE_FALHA, classeEsperada, metodoEsperado, excecaoEsperada, mensagemDaExcecaoEsperada, null, null, null, null);
	}

	public static Matcher<Notificacao> combinaComTestesFinalizados(Integer executadosEsperados, Integer falhasEsperadas, Integer ignoradosEsperados) {
		return new CombinadorDeNotificacao(TipoDeNotificacao.TESTES_FINALIZADOS, null, null, null, null, executadosEsperados, falhasEsperadas, ignoradosEsperados, falhasEsperadas == 0);
	}

	@Override
	public void describeTo(Description casamento) {
		casamento.appendValue(tipoEsperado);
		adicionarRepresentacaoTextualDeDescricao(casamento, classeEsperada, metodoEsperado);
		adicionarRepresentacaoTextualDeFalha(casamento, excecaoEsperada, mensagemDaExcecaoEsperada);
		adicionarRepresentacaoTextualDeResultado(casamento, executadosEsperados, falhasEsperadas, ignoradosEsperados);
	}

	@Override
	public void describeMismatch(Object objeto, Description casamento) {
		casamento.appendValue(tipoRecebido);
		adicionarRepresentacaoTextualDeDescricao(casamento, classeRecebida, metodoRecebido);
		adicionarRepresentacaoTextualDeFalha(casamento, excecaoRecebida, mensagemDaExcecaoRecebida);
		adicionarRepresentacaoTextualDeResultado(casamento, executadosRecebidos, falhasRecebidas, ignoradosRecebidos);
	}

	@Override
	public boolean matches(Object objeto) {
		return extrairAtributos(objeto) && casarTipo() && casarDescricao() && casarFalha() && casarResultado();
	}

	private Boolean casarTipo() {
		return tipoEsperado.equals(tipoRecebido);
	}

	private Boolean casarDescricao() {
		return !tipoEsperado.possuiDescricao() || (casarClasse() && casarMetodo());
	}

	private Boolean casarFalha() {
		return !tipoEsperado.possuiFalha() || (casarExcecao() && casarMensagemDaExcecao());
	}

	private Boolean casarResultado() {
		return !tipoEsperado.possuiResultado() || (casarExecutados() && casarFalhas() && casarIgnorados() && casarSucesso());
	}

	private Boolean casarClasse() {
		return classeEsperada.equals(classeRecebida);
	}

	private Boolean casarMetodo() {
		return (metodoEsperado == null && metodoRecebido == null) || metodoEsperado.equals(metodoRecebido);
	}

	private Boolean casarExcecao() {
		return excecaoEsperada.equals(excecaoRecebida);
	}

	private Boolean casarMensagemDaExcecao() {
		return (mensagemDaExcecaoEsperada == null) || mensagemDaExcecaoEsperada.equals(mensagemDaExcecaoRecebida);
	}

	private Boolean casarExecutados() {
		return executadosEsperados.equals(executadosRecebidos);
	}

	private Boolean casarFalhas() {
		return falhasEsperadas.equals(falhasRecebidas);
	}

	private Boolean casarIgnorados() {
		return ignoradosEsperados.equals(ignoradosRecebidos);
	}

	private Boolean casarSucesso() {
		return sucessoEsperado.equals(sucessoRecebido);
	}

	private Boolean extrairAtributos(Object objeto) {
		if (objeto != null && objeto instanceof Notificacao) {
			Notificacao notificacao = (Notificacao) objeto;
			tipoRecebido = notificacao.obterTipo();
			classeRecebida = (notificacao.obterDescricao() == null) ? null : notificacao.obterDescricao().getTestClass();
			metodoRecebido = (notificacao.obterDescricao() == null) ? null : notificacao.obterDescricao().getMethodName();
			excecaoRecebida = (notificacao.obterFalha() == null) ? null : notificacao.obterFalha().getException().getClass();
			mensagemDaExcecaoRecebida = (notificacao.obterFalha() == null) ? null : notificacao.obterFalha().getException().getMessage();
			executadosRecebidos = (notificacao.obterResultado() == null) ? null : notificacao.obterResultado().getRunCount();
			falhasRecebidas = (notificacao.obterResultado() == null) ? null : notificacao.obterResultado().getFailureCount();
			ignoradosRecebidos = (notificacao.obterResultado() == null) ? null : notificacao.obterResultado().getIgnoreCount();
			sucessoRecebido = (notificacao.obterResultado() == null) ? null : notificacao.obterResultado().wasSuccessful();
			return true;
		}
		return false;
	}

	private static void adicionarRepresentacaoTextualDeDescricao(Description casamento, Class<?> classe, String metodo) {
		if (classe != null) {
			String representacaoDaClasse = classe.getSimpleName();
			String representacaoDoMetodo = (metodo == null) ? "class" : metodo;
			String representacao = String.format(" %s.%s", representacaoDaClasse, representacaoDoMetodo);
			casamento.appendText(representacao);
		}
	}

	private static void adicionarRepresentacaoTextualDeFalha(Description casamento, Class<? extends Throwable> excecao, String mensagem) {
		if (excecao != null) {
			String representacaoDaExcecao = excecao.getSimpleName();
			String reoresentacaoDaMensagem = (mensagem == null) ? "*" : mensagem;
			String representacao = String.format(" lança %s.class [%s]", representacaoDaExcecao, reoresentacaoDaMensagem);
			casamento.appendText(representacao);
		}
	}

	private static void adicionarRepresentacaoTextualDeResultado(Description casamento, Integer executados, Integer falhas, Integer ignorados) {
		if (executados != null && falhas != null && ignorados != null) {
			String representacao = String.format(" %d executados, %d falhas, %d ignorados", executados, falhas, ignorados);
			casamento.appendText(representacao);
		}
	}

}
