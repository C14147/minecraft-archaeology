package com.mojang.rubydung;

import com.mojang.rubydung.character.Zombie;
import com.mojang.rubydung.level.Chunk;
import com.mojang.rubydung.level.Frustum;
import com.mojang.rubydung.level.Level;
import com.mojang.rubydung.level.LevelRenderer;
import com.mojang.rubydung.level.Tesselator;
import com.mojang.rubydung.level.tile.Tile;
import com.mojang.rubydung.particle.ParticleEngine;
import java.awt.Component;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: loaded from: pre-Classic rd-160052.jar:com/mojang/rubydung/RubyDung.class */
public class RubyDung implements Runnable {
    private static final boolean FULLSCREEN_MODE = true;
    private int width;
    private int height;
    private Level level;
    private LevelRenderer levelRenderer;
    private Player player;
    private ParticleEngine particleEngine;
    private FloatBuffer fogColor0 = BufferUtils.createFloatBuffer(4);
    private FloatBuffer fogColor1 = BufferUtils.createFloatBuffer(4);
    private Timer timer = new Timer(20.0f);
    private int paintTexture = 1;
    private ArrayList<Zombie> zombies = new ArrayList<>();
    private IntBuffer viewportBuffer = BufferUtils.createIntBuffer(16);
    private IntBuffer selectBuffer = BufferUtils.createIntBuffer(2000);
    private HitResult hitResult = null;
    FloatBuffer lb = BufferUtils.createFloatBuffer(16);

    public void init() throws IOException, LWJGLException {
        this.fogColor0.put(new float[]{((16710650 >> 16) & 255) / 255.0f, ((16710650 >> 8) & 255) / 255.0f, (16710650 & 255) / 255.0f, 1.0f});
        this.fogColor0.flip();
        this.fogColor1.put(new float[]{((920330 >> 16) & 255) / 255.0f, ((920330 >> 8) & 255) / 255.0f, (920330 & 255) / 255.0f, 1.0f});
        this.fogColor1.flip();
        Display.setFullscreen(true);
        Display.create();
        Keyboard.create();
        Mouse.create();
        this.width = Display.getDisplayMode().getWidth();
        this.height = Display.getDisplayMode().getHeight();
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glClearColor(0.5f, 0.8f, 1.0f, 0.0f);
        GL11.glClearDepth(1.0d);
        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        this.level = new Level(256, 256, 64);
        this.levelRenderer = new LevelRenderer(this.level);
        this.player = new Player(this.level);
        this.particleEngine = new ParticleEngine(this.level);
        Mouse.setGrabbed(true);
        for (int i = 0; i < 10; i++) {
            Zombie zombie = new Zombie(this.level, 128.0f, 0.0f, 128.0f);
            zombie.resetPos();
            this.zombies.add(zombie);
        }
    }

    public void destroy() {
        this.level.save();
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.lwjgl.LWJGLException */
    @Override // java.lang.Runnable
    public void run() throws LWJGLException {
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog((Component) null, e.toString(), "Failed to start RubyDung", 0);
            System.exit(0);
        }
        long lastTime = System.currentTimeMillis();
        int frames = 0;
        try {
            while (!Keyboard.isKeyDown(1) && !Display.isCloseRequested()) {
                this.timer.advanceTime();
                for (int i = 0; i < this.timer.ticks; i++) {
                    tick();
                }
                render(this.timer.a);
                frames++;
                while (System.currentTimeMillis() >= lastTime + 1000) {
                    System.out.println(String.valueOf(frames) + " fps, " + Chunk.updates);
                    Chunk.updates = 0;
                    lastTime += 1000;
                    frames = 0;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            destroy();
        }
    }

    public void tick() {
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == 28) {
                    this.level.save();
                }
                if (Keyboard.getEventKey() == 2) {
                    this.paintTexture = 1;
                }
                if (Keyboard.getEventKey() == 3) {
                    this.paintTexture = 3;
                }
                if (Keyboard.getEventKey() == 4) {
                    this.paintTexture = 4;
                }
                if (Keyboard.getEventKey() == 5) {
                    this.paintTexture = 5;
                }
                if (Keyboard.getEventKey() == 34) {
                    this.zombies.add(new Zombie(this.level, this.player.x, this.player.y, this.player.z));
                }
            }
        }
        this.level.tick();
        this.particleEngine.tick();
        int i = 0;
        while (i < this.zombies.size()) {
            this.zombies.get(i).tick();
            if (this.zombies.get(i).removed) {
                int i2 = i;
                i--;
                this.zombies.remove(i2);
            }
            i++;
        }
        this.player.tick();
    }

    private void moveCameraToPlayer(float a) {
        GL11.glTranslatef(0.0f, 0.0f, -0.3f);
        GL11.glRotatef(this.player.xRot, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(this.player.yRot, 0.0f, 1.0f, 0.0f);
        float x = this.player.xo + ((this.player.x - this.player.xo) * a);
        float y = this.player.yo + ((this.player.y - this.player.yo) * a);
        float z = this.player.zo + ((this.player.z - this.player.zo) * a);
        GL11.glTranslatef(-x, -y, -z);
    }

    private void setupCamera(float a) {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GLU.gluPerspective(70.0f, this.width / this.height, 0.05f, 1000.0f);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        moveCameraToPlayer(a);
    }

    private void setupOrthoCamera() {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, this.width, this.height, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    private void setupPickCamera(float a, int x, int y) {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        this.viewportBuffer.clear();
        GL11.glGetInteger(2978, this.viewportBuffer);
        this.viewportBuffer.flip();
        this.viewportBuffer.limit(16);
        GLU.gluPickMatrix(x, y, 5.0f, 5.0f, this.viewportBuffer);
        GLU.gluPerspective(70.0f, this.width / this.height, 0.05f, 1000.0f);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        moveCameraToPlayer(a);
    }

    private void pick(float a) {
        this.selectBuffer.clear();
        GL11.glSelectBuffer(this.selectBuffer);
        GL11.glRenderMode(7170);
        setupPickCamera(a, this.width / 2, this.height / 2);
        this.levelRenderer.pick(this.player);
        int hits = GL11.glRenderMode(7168);
        this.selectBuffer.flip();
        this.selectBuffer.limit(this.selectBuffer.capacity());
        long closest = 0;
        int[] names = new int[10];
        int hitNameCount = 0;
        for (int i = 0; i < hits; i++) {
            int nameCount = this.selectBuffer.get();
            long minZ = this.selectBuffer.get();
            this.selectBuffer.get();
            if (minZ < closest || i == 0) {
                closest = minZ;
                hitNameCount = nameCount;
                for (int j = 0; j < nameCount; j++) {
                    names[j] = this.selectBuffer.get();
                }
            } else {
                for (int j2 = 0; j2 < nameCount; j2++) {
                    this.selectBuffer.get();
                }
            }
        }
        if (hitNameCount > 0) {
            this.hitResult = new HitResult(names[0], names[1], names[2], names[3], names[4]);
        } else {
            this.hitResult = null;
        }
    }

    public void render(float a) {
        float xo = Mouse.getDX();
        float yo = Mouse.getDY();
        this.player.turn(xo, yo);
        pick(a);
        while (Mouse.next()) {
            if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState() && this.hitResult != null) {
                Tile oldTile = Tile.tiles[this.level.getTile(this.hitResult.x, this.hitResult.y, this.hitResult.z)];
                boolean changed = this.level.setTile(this.hitResult.x, this.hitResult.y, this.hitResult.z, 0);
                if (oldTile != null && changed) {
                    oldTile.destroy(this.level, this.hitResult.x, this.hitResult.y, this.hitResult.z, this.particleEngine);
                }
            }
            if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.hitResult != null) {
                int x = this.hitResult.x;
                int y = this.hitResult.y;
                int z = this.hitResult.z;
                if (this.hitResult.f == 0) {
                    y--;
                }
                if (this.hitResult.f == 1) {
                    y++;
                }
                if (this.hitResult.f == 2) {
                    z--;
                }
                if (this.hitResult.f == 3) {
                    z++;
                }
                if (this.hitResult.f == 4) {
                    x--;
                }
                if (this.hitResult.f == 5) {
                    x++;
                }
                this.level.setTile(x, y, z, this.paintTexture);
            }
        }
        GL11.glClear(16640);
        setupCamera(a);
        GL11.glEnable(2884);
        Frustum frustum = Frustum.getFrustum();
        this.levelRenderer.updateDirtyChunks(this.player);
        setupFog(0);
        GL11.glEnable(2912);
        this.levelRenderer.render(this.player, 0);
        for (int i = 0; i < this.zombies.size(); i++) {
            Zombie zombie = this.zombies.get(i);
            if (zombie.isLit() && frustum.isVisible(zombie.bb)) {
                this.zombies.get(i).render(a);
            }
        }
        this.particleEngine.render(this.player, a, 0);
        setupFog(1);
        this.levelRenderer.render(this.player, 1);
        for (int i2 = 0; i2 < this.zombies.size(); i2++) {
            Zombie zombie2 = this.zombies.get(i2);
            if (!zombie2.isLit() && frustum.isVisible(zombie2.bb)) {
                this.zombies.get(i2).render(a);
            }
        }
        this.particleEngine.render(this.player, a, 1);
        GL11.glDisable(2896);
        GL11.glDisable(3553);
        GL11.glDisable(2912);
        if (this.hitResult != null) {
            this.levelRenderer.renderHit(this.hitResult);
        }
        drawGui(a);
        Display.update();
    }

    private void drawGui(float a) {
        GL11.glClear(256);
        setupOrthoCamera();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.width - 48, 48.0f, 0.0f);
        Tesselator t = Tesselator.instance;
        GL11.glScalef(48.0f, 48.0f, 48.0f);
        GL11.glRotatef(30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(1.5f, -0.5f, -0.5f);
        int id = Textures.loadTexture("/terrain.png", 9728);
        GL11.glBindTexture(3553, id);
        GL11.glEnable(3553);
        t.init();
        Tile.tiles[this.paintTexture].render(t, this.level, 0, -2, 0, 0);
        t.flush();
        GL11.glDisable(3553);
        GL11.glPopMatrix();
        int wc = this.width / 2;
        int hc = this.height / 2;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        t.init();
        t.vertex(wc + 1, hc - 8, 0.0f);
        t.vertex(wc - 0, hc - 8, 0.0f);
        t.vertex(wc - 0, hc + 9, 0.0f);
        t.vertex(wc + 1, hc + 9, 0.0f);
        t.vertex(wc + 9, hc - 0, 0.0f);
        t.vertex(wc - 8, hc - 0, 0.0f);
        t.vertex(wc - 8, hc + 1, 0.0f);
        t.vertex(wc + 9, hc + 1, 0.0f);
        t.flush();
    }

    private void setupFog(int i) {
        if (i == 0) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.001f);
            GL11.glFog(2918, this.fogColor0);
            GL11.glDisable(2896);
            return;
        }
        if (i == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.06f);
            GL11.glFog(2918, this.fogColor1);
            GL11.glEnable(2896);
            GL11.glEnable(2903);
            GL11.glLightModel(2899, getBuffer(0.6f, 0.6f, 0.6f, 1.0f));
        }
    }

    private FloatBuffer getBuffer(float a, float b, float c, float d) {
        this.lb.clear();
        this.lb.put(a).put(b).put(c).put(d);
        this.lb.flip();
        return this.lb;
    }

    public static void checkError() {
        int e = GL11.glGetError();
        if (e != 0) {
            throw new IllegalStateException(GLU.gluErrorString(e));
        }
    }

    public static void main(String[] args) throws LWJGLException {
        new Thread(new RubyDung()).start();
    }
}
