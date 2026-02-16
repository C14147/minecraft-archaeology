package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/IDirectInputEffect.class */
final class IDirectInputEffect implements Rumbler {
    private final long address;
    private final DIEffectInfo info;
    private boolean released;

    private static final native void nRelease(long j);

    private static final native int nSetGain(long j, int i);

    private static final native int nStart(long j, int i, int i2);

    private static final native int nStop(long j);

    public IDirectInputEffect(long address, DIEffectInfo info) {
        this.address = address;
        this.info = info;
    }

    @Override // net.java.games.input.Rumbler
    public final synchronized void rumble(float intensity) {
        try {
            checkReleased();
            if (intensity > 0.0f) {
                int int_gain = Math.round(intensity * 10000.0f);
                setGain(int_gain);
                start(1, 0);
            } else {
                stop();
            }
        } catch (IOException e) {
            DirectInputEnvironmentPlugin.logln(new StringBuffer().append("Failed to set rumbler gain: ").append(e.getMessage()).toString());
        }
    }

    @Override // net.java.games.input.Rumbler
    public final Component.Identifier getAxisIdentifier() {
        return null;
    }

    @Override // net.java.games.input.Rumbler
    public final String getAxisName() {
        return null;
    }

    public final synchronized void release() {
        if (!this.released) {
            this.released = true;
            nRelease(this.address);
        }
    }

    private final void checkReleased() throws IOException {
        if (this.released) {
            throw new IOException();
        }
    }

    private final void setGain(int gain) throws IOException {
        int res = nSetGain(this.address, gain);
        if (res != 3 && res != 4 && res != 0 && res != 8 && res != 12) {
            throw new IOException(new StringBuffer().append("Failed to set effect gain (0x").append(Integer.toHexString(res)).append(")").toString());
        }
    }

    private final void start(int iterations, int flags) throws IOException {
        int res = nStart(this.address, iterations, flags);
        if (res != 0) {
            throw new IOException(new StringBuffer().append("Failed to start effect (0x").append(Integer.toHexString(res)).append(")").toString());
        }
    }

    private final void stop() throws IOException {
        int res = nStop(this.address);
        if (res != 0) {
            throw new IOException(new StringBuffer().append("Failed to stop effect (0x").append(Integer.toHexString(res)).append(")").toString());
        }
    }

    protected void finalize() {
        release();
    }
}
