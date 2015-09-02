package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.suitesDoEstoria;

import org.junit.runner.RunWith;

import br.ufsc.ine.leb.projetos.estoria.Estoria;
import br.ufsc.ine.leb.projetos.estoria.SeletorDeTestes;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTeste.TresTestesPassandoIgnoradoFalhando;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classesDeTesteComBefore.UmBeforePassandoTresTestesPassandoFalhandoIgnorado;

@RunWith(Estoria.class)
public class SuiteDoEstoriaDuasClassesSeisMetodosDeTeste extends SeletorDeTestes {

	public SuiteDoEstoriaDuasClassesSeisMetodosDeTeste() {
		adicionarClasse(TresTestesPassandoIgnoradoFalhando.class);
		adicionarClasse(UmBeforePassandoTresTestesPassandoFalhandoIgnorado.class);
	}

}
