package com.mojang.minecraft.level;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: pre-Classic rd-161348.jar:com/mojang/minecraft/level/Tesselator.class */
public class Tesselator {
    private static final int MAX_MEMORY_USE = 4194304;
    private static final int MAX_FLOATS = 524288;
    private float u;
    private float v;
    private float r;
    private float g;
    private float b;
    public static Tesselator instance = new Tesselator();
    private FloatBuffer buffer = BufferUtils.createFloatBuffer(MAX_FLOATS);
    private float[] array = new float[MAX_FLOATS];
    private int vertices = 0;
    private boolean hasColor = false;
    private boolean hasTexture = false;
    private int len = 3;
    private int p = 0;

    private Tesselator() {
    }

    public void flush() {
        this.buffer.clear();
        this.buffer.put(this.array, 0, this.p);
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
        clear();
    }

    private void clear() {
        this.vertices = 0;
        this.buffer.clear();
        this.p = 0;
    }

    public void init() {
        clear();
        this.hasColor = false;
        this.hasTexture = false;
    }

    public void tex(float u, float v) {
        if (!this.hasTexture) {
            this.len += 2;
        }
        this.hasTexture = true;
        this.u = u;
        this.v = v;
    }

    public void color(float r, float g, float b) {
        if (!this.hasColor) {
            this.len += 3;
        }
        this.hasColor = true;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void vertexUV(float x, float y, float z, float u, float v) {
        tex(u, v);
        vertex(x, y, z);
    }

    public void vertex(float x, float y, float z) {
        if (this.hasTexture) {
            float[] fArr = this.array;
            int i = this.p;
            this.p = i + 1;
            fArr[i] = this.u;
            float[] fArr2 = this.array;
            int i2 = this.p;
            this.p = i2 + 1;
            fArr2[i2] = this.v;
        }
        if (this.hasColor) {
            float[] fArr3 = this.array;
            int i3 = this.p;
            this.p = i3 + 1;
            fArr3[i3] = this.r;
            float[] fArr4 = this.array;
            int i4 = this.p;
            this.p = i4 + 1;
            fArr4[i4] = this.g;
            float[] fArr5 = this.array;
            int i5 = this.p;
            this.p = i5 + 1;
            fArr5[i5] = this.b;
        }
        float[] fArr6 = this.array;
        int i6 = this.p;
        this.p = i6 + 1;
        fArr6[i6] = x;
        float[] fArr7 = this.array;
        int i7 = this.p;
        this.p = i7 + 1;
        fArr7[i7] = y;
        float[] fArr8 = this.array;
        int i8 = this.p;
        this.p = i8 + 1;
        fArr8[i8] = z;
        this.vertices++;
        if (this.vertices % 4 == 0 && this.p >= MAX_FLOATS - (this.len * 4)) {
            flush();
        }
    }
}
