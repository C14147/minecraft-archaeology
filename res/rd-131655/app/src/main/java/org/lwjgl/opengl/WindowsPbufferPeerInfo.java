package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsPbufferPeerInfo.class */
final class WindowsPbufferPeerInfo extends WindowsPeerInfo {
    private static native void nCreate(ByteBuffer byteBuffer, int i, int i2, PixelFormat pixelFormat, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException;

    private static native boolean nIsBufferLost(ByteBuffer byteBuffer);

    private static native void nSetPbufferAttrib(ByteBuffer byteBuffer, int i, int i2);

    private static native void nBindTexImageToPbuffer(ByteBuffer byteBuffer, int i);

    private static native void nReleaseTexImageFromPbuffer(ByteBuffer byteBuffer, int i);

    private static native void nDestroy(ByteBuffer byteBuffer);

    WindowsPbufferPeerInfo(int width, int height, PixelFormat pixel_format, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException {
        nCreate(getHandle(), width, height, pixel_format, pixelFormatCaps, pBufferAttribs);
    }

    public boolean isBufferLost() {
        return nIsBufferLost(getHandle());
    }

    public void setPbufferAttrib(int attrib, int value) {
        nSetPbufferAttrib(getHandle(), attrib, value);
    }

    public void bindTexImageToPbuffer(int buffer) {
        nBindTexImageToPbuffer(getHandle(), buffer);
    }

    public void releaseTexImageFromPbuffer(int buffer) {
        nReleaseTexImageFromPbuffer(getHandle(), buffer);
    }

    @Override // org.lwjgl.opengl.PeerInfo
    public void destroy() {
        nDestroy(getHandle());
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
    }
}
