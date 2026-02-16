package com.mojang.rubydung;

/* JADX INFO: loaded from: pre-Classic rd-160052.jar:com/mojang/rubydung/Timer.class */
public class Timer {
    private static final long NS_PER_SECOND = 1000000000;
    private static final long MAX_NS_PER_UPDATE = 1000000000;
    private static final int MAX_TICKS_PER_UPDATE = 100;
    private float ticksPerSecond;
    public int ticks;
    public float a;
    public float timeScale = 1.0f;
    public float fps = 0.0f;
    public float passedTime = 0.0f;
    private long lastTime = System.nanoTime();

    public Timer(float ticksPerSecond) {
        this.ticksPerSecond = ticksPerSecond;
    }

    public void advanceTime() {
        long now = System.nanoTime();
        long passedNs = now - this.lastTime;
        this.lastTime = now;
        if (passedNs < 0) {
            passedNs = 0;
        }
        if (passedNs > 1000000000) {
            passedNs = 1000000000;
        }
        this.fps = 1000000000 / passedNs;
        this.passedTime += ((passedNs * this.timeScale) * this.ticksPerSecond) / 1.0E9f;
        this.ticks = (int) this.passedTime;
        if (this.ticks > MAX_TICKS_PER_UPDATE) {
            this.ticks = MAX_TICKS_PER_UPDATE;
        }
        this.passedTime -= this.ticks;
        this.a = this.passedTime;
    }
}
