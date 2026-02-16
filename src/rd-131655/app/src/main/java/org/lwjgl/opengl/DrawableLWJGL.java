package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/DrawableLWJGL.class */
interface DrawableLWJGL extends Drawable {
    void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException;

    void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException;

    PixelFormatLWJGL getPixelFormat();

    Context getContext();

    Context createSharedContext() throws LWJGLException;

    void checkGLError();

    void setSwapInterval(int i);

    void swapBuffers() throws LWJGLException;

    void initContext(float f, float f2, float f3);
}
