package org.lwjgl.opengl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxEvent.class */
final class LinuxEvent {
    public static final int FocusIn = 9;
    public static final int FocusOut = 10;
    public static final int KeyPress = 2;
    public static final int KeyRelease = 3;
    public static final int ButtonPress = 4;
    public static final int ButtonRelease = 5;
    public static final int MotionNotify = 6;
    public static final int EnterNotify = 7;
    public static final int LeaveNotify = 8;
    public static final int UnmapNotify = 18;
    public static final int MapNotify = 19;
    public static final int Expose = 12;
    public static final int ConfigureNotify = 22;
    public static final int ClientMessage = 33;
    private final ByteBuffer event_buffer = createEventBuffer();

    private static native ByteBuffer createEventBuffer();

    public static native int getPending(long j);

    private static native void nSendEvent(ByteBuffer byteBuffer, long j, long j2, boolean z, long j3);

    private static native boolean nFilterEvent(ByteBuffer byteBuffer, long j);

    private static native void nNextEvent(long j, ByteBuffer byteBuffer);

    private static native int nGetType(ByteBuffer byteBuffer);

    private static native long nGetWindow(ByteBuffer byteBuffer);

    private static native void nSetWindow(ByteBuffer byteBuffer, long j);

    private static native int nGetFocusMode(ByteBuffer byteBuffer);

    private static native int nGetFocusDetail(ByteBuffer byteBuffer);

    private static native long nGetClientMessageType(ByteBuffer byteBuffer);

    private static native int nGetClientData(ByteBuffer byteBuffer, int i);

    private static native int nGetClientFormat(ByteBuffer byteBuffer);

    private static native long nGetButtonTime(ByteBuffer byteBuffer);

    private static native int nGetButtonState(ByteBuffer byteBuffer);

    private static native int nGetButtonType(ByteBuffer byteBuffer);

    private static native int nGetButtonButton(ByteBuffer byteBuffer);

    private static native long nGetButtonRoot(ByteBuffer byteBuffer);

    private static native int nGetButtonXRoot(ByteBuffer byteBuffer);

    private static native int nGetButtonYRoot(ByteBuffer byteBuffer);

    private static native int nGetButtonX(ByteBuffer byteBuffer);

    private static native int nGetButtonY(ByteBuffer byteBuffer);

    private static native long nGetKeyAddress(ByteBuffer byteBuffer);

    private static native int nGetKeyTime(ByteBuffer byteBuffer);

    private static native int nGetKeyType(ByteBuffer byteBuffer);

    private static native int nGetKeyKeyCode(ByteBuffer byteBuffer);

    private static native int nGetKeyState(ByteBuffer byteBuffer);

    LinuxEvent() {
    }

    public void copyFrom(LinuxEvent event) {
        int pos = this.event_buffer.position();
        int event_pos = event.event_buffer.position();
        this.event_buffer.put(event.event_buffer);
        this.event_buffer.position(pos);
        event.event_buffer.position(event_pos);
    }

    public void sendEvent(long display, long window, boolean propagate, long event_mask) {
        nSendEvent(this.event_buffer, display, window, propagate, event_mask);
    }

    public boolean filterEvent(long window) {
        return nFilterEvent(this.event_buffer, window);
    }

    public void nextEvent(long display) {
        nNextEvent(display, this.event_buffer);
    }

    public int getType() {
        return nGetType(this.event_buffer);
    }

    public long getWindow() {
        return nGetWindow(this.event_buffer);
    }

    public void setWindow(long window) {
        nSetWindow(this.event_buffer, window);
    }

    public int getFocusMode() {
        return nGetFocusMode(this.event_buffer);
    }

    public int getFocusDetail() {
        return nGetFocusDetail(this.event_buffer);
    }

    public long getClientMessageType() {
        return nGetClientMessageType(this.event_buffer);
    }

    public int getClientData(int index) {
        return nGetClientData(this.event_buffer, index);
    }

    public int getClientFormat() {
        return nGetClientFormat(this.event_buffer);
    }

    public long getButtonTime() {
        return nGetButtonTime(this.event_buffer);
    }

    public int getButtonState() {
        return nGetButtonState(this.event_buffer);
    }

    public int getButtonType() {
        return nGetButtonType(this.event_buffer);
    }

    public int getButtonButton() {
        return nGetButtonButton(this.event_buffer);
    }

    public long getButtonRoot() {
        return nGetButtonRoot(this.event_buffer);
    }

    public int getButtonXRoot() {
        return nGetButtonXRoot(this.event_buffer);
    }

    public int getButtonYRoot() {
        return nGetButtonYRoot(this.event_buffer);
    }

    public int getButtonX() {
        return nGetButtonX(this.event_buffer);
    }

    public int getButtonY() {
        return nGetButtonY(this.event_buffer);
    }

    public long getKeyAddress() {
        return nGetKeyAddress(this.event_buffer);
    }

    public long getKeyTime() {
        return nGetKeyTime(this.event_buffer);
    }

    public int getKeyType() {
        return nGetKeyType(this.event_buffer);
    }

    public int getKeyKeyCode() {
        return nGetKeyKeyCode(this.event_buffer);
    }

    public int getKeyState() {
        return nGetKeyState(this.event_buffer);
    }
}
