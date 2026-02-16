package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxPbufferPeerInfo.class */
final class LinuxPbufferPeerInfo extends LinuxPeerInfo {
    private static native void nInitHandle(long j, int i, ByteBuffer byteBuffer, int i2, int i3, PixelFormat pixelFormat) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer);

    LinuxPbufferPeerInfo(int width, int height, PixelFormat pixel_format) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            GLContext.loadOpenGLLibrary();
            try {
                LinuxDisplay.incDisplay();
                try {
                    nInitHandle(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), getHandle(), width, height, pixel_format);
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
    public void destroy() {
        LinuxDisplay.lockAWT();
        nDestroy(getHandle());
        LinuxDisplay.decDisplay();
        GLContext.unloadOpenGLLibrary();
        LinuxDisplay.unlockAWT();
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
    }
}
