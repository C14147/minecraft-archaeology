package org.lwjgl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/DefaultSysImplementation.class */
abstract class DefaultSysImplementation implements SysImplementation {
    @Override // org.lwjgl.SysImplementation
    public native int getJNIVersion();

    @Override // org.lwjgl.SysImplementation
    public native int getPointerSize();

    @Override // org.lwjgl.SysImplementation
    public native void setDebug(boolean z);

    @Override // org.lwjgl.SysImplementation
    public abstract long getTime();

    @Override // org.lwjgl.SysImplementation
    public abstract void alert(String str, String str2);

    @Override // org.lwjgl.SysImplementation
    public abstract String getClipboard();

    DefaultSysImplementation() {
    }

    @Override // org.lwjgl.SysImplementation
    public long getTimerResolution() {
        return 1000L;
    }

    @Override // org.lwjgl.SysImplementation
    public boolean has64Bit() {
        return false;
    }
}
