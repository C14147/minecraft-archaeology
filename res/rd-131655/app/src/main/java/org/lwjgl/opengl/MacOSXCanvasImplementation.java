package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXCanvasImplementation.class */
final class MacOSXCanvasImplementation implements AWTCanvasImplementation {
    MacOSXCanvasImplementation() {
    }

    @Override // org.lwjgl.opengl.AWTCanvasImplementation
    public PeerInfo createPeerInfo(Canvas component, PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        try {
            return new MacOSXAWTGLCanvasPeerInfo(component, pixel_format, attribs, true);
        } catch (LWJGLException e) {
            return new MacOSXAWTGLCanvasPeerInfo(component, pixel_format, attribs, false);
        }
    }

    @Override // org.lwjgl.opengl.AWTCanvasImplementation
    public GraphicsConfiguration findConfiguration(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
        return null;
    }
}
