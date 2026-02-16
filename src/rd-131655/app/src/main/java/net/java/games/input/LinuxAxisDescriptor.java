package net.java.games.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxAxisDescriptor.class */
final class LinuxAxisDescriptor {
    private int type;
    private int code;

    LinuxAxisDescriptor() {
    }

    public final void set(int type, int code) {
        this.type = type;
        this.code = code;
    }

    public final int getType() {
        return this.type;
    }

    public final int getCode() {
        return this.code;
    }

    public final int hashCode() {
        return this.type ^ this.code;
    }

    public final boolean equals(Object other) {
        if (!(other instanceof LinuxAxisDescriptor)) {
            return false;
        }
        LinuxAxisDescriptor descriptor = (LinuxAxisDescriptor) other;
        return descriptor.type == this.type && descriptor.code == this.code;
    }

    public final String toString() {
        return new StringBuffer().append("LinuxAxis: type = 0x").append(Integer.toHexString(this.type)).append(", code = 0x").append(Integer.toHexString(this.code)).toString();
    }
}
