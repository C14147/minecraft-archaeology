package org.lwjgl.opengl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBTransformFeedbackInstanced.class */
public final class ARBTransformFeedbackInstanced {
    private ARBTransformFeedbackInstanced() {
    }

    public static void glDrawTransformFeedbackInstanced(int mode, int id, int primcount) {
        GL42.glDrawTransformFeedbackInstanced(mode, id, primcount);
    }

    public static void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int primcount) {
        GL42.glDrawTransformFeedbackStreamInstanced(mode, id, stream, primcount);
    }
}
