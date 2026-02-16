package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsDisplayPeerInfo.class */
final class WindowsDisplayPeerInfo extends WindowsPeerInfo {
    final boolean egl;

    private static native void nInitDC(ByteBuffer byteBuffer, long j, long j2);

    WindowsDisplayPeerInfo(boolean egl) throws LWJGLException {
        this.egl = egl;
        if (egl) {
            org.lwjgl.opengles.GLContext.loadOpenGLLibrary();
        } else {
            GLContext.loadOpenGLLibrary();
        }
    }

    void initDC(long hwnd, long hdc) throws LWJGLException {
        nInitDC(getHandle(), hwnd, hdc);
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
    }

    @Override // org.lwjgl.opengl.PeerInfo
    public void destroy() {
        super.destroy();
        if (this.egl) {
            org.lwjgl.opengles.GLContext.unloadOpenGLLibrary();
        } else {
            GLContext.unloadOpenGLLibrary();
        }
    }
}
