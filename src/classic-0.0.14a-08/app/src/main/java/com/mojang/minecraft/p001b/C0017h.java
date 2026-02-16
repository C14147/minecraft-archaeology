package com.mojang.minecraft.p001b;

import com.mojang.minecraft.p000a.C0002a;
import com.mojang.minecraft.p000a.C0004c;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.h */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/b/h.class */
public final class C0017h {

    /* JADX INFO: renamed from: a */
    private int[] f94a = new int[256];

    /* JADX INFO: renamed from: b */
    private int f95b;

    public C0017h(String str, C0002a c0002a) {
        this.f95b = 0;
        try {
            BufferedImage bufferedImage = ImageIO.read(C0002a.class.getResourceAsStream(str));
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            int[] iArr = new int[width * height];
            bufferedImage.getRGB(0, 0, width, height, iArr, 0, width);
            for (int i = 0; i < 128; i++) {
                int i2 = i % 16;
                int i3 = i / 16;
                int i4 = 0;
                boolean z = false;
                while (i4 < 8 && !z) {
                    int i5 = (i2 << 3) + i4;
                    z = true;
                    for (int i6 = 0; i6 < 8 && z; i6++) {
                        if ((iArr[i5 + (((i3 << 3) + i6) * width)] & 255) > 128) {
                            z = false;
                        }
                    }
                    i4++;
                }
                if (i == 32) {
                    i4 = 4;
                }
                this.f94a[i] = i4;
            }
            this.f95b = c0002a.m0a(str, 9728);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m43a(String str, int i, int i2, int i3) {
        m44a(str, i + 1, i2 + 1, i3, true);
        m44a(str, i, i2, i3, false);
    }

    /* JADX INFO: renamed from: a */
    private void m44a(String str, int i, int i2, int i3, boolean z) {
        char[] charArray = str.toCharArray();
        if (z) {
            i3 = (i3 & 16579836) >> 2;
        }
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f95b);
        C0004c c0004c = C0004c.f27a;
        c0004c.m3b();
        c0004c.m8a(i3);
        int i4 = 0;
        int i5 = 0;
        while (i5 < charArray.length) {
            if (charArray[i5] == '&') {
                int iIndexOf = "0123456789abcdef".indexOf(charArray[i5 + 1]);
                int i6 = (iIndexOf & 8) << 3;
                int i7 = (((((iIndexOf & 4) >> 2) * 191) + i6) << 16) | (((((iIndexOf & 2) >> 1) * 191) + i6) << 8) | (((iIndexOf & 1) * 191) + i6);
                i5 += 2;
                if (z) {
                    i7 = (i7 & 16579836) >> 2;
                }
                c0004c.m8a(i7);
            }
            int i8 = (charArray[i5] % 16) << 3;
            int i9 = (charArray[i5] / 16) << 3;
            c0004c.m6a(i + i4, i2 + 8, 0.0f, i8 / 128.0f, (i9 + 8) / 128.0f);
            c0004c.m6a(i + i4 + 8, i2 + 8, 0.0f, (i8 + 8) / 128.0f, (i9 + 8) / 128.0f);
            c0004c.m6a(i + i4 + 8, i2, 0.0f, (i8 + 8) / 128.0f, i9 / 128.0f);
            c0004c.m6a(i + i4, i2, 0.0f, i8 / 128.0f, i9 / 128.0f);
            i4 += this.f94a[charArray[i5]];
            i5++;
        }
        c0004c.m1a();
        GL11.glDisable(3553);
    }

    /* JADX INFO: renamed from: a */
    public final int m45a(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        while (i2 < charArray.length) {
            if (charArray[i2] == '&') {
                i2++;
            } else {
                i += this.f94a[charArray[i2]];
            }
            i2++;
        }
        return i;
    }
}
