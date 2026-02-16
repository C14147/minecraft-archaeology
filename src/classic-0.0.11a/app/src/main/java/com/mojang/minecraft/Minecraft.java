package com.mojang.minecraft;

import com.mojang.minecraft.character.Zombie;
import com.mojang.minecraft.gui.Font;
import com.mojang.minecraft.level.Chunk;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.LevelRenderer;
import com.mojang.minecraft.level.tile.Tile;
import com.mojang.minecraft.particle.ParticleEngine;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.renderer.Frustum;
import com.mojang.minecraft.renderer.Tesselator;
import com.mojang.minecraft.renderer.Textures;
import java.awt.Canvas;
import java.awt.Component;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/Minecraft.class */
public class Minecraft implements Runnable {
    public static final String VERSION_STRING = "0.0.11a";
    private boolean fullscreen;
    private int width;
    private int height;
    private Level level;
    private LevelRenderer levelRenderer;
    private Player player;
    private ParticleEngine particleEngine;
    private Canvas parent;
    private Cursor emptyCursor;
    private Font font;
    private FloatBuffer fogColor0 = BufferUtils.createFloatBuffer(4);
    private FloatBuffer fogColor1 = BufferUtils.createFloatBuffer(4);
    private Timer timer = new Timer(20.0f);
    private int paintTexture = 1;
    private ArrayList<Entity> entities = new ArrayList<>();
    public boolean appletMode = false;
    public volatile boolean pause = false;
    private int yMouseAxis = 1;
    private int editMode = 0;
    private volatile boolean running = false;
    private String fpsString = "";
    private boolean mouseGrabbed = false;
    private IntBuffer viewportBuffer = BufferUtils.createIntBuffer(16);
    private IntBuffer selectBuffer = BufferUtils.createIntBuffer(2000);
    private HitResult hitResult = null;
    FloatBuffer lb = BufferUtils.createFloatBuffer(16);
    public Textures textures = new Textures();

    public Minecraft(Canvas parent, int width, int height, boolean fullscreen) {
        this.fullscreen = false;
        this.parent = parent;
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
    }

    public void init() throws IOException, LWJGLException {
        this.fogColor0.put(new float[]{((16710650 >> 16) & 255) / 255.0f, ((16710650 >> 8) & 255) / 255.0f, (16710650 & 255) / 255.0f, 1.0f});
        this.fogColor0.flip();
        this.fogColor1.put(new float[]{((920330 >> 16) & 255) / 255.0f, ((920330 >> 8) & 255) / 255.0f, (920330 & 255) / 255.0f, 1.0f});
        this.fogColor1.flip();
        if (this.parent != null) {
            Display.setParent(this.parent);
        } else if (this.fullscreen) {
            Display.setFullscreen(true);
            this.width = Display.getDisplayMode().getWidth();
            this.height = Display.getDisplayMode().getHeight();
        } else {
            Display.setDisplayMode(new DisplayMode(this.width, this.height));
        }
        Display.setTitle("Minecraft 0.0.11a");
        try {
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e2) {
            }
            Display.create();
        }
        Keyboard.create();
        Mouse.create();
        checkGlError("Pre startup");
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glClearColor(0.5f, 0.8f, 1.0f, 0.0f);
        GL11.glClearDepth(1.0d);
        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.0f);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        checkGlError("Startup");
        this.level = new Level(256, 256, 64);
        this.levelRenderer = new LevelRenderer(this.level, this.textures);
        this.player = new Player(this.level);
        this.particleEngine = new ParticleEngine(this.level, this.textures);
        this.font = new Font("/default.gif", this.textures);
        for (int i = 0; i < 10; i++) {
            Zombie zombie = new Zombie(this.level, this.textures, 128.0f, 0.0f, 128.0f);
            zombie.resetPos();
            this.entities.add(zombie);
        }
        IntBuffer imgData = BufferUtils.createIntBuffer(256);
        imgData.clear().limit(256);
        if (this.appletMode) {
            try {
                this.emptyCursor = new Cursor(16, 16, 0, 0, 1, imgData, (IntBuffer) null);
            } catch (LWJGLException e3) {
                e3.printStackTrace();
            }
        } else {
            grabMouse();
        }
        checkGlError("Post startup");
    }

    private void checkGlError(String string) {
        int errorCode = GL11.glGetError();
        if (errorCode != 0) {
            String errorString = GLU.gluErrorString(errorCode);
            System.out.println("########## GL ERROR ##########");
            System.out.println("@ " + string);
            System.out.println(String.valueOf(errorCode) + ": " + errorString);
            System.exit(0);
        }
    }

    public void destroy() {
        try {
            this.level.save();
        } catch (Exception e) {
        }
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.lwjgl.LWJGLException */
    @Override // java.lang.Runnable
    public void run() throws LWJGLException {
        this.running = true;
        try {
            init();
            long lastTime = System.currentTimeMillis();
            int frames = 0;
            try {
                while (this.running) {
                    if (this.pause) {
                        Thread.sleep(100L);
                    } else {
                        if (this.parent == null && Display.isCloseRequested()) {
                            stop();
                        }
                        this.timer.advanceTime();
                        for (int i = 0; i < this.timer.ticks; i++) {
                            tick();
                        }
                        checkGlError("Pre render");
                        render(this.timer.a);
                        checkGlError("Post render");
                        frames++;
                        while (System.currentTimeMillis() >= lastTime + 1000) {
                            this.fpsString = String.valueOf(frames) + " fps, " + Chunk.updates + " chunk updates";
                            Chunk.updates = 0;
                            lastTime += 1000;
                            frames = 0;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                destroy();
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog((Component) null, e2.toString(), "Failed to start Minecraft", 0);
        }
    }

    public void stop() {
        this.running = false;
    }

    public void grabMouse() {
        if (this.mouseGrabbed) {
            return;
        }
        this.mouseGrabbed = true;
        if (this.appletMode) {
            try {
                Mouse.setNativeCursor(this.emptyCursor);
                Mouse.setCursorPosition(this.width / 2, this.height / 2);
                return;
            } catch (LWJGLException e) {
                e.printStackTrace();
                return;
            }
        }
        Mouse.setGrabbed(true);
    }

    public void releaseMouse() {
        if (this.mouseGrabbed) {
            this.mouseGrabbed = false;
            if (this.appletMode) {
                try {
                    Mouse.setNativeCursor((Cursor) null);
                    return;
                } catch (LWJGLException e) {
                    e.printStackTrace();
                    return;
                }
            }
            Mouse.setGrabbed(false);
        }
    }

    private void handleMouseClick() {
        if (this.editMode == 0) {
            if (this.hitResult != null) {
                Tile oldTile = Tile.tiles[this.level.getTile(this.hitResult.x, this.hitResult.y, this.hitResult.z)];
                boolean changed = this.level.setTile(this.hitResult.x, this.hitResult.y, this.hitResult.z, 0);
                if (oldTile != null && changed) {
                    oldTile.destroy(this.level, this.hitResult.x, this.hitResult.y, this.hitResult.z, this.particleEngine);
                    return;
                }
                return;
            }
            return;
        }
        if (this.hitResult != null) {
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
            AABB aabb = Tile.tiles[this.paintTexture].getAABB(x, y, z);
            if (aabb == null || isFree(aabb)) {
                this.level.setTile(x, y, z, this.paintTexture);
            }
        }
    }

    public void tick() {
        while (Mouse.next()) {
            if (!this.mouseGrabbed && Mouse.getEventButtonState()) {
                grabMouse();
            } else {
                if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
                    handleMouseClick();
                }
                if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState()) {
                    this.editMode = (this.editMode + 1) % 2;
                }
            }
        }
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == 1 && (this.appletMode || !this.fullscreen)) {
                    releaseMouse();
                }
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
                if (Keyboard.getEventKey() == 7) {
                    this.paintTexture = 6;
                }
                if (Keyboard.getEventKey() == 21) {
                    this.yMouseAxis *= -1;
                }
                if (Keyboard.getEventKey() == 34) {
                    this.entities.add(new Zombie(this.level, this.textures, this.player.x, this.player.y, this.player.z));
                }
            }
        }
        this.level.tick();
        this.particleEngine.tick();
        int i = 0;
        while (i < this.entities.size()) {
            this.entities.get(i).tick();
            if (this.entities.get(i).removed) {
                int i2 = i;
                i--;
                this.entities.remove(i2);
            }
            i++;
        }
        this.player.tick();
    }

    private boolean isFree(AABB aabb) {
        if (this.player.bb.intersects(aabb)) {
            return false;
        }
        for (int i = 0; i < this.entities.size(); i++) {
            if (this.entities.get(i).bb.intersects(aabb)) {
                return false;
            }
        }
        return true;
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
        this.levelRenderer.pick(this.player, Frustum.getFrustum());
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
        if (!Display.isActive()) {
            releaseMouse();
        }
        GL11.glViewport(0, 0, this.width, this.height);
        if (this.mouseGrabbed) {
            float xo = Mouse.getDX();
            float yo = Mouse.getDY();
            if (this.appletMode) {
                Display.processMessages();
                Mouse.poll();
                xo = Mouse.getX() - (this.width / 2);
                yo = Mouse.getY() - (this.height / 2);
                Mouse.setCursorPosition(this.width / 2, this.height / 2);
            }
            this.player.turn(xo, yo * this.yMouseAxis);
        }
        checkGlError("Set viewport");
        pick(a);
        checkGlError("Picked");
        GL11.glClear(16640);
        setupCamera(a);
        checkGlError("Set up camera");
        GL11.glEnable(2884);
        Frustum frustum = Frustum.getFrustum();
        this.levelRenderer.updateDirtyChunks(this.player);
        checkGlError("Update chunks");
        setupFog(0);
        GL11.glEnable(2912);
        this.levelRenderer.render(this.player, 0);
        checkGlError("Rendered level");
        for (int i = 0; i < this.entities.size(); i++) {
            Entity entity = this.entities.get(i);
            if (entity.isLit() && frustum.isVisible(entity.bb)) {
                this.entities.get(i).render(a);
            }
        }
        checkGlError("Rendered entities");
        this.particleEngine.render(this.player, a, 0);
        checkGlError("Rendered particles");
        setupFog(1);
        this.levelRenderer.render(this.player, 1);
        for (int i2 = 0; i2 < this.entities.size(); i2++) {
            Entity zombie = this.entities.get(i2);
            if (!zombie.isLit() && frustum.isVisible(zombie.bb)) {
                this.entities.get(i2).render(a);
            }
        }
        this.particleEngine.render(this.player, a, 1);
        GL11.glDisable(2896);
        GL11.glDisable(3553);
        GL11.glDisable(2912);
        checkGlError("Rendered rest");
        if (this.hitResult != null) {
            GL11.glDisable(3008);
            this.levelRenderer.renderHit(this.hitResult, this.editMode, this.paintTexture);
            GL11.glEnable(3008);
        }
        checkGlError("Rendered hit");
        drawGui(a);
        checkGlError("Rendered gui");
        Display.update();
    }

    private void drawGui(float a) {
        int screenWidth = (this.width * 240) / this.height;
        int screenHeight = (this.height * 240) / this.height;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, screenWidth, screenHeight, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
        checkGlError("GUI: Init");
        GL11.glPushMatrix();
        GL11.glTranslatef(screenWidth - 16, 16.0f, 0.0f);
        Tesselator t = Tesselator.instance;
        GL11.glScalef(16.0f, 16.0f, 16.0f);
        GL11.glRotatef(30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-1.5f, 0.5f, -0.5f);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        int id = this.textures.loadTexture("/terrain.png", 9728);
        GL11.glBindTexture(3553, id);
        GL11.glEnable(3553);
        t.init();
        Tile.tiles[this.paintTexture].render(t, this.level, 0, -2, 0, 0);
        t.flush();
        GL11.glDisable(3553);
        GL11.glPopMatrix();
        checkGlError("GUI: Draw selected");
        this.font.drawShadow(VERSION_STRING, 2, 2, 16777215);
        this.font.drawShadow(this.fpsString, 2, 12, 16777215);
        checkGlError("GUI: Draw text");
        int wc = screenWidth / 2;
        int hc = screenHeight / 2;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        t.init();
        t.vertex(wc + 1, hc - 4, 0.0f);
        t.vertex(wc - 0, hc - 4, 0.0f);
        t.vertex(wc - 0, hc + 5, 0.0f);
        t.vertex(wc + 1, hc + 5, 0.0f);
        t.vertex(wc + 5, hc - 0, 0.0f);
        t.vertex(wc - 4, hc - 0, 0.0f);
        t.vertex(wc - 4, hc + 1, 0.0f);
        t.vertex(wc + 5, hc + 1, 0.0f);
        t.flush();
        checkGlError("GUI: Draw crosshair");
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
            GL11.glFogf(2914, 0.01f);
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
        Minecraft minecraft = new Minecraft(null, 854, 480, false);
        new Thread(minecraft).start();
    }
}
