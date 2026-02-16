package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBOcclusionQuery.class */
public final class ARBOcclusionQuery {
    public static final int GL_SAMPLES_PASSED_ARB = 35092;
    public static final int GL_QUERY_COUNTER_BITS_ARB = 34916;
    public static final int GL_CURRENT_QUERY_ARB = 34917;
    public static final int GL_QUERY_RESULT_ARB = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE_ARB = 34919;

    static native void nglGenQueriesARB(int i, long j, long j2);

    static native void nglDeleteQueriesARB(int i, long j, long j2);

    static native boolean nglIsQueryARB(int i, long j);

    static native void nglBeginQueryARB(int i, int i2, long j);

    static native void nglEndQueryARB(int i, long j);

    static native void nglGetQueryivARB(int i, int i2, long j, long j2);

    static native void nglGetQueryObjectivARB(int i, int i2, long j, long j2);

    static native void nglGetQueryObjectuivARB(int i, int i2, long j, long j2);

    private ARBOcclusionQuery() {
    }

    public static void glGenQueriesARB(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenQueriesARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        nglGenQueriesARB(ids.remaining(), MemoryUtil.getAddress(ids), function_pointer);
    }

    public static int glGenQueriesARB() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenQueriesARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer ids = APIUtil.getBufferInt(caps);
        nglGenQueriesARB(1, MemoryUtil.getAddress(ids), function_pointer);
        return ids.get(0);
    }

    public static void glDeleteQueriesARB(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteQueriesARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        nglDeleteQueriesARB(ids.remaining(), MemoryUtil.getAddress(ids), function_pointer);
    }

    public static void glDeleteQueriesARB(int id) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteQueriesARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDeleteQueriesARB(1, APIUtil.getInt(caps, id), function_pointer);
    }

    public static boolean glIsQueryARB(int id) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsQueryARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsQueryARB(id, function_pointer);
        return __result;
    }

    public static void glBeginQueryARB(int target, int id) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBeginQueryARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBeginQueryARB(target, id, function_pointer);
    }

    public static void glEndQueryARB(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glEndQueryARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglEndQueryARB(target, function_pointer);
    }

    public static void glGetQueryARB(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetQueryivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetQueryivARB(target, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    @Deprecated
    public static int glGetQueryARB(int target, int pname) {
        return glGetQueryiARB(target, pname);
    }

    public static int glGetQueryiARB(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetQueryivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetQueryivARB(target, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectARB(int id, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetQueryObjectivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetQueryObjectivARB(id, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static int glGetQueryObjectiARB(int id, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetQueryObjectivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetQueryObjectivARB(id, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectuARB(int id, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetQueryObjectuivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetQueryObjectuivARB(id, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static int glGetQueryObjectuiARB(int id, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetQueryObjectuivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetQueryObjectuivARB(id, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }
}
