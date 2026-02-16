package org.lwjgl.openal;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/openal/OpenALException.class */
public class OpenALException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public OpenALException() {
    }

    public OpenALException(int error_code) {
        super("OpenAL error: " + AL10.alGetString(error_code) + " (" + error_code + ")");
    }

    public OpenALException(String message) {
        super(message);
    }

    public OpenALException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenALException(Throwable cause) {
        super(cause);
    }
}
