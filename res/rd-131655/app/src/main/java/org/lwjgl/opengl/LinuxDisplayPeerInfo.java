package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxDisplayPeerInfo.class */
final class LinuxDisplayPeerInfo extends LinuxPeerInfo {
    final boolean egl = true;

    private static native void initDefaultPeerInfo(long j, int i, ByteBuffer byteBuffer, PixelFormat pixelFormat) throws LWJGLException;

    private static native void initDrawable(long j, ByteBuffer byteBuffer);

    LinuxDisplayPeerInfo() throws LWJGLException {
        org.lwjgl.opengles.GLContext.loadOpenGLLibrary();
    }

    LinuxDisplayPeerInfo(PixelFormat pixel_format) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            GLContext.loadOpenGLLibrary();
            try {
                LinuxDisplay.incDisplay();
                try {
                    initDefaultPeerInfo(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), getHandle(), pixel_format);
                } catch (LWJGLException e) {
                    LinuxDisplay.decDisplay();
                    throw e;
                }
            } catch (LWJGLException e2) {
                GLContext.unloadOpenGLLibrary();
                throw e2;
            }
        } finally {
            LinuxDisplay.unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            initDrawable(LinuxDisplay.getWindow(), getHandle());
        } finally {
            LinuxDisplay.unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
    }

    @Override // org.lwjgl.opengl.PeerInfo
    public void destroy() {
        super.destroy();
        if (this.egl) {
            org.lwjgl.opengles.GLContext.unloadOpenGLLibrary();
            return;
        }
        LinuxDisplay.lockAWT();
        LinuxDisplay.decDisplay();
        GLContext.unloadOpenGLLibrary();
        LinuxDisplay.unlockAWT();
    }
}
