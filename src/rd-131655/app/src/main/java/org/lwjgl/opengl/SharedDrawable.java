package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/SharedDrawable.class */
public final class SharedDrawable extends DrawableGL {
    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void setCLSharingProperties(PointerBuffer x0) throws LWJGLException {
        super.setCLSharingProperties(x0);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void releaseContext() throws LWJGLException {
        super.releaseContext();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void makeCurrent() throws LWJGLException {
        super.makeCurrent();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ boolean isCurrent() throws LWJGLException {
        return super.isCurrent();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void initContext(float x0, float x1, float x2) {
        super.initContext(x0, x1, x2);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void swapBuffers() throws LWJGLException {
        super.swapBuffers();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void setSwapInterval(int x0) {
        super.setSwapInterval(x0);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void checkGLError() {
        super.checkGLError();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ ContextGL getContext() {
        return super.getContext();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ PixelFormatLWJGL getPixelFormat() {
        return super.getPixelFormat();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL x0, ContextAttribs x1) throws LWJGLException {
        super.setPixelFormat(x0, x1);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL x0) throws LWJGLException {
        super.setPixelFormat(x0);
    }

    public SharedDrawable(Drawable drawable) throws LWJGLException {
        this.context = (ContextGL) ((DrawableLWJGL) drawable).createSharedContext();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public ContextGL createSharedContext() {
        throw new UnsupportedOperationException();
    }
}
