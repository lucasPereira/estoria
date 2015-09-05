package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.jUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassandoVazio;

@RunWith(Suite.class)
@SuiteClasses({
		UmTestePassando.class,
		UmTestePassandoVazio.class
})
public class SuiteDoJUnitDuasClassesZeroConfiguracoesDoisTestes {

}
