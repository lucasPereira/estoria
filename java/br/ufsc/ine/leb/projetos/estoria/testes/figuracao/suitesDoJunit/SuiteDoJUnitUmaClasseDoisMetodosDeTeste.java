package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suitesDoJunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.DoisTestesPassandoPassando;

@RunWith(Suite.class)
@SuiteClasses({
	DoisTestesPassandoPassando.class
})
public class SuiteDoJUnitUmaClasseDoisMetodosDeTeste {

}
