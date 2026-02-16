package org.lwjgl.opengl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsFileVersion.class */
final class WindowsFileVersion {
    private final int product_version_ms;
    private final int product_version_ls;

    WindowsFileVersion(int product_version_ms, int product_version_ls) {
        this.product_version_ms = product_version_ms;
        this.product_version_ls = product_version_ls;
    }

    public String toString() {
        int f1 = (this.product_version_ms >> 16) & LinuxKeycodes.XK_Delete;
        int f2 = this.product_version_ms & LinuxKeycodes.XK_Delete;
        int f3 = (this.product_version_ls >> 16) & LinuxKeycodes.XK_Delete;
        int f4 = this.product_version_ls & LinuxKeycodes.XK_Delete;
        return f1 + "." + f2 + "." + f3 + "." + f4;
    }
}
