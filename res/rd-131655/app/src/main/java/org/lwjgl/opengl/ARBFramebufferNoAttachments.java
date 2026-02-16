package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBFramebufferNoAttachments.class */
public final class ARBFramebufferNoAttachments {
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;

    static native void nglNamedFramebufferParameteriEXT(int i, int i2, int i3, long j);

    static native void nglGetNamedFramebufferParameterivEXT(int i, int i2, long j, long j2);

    private ARBFramebufferNoAttachments() {
    }

    public static void glFramebufferParameteri(int target, int pname, int param) {
        GL43.glFramebufferParameteri(target, pname, param);
    }

    public static void glGetFramebufferParameter(int target, int pname, IntBuffer params) {
        GL43.glGetFramebufferParameter(target, pname, params);
    }

    public static int glGetFramebufferParameteri(int target, int pname) {
        return GL43.glGetFramebufferParameteri(target, pname);
    }

    public static void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glNamedFramebufferParameteriEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglNamedFramebufferParameteriEXT(framebuffer, pname, param, function_pointer);
    }

    public static void glGetNamedFramebufferParameterEXT(int framebuffer, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedFramebufferParameterivEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetNamedFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static int glGetNamedFramebufferParameterEXT(int framebuffer, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedFramebufferParameterivEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetNamedFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }
}
