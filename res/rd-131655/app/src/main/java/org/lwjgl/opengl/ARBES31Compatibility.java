package org.lwjgl.opengl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBES31Compatibility.class */
public final class ARBES31Compatibility {
    private ARBES31Compatibility() {
    }

    public static void glMemoryBarrierByRegion(int barriers) {
        GL45.glMemoryBarrierByRegion(barriers);
    }
}
