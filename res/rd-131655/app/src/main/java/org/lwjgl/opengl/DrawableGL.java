package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/DrawableGL.class */
abstract class DrawableGL implements DrawableLWJGL {
    protected PixelFormat pixel_format;
    protected PeerInfo peer_info;
    protected ContextGL context;

    protected DrawableGL() {
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException {
        throw new UnsupportedOperationException();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs) throws LWJGLException {
        this.pixel_format = (PixelFormat) pf;
        this.peer_info = Display.getImplementation().createPeerInfo(this.pixel_format, attribs);
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public PixelFormatLWJGL getPixelFormat() {
        return this.pixel_format;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public ContextGL getContext() {
        ContextGL contextGL;
        synchronized (GlobalLock.lock) {
            contextGL = this.context;
        }
        return contextGL;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public ContextGL createSharedContext() throws LWJGLException {
        ContextGL contextGL;
        synchronized (GlobalLock.lock) {
            checkDestroyed();
            contextGL = new ContextGL(this.peer_info, this.context.getContextAttribs(), this.context);
        }
        return contextGL;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void checkGLError() {
        Util.checkGLError();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setSwapInterval(int swap_interval) {
        ContextGL.setSwapInterval(swap_interval);
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void swapBuffers() throws LWJGLException {
        ContextGL.swapBuffers();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void initContext(float r, float g, float b) {
        GL11.glClearColor(r, g, b, 0.0f);
        GL11.glClear(16384);
    }

    @Override // org.lwjgl.opengl.Drawable
    public boolean isCurrent() throws LWJGLException {
        boolean zIsCurrent;
        synchronized (GlobalLock.lock) {
            checkDestroyed();
            zIsCurrent = this.context.isCurrent();
        }
        return zIsCurrent;
    }

    @Override // org.lwjgl.opengl.Drawable
    public void makeCurrent() throws LWJGLException {
        synchronized (GlobalLock.lock) {
            checkDestroyed();
            this.context.makeCurrent();
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public void releaseContext() throws LWJGLException {
        synchronized (GlobalLock.lock) {
            checkDestroyed();
            if (this.context.isCurrent()) {
                this.context.releaseCurrent();
            }
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public void destroy() {
        synchronized (GlobalLock.lock) {
            if (this.context == null) {
                return;
            }
            try {
                releaseContext();
                this.context.forceDestroy();
                this.context = null;
                if (this.peer_info != null) {
                    this.peer_info.destroy();
                    this.peer_info = null;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Exception occurred while destroying Drawable: " + e);
            }
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            checkDestroyed();
            this.context.setCLSharingProperties(properties);
        }
    }

    protected final void checkDestroyed() {
        if (this.context == null) {
            throw new IllegalStateException("The Drawable has no context available.");
        }
    }
}
