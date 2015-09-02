package br.ufsc.ine.leb.projetos.estoria;

public enum TipoDeNotificacao {

	TESTES_INICIADOS(true, false, false), TESTES_FINALIZADOS(false, false, true), TESTE_INICIADO(true, false, false), TESTE_FINALIZADO(true, false, false), TESTE_FALHA(true, true, false), TESTE_IGNORADO(true, false, false);

	private Boolean descricao;
	private Boolean falha;
	private Boolean resultado;

	private TipoDeNotificacao(Boolean descricao, Boolean falha, Boolean resultado) {
		this.descricao = descricao;
		this.falha = falha;
		this.resultado = resultado;
	}

	public Boolean possuiDescricao() {
		return descricao;
	}

	public Boolean possuiFalha() {
		return falha;
	}

	public Boolean possuiResultado() {
		return resultado;
	}

}
