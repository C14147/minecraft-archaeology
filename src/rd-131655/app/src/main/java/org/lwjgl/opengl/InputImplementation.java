package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/InputImplementation.class */
public interface InputImplementation {
    boolean hasWheel();

    int getButtonCount();

    void createMouse() throws LWJGLException;

    void destroyMouse();

    void pollMouse(IntBuffer intBuffer, ByteBuffer byteBuffer);

    void readMouse(ByteBuffer byteBuffer);

    void grabMouse(boolean z);

    int getNativeCursorCapabilities();

    void setCursorPosition(int i, int i2);

    void setNativeCursor(Object obj) throws LWJGLException;

    int getMinCursorSize();

    int getMaxCursorSize();

    void createKeyboard() throws LWJGLException;

    void destroyKeyboard();

    void pollKeyboard(ByteBuffer byteBuffer);

    void readKeyboard(ByteBuffer byteBuffer);

    Object createCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException;

    void destroyCursor(Object obj);

    int getWidth();

    int getHeight();

    boolean isInsideWindow();
}
