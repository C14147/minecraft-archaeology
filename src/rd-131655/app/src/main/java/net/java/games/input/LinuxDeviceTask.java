package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxDeviceTask.class */
abstract class LinuxDeviceTask {
    public static final int INPROGRESS = 1;
    public static final int COMPLETED = 2;
    public static final int FAILED = 3;
    private Object result;
    private IOException exception;
    private int state = 1;

    protected abstract Object execute() throws IOException;

    LinuxDeviceTask() {
    }

    public final void doExecute() {
        try {
            this.result = execute();
            this.state = 2;
        } catch (IOException e) {
            this.exception = e;
            this.state = 3;
        }
    }

    public final IOException getException() {
        return this.exception;
    }

    public final Object getResult() {
        return this.result;
    }

    public final int getState() {
        return this.state;
    }
}
