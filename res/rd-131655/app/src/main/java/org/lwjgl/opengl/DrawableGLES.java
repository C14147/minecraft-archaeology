package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengles.EGL;
import org.lwjgl.opengles.EGLConfig;
import org.lwjgl.opengles.EGLDisplay;
import org.lwjgl.opengles.EGLSurface;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.PowerManagementEventException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/DrawableGLES.class */
abstract class DrawableGLES implements DrawableLWJGL {
    protected org.lwjgl.opengles.PixelFormat pixel_format;
    protected EGLDisplay eglDisplay;
    protected EGLConfig eglConfig;
    protected EGLSurface eglSurface;
    protected ContextGLES context;
    protected Drawable shared_drawable;

    protected DrawableGLES() {
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            this.pixel_format = (org.lwjgl.opengles.PixelFormat) pf;
        }
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public PixelFormatLWJGL getPixelFormat() {
        org.lwjgl.opengles.PixelFormat pixelFormat;
        synchronized (GlobalLock.lock) {
            pixelFormat = this.pixel_format;
        }
        return pixelFormat;
    }

    public void initialize(long window, long display_id, int eglSurfaceType, org.lwjgl.opengles.PixelFormat pf) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (this.eglSurface != null) {
                this.eglSurface.destroy();
                this.eglSurface = null;
            }
            if (this.eglDisplay != null) {
                this.eglDisplay.terminate();
                this.eglDisplay = null;
            }
            EGLDisplay eglDisplay = EGL.eglGetDisplay((int) display_id);
            int[] attribs = {12329, 0, 12352, 4, 12333, 0};
            EGLConfig[] configs = eglDisplay.chooseConfig(pf.getAttribBuffer(eglDisplay, eglSurfaceType, attribs), (EGLConfig[]) null, BufferUtils.createIntBuffer(1));
            if (configs.length == 0) {
                throw new LWJGLException("No EGLConfigs found for the specified PixelFormat.");
            }
            EGLConfig eglConfig = pf.getBestMatch(configs);
            EGLSurface eglSurface = eglDisplay.createWindowSurface(eglConfig, window, (IntBuffer) null);
            pf.setSurfaceAttribs(eglSurface);
            this.eglDisplay = eglDisplay;
            this.eglConfig = eglConfig;
            this.eglSurface = eglSurface;
            if (this.context != null) {
                this.context.getEGLContext().setDisplay(eglDisplay);
            }
        }
    }

    public void createContext(org.lwjgl.opengles.ContextAttribs attribs, Drawable shared_drawable) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            this.context = new ContextGLES(this, attribs, shared_drawable != null ? ((DrawableGLES) shared_drawable).getContext() : null);
            this.shared_drawable = shared_drawable;
        }
    }

    Drawable getSharedDrawable() {
        Drawable drawable;
        synchronized (GlobalLock.lock) {
            drawable = this.shared_drawable;
        }
        return drawable;
    }

    public EGLDisplay getEGLDisplay() {
        EGLDisplay eGLDisplay;
        synchronized (GlobalLock.lock) {
            eGLDisplay = this.eglDisplay;
        }
        return eGLDisplay;
    }

    public EGLConfig getEGLConfig() {
        EGLConfig eGLConfig;
        synchronized (GlobalLock.lock) {
            eGLConfig = this.eglConfig;
        }
        return eGLConfig;
    }

    public EGLSurface getEGLSurface() {
        EGLSurface eGLSurface;
        synchronized (GlobalLock.lock) {
            eGLSurface = this.eglSurface;
        }
        return eGLSurface;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public ContextGLES getContext() {
        ContextGLES contextGLES;
        synchronized (GlobalLock.lock) {
            contextGLES = this.context;
        }
        return contextGLES;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public Context createSharedContext() throws LWJGLException {
        ContextGLES contextGLES;
        synchronized (GlobalLock.lock) {
            checkDestroyed();
            contextGLES = new ContextGLES(this, this.context.getContextAttribs(), this.context);
        }
        return contextGLES;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void checkGLError() {
        org.lwjgl.opengles.Util.checkGLError();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setSwapInterval(int swap_interval) {
        ContextGLES.setSwapInterval(swap_interval);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.lwjgl.opengles.PowerManagementEventException */
    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void swapBuffers() throws PowerManagementEventException, LWJGLException {
        ContextGLES.swapBuffers();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void initContext(float r, float g, float b) {
        GLES20.glClearColor(r, g, b, 0.0f);
        GLES20.glClear(16384);
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
    public void makeCurrent() throws PowerManagementEventException, LWJGLException {
        synchronized (GlobalLock.lock) {
            checkDestroyed();
            this.context.makeCurrent();
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public void releaseContext() throws PowerManagementEventException, LWJGLException {
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
            try {
                if (this.context != null) {
                    try {
                        releaseContext();
                    } catch (PowerManagementEventException e) {
                    }
                    this.context.forceDestroy();
                    this.context = null;
                }
                if (this.eglSurface != null) {
                    this.eglSurface.destroy();
                    this.eglSurface = null;
                }
                if (this.eglDisplay != null) {
                    this.eglDisplay.terminate();
                    this.eglDisplay = null;
                }
                this.pixel_format = null;
                this.shared_drawable = null;
            } catch (LWJGLException e2) {
                LWJGLUtil.log("Exception occurred while destroying Drawable: " + e2);
            }
        }
    }

    protected void checkDestroyed() {
        if (this.context == null) {
            throw new IllegalStateException("The Drawable has no context available.");
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
        throw new UnsupportedOperationException();
    }
}
