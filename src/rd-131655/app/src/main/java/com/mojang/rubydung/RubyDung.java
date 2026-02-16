package com.mojang.rubydung;

import com.mojang.rubydung.level.Chunk;
import com.mojang.rubydung.level.Level;
import com.mojang.rubydung.level.LevelRenderer;
import java.awt.Component;
import java.nio.FloatBuffer;
import javax.swing.JOptionPane;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/RubyDung.class */
public class RubyDung implements Runnable {
    private Level level;
    private LevelRenderer levelRenderer;
    private Player player;
    private final Timer timer = new Timer(60.0f);
    private final FloatBuffer fogColor = BufferUtils.createFloatBuffer(4);

    public void init() throws LWJGLException {
        this.fogColor.put(new float[]{0.05490196f, 0.043137256f, 0.039215688f, 1.0f}).flip();
        Display.setDisplayMode(new DisplayMode(1024, 768));
        Display.create();
        Keyboard.create();
        Mouse.create();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearColor(0.5f, 0.8f, 1.0f, 0.0f);
        GL11.glClearDepth(1.0d);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(70.0f, 1024 / 768, 0.05f, 1000.0f);
        GL11.glMatrixMode(5888);
        this.level = new Level(256, 256, 64);
        this.levelRenderer = new LevelRenderer(this.level);
        this.player = new Player(this.level);
        Mouse.setGrabbed(true);
    }

    public void destroy() {
        this.level.save();
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog((Component) null, e, "Failed to start RubyDung", 0);
            System.exit(0);
        }
        int frames = 0;
        long lastTime = System.currentTimeMillis();
        while (!Keyboard.isKeyDown(1) && !Display.isCloseRequested()) {
            try {
                try {
                    this.timer.advanceTime();
                    for (int i = 0; i < this.timer.ticks; i++) {
                        tick();
                    }
                    render(this.timer.partialTicks);
                    frames++;
                    while (System.currentTimeMillis() >= lastTime + 1000) {
                        System.out.println(frames + " fps, " + Chunk.updates);
                        Chunk.updates = 0;
                        lastTime += 1000;
                        frames = 0;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    destroy();
                    return;
                }
            } finally {
                destroy();
            }
        }
    }

    private void tick() {
        this.player.tick();
    }

    private void moveCameraToPlayer(float partialTicks) {
        Player player = this.player;
        GL11.glTranslatef(0.0f, 0.0f, -0.3f);
        GL11.glRotatef(player.xRotation, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(player.yRotation, 0.0f, 1.0f, 0.0f);
        double x = this.player.prevX + ((this.player.x - this.player.prevX) * ((double) partialTicks));
        double y = this.player.prevY + ((this.player.y - this.player.prevY) * ((double) partialTicks));
        double z = this.player.prevZ + ((this.player.z - this.player.prevZ) * ((double) partialTicks));
        GL11.glTranslated(-x, -y, -z);
    }

    private void render(float partialTicks) {
        float motionX = Mouse.getDX();
        float motionY = Mouse.getDY();
        this.player.turn(motionX, motionY);
        GL11.glClear(16640);
        GL11.glLoadIdentity();
        moveCameraToPlayer(partialTicks);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_LINEAR);
        GL11.glFogf(GL11.GL_FOG_START, -10.0f);
        GL11.glFogf(GL11.GL_FOG_END, 20.0f);
        GL11.glFog(GL11.GL_FOG_COLOR, this.fogColor);
        GL11.glDisable(GL11.GL_FOG);
        this.levelRenderer.render(0);
        GL11.glEnable(GL11.GL_FOG);
        this.levelRenderer.render(1);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        Display.update();
    }

    public static void main(String[] args) {
        new Thread(new RubyDung()).start();
    }
}
