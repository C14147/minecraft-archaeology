package com.mojang.rubydung;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/Timer.class */
public class Timer {
    private static final long NS_PER_SECOND = 1000000000;
    private static final long MAX_NS_PER_UPDATE = 1000000000;
    private static final int MAX_TICKS_PER_UPDATE = 100;
    private final float ticksPerSecond;
    private long lastTime = System.nanoTime();
    public float timeScale = 1.0f;
    public float fps = 0.0f;
    public float passedTime = 0.0f;
    public int ticks;
    public float partialTicks;

    public Timer(float ticksPerSecond) {
        this.ticksPerSecond = ticksPerSecond;
    }

    public void advanceTime() {
        long now = System.nanoTime();
        long passedNs = now - this.lastTime;
        this.lastTime = now;
        long passedNs2 = Math.min(1000000000L, Math.max(0L, passedNs));
        this.fps = 1000000000 / passedNs2;
        this.passedTime += ((passedNs2 * this.timeScale) * this.ticksPerSecond) / 1.0E9f;
        this.ticks = (int) this.passedTime;
        this.ticks = Math.min(100, this.ticks);
        this.passedTime -= this.ticks;
        this.partialTicks = this.passedTime;
    }
}
