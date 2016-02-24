package br.ufsc.ine.leb.projetos.estoria;

import java.util.LinkedList;
import java.util.List;

public final class Ata {

	private static final String SIMBOLO_DE_ESPACAMENTO_PADRAO = "·  ";

	private List<String> registros;
	private Escrivao escrivao;
	private Integer indentacao;
	private String simboloDeEspacamento;

	public Ata() {
		this(new EscrivaoPadrao(), SIMBOLO_DE_ESPACAMENTO_PADRAO);
	}

	public Ata(Escrivao escrivao) {
		this(escrivao, SIMBOLO_DE_ESPACAMENTO_PADRAO);
	}

	public Ata(Escrivao escrivao, String simboloDeEspacamento) {
		this.escrivao = escrivao;
		this.registros = new LinkedList<>();
		this.simboloDeEspacamento = simboloDeEspacamento;
		this.indentacao = 0;
	}

	public List<String> obterRegistros() {
		return registros;
	}

	public void registrar(String formato, Object... parametros) {
		String registro = String.format(formato, parametros);
		String registroComEspacamento = adicionarEspacamento(registro);
		registros.add(registroComEspacamento);
		escrivao.escrever(registroComEspacamento);
	}

	private String adicionarEspacamento(String registro) {
		StringBuilder espacamento = new StringBuilder();
		for (Integer contador = 0; contador < indentacao; contador++) {
			espacamento.append(simboloDeEspacamento);
		}
		espacamento.append(registro);
		return espacamento.toString();
	}

	public void avancarIndentacao() {
		indentacao++;
	}

	public void recuarIndentacao() {
		if (indentacao == 0) {
			throw new ExcecaoRecuoDeAtaMaiorDoQuePermitido();
		}
		indentacao--;
	}

}
