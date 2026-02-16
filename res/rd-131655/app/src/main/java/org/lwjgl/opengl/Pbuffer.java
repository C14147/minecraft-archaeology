package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Sys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/Pbuffer.class */
public final class Pbuffer extends DrawableGL {
    public static final int PBUFFER_SUPPORTED = 1;
    public static final int RENDER_TEXTURE_SUPPORTED = 2;
    public static final int RENDER_TEXTURE_RECTANGLE_SUPPORTED = 4;
    public static final int RENDER_DEPTH_TEXTURE_SUPPORTED = 8;
    public static final int MIPMAP_LEVEL = 8315;
    public static final int CUBE_MAP_FACE = 8316;
    public static final int TEXTURE_CUBE_MAP_POSITIVE_X = 8317;
    public static final int TEXTURE_CUBE_MAP_NEGATIVE_X = 8318;
    public static final int TEXTURE_CUBE_MAP_POSITIVE_Y = 8319;
    public static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = 8320;
    public static final int TEXTURE_CUBE_MAP_POSITIVE_Z = 8321;
    public static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = 8322;
    public static final int FRONT_LEFT_BUFFER = 8323;
    public static final int FRONT_RIGHT_BUFFER = 8324;
    public static final int BACK_LEFT_BUFFER = 8325;
    public static final int BACK_RIGHT_BUFFER = 8326;
    public static final int DEPTH_BUFFER = 8359;
    private final int width;
    private final int height;

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void setCLSharingProperties(PointerBuffer x0) throws LWJGLException {
        super.setCLSharingProperties(x0);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void releaseContext() throws LWJGLException {
        super.releaseContext();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ void makeCurrent() throws LWJGLException {
        super.makeCurrent();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
    public /* bridge */ /* synthetic */ boolean isCurrent() throws LWJGLException {
        return super.isCurrent();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void initContext(float x0, float x1, float x2) {
        super.initContext(x0, x1, x2);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void swapBuffers() throws LWJGLException {
        super.swapBuffers();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void setSwapInterval(int x0) {
        super.setSwapInterval(x0);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void checkGLError() {
        super.checkGLError();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ ContextGL createSharedContext() throws LWJGLException {
        return super.createSharedContext();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ ContextGL getContext() {
        return super.getContext();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ PixelFormatLWJGL getPixelFormat() {
        return super.getPixelFormat();
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL x0, ContextAttribs x1) throws LWJGLException {
        super.setPixelFormat(x0, x1);
    }

    @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.DrawableLWJGL
    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL x0) throws LWJGLException {
        super.setPixelFormat(x0);
    }

    static {
        Sys.initialize();
    }

    public Pbuffer(int width, int height, PixelFormat pixel_format, Drawable shared_drawable) throws LWJGLException {
        this(width, height, pixel_format, null, shared_drawable);
    }

    public Pbuffer(int width, int height, PixelFormat pixel_format, RenderTexture renderTexture, Drawable shared_drawable) throws LWJGLException {
        this(width, height, pixel_format, renderTexture, shared_drawable, null);
    }

    public Pbuffer(int width, int height, PixelFormat pixel_format, RenderTexture renderTexture, Drawable shared_drawable, ContextAttribs attribs) throws LWJGLException {
        if (pixel_format == null) {
            throw new NullPointerException("Pixel format must be non-null");
        }
        this.width = width;
        this.height = height;
        this.peer_info = createPbuffer(width, height, pixel_format, attribs, renderTexture);
        Context shared_context = null;
        shared_drawable = shared_drawable == null ? Display.getDrawable() : shared_drawable;
        this.context = new ContextGL(this.peer_info, attribs, (ContextGL) (shared_drawable != null ? ((DrawableLWJGL) shared_drawable).getContext() : shared_context));
    }

    private static PeerInfo createPbuffer(int width, int height, PixelFormat pixel_format, ContextAttribs attribs, RenderTexture renderTexture) throws LWJGLException {
        if (renderTexture == null) {
            IntBuffer defaultAttribs = BufferUtils.createIntBuffer(1);
            return Display.getImplementation().createPbuffer(width, height, pixel_format, attribs, null, defaultAttribs);
        }
        return Display.getImplementation().createPbuffer(width, height, pixel_format, attribs, renderTexture.pixelFormatCaps, renderTexture.pBufferAttribs);
    }

    public synchronized boolean isBufferLost() {
        checkDestroyed();
        return Display.getImplementation().isBufferLost(this.peer_info);
    }

    public static int getCapabilities() {
        return Display.getImplementation().getPbufferCapabilities();
    }

    public synchronized void setAttrib(int attrib, int value) {
        checkDestroyed();
        Display.getImplementation().setPbufferAttrib(this.peer_info, attrib, value);
    }

    public synchronized void bindTexImage(int buffer) {
        checkDestroyed();
        Display.getImplementation().bindTexImageToPbuffer(this.peer_info, buffer);
    }

    public synchronized void releaseTexImage(int buffer) {
        checkDestroyed();
        Display.getImplementation().releaseTexImageFromPbuffer(this.peer_info, buffer);
    }

    public synchronized int getHeight() {
        checkDestroyed();
        return this.height;
    }

    public synchronized int getWidth() {
        checkDestroyed();
        return this.width;
    }
}
