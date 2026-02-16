package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/GREMEDYStringMarker.class */
public final class GREMEDYStringMarker {
    static native void nglStringMarkerGREMEDY(int i, long j, long j2);

    private GREMEDYStringMarker() {
    }

    public static void glStringMarkerGREMEDY(ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glStringMarkerGREMEDY;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(string);
        nglStringMarkerGREMEDY(string.remaining(), MemoryUtil.getAddress(string), function_pointer);
    }

    public static void glStringMarkerGREMEDY(CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glStringMarkerGREMEDY;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglStringMarkerGREMEDY(string.length(), APIUtil.getBuffer(caps, string), function_pointer);
    }
}
