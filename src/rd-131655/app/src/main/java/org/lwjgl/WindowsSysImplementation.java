package org.lwjgl;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.opengl.Display;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/WindowsSysImplementation.class */
final class WindowsSysImplementation extends DefaultSysImplementation {
    private static final int JNI_VERSION = 24;

    private static native long nGetTime();

    private static native void nAlert(long j, long j2, long j3);

    private static native void initCommonControls();

    private static native String nGetClipboard();

    WindowsSysImplementation() {
    }

    static {
        Sys.initialize();
    }

    @Override // org.lwjgl.SysImplementation
    public int getRequiredJNIVersion() {
        return 24;
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public long getTimerResolution() {
        return 1000L;
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public long getTime() {
        return nGetTime();
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public boolean has64Bit() {
        return true;
    }

    private static long getHwnd() {
        if (!Display.isCreated()) {
            return 0L;
        }
        try {
            return ((Long) AccessController.doPrivileged(new PrivilegedExceptionAction<Long>() { // from class: org.lwjgl.WindowsSysImplementation.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public Long run() throws Exception {
                    Method getImplementation_method = Display.class.getDeclaredMethod("getImplementation", new Class[0]);
                    getImplementation_method.setAccessible(true);
                    Object display_impl = getImplementation_method.invoke(null, new Object[0]);
                    Class<?> WindowsDisplay_class = Class.forName("org.lwjgl.opengl.WindowsDisplay");
                    Method getHwnd_method = WindowsDisplay_class.getDeclaredMethod("getHwnd", new Class[0]);
                    getHwnd_method.setAccessible(true);
                    return (Long) getHwnd_method.invoke(display_impl, new Object[0]);
                }
            })).longValue();
        } catch (PrivilegedActionException e) {
            throw new Error(e);
        }
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public void alert(String title, String message) {
        if (!Display.isCreated()) {
            initCommonControls();
        }
        LWJGLUtil.log(String.format("*** Alert *** %s\n%s\n", title, message));
        ByteBuffer titleText = MemoryUtil.encodeUTF16(title);
        ByteBuffer messageText = MemoryUtil.encodeUTF16(message);
        nAlert(getHwnd(), MemoryUtil.getAddress(titleText), MemoryUtil.getAddress(messageText));
    }

    @Override // org.lwjgl.SysImplementation
    public boolean openURL(String url) {
        try {
            LWJGLUtil.execPrivileged(new String[]{"rundll32", "url.dll,FileProtocolHandler", url});
            return true;
        } catch (Exception e) {
            LWJGLUtil.log("Failed to open url (" + url + "): " + e.getMessage());
            return false;
        }
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public String getClipboard() {
        return nGetClipboard();
    }
}
