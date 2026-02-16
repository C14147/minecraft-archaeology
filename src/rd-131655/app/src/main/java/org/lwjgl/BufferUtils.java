package org.lwjgl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/BufferUtils.class */
public final class BufferUtils {
    private static native void zeroBuffer0(Buffer buffer, long j, long j2);

    static native long getBufferAddress(Buffer buffer);

    public static ByteBuffer createByteBuffer(int size) {
        return ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
    }

    public static ShortBuffer createShortBuffer(int size) {
        return createByteBuffer(size << 1).asShortBuffer();
    }

    public static CharBuffer createCharBuffer(int size) {
        return createByteBuffer(size << 1).asCharBuffer();
    }

    public static IntBuffer createIntBuffer(int size) {
        return createByteBuffer(size << 2).asIntBuffer();
    }

    public static LongBuffer createLongBuffer(int size) {
        return createByteBuffer(size << 3).asLongBuffer();
    }

    public static FloatBuffer createFloatBuffer(int size) {
        return createByteBuffer(size << 2).asFloatBuffer();
    }

    public static DoubleBuffer createDoubleBuffer(int size) {
        return createByteBuffer(size << 3).asDoubleBuffer();
    }

    public static PointerBuffer createPointerBuffer(int size) {
        return PointerBuffer.allocateDirect(size);
    }

    public static int getElementSizeExponent(Buffer buf) {
        if (buf instanceof ByteBuffer) {
            return 0;
        }
        if ((buf instanceof ShortBuffer) || (buf instanceof CharBuffer)) {
            return 1;
        }
        if ((buf instanceof FloatBuffer) || (buf instanceof IntBuffer)) {
            return 2;
        }
        if ((buf instanceof LongBuffer) || (buf instanceof DoubleBuffer)) {
            return 3;
        }
        throw new IllegalStateException("Unsupported buffer type: " + buf);
    }

    public static int getOffset(Buffer buffer) {
        return buffer.position() << getElementSizeExponent(buffer);
    }

    public static void zeroBuffer(ByteBuffer b) {
        zeroBuffer0(b, b.position(), b.remaining());
    }

    public static void zeroBuffer(ShortBuffer b) {
        zeroBuffer0(b, ((long) b.position()) * 2, ((long) b.remaining()) * 2);
    }

    public static void zeroBuffer(CharBuffer b) {
        zeroBuffer0(b, ((long) b.position()) * 2, ((long) b.remaining()) * 2);
    }

    public static void zeroBuffer(IntBuffer b) {
        zeroBuffer0(b, ((long) b.position()) * 4, ((long) b.remaining()) * 4);
    }

    public static void zeroBuffer(FloatBuffer b) {
        zeroBuffer0(b, ((long) b.position()) * 4, ((long) b.remaining()) * 4);
    }

    public static void zeroBuffer(LongBuffer b) {
        zeroBuffer0(b, ((long) b.position()) * 8, ((long) b.remaining()) * 8);
    }

    public static void zeroBuffer(DoubleBuffer b) {
        zeroBuffer0(b, ((long) b.position()) * 8, ((long) b.remaining()) * 8);
    }
}
