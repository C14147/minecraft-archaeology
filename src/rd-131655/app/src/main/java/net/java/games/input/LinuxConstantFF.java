package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxConstantFF.class */
final class LinuxConstantFF extends LinuxForceFeedbackEffect {
    public LinuxConstantFF(LinuxEventDevice device) throws IOException {
        super(device);
    }

    @Override // net.java.games.input.LinuxForceFeedbackEffect
    protected final int upload(int id, float intensity) throws IOException {
        int scaled_intensity = Math.round(intensity * 32767.0f);
        return getDevice().uploadConstantEffect(id, 0, 0, 0, 0, 0, scaled_intensity, 0, 0, 0, 0);
    }
}
