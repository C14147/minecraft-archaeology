package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Sys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ContextGL.class */
final class ContextGL implements Context {
    private static final ContextImplementation implementation;
    private static final ThreadLocal<ContextGL> current_context_local = new ThreadLocal<>();
    private final ByteBuffer handle;
    private final PeerInfo peer_info;
    private final ContextAttribs contextAttribs;
    private final boolean forwardCompatible;
    private boolean destroyed;
    private boolean destroy_requested;
    private Thread thread;

    static {
        Sys.initialize();
        implementation = createImplementation();
    }

    private static ContextImplementation createImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                return new LinuxContextImplementation();
            case 2:
                return new MacOSXContextImplementation();
            case 3:
                return new WindowsContextImplementation();
            default:
                throw new IllegalStateException("Unsupported platform");
        }
    }

    PeerInfo getPeerInfo() {
        return this.peer_info;
    }

    ContextAttribs getContextAttribs() {
        return this.contextAttribs;
    }

    static ContextGL getCurrentContext() {
        return current_context_local.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b A[Catch: LWJGLException -> 0x0072, all -> 0x0080, TryCatch #1 {LWJGLException -> 0x0072, blocks: (B:15:0x002d, B:17:0x003b, B:19:0x0054, B:21:0x005f, B:23:0x0067, B:18:0x004c), top: B:37:0x002d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: LWJGLException -> 0x0072, all -> 0x0080, TryCatch #1 {LWJGLException -> 0x0072, blocks: (B:15:0x002d, B:17:0x003b, B:19:0x0054, B:21:0x005f, B:23:0x0067, B:18:0x004c), top: B:37:0x002d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[Catch: LWJGLException -> 0x0072, all -> 0x0080, TryCatch #1 {LWJGLException -> 0x0072, blocks: (B:15:0x002d, B:17:0x003b, B:19:0x0054, B:21:0x005f, B:23:0x0067, B:18:0x004c), top: B:37:0x002d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    ContextGL(org.lwjgl.opengl.PeerInfo r7, org.lwjgl.opengl.ContextAttribs r8, org.lwjgl.opengl.ContextGL r9) throws org.lwjgl.LWJGLException {
        /*
            r6 = this;
            r0 = r6
            r0.<init>()
            r0 = r9
            if (r0 == 0) goto Lc
            r0 = r9
            goto Ld
        Lc:
            r0 = r6
        Ld:
            r10 = r0
            r0 = r10
            r1 = r0
            r11 = r1
            monitor-enter(r0)
            r0 = r9
            if (r0 == 0) goto L2a
            r0 = r9
            boolean r0 = r0.destroyed     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L2a
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L80
            r1 = r0
            java.lang.String r2 = "Shared context is destroyed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L80
            throw r0     // Catch: java.lang.Throwable -> L80
        L2a:
            org.lwjgl.opengl.GLContext.loadOpenGLLibrary()     // Catch: java.lang.Throwable -> L80
            r0 = r6
            r1 = r7
            r0.peer_info = r1     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            r0 = r6
            r1 = r8
            r0.contextAttribs = r1     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            r0 = r8
            if (r0 == 0) goto L4c
            r0 = r8
            java.nio.IntBuffer r0 = r0.getAttribList()     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            r12 = r0
            r0 = r6
            r1 = r8
            boolean r1 = r1.isForwardCompatible()     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            r0.forwardCompatible = r1     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            goto L54
        L4c:
            r0 = 0
            r12 = r0
            r0 = r6
            r1 = 0
            r0.forwardCompatible = r1     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
        L54:
            r0 = r6
            org.lwjgl.opengl.ContextImplementation r1 = org.lwjgl.opengl.ContextGL.implementation     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            r2 = r7
            r3 = r12
            r4 = r9
            if (r4 == 0) goto L66
            r4 = r9
            java.nio.ByteBuffer r4 = r4.handle     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            goto L67
        L66:
            r4 = 0
        L67:
            java.nio.ByteBuffer r1 = r1.create(r2, r3, r4)     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            r0.handle = r1     // Catch: org.lwjgl.LWJGLException -> L72 java.lang.Throwable -> L80
            goto L7a
        L72:
            r12 = move-exception
            org.lwjgl.opengl.GLContext.unloadOpenGLLibrary()     // Catch: java.lang.Throwable -> L80
            r0 = r12
            throw r0     // Catch: java.lang.Throwable -> L80
        L7a:
            r0 = r11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
            goto L88
        L80:
            r13 = move-exception
            r0 = r11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
            r0 = r13
            throw r0
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextGL.<init>(org.lwjgl.opengl.PeerInfo, org.lwjgl.opengl.ContextAttribs, org.lwjgl.opengl.ContextGL):void");
    }

    @Override // org.lwjgl.opengl.Context
    public void releaseCurrent() throws LWJGLException {
        ContextGL current_context = getCurrentContext();
        if (current_context != null) {
            implementation.releaseCurrentContext();
            GLContext.useContext(null);
            current_context_local.set(null);
            synchronized (current_context) {
                current_context.thread = null;
                current_context.checkDestroy();
            }
        }
    }

    @Override // org.lwjgl.opengl.Context
    public synchronized void releaseDrawable() throws LWJGLException {
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        implementation.releaseDrawable(getHandle());
    }

    public synchronized void update() {
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        implementation.update(getHandle());
    }

    public static void swapBuffers() throws LWJGLException {
        implementation.swapBuffers();
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
    public synchronized void makeCurrent() throws LWJGLException {
        checkAccess();
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        this.thread = Thread.currentThread();
        current_context_local.set(this);
        implementation.makeCurrent(this.peer_info, this.handle);
        GLContext.useContext(this, this.forwardCompatible);
    }

    ByteBuffer getHandle() {
        return this.handle;
    }

    @Override // org.lwjgl.opengl.Context
    public synchronized boolean isCurrent() throws LWJGLException {
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        return implementation.isCurrent(this.handle);
    }

    private void checkDestroy() {
        if (!this.destroyed && this.destroy_requested) {
            try {
                releaseDrawable();
                implementation.destroy(this.peer_info, this.handle);
                CallbackUtil.unregisterCallbacks(this);
                this.destroyed = true;
                this.thread = null;
                GLContext.unloadOpenGLLibrary();
            } catch (LWJGLException e) {
                LWJGLUtil.log("Exception occurred while destroying context: " + e);
            }
        }
    }

    public static void setSwapInterval(int value) {
        implementation.setSwapInterval(value);
    }

    public synchronized void forceDestroy() throws LWJGLException {
        checkAccess();
        destroy();
    }

    public synchronized void destroy() throws LWJGLException {
        if (this.destroyed) {
            return;
        }
        this.destroy_requested = true;
        boolean was_current = isCurrent();
        int error = 0;
        if (was_current) {
            try {
                error = GL11.glGetError();
            } catch (Exception e) {
            }
            releaseCurrent();
        }
        checkDestroy();
        if (was_current && error != 0) {
            throw new OpenGLException(error);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public synchronized void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
        ByteBuffer peer_handle = this.peer_info.lockAndGetHandle();
        try {
            switch (LWJGLUtil.getPlatform()) {
                case 1:
                    LinuxContextImplementation implLinux = (LinuxContextImplementation) implementation;
                    properties.put(8200L).put(implLinux.getGLXContext(this.handle));
                    properties.put(8202L).put(implLinux.getDisplay(peer_handle));
                    break;
                case 2:
                    if (LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 6)) {
                        MacOSXContextImplementation implMacOSX = (MacOSXContextImplementation) implementation;
                        long CGLShareGroup = implMacOSX.getCGLShareGroup(this.handle);
                        properties.put(268435456L).put(CGLShareGroup);
                        break;
                    }
                    throw new UnsupportedOperationException("CL/GL context sharing is not supported on this platform.");
                case 3:
                    WindowsContextImplementation implWindows = (WindowsContextImplementation) implementation;
                    properties.put(8200L).put(implWindows.getHGLRC(this.handle));
                    properties.put(8203L).put(implWindows.getHDC(peer_handle));
                    break;
                default:
                    throw new UnsupportedOperationException("CL/GL context sharing is not supported on this platform.");
            }
        } finally {
            this.peer_info.unlock();
        }
    }
}
