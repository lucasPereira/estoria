package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.estoria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComConfiguracao.UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.testes.classesComTeste.TresTestesPassandoIgnoradoFalhando;

@RunWith(Estoria.class)
@SuiteClasses({
		TresTestesPassandoIgnoradoFalhando.class,
		UmaConfiguracaoPassandoTresTestesPassandoFalhandoIgnorado.class
})
public class SuiteDoEstoriaDuasClassesZeroAcessoriosUmaConfiguracaoSeisTestes {

}
