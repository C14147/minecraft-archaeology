package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxContextImplementation.class */
final class LinuxContextImplementation implements ContextImplementation {
    private static native ByteBuffer nCreate(ByteBuffer byteBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    native long getGLXContext(ByteBuffer byteBuffer);

    native long getDisplay(ByteBuffer byteBuffer);

    private static native void nSwapBuffers(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nReleaseCurrentContext(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nMakeCurrent(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native boolean nIsCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nSetSwapInterval(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i);

    private static native void nDestroy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    LinuxContextImplementation() {
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public ByteBuffer create(PeerInfo peer_info, IntBuffer attribs, ByteBuffer shared_context_handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            ByteBuffer peer_handle = peer_info.lockAndGetHandle();
            try {
                ByteBuffer byteBufferNCreate = nCreate(peer_handle, attribs, shared_context_handle);
                peer_info.unlock();
                LinuxDisplay.unlockAWT();
                return byteBufferNCreate;
            } catch (Throwable th) {
                peer_info.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            LinuxDisplay.unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void releaseDrawable(ByteBuffer context_handle) throws LWJGLException {
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void swapBuffers() throws LWJGLException {
        ContextGL current_context = ContextGL.getCurrentContext();
        if (current_context == null) {
            throw new IllegalStateException("No context is current");
        }
        synchronized (current_context) {
            PeerInfo current_peer_info = current_context.getPeerInfo();
            LinuxDisplay.lockAWT();
            try {
                ByteBuffer peer_handle = current_peer_info.lockAndGetHandle();
                try {
                    nSwapBuffers(peer_handle);
                    current_peer_info.unlock();
                    LinuxDisplay.unlockAWT();
                } catch (Throwable th) {
                    current_peer_info.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                LinuxDisplay.unlockAWT();
                throw th2;
            }
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void releaseCurrentContext() throws LWJGLException {
        ContextGL current_context = ContextGL.getCurrentContext();
        if (current_context == null) {
            throw new IllegalStateException("No context is current");
        }
        synchronized (current_context) {
            PeerInfo current_peer_info = current_context.getPeerInfo();
            LinuxDisplay.lockAWT();
            try {
                ByteBuffer peer_handle = current_peer_info.lockAndGetHandle();
                try {
                    nReleaseCurrentContext(peer_handle);
                    current_peer_info.unlock();
                    LinuxDisplay.unlockAWT();
                } catch (Throwable th) {
                    current_peer_info.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                LinuxDisplay.unlockAWT();
                throw th2;
            }
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void update(ByteBuffer context_handle) {
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void makeCurrent(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            ByteBuffer peer_handle = peer_info.lockAndGetHandle();
            try {
                nMakeCurrent(peer_handle, handle);
                peer_info.unlock();
            } catch (Throwable th) {
                peer_info.unlock();
                throw th;
            }
        } finally {
            LinuxDisplay.unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public boolean isCurrent(ByteBuffer handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            boolean result = nIsCurrent(handle);
            LinuxDisplay.unlockAWT();
            return result;
        } catch (Throwable th) {
            LinuxDisplay.unlockAWT();
            throw th;
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void setSwapInterval(int value) {
        ContextGL current_context = ContextGL.getCurrentContext();
        PeerInfo peer_info = current_context.getPeerInfo();
        if (current_context == null) {
            throw new IllegalStateException("No context is current");
        }
        synchronized (current_context) {
            try {
                LinuxDisplay.lockAWT();
                try {
                    ByteBuffer peer_handle = peer_info.lockAndGetHandle();
                    try {
                        nSetSwapInterval(peer_handle, current_context.getHandle(), value);
                        peer_info.unlock();
                        LinuxDisplay.unlockAWT();
                    } catch (Throwable th) {
                        peer_info.unlock();
                        throw th;
                    }
                } catch (LWJGLException e) {
                    e.printStackTrace();
                    LinuxDisplay.unlockAWT();
                }
            } catch (Throwable th2) {
                LinuxDisplay.unlockAWT();
                throw th2;
            }
        }
    }

    @Override // org.lwjgl.opengl.ContextImplementation
    public void destroy(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            ByteBuffer peer_handle = peer_info.lockAndGetHandle();
            try {
                nDestroy(peer_handle, handle);
                peer_info.unlock();
            } catch (Throwable th) {
                peer_info.unlock();
                throw th;
            }
        } finally {
            LinuxDisplay.unlockAWT();
        }
    }
}
