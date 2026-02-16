package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/Drawable.class */
public interface Drawable {
    boolean isCurrent() throws LWJGLException;

    void makeCurrent() throws LWJGLException;

    void releaseContext() throws LWJGLException;

    void destroy();

    void setCLSharingProperties(PointerBuffer pointerBuffer) throws LWJGLException;
}
