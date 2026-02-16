package org.lwjgl.util.mapped;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/CacheLineSize.class */
final class CacheLineSize {
    private CacheLineSize() {
    }

    static int getCacheLineSize() {
        int MAX_SIZE = LWJGLUtil.getPrivilegedInteger("org.lwjgl.util.mapped.CacheLineMaxSize", 1024).intValue() / 4;
        double TIME_THRESHOLD = 1.0d + (((double) LWJGLUtil.getPrivilegedInteger("org.lwjgl.util.mapped.CacheLineTimeThreshold", 50).intValue()) / 100.0d);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorCompletionService<Long> completionService = new ExecutorCompletionService<>(executorService);
        try {
            IntBuffer memory = getMemory(MAX_SIZE);
            for (int i = 0; i < 10; i++) {
                doTest(2, GLU.GLU_SMOOTH, 0, memory, completionService);
            }
            long totalTime = 0;
            int count = 0;
            int cacheLineSize = 64;
            boolean found = false;
            int i2 = MAX_SIZE;
            while (true) {
                if (i2 < 1) {
                    break;
                }
                long time = doTest(2, GLU.GLU_SMOOTH, i2, memory, completionService);
                if (totalTime > 0) {
                    long avgTime = totalTime / ((long) count);
                    if (time / avgTime > TIME_THRESHOLD) {
                        cacheLineSize = (i2 << 1) * 4;
                        found = true;
                        break;
                    }
                }
                totalTime += time;
                count++;
                i2 >>= 1;
            }
            if (LWJGLUtil.DEBUG) {
                if (found) {
                    LWJGLUtil.log("Cache line size detected: " + cacheLineSize + " bytes");
                } else {
                    LWJGLUtil.log("Failed to detect cache line size, assuming " + cacheLineSize + " bytes");
                }
            }
            return cacheLineSize;
        } finally {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        CacheUtil.getCacheLineSize();
    }

    static long memoryLoop(int index, int repeats, IntBuffer memory, int padding) {
        long address = MemoryUtil.getAddress(memory) + ((long) (index * padding * 4));
        long time = System.nanoTime();
        for (int i = 0; i < repeats; i++) {
            MappedHelper.ivput(MappedHelper.ivget(address) + 1, address);
        }
        return System.nanoTime() - time;
    }

    private static IntBuffer getMemory(int START_SIZE) {
        int PAGE_SIZE = MappedObjectUnsafe.INSTANCE.pageSize();
        ByteBuffer buffer = ByteBuffer.allocateDirect((START_SIZE * 4) + PAGE_SIZE).order(ByteOrder.nativeOrder());
        if (MemoryUtil.getAddress(buffer) % ((long) PAGE_SIZE) != 0) {
            buffer.position(PAGE_SIZE - ((int) (MemoryUtil.getAddress(buffer) & ((long) (PAGE_SIZE - 1)))));
        }
        return buffer.asIntBuffer();
    }

    private static long doTest(int threads, int repeats, int padding, IntBuffer memory, ExecutorCompletionService<Long> completionService) {
        for (int i = 0; i < threads; i++) {
            submitTest(completionService, i, repeats, memory, padding);
        }
        return waitForResults(threads, completionService);
    }

    private static void submitTest(ExecutorCompletionService<Long> completionService, final int index, final int repeats, final IntBuffer memory, final int padding) {
        completionService.submit(new Callable<Long>() { // from class: org.lwjgl.util.mapped.CacheLineSize.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                return Long.valueOf(CacheLineSize.memoryLoop(index, repeats, memory, padding));
            }
        });
    }

    private static long waitForResults(int count, ExecutorCompletionService<Long> completionService) {
        long totalTime = 0;
        for (int i = 0; i < count; i++) {
            try {
                totalTime += completionService.take().get().longValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return totalTime;
    }
}
