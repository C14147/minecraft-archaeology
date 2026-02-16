package com.mojang.rubydung.level;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/level/Tessellator.class */
public class Tessellator {
    private static final int MAX_VERTICES = 100000;
    private final FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(300000);
    private final FloatBuffer textureCoordinateBuffer = BufferUtils.createFloatBuffer(200000);
    private final FloatBuffer colorBuffer = BufferUtils.createFloatBuffer(300000);
    private int vertices = 0;
    private boolean hasTexture = false;
    private float textureU;
    private float textureV;
    private boolean hasColor;
    private float red;
    private float green;
    private float blue;

    public void init() {
        clear();
    }

    public void vertex(float x, float y, float z) {
        this.vertexBuffer.put(this.vertices * 3, x);
        this.vertexBuffer.put((this.vertices * 3) + 1, y);
        this.vertexBuffer.put((this.vertices * 3) + 2, z);
        if (this.hasTexture) {
            this.textureCoordinateBuffer.put(this.vertices * 2, this.textureU);
            this.textureCoordinateBuffer.put((this.vertices * 2) + 1, this.textureV);
        }
        if (this.hasColor) {
            this.colorBuffer.put(this.vertices * 3, this.red);
            this.colorBuffer.put((this.vertices * 3) + 1, this.green);
            this.colorBuffer.put((this.vertices * 3) + 2, this.blue);
        }
        this.vertices++;
        if (this.vertices == 100000) {
            flush();
        }
    }

    public void texture(float textureU, float textureV) {
        this.hasTexture = true;
        this.textureU = textureU;
        this.textureV = textureV;
    }

    public void color(float red, float green, float blue) {
        this.hasColor = true;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void flush() {
        this.vertexBuffer.flip();
        this.textureCoordinateBuffer.flip();
        GL11.glVertexPointer(3, 0, this.vertexBuffer);
        if (this.hasTexture) {
            GL11.glTexCoordPointer(2, 0, this.textureCoordinateBuffer);
        }
        if (this.hasColor) {
            GL11.glColorPointer(3, 0, this.colorBuffer);
        }
        GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        if (this.hasTexture) {
            GL11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
        }
        if (this.hasColor) {
            GL11.glEnableClientState(GL11.GL_COLOR_ARRAY);
        }
        GL11.glDrawArrays(7, 0, this.vertices);
        GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
        if (this.hasTexture) {
            GL11.glDisableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
        }
        if (this.hasColor) {
            GL11.glDisableClientState(GL11.GL_COLOR_ARRAY);
        }
        clear();
    }

    private void clear() {
        this.vertexBuffer.clear();
        this.textureCoordinateBuffer.clear();
        this.vertices = 0;
        this.hasTexture = false;
        this.hasColor = false;
    }
}
