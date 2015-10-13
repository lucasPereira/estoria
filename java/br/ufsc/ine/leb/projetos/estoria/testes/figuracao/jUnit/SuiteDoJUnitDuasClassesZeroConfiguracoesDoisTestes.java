package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.jUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste101;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.ClasseDeTeste104;

@RunWith(Suite.class)
@SuiteClasses({
		ClasseDeTeste101.class,
		ClasseDeTeste104.class
})
public class SuiteDoJUnitDuasClassesZeroConfiguracoesDoisTestes {

}
