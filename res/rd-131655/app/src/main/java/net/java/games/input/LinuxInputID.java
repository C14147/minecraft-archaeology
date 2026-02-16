package net.java.games.input;

import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxInputID.class */
final class LinuxInputID {
    private final int bustype;
    private final int vendor;
    private final int product;
    private final int version;

    public LinuxInputID(int bustype, int vendor, int product, int version) {
        this.bustype = bustype;
        this.vendor = vendor;
        this.product = product;
        this.version = version;
    }

    public final Controller.PortType getPortType() {
        return LinuxNativeTypesMap.getPortType(this.bustype);
    }

    public final String toString() {
        return new StringBuffer().append("LinuxInputID: bustype = 0x").append(Integer.toHexString(this.bustype)).append(" | vendor = 0x").append(Integer.toHexString(this.vendor)).append(" | product = 0x").append(Integer.toHexString(this.product)).append(" | version = 0x").append(Integer.toHexString(this.version)).toString();
    }
}
