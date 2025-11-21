package edu.ucsal.fiadopay.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AntiFraude {
	
	double threshold() default 5000.00;
	String name() default "RulePadrao";
}
