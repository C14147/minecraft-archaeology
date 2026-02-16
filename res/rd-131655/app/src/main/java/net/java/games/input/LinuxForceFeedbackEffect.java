package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxForceFeedbackEffect.class */
abstract class LinuxForceFeedbackEffect implements Rumbler {
    private final LinuxEventDevice device;
    private final WriteTask write_task = new WriteTask(this, null);
    private final UploadTask upload_task = new UploadTask(this, null);
    private final int ff_id = this.upload_task.doUpload(-1, 0.0f);

    /* JADX INFO: renamed from: net.java.games.input.LinuxForceFeedbackEffect$1, reason: invalid class name */
    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxForceFeedbackEffect$1.class */
    static class AnonymousClass1 {
    }

    protected abstract int upload(int i, float f) throws IOException;

    public LinuxForceFeedbackEffect(LinuxEventDevice device) throws IOException {
        this.device = device;
    }

    protected final LinuxEventDevice getDevice() {
        return this.device;
    }

    @Override // net.java.games.input.Rumbler
    public final synchronized void rumble(float intensity) {
        try {
            if (intensity > 0.0f) {
                this.upload_task.doUpload(this.ff_id, intensity);
                this.write_task.write(1);
            } else {
                this.write_task.write(0);
            }
        } catch (IOException e) {
            LinuxEnvironmentPlugin.logln(new StringBuffer().append("Failed to rumble: ").append(e).toString());
        }
    }

    @Override // net.java.games.input.Rumbler
    public final String getAxisName() {
        return null;
    }

    @Override // net.java.games.input.Rumbler
    public final Component.Identifier getAxisIdentifier() {
        return null;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxForceFeedbackEffect$UploadTask.class */
    private final class UploadTask extends LinuxDeviceTask {
        private int id;
        private float intensity;
        private final LinuxForceFeedbackEffect this$0;

        private UploadTask(LinuxForceFeedbackEffect linuxForceFeedbackEffect) {
            this.this$0 = linuxForceFeedbackEffect;
        }

        UploadTask(LinuxForceFeedbackEffect x0, AnonymousClass1 x1) {
            this(x0);
        }

        public final int doUpload(int id, float intensity) throws IOException {
            this.id = id;
            this.intensity = intensity;
            LinuxEnvironmentPlugin.execute(this);
            return this.id;
        }

        @Override // net.java.games.input.LinuxDeviceTask
        protected final Object execute() throws IOException {
            this.id = this.this$0.upload(this.id, this.intensity);
            return null;
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxForceFeedbackEffect$WriteTask.class */
    private final class WriteTask extends LinuxDeviceTask {
        private int value;
        private final LinuxForceFeedbackEffect this$0;

        private WriteTask(LinuxForceFeedbackEffect linuxForceFeedbackEffect) {
            this.this$0 = linuxForceFeedbackEffect;
        }

        WriteTask(LinuxForceFeedbackEffect x0, AnonymousClass1 x1) {
            this(x0);
        }

        public final void write(int value) throws IOException {
            this.value = value;
            LinuxEnvironmentPlugin.execute(this);
        }

        @Override // net.java.games.input.LinuxDeviceTask
        protected final Object execute() throws IOException {
            this.this$0.device.writeEvent(21, this.this$0.ff_id, this.value);
            return null;
        }
    }
}
