package org.lwjgl.opengl;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXMouseEventQueue.class */
final class MacOSXMouseEventQueue extends MouseEventQueue {
    private final IntBuffer delta_buffer;
    private boolean skip_event;
    private static boolean is_grabbed;

    private static native void getMouseDeltas(IntBuffer intBuffer);

    private static native void nWarpCursor(int i, int i2);

    static native void nGrabMouse(boolean z);

    MacOSXMouseEventQueue(Component component) {
        super(component);
        this.delta_buffer = BufferUtils.createIntBuffer(2);
    }

    @Override // org.lwjgl.opengl.MouseEventQueue
    public void setGrabbed(boolean grab) {
        if (is_grabbed != grab) {
            super.setGrabbed(grab);
            warpCursor();
            grabMouse(grab);
        }
    }

    private static synchronized void grabMouse(boolean grab) {
        is_grabbed = grab;
        if (!grab) {
            nGrabMouse(grab);
        }
    }

    @Override // org.lwjgl.opengl.MouseEventQueue
    protected void resetCursorToCenter() {
        super.resetCursorToCenter();
        getMouseDeltas(this.delta_buffer);
    }

    @Override // org.lwjgl.opengl.MouseEventQueue
    protected void updateDeltas(long nanos) {
        super.updateDeltas(nanos);
        synchronized (this) {
            getMouseDeltas(this.delta_buffer);
            int dx = this.delta_buffer.get(0);
            int dy = -this.delta_buffer.get(1);
            if (this.skip_event) {
                this.skip_event = false;
                nGrabMouse(isGrabbed());
            } else {
                if (dx != 0 || dy != 0) {
                    putMouseEventWithCoords((byte) -1, (byte) 0, dx, dy, 0, nanos);
                    addDelta(dx, dy);
                }
            }
        }
    }

    void warpCursor() {
        synchronized (this) {
            this.skip_event = isGrabbed();
        }
        if (isGrabbed()) {
            Rectangle bounds = getComponent().getBounds();
            Point location_on_screen = getComponent().getLocationOnScreen();
            int x = location_on_screen.x + (bounds.width / 2);
            int y = location_on_screen.y + (bounds.height / 2);
            nWarpCursor(x, y);
        }
    }
}
