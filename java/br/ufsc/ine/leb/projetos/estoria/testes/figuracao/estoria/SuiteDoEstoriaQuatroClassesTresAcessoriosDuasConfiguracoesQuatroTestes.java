package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.estoria;

import org.junit.runner.*;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComAcessorio.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.*;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.diversos.*;

@RunWith(Estoria.class)
@SuiteClasses({
		UmTestePassando.class,
		DuasConfiguracoesPassandoPassandoUmTestePassando.class,
		UmAcessorioPassandoUmaConfiguracaoPassandoUmTestePassando.class
})
public class SuiteDoEstoriaQuatroClassesTresAcessoriosDuasConfiguracoesQuatroTestes {

}
