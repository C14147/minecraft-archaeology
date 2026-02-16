package org.lwjgl.opengl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxPeerInfo.class */
abstract class LinuxPeerInfo extends PeerInfo {
    private static native ByteBuffer createHandle();

    private static native long nGetDisplay(ByteBuffer byteBuffer);

    private static native long nGetDrawable(ByteBuffer byteBuffer);

    LinuxPeerInfo() {
        super(createHandle());
    }

    public final long getDisplay() {
        return nGetDisplay(getHandle());
    }

    public final long getDrawable() {
        return nGetDrawable(getHandle());
    }
}
