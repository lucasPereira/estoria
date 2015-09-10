package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import br.ufsc.ine.leb.projetos.estoria.*;

@Acessorios({ ClasseComUmMetodo.class, ClasseSemMetodos.class })
public class ClasseComDuasClassesAcessorioDoisAtributosAcessorios {

	@Acessorio public String atributo1;
	@Acessorio public String atributo2;

	public void testar() {}

}
