package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Graphics;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXGLCanvas.class */
final class MacOSXGLCanvas extends Canvas {
    private static final long serialVersionUID = 6916664741667434870L;
    private boolean canvas_painted;
    private boolean dirty;

    MacOSXGLCanvas() {
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        synchronized (this) {
            this.dirty = true;
            this.canvas_painted = true;
        }
    }

    public boolean syncCanvasPainted() {
        boolean result;
        synchronized (this) {
            result = this.canvas_painted;
            this.canvas_painted = false;
        }
        return result;
    }

    public boolean syncIsDirty() {
        boolean result;
        synchronized (this) {
            result = this.dirty;
            this.dirty = false;
        }
        return result;
    }
}
