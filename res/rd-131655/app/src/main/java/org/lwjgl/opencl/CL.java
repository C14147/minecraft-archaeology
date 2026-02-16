package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.MemoryUtil;
import org.lwjgl.Sys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CL.class */
public final class CL {
    private static boolean created;

    private static native void nCreate(String str) throws LWJGLException;

    private static native void nCreateDefault() throws LWJGLException;

    private static native void nDestroy();

    private static native long ngetFunctionAddress(long j);

    static native ByteBuffer getHostBuffer(long j, int i);

    private static native void resetNativeStubs(Class cls);

    static {
        Sys.initialize();
    }

    private CL() {
    }

    public static boolean isCreated() {
        return created;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void create() throws org.lwjgl.LWJGLException {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.CL.create():void");
    }

    public static void destroy() {
    }

    static long getFunctionAddress(String[] aliases) {
        for (String aliase : aliases) {
            long address = getFunctionAddress(aliase);
            if (address != 0) {
                return address;
            }
        }
        return 0L;
    }

    static long getFunctionAddress(String name) {
        ByteBuffer buffer = MemoryUtil.encodeASCII(name);
        return ngetFunctionAddress(MemoryUtil.getAddress(buffer));
    }
}
