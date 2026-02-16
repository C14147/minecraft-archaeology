package com.mojang.minecraft.p001a;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.c */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/a/c.class */
public final class C0005c {

    /* JADX INFO: renamed from: e */
    private float f25e;

    /* JADX INFO: renamed from: f */
    private float f26f;

    /* JADX INFO: renamed from: g */
    private float f27g;

    /* JADX INFO: renamed from: h */
    private float f28h;

    /* JADX INFO: renamed from: i */
    private float f29i;

    /* JADX INFO: renamed from: a */
    public static C0005c f35a = new C0005c();

    /* JADX INFO: renamed from: b */
    private FloatBuffer f22b = BufferUtils.createFloatBuffer(524288);

    /* JADX INFO: renamed from: c */
    private float[] f23c = new float[524288];

    /* JADX INFO: renamed from: d */
    private int f24d = 0;

    /* JADX INFO: renamed from: j */
    private boolean f30j = false;

    /* JADX INFO: renamed from: k */
    private boolean f31k = false;

    /* JADX INFO: renamed from: l */
    private int f32l = 3;

    /* JADX INFO: renamed from: m */
    private int f33m = 0;

    /* JADX INFO: renamed from: n */
    private boolean f34n = false;

    private C0005c() {
    }

    /* JADX INFO: renamed from: a */
    public final void m5a() {
        if (this.f24d > 0) {
            this.f22b.clear();
            this.f22b.put(this.f23c, 0, this.f33m);
            this.f22b.flip();
            if (this.f31k && this.f30j) {
                GL11.glInterleavedArrays(10794, 0, this.f22b);
            } else if (this.f31k) {
                GL11.glInterleavedArrays(10791, 0, this.f22b);
            } else if (this.f30j) {
                GL11.glInterleavedArrays(10788, 0, this.f22b);
            } else {
                GL11.glInterleavedArrays(10785, 0, this.f22b);
            }
            GL11.glEnableClientState(32884);
            if (this.f31k) {
                GL11.glEnableClientState(32888);
            }
            if (this.f30j) {
                GL11.glEnableClientState(32886);
            }
            GL11.glDrawArrays(7, 0, this.f24d);
            GL11.glDisableClientState(32884);
            if (this.f31k) {
                GL11.glDisableClientState(32888);
            }
            if (this.f30j) {
                GL11.glDisableClientState(32886);
            }
        }
        m6d();
    }

    /* JADX INFO: renamed from: d */
    private void m6d() {
        this.f24d = 0;
        this.f22b.clear();
        this.f33m = 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m7b() {
        m6d();
        this.f30j = false;
        this.f31k = false;
        this.f34n = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m8a(float f, float f2, float f3) {
        if (this.f34n) {
            return;
        }
        if (!this.f30j) {
            this.f32l += 3;
        }
        this.f30j = true;
        this.f27g = f;
        this.f28h = f2;
        this.f29i = f3;
    }

    /* JADX INFO: renamed from: a */
    public final void m9a(int i, int i2, int i3) {
        byte b = (byte) i;
        byte b2 = (byte) i2;
        byte b3 = (byte) i3;
        if (this.f34n) {
            return;
        }
        if (!this.f30j) {
            this.f32l += 3;
        }
        this.f30j = true;
        this.f27g = (b & 255) / 255.0f;
        this.f28h = (b2 & 255) / 255.0f;
        this.f29i = (b3 & 255) / 255.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m10a(float f, float f2, float f3, float f4, float f5) {
        if (!this.f31k) {
            this.f32l += 2;
        }
        this.f31k = true;
        this.f25e = f4;
        this.f26f = f5;
        m11b(f, f2, f3);
    }

    /* JADX INFO: renamed from: b */
    public final void m11b(float f, float f2, float f3) {
        if (this.f31k) {
            float[] fArr = this.f23c;
            int i = this.f33m;
            this.f33m = i + 1;
            fArr[i] = this.f25e;
            float[] fArr2 = this.f23c;
            int i2 = this.f33m;
            this.f33m = i2 + 1;
            fArr2[i2] = this.f26f;
        }
        if (this.f30j) {
            float[] fArr3 = this.f23c;
            int i3 = this.f33m;
            this.f33m = i3 + 1;
            fArr3[i3] = this.f27g;
            float[] fArr4 = this.f23c;
            int i4 = this.f33m;
            this.f33m = i4 + 1;
            fArr4[i4] = this.f28h;
            float[] fArr5 = this.f23c;
            int i5 = this.f33m;
            this.f33m = i5 + 1;
            fArr5[i5] = this.f29i;
        }
        float[] fArr6 = this.f23c;
        int i6 = this.f33m;
        this.f33m = i6 + 1;
        fArr6[i6] = f;
        float[] fArr7 = this.f23c;
        int i7 = this.f33m;
        this.f33m = i7 + 1;
        fArr7[i7] = f2;
        float[] fArr8 = this.f23c;
        int i8 = this.f33m;
        this.f33m = i8 + 1;
        fArr8[i8] = f3;
        this.f24d++;
        if (this.f24d % 4 != 0 || this.f33m < 524288 - (this.f32l << 2)) {
            return;
        }
        m5a();
    }

    /* JADX INFO: renamed from: a */
    public final void m12a(int i) {
        m9a((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    /* JADX INFO: renamed from: c */
    public final void m13c() {
        this.f34n = true;
    }
}
