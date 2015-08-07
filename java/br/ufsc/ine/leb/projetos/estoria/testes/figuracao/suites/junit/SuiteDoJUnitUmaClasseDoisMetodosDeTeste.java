package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseDeTesteDoisMetodosDeTestePassando;

@RunWith(Suite.class)
@SuiteClasses({
	ClasseDeTesteDoisMetodosDeTestePassando.class
})
public class SuiteDoJUnitUmaClasseDoisMetodosDeTeste {

}
