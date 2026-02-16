package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/Context.class */
interface Context {
    boolean isCurrent() throws LWJGLException;

    void makeCurrent() throws LWJGLException;

    void releaseCurrent() throws LWJGLException;

    void releaseDrawable() throws LWJGLException;
}
