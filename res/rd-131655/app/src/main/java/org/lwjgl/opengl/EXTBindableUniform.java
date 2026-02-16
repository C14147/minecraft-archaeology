package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTBindableUniform.class */
public final class EXTBindableUniform {
    public static final int GL_MAX_VERTEX_BINDABLE_UNIFORMS_EXT = 36322;
    public static final int GL_MAX_FRAGMENT_BINDABLE_UNIFORMS_EXT = 36323;
    public static final int GL_MAX_GEOMETRY_BINDABLE_UNIFORMS_EXT = 36324;
    public static final int GL_MAX_BINDABLE_UNIFORM_SIZE_EXT = 36333;
    public static final int GL_UNIFORM_BUFFER_BINDING_EXT = 36335;
    public static final int GL_UNIFORM_BUFFER_EXT = 36334;

    static native void nglUniformBufferEXT(int i, int i2, int i3, long j);

    static native int nglGetUniformBufferSizeEXT(int i, int i2, long j);

    static native long nglGetUniformOffsetEXT(int i, int i2, long j);

    private EXTBindableUniform() {
    }

    public static void glUniformBufferEXT(int program, int location, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glUniformBufferEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglUniformBufferEXT(program, location, buffer, function_pointer);
    }

    public static int glGetUniformBufferSizeEXT(int program, int location) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetUniformBufferSizeEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = nglGetUniformBufferSizeEXT(program, location, function_pointer);
        return __result;
    }

    public static long glGetUniformOffsetEXT(int program, int location) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetUniformOffsetEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        long __result = nglGetUniformOffsetEXT(program, location, function_pointer);
        return __result;
    }
}
