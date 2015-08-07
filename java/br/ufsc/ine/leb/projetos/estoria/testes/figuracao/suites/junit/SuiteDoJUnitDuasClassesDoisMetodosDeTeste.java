package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseDeTesteUmMetodoDeTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseDeTesteUmMetodoDeTestePassandoVazio;

@RunWith(Suite.class)
@SuiteClasses({
	ClasseDeTesteUmMetodoDeTestePassandoVazio.class,
	ClasseDeTesteUmMetodoDeTestePassando.class
})
public class SuiteDoJUnitDuasClassesDoisMetodosDeTeste {

}
