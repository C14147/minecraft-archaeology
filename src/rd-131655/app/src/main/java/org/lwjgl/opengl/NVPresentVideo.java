package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVPresentVideo.class */
public final class NVPresentVideo {
    public static final int GL_FRAME_NV = 36390;
    public static final int FIELDS_NV = 36391;
    public static final int GL_CURRENT_TIME_NV = 36392;
    public static final int GL_NUM_FILL_STREAMS_NV = 36393;
    public static final int GL_PRESENT_TIME_NV = 36394;
    public static final int GL_PRESENT_DURATION_NV = 36395;
    public static final int GL_NUM_VIDEO_SLOTS_NV = 8432;

    static native void nglPresentFrameKeyedNV(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j2);

    static native void nglPresentFrameDualFillNV(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, long j2);

    static native void nglGetVideoivNV(int i, int i2, long j, long j2);

    static native void nglGetVideouivNV(int i, int i2, long j, long j2);

    static native void nglGetVideoi64vNV(int i, int i2, long j, long j2);

    static native void nglGetVideoui64vNV(int i, int i2, long j, long j2);

    private NVPresentVideo() {
    }

    public static void glPresentFrameKeyedNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int key0, int target1, int fill1, int key1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glPresentFrameKeyedNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglPresentFrameKeyedNV(video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, key0, target1, fill1, key1, function_pointer);
    }

    public static void glPresentFrameDualFillNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int target1, int fill1, int target2, int fill2, int target3, int fill3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glPresentFrameDualFillNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglPresentFrameDualFillNV(video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, target1, fill1, target2, fill2, target3, fill3, function_pointer);
    }

    public static void glGetVideoNV(int video_slot, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideoivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetVideoivNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static int glGetVideoiNV(int video_slot, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideoivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetVideoivNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }

    public static void glGetVideouNV(int video_slot, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideouivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetVideouivNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static int glGetVideouiNV(int video_slot, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideouivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        nglGetVideouivNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }

    public static void glGetVideoNV(int video_slot, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideoi64vNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetVideoi64vNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static long glGetVideoi64NV(int video_slot, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideoi64vNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtil.getBufferLong(caps);
        nglGetVideoi64vNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }

    public static void glGetVideouNV(int video_slot, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideoui64vNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        nglGetVideoui64vNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static long glGetVideoui64NV(int video_slot, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVideoui64vNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtil.getBufferLong(caps);
        nglGetVideoui64vNV(video_slot, pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }
}
