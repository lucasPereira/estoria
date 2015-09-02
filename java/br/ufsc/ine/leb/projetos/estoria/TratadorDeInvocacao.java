package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;

public interface TratadorDeInvocacao {

	public void tratarInvocacaoSemExcecao(Method metodo);

	public void tratarInvocacaoComExcecao(Method metodo, Throwable excecao);

}
