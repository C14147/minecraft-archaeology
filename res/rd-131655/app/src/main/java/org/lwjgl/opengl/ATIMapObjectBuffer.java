package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ATIMapObjectBuffer.class */
public final class ATIMapObjectBuffer {
    static native ByteBuffer nglMapObjectBufferATI(int i, long j, ByteBuffer byteBuffer, long j2);

    static native void nglUnmapObjectBufferATI(int i, long j);

    private ATIMapObjectBuffer() {
    }

    public static ByteBuffer glMapObjectBufferATI(int buffer, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapObjectBufferATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = nglMapObjectBufferATI(buffer, ATIVertexArrayObject.glGetObjectBufferiATI(buffer, 34660), old_buffer, function_pointer);
        if (LWJGLUtil.CHECKS && __result == null) {
            return null;
        }
        return __result.order(ByteOrder.nativeOrder());
    }

    public static ByteBuffer glMapObjectBufferATI(int buffer, long length, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapObjectBufferATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = nglMapObjectBufferATI(buffer, length, old_buffer, function_pointer);
        if (LWJGLUtil.CHECKS && __result == null) {
            return null;
        }
        return __result.order(ByteOrder.nativeOrder());
    }

    public static void glUnmapObjectBufferATI(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glUnmapObjectBufferATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglUnmapObjectBufferATI(buffer, function_pointer);
    }
}
