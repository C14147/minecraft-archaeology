package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/AWTSurfaceLock.class */
final class AWTSurfaceLock {
    private static final int WAIT_DELAY_MILLIS = 100;
    private final ByteBuffer lock_buffer = createHandle();
    private boolean firstLockSucceeded;

    private static native ByteBuffer createHandle();

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean lockAndInitHandle(ByteBuffer byteBuffer, Canvas canvas) throws LWJGLException;

    private static native void nUnlock(ByteBuffer byteBuffer) throws LWJGLException;

    AWTSurfaceLock() {
    }

    public ByteBuffer lockAndGetHandle(Canvas component) throws LWJGLException {
        while (!privilegedLockAndInitHandle(component)) {
            LWJGLUtil.log("Could not get drawing surface info, retrying...");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                LWJGLUtil.log("Interrupted while retrying: " + e);
            }
        }
        return this.lock_buffer;
    }

    private boolean privilegedLockAndInitHandle(final Canvas component) throws LWJGLException {
        if (this.firstLockSucceeded) {
            return lockAndInitHandle(this.lock_buffer, component);
        }
        try {
            this.firstLockSucceeded = ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() { // from class: org.lwjgl.opengl.AWTSurfaceLock.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public Boolean run() throws LWJGLException {
                    return Boolean.valueOf(AWTSurfaceLock.lockAndInitHandle(AWTSurfaceLock.this.lock_buffer, component));
                }
            })).booleanValue();
            return this.firstLockSucceeded;
        } catch (PrivilegedActionException e) {
            throw ((LWJGLException) e.getException());
        }
    }

    void unlock() throws LWJGLException {
        nUnlock(this.lock_buffer);
    }
}
