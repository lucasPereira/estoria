package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.estoria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste117;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste119;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste127;

@RunWith(Estoria.class)
@SuiteClasses({
		ClasseDeTeste101.class,
		ClasseDeTeste117.class,
		ClasseDeTeste119.class,
		ClasseDeTeste127.class
})
public class SuiteDoEstoriaQuatroClassesTresAcessoriosQuatroConfiguracoesQuatroTestes {

}
