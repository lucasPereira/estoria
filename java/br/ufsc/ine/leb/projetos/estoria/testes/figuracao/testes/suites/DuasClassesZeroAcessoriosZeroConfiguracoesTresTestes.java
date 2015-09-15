package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.*;

@RunWith(Suite.class)
@SuiteClasses({
		UmTestePassando.class,
		DoisTestesPassandoPassando.class,
})
public class DuasClassesZeroAcessoriosZeroConfiguracoesTresTestes {

}
