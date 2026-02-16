package org.lwjgl.opengl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBTextureBarrier.class */
public final class ARBTextureBarrier {
    private ARBTextureBarrier() {
    }

    public static void glTextureBarrier() {
        GL45.glTextureBarrier();
    }
}
