package org.lwjgl.opencl;

import java.lang.reflect.Field;
import java.util.Map;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/Util.class */
public final class Util {
    private static final Map<Integer, String> CL_ERROR_TOKENS = LWJGLUtil.getClassTokens(new LWJGLUtil.TokenFilter() { // from class: org.lwjgl.opencl.Util.1
        @Override // org.lwjgl.LWJGLUtil.TokenFilter
        public boolean accept(Field field, int value) {
            return value < 0;
        }
    }, (Map<Integer, String>) null, CL10.class, CL11.class, KHRGLSharing.class, KHRICD.class, APPLEGLSharing.class, EXTDeviceFission.class);

    private Util() {
    }

    public static void checkCLError(int errcode) {
        if (errcode != 0) {
            throwCLError(errcode);
        }
    }

    private static void throwCLError(int errcode) {
        String errname = CL_ERROR_TOKENS.get(Integer.valueOf(errcode));
        if (errname == null) {
            errname = "UNKNOWN";
        }
        throw new OpenCLException("Error Code: " + errname + " (" + LWJGLUtil.toHexString(errcode) + ")");
    }
}
