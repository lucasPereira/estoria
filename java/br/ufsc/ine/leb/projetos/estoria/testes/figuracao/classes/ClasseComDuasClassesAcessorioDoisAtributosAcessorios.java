package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes;

import br.ufsc.ine.leb.projetos.estoria.*;

@FixtureSetup({ ClasseComUmMetodo.class, ClasseVazia.class })
public class ClasseComDuasClassesAcessorioDoisAtributosAcessorios {

	@Fixture public String atributo1;
	@Fixture public String atributo2;

	public void testar() {}

}
