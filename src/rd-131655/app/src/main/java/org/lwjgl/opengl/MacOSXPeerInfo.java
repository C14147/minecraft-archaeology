package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXPeerInfo.class */
abstract class MacOSXPeerInfo extends PeerInfo {
    private static native ByteBuffer createHandle();

    private static native void nChoosePixelFormat(ByteBuffer byteBuffer, PixelFormat pixelFormat, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer);

    MacOSXPeerInfo(PixelFormat pixel_format, ContextAttribs attribs, boolean use_display_bpp, boolean support_window, boolean support_pbuffer, boolean double_buffered) throws LWJGLException {
        super(createHandle());
        boolean gl32 = attribs != null && (3 < attribs.getMajorVersion() || (attribs.getMajorVersion() == 3 && 2 <= attribs.getMinorVersion())) && attribs.isProfileCore();
        if (gl32 && !LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 7)) {
            throw new LWJGLException("OpenGL 3.2+ requested, but it requires MacOS X 10.7 or newer");
        }
        choosePixelFormat(pixel_format, gl32, use_display_bpp, support_window, support_pbuffer, double_buffered);
    }

    private void choosePixelFormat(PixelFormat pixel_format, boolean gl32, boolean use_display_bpp, boolean support_window, boolean support_pbuffer, boolean double_buffered) throws LWJGLException {
        nChoosePixelFormat(getHandle(), pixel_format, gl32, use_display_bpp, support_window, support_pbuffer, double_buffered);
    }

    @Override // org.lwjgl.opengl.PeerInfo
    public void destroy() {
        nDestroy(getHandle());
    }
}
