package org.shitj.anno;

import org.shitj.config.KeanImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(KeanImportBeanDefinitionRegistrar.class)
public @interface MapperScan {

	String value();

}
