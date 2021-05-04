package com.test.demo.basic.annotationtest.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author chengqj
 * @Date 2020/8/10 9:14
 * @Desc 局部变量注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE)
public @interface LocalVarAnno {

    String name();

    int num() default 0;
}
