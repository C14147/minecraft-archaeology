package com.mojang.minecraft.p002b;

import com.mojang.minecraft.p001a.C0003a;
import com.mojang.minecraft.p001a.C0005c;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.j */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/j.class */
public final class C0020j {

    /* JADX INFO: renamed from: a */
    private int[] f102a = new int[256];

    /* JADX INFO: renamed from: b */
    private int f103b;

    public C0020j(String str, C0003a c0003a) {
        this.f103b = 0;
        try {
            BufferedImage bufferedImage = ImageIO.read(C0003a.class.getResourceAsStream(str));
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
                this.f102a[i] = i4;
            }
            this.f103b = c0003a.m4a(str, 9728);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m47a(String str, int i, int i2, int i3) {
        m49a(str, i + 1, i2 + 1, i3, true);
        m48b(str, i, i2, i3);
    }

    /* JADX INFO: renamed from: b */
    public final void m48b(String str, int i, int i2, int i3) {
        m49a(str, i, i2, i3, false);
    }

    /* JADX INFO: renamed from: a */
    private void m49a(String str, int i, int i2, int i3, boolean z) {
        char[] charArray = str.toCharArray();
        if (z) {
            i3 = (i3 & 16579836) >> 2;
        }
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f103b);
        C0005c c0005c = C0005c.f35a;
        c0005c.m7b();
        c0005c.m12a(i3);
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
                c0005c.m12a(i7);
            }
            int i8 = (charArray[i5] % 16) << 3;
            int i9 = (charArray[i5] / 16) << 3;
            c0005c.m10a(i + i4, i2 + 7.99f, 0.0f, i8 / 128.0f, (i9 + 7.99f) / 128.0f);
            c0005c.m10a(i + i4 + 7.99f, i2 + 7.99f, 0.0f, (i8 + 7.99f) / 128.0f, (i9 + 7.99f) / 128.0f);
            c0005c.m10a(i + i4 + 7.99f, i2, 0.0f, (i8 + 7.99f) / 128.0f, i9 / 128.0f);
            c0005c.m10a(i + i4, i2, 0.0f, i8 / 128.0f, i9 / 128.0f);
            i4 += this.f102a[charArray[i5]];
            i5++;
        }
        c0005c.m5a();
        GL11.glDisable(3553);
    }

    /* JADX INFO: renamed from: a */
    public final int m50a(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        while (i2 < charArray.length) {
            if (charArray[i2] == '&') {
                i2++;
            } else {
                i += this.f102a[charArray[i2]];
            }
            i2++;
        }
        return i;
    }
}
