package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmMetodoDeTestePassandoVazio;

@RunWith(Suite.class)
@SuiteClasses({
	UmMetodoDeTestePassandoVazio.class,
	UmMetodoDeTestePassando.class
})
public class SuiteDoJUnitDuasClassesDoisMetodosDeTeste {

}
