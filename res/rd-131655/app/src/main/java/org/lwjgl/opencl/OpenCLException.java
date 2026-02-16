package org.lwjgl.opencl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/OpenCLException.class */
public class OpenCLException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public OpenCLException() {
    }

    public OpenCLException(String message) {
        super(message);
    }

    public OpenCLException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenCLException(Throwable cause) {
        super(cause);
    }
}
