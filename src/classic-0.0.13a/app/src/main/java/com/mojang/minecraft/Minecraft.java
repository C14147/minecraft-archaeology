package com.mojang.minecraft;

import com.mojang.minecraft.character.Zombie;
import com.mojang.minecraft.gui.Font;
import com.mojang.minecraft.gui.PauseScreen;
import com.mojang.minecraft.gui.Screen;
import com.mojang.minecraft.level.Chunk;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.LevelIO;
import com.mojang.minecraft.level.LevelLoaderListener;
import com.mojang.minecraft.level.LevelRenderer;
import com.mojang.minecraft.level.levelgen.LevelGen;
import com.mojang.minecraft.level.tile.Tile;
import com.mojang.minecraft.particle.ParticleEngine;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.renderer.Frustum;
import com.mojang.minecraft.renderer.Tesselator;
import com.mojang.minecraft.renderer.Textures;
import java.awt.Canvas;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/Minecraft.class */
public class Minecraft implements Runnable, LevelLoaderListener {
    public static final String VERSION_STRING = "0.0.13a";
    private boolean fullscreen;
    public int width;
    public int height;
    private Level level;
    private LevelRenderer levelRenderer;
    private Player player;
    private ParticleEngine particleEngine;
    private Canvas parent;
    private Cursor emptyCursor;
    public Font font;
    private FloatBuffer fogColor0 = BufferUtils.createFloatBuffer(4);
    private FloatBuffer fogColor1 = BufferUtils.createFloatBuffer(4);
    private Timer timer = new Timer(20.0f);
    private int paintTexture = 1;
    public User user = new User("noname");
    private ArrayList<Entity> entities = new ArrayList<>();
    public boolean appletMode = false;
    public volatile boolean pause = false;
    private int yMouseAxis = 1;
    private int editMode = 0;
    private Screen screen = null;
    private LevelIO levelIo = new LevelIO(this);
    private LevelGen levelGen = new LevelGen(this);
    private volatile boolean running = false;
    private String fpsString = "";
    private boolean mouseGrabbed = false;
    private IntBuffer viewportBuffer = BufferUtils.createIntBuffer(16);
    private IntBuffer selectBuffer = BufferUtils.createIntBuffer(2000);
    private HitResult hitResult = null;

    /* JADX INFO: renamed from: lb */
    FloatBuffer f14lb = BufferUtils.createFloatBuffer(16);
    private String title = "";
    public Textures textures = new Textures();

    public Minecraft(Canvas parent, int width, int height, boolean fullscreen) {
        this.fullscreen = false;
        this.parent = parent;
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
    }

    public void init() throws IOException, LWJGLException {
        boolean success;
        this.fogColor0.put(new float[]{0.5f, 0.8f, 1.0f, 1.0f});
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
        Display.setTitle("Minecraft 0.0.13a");
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
        GL11.glCullFace(1029);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        checkGlError("Startup");
        this.font = new Font("/default.gif", this.textures);
        IntBuffer imgData = BufferUtils.createIntBuffer(256);
        imgData.clear().limit(256);
        GL11.glViewport(0, 0, this.width, this.height);
        this.level = new Level();
        try {
            success = this.levelIo.load(this.level, new FileInputStream(new File("level.dat")));
            if (!success) {
                success = this.levelIo.loadLegacy(this.level, new FileInputStream(new File("level.dat")));
            }
        } catch (Exception e3) {
            success = false;
        }
        if (!success) {
            this.levelGen.generateLevel(this.level, this.user.name, 256, 256, 64);
        }
        this.levelRenderer = new LevelRenderer(this.level, this.textures);
        this.player = new Player(this.level);
        this.particleEngine = new ParticleEngine(this.level, this.textures);
        for (int i = 0; i < 10; i++) {
            Zombie zombie = new Zombie(this.level, this.textures, 128.0f, 0.0f, 128.0f);
            zombie.resetPos();
            this.entities.add(zombie);
        }
        if (this.appletMode) {
            try {
                this.emptyCursor = new Cursor(16, 16, 0, 0, 1, imgData, (IntBuffer) null);
            } catch (LWJGLException e4) {
                e4.printStackTrace();
            }
        }
        checkGlError("Post startup");
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
        if (screen != null) {
            int screenWidth = (this.width * 240) / this.height;
            int screenHeight = (this.height * 240) / this.height;
            screen.init(this, screenWidth, screenHeight);
        }
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

    protected void attemptSaveLevel() {
        try {
            this.levelIo.save(this.level, new FileOutputStream(new File("level.dat")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        attemptSaveLevel();
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
            while (this.running) {
                try {
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
                        render(this.timer.f15a);
                        checkGlError("Post render");
                        frames++;
                        while (System.currentTimeMillis() >= lastTime + 1000) {
                            this.fpsString = String.valueOf(frames) + " fps, " + Chunk.updates + " chunk updates";
                            Chunk.updates = 0;
                            lastTime += 1000;
                            frames = 0;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                } finally {
                    destroy();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
            } catch (LWJGLException e) {
                e.printStackTrace();
            }
        } else {
            Mouse.setGrabbed(true);
        }
        setScreen(null);
    }

    public void releaseMouse() {
        if (this.mouseGrabbed) {
            this.player.releaseAllKeys();
            this.mouseGrabbed = false;
            if (this.appletMode) {
                try {
                    Mouse.setNativeCursor((Cursor) null);
                } catch (LWJGLException e) {
                    e.printStackTrace();
                }
            } else {
                Mouse.setGrabbed(false);
            }
            setScreen(new PauseScreen());
        }
    }

    private void handleMouseClick() {
        if (this.editMode == 0) {
            if (this.hitResult != null) {
                Tile oldTile = Tile.tiles[this.level.getTile(this.hitResult.f10x, this.hitResult.f11y, this.hitResult.f12z)];
                boolean changed = this.level.setTile(this.hitResult.f10x, this.hitResult.f11y, this.hitResult.f12z, 0);
                if (oldTile != null && changed) {
                    oldTile.destroy(this.level, this.hitResult.f10x, this.hitResult.f11y, this.hitResult.f12z, this.particleEngine);
                    return;
                }
                return;
            }
            return;
        }
        if (this.hitResult != null) {
            int x = this.hitResult.f10x;
            int y = this.hitResult.f11y;
            int z = this.hitResult.f12z;
            if (this.hitResult.f13f == 0) {
                y--;
            }
            if (this.hitResult.f13f == 1) {
                y++;
            }
            if (this.hitResult.f13f == 2) {
                z--;
            }
            if (this.hitResult.f13f == 3) {
                z++;
            }
            if (this.hitResult.f13f == 4) {
                x--;
            }
            if (this.hitResult.f13f == 5) {
                x++;
            }
            AABB aabb = Tile.tiles[this.paintTexture].getAABB(x, y, z);
            if (aabb == null || isFree(aabb)) {
                this.level.setTile(x, y, z, this.paintTexture);
            }
        }
    }

    public void tick() {
        if (this.screen == null) {
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
                this.player.setKey(Keyboard.getEventKey(), Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    if (Keyboard.getEventKey() == 1) {
                        releaseMouse();
                    }
                    if (Keyboard.getEventKey() == 28) {
                        attemptSaveLevel();
                    }
                    if (Keyboard.getEventKey() == 19) {
                        this.player.resetPos();
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
                        this.entities.add(new Zombie(this.level, this.textures, this.player.f3x, this.player.f4y, this.player.f5z));
                    }
                    if (Keyboard.getEventKey() == 33) {
                        this.levelRenderer.toggleDrawDistance();
                    }
                }
            }
        }
        if (this.screen != null) {
            this.screen.updateEvents();
            if (this.screen != null) {
                this.screen.tick();
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
        if (this.player.f9bb.intersects(aabb)) {
            return false;
        }
        for (int i = 0; i < this.entities.size(); i++) {
            if (this.entities.get(i).f9bb.intersects(aabb)) {
                return false;
            }
        }
        return true;
    }

    private void moveCameraToPlayer(float a) {
        GL11.glTranslatef(0.0f, 0.0f, -0.3f);
        GL11.glRotatef(this.player.xRot, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(this.player.yRot, 0.0f, 1.0f, 0.0f);
        float x = this.player.f0xo + ((this.player.f3x - this.player.f0xo) * a);
        float y = this.player.f1yo + ((this.player.f4y - this.player.f1yo) * a);
        float z = this.player.f2zo + ((this.player.f5z - this.player.f2zo) * a);
        GL11.glTranslatef(-x, -y, -z);
    }

    private void setupCamera(float a) {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GLU.gluPerspective(70.0f, this.width / this.height, 0.05f, 1024.0f);
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
        GLU.gluPerspective(70.0f, this.width / this.height, 0.05f, 1024.0f);
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
        int[] names = new int[10];
        HitResult bestResult = null;
        for (int i = 0; i < hits; i++) {
            int nameCount = this.selectBuffer.get();
            this.selectBuffer.get();
            this.selectBuffer.get();
            for (int j = 0; j < nameCount; j++) {
                names[j] = this.selectBuffer.get();
            }
            this.hitResult = new HitResult(names[0], names[1], names[2], names[3], names[4]);
            if (bestResult == null || this.hitResult.isCloserThan(this.player, bestResult, this.editMode)) {
                bestResult = this.hitResult;
            }
        }
        this.hitResult = bestResult;
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
        this.levelRenderer.cull(frustum);
        this.levelRenderer.updateDirtyChunks(this.player);
        checkGlError("Update chunks");
        setupFog(0);
        GL11.glEnable(2912);
        this.levelRenderer.render(this.player, 0);
        checkGlError("Rendered level");
        for (int i = 0; i < this.entities.size(); i++) {
            Entity entity = this.entities.get(i);
            if (entity.isLit() && frustum.isVisible(entity.f9bb)) {
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
            if (!zombie.isLit() && frustum.isVisible(zombie.f9bb)) {
                this.entities.get(i2).render(a);
            }
        }
        this.particleEngine.render(this.player, a, 1);
        this.levelRenderer.renderSurroundingGround();
        if (this.hitResult != null) {
            GL11.glDisable(2896);
            GL11.glDisable(3008);
            this.levelRenderer.renderHit(this.player, this.hitResult, this.editMode, this.paintTexture);
            this.levelRenderer.renderHitOutline(this.player, this.hitResult, this.editMode, this.paintTexture);
            GL11.glEnable(3008);
            GL11.glEnable(2896);
        }
        GL11.glBlendFunc(770, 771);
        setupFog(0);
        this.levelRenderer.renderSurroundingWater();
        GL11.glEnable(3042);
        GL11.glColorMask(false, false, false, false);
        this.levelRenderer.render(this.player, 2);
        GL11.glColorMask(true, true, true, true);
        this.levelRenderer.render(this.player, 2);
        GL11.glDisable(3042);
        GL11.glDisable(2896);
        GL11.glDisable(3553);
        GL11.glDisable(2912);
        if (this.hitResult != null) {
            GL11.glDepthFunc(513);
            GL11.glDisable(3008);
            this.levelRenderer.renderHit(this.player, this.hitResult, this.editMode, this.paintTexture);
            this.levelRenderer.renderHitOutline(this.player, this.hitResult, this.editMode, this.paintTexture);
            GL11.glEnable(3008);
            GL11.glDepthFunc(515);
        }
        drawGui(a);
        checkGlError("Rendered gui");
        Display.update();
    }

    private void drawGui(float a) {
        int screenWidth = (this.width * 240) / this.height;
        int screenHeight = (this.height * 240) / this.height;
        int xMouse = (Mouse.getX() * screenWidth) / this.width;
        int yMouse = (screenHeight - ((Mouse.getY() * screenHeight) / this.height)) - 1;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, screenWidth, screenHeight, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
        checkGlError("GUI: Init");
        GL11.glPushMatrix();
        GL11.glTranslatef(screenWidth - 16, 16.0f, -50.0f);
        Tesselator t = Tesselator.instance;
        GL11.glScalef(16.0f, 16.0f, 16.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-1.5f, 0.5f, 0.5f);
        GL11.glScalef(-1.0f, -1.0f, -1.0f);
        int id = this.textures.loadTexture("/terrain.png", 9728);
        GL11.glBindTexture(3553, id);
        GL11.glEnable(3553);
        t.begin();
        Tile.tiles[this.paintTexture].render(t, this.level, 0, -2, 0, 0);
        t.end();
        GL11.glDisable(3553);
        GL11.glPopMatrix();
        checkGlError("GUI: Draw selected");
        this.font.drawShadow(VERSION_STRING, 2, 2, 16777215);
        this.font.drawShadow(this.fpsString, 2, 12, 16777215);
        checkGlError("GUI: Draw text");
        int wc = screenWidth / 2;
        int hc = screenHeight / 2;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        t.begin();
        t.vertex(wc + 1, hc - 4, 0.0f);
        t.vertex(wc - 0, hc - 4, 0.0f);
        t.vertex(wc - 0, hc + 5, 0.0f);
        t.vertex(wc + 1, hc + 5, 0.0f);
        t.vertex(wc + 5, hc - 0, 0.0f);
        t.vertex(wc - 4, hc - 0, 0.0f);
        t.vertex(wc - 4, hc + 1, 0.0f);
        t.vertex(wc + 5, hc + 1, 0.0f);
        t.end();
        checkGlError("GUI: Draw crosshair");
        if (this.screen != null) {
            this.screen.render(xMouse, yMouse);
        }
    }

    private void setupFog(int i) {
        Tile currentTile = Tile.tiles[this.level.getTile((int) this.player.f3x, (int) (this.player.f4y + 0.12f), (int) this.player.f5z)];
        if (currentTile != null && currentTile.getLiquidType() == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1f);
            GL11.glFog(2918, getBuffer(0.02f, 0.02f, 0.2f, 1.0f));
            GL11.glLightModel(2899, getBuffer(0.3f, 0.3f, 0.7f, 1.0f));
        } else if (currentTile != null && currentTile.getLiquidType() == 2) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0f);
            GL11.glFog(2918, getBuffer(0.6f, 0.1f, 0.0f, 1.0f));
            GL11.glLightModel(2899, getBuffer(0.4f, 0.3f, 0.3f, 1.0f));
        } else if (i == 0) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.001f);
            GL11.glFog(2918, this.fogColor0);
            GL11.glLightModel(2899, getBuffer(1.0f, 1.0f, 1.0f, 1.0f));
        } else if (i == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.01f);
            GL11.glFog(2918, this.fogColor1);
            GL11.glLightModel(2899, getBuffer(0.6f, 0.6f, 0.6f, 1.0f));
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
        GL11.glEnable(2896);
    }

    private FloatBuffer getBuffer(float a, float b, float c, float d) {
        this.f14lb.clear();
        this.f14lb.put(a).put(b).put(c).put(d);
        this.f14lb.flip();
        return this.f14lb;
    }

    public static void checkError() {
        int e = GL11.glGetError();
        if (e != 0) {
            throw new IllegalStateException(GLU.gluErrorString(e));
        }
    }

    @Override // com.mojang.minecraft.level.LevelLoaderListener
    public void beginLevelLoading(String title) {
        this.title = title;
        int screenWidth = (this.width * 240) / this.height;
        int screenHeight = (this.height * 240) / this.height;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, screenWidth, screenHeight, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    @Override // com.mojang.minecraft.level.LevelLoaderListener
    public void levelLoadUpdate(String status) {
        int screenWidth = (this.width * 240) / this.height;
        int screenHeight = (this.height * 240) / this.height;
        GL11.glClear(16640);
        Tesselator t = Tesselator.instance;
        GL11.glEnable(3553);
        int id = this.textures.loadTexture("/dirt.png", 9728);
        GL11.glBindTexture(3553, id);
        t.begin();
        t.color(8421504);
        t.vertexUV(0.0f, screenHeight, 0.0f, 0.0f, screenHeight / 32.0f);
        t.vertexUV(screenWidth, screenHeight, 0.0f, screenWidth / 32.0f, screenHeight / 32.0f);
        t.vertexUV(screenWidth, 0.0f, 0.0f, screenWidth / 32.0f, 0.0f);
        t.vertexUV(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        t.end();
        GL11.glEnable(3553);
        this.font.drawShadow(this.title, (screenWidth - this.font.width(this.title)) / 2, ((screenHeight / 2) - 4) - 8, 16777215);
        this.font.drawShadow(status, (screenWidth - this.font.width(status)) / 2, ((screenHeight / 2) - 4) + 4, 16777215);
        Display.update();
        try {
            Thread.sleep(200L);
        } catch (Exception e) {
        }
    }

    public void generateNewLevel() {
        this.levelGen.generateLevel(this.level, this.user.name, 32, 512, 64);
        this.player.resetPos();
        for (int i = 0; i < this.entities.size(); i = (i - 1) + 1) {
            this.entities.remove(i);
        }
    }

    public static void main(String[] args) throws LWJGLException {
        boolean fullScreen = false;
        for (String str : args) {
            if (str.equalsIgnoreCase("-fullscreen")) {
                fullScreen = true;
            }
        }
        Minecraft minecraft = new Minecraft(null, 854, 480, fullScreen);
        new Thread(minecraft).start();
    }
}
