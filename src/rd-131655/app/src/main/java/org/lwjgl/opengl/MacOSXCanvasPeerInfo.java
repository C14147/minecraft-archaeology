package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.nio.ByteBuffer;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXCanvasPeerInfo.class */
abstract class MacOSXCanvasPeerInfo extends MacOSXPeerInfo {
    private final AWTSurfaceLock awt_surface;
    public ByteBuffer window_handle;

    private static native ByteBuffer nInitHandle(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, boolean z, boolean z2, int i, int i2) throws LWJGLException;

    private static native void nSetLayerPosition(ByteBuffer byteBuffer, int i, int i2);

    private static native void nSetLayerBounds(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    protected MacOSXCanvasPeerInfo(PixelFormat pixel_format, ContextAttribs attribs, boolean support_pbuffer) throws LWJGLException {
        super(pixel_format, attribs, true, true, support_pbuffer, true);
        this.awt_surface = new AWTSurfaceLock();
    }

    protected void initHandle(Canvas component) throws LWJGLException {
        boolean forceCALayer = true;
        boolean autoResizable = true;
        String javaVersion = System.getProperty("java.version");
        if (javaVersion.startsWith("1.5") || javaVersion.startsWith("1.6")) {
            forceCALayer = false;
        } else if (javaVersion.startsWith("1.7")) {
            autoResizable = false;
        }
        Insets insets = getInsets(component);
        int top = insets != null ? insets.top : 0;
        int left = insets != null ? insets.left : 0;
        this.window_handle = nInitHandle(this.awt_surface.lockAndGetHandle(component), getHandle(), this.window_handle, forceCALayer, autoResizable, component.getX() - left, component.getY() - top);
        if (javaVersion.startsWith("1.7")) {
            addComponentListener(component);
            reSetLayerBounds(component, getHandle());
        }
    }

    private void addComponentListener(final Canvas component) {
        ComponentListener[] components = component.getComponentListeners();
        for (ComponentListener c : components) {
            if (c.toString() == "CanvasPeerInfoListener") {
                return;
            }
        }
        ComponentListener comp = new ComponentListener() { // from class: org.lwjgl.opengl.MacOSXCanvasPeerInfo.1
            public void componentHidden(ComponentEvent e) {
            }

            public void componentMoved(ComponentEvent e) {
                MacOSXCanvasPeerInfo.reSetLayerBounds(component, MacOSXCanvasPeerInfo.this.getHandle());
            }

            public void componentResized(ComponentEvent e) {
                MacOSXCanvasPeerInfo.reSetLayerBounds(component, MacOSXCanvasPeerInfo.this.getHandle());
            }

            public void componentShown(ComponentEvent e) {
            }

            public String toString() {
                return "CanvasPeerInfoListener";
            }
        };
        component.addComponentListener(comp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reSetLayerBounds(Canvas component, ByteBuffer peer_info_handle) {
        Component peer = SwingUtilities.getRoot(component);
        Point rtLoc = SwingUtilities.convertPoint(component.getParent(), component.getLocation(), peer);
        int x = (int) rtLoc.getX();
        int y = (int) rtLoc.getY();
        Insets insets = getInsets(component);
        nSetLayerBounds(peer_info_handle, x - (insets != null ? insets.left : 0), (peer.getHeight() - (y - (insets != null ? insets.top : 0))) - component.getHeight(), component.getWidth(), component.getHeight());
    }

    @Override // org.lwjgl.opengl.PeerInfo
    protected void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }

    private static Insets getInsets(Canvas component) {
        JRootPane rootPane = SwingUtilities.getRootPane(component);
        if (rootPane != null) {
            return rootPane.getInsets();
        }
        return new Insets(0, 0, 0, 0);
    }
}
