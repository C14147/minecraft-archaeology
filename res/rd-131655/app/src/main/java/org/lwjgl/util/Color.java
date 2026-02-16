package org.lwjgl.util;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/Color.class */
public final class Color implements ReadableColor, Serializable, WritableColor {
    static final long serialVersionUID = 1;
    private byte red;
    private byte green;
    private byte blue;
    private byte alpha;

    public Color() {
        this(0, 0, 0, 255);
    }

    public Color(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public Color(byte r, byte g, byte b) {
        this(r, g, b, (byte) -1);
    }

    public Color(int r, int g, int b, int a) {
        set(r, g, b, a);
    }

    public Color(byte r, byte g, byte b, byte a) {
        set(r, g, b, a);
    }

    public Color(ReadableColor c) {
        setColor(c);
    }

    @Override // org.lwjgl.util.WritableColor
    public void set(int r, int g, int b, int a) {
        this.red = (byte) r;
        this.green = (byte) g;
        this.blue = (byte) b;
        this.alpha = (byte) a;
    }

    @Override // org.lwjgl.util.WritableColor
    public void set(byte r, byte g, byte b, byte a) {
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = a;
    }

    @Override // org.lwjgl.util.WritableColor
    public void set(int r, int g, int b) {
        set(r, g, b, 255);
    }

    @Override // org.lwjgl.util.WritableColor
    public void set(byte r, byte g, byte b) {
        set(r, g, b, (byte) -1);
    }

    @Override // org.lwjgl.util.ReadableColor
    public int getRed() {
        return this.red & 255;
    }

    @Override // org.lwjgl.util.ReadableColor
    public int getGreen() {
        return this.green & 255;
    }

    @Override // org.lwjgl.util.ReadableColor
    public int getBlue() {
        return this.blue & 255;
    }

    @Override // org.lwjgl.util.ReadableColor
    public int getAlpha() {
        return this.alpha & 255;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setRed(int red) {
        this.red = (byte) red;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setGreen(int green) {
        this.green = (byte) green;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setBlue(int blue) {
        this.blue = (byte) blue;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setAlpha(int alpha) {
        this.alpha = (byte) alpha;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setRed(byte red) {
        this.red = red;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setGreen(byte green) {
        this.green = green;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setBlue(byte blue) {
        this.blue = blue;
    }

    @Override // org.lwjgl.util.WritableColor
    public void setAlpha(byte alpha) {
        this.alpha = alpha;
    }

    public String toString() {
        return "Color [" + getRed() + ", " + getGreen() + ", " + getBlue() + ", " + getAlpha() + "]";
    }

    public boolean equals(Object o) {
        return o != null && (o instanceof ReadableColor) && ((ReadableColor) o).getRed() == getRed() && ((ReadableColor) o).getGreen() == getGreen() && ((ReadableColor) o).getBlue() == getBlue() && ((ReadableColor) o).getAlpha() == getAlpha();
    }

    public int hashCode() {
        return (this.red << 24) | (this.green << 16) | (this.blue << 8) | this.alpha;
    }

    @Override // org.lwjgl.util.ReadableColor
    public byte getAlphaByte() {
        return this.alpha;
    }

    @Override // org.lwjgl.util.ReadableColor
    public byte getBlueByte() {
        return this.blue;
    }

    @Override // org.lwjgl.util.ReadableColor
    public byte getGreenByte() {
        return this.green;
    }

    @Override // org.lwjgl.util.ReadableColor
    public byte getRedByte() {
        return this.red;
    }

    @Override // org.lwjgl.util.ReadableColor
    public void writeRGBA(ByteBuffer dest) {
        dest.put(this.red);
        dest.put(this.green);
        dest.put(this.blue);
        dest.put(this.alpha);
    }

    @Override // org.lwjgl.util.ReadableColor
    public void writeRGB(ByteBuffer dest) {
        dest.put(this.red);
        dest.put(this.green);
        dest.put(this.blue);
    }

    @Override // org.lwjgl.util.ReadableColor
    public void writeABGR(ByteBuffer dest) {
        dest.put(this.alpha);
        dest.put(this.blue);
        dest.put(this.green);
        dest.put(this.red);
    }

    @Override // org.lwjgl.util.ReadableColor
    public void writeARGB(ByteBuffer dest) {
        dest.put(this.alpha);
        dest.put(this.red);
        dest.put(this.green);
        dest.put(this.blue);
    }

    @Override // org.lwjgl.util.ReadableColor
    public void writeBGR(ByteBuffer dest) {
        dest.put(this.blue);
        dest.put(this.green);
        dest.put(this.red);
    }

    @Override // org.lwjgl.util.ReadableColor
    public void writeBGRA(ByteBuffer dest) {
        dest.put(this.blue);
        dest.put(this.green);
        dest.put(this.red);
        dest.put(this.alpha);
    }

    @Override // org.lwjgl.util.WritableColor
    public void readRGBA(ByteBuffer src) {
        this.red = src.get();
        this.green = src.get();
        this.blue = src.get();
        this.alpha = src.get();
    }

    @Override // org.lwjgl.util.WritableColor
    public void readRGB(ByteBuffer src) {
        this.red = src.get();
        this.green = src.get();
        this.blue = src.get();
    }

    @Override // org.lwjgl.util.WritableColor
    public void readARGB(ByteBuffer src) {
        this.alpha = src.get();
        this.red = src.get();
        this.green = src.get();
        this.blue = src.get();
    }

    @Override // org.lwjgl.util.WritableColor
    public void readBGRA(ByteBuffer src) {
        this.blue = src.get();
        this.green = src.get();
        this.red = src.get();
        this.alpha = src.get();
    }

    @Override // org.lwjgl.util.WritableColor
    public void readBGR(ByteBuffer src) {
        this.blue = src.get();
        this.green = src.get();
        this.red = src.get();
    }

    @Override // org.lwjgl.util.WritableColor
    public void readABGR(ByteBuffer src) {
        this.alpha = src.get();
        this.blue = src.get();
        this.green = src.get();
        this.red = src.get();
    }

    @Override // org.lwjgl.util.WritableColor
    public void setColor(ReadableColor src) {
        this.red = src.getRedByte();
        this.green = src.getGreenByte();
        this.blue = src.getBlueByte();
        this.alpha = src.getAlphaByte();
    }

    public void fromHSB(float hue, float saturation, float brightness) {
        if (saturation == 0.0f) {
            byte b = (byte) ((brightness * 255.0f) + 0.5f);
            this.blue = b;
            this.green = b;
            this.red = b;
            return;
        }
        float f3 = (hue - ((float) Math.floor(hue))) * 6.0f;
        float f4 = f3 - ((float) Math.floor(f3));
        float f5 = brightness * (1.0f - saturation);
        float f6 = brightness * (1.0f - (saturation * f4));
        float f7 = brightness * (1.0f - (saturation * (1.0f - f4)));
        switch ((int) f3) {
            case 0:
                this.red = (byte) ((brightness * 255.0f) + 0.5f);
                this.green = (byte) ((f7 * 255.0f) + 0.5f);
                this.blue = (byte) ((f5 * 255.0f) + 0.5f);
                break;
            case 1:
                this.red = (byte) ((f6 * 255.0f) + 0.5f);
                this.green = (byte) ((brightness * 255.0f) + 0.5f);
                this.blue = (byte) ((f5 * 255.0f) + 0.5f);
                break;
            case 2:
                this.red = (byte) ((f5 * 255.0f) + 0.5f);
                this.green = (byte) ((brightness * 255.0f) + 0.5f);
                this.blue = (byte) ((f7 * 255.0f) + 0.5f);
                break;
            case 3:
                this.red = (byte) ((f5 * 255.0f) + 0.5f);
                this.green = (byte) ((f6 * 255.0f) + 0.5f);
                this.blue = (byte) ((brightness * 255.0f) + 0.5f);
                break;
            case 4:
                this.red = (byte) ((f7 * 255.0f) + 0.5f);
                this.green = (byte) ((f5 * 255.0f) + 0.5f);
                this.blue = (byte) ((brightness * 255.0f) + 0.5f);
                break;
            case 5:
                this.red = (byte) ((brightness * 255.0f) + 0.5f);
                this.green = (byte) ((f5 * 255.0f) + 0.5f);
                this.blue = (byte) ((f6 * 255.0f) + 0.5f);
                break;
        }
    }

    public float[] toHSB(float[] dest) {
        float saturation;
        float hue;
        float hue2;
        int r = getRed();
        int g = getGreen();
        int b = getBlue();
        if (dest == null) {
            dest = new float[3];
        }
        int l = r <= g ? g : r;
        if (b > l) {
            l = b;
        }
        int i1 = r >= g ? g : r;
        if (b < i1) {
            i1 = b;
        }
        float brightness = l / 255.0f;
        if (l != 0) {
            saturation = (l - i1) / l;
        } else {
            saturation = 0.0f;
        }
        if (saturation == 0.0f) {
            hue2 = 0.0f;
        } else {
            float f3 = (l - r) / (l - i1);
            float f4 = (l - g) / (l - i1);
            float f5 = (l - b) / (l - i1);
            if (r == l) {
                hue = f5 - f4;
            } else if (g == l) {
                hue = (2.0f + f3) - f5;
            } else {
                hue = (4.0f + f4) - f3;
            }
            hue2 = hue / 6.0f;
            if (hue2 < 0.0f) {
                hue2 += 1.0f;
            }
        }
        dest[0] = hue2;
        dest[1] = saturation;
        dest[2] = brightness;
        return dest;
    }
}
