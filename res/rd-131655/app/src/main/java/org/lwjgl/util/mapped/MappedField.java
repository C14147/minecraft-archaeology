package org.lwjgl.util.mapped;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedField.class */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MappedField {
    long byteOffset() default -1;

    long byteLength() default -1;
}
