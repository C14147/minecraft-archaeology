package org.lwjgl;

import java.awt.Toolkit;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/LinuxSysImplementation.class */
final class LinuxSysImplementation extends J2SESysImplementation {
    private static final int JNI_VERSION = 19;

    LinuxSysImplementation() {
    }

    static {
        Toolkit.getDefaultToolkit();
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.LinuxSysImplementation.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    System.loadLibrary("jawt");
                    return null;
                } catch (UnsatisfiedLinkError e) {
                    return null;
                }
            }
        });
    }

    @Override // org.lwjgl.SysImplementation
    public int getRequiredJNIVersion() {
        return 19;
    }

    @Override // org.lwjgl.SysImplementation
    public boolean openURL(String url) {
        String[] browsers = {"sensible-browser", "xdg-open", "google-chrome", "chromium", "firefox", "iceweasel", "mozilla", "opera", "konqueror", "nautilus", "galeon", "netscape"};
        for (String browser : browsers) {
            try {
                LWJGLUtil.execPrivileged(new String[]{browser, url});
                return true;
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
        return false;
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public boolean has64Bit() {
        return true;
    }
}
