package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.estoria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;

@RunWith(Estoria.class)
@SuiteClasses({
		UmTestePassando.class,
		DuasConfiguracoesPassandoPassandoUmTestePassando.class,
		UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class,
		DoisAcessoriosPassandoPassandoUmTestePassando.class
})
public class SuiteDoEstoriaQuatroClassesTresAcessoriosDuasConfiguracoesQuatroTestes {

}
