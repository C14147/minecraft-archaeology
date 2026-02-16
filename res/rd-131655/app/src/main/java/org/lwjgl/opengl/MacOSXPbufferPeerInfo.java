package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXPbufferPeerInfo.class */
final class MacOSXPbufferPeerInfo extends MacOSXPeerInfo {
    private static native void nCreate(ByteBuffer byteBuffer, int i, int i2) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer);

    MacOSXPbufferPeerInfo(int width, int height, PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        super(pixel_format, attribs, false, false, true, false);
        nCreate(getHandle(), width, height);
    }

    @Override // org.lwjgl.opengl.MacOSXPeerInfo, org.lwjgl.opengl.PeerInfo
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
