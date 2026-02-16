package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ContextImplementation.class */
interface ContextImplementation {
    ByteBuffer create(PeerInfo peerInfo, IntBuffer intBuffer, ByteBuffer byteBuffer) throws LWJGLException;

    void swapBuffers() throws LWJGLException;

    void releaseDrawable(ByteBuffer byteBuffer) throws LWJGLException;

    void releaseCurrentContext() throws LWJGLException;

    void update(ByteBuffer byteBuffer);

    void makeCurrent(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException;

    boolean isCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    void setSwapInterval(int i);

    void destroy(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException;
}
