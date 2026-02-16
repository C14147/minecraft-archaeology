package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBBufferObject.class */
public class ARBBufferObject {
    public static final int GL_STREAM_DRAW_ARB = 35040;
    public static final int GL_STREAM_READ_ARB = 35041;
    public static final int GL_STREAM_COPY_ARB = 35042;
    public static final int GL_STATIC_DRAW_ARB = 35044;
    public static final int GL_STATIC_READ_ARB = 35045;
    public static final int GL_STATIC_COPY_ARB = 35046;
    public static final int GL_DYNAMIC_DRAW_ARB = 35048;
    public static final int GL_DYNAMIC_READ_ARB = 35049;
    public static final int GL_DYNAMIC_COPY_ARB = 35050;
    public static final int GL_READ_ONLY_ARB = 35000;
    public static final int GL_WRITE_ONLY_ARB = 35001;
    public static final int GL_READ_WRITE_ARB = 35002;
    public static final int GL_BUFFER_SIZE_ARB = 34660;
    public static final int GL_BUFFER_USAGE_ARB = 34661;
    public static final int GL_BUFFER_ACCESS_ARB = 35003;
    public static final int GL_BUFFER_MAPPED_ARB = 35004;
    public static final int GL_BUFFER_MAP_POINTER_ARB = 35005;

    static native void nglBindBufferARB(int i, int i2, long j);

    static native void nglDeleteBuffersARB(int i, long j, long j2);

    static native void nglGenBuffersARB(int i, long j, long j2);

    static native boolean nglIsBufferARB(int i, long j);

    static native void nglBufferDataARB(int i, long j, long j2, int i2, long j3);

    static native void nglBufferSubDataARB(int i, long j, long j2, long j3, long j4);

    static native void nglGetBufferSubDataARB(int i, long j, long j2, long j3, long j4);

    static native ByteBuffer nglMapBufferARB(int i, int i2, long j, ByteBuffer byteBuffer, long j2);

    static native boolean nglUnmapBufferARB(int i, long j);

    static native void nglGetBufferParameterivARB(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetBufferPointervARB(int i, int i2, long j, long j2);

    public static void glBindBufferARB(int target, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBindBufferARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        StateTracker.bindBuffer(caps, target, buffer);
        nglBindBufferARB(target, buffer, function_pointer);
    }

    public static void glDeleteBuffersARB(IntBuffer buffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteBuffersARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffers);
        nglDeleteBuffersARB(buffers.remaining(), MemoryUtil.getAddress(buffers), function_pointer);
    }

    public static void glDeleteBuffersARB(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteBuffersARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDeleteBuffersARB(1, APIUtil.getInt(caps, buffer), function_pointer);
    }

    public static void glGenBuffersARB(IntBuffer buffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenBuffersARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffers);
        nglGenBuffersARB(buffers.remaining(), MemoryUtil.getAddress(buffers), function_pointer);
    }

    public static int glGenBuffersARB() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenBuffersARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer buffers = APIUtil.getBufferInt(caps);
        nglGenBuffersARB(1, MemoryUtil.getAddress(buffers), function_pointer);
        return buffers.get(0);
    }

    public static boolean glIsBufferARB(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsBufferARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsBufferARB(buffer, function_pointer);
        return __result;
    }

    public static void glBufferDataARB(int target, long data_size, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBufferDataARB(target, data_size, 0L, usage, function_pointer);
    }

    public static void glBufferDataARB(int target, ByteBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferDataARB(target, data.remaining(), MemoryUtil.getAddress(data), usage, function_pointer);
    }

    public static void glBufferDataARB(int target, DoubleBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferDataARB(target, data.remaining() << 3, MemoryUtil.getAddress(data), usage, function_pointer);
    }

    public static void glBufferDataARB(int target, FloatBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferDataARB(target, data.remaining() << 2, MemoryUtil.getAddress(data), usage, function_pointer);
    }

    public static void glBufferDataARB(int target, IntBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferDataARB(target, data.remaining() << 2, MemoryUtil.getAddress(data), usage, function_pointer);
    }

    public static void glBufferDataARB(int target, ShortBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferDataARB(target, data.remaining() << 1, MemoryUtil.getAddress(data), usage, function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferSubDataARB(target, offset, data.remaining(), MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferSubDataARB(target, offset, data.remaining() << 3, MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferSubDataARB(target, offset, data.remaining() << 2, MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferSubDataARB(target, offset, data.remaining() << 2, MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglBufferSubDataARB(target, offset, data.remaining() << 1, MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglGetBufferSubDataARB(target, offset, data.remaining(), MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglGetBufferSubDataARB(target, offset, data.remaining() << 3, MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglGetBufferSubDataARB(target, offset, data.remaining() << 2, MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglGetBufferSubDataARB(target, offset, data.remaining() << 2, MemoryUtil.getAddress(data), function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        nglGetBufferSubDataARB(target, offset, data.remaining() << 1, MemoryUtil.getAddress(data), function_pointer);
    }

    public static ByteBuffer glMapBufferARB(int target, int access, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapBufferARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = nglMapBufferARB(target, access, glGetBufferParameteriARB(target, 34660), old_buffer, function_pointer);
        if (LWJGLUtil.CHECKS && __result == null) {
            return null;
        }
        return __result.order(ByteOrder.nativeOrder());
    }

    public static ByteBuffer glMapBufferARB(int target, int access, long length, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapBufferARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = nglMapBufferARB(target, access, length, old_buffer, function_pointer);
        if (LWJGLUtil.CHECKS && __result == null) {
            return null;
        }
        return __result.order(ByteOrder.nativeOrder());
    }

    public static boolean glUnmapBufferARB(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glUnmapBufferARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglUnmapBufferARB(target, function_pointer);
        return __result;
    }

    public static void glGetBufferParameterARB(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferParameterivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        nglGetBufferParameterivARB(target, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    @Deprecated
    public static int glGetBufferParameterARB(int target, int pname) {
        return glGetBufferParameteriARB(target, pname);
    }

    public static int glGetBufferParameteriARB(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferParameterivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetBufferParameterivARB(target, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }

    public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBufferPointervARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = nglGetBufferPointervARB(target, pname, glGetBufferParameteriARB(target, 34660), function_pointer);
        if (LWJGLUtil.CHECKS && __result == null) {
            return null;
        }
        return __result.order(ByteOrder.nativeOrder());
    }
}
