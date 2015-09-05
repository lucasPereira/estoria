package br.ufsc.ine.leb.projetos.estoria.testes.figuracao.anotacoes;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(value = Anotacoes.class)
@Target(value = { ANNOTATION_TYPE, CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE, TYPE_PARAMETER, TYPE_USE })
public @interface Anotacao {

	String valor();

}
