package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXContextImplementation.class */
final class MacOSXContextImplementation implements ContextImplementation {
    private static native ByteBuffer nCreate(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    native long getCGLShareGroup(ByteBuffer byteBuffer);

    private static native void nSwapBuffers(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nUpdate(ByteBuffer byteBuffer);

    private static native void nReleaseCurrentContext() throws LWJGLException;

    private static native void clearDrawable(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void setView(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native void nMakeCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native boolean nIsCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nSetSwapInterval(ByteBuffer byteBuffer, int i);

    private static native void nDestroy(ByteBuffer byteBuffer) throws LWJGLException;

    MacOSXContextImplementation() {
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public ByteBuffer create(PeerInfo peer_info, IntBuffer attribs, ByteBuffer shared_context_handle) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            ByteBuffer byteBufferNCreate = nCreate(peer_handle, shared_context_handle);
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
            nSwapBuffers(current_context.getHandle());
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void update(ByteBuffer context_handle) {
        nUpdate(context_handle);
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void releaseCurrentContext() throws LWJGLException {
        nReleaseCurrentContext();
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void releaseDrawable(ByteBuffer context_handle) throws LWJGLException {
        clearDrawable(context_handle);
    }

    static void resetView(PeerInfo peer_info, ContextGL context) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            synchronized (context) {
                clearDrawable(context.getHandle());
                setView(peer_handle, context.getHandle());
            }
        } finally {
            peer_info.unlock();
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void makeCurrent(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            setView(peer_handle, handle);
            nMakeCurrent(handle);
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
        ContextGL current_context = ContextGL.getCurrentContext();
        synchronized (current_context) {
            nSetSwapInterval(current_context.getHandle(), value);
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void destroy(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        nDestroy(handle);
    }
}
