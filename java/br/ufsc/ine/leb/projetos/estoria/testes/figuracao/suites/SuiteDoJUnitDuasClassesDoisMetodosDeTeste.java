package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmMetodoDeTestePassandoVazio;

@RunWith(Suite.class)
@SuiteClasses({
	ClasseComUmMetodoDeTestePassandoVazio.class,
	ClasseComUmMetodoDeTestePassando.class
})
public class SuiteDoJUnitDuasClassesDoisMetodosDeTeste {

}
