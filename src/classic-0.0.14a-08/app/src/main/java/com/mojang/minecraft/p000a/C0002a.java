package com.mojang.minecraft.p000a;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/a/a.class */
public class C0002a {

    /* JADX INFO: renamed from: a */
    private HashMap f12a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final int m0a(String str, int i) {
        try {
            if (this.f12a.containsKey(str)) {
                return ((Integer) this.f12a.get(str)).intValue();
            }
            IntBuffer intBufferCreateIntBuffer = BufferUtils.createIntBuffer(1);
            intBufferCreateIntBuffer.clear();
            GL11.glGenTextures(intBufferCreateIntBuffer);
            int i2 = intBufferCreateIntBuffer.get(0);
            this.f12a.put(str, Integer.valueOf(i2));
            GL11.glBindTexture(3553, i2);
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
            BufferedImage bufferedImage = ImageIO.read(C0002a.class.getResourceAsStream(str));
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            ByteBuffer byteBufferCreateByteBuffer = BufferUtils.createByteBuffer((width * height) << 2);
            int[] iArr = new int[width * height];
            byte[] bArr = new byte[(width * height) << 2];
            bufferedImage.getRGB(0, 0, width, height, iArr, 0, width);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int i4 = iArr[i3] >>> 24;
                int i5 = (iArr[i3] >> 16) & 255;
                int i6 = (iArr[i3] >> 8) & 255;
                int i7 = iArr[i3] & 255;
                bArr[i3 << 2] = (byte) i5;
                bArr[(i3 << 2) + 1] = (byte) i6;
                bArr[(i3 << 2) + 2] = (byte) i7;
                bArr[(i3 << 2) + 3] = (byte) i4;
            }
            byteBufferCreateByteBuffer.put(bArr);
            byteBufferCreateByteBuffer.position(0).limit(bArr.length);
            GLU.gluBuild2DMipmaps(3553, 6408, width, height, 6408, 5121, byteBufferCreateByteBuffer);
            return i2;
        } catch (IOException unused) {
            throw new RuntimeException("!!");
        }
    }
}
