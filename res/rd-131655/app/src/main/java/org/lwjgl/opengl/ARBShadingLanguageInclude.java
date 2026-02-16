package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBShadingLanguageInclude.class */
public final class ARBShadingLanguageInclude {
    public static final int GL_SHADER_INCLUDE_ARB = 36270;
    public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
    public static final int GL_NAMED_STRING_TYPE_ARB = 36330;

    static native void nglNamedStringARB(int i, int i2, long j, int i3, long j2, long j3);

    static native void nglDeleteNamedStringARB(int i, long j, long j2);

    static native void nglCompileShaderIncludeARB(int i, int i2, long j, long j2, long j3);

    static native void nglCompileShaderIncludeARB2(int i, int i2, long j, long j2, long j3);

    static native boolean nglIsNamedStringARB(int i, long j, long j2);

    static native void nglGetNamedStringARB(int i, long j, int i2, long j2, long j3, long j4);

    static native void nglGetNamedStringivARB(int i, long j, int i2, long j2, long j3);

    private ARBShadingLanguageInclude() {
    }

    public static void glNamedStringARB(int type, ByteBuffer name, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkDirect(string);
        nglNamedStringARB(type, name.remaining(), MemoryUtil.getAddress(name), string.remaining(), MemoryUtil.getAddress(string), function_pointer);
    }

    public static void glNamedStringARB(int type, CharSequence name, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglNamedStringARB(type, name.length(), APIUtil.getBuffer(caps, name), string.length(), APIUtil.getBuffer(caps, string, name.length()), function_pointer);
    }

    public static void glDeleteNamedStringARB(ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        nglDeleteNamedStringARB(name.remaining(), MemoryUtil.getAddress(name), function_pointer);
    }

    public static void glDeleteNamedStringARB(CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDeleteNamedStringARB(name.length(), APIUtil.getBuffer(caps, name), function_pointer);
    }

    public static void glCompileShaderIncludeARB(int shader, int count, ByteBuffer path) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glCompileShaderIncludeARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(path);
        BufferChecks.checkNullTerminated(path, count);
        nglCompileShaderIncludeARB(shader, count, MemoryUtil.getAddress(path), 0L, function_pointer);
    }

    public static void glCompileShaderIncludeARB(int shader, CharSequence[] path) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glCompileShaderIncludeARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkArray(path);
        nglCompileShaderIncludeARB2(shader, path.length, APIUtil.getBuffer(caps, path), APIUtil.getLengths(caps, path), function_pointer);
    }

    public static boolean glIsNamedStringARB(ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        boolean __result = nglIsNamedStringARB(name.remaining(), MemoryUtil.getAddress(name), function_pointer);
        return __result;
    }

    public static boolean glIsNamedStringARB(CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsNamedStringARB(name.length(), APIUtil.getBuffer(caps, name), function_pointer);
        return __result;
    }

    public static void glGetNamedStringARB(ByteBuffer name, IntBuffer stringlen, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        if (stringlen != null) {
            BufferChecks.checkBuffer(stringlen, 1);
        }
        BufferChecks.checkDirect(string);
        nglGetNamedStringARB(name.remaining(), MemoryUtil.getAddress(name), string.remaining(), MemoryUtil.getAddressSafe(stringlen), MemoryUtil.getAddress(string), function_pointer);
    }

    public static void glGetNamedStringARB(CharSequence name, IntBuffer stringlen, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (stringlen != null) {
            BufferChecks.checkBuffer(stringlen, 1);
        }
        BufferChecks.checkDirect(string);
        nglGetNamedStringARB(name.length(), APIUtil.getBuffer(caps, name), string.remaining(), MemoryUtil.getAddressSafe(stringlen), MemoryUtil.getAddress(string), function_pointer);
    }

    public static String glGetNamedStringARB(CharSequence name, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer string_length = APIUtil.getLengths(caps);
        ByteBuffer string = APIUtil.getBufferByte(caps, bufSize + name.length());
        nglGetNamedStringARB(name.length(), APIUtil.getBuffer(caps, name), bufSize, MemoryUtil.getAddress0(string_length), MemoryUtil.getAddress(string), function_pointer);
        string.limit(name.length() + string_length.get(0));
        return APIUtil.getString(caps, string);
    }

    public static void glGetNamedStringARB(ByteBuffer name, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkBuffer(params, 1);
        nglGetNamedStringivARB(name.remaining(), MemoryUtil.getAddress(name), pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static void glGetNamedStringiARB(CharSequence name, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetNamedStringivARB(name.length(), APIUtil.getBuffer(caps, name), pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static int glGetNamedStringiARB(CharSequence name, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetNamedStringivARB(name.length(), APIUtil.getBuffer(caps, name), pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }
}
