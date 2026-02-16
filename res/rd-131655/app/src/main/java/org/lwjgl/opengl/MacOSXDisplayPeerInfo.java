package org.lwjgl.opengl;

import java.awt.Canvas;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXDisplayPeerInfo.class */
final class MacOSXDisplayPeerInfo extends MacOSXCanvasPeerInfo {
    private boolean locked;

    MacOSXDisplayPeerInfo(PixelFormat pixel_format, ContextAttribs attribs, boolean support_pbuffer) throws LWJGLException {
        super(pixel_format, attribs, support_pbuffer);
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
        if (this.locked) {
            throw new RuntimeException("Already locked");
        }
        Canvas canvas = ((MacOSXDisplay) Display.getImplementation()).getCanvas();
        if (canvas != null) {
            initHandle(canvas);
            this.locked = true;
        }
    }

    @Override // org.lwjgl.opengl.MacOSXCanvasPeerInfo, org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
        if (this.locked) {
            super.doUnlock();
            this.locked = false;
        }
    }
}
