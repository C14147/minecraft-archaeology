package com.mojang.minecraft.p002b;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.b */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/b/b.class */
public final class C0016b {

    /* JADX INFO: renamed from: e */
    private float f87e;

    /* JADX INFO: renamed from: f */
    private float f88f;

    /* JADX INFO: renamed from: g */
    private float f89g;

    /* JADX INFO: renamed from: h */
    private float f90h;

    /* JADX INFO: renamed from: i */
    private float f91i;

    /* JADX INFO: renamed from: a */
    public static C0016b f97a = new C0016b();

    /* JADX INFO: renamed from: b */
    private FloatBuffer f84b = BufferUtils.createFloatBuffer(524288);

    /* JADX INFO: renamed from: c */
    private float[] f85c = new float[524288];

    /* JADX INFO: renamed from: d */
    private int f86d = 0;

    /* JADX INFO: renamed from: j */
    private boolean f92j = false;

    /* JADX INFO: renamed from: k */
    private boolean f93k = false;

    /* JADX INFO: renamed from: l */
    private int f94l = 3;

    /* JADX INFO: renamed from: m */
    private int f95m = 0;

    /* JADX INFO: renamed from: n */
    private boolean f96n = false;

    private C0016b() {
    }

    /* JADX INFO: renamed from: a */
    public final void m46a() {
        if (this.f86d > 0) {
            this.f84b.clear();
            this.f84b.put(this.f85c, 0, this.f95m);
            this.f84b.flip();
            if (this.f93k && this.f92j) {
                GL11.glInterleavedArrays(10794, 0, this.f84b);
            } else if (this.f93k) {
                GL11.glInterleavedArrays(10791, 0, this.f84b);
            } else if (this.f92j) {
                GL11.glInterleavedArrays(10788, 0, this.f84b);
            } else {
                GL11.glInterleavedArrays(10785, 0, this.f84b);
            }
            GL11.glEnableClientState(32884);
            if (this.f93k) {
                GL11.glEnableClientState(32888);
            }
            if (this.f92j) {
                GL11.glEnableClientState(32886);
            }
            GL11.glDrawArrays(7, 0, this.f86d);
            GL11.glDisableClientState(32884);
            if (this.f93k) {
                GL11.glDisableClientState(32888);
            }
            if (this.f92j) {
                GL11.glDisableClientState(32886);
            }
        }
        m47d();
    }

    /* JADX INFO: renamed from: d */
    private void m47d() {
        this.f86d = 0;
        this.f84b.clear();
        this.f95m = 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m48b() {
        m47d();
        this.f92j = false;
        this.f93k = false;
        this.f96n = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m49a(int i, int i2, int i3) {
        m50a((byte) i, (byte) i2, (byte) i3);
    }

    /* JADX INFO: renamed from: a */
    public final void m50a(byte b, byte b2, byte b3) {
        if (this.f96n) {
            return;
        }
        if (!this.f92j) {
            this.f94l += 3;
        }
        this.f92j = true;
        this.f89g = (b & 255) / 255.0f;
        this.f90h = (b2 & 255) / 255.0f;
        this.f91i = (b3 & 255) / 255.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m51a(float f, float f2, float f3, float f4, float f5) {
        if (!this.f93k) {
            this.f94l += 2;
        }
        this.f93k = true;
        this.f87e = f4;
        this.f88f = f5;
        m52a(f, f2, f3);
    }

    /* JADX INFO: renamed from: a */
    public final void m52a(float f, float f2, float f3) {
        if (this.f93k) {
            float[] fArr = this.f85c;
            int i = this.f95m;
            this.f95m = i + 1;
            fArr[i] = this.f87e;
            float[] fArr2 = this.f85c;
            int i2 = this.f95m;
            this.f95m = i2 + 1;
            fArr2[i2] = this.f88f;
        }
        if (this.f92j) {
            float[] fArr3 = this.f85c;
            int i3 = this.f95m;
            this.f95m = i3 + 1;
            fArr3[i3] = this.f89g;
            float[] fArr4 = this.f85c;
            int i4 = this.f95m;
            this.f95m = i4 + 1;
            fArr4[i4] = this.f90h;
            float[] fArr5 = this.f85c;
            int i5 = this.f95m;
            this.f95m = i5 + 1;
            fArr5[i5] = this.f91i;
        }
        float[] fArr6 = this.f85c;
        int i6 = this.f95m;
        this.f95m = i6 + 1;
        fArr6[i6] = f;
        float[] fArr7 = this.f85c;
        int i7 = this.f95m;
        this.f95m = i7 + 1;
        fArr7[i7] = f2;
        float[] fArr8 = this.f85c;
        int i8 = this.f95m;
        this.f95m = i8 + 1;
        fArr8[i8] = f3;
        this.f86d++;
        if (this.f86d % 4 != 0 || this.f95m < 524288 - (this.f94l << 2)) {
            return;
        }
        m46a();
    }

    /* JADX INFO: renamed from: a */
    public final void m53a(int i) {
        m49a((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    /* JADX INFO: renamed from: c */
    public final void m54c() {
        this.f96n = true;
    }
}
