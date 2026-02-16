package org.lwjgl;

import com.apple.eio.FileManager;
import java.awt.Toolkit;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/MacOSXSysImplementation.class */
final class MacOSXSysImplementation extends J2SESysImplementation {
    private static final int JNI_VERSION = 25;

    MacOSXSysImplementation() {
    }

    static {
        Toolkit.getDefaultToolkit();
    }

    @Override // org.lwjgl.SysImplementation
    public int getRequiredJNIVersion() {
        return 25;
    }

    @Override // org.lwjgl.SysImplementation
    public boolean openURL(String url) {
        try {
            FileManager.openURL(url);
            return true;
        } catch (Exception e) {
            LWJGLUtil.log("Exception occurred while trying to invoke browser: " + e);
            return false;
        }
    }
}
