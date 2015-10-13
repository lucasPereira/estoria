package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.estoria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste111;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste116;

@RunWith(Estoria.class)
@SuiteClasses({
		ClasseDeTeste111.class,
		ClasseDeTeste116.class
})
public class SuiteDoEstoriaDuasClassesZeroAcessoriosUmaConfiguracaoSeisTestes {

}
