package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisMetodosDeTestePassando;

@RunWith(Suite.class)
@SuiteClasses({
	ClasseComDoisMetodosDeTestePassando.class
})
public class SuiteDoJUnitUmaClasseDoisMetodosDeTeste {

}
