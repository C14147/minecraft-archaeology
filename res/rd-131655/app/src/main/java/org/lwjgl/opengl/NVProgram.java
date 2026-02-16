package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVProgram.class */
public class NVProgram {
    public static final int GL_PROGRAM_TARGET_NV = 34374;
    public static final int GL_PROGRAM_LENGTH_NV = 34343;
    public static final int GL_PROGRAM_RESIDENT_NV = 34375;
    public static final int GL_PROGRAM_STRING_NV = 34344;
    public static final int GL_PROGRAM_ERROR_POSITION_NV = 34379;
    public static final int GL_PROGRAM_ERROR_STRING_NV = 34932;

    static native void nglLoadProgramNV(int i, int i2, int i3, long j, long j2);

    static native void nglBindProgramNV(int i, int i2, long j);

    static native void nglDeleteProgramsNV(int i, long j, long j2);

    static native void nglGenProgramsNV(int i, long j, long j2);

    static native void nglGetProgramivNV(int i, int i2, long j, long j2);

    static native void nglGetProgramStringNV(int i, int i2, long j, long j2);

    static native boolean nglIsProgramNV(int i, long j);

    static native boolean nglAreProgramsResidentNV(int i, long j, long j2, long j3);

    static native void nglRequestResidentProgramsNV(int i, long j, long j2);

    public static void glLoadProgramNV(int target, int programID, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glLoadProgramNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(string);
        nglLoadProgramNV(target, programID, string.remaining(), MemoryUtil.getAddress(string), function_pointer);
    }

    public static void glLoadProgramNV(int target, int programID, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glLoadProgramNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglLoadProgramNV(target, programID, string.length(), APIUtil.getBuffer(caps, string), function_pointer);
    }

    public static void glBindProgramNV(int target, int programID) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBindProgramNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBindProgramNV(target, programID, function_pointer);
    }

    public static void glDeleteProgramsNV(IntBuffer programs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteProgramsNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programs);
        nglDeleteProgramsNV(programs.remaining(), MemoryUtil.getAddress(programs), function_pointer);
    }

    public static void glDeleteProgramsNV(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteProgramsNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDeleteProgramsNV(1, APIUtil.getInt(caps, program), function_pointer);
    }

    public static void glGenProgramsNV(IntBuffer programs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenProgramsNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programs);
        nglGenProgramsNV(programs.remaining(), MemoryUtil.getAddress(programs), function_pointer);
    }

    public static int glGenProgramsNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenProgramsNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer programs = APIUtil.getBufferInt(caps);
        nglGenProgramsNV(1, MemoryUtil.getAddress(programs), function_pointer);
        return programs.get(0);
    }

    public static void glGetProgramNV(int programID, int parameterName, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetProgramivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        nglGetProgramivNV(programID, parameterName, MemoryUtil.getAddress(params), function_pointer);
    }

    @Deprecated
    public static int glGetProgramNV(int programID, int parameterName) {
        return glGetProgramiNV(programID, parameterName);
    }

    public static int glGetProgramiNV(int programID, int parameterName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetProgramivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetProgramivNV(programID, parameterName, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }

    public static void glGetProgramStringNV(int programID, int parameterName, ByteBuffer paramString) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetProgramStringNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(paramString);
        nglGetProgramStringNV(programID, parameterName, MemoryUtil.getAddress(paramString), function_pointer);
    }

    public static String glGetProgramStringNV(int programID, int parameterName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetProgramStringNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        int programLength = glGetProgramiNV(programID, 34343);
        ByteBuffer paramString = APIUtil.getBufferByte(caps, programLength);
        nglGetProgramStringNV(programID, parameterName, MemoryUtil.getAddress(paramString), function_pointer);
        paramString.limit(programLength);
        return APIUtil.getString(caps, paramString);
    }

    public static boolean glIsProgramNV(int programID) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsProgramNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsProgramNV(programID, function_pointer);
        return __result;
    }

    public static boolean glAreProgramsResidentNV(IntBuffer programIDs, ByteBuffer programResidences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glAreProgramsResidentNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programIDs);
        BufferChecks.checkBuffer(programResidences, programIDs.remaining());
        boolean __result = nglAreProgramsResidentNV(programIDs.remaining(), MemoryUtil.getAddress(programIDs), MemoryUtil.getAddress(programResidences), function_pointer);
        return __result;
    }

    public static void glRequestResidentProgramsNV(IntBuffer programIDs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glRequestResidentProgramsNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programIDs);
        nglRequestResidentProgramsNV(programIDs.remaining(), MemoryUtil.getAddress(programIDs), function_pointer);
    }

    public static void glRequestResidentProgramsNV(int programID) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glRequestResidentProgramsNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglRequestResidentProgramsNV(1, APIUtil.getInt(caps, programID), function_pointer);
    }
}
