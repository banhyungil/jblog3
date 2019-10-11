package kr.co.itcen.jblog.security;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Auth {
	public ResultAuth value() default ResultAuth.USER;
}
