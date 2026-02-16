package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/GLChecks.class */
class GLChecks {
    private GLChecks() {
    }

    static void ensureArrayVBOdisabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).arrayBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Array Buffer Object is enabled");
        }
    }

    static void ensureArrayVBOenabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).arrayBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Array Buffer Object is disabled");
        }
    }

    static void ensureElementVBOdisabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getElementArrayBufferBound(caps) != 0) {
            throw new OpenGLException("Cannot use Buffers when Element Array Buffer Object is enabled");
        }
    }

    static void ensureElementVBOenabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getElementArrayBufferBound(caps) == 0) {
            throw new OpenGLException("Cannot use offsets when Element Array Buffer Object is disabled");
        }
    }

    static void ensureIndirectBOdisabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).indirectBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Draw Indirect Object is enabled");
        }
    }

    static void ensureIndirectBOenabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).indirectBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Draw Indirect Object is disabled");
        }
    }

    static void ensurePackPBOdisabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).pixelPackBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Pixel Pack Buffer Object is enabled");
        }
    }

    static void ensurePackPBOenabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).pixelPackBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Pixel Pack Buffer Object is disabled");
        }
    }

    static void ensureUnpackPBOdisabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).pixelUnpackBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Pixel Unpack Buffer Object is enabled");
        }
    }

    static void ensureUnpackPBOenabled(ContextCapabilities caps) {
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(caps).pixelUnpackBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Pixel Unpack Buffer Object is disabled");
        }
    }

    static int calculateImageStorage(Buffer buffer, int format, int type, int width, int height, int depth) {
        if (LWJGLUtil.CHECKS) {
            return calculateImageStorage(format, type, width, height, depth) >> BufferUtils.getElementSizeExponent(buffer);
        }
        return 0;
    }

    static int calculateTexImage1DStorage(Buffer buffer, int format, int type, int width) {
        if (LWJGLUtil.CHECKS) {
            return calculateTexImage1DStorage(format, type, width) >> BufferUtils.getElementSizeExponent(buffer);
        }
        return 0;
    }

    static int calculateTexImage2DStorage(Buffer buffer, int format, int type, int width, int height) {
        if (LWJGLUtil.CHECKS) {
            return calculateTexImage2DStorage(format, type, width, height) >> BufferUtils.getElementSizeExponent(buffer);
        }
        return 0;
    }

    static int calculateTexImage3DStorage(Buffer buffer, int format, int type, int width, int height, int depth) {
        if (LWJGLUtil.CHECKS) {
            return calculateTexImage3DStorage(format, type, width, height, depth) >> BufferUtils.getElementSizeExponent(buffer);
        }
        return 0;
    }

    private static int calculateImageStorage(int format, int type, int width, int height, int depth) {
        return calculateBytesPerPixel(format, type) * width * height * depth;
    }

    private static int calculateTexImage1DStorage(int format, int type, int width) {
        return calculateBytesPerPixel(format, type) * width;
    }

    private static int calculateTexImage2DStorage(int format, int type, int width, int height) {
        return calculateTexImage1DStorage(format, type, width) * height;
    }

    private static int calculateTexImage3DStorage(int format, int type, int width, int height, int depth) {
        return calculateTexImage2DStorage(format, type, width, height) * depth;
    }

    private static int calculateBytesPerPixel(int format, int type) {
        int bpe;
        int epp;
        switch (type) {
            case GL11.GL_BYTE /* 5120 */:
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
                bpe = 1;
                break;
            case GL11.GL_SHORT /* 5122 */:
            case GL11.GL_UNSIGNED_SHORT /* 5123 */:
                bpe = 2;
                break;
            case GL11.GL_INT /* 5124 */:
            case GL11.GL_UNSIGNED_INT /* 5125 */:
            case GL11.GL_FLOAT /* 5126 */:
                bpe = 4;
                break;
            default:
                return 0;
        }
        switch (format) {
            case GL11.GL_ALPHA /* 6406 */:
            case GL11.GL_LUMINANCE /* 6409 */:
                epp = 1;
                break;
            case GL11.GL_RGB /* 6407 */:
            case 32992:
                epp = 3;
                break;
            case GL11.GL_RGBA /* 6408 */:
            case 32768:
            case 32993:
                epp = 4;
                break;
            case GL11.GL_LUMINANCE_ALPHA /* 6410 */:
                epp = 2;
                break;
            default:
                return 0;
        }
        return bpe * epp;
    }

    static int calculateBytesPerCharCode(int type) {
        switch (type) {
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
            case NVPathRendering.GL_UTF8_NV /* 37018 */:
                return 1;
            case GL11.GL_UNSIGNED_SHORT /* 5123 */:
            case GL11.GL_2_BYTES /* 5127 */:
            case NVPathRendering.GL_UTF16_NV /* 37019 */:
                return 2;
            case GL11.GL_3_BYTES /* 5128 */:
                return 3;
            case GL11.GL_4_BYTES /* 5129 */:
                return 4;
            default:
                throw new IllegalArgumentException("Unsupported charcode type: " + type);
        }
    }

    static int calculateBytesPerPathName(int pathNameType) {
        switch (pathNameType) {
            case GL11.GL_BYTE /* 5120 */:
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
            case NVPathRendering.GL_UTF8_NV /* 37018 */:
                return 1;
            case GL11.GL_SHORT /* 5122 */:
            case GL11.GL_UNSIGNED_SHORT /* 5123 */:
            case GL11.GL_2_BYTES /* 5127 */:
            case NVPathRendering.GL_UTF16_NV /* 37019 */:
                return 2;
            case GL11.GL_INT /* 5124 */:
            case GL11.GL_UNSIGNED_INT /* 5125 */:
            case GL11.GL_FLOAT /* 5126 */:
            case GL11.GL_4_BYTES /* 5129 */:
                return 4;
            case GL11.GL_3_BYTES /* 5128 */:
                return 3;
            default:
                throw new IllegalArgumentException("Unsupported path name type: " + pathNameType);
        }
    }

    static int calculateTransformPathValues(int transformType) {
        switch (transformType) {
            case 0:
                return 0;
            case NVPathRendering.GL_TRANSLATE_X_NV /* 37006 */:
            case NVPathRendering.GL_TRANSLATE_Y_NV /* 37007 */:
                return 1;
            case NVPathRendering.GL_TRANSLATE_2D_NV /* 37008 */:
                return 2;
            case NVPathRendering.GL_TRANSLATE_3D_NV /* 37009 */:
                return 3;
            case NVPathRendering.GL_AFFINE_2D_NV /* 37010 */:
            case NVPathRendering.GL_TRANSPOSE_AFFINE_2D_NV /* 37014 */:
                return 6;
            case NVPathRendering.GL_AFFINE_3D_NV /* 37012 */:
            case NVPathRendering.GL_TRANSPOSE_AFFINE_3D_NV /* 37016 */:
                return 12;
            default:
                throw new IllegalArgumentException("Unsupported transform type: " + transformType);
        }
    }

    static int calculatePathColorGenCoeffsCount(int genMode, int colorFormat) {
        int coeffsPerComponent = calculatePathGenCoeffsPerComponent(genMode);
        switch (colorFormat) {
            case GL11.GL_RGB /* 6407 */:
                return 3 * coeffsPerComponent;
            case GL11.GL_RGBA /* 6408 */:
                return 4 * coeffsPerComponent;
            default:
                return coeffsPerComponent;
        }
    }

    static int calculatePathTextGenCoeffsPerComponent(FloatBuffer coeffs, int genMode) {
        if (genMode == 0) {
            return 0;
        }
        return coeffs.remaining() / calculatePathGenCoeffsPerComponent(genMode);
    }

    private static int calculatePathGenCoeffsPerComponent(int genMode) {
        switch (genMode) {
            case 0:
                return 0;
            case GL11.GL_EYE_LINEAR /* 9216 */:
                return 4;
            case GL11.GL_OBJECT_LINEAR /* 9217 */:
            case NVPathRendering.GL_PATH_OBJECT_BOUNDING_BOX_NV /* 37002 */:
                return 3;
            default:
                throw new IllegalArgumentException("Unsupported gen mode: " + genMode);
        }
    }

    static int calculateMetricsSize(int metricQueryMask, int stride) {
        if (LWJGLUtil.DEBUG && (stride < 0 || stride % 4 != 0)) {
            throw new IllegalArgumentException("Invalid stride value: " + stride);
        }
        int metrics = Integer.bitCount(metricQueryMask);
        if (!LWJGLUtil.DEBUG || (stride >> 2) >= metrics) {
            return stride == 0 ? metrics : stride >> 2;
        }
        throw new IllegalArgumentException("The queried metrics do not fit in the specified stride: " + stride);
    }
}
