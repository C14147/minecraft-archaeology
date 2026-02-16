package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsKeyboard.class */
final class WindowsKeyboard {
    private final byte[] key_down_buffer = new byte[256];
    private final byte[] virt_key_down_buffer = new byte[256];
    private final EventQueue event_queue = new EventQueue(18);
    private final ByteBuffer tmp_event = ByteBuffer.allocate(18);
    private boolean has_retained_event;
    private int retained_key_code;
    private byte retained_state;
    private int retained_char;
    private long retained_millis;
    private boolean retained_repeat;

    private static native boolean isWindowsNT();

    private static native int MapVirtualKey(int i, int i2);

    private static native int ToUnicode(int i, int i2, ByteBuffer byteBuffer, CharBuffer charBuffer, int i3, int i4);

    private static native int ToAscii(int i, int i2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i3);

    private static native int GetKeyboardState(ByteBuffer byteBuffer);

    private static native short GetKeyState(int i);

    private static native short GetAsyncKeyState(int i);

    WindowsKeyboard() throws LWJGLException {
    }

    boolean isKeyDown(int lwjgl_keycode) {
        return this.key_down_buffer[lwjgl_keycode] == 1;
    }

    void poll(ByteBuffer keyDownBuffer) {
        if (isKeyDown(42) && !isKeyPressedAsync(160)) {
            handleKey(16, 42, false, (byte) 0, 0L, false);
        }
        if (isKeyDown(54) && !isKeyPressedAsync(161)) {
            handleKey(16, 54, false, (byte) 0, 0L, false);
        }
        int old_position = keyDownBuffer.position();
        keyDownBuffer.put(this.key_down_buffer);
        keyDownBuffer.position(old_position);
    }

    private void putEvent(int keycode, byte state, int ch, long millis, boolean repeat) {
        this.tmp_event.clear();
        this.tmp_event.putInt(keycode).put(state).putInt(ch).putLong(millis * 1000000).put(repeat ? (byte) 1 : (byte) 0);
        this.tmp_event.flip();
        this.event_queue.putEvent(this.tmp_event);
    }

    private static int translateExtended(int virt_key, int scan_code, boolean extended) {
        switch (virt_key) {
            case 16:
                return scan_code == 54 ? 161 : 160;
            case 17:
                return extended ? 163 : 162;
            case 18:
                return extended ? 165 : 164;
            default:
                return virt_key;
        }
    }

    private void flushRetained() {
        if (this.has_retained_event) {
            this.has_retained_event = false;
            putEvent(this.retained_key_code, this.retained_state, this.retained_char, this.retained_millis, this.retained_repeat);
        }
    }

    private static boolean isKeyPressed(int state) {
        return (state & 1) == 1;
    }

    private static boolean isKeyPressedAsync(int virt_key) {
        return (GetAsyncKeyState(virt_key) & Short.MIN_VALUE) != 0;
    }

    void releaseAll(long millis) {
        for (int i = 0; i < this.virt_key_down_buffer.length; i++) {
            if (isKeyPressed(this.virt_key_down_buffer[i])) {
                handleKey(i, 0, false, (byte) 0, millis, false);
            }
        }
    }

    void handleKey(int virt_key, int scan_code, boolean extended, byte event_state, long millis, boolean repeat) {
        int virt_key2 = translateExtended(virt_key, scan_code, extended);
        if (!repeat && isKeyPressed(event_state) == isKeyPressed(this.virt_key_down_buffer[virt_key2])) {
            return;
        }
        flushRetained();
        this.has_retained_event = true;
        int keycode = WindowsKeycodes.mapVirtualKeyToLWJGLCode(virt_key2);
        if (keycode < this.key_down_buffer.length) {
            this.key_down_buffer[keycode] = event_state;
            repeat &= isKeyPressed(this.virt_key_down_buffer[virt_key2]);
            this.virt_key_down_buffer[virt_key2] = event_state;
        }
        this.retained_key_code = keycode;
        this.retained_state = event_state;
        this.retained_millis = millis;
        this.retained_char = 0;
        this.retained_repeat = repeat;
    }

    void handleChar(int event_char, long millis, boolean repeat) {
        if (this.has_retained_event && this.retained_char != 0) {
            flushRetained();
        }
        if (!this.has_retained_event) {
            putEvent(0, (byte) 0, event_char, millis, repeat);
        } else {
            this.retained_char = event_char;
        }
    }

    void read(ByteBuffer buffer) {
        flushRetained();
        this.event_queue.copyEvents(buffer);
    }
}
