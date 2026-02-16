package org.lwjgl.opengl;

import java.awt.Canvas;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXAWTGLCanvasPeerInfo.class */
final class MacOSXAWTGLCanvasPeerInfo extends MacOSXCanvasPeerInfo {
    private final Canvas component;

    MacOSXAWTGLCanvasPeerInfo(Canvas component, PixelFormat pixel_format, ContextAttribs attribs, boolean support_pbuffer) throws LWJGLException {
        super(pixel_format, attribs, support_pbuffer);
        this.component = component;
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doLockAndInitHandle() throws LWJGLException {
        initHandle(this.component);
    }
}
