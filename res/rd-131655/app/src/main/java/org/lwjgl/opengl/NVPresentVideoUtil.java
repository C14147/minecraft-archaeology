package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVPresentVideoUtil.class */
public final class NVPresentVideoUtil {
    private static native int nglEnumerateVideoDevicesNV(ByteBuffer byteBuffer, LongBuffer longBuffer, int i);

    private static native boolean nglBindVideoDeviceNV(ByteBuffer byteBuffer, int i, long j, IntBuffer intBuffer, int i2);

    private static native boolean nglQueryContextNV(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, IntBuffer intBuffer, int i2);

    private NVPresentVideoUtil() {
    }

    private static void checkExtension() {
        if (LWJGLUtil.CHECKS && !GLContext.getCapabilities().GL_NV_present_video) {
            throw new IllegalStateException("NV_present_video is not supported");
        }
    }

    private static ByteBuffer getPeerInfo() {
        return ContextGL.getCurrentContext().getPeerInfo().getHandle();
    }

    public static int glEnumerateVideoDevicesNV(LongBuffer devices) {
        checkExtension();
        if (devices != null) {
            BufferChecks.checkBuffer(devices, 1);
        }
        return nglEnumerateVideoDevicesNV(getPeerInfo(), devices, devices == null ? 0 : devices.position());
    }

    public static boolean glBindVideoDeviceNV(int video_slot, long video_device, IntBuffer attrib_list) {
        checkExtension();
        if (attrib_list != null) {
            BufferChecks.checkNullTerminated(attrib_list);
        }
        return nglBindVideoDeviceNV(getPeerInfo(), video_slot, video_device, attrib_list, attrib_list == null ? 0 : attrib_list.position());
    }

    public static boolean glQueryContextNV(int attrib, IntBuffer value) {
        checkExtension();
        BufferChecks.checkBuffer(value, 1);
        ContextGL ctx = ContextGL.getCurrentContext();
        return nglQueryContextNV(ctx.getPeerInfo().getHandle(), ctx.getHandle(), attrib, value, value.position());
    }
}
