package org.lwjgl.util.mapped;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/CacheLinePad.class */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheLinePad {
    boolean before() default false;

    boolean after() default true;
}
