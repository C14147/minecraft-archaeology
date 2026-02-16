package net.java.games.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxJoystickEvent.class */
final class LinuxJoystickEvent {
    private long nanos;
    private int value;
    private int type;
    private int number;

    LinuxJoystickEvent() {
    }

    public final void set(long millis, int value, int type, int number) {
        this.nanos = millis * 1000000;
        this.value = value;
        this.type = type;
        this.number = number;
    }

    public final int getValue() {
        return this.value;
    }

    public final int getType() {
        return this.type;
    }

    public final int getNumber() {
        return this.number;
    }

    public final long getNanos() {
        return this.nanos;
    }
}
