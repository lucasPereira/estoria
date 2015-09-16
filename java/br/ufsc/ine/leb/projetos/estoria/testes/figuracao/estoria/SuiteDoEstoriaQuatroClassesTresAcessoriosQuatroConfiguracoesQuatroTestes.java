package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.estoria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.UmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.DoisAcessoriosPassandoPassandoUmaConfiguracaoPassandoUmTestePassando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.DuasConfiguracoesPassandoPassandoUmTestePassando;

@RunWith(Estoria.class)
@SuiteClasses({
		UmTestePassando.class,
		DuasConfiguracoesPassandoPassandoUmTestePassando.class,
		UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class,
		DoisAcessoriosPassandoPassandoUmaConfiguracaoPassandoUmTestePassando.class
})
public class SuiteDoEstoriaQuatroClassesTresAcessoriosQuatroConfiguracoesQuatroTestes {

}
