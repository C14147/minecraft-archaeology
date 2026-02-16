package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/RawDeviceInfo.class */
abstract class RawDeviceInfo {
    public abstract Controller createControllerFromDevice(RawDevice rawDevice, SetupAPIDevice setupAPIDevice) throws IOException;

    public abstract int getUsage();

    public abstract int getUsagePage();

    public abstract long getHandle();

    RawDeviceInfo() {
    }

    public final boolean equals(Object other) {
        if (!(other instanceof RawDeviceInfo)) {
            return false;
        }
        RawDeviceInfo other_info = (RawDeviceInfo) other;
        return other_info.getUsage() == getUsage() && other_info.getUsagePage() == getUsagePage();
    }

    public final int hashCode() {
        return getUsage() ^ getUsagePage();
    }
}
