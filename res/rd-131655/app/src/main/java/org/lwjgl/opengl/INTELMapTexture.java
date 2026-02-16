package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/INTELMapTexture.class */
public final class INTELMapTexture {
    public static final int GL_TEXTURE_MEMORY_LAYOUT_INTEL = 33791;
    public static final int GL_LAYOUT_DEFAULT_INTEL = 0;
    public static final int GL_LAYOUT_LINEAR_INTEL = 1;
    public static final int GL_LAYOUT_LINEAR_CPU_CACHED_INTEL = 2;

    static native ByteBuffer nglMapTexture2DINTEL(int i, int i2, long j, int i3, long j2, long j3, ByteBuffer byteBuffer, long j4);

    static native void nglUnmapTexture2DINTEL(int i, int i2, long j);

    static native void nglSyncTextureINTEL(int i, long j);

    private INTELMapTexture() {
    }

    public static ByteBuffer glMapTexture2DINTEL(int texture, int level, long length, int access, IntBuffer stride, IntBuffer layout, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapTexture2DINTEL;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(stride, 1);
        BufferChecks.checkBuffer(layout, 1);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = nglMapTexture2DINTEL(texture, level, length, access, MemoryUtil.getAddress(stride), MemoryUtil.getAddress(layout), old_buffer, function_pointer);
        if (LWJGLUtil.CHECKS && __result == null) {
            return null;
        }
        return __result.order(ByteOrder.nativeOrder());
    }

    public static void glUnmapTexture2DINTEL(int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glUnmapTexture2DINTEL;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglUnmapTexture2DINTEL(texture, level, function_pointer);
    }

    public static void glSyncTextureINTEL(int texture) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glSyncTextureINTEL;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglSyncTextureINTEL(texture, function_pointer);
    }
}
