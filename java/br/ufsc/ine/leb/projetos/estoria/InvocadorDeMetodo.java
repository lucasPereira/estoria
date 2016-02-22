package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class InvocadorDeMetodo<T> {

	private Class<T> classe;
	private T instancia;

	public InvocadorDeMetodo(Class<T> classe) {
		this.classe = classe;
		criarInstancia();
	}

	public void executar(Method metodo, TratadorDeInvocacao tratador) {
		try {
			invocar(metodo, instancia, tratador);
		} catch (IllegalAccessException excecao) {
			new LancadorDeExcecao().lancar(excecao);
		}
	}

	private void invocar(Method metodo, T objeto, TratadorDeInvocacao tratador) throws IllegalAccessException {
		try {
			metodo.invoke(objeto);
			tratador.tratarInvocacaoSemExcecao(metodo);
		} catch (InvocationTargetException excecao) {
			Throwable causa = excecao.getTargetException();
			StackTraceElement[] pilhaExecucaoCausa = causa.getStackTrace();
			StackTraceElement[] pilhaExecucaoExcecao = excecao.getStackTrace();
			Integer tamanho = pilhaExecucaoCausa.length - pilhaExecucaoExcecao.length;
			StackTraceElement[] pilhaDeExecaoCausaSemEstoria = new StackTraceElement[tamanho];
			for (Integer contador = 0; contador < tamanho; contador++) {
				pilhaDeExecaoCausaSemEstoria[contador] = pilhaExecucaoCausa[contador];
			}
			causa.setStackTrace(pilhaDeExecaoCausaSemEstoria);
			tratador.tratarInvocacaoComExcecao(metodo, causa);
		}
	}

	private void criarInstancia() {
		try {
			instancia = (instancia == null) ? classe.newInstance() : instancia;
		} catch (InstantiationException | IllegalAccessException excecao) {
			new LancadorDeExcecao().lancar(excecao);
		}
	}

	public T obterInstancia() {
		return instancia;
	}

}
