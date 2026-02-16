package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/PeerInfo.class */
abstract class PeerInfo {
    private final ByteBuffer handle;
    private Thread locking_thread;
    private int lock_count;

    protected abstract void doLockAndInitHandle() throws LWJGLException;

    protected abstract void doUnlock() throws LWJGLException;

    protected PeerInfo(ByteBuffer handle) {
        this.handle = handle;
    }

    private void lockAndInitHandle() throws LWJGLException {
        doLockAndInitHandle();
    }

    public final synchronized void unlock() throws LWJGLException {
        if (this.lock_count <= 0) {
            throw new IllegalStateException("PeerInfo not locked!");
        }
        if (Thread.currentThread() != this.locking_thread) {
            throw new IllegalStateException("PeerInfo already locked by " + this.locking_thread);
        }
        this.lock_count--;
        if (this.lock_count == 0) {
            doUnlock();
            this.locking_thread = null;
            notify();
        }
    }

    public final synchronized ByteBuffer lockAndGetHandle() throws LWJGLException {
        Thread this_thread = Thread.currentThread();
        while (this.locking_thread != null && this.locking_thread != this_thread) {
            try {
                wait();
            } catch (InterruptedException e) {
                LWJGLUtil.log("Interrupted while waiting for PeerInfo lock: " + e);
            }
        }
        if (this.lock_count == 0) {
            this.locking_thread = this_thread;
            doLockAndInitHandle();
        }
        this.lock_count++;
        return getHandle();
    }

    protected final ByteBuffer getHandle() {
        return this.handle;
    }

    public void destroy() {
    }
}
