package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassando;

@RunWith(Suite.class)
@SuiteClasses({
	ClasseComUmMetodoDeTestePassando.class
})
public class SuiteDoJUnitUmaClasseUmMetodoDeTeste {

}
