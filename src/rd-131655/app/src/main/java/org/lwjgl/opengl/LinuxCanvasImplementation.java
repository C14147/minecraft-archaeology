package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxCanvasImplementation.class */
final class LinuxCanvasImplementation implements AWTCanvasImplementation {
    private static native int nFindVisualIDFromFormat(long j, int i, PixelFormat pixelFormat) throws LWJGLException;

    LinuxCanvasImplementation() {
    }

    static int getScreenFromDevice(final GraphicsDevice device) throws LWJGLException {
        try {
            Method getScreen_method = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: org.lwjgl.opengl.LinuxCanvasImplementation.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return device.getClass().getMethod("getScreen", new Class[0]);
                }
            });
            Integer screen = (Integer) getScreen_method.invoke(device, new Object[0]);
            return screen.intValue();
        } catch (Exception e) {
            throw new LWJGLException(e);
        }
    }

    private static int getVisualIDFromConfiguration(final GraphicsConfiguration configuration) throws LWJGLException {
        try {
            Method getVisual_method = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: org.lwjgl.opengl.LinuxCanvasImplementation.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return configuration.getClass().getMethod("getVisual", new Class[0]);
                }
            });
            Integer visual = (Integer) getVisual_method.invoke(configuration, new Object[0]);
            return visual.intValue();
        } catch (Exception e) {
            throw new LWJGLException(e);
        }
    }

    @Override // org.lwjgl.opengl.AWTCanvasImplementation
    public PeerInfo createPeerInfo(Canvas component, PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        return new LinuxAWTGLCanvasPeerInfo(component);
    }

    @Override // org.lwjgl.opengl.AWTCanvasImplementation
    public GraphicsConfiguration findConfiguration(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
        try {
            int screen = getScreenFromDevice(device);
            int visual_id_matching_format = findVisualIDFromFormat(screen, pixel_format);
            GraphicsConfiguration[] configurations = device.getConfigurations();
            for (GraphicsConfiguration configuration : configurations) {
                int visual_id = getVisualIDFromConfiguration(configuration);
                if (visual_id == visual_id_matching_format) {
                    return configuration;
                }
            }
            return null;
        } catch (LWJGLException e) {
            LWJGLUtil.log("Got exception while trying to determine configuration: " + e);
            return null;
        }
    }

    private static int findVisualIDFromFormat(int screen, PixelFormat pixel_format) throws LWJGLException {
        try {
            LinuxDisplay.lockAWT();
            try {
                GLContext.loadOpenGLLibrary();
                try {
                    LinuxDisplay.incDisplay();
                    int iNFindVisualIDFromFormat = nFindVisualIDFromFormat(LinuxDisplay.getDisplay(), screen, pixel_format);
                    LinuxDisplay.decDisplay();
                    GLContext.unloadOpenGLLibrary();
                    LinuxDisplay.unlockAWT();
                    return iNFindVisualIDFromFormat;
                } catch (Throwable th) {
                    LinuxDisplay.decDisplay();
                    throw th;
                }
            } catch (Throwable th2) {
                GLContext.unloadOpenGLLibrary();
                throw th2;
            }
        } catch (Throwable th3) {
            LinuxDisplay.unlockAWT();
            throw th3;
        }
    }
}
