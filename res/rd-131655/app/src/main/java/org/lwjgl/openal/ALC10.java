package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLException;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/openal/ALC10.class */
public final class ALC10 {
    static final HashMap<Long, ALCcontext> contexts = new HashMap<>();
    static final HashMap<Long, ALCdevice> devices = new HashMap<>();
    public static final int ALC_INVALID = 0;
    public static final int ALC_FALSE = 0;
    public static final int ALC_TRUE = 1;
    public static final int ALC_NO_ERROR = 0;
    public static final int ALC_MAJOR_VERSION = 4096;
    public static final int ALC_MINOR_VERSION = 4097;
    public static final int ALC_ATTRIBUTES_SIZE = 4098;
    public static final int ALC_ALL_ATTRIBUTES = 4099;
    public static final int ALC_DEFAULT_DEVICE_SPECIFIER = 4100;
    public static final int ALC_DEVICE_SPECIFIER = 4101;
    public static final int ALC_EXTENSIONS = 4102;
    public static final int ALC_FREQUENCY = 4103;
    public static final int ALC_REFRESH = 4104;
    public static final int ALC_SYNC = 4105;
    public static final int ALC_INVALID_DEVICE = 40961;
    public static final int ALC_INVALID_CONTEXT = 40962;
    public static final int ALC_INVALID_ENUM = 40963;
    public static final int ALC_INVALID_VALUE = 40964;
    public static final int ALC_OUT_OF_MEMORY = 40965;

    static native void initNativeStubs() throws LWJGLException;

    static native ByteBuffer nalcGetString(long j, int i);

    static native void nalcGetIntegerv(long j, int i, int i2, long j2);

    static native long nalcOpenDevice(long j);

    static native boolean nalcCloseDevice(long j);

    static native long nalcCreateContext(long j, long j2);

    static native int nalcMakeContextCurrent(long j);

    static native void nalcProcessContext(long j);

    static native long nalcGetCurrentContext();

    static native long nalcGetContextsDevice(long j);

    static native void nalcSuspendContext(long j);

    static native void nalcDestroyContext(long j);

    static native int nalcGetError(long j);

    private static native boolean nalcIsExtensionPresent(long j, long j2);

    private static native int nalcGetEnumValue(long j, long j2);

    public static String alcGetString(ALCdevice device, int pname) {
        ByteBuffer buffer = nalcGetString(getDevice(device), pname);
        Util.checkALCError(device);
        return MemoryUtil.decodeUTF8(buffer);
    }

    public static void alcGetInteger(ALCdevice device, int pname, IntBuffer integerdata) {
        BufferChecks.checkDirect(integerdata);
        nalcGetIntegerv(getDevice(device), pname, integerdata.remaining(), MemoryUtil.getAddress(integerdata));
        Util.checkALCError(device);
    }

    public static ALCdevice alcOpenDevice(String devicename) {
        ByteBuffer buffer = MemoryUtil.encodeUTF8(devicename);
        long device_address = nalcOpenDevice(MemoryUtil.getAddressSafe(buffer));
        if (device_address != 0) {
            ALCdevice device = new ALCdevice(device_address);
            synchronized (devices) {
                devices.put(Long.valueOf(device_address), device);
            }
            return device;
        }
        return null;
    }

    public static boolean alcCloseDevice(ALCdevice device) {
        boolean result = nalcCloseDevice(getDevice(device));
        synchronized (devices) {
            device.setInvalid();
            devices.remove(new Long(device.device));
        }
        return result;
    }

    public static ALCcontext alcCreateContext(ALCdevice device, IntBuffer attrList) {
        long context_address = nalcCreateContext(getDevice(device), MemoryUtil.getAddressSafe(attrList));
        Util.checkALCError(device);
        if (context_address != 0) {
            ALCcontext context = new ALCcontext(context_address);
            synchronized (contexts) {
                contexts.put(Long.valueOf(context_address), context);
                device.addContext(context);
            }
            return context;
        }
        return null;
    }

    public static int alcMakeContextCurrent(ALCcontext context) {
        return nalcMakeContextCurrent(getContext(context));
    }

    public static void alcProcessContext(ALCcontext context) {
        nalcProcessContext(getContext(context));
    }

    public static ALCcontext alcGetCurrentContext() {
        ALCcontext context = null;
        long context_address = nalcGetCurrentContext();
        if (context_address != 0) {
            synchronized (contexts) {
                context = contexts.get(Long.valueOf(context_address));
            }
        }
        return context;
    }

    public static ALCdevice alcGetContextsDevice(ALCcontext context) {
        ALCdevice device = null;
        long device_address = nalcGetContextsDevice(getContext(context));
        if (device_address != 0) {
            synchronized (devices) {
                device = devices.get(Long.valueOf(device_address));
            }
        }
        return device;
    }

    public static void alcSuspendContext(ALCcontext context) {
        nalcSuspendContext(getContext(context));
    }

    public static void alcDestroyContext(ALCcontext context) {
        synchronized (contexts) {
            ALCdevice device = alcGetContextsDevice(context);
            nalcDestroyContext(getContext(context));
            device.removeContext(context);
            context.setInvalid();
        }
    }

    public static int alcGetError(ALCdevice device) {
        return nalcGetError(getDevice(device));
    }

    public static boolean alcIsExtensionPresent(ALCdevice device, String extName) {
        ByteBuffer buffer = MemoryUtil.encodeASCII(extName);
        boolean result = nalcIsExtensionPresent(getDevice(device), MemoryUtil.getAddress(buffer));
        Util.checkALCError(device);
        return result;
    }

    public static int alcGetEnumValue(ALCdevice device, String enumName) {
        ByteBuffer buffer = MemoryUtil.encodeASCII(enumName);
        int result = nalcGetEnumValue(getDevice(device), MemoryUtil.getAddress(buffer));
        Util.checkALCError(device);
        return result;
    }

    static long getDevice(ALCdevice device) {
        if (device != null) {
            Util.checkALCValidDevice(device);
            return device.device;
        }
        return 0L;
    }

    static long getContext(ALCcontext context) {
        if (context != null) {
            Util.checkALCValidContext(context);
            return context.context;
        }
        return 0L;
    }
}
