package org.lwjgl.opencl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CL12GL.class */
public final class CL12GL {
    public static final int CL_GL_OBJECT_TEXTURE2D_ARRAY = 8206;
    public static final int CL_GL_OBJECT_TEXTURE1D = 8207;
    public static final int CL_GL_OBJECT_TEXTURE1D_ARRAY = 8208;
    public static final int CL_GL_OBJECT_TEXTURE_BUFFER = 8209;

    static native long nclCreateFromGLTexture(long j, long j2, int i, int i2, int i3, long j3, long j4);

    private CL12GL() {
    }

    public static CLMem clCreateFromGLTexture(CLContext context, long flags, int target, int miplevel, int texture, IntBuffer errcode_ret) {
        long function_pointer = CLCapabilities.clCreateFromGLTexture;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (errcode_ret != null) {
            BufferChecks.checkBuffer(errcode_ret, 1);
        }
        CLMem __result = new CLMem(nclCreateFromGLTexture(context.getPointer(), flags, target, miplevel, texture, MemoryUtil.getAddressSafe(errcode_ret), function_pointer), context);
        return __result;
    }
}
