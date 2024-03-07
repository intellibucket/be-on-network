package com.intellibucket.lib.fj.dataaccess.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE,
        java.lang.annotation.ElementType.METHOD,
        java.lang.annotation.ElementType.FIELD,
        java.lang.annotation.ElementType.PARAMETER,
        java.lang.annotation.ElementType.CONSTRUCTOR,
        java.lang.annotation.ElementType.LOCAL_VARIABLE,
        java.lang.annotation.ElementType.ANNOTATION_TYPE,
        java.lang.annotation.ElementType.PACKAGE,
        java.lang.annotation.ElementType.TYPE_PARAMETER,
        java.lang.annotation.ElementType.TYPE_USE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Description {
    String[] value();
}
