package org.lwjgl.input;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/input/Cursor.class */
public class Cursor {
    public static final int CURSOR_ONE_BIT_TRANSPARENCY = 1;
    public static final int CURSOR_8_BIT_ALPHA = 2;
    public static final int CURSOR_ANIMATION = 4;
    private final CursorElement[] cursors;
    private int index;
    private boolean destroyed;

    public Cursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        synchronized (OpenGLPackageAccess.global_lock) {
            if ((getCapabilities() & 1) == 0) {
                throw new LWJGLException("Native cursors not supported");
            }
            BufferChecks.checkBufferSize(images, width * height * numImages);
            if (delays != null) {
                BufferChecks.checkBufferSize(delays, numImages);
            }
            if (!Mouse.isCreated()) {
                throw new IllegalStateException("Mouse must be created before creating cursor objects");
            }
            if (width * height * numImages > images.remaining()) {
                throw new IllegalArgumentException("width*height*numImages > images.remaining()");
            }
            if (xHotspot >= width || xHotspot < 0) {
                throw new IllegalArgumentException("xHotspot > width || xHotspot < 0");
            }
            if (yHotspot >= height || yHotspot < 0) {
                throw new IllegalArgumentException("yHotspot > height || yHotspot < 0");
            }
            Sys.initialize();
            this.cursors = createCursors(width, height, xHotspot, (height - 1) - yHotspot, numImages, images, delays);
        }
    }

    public static int getMinCursorSize() {
        int minCursorSize;
        synchronized (OpenGLPackageAccess.global_lock) {
            if (!Mouse.isCreated()) {
                throw new IllegalStateException("Mouse must be created.");
            }
            minCursorSize = Mouse.getImplementation().getMinCursorSize();
        }
        return minCursorSize;
    }

    public static int getMaxCursorSize() {
        int maxCursorSize;
        synchronized (OpenGLPackageAccess.global_lock) {
            if (!Mouse.isCreated()) {
                throw new IllegalStateException("Mouse must be created.");
            }
            maxCursorSize = Mouse.getImplementation().getMaxCursorSize();
        }
        return maxCursorSize;
    }

    public static int getCapabilities() {
        synchronized (OpenGLPackageAccess.global_lock) {
            if (Mouse.getImplementation() != null) {
                return Mouse.getImplementation().getNativeCursorCapabilities();
            }
            return OpenGLPackageAccess.createImplementation().getNativeCursorCapabilities();
        }
    }

    private static CursorElement[] createCursors(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        CursorElement[] cursors;
        IntBuffer images_copy = BufferUtils.createIntBuffer(images.remaining());
        flipImages(width, height, numImages, images, images_copy);
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                Object handle = Mouse.getImplementation().createCursor(width, height, xHotspot, yHotspot, numImages, images_copy, delays);
                CursorElement cursor_element = new CursorElement(handle, -1L, -1L);
                cursors = new CursorElement[]{cursor_element};
                break;
            case 2:
                convertARGBtoABGR(images_copy);
                cursors = new CursorElement[numImages];
                for (int i = 0; i < numImages; i++) {
                    Object handle2 = Mouse.getImplementation().createCursor(width, height, xHotspot, yHotspot, 1, images_copy, null);
                    long delay = delays != null ? delays.get(i) : 0L;
                    long timeout = System.currentTimeMillis();
                    cursors[i] = new CursorElement(handle2, delay, timeout);
                    images_copy.position(width * height * (i + 1));
                }
                break;
            case 3:
                cursors = new CursorElement[numImages];
                for (int i2 = 0; i2 < numImages; i2++) {
                    int size = width * height;
                    for (int j = 0; j < size; j++) {
                        int index = j + (i2 * size);
                        int alpha = (images_copy.get(index) >> 24) & 255;
                        if (alpha != 255) {
                            images_copy.put(index, 0);
                        }
                    }
                    Object handle3 = Mouse.getImplementation().createCursor(width, height, xHotspot, yHotspot, 1, images_copy, null);
                    long delay2 = delays != null ? delays.get(i2) : 0L;
                    long timeout2 = System.currentTimeMillis();
                    cursors[i2] = new CursorElement(handle3, delay2, timeout2);
                    images_copy.position(width * height * (i2 + 1));
                }
                break;
            default:
                throw new RuntimeException("Unknown OS");
        }
        return cursors;
    }

    private static void convertARGBtoABGR(IntBuffer imageBuffer) {
        for (int i = 0; i < imageBuffer.limit(); i++) {
            int argbColor = imageBuffer.get(i);
            byte alpha = (byte) (argbColor >>> 24);
            byte blue = (byte) (argbColor >>> 16);
            byte green = (byte) (argbColor >>> 8);
            byte red = (byte) argbColor;
            int abgrColor = ((alpha & 255) << 24) + ((red & 255) << 16) + ((green & 255) << 8) + (blue & 255);
            imageBuffer.put(i, abgrColor);
        }
    }

    private static void flipImages(int width, int height, int numImages, IntBuffer images, IntBuffer images_copy) {
        for (int i = 0; i < numImages; i++) {
            int start_index = i * width * height;
            flipImage(width, height, start_index, images, images_copy);
        }
    }

    private static void flipImage(int width, int height, int start_index, IntBuffer images, IntBuffer images_copy) {
        for (int y = 0; y < (height >> 1); y++) {
            int index_y_1 = (y * width) + start_index;
            int index_y_2 = (((height - y) - 1) * width) + start_index;
            for (int x = 0; x < width; x++) {
                int index1 = index_y_1 + x;
                int index2 = index_y_2 + x;
                int temp_pixel = images.get(index1 + images.position());
                images_copy.put(index1, images.get(index2 + images.position()));
                images_copy.put(index2, temp_pixel);
            }
        }
    }

    Object getHandle() {
        checkValid();
        return this.cursors[this.index].cursorHandle;
    }

    private void checkValid() {
        if (this.destroyed) {
            throw new IllegalStateException("The cursor is destroyed");
        }
    }

    public void destroy() {
        synchronized (OpenGLPackageAccess.global_lock) {
            if (this.destroyed) {
                return;
            }
            if (Mouse.getNativeCursor() == this) {
                try {
                    Mouse.setNativeCursor(null);
                } catch (LWJGLException e) {
                }
            }
            CursorElement[] arr$ = this.cursors;
            for (CursorElement cursor : arr$) {
                Mouse.getImplementation().destroyCursor(cursor.cursorHandle);
            }
            this.destroyed = true;
        }
    }

    protected void setTimeout() {
        checkValid();
        this.cursors[this.index].timeout = System.currentTimeMillis() + this.cursors[this.index].delay;
    }

    protected boolean hasTimedOut() {
        checkValid();
        return this.cursors.length > 1 && this.cursors[this.index].timeout < System.currentTimeMillis();
    }

    protected void nextCursor() {
        checkValid();
        int i = this.index + 1;
        this.index = i;
        this.index = i % this.cursors.length;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/input/Cursor$CursorElement.class */
    private static class CursorElement {
        final Object cursorHandle;
        final long delay;
        long timeout;

        CursorElement(Object cursorHandle, long delay, long timeout) {
            this.cursorHandle = cursorHandle;
            this.delay = delay;
            this.timeout = timeout;
        }
    }
}
