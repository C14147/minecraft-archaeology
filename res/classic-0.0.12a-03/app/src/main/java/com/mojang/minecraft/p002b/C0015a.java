package com.mojang.minecraft.p002b;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: renamed from: com.mojang.minecraft.b.a */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/b/a.class */
public class C0015a {

    /* JADX INFO: renamed from: a */
    private HashMap f83a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final int m45a(String str, int i) {
        try {
            if (this.f83a.containsKey(str)) {
                return ((Integer) this.f83a.get(str)).intValue();
            }
            IntBuffer intBufferCreateIntBuffer = BufferUtils.createIntBuffer(1);
            intBufferCreateIntBuffer.clear();
            GL11.glGenTextures(intBufferCreateIntBuffer);
            int i2 = intBufferCreateIntBuffer.get(0);
            this.f83a.put(str, Integer.valueOf(i2));
            GL11.glBindTexture(3553, i2);
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
            BufferedImage bufferedImage = ImageIO.read(C0015a.class.getResourceAsStream(str));
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            ByteBuffer byteBufferCreateByteBuffer = BufferUtils.createByteBuffer((width * height) << 2);
            int[] iArr = new int[width * height];
            bufferedImage.getRGB(0, 0, width, height, iArr, 0, width);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int i4 = iArr[i3] >>> 24;
                iArr[i3] = (i4 << 24) | ((iArr[i3] & 255) << 16) | (((iArr[i3] >> 8) & 255) << 8) | ((iArr[i3] >> 16) & 255);
            }
            byteBufferCreateByteBuffer.asIntBuffer().put(iArr);
            GLU.gluBuild2DMipmaps(3553, 6408, width, height, 6408, 5121, byteBufferCreateByteBuffer);
            return i2;
        } catch (IOException unused) {
            throw new RuntimeException("!!");
        }
    }
}
