package org.lwjgl.util.mapped;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedType.class */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MappedType {
    int padding() default 0;

    boolean cacheLinePadding() default false;

    int align() default 4;

    boolean autoGenerateOffsets() default true;
}
