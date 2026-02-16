package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.PointerWrapper;
import org.lwjgl.opencl.FastLongMap;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/APIUtil.class */
final class APIUtil {
    private static final int INITIAL_BUFFER_SIZE = 256;
    private static final int INITIAL_LENGTHS_SIZE = 4;
    private static final int BUFFERS_SIZE = 32;
    private static final ThreadLocal<char[]> arrayTL = new ThreadLocal<char[]>() { // from class: org.lwjgl.opencl.APIUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[256];
        }
    };
    private static final ThreadLocal<ByteBuffer> bufferByteTL = new ThreadLocal<ByteBuffer>() { // from class: org.lwjgl.opencl.APIUtil.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ByteBuffer initialValue() {
            return BufferUtils.createByteBuffer(256);
        }
    };
    private static final ThreadLocal<PointerBuffer> bufferPointerTL = new ThreadLocal<PointerBuffer>() { // from class: org.lwjgl.opencl.APIUtil.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public PointerBuffer initialValue() {
            return BufferUtils.createPointerBuffer(256);
        }
    };
    private static final ThreadLocal<PointerBuffer> lengthsTL = new ThreadLocal<PointerBuffer>() { // from class: org.lwjgl.opencl.APIUtil.4
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public PointerBuffer initialValue() {
            return BufferUtils.createPointerBuffer(4);
        }
    };
    private static final ThreadLocal<Buffers> buffersTL = new ThreadLocal<Buffers>() { // from class: org.lwjgl.opencl.APIUtil.5
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Buffers initialValue() {
            return new Buffers();
        }
    };
    private static final ObjectDestructor<CLDevice> DESTRUCTOR_CLSubDevice = new ObjectDestructor<CLDevice>() { // from class: org.lwjgl.opencl.APIUtil.6
        @Override // org.lwjgl.opencl.APIUtil.ObjectDestructor
        public void release(CLDevice object) {
            EXTDeviceFission.clReleaseDeviceEXT(object);
        }
    };
    private static final ObjectDestructor<CLMem> DESTRUCTOR_CLMem = new ObjectDestructor<CLMem>() { // from class: org.lwjgl.opencl.APIUtil.7
        @Override // org.lwjgl.opencl.APIUtil.ObjectDestructor
        public void release(CLMem object) {
            CL10.clReleaseMemObject(object);
        }
    };
    private static final ObjectDestructor<CLCommandQueue> DESTRUCTOR_CLCommandQueue = new ObjectDestructor<CLCommandQueue>() { // from class: org.lwjgl.opencl.APIUtil.8
        @Override // org.lwjgl.opencl.APIUtil.ObjectDestructor
        public void release(CLCommandQueue object) {
            CL10.clReleaseCommandQueue(object);
        }
    };
    private static final ObjectDestructor<CLSampler> DESTRUCTOR_CLSampler = new ObjectDestructor<CLSampler>() { // from class: org.lwjgl.opencl.APIUtil.9
        @Override // org.lwjgl.opencl.APIUtil.ObjectDestructor
        public void release(CLSampler object) {
            CL10.clReleaseSampler(object);
        }
    };
    private static final ObjectDestructor<CLProgram> DESTRUCTOR_CLProgram = new ObjectDestructor<CLProgram>() { // from class: org.lwjgl.opencl.APIUtil.10
        @Override // org.lwjgl.opencl.APIUtil.ObjectDestructor
        public void release(CLProgram object) {
            CL10.clReleaseProgram(object);
        }
    };
    private static final ObjectDestructor<CLKernel> DESTRUCTOR_CLKernel = new ObjectDestructor<CLKernel>() { // from class: org.lwjgl.opencl.APIUtil.11
        @Override // org.lwjgl.opencl.APIUtil.ObjectDestructor
        public void release(CLKernel object) {
            CL10.clReleaseKernel(object);
        }
    };
    private static final ObjectDestructor<CLEvent> DESTRUCTOR_CLEvent = new ObjectDestructor<CLEvent>() { // from class: org.lwjgl.opencl.APIUtil.12
        @Override // org.lwjgl.opencl.APIUtil.ObjectDestructor
        public void release(CLEvent object) {
            CL10.clReleaseEvent(object);
        }
    };

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/APIUtil$ObjectDestructor.class */
    private interface ObjectDestructor<T extends CLObjectChild> {
        void release(T t);
    }

    private APIUtil() {
    }

    private static char[] getArray(int size) {
        char[] array = arrayTL.get();
        if (array.length < size) {
            int length = array.length;
            while (true) {
                int sizeNew = length << 1;
                if (sizeNew >= size) {
                    break;
                }
                length = sizeNew;
            }
            array = new char[size];
            arrayTL.set(array);
        }
        return array;
    }

    static ByteBuffer getBufferByte(int size) {
        ByteBuffer buffer = bufferByteTL.get();
        if (buffer.capacity() < size) {
            int iCapacity = buffer.capacity();
            while (true) {
                int sizeNew = iCapacity << 1;
                if (sizeNew >= size) {
                    break;
                }
                iCapacity = sizeNew;
            }
            buffer = BufferUtils.createByteBuffer(size);
            bufferByteTL.set(buffer);
        } else {
            buffer.clear();
        }
        return buffer;
    }

    private static ByteBuffer getBufferByteOffset(int size) {
        ByteBuffer buffer = bufferByteTL.get();
        if (buffer.capacity() < size) {
            int iCapacity = buffer.capacity();
            while (true) {
                int sizeNew = iCapacity << 1;
                if (sizeNew >= size) {
                    break;
                }
                iCapacity = sizeNew;
            }
            ByteBuffer bufferNew = BufferUtils.createByteBuffer(size);
            bufferNew.put(buffer);
            buffer = bufferNew;
            bufferByteTL.set(bufferNew);
        } else {
            buffer.position(buffer.limit());
            buffer.limit(buffer.capacity());
        }
        return buffer;
    }

    static PointerBuffer getBufferPointer(int size) {
        PointerBuffer buffer = bufferPointerTL.get();
        if (buffer.capacity() < size) {
            int iCapacity = buffer.capacity();
            while (true) {
                int sizeNew = iCapacity << 1;
                if (sizeNew >= size) {
                    break;
                }
                iCapacity = sizeNew;
            }
            buffer = BufferUtils.createPointerBuffer(size);
            bufferPointerTL.set(buffer);
        } else {
            buffer.clear();
        }
        return buffer;
    }

    static ShortBuffer getBufferShort() {
        return buffersTL.get().shorts;
    }

    static IntBuffer getBufferInt() {
        return buffersTL.get().ints;
    }

    static IntBuffer getBufferIntDebug() {
        return buffersTL.get().intsDebug;
    }

    static LongBuffer getBufferLong() {
        return buffersTL.get().longs;
    }

    static FloatBuffer getBufferFloat() {
        return buffersTL.get().floats;
    }

    static DoubleBuffer getBufferDouble() {
        return buffersTL.get().doubles;
    }

    static PointerBuffer getBufferPointer() {
        return buffersTL.get().pointers;
    }

    static PointerBuffer getLengths() {
        return getLengths(1);
    }

    static PointerBuffer getLengths(int size) {
        PointerBuffer lengths = lengthsTL.get();
        if (lengths.capacity() < size) {
            int iCapacity = lengths.capacity();
            while (true) {
                int sizeNew = iCapacity;
                if (sizeNew >= size) {
                    break;
                }
                iCapacity = sizeNew << 1;
            }
            lengths = BufferUtils.createPointerBuffer(size);
            lengthsTL.set(lengths);
        } else {
            lengths.clear();
        }
        return lengths;
    }

    private static ByteBuffer encode(ByteBuffer buffer, CharSequence string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (LWJGLUtil.DEBUG && 128 <= c) {
                buffer.put((byte) 26);
            } else {
                buffer.put((byte) c);
            }
        }
        return buffer;
    }

    static String getString(ByteBuffer buffer) {
        int length = buffer.remaining();
        char[] charArray = getArray(length);
        for (int i = buffer.position(); i < buffer.limit(); i++) {
            charArray[i - buffer.position()] = (char) buffer.get(i);
        }
        return new String(charArray, 0, length);
    }

    static long getBuffer(CharSequence string) {
        ByteBuffer buffer = encode(getBufferByte(string.length()), string);
        buffer.flip();
        return MemoryUtil.getAddress0(buffer);
    }

    static long getBuffer(CharSequence string, int offset) {
        ByteBuffer buffer = encode(getBufferByteOffset(offset + string.length()), string);
        buffer.flip();
        return MemoryUtil.getAddress(buffer);
    }

    static long getBufferNT(CharSequence string) {
        ByteBuffer buffer = encode(getBufferByte(string.length() + 1), string);
        buffer.put((byte) 0);
        buffer.flip();
        return MemoryUtil.getAddress0(buffer);
    }

    static int getTotalLength(CharSequence[] strings) {
        int length = 0;
        for (CharSequence string : strings) {
            length += string.length();
        }
        return length;
    }

    static long getBuffer(CharSequence[] strings) {
        ByteBuffer buffer = getBufferByte(getTotalLength(strings));
        for (CharSequence string : strings) {
            encode(buffer, string);
        }
        buffer.flip();
        return MemoryUtil.getAddress0(buffer);
    }

    static long getBufferNT(CharSequence[] strings) {
        ByteBuffer buffer = getBufferByte(getTotalLength(strings) + strings.length);
        for (CharSequence string : strings) {
            encode(buffer, string);
            buffer.put((byte) 0);
        }
        buffer.flip();
        return MemoryUtil.getAddress0(buffer);
    }

    static long getLengths(CharSequence[] strings) {
        PointerBuffer buffer = getLengths(strings.length);
        for (CharSequence string : strings) {
            buffer.put(string.length());
        }
        buffer.flip();
        return MemoryUtil.getAddress0(buffer);
    }

    static long getLengths(ByteBuffer[] buffers) {
        PointerBuffer lengths = getLengths(buffers.length);
        for (ByteBuffer buffer : buffers) {
            lengths.put(buffer.remaining());
        }
        lengths.flip();
        return MemoryUtil.getAddress0(lengths);
    }

    static int getSize(PointerBuffer lengths) {
        long size = 0;
        for (int i = lengths.position(); i < lengths.limit(); i++) {
            size += lengths.get(i);
        }
        return (int) size;
    }

    static long getPointer(PointerWrapper pointer) {
        return MemoryUtil.getAddress0(getBufferPointer().put(0, pointer));
    }

    static long getPointerSafe(PointerWrapper pointer) {
        return MemoryUtil.getAddress0(getBufferPointer().put(0, pointer == null ? 0L : pointer.getPointer()));
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/APIUtil$Buffers.class */
    private static class Buffers {
        final ShortBuffer shorts = BufferUtils.createShortBuffer(32);
        final IntBuffer ints = BufferUtils.createIntBuffer(32);
        final IntBuffer intsDebug = BufferUtils.createIntBuffer(1);
        final LongBuffer longs = BufferUtils.createLongBuffer(32);
        final FloatBuffer floats = BufferUtils.createFloatBuffer(32);
        final DoubleBuffer doubles = BufferUtils.createDoubleBuffer(32);
        final PointerBuffer pointers = BufferUtils.createPointerBuffer(32);

        Buffers() {
        }
    }

    static Set<String> getExtensions(String extensionList) {
        Set<String> extensions = new HashSet<>();
        if (extensionList != null) {
            StringTokenizer tokenizer = new StringTokenizer(extensionList);
            while (tokenizer.hasMoreTokens()) {
                extensions.add(tokenizer.nextToken());
            }
        }
        return extensions;
    }

    static boolean isDevicesParam(int param_name) {
        switch (param_name) {
            case CL10.CL_CONTEXT_DEVICES /* 4225 */:
            case KHRGLSharing.CL_CURRENT_DEVICE_FOR_GL_CONTEXT_KHR /* 8198 */:
            case KHRGLSharing.CL_DEVICES_FOR_GL_CONTEXT_KHR /* 8199 */:
            case APPLEGLSharing.CL_CGL_DEVICE_FOR_CURRENT_VIRTUAL_SCREEN_APPLE /* 268435458 */:
            case APPLEGLSharing.CL_CGL_DEVICES_FOR_SUPPORTED_VIRTUAL_SCREENS_APPLE /* 268435459 */:
                return true;
            default:
                return false;
        }
    }

    static CLPlatform getCLPlatform(PointerBuffer properties) {
        long platformID = 0;
        int keys = properties.remaining() / 2;
        int k = 0;
        while (true) {
            if (k >= keys) {
                break;
            }
            long key = properties.get(k << 1);
            if (key == 0) {
                break;
            }
            if (key != 4228) {
                k++;
            } else {
                platformID = properties.get((k << 1) + 1);
                break;
            }
        }
        if (platformID == 0) {
            throw new IllegalArgumentException("Could not find CL_CONTEXT_PLATFORM in cl_context_properties.");
        }
        CLPlatform platform = CLPlatform.getCLPlatform(platformID);
        if (platform == null) {
            throw new IllegalStateException("Could not find a valid CLPlatform. Make sure clGetPlatformIDs has been used before.");
        }
        return platform;
    }

    static ByteBuffer getNativeKernelArgs(long user_func_ref, CLMem[] clMems, long[] sizes) {
        ByteBuffer args = getBufferByte(12 + (clMems == null ? 0 : clMems.length * (4 + PointerBuffer.getPointerSize())));
        args.putLong(0, user_func_ref);
        if (clMems == null) {
            args.putInt(8, 0);
        } else {
            args.putInt(8, clMems.length);
            int byteIndex = 12;
            for (int i = 0; i < clMems.length; i++) {
                if (LWJGLUtil.DEBUG && !clMems[i].isValid()) {
                    throw new IllegalArgumentException("An invalid CLMem object was specified.");
                }
                args.putInt(byteIndex, (int) sizes[i]);
                byteIndex += 4 + PointerBuffer.getPointerSize();
            }
        }
        return args;
    }

    static void releaseObjects(CLDevice device) {
        if (!device.isValid() || device.getReferenceCount() > 1) {
            return;
        }
        releaseObjects(device.getSubCLDeviceRegistry(), DESTRUCTOR_CLSubDevice);
    }

    static void releaseObjects(CLContext context) {
        if (!context.isValid() || context.getReferenceCount() > 1) {
            return;
        }
        releaseObjects(context.getCLEventRegistry(), DESTRUCTOR_CLEvent);
        releaseObjects(context.getCLProgramRegistry(), DESTRUCTOR_CLProgram);
        releaseObjects(context.getCLSamplerRegistry(), DESTRUCTOR_CLSampler);
        releaseObjects(context.getCLMemRegistry(), DESTRUCTOR_CLMem);
        releaseObjects(context.getCLCommandQueueRegistry(), DESTRUCTOR_CLCommandQueue);
    }

    static void releaseObjects(CLProgram program) {
        if (!program.isValid() || program.getReferenceCount() > 1) {
            return;
        }
        releaseObjects(program.getCLKernelRegistry(), DESTRUCTOR_CLKernel);
    }

    static void releaseObjects(CLCommandQueue queue) {
        if (!queue.isValid() || queue.getReferenceCount() > 1) {
            return;
        }
        releaseObjects(queue.getCLEventRegistry(), DESTRUCTOR_CLEvent);
    }

    private static <T extends CLObjectChild> void releaseObjects(CLObjectRegistry<T> registry, ObjectDestructor<T> destructor) {
        if (registry.isEmpty()) {
            return;
        }
        for (FastLongMap.Entry<T> entry : registry.getAll()) {
            T object = entry.value;
            while (object.isValid()) {
                destructor.release(object);
            }
        }
    }
}
