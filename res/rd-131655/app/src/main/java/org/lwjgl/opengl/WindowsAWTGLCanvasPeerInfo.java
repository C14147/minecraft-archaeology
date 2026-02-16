package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsAWTGLCanvasPeerInfo.class */
final class WindowsAWTGLCanvasPeerInfo extends WindowsPeerInfo {
    private final Canvas component;
    private final AWTSurfaceLock awt_surface = new AWTSurfaceLock();
    private final PixelFormat pixel_format;
    private boolean has_pixel_format;

    private static native void nInitHandle(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    WindowsAWTGLCanvasPeerInfo(Canvas component, PixelFormat pixel_format) {
        this.component = component;
        this.pixel_format = pixel_format;
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
        nInitHandle(this.awt_surface.lockAndGetHandle(this.component), getHandle());
        if (!this.has_pixel_format && this.pixel_format != null) {
            int format = choosePixelFormat(getHdc(), this.component.getX(), this.component.getY(), this.pixel_format, null, true, true, false, true);
            setPixelFormat(getHdc(), format);
            this.has_pixel_format = true;
        }
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }
}
