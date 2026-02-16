package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVVideoCaptureUtil.class */
public final class NVVideoCaptureUtil {
    private static native boolean nglBindVideoCaptureDeviceNV(ByteBuffer byteBuffer, int i, long j);

    private static native int nglEnumerateVideoCaptureDevicesNV(ByteBuffer byteBuffer, LongBuffer longBuffer, int i);

    private static native boolean nglLockVideoCaptureDeviceNV(ByteBuffer byteBuffer, long j);

    private static native boolean nglQueryVideoCaptureDeviceNV(ByteBuffer byteBuffer, long j, int i, IntBuffer intBuffer, int i2);

    private static native boolean nglReleaseVideoCaptureDeviceNV(ByteBuffer byteBuffer, long j);

    private NVVideoCaptureUtil() {
    }

    private static void checkExtension() {
        if (LWJGLUtil.CHECKS && !GLContext.getCapabilities().GL_NV_video_capture) {
            throw new IllegalStateException("NV_video_capture is not supported");
        }
    }

    private static ByteBuffer getPeerInfo() {
        return ContextGL.getCurrentContext().getPeerInfo().getHandle();
    }

    public static boolean glBindVideoCaptureDeviceNV(int video_slot, long device) {
        checkExtension();
        return nglBindVideoCaptureDeviceNV(getPeerInfo(), video_slot, device);
    }

    public static int glEnumerateVideoCaptureDevicesNV(LongBuffer devices) {
        checkExtension();
        if (devices != null) {
            BufferChecks.checkBuffer(devices, 1);
        }
        return nglEnumerateVideoCaptureDevicesNV(getPeerInfo(), devices, devices == null ? 0 : devices.position());
    }

    public static boolean glLockVideoCaptureDeviceNV(long device) {
        checkExtension();
        return nglLockVideoCaptureDeviceNV(getPeerInfo(), device);
    }

    public static boolean glQueryVideoCaptureDeviceNV(long device, int attribute, IntBuffer value) {
        checkExtension();
        BufferChecks.checkBuffer(value, 1);
        return nglQueryVideoCaptureDeviceNV(getPeerInfo(), device, attribute, value, value.position());
    }

    public static boolean glReleaseVideoCaptureDeviceNV(long device) {
        checkExtension();
        return nglReleaseVideoCaptureDeviceNV(getPeerInfo(), device);
    }
}
