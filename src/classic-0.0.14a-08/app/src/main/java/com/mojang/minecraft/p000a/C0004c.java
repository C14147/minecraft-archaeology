package com.mojang.minecraft.p000a;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.c */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/a/c.class */
public final class C0004c {

    /* JADX INFO: renamed from: e */
    private float f17e;

    /* JADX INFO: renamed from: f */
    private float f18f;

    /* JADX INFO: renamed from: g */
    private float f19g;

    /* JADX INFO: renamed from: h */
    private float f20h;

    /* JADX INFO: renamed from: i */
    private float f21i;

    /* JADX INFO: renamed from: a */
    public static C0004c f27a = new C0004c();

    /* JADX INFO: renamed from: b */
    private FloatBuffer f14b = BufferUtils.createFloatBuffer(524288);

    /* JADX INFO: renamed from: c */
    private float[] f15c = new float[524288];

    /* JADX INFO: renamed from: d */
    private int f16d = 0;

    /* JADX INFO: renamed from: j */
    private boolean f22j = false;

    /* JADX INFO: renamed from: k */
    private boolean f23k = false;

    /* JADX INFO: renamed from: l */
    private int f24l = 3;

    /* JADX INFO: renamed from: m */
    private int f25m = 0;

    /* JADX INFO: renamed from: n */
    private boolean f26n = false;

    private C0004c() {
    }

    /* JADX INFO: renamed from: a */
    public final void m1a() {
        if (this.f16d > 0) {
            this.f14b.clear();
            this.f14b.put(this.f15c, 0, this.f25m);
            this.f14b.flip();
            if (this.f23k && this.f22j) {
                GL11.glInterleavedArrays(10794, 0, this.f14b);
            } else if (this.f23k) {
                GL11.glInterleavedArrays(10791, 0, this.f14b);
            } else if (this.f22j) {
                GL11.glInterleavedArrays(10788, 0, this.f14b);
            } else {
                GL11.glInterleavedArrays(10785, 0, this.f14b);
            }
            GL11.glEnableClientState(32884);
            if (this.f23k) {
                GL11.glEnableClientState(32888);
            }
            if (this.f22j) {
                GL11.glEnableClientState(32886);
            }
            GL11.glDrawArrays(7, 0, this.f16d);
            GL11.glDisableClientState(32884);
            if (this.f23k) {
                GL11.glDisableClientState(32888);
            }
            if (this.f22j) {
                GL11.glDisableClientState(32886);
            }
        }
        m2d();
    }

    /* JADX INFO: renamed from: d */
    private void m2d() {
        this.f16d = 0;
        this.f14b.clear();
        this.f25m = 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m3b() {
        m2d();
        this.f22j = false;
        this.f23k = false;
        this.f26n = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m4a(float f, float f2, float f3) {
        if (this.f26n) {
            return;
        }
        if (!this.f22j) {
            this.f24l += 3;
        }
        this.f22j = true;
        this.f19g = f;
        this.f20h = f2;
        this.f21i = f3;
    }

    /* JADX INFO: renamed from: a */
    public final void m5a(int i, int i2, int i3) {
        byte b = (byte) i;
        byte b2 = (byte) i2;
        byte b3 = (byte) i3;
        if (this.f26n) {
            return;
        }
        if (!this.f22j) {
            this.f24l += 3;
        }
        this.f22j = true;
        this.f19g = (b & 255) / 255.0f;
        this.f20h = (b2 & 255) / 255.0f;
        this.f21i = (b3 & 255) / 255.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m6a(float f, float f2, float f3, float f4, float f5) {
        if (!this.f23k) {
            this.f24l += 2;
        }
        this.f23k = true;
        this.f17e = f4;
        this.f18f = f5;
        m7b(f, f2, f3);
    }

    /* JADX INFO: renamed from: b */
    public final void m7b(float f, float f2, float f3) {
        if (this.f23k) {
            float[] fArr = this.f15c;
            int i = this.f25m;
            this.f25m = i + 1;
            fArr[i] = this.f17e;
            float[] fArr2 = this.f15c;
            int i2 = this.f25m;
            this.f25m = i2 + 1;
            fArr2[i2] = this.f18f;
        }
        if (this.f22j) {
            float[] fArr3 = this.f15c;
            int i3 = this.f25m;
            this.f25m = i3 + 1;
            fArr3[i3] = this.f19g;
            float[] fArr4 = this.f15c;
            int i4 = this.f25m;
            this.f25m = i4 + 1;
            fArr4[i4] = this.f20h;
            float[] fArr5 = this.f15c;
            int i5 = this.f25m;
            this.f25m = i5 + 1;
            fArr5[i5] = this.f21i;
        }
        float[] fArr6 = this.f15c;
        int i6 = this.f25m;
        this.f25m = i6 + 1;
        fArr6[i6] = f;
        float[] fArr7 = this.f15c;
        int i7 = this.f25m;
        this.f25m = i7 + 1;
        fArr7[i7] = f2;
        float[] fArr8 = this.f15c;
        int i8 = this.f25m;
        this.f25m = i8 + 1;
        fArr8[i8] = f3;
        this.f16d++;
        if (this.f16d % 4 != 0 || this.f25m < 524288 - (this.f24l << 2)) {
            return;
        }
        m1a();
    }

    /* JADX INFO: renamed from: a */
    public final void m8a(int i) {
        m5a((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    /* JADX INFO: renamed from: c */
    public final void m9c() {
        this.f26n = true;
    }
}
