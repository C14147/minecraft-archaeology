package org.lwjgl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/SysImplementation.class */
interface SysImplementation {
    int getRequiredJNIVersion();

    int getJNIVersion();

    int getPointerSize();

    void setDebug(boolean z);

    long getTimerResolution();

    long getTime();

    void alert(String str, String str2);

    boolean openURL(String str);

    String getClipboard();

    boolean has64Bit();
}
