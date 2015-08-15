package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.anotacoes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Anotacoes {

	Anotacao[] value();

}
