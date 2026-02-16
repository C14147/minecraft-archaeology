package com.mojang.minecraft.gui;

import com.mojang.minecraft.renderer.Tesselator;
import com.mojang.minecraft.renderer.Textures;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/gui/Font.class */
public class Font {
    private int[] charWidths = new int[256];
    private int fontTexture;

    public Font(String name, Textures textures) {
        this.fontTexture = 0;
        try {
            BufferedImage img = ImageIO.read(Textures.class.getResourceAsStream(name));
            int w = img.getWidth();
            int h = img.getHeight();
            int[] rawPixels = new int[w * h];
            img.getRGB(0, 0, w, h, rawPixels, 0, w);
            for (int i = 0; i < 128; i++) {
                int xt = i % 16;
                int yt = i / 16;
                int x = 0;
                boolean emptyColumn = false;
                while (x < 8 && !emptyColumn) {
                    int xPixel = (xt * 8) + x;
                    emptyColumn = true;
                    for (int y = 0; y < 8 && emptyColumn; y++) {
                        int yPixel = ((yt * 8) + y) * w;
                        int pixel = rawPixels[xPixel + yPixel] & 255;
                        if (pixel > 128) {
                            emptyColumn = false;
                        }
                    }
                    x++;
                }
                if (i == 32) {
                    x = 4;
                }
                this.charWidths[i] = x;
            }
            this.fontTexture = textures.loadTexture(name, 9728);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawShadow(String str, int x, int y, int color) {
        draw(str, x + 1, y + 1, color, true);
        draw(str, x, y, color);
    }

    public void draw(String str, int x, int y, int color) {
        draw(str, x, y, color, false);
    }

    public void draw(String str, int x, int y, int color, boolean darken) {
        char[] chars = str.toCharArray();
        if (darken) {
            color = (color & 16579836) >> 2;
        }
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.fontTexture);
        Tesselator t = Tesselator.instance;
        t.init();
        t.color(color);
        int xo = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '&') {
                int cc = "0123456789abcdef".indexOf(chars[i + 1]);
                int br = (cc & 8) * 8;
                int b = ((cc & 1) * 191) + br;
                int g = (((cc & 2) >> 1) * 191) + br;
                int r = (((cc & 4) >> 2) * 191) + br;
                int color2 = (r << 16) | (g << 8) | b;
                i += 2;
                if (darken) {
                    color2 = (color2 & 16579836) >> 2;
                }
                t.color(color2);
            }
            int ix = (chars[i] % 16) * 8;
            int iy = (chars[i] / 16) * 8;
            t.vertexUV(x + xo, y + 8, 0.0f, ix / 128.0f, (iy + 8) / 128.0f);
            t.vertexUV(x + xo + 8, y + 8, 0.0f, (ix + 8) / 128.0f, (iy + 8) / 128.0f);
            t.vertexUV(x + xo + 8, y, 0.0f, (ix + 8) / 128.0f, iy / 128.0f);
            t.vertexUV(x + xo, y, 0.0f, ix / 128.0f, iy / 128.0f);
            xo += this.charWidths[chars[i]];
            i++;
        }
        t.flush();
        GL11.glDisable(3553);
    }

    public int width(String str) {
        char[] chars = str.toCharArray();
        int len = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '&') {
                i++;
            } else {
                len += this.charWidths[chars[i]];
            }
            i++;
        }
        return len;
    }
}
