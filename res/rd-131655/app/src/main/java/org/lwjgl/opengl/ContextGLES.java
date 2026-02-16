package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengles.EGL;
import org.lwjgl.opengles.EGLContext;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.PowerManagementEventException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ContextGLES.class */
final class ContextGLES implements Context {
    private static final ThreadLocal<ContextGLES> current_context_local = new ThreadLocal<>();
    private final DrawableGLES drawable;
    private final EGLContext eglContext;
    private final org.lwjgl.opengles.ContextAttribs contextAttribs;
    private boolean destroyed;
    private boolean destroy_requested;
    private Thread thread;

    static {
        Sys.initialize();
    }

    public EGLContext getEGLContext() {
        return this.eglContext;
    }

    org.lwjgl.opengles.ContextAttribs getContextAttribs() {
        return this.contextAttribs;
    }

    static ContextGLES getCurrentContext() {
        return current_context_local.get();
    }

    ContextGLES(DrawableGLES drawable, org.lwjgl.opengles.ContextAttribs attribs, ContextGLES shared_context) throws LWJGLException {
        if (drawable == null) {
            throw new IllegalArgumentException();
        }
        ContextGLES context_lock = shared_context != null ? shared_context : this;
        synchronized (context_lock) {
            if (shared_context != null) {
                if (shared_context.destroyed) {
                    throw new IllegalArgumentException("Shared context is destroyed");
                }
            }
            this.drawable = drawable;
            this.contextAttribs = attribs;
            this.eglContext = drawable.getEGLDisplay().createContext(drawable.getEGLConfig(), shared_context == null ? null : shared_context.eglContext, attribs == null ? new org.lwjgl.opengles.ContextAttribs(2).getAttribList() : attribs.getAttribList());
        }
    }

    @Override // org.lwjgl.opengl.Context
    public void releaseCurrent() throws PowerManagementEventException, LWJGLException {
        EGL.eglReleaseCurrent(this.drawable.getEGLDisplay());
        org.lwjgl.opengles.GLContext.useContext((Object) null);
        current_context_local.set(null);
        synchronized (this) {
            this.thread = null;
            checkDestroy();
        }
    }

    public static void swapBuffers() throws PowerManagementEventException, LWJGLException {
        ContextGLES current_context = getCurrentContext();
        if (current_context != null) {
            current_context.drawable.getEGLSurface().swapBuffers();
        }
    }

    private boolean canAccess() {
        return this.thread == null || Thread.currentThread() == this.thread;
    }

    private void checkAccess() {
        if (!canAccess()) {
            throw new IllegalStateException("From thread " + Thread.currentThread() + ": " + this.thread + " already has the context current");
        }
    }

    @Override // org.lwjgl.opengl.Context
    public synchronized void makeCurrent() throws PowerManagementEventException, LWJGLException {
        checkAccess();
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        this.thread = Thread.currentThread();
        current_context_local.set(this);
        this.eglContext.makeCurrent(this.drawable.getEGLSurface());
        org.lwjgl.opengles.GLContext.useContext(this);
    }

    @Override // org.lwjgl.opengl.Context
    public synchronized boolean isCurrent() throws LWJGLException {
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        return EGL.eglIsCurrentContext(this.eglContext);
    }

    private void checkDestroy() {
        if (!this.destroyed && this.destroy_requested) {
            try {
                this.eglContext.destroy();
                this.destroyed = true;
                this.thread = null;
            } catch (LWJGLException e) {
                LWJGLUtil.log("Exception occurred while destroying context: " + e);
            }
        }
    }

    public static void setSwapInterval(int value) {
        ContextGLES current_context = getCurrentContext();
        if (current_context != null) {
            try {
                current_context.drawable.getEGLDisplay().setSwapInterval(value);
            } catch (LWJGLException e) {
                LWJGLUtil.log("Failed to set swap interval. Reason: " + e.getMessage());
            }
        }
    }

    public synchronized void forceDestroy() throws LWJGLException {
        checkAccess();
        destroy();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.lwjgl.opengles.PowerManagementEventException */
    public synchronized void destroy() throws LWJGLException {
        if (this.destroyed) {
            return;
        }
        this.destroy_requested = true;
        boolean was_current = isCurrent();
        int error = 0;
        if (was_current) {
            if (org.lwjgl.opengles.GLContext.getCapabilities() != null && org.lwjgl.opengles.GLContext.getCapabilities().OpenGLES20) {
                error = GLES20.glGetError();
            }
            try {
                releaseCurrent();
            } catch (PowerManagementEventException e) {
            }
        }
        checkDestroy();
        if (was_current && error != 0) {
            throw new OpenGLException(error);
        }
    }

    @Override // org.lwjgl.opengl.Context
    public void releaseDrawable() throws LWJGLException {
    }
}
