package br.ufsc.ine.leb.projetos.estoria;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class NotificacaoTesteIniciado extends TypeSafeMatcher<Notificacao> {

	private Class<?> classeEsperada;
	private String metodoEsperado;

	public NotificacaoTesteIniciado(Class<?> classeEsperada, String metodoEsperado) {
		this.classeEsperada = classeEsperada;
		this.metodoEsperado = metodoEsperado;
	}

	@Override
	public void describeTo(Description descricao) {
		descricao.appendValue(TipoDeNotificacao.TESTE_INICIADO).appendText(" ");
		descricao.appendText(classeEsperada.getSimpleName()).appendText(".").appendText(metodoEsperado);
	}

	@Override
	protected void describeMismatchSafely(Notificacao notificacao, Description descricao) {
		descricao.appendValue(notificacao.obterTipo());
		if (notificacao.obterDescricao() != null) {
			descricao.appendText(" ").appendText(notificacao.obterDescricao().getTestClass().getSimpleName()).appendText(".").appendText(notificacao.obterDescricao().getMethodName());
		}
	}

	@Override
	protected boolean matchesSafely(Notificacao notificacao) {
		return combinarTipo(notificacao) && combinarDescricao(notificacao) && combinarFalha(notificacao) && combinarResultado(notificacao);
	}

	private Boolean combinarTipo(Notificacao notificacao) {
		return notificacao.obterTipo().equals(TipoDeNotificacao.TESTE_INICIADO);
	}

	private Boolean combinarDescricao(Notificacao notificacao) {
		Boolean combina = notificacao.obterDescricao() != null;
		return combina && combinarClasseDaDescricao(notificacao) && combinarMetodoDaDescricao(notificacao);
	}

	private Boolean combinarResultado(Notificacao notificacao) {
		return notificacao.obterResultado() == null;
	}

	private Boolean combinarFalha(Notificacao notificacao) {
		return notificacao.obterFalha() == null;
	}

	private Boolean combinarMetodoDaDescricao(Notificacao notificacao) {
		return notificacao.obterDescricao().getMethodName().equals(metodoEsperado);
	}

	private Boolean combinarClasseDaDescricao(Notificacao notificacao) {
		return notificacao.obterDescricao().getTestClass().equals(classeEsperada);
	}

}
