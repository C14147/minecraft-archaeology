package org.lwjgl.input;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.InputImplementation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/input/OpenGLPackageAccess.class */
final class OpenGLPackageAccess {
    static final Object global_lock;

    OpenGLPackageAccess() {
    }

    static {
        try {
            global_lock = AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: org.lwjgl.input.OpenGLPackageAccess.1
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws Exception {
                    Field lock_field = Class.forName("org.lwjgl.opengl.GlobalLock").getDeclaredField("lock");
                    lock_field.setAccessible(true);
                    return lock_field.get(null);
                }
            });
        } catch (PrivilegedActionException e) {
            throw new Error(e);
        }
    }

    static InputImplementation createImplementation() {
        try {
            return (InputImplementation) AccessController.doPrivileged(new PrivilegedExceptionAction<InputImplementation>() { // from class: org.lwjgl.input.OpenGLPackageAccess.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public InputImplementation run() throws Exception {
                    Method getImplementation_method = Display.class.getDeclaredMethod("getImplementation", new Class[0]);
                    getImplementation_method.setAccessible(true);
                    return (InputImplementation) getImplementation_method.invoke(null, new Object[0]);
                }
            });
        } catch (PrivilegedActionException e) {
            throw new Error(e);
        }
    }
}
