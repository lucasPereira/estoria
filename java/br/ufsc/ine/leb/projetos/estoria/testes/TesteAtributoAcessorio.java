package br.ufsc.ine.leb.projetos.estoria.testes;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.AtributoAcessorio;
import br.ufsc.ine.leb.projetos.estoria.AtributoProprio;
import br.ufsc.ine.leb.projetos.estoria.FiltradorDeAtributos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComDoisAtributosDoisMetodos;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberInteger;
import br.ufsc.ine.leb.projetos.estoria.testes.figuracao.classes.ClasseComUmAtributoNumberLong;

public final class TesteAtributoAcessorio {

	private Field atributoInteiro;
	private Field atributoNumeroInteiro;
	private Field atributoNumeroLongo;
	private AtributoAcessorio atributoAcessorioInteiro;
	private AtributoAcessorio atributoAcessorioNumeroInteiro;
	private AtributoAcessorio atributoAcessorioNumeroLongo;
	private AtributoProprio atributoProprioInteiro;
	private AtributoProprio atributoProprioNumeroInteiro;
	private AtributoProprio atributoProprioNumeroLongo;

	@Before
	public void prepararCenario() {
		atributoInteiro = new FiltradorDeAtributos(ClasseComUmAtributoInteger.class).obterAtributos().get(0);
		atributoNumeroInteiro = new FiltradorDeAtributos(ClasseComUmAtributoNumberInteger.class).obterAtributos().get(0);
		atributoNumeroLongo = new FiltradorDeAtributos(ClasseComUmAtributoNumberLong.class).obterAtributos().get(0);
		atributoAcessorioInteiro = new AtributoAcessorio(atributoInteiro);
		atributoAcessorioNumeroInteiro = new AtributoAcessorio(atributoNumeroInteiro);
		atributoAcessorioNumeroLongo = new AtributoAcessorio(atributoNumeroInteiro);
		atributoProprioInteiro = new AtributoProprio(atributoInteiro);
		atributoProprioNumeroInteiro = new AtributoProprio(atributoNumeroInteiro);
		atributoProprioNumeroLongo = new AtributoProprio(atributoNumeroLongo);
	}

	@Test
	public void naoCompativelComNomesDiferentes() throws Exception {
		List<Field> atributos = new FiltradorDeAtributos(ClasseComDoisAtributosDoisMetodos.class).obterAtributos();
		AtributoAcessorio atributoAcessorio = new AtributoAcessorio(atributos.get(0));
		AtributoProprio atributoProprio = new AtributoProprio(atributos.get(1));
		assertFalse(atributoAcessorio.compativelCom(atributoProprio));
	}

	@Test
	public void compativelComMesmoTipo() throws Exception {
		assertTrue(atributoAcessorioInteiro.compativelCom(atributoProprioInteiro));
	}

	@Test
	public void compativelComTipoIgualDeSubClasse() throws Exception {
		assertTrue(atributoAcessorioNumeroInteiro.compativelCom(atributoProprioInteiro));
	}

	@Test
	public void compativelComTipoDiferenteDeSubClasse() throws Exception {
		assertTrue(atributoAcessorioNumeroLongo.compativelCom(atributoProprioInteiro));
	}

	@Test
	public void incompativelComTipoIgualDeSuperClasse() throws Exception {
		assertFalse(atributoAcessorioInteiro.compativelCom(atributoProprioNumeroInteiro));
	}

	@Test
	public void incompativelComTipoDifrenteDeSuperClasse() throws Exception {
		assertFalse(atributoAcessorioInteiro.compativelCom(atributoProprioNumeroLongo));
	}

}
