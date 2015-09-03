package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.jUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassandoVazio;

@RunWith(Suite.class)
@SuiteClasses({
		UmTestePassandoVazio.class,
		UmTestePassando.class
})
public class SuiteDoJUnitDuasClassesDoisMetodosDeTeste {

}
