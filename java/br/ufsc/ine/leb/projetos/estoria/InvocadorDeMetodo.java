package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocadorDeMetodo {

	private Class<?> classe;
	private Object instancia;

	public InvocadorDeMetodo(Class<?> classe) {
		this.classe = classe;
		this.instancia = null;
	}

	public void executar(String nomeDoMetodo, TratadorDeInvocacao tratador) {
		try {
			Object objeto = obterInstancia();
			Method metodo = classe.getMethod(nomeDoMetodo);
			invocar(metodo, objeto, tratador);
		} catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InstantiationException excecao) {
			excecao.printStackTrace();
		}
	}

	private Object obterInstancia() throws InstantiationException, IllegalAccessException {
		return (instancia == null) ? instancia = classe.newInstance() : instancia;
	}

	private void invocar(Method metodo, Object objeto, TratadorDeInvocacao tratador) throws IllegalAccessException {
		try {
			metodo.invoke(objeto);
			tratador.tratarInvocacaoSemExcecao(metodo);
		} catch (InvocationTargetException excecao) {
			tratador.tratarInvocacaoComExcecao(metodo, excecao.getCause());
		}
	}

}
