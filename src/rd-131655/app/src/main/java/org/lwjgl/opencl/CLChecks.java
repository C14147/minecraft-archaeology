package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLChecks.class */
final class CLChecks {
    private CLChecks() {
    }

    static int calculateBufferRectSize(PointerBuffer offset, PointerBuffer region, long row_pitch, long slice_pitch) {
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        long x = offset.get(0);
        long y = offset.get(1);
        long z = offset.get(2);
        if (LWJGLUtil.DEBUG && (x < 0 || y < 0 || z < 0)) {
            throw new IllegalArgumentException("Invalid cl_mem host offset: " + x + ", " + y + ", " + z);
        }
        long w = region.get(0);
        long h = region.get(1);
        long d = region.get(2);
        if (LWJGLUtil.DEBUG && (w < 1 || h < 1 || d < 1)) {
            throw new IllegalArgumentException("Invalid cl_mem rectangle region dimensions: " + w + " x " + h + " x " + d);
        }
        if (row_pitch == 0) {
            row_pitch = w;
        } else if (LWJGLUtil.DEBUG && row_pitch < w) {
            throw new IllegalArgumentException("Invalid host row pitch specified: " + row_pitch);
        }
        if (slice_pitch == 0) {
            slice_pitch = row_pitch * h;
        } else if (LWJGLUtil.DEBUG && slice_pitch < row_pitch * h) {
            throw new IllegalArgumentException("Invalid host slice pitch specified: " + slice_pitch);
        }
        return (int) ((z * slice_pitch) + (y * row_pitch) + x + (w * h * d));
    }

    static int calculateImageSize(PointerBuffer region, long row_pitch, long slice_pitch) {
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        long w = region.get(0);
        long h = region.get(1);
        long d = region.get(2);
        if (LWJGLUtil.DEBUG && (w < 1 || h < 1 || d < 1)) {
            throw new IllegalArgumentException("Invalid cl_mem image region dimensions: " + w + " x " + h + " x " + d);
        }
        if (row_pitch == 0) {
            row_pitch = w;
        } else if (LWJGLUtil.DEBUG && row_pitch < w) {
            throw new IllegalArgumentException("Invalid row pitch specified: " + row_pitch);
        }
        if (slice_pitch == 0) {
            slice_pitch = row_pitch * h;
        } else if (LWJGLUtil.DEBUG && slice_pitch < row_pitch * h) {
            throw new IllegalArgumentException("Invalid slice pitch specified: " + slice_pitch);
        }
        return (int) (slice_pitch * d);
    }

    static int calculateImage2DSize(ByteBuffer format, long w, long h, long row_pitch) {
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        if (LWJGLUtil.DEBUG && (w < 1 || h < 1)) {
            throw new IllegalArgumentException("Invalid 2D image dimensions: " + w + " x " + h);
        }
        int elementSize = getElementSize(format);
        if (row_pitch == 0) {
            row_pitch = w * ((long) elementSize);
        } else if (LWJGLUtil.DEBUG && (row_pitch < w * ((long) elementSize) || row_pitch % ((long) elementSize) != 0)) {
            throw new IllegalArgumentException("Invalid image_row_pitch specified: " + row_pitch);
        }
        return (int) (row_pitch * h);
    }

    static int calculateImage3DSize(ByteBuffer format, long w, long h, long d, long row_pitch, long slice_pitch) {
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        if (LWJGLUtil.DEBUG && (w < 1 || h < 1 || d < 2)) {
            throw new IllegalArgumentException("Invalid 3D image dimensions: " + w + " x " + h + " x " + d);
        }
        int elementSize = getElementSize(format);
        if (row_pitch == 0) {
            row_pitch = w * ((long) elementSize);
        } else if (LWJGLUtil.DEBUG && (row_pitch < w * ((long) elementSize) || row_pitch % ((long) elementSize) != 0)) {
            throw new IllegalArgumentException("Invalid image_row_pitch specified: " + row_pitch);
        }
        if (slice_pitch == 0) {
            slice_pitch = row_pitch * h;
        } else if (LWJGLUtil.DEBUG && (row_pitch < row_pitch * h || slice_pitch % row_pitch != 0)) {
            throw new IllegalArgumentException("Invalid image_slice_pitch specified: " + row_pitch);
        }
        return (int) (slice_pitch * d);
    }

    private static int getElementSize(ByteBuffer format) {
        int channelOrder = format.getInt(format.position() + 0);
        int channelType = format.getInt(format.position() + 4);
        return getChannelCount(channelOrder) * getChannelSize(channelType);
    }

    private static int getChannelCount(int channelOrder) {
        switch (channelOrder) {
            case CL10.CL_R /* 4272 */:
            case CL10.CL_A /* 4273 */:
            case CL10.CL_INTENSITY /* 4280 */:
            case CL10.CL_LUMINANCE /* 4281 */:
            case CL11.CL_Rx /* 4282 */:
                return 1;
            case CL10.CL_RG /* 4274 */:
            case CL10.CL_RA /* 4275 */:
            case CL11.CL_RGx /* 4283 */:
                return 2;
            case CL10.CL_RGB /* 4276 */:
            case CL11.CL_RGBx /* 4284 */:
                return 3;
            case CL10.CL_RGBA /* 4277 */:
            case CL10.CL_BGRA /* 4278 */:
            case CL10.CL_ARGB /* 4279 */:
                return 4;
            default:
                throw new IllegalArgumentException("Invalid cl_channel_order specified: " + LWJGLUtil.toHexString(channelOrder));
        }
    }

    private static int getChannelSize(int channelType) {
        switch (channelType) {
            case CL10.CL_SNORM_INT8 /* 4304 */:
            case CL10.CL_UNORM_INT8 /* 4306 */:
            case CL10.CL_SIGNED_INT8 /* 4311 */:
            case CL10.CL_UNSIGNED_INT8 /* 4314 */:
                return 1;
            case CL10.CL_SNORM_INT16 /* 4305 */:
            case CL10.CL_UNORM_INT16 /* 4307 */:
            case CL10.CL_UNORM_SHORT_565 /* 4308 */:
            case CL10.CL_UNORM_SHORT_555 /* 4309 */:
            case CL10.CL_SIGNED_INT16 /* 4312 */:
            case CL10.CL_UNSIGNED_INT16 /* 4315 */:
            case CL10.CL_HALF_FLOAT /* 4317 */:
                return 2;
            case CL10.CL_UNORM_INT_101010 /* 4310 */:
            case CL10.CL_SIGNED_INT32 /* 4313 */:
            case CL10.CL_UNSIGNED_INT32 /* 4316 */:
            case CL10.CL_FLOAT /* 4318 */:
                return 4;
            default:
                throw new IllegalArgumentException("Invalid cl_channel_type specified: " + LWJGLUtil.toHexString(channelType));
        }
    }
}
