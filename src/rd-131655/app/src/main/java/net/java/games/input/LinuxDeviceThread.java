package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxDeviceThread.class */
final class LinuxDeviceThread extends Thread {
    private final List tasks = new ArrayList();

    public LinuxDeviceThread() {
        setDaemon(true);
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final synchronized void run() {
        while (true) {
            if (!this.tasks.isEmpty()) {
                LinuxDeviceTask task = (LinuxDeviceTask) this.tasks.remove(0);
                task.doExecute();
                synchronized (task) {
                    task.notify();
                }
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final Object execute(LinuxDeviceTask task) throws IOException {
        synchronized (this) {
            this.tasks.add(task);
            notify();
        }
        synchronized (task) {
            while (task.getState() == 1) {
                try {
                    task.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        switch (task.getState()) {
            case 2:
                return task.getResult();
            case 3:
                throw task.getException();
            default:
                throw new RuntimeException(new StringBuffer().append("Invalid task state: ").append(task.getState()).toString());
        }
    }
}
