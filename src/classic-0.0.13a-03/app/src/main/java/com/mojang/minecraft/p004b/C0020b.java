package com.mojang.minecraft.p004b;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.b */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/b/b.class */
public final class C0020b {

    /* JADX INFO: renamed from: e */
    private float f94e;

    /* JADX INFO: renamed from: f */
    private float f95f;

    /* JADX INFO: renamed from: g */
    private float f96g;

    /* JADX INFO: renamed from: h */
    private float f97h;

    /* JADX INFO: renamed from: i */
    private float f98i;

    /* JADX INFO: renamed from: a */
    public static C0020b f104a = new C0020b();

    /* JADX INFO: renamed from: b */
    private FloatBuffer f91b = BufferUtils.createFloatBuffer(524288);

    /* JADX INFO: renamed from: c */
    private float[] f92c = new float[524288];

    /* JADX INFO: renamed from: d */
    private int f93d = 0;

    /* JADX INFO: renamed from: j */
    private boolean f99j = false;

    /* JADX INFO: renamed from: k */
    private boolean f100k = false;

    /* JADX INFO: renamed from: l */
    private int f101l = 3;

    /* JADX INFO: renamed from: m */
    private int f102m = 0;

    /* JADX INFO: renamed from: n */
    private boolean f103n = false;

    private C0020b() {
    }

    /* JADX INFO: renamed from: a */
    public final void m56a() {
        if (this.f93d > 0) {
            this.f91b.clear();
            this.f91b.put(this.f92c, 0, this.f102m);
            this.f91b.flip();
            if (this.f100k && this.f99j) {
                GL11.glInterleavedArrays(10794, 0, this.f91b);
            } else if (this.f100k) {
                GL11.glInterleavedArrays(10791, 0, this.f91b);
            } else if (this.f99j) {
                GL11.glInterleavedArrays(10788, 0, this.f91b);
            } else {
                GL11.glInterleavedArrays(10785, 0, this.f91b);
            }
            GL11.glEnableClientState(32884);
            if (this.f100k) {
                GL11.glEnableClientState(32888);
            }
            if (this.f99j) {
                GL11.glEnableClientState(32886);
            }
            GL11.glDrawArrays(7, 0, this.f93d);
            GL11.glDisableClientState(32884);
            if (this.f100k) {
                GL11.glDisableClientState(32888);
            }
            if (this.f99j) {
                GL11.glDisableClientState(32886);
            }
        }
        m57d();
    }

    /* JADX INFO: renamed from: d */
    private void m57d() {
        this.f93d = 0;
        this.f91b.clear();
        this.f102m = 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m58b() {
        m57d();
        this.f99j = false;
        this.f100k = false;
        this.f103n = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m59a(int i, int i2, int i3) {
        m60a((byte) i, (byte) i2, (byte) i3);
    }

    /* JADX INFO: renamed from: a */
    public final void m60a(byte b, byte b2, byte b3) {
        if (this.f103n) {
            return;
        }
        if (!this.f99j) {
            this.f101l += 3;
        }
        this.f99j = true;
        this.f96g = (b & 255) / 255.0f;
        this.f97h = (b2 & 255) / 255.0f;
        this.f98i = (b3 & 255) / 255.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m61a(float f, float f2, float f3, float f4, float f5) {
        if (!this.f100k) {
            this.f101l += 2;
        }
        this.f100k = true;
        this.f94e = f4;
        this.f95f = f5;
        m62a(f, f2, f3);
    }

    /* JADX INFO: renamed from: a */
    public final void m62a(float f, float f2, float f3) {
        if (this.f100k) {
            float[] fArr = this.f92c;
            int i = this.f102m;
            this.f102m = i + 1;
            fArr[i] = this.f94e;
            float[] fArr2 = this.f92c;
            int i2 = this.f102m;
            this.f102m = i2 + 1;
            fArr2[i2] = this.f95f;
        }
        if (this.f99j) {
            float[] fArr3 = this.f92c;
            int i3 = this.f102m;
            this.f102m = i3 + 1;
            fArr3[i3] = this.f96g;
            float[] fArr4 = this.f92c;
            int i4 = this.f102m;
            this.f102m = i4 + 1;
            fArr4[i4] = this.f97h;
            float[] fArr5 = this.f92c;
            int i5 = this.f102m;
            this.f102m = i5 + 1;
            fArr5[i5] = this.f98i;
        }
        float[] fArr6 = this.f92c;
        int i6 = this.f102m;
        this.f102m = i6 + 1;
        fArr6[i6] = f;
        float[] fArr7 = this.f92c;
        int i7 = this.f102m;
        this.f102m = i7 + 1;
        fArr7[i7] = f2;
        float[] fArr8 = this.f92c;
        int i8 = this.f102m;
        this.f102m = i8 + 1;
        fArr8[i8] = f3;
        this.f93d++;
        if (this.f93d % 4 != 0 || this.f102m < 524288 - (this.f101l << 2)) {
            return;
        }
        m56a();
    }

    /* JADX INFO: renamed from: a */
    public final void m63a(int i) {
        m59a((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    /* JADX INFO: renamed from: c */
    public final void m64c() {
        this.f103n = true;
    }
}
