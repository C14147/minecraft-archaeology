package com.mojang.minecraft.renderer;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/renderer/Tesselator.class */
public class Tesselator {
    private static final int MAX_MEMORY_USE = 4194304;
    private static final int MAX_FLOATS = 524288;

    /* JADX INFO: renamed from: u */
    private float f63u;

    /* JADX INFO: renamed from: v */
    private float f64v;

    /* JADX INFO: renamed from: r */
    private float f65r;

    /* JADX INFO: renamed from: g */
    private float f66g;

    /* JADX INFO: renamed from: b */
    private float f67b;
    public static Tesselator instance = new Tesselator();
    private FloatBuffer buffer = BufferUtils.createFloatBuffer(MAX_FLOATS);
    private float[] array = new float[MAX_FLOATS];
    private int vertices = 0;
    private boolean hasColor = false;
    private boolean hasTexture = false;
    private int len = 3;

    /* JADX INFO: renamed from: p */
    private int f68p = 0;
    private boolean noColor = false;

    private Tesselator() {
    }

    public void end() {
        if (this.vertices > 0) {
            this.buffer.clear();
            this.buffer.put(this.array, 0, this.f68p);
            this.buffer.flip();
            if (this.hasTexture && this.hasColor) {
                GL11.glInterleavedArrays(10794, 0, this.buffer);
            } else if (this.hasTexture) {
                GL11.glInterleavedArrays(10791, 0, this.buffer);
            } else if (this.hasColor) {
                GL11.glInterleavedArrays(10788, 0, this.buffer);
            } else {
                GL11.glInterleavedArrays(10785, 0, this.buffer);
            }
            GL11.glEnableClientState(32884);
            if (this.hasTexture) {
                GL11.glEnableClientState(32888);
            }
            if (this.hasColor) {
                GL11.glEnableClientState(32886);
            }
            GL11.glDrawArrays(7, 0, this.vertices);
            GL11.glDisableClientState(32884);
            if (this.hasTexture) {
                GL11.glDisableClientState(32888);
            }
            if (this.hasColor) {
                GL11.glDisableClientState(32886);
            }
        }
        clear();
    }

    private void clear() {
        this.vertices = 0;
        this.buffer.clear();
        this.f68p = 0;
    }

    public void begin() {
        clear();
        this.hasColor = false;
        this.hasTexture = false;
        this.noColor = false;
    }

    public void tex(float u, float v) {
        if (!this.hasTexture) {
            this.len += 2;
        }
        this.hasTexture = true;
        this.f63u = u;
        this.f64v = v;
    }

    public void color(int r, int g, int b) {
        color((byte) r, (byte) g, (byte) b);
    }

    public void color(byte r, byte g, byte b) {
        if (this.noColor) {
            return;
        }
        if (!this.hasColor) {
            this.len += 3;
        }
        this.hasColor = true;
        this.f65r = (r & 255) / 255.0f;
        this.f66g = (g & 255) / 255.0f;
        this.f67b = (b & 255) / 255.0f;
    }

    public void vertexUV(float x, float y, float z, float u, float v) {
        tex(u, v);
        vertex(x, y, z);
    }

    public void vertex(float x, float y, float z) {
        if (this.hasTexture) {
            float[] fArr = this.array;
            int i = this.f68p;
            this.f68p = i + 1;
            fArr[i] = this.f63u;
            float[] fArr2 = this.array;
            int i2 = this.f68p;
            this.f68p = i2 + 1;
            fArr2[i2] = this.f64v;
        }
        if (this.hasColor) {
            float[] fArr3 = this.array;
            int i3 = this.f68p;
            this.f68p = i3 + 1;
            fArr3[i3] = this.f65r;
            float[] fArr4 = this.array;
            int i4 = this.f68p;
            this.f68p = i4 + 1;
            fArr4[i4] = this.f66g;
            float[] fArr5 = this.array;
            int i5 = this.f68p;
            this.f68p = i5 + 1;
            fArr5[i5] = this.f67b;
        }
        float[] fArr6 = this.array;
        int i6 = this.f68p;
        this.f68p = i6 + 1;
        fArr6[i6] = x;
        float[] fArr7 = this.array;
        int i7 = this.f68p;
        this.f68p = i7 + 1;
        fArr7[i7] = y;
        float[] fArr8 = this.array;
        int i8 = this.f68p;
        this.f68p = i8 + 1;
        fArr8[i8] = z;
        this.vertices++;
        if (this.vertices % 4 == 0 && this.f68p >= MAX_FLOATS - (this.len * 4)) {
            end();
        }
    }

    public void color(int c) {
        int r = (c >> 16) & 255;
        int g = (c >> 8) & 255;
        int b = c & 255;
        color(r, g, b);
    }

    public void noColor() {
        this.noColor = true;
    }
}
