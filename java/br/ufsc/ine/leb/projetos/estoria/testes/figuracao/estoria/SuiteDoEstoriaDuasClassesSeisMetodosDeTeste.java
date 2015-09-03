package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.estoria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.TresTestesPassandoIgnoradoFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTesteComBefore.UmBeforePassandoTresTestesPassandoFalhandoIgnorado;

@RunWith(Estoria.class)
@SuiteClasses({
		TresTestesPassandoIgnoradoFalhando.class,
		UmBeforePassandoTresTestesPassandoFalhandoIgnorado.class
})
public class SuiteDoEstoriaDuasClassesSeisMetodosDeTeste {

}
