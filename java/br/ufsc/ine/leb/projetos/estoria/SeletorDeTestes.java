package br.ufsc.ine.leb.projetos.estoria;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public final class SeletorDeTestes {

	private List<SelecaoDeTeste> selecoes;
	
	
	public SeletorDeTestes() {
		selecoes = new LinkedList<>();
	}
	
	public void adicionarClasse(Class<?> classe) {
		FiltradorDeMetodos filtrador = new FiltradorDeMetodos(classe);
		filtrador.removerMetodosAbstratos();
		filtrador.removerMetodosNativos();
		filtrador.removerMetodosNaoAnotadosCom(Test.class);
		filtrador.removerMetodosAnotadosCom(Ignore.class);
		filtrador.removerMetodosComRetorno();
		filtrador.removerMetodosPrivados();
		filtrador.removerMetodosDefault();
		filtrador.removerMetodosProtegidos();
		filtrador.removerMetodosEstaticos();
		filtrador.removerMetodosGenericos();
		filtrador.removerMetodosParametrizados();
		filtrador.removerMetodosSincronizados();
		List<Method> metodos = filtrador.obterMetodos();
		metodos.forEach(metodo -> selecoes.add(new SelecaoDeTeste(classe, metodo.getName())));
	}

	public List<SelecaoDeTeste> obterSelecoes() {
		return selecoes;
	}

}
