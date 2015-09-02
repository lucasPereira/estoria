package br.ufsc.ine.leb.projetos.estoria;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Acessorio {

	Class<?>classe();

}
