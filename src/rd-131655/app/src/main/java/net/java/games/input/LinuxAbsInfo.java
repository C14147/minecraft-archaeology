package net.java.games.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxAbsInfo.class */
final class LinuxAbsInfo {
    private int value;
    private int minimum;
    private int maximum;
    private int fuzz;
    private int flat;

    LinuxAbsInfo() {
    }

    public final void set(int value, int min, int max, int fuzz, int flat) {
        this.value = value;
        this.minimum = min;
        this.maximum = max;
        this.fuzz = fuzz;
        this.flat = flat;
    }

    public final String toString() {
        return new StringBuffer().append("AbsInfo: value = ").append(this.value).append(" | min = ").append(this.minimum).append(" | max = ").append(this.maximum).append(" | fuzz = ").append(this.fuzz).append(" | flat = ").append(this.flat).toString();
    }

    public final int getValue() {
        return this.value;
    }

    final int getMax() {
        return this.maximum;
    }

    final int getMin() {
        return this.minimum;
    }

    final int getFlat() {
        return this.flat;
    }

    final int getFuzz() {
        return this.fuzz;
    }
}
