package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxAWTGLCanvasPeerInfo.class */
final class LinuxAWTGLCanvasPeerInfo extends LinuxPeerInfo {
    private final Canvas component;
    private final AWTSurfaceLock awt_surface = new AWTSurfaceLock();
    private int screen = -1;

    private static native int getScreenFromSurfaceInfo(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nInitHandle(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    LinuxAWTGLCanvasPeerInfo(Canvas component) {
        this.component = component;
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
        ByteBuffer surface_handle = this.awt_surface.lockAndGetHandle(this.component);
        if (this.screen == -1) {
            try {
                this.screen = getScreenFromSurfaceInfo(surface_handle);
            } catch (LWJGLException e) {
                LWJGLUtil.log("Got exception while trying to determine screen: " + e);
                this.screen = 0;
            }
        }
        nInitHandle(this.screen, surface_handle, getHandle());
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }
}
