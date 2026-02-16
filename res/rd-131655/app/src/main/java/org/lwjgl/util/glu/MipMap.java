package org.lwjgl.util.glu;

import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/MipMap.class */
public class MipMap extends Util {
    public static int gluBuild2DMipmaps(int target, int components, int width, int height, int format, int type, ByteBuffer data) {
        ByteBuffer image;
        ByteBuffer newImage;
        if (width < 1 || height < 1) {
            return 100901;
        }
        int bpp = bytesPerPixel(format, type);
        if (bpp == 0) {
            return 100900;
        }
        int maxSize = glGetIntegerv(GL11.GL_MAX_TEXTURE_SIZE);
        int w = nearestPower(width);
        if (w > maxSize) {
            w = maxSize;
        }
        int h = nearestPower(height);
        if (h > maxSize) {
            h = maxSize;
        }
        PixelStoreState pss = new PixelStoreState();
        GL11.glPixelStorei(GL11.GL_PACK_ROW_LENGTH, 0);
        GL11.glPixelStorei(GL11.GL_PACK_ALIGNMENT, 1);
        GL11.glPixelStorei(GL11.GL_PACK_SKIP_ROWS, 0);
        GL11.glPixelStorei(GL11.GL_PACK_SKIP_PIXELS, 0);
        int retVal = 0;
        boolean done = false;
        if (w != width || h != height) {
            image = BufferUtils.createByteBuffer((w + 4) * h * bpp);
            int error = gluScaleImage(format, width, height, type, data, w, h, type, image);
            if (error != 0) {
                retVal = error;
                done = true;
            }
            GL11.glPixelStorei(GL11.GL_UNPACK_ROW_LENGTH, 0);
            GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
            GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_ROWS, 0);
            GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_PIXELS, 0);
        } else {
            image = data;
        }
        ByteBuffer bufferA = null;
        ByteBuffer bufferB = null;
        int level = 0;
        while (!done) {
            if (image != data) {
                GL11.glPixelStorei(GL11.GL_UNPACK_ROW_LENGTH, 0);
                GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
                GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_ROWS, 0);
                GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_PIXELS, 0);
            }
            GL11.glTexImage2D(target, level, components, w, h, 0, format, type, image);
            if (w == 1 && h == 1) {
                break;
            }
            int newW = w < 2 ? 1 : w >> 1;
            int newH = h < 2 ? 1 : h >> 1;
            if (bufferA == null) {
                ByteBuffer byteBufferCreateByteBuffer = BufferUtils.createByteBuffer((newW + 4) * newH * bpp);
                bufferA = byteBufferCreateByteBuffer;
                newImage = byteBufferCreateByteBuffer;
            } else if (bufferB == null) {
                ByteBuffer byteBufferCreateByteBuffer2 = BufferUtils.createByteBuffer((newW + 4) * newH * bpp);
                bufferB = byteBufferCreateByteBuffer2;
                newImage = byteBufferCreateByteBuffer2;
            } else {
                newImage = bufferB;
            }
            int error2 = gluScaleImage(format, w, h, type, image, newW, newH, type, newImage);
            if (error2 != 0) {
                retVal = error2;
                done = true;
            }
            image = newImage;
            if (bufferB != null) {
                bufferB = bufferA;
            }
            w = newW;
            h = newH;
            level++;
        }
        pss.save();
        return retVal;
    }

    public static int gluScaleImage(int format, int widthIn, int heightIn, int typein, ByteBuffer dataIn, int widthOut, int heightOut, int typeOut, ByteBuffer dataOut) {
        int sizein;
        int sizeout;
        int rowlen;
        int rowstride;
        int rowlen2;
        int rowstride2;
        int components = compPerPix(format);
        if (components == -1) {
            return 100900;
        }
        float[] tempIn = new float[widthIn * heightIn * components];
        float[] tempOut = new float[widthOut * heightOut * components];
        switch (typein) {
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
                sizein = 1;
                break;
            case GL11.GL_FLOAT /* 5126 */:
                sizein = 4;
                break;
            default:
                return GL11.GL_INVALID_ENUM;
        }
        switch (typeOut) {
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
                sizeout = 1;
                break;
            case GL11.GL_FLOAT /* 5126 */:
                sizeout = 4;
                break;
            default:
                return GL11.GL_INVALID_ENUM;
        }
        PixelStoreState pss = new PixelStoreState();
        if (pss.unpackRowLength > 0) {
            rowlen = pss.unpackRowLength;
        } else {
            rowlen = widthIn;
        }
        if (sizein >= pss.unpackAlignment) {
            rowstride = components * rowlen;
        } else {
            rowstride = (pss.unpackAlignment / sizein) * ceil(components * rowlen * sizein, pss.unpackAlignment);
        }
        switch (typein) {
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
                int k = 0;
                dataIn.rewind();
                for (int i = 0; i < heightIn; i++) {
                    int ubptr = (i * rowstride) + (pss.unpackSkipRows * rowstride) + (pss.unpackSkipPixels * components);
                    for (int j = 0; j < widthIn * components; j++) {
                        int i2 = k;
                        k++;
                        int i3 = ubptr;
                        ubptr++;
                        tempIn[i2] = dataIn.get(i3) & 255;
                    }
                }
                break;
            case GL11.GL_FLOAT /* 5126 */:
                int k2 = 0;
                dataIn.rewind();
                for (int i4 = 0; i4 < heightIn; i4++) {
                    int fptr = 4 * ((i4 * rowstride) + (pss.unpackSkipRows * rowstride) + (pss.unpackSkipPixels * components));
                    for (int j2 = 0; j2 < widthIn * components; j2++) {
                        int i5 = k2;
                        k2++;
                        tempIn[i5] = dataIn.getFloat(fptr);
                        fptr += 4;
                    }
                }
                break;
            default:
                return 100900;
        }
        float sx = widthIn / widthOut;
        float sy = heightIn / heightOut;
        float[] c = new float[components];
        for (int iy = 0; iy < heightOut; iy++) {
            for (int ix = 0; ix < widthOut; ix++) {
                int x0 = (int) (ix * sx);
                int x1 = (int) ((ix + 1) * sx);
                int y0 = (int) (iy * sy);
                int y1 = (int) ((iy + 1) * sy);
                int readPix = 0;
                for (int ic = 0; ic < components; ic++) {
                    c[ic] = 0.0f;
                }
                for (int ix0 = x0; ix0 < x1; ix0++) {
                    for (int iy0 = y0; iy0 < y1; iy0++) {
                        int src = ((iy0 * widthIn) + ix0) * components;
                        for (int ic2 = 0; ic2 < components; ic2++) {
                            int i6 = ic2;
                            c[i6] = c[i6] + tempIn[src + ic2];
                        }
                        readPix++;
                    }
                }
                int dst = ((iy * widthOut) + ix) * components;
                if (readPix == 0) {
                    int src2 = ((y0 * widthIn) + x0) * components;
                    for (int ic3 = 0; ic3 < components; ic3++) {
                        int i7 = dst;
                        dst++;
                        tempOut[i7] = tempIn[src2 + ic3];
                    }
                } else {
                    for (int k3 = 0; k3 < components; k3++) {
                        int i8 = dst;
                        dst++;
                        tempOut[i8] = c[k3] / readPix;
                    }
                }
            }
        }
        if (pss.packRowLength > 0) {
            rowlen2 = pss.packRowLength;
        } else {
            rowlen2 = widthOut;
        }
        if (sizeout >= pss.packAlignment) {
            rowstride2 = components * rowlen2;
        } else {
            rowstride2 = (pss.packAlignment / sizeout) * ceil(components * rowlen2 * sizeout, pss.packAlignment);
        }
        switch (typeOut) {
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
                int k4 = 0;
                for (int i9 = 0; i9 < heightOut; i9++) {
                    int ubptr2 = (i9 * rowstride2) + (pss.packSkipRows * rowstride2) + (pss.packSkipPixels * components);
                    for (int j3 = 0; j3 < widthOut * components; j3++) {
                        int i10 = ubptr2;
                        ubptr2++;
                        int i11 = k4;
                        k4++;
                        dataOut.put(i10, (byte) tempOut[i11]);
                    }
                }
                return 0;
            case GL11.GL_FLOAT /* 5126 */:
                int k5 = 0;
                for (int i12 = 0; i12 < heightOut; i12++) {
                    int fptr2 = 4 * ((i12 * rowstride2) + (pss.unpackSkipRows * rowstride2) + (pss.unpackSkipPixels * components));
                    for (int j4 = 0; j4 < widthOut * components; j4++) {
                        int i13 = k5;
                        k5++;
                        dataOut.putFloat(fptr2, tempOut[i13]);
                        fptr2 += 4;
                    }
                }
                return 0;
            default:
                return 100900;
        }
    }
}
