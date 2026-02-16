package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsCanvasImplementation.class */
final class WindowsCanvasImplementation implements AWTCanvasImplementation {
    WindowsCanvasImplementation() {
    }

    static {
        Toolkit.getDefaultToolkit();
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.opengl.WindowsCanvasImplementation.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    System.loadLibrary("jawt");
                    return null;
                } catch (UnsatisfiedLinkError e) {
                    LWJGLUtil.log("Failed to load jawt: " + e.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // org.lwjgl.opengl.AWTCanvasImplementation
    public PeerInfo createPeerInfo(Canvas component, PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        return new WindowsAWTGLCanvasPeerInfo(component, pixel_format);
    }

    @Override // org.lwjgl.opengl.AWTCanvasImplementation
    public GraphicsConfiguration findConfiguration(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
        return null;
    }
}
