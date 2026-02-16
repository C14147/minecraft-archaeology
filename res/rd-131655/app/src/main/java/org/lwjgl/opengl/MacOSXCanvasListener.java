package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXCanvasListener.class */
final class MacOSXCanvasListener implements ComponentListener, HierarchyListener {
    private final Canvas canvas;
    private int width;
    private int height;
    private boolean context_update;
    private boolean resized;

    MacOSXCanvasListener(Canvas canvas) {
        this.canvas = canvas;
        canvas.addComponentListener(this);
        canvas.addHierarchyListener(this);
        setUpdate();
    }

    public void disableListeners() {
        java.awt.EventQueue.invokeLater(new Runnable() { // from class: org.lwjgl.opengl.MacOSXCanvasListener.1
            @Override // java.lang.Runnable
            public void run() {
                MacOSXCanvasListener.this.canvas.removeComponentListener(MacOSXCanvasListener.this);
                MacOSXCanvasListener.this.canvas.removeHierarchyListener(MacOSXCanvasListener.this);
            }
        });
    }

    public boolean syncShouldUpdateContext() {
        boolean should_update;
        synchronized (this) {
            should_update = this.context_update;
            this.context_update = false;
        }
        return should_update;
    }

    private synchronized void setUpdate() {
        this.width = this.canvas.getWidth();
        this.height = this.canvas.getHeight();
        this.context_update = true;
    }

    public int syncGetWidth() {
        int i;
        synchronized (this) {
            i = this.width;
        }
        return i;
    }

    public int syncGetHeight() {
        int i;
        synchronized (this) {
            i = this.height;
        }
        return i;
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        setUpdate();
        this.resized = true;
    }

    public void componentMoved(ComponentEvent e) {
        setUpdate();
    }

    public void hierarchyChanged(HierarchyEvent e) {
        setUpdate();
    }

    public boolean wasResized() {
        if (this.resized) {
            this.resized = false;
            return true;
        }
        return false;
    }
}
