package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsPeerInfo.class */
abstract class WindowsPeerInfo extends PeerInfo {
    private static native ByteBuffer createHandle();

    private static native int nChoosePixelFormat(long j, int i, int i2, PixelFormat pixelFormat, IntBuffer intBuffer, boolean z, boolean z2, boolean z3, boolean z4) throws LWJGLException;

    protected static native void setPixelFormat(long j, int i) throws LWJGLException;

    private static native long nGetHdc(ByteBuffer byteBuffer);

    private static native long nGetHwnd(ByteBuffer byteBuffer);

    protected WindowsPeerInfo() {
        super(createHandle());
    }

    protected static int choosePixelFormat(long hdc, int origin_x, int origin_y, PixelFormat pixel_format, IntBuffer pixel_format_caps, boolean use_hdc_bpp, boolean support_window, boolean support_pbuffer, boolean double_buffered) throws LWJGLException {
        return nChoosePixelFormat(hdc, origin_x, origin_y, pixel_format, pixel_format_caps, use_hdc_bpp, support_window, support_pbuffer, double_buffered);
    }

    public final long getHdc() {
        return nGetHdc(getHandle());
    }

    public final long getHwnd() {
        return nGetHwnd(getHandle());
    }
}
