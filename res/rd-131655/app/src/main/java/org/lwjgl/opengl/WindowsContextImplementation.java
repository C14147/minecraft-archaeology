package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsContextImplementation.class */
final class WindowsContextImplementation implements ContextImplementation {
    private static native ByteBuffer nCreate(ByteBuffer byteBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    native long getHGLRC(ByteBuffer byteBuffer);

    native long getHDC(ByteBuffer byteBuffer);

    private static native void nSwapBuffers(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nReleaseCurrentContext() throws LWJGLException;

    private static native void nMakeCurrent(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native boolean nIsCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native boolean nSetSwapInterval(int i);

    private static native void nDestroy(ByteBuffer byteBuffer) throws LWJGLException;

    WindowsContextImplementation() {
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public ByteBuffer create(PeerInfo peer_info, IntBuffer attribs, ByteBuffer shared_context_handle) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            ByteBuffer byteBufferNCreate = nCreate(peer_handle, attribs, shared_context_handle);
            peer_info.unlock();
            return byteBufferNCreate;
        } catch (Throwable th) {
            peer_info.unlock();
            throw th;
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void swapBuffers() throws LWJGLException {
        ContextGL current_context = ContextGL.getCurrentContext();
        if (current_context == null) {
            throw new IllegalStateException("No context is current");
        }
        synchronized (current_context) {
            PeerInfo current_peer_info = current_context.getPeerInfo();
            ByteBuffer peer_handle = current_peer_info.lockAndGetHandle();
            try {
                nSwapBuffers(peer_handle);
                current_peer_info.unlock();
            } catch (Throwable th) {
                current_peer_info.unlock();
                throw th;
            }
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void releaseDrawable(ByteBuffer context_handle) throws LWJGLException {
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void update(ByteBuffer context_handle) {
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void releaseCurrentContext() throws LWJGLException {
        nReleaseCurrentContext();
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void makeCurrent(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            nMakeCurrent(peer_handle, handle);
            peer_info.unlock();
        } catch (Throwable th) {
            peer_info.unlock();
            throw th;
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public boolean isCurrent(ByteBuffer handle) throws LWJGLException {
        boolean result = nIsCurrent(handle);
        return result;
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void setSwapInterval(int value) {
        boolean success = nSetSwapInterval(value);
        if (!success) {
            LWJGLUtil.log("Failed to set swap interval");
        }
        Util.checkGLError();
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void destroy(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        nDestroy(handle);
    }
}
