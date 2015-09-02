package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suitesDoJunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.UmTestePassando;

@RunWith(Suite.class)
@SuiteClasses({
	UmTestePassando.class
})
public class SuiteDoJUnitUmaClasseUmMetodoDeTeste {

}
