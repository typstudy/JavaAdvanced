package com.typstudy.java;

import java.lang.annotation.*;

/**
 * @author typ
 * @date 2019/5/21 20:48
 * @Description: com.typstudy.java
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.PACKAGE,
        ElementType.METHOD,ElementType.LOCAL_VARIABLE,ElementType.FIELD,ElementType.PARAMETER})

public @interface MyAnnotations {
    MyAnnotation[] value();
}
