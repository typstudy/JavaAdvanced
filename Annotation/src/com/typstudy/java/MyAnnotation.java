package com.typstudy.java;

import java.lang.annotation.*;

/**
 * @author typ
 * @date 2019/5/21 20:38
 * @Description: com.typstudy.java
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.PACKAGE,
        ElementType.METHOD,ElementType.LOCAL_VARIABLE,ElementType.FIELD,
        ElementType.PARAMETER,ElementType.TYPE_USE})
public @interface MyAnnotation {

    String value() default "hello";
}
