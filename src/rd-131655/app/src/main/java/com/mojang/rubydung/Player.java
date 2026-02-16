package com.mojang.rubydung;

import com.mojang.rubydung.level.Level;
import com.mojang.rubydung.phys.AABB;
import java.util.List;
import org.lwjgl.input.Keyboard;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/Player.class */
public class Player {
    private final Level level;
    public double x;
    public double y;
    public double z;
    public double prevX;
    public double prevY;
    public double prevZ;
    public double motionX;
    public double motionY;
    public double motionZ;
    public float xRotation;
    public float yRotation;
    private boolean onGround;
    public AABB boundingBox;

    public Player(Level level) {
        this.level = level;
        resetPosition();
    }

    private void setPosition(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.boundingBox = new AABB(x - 0.3f, y - 0.9f, z - 0.3f, x + 0.3f, y + 0.9f, z + 0.3f);
    }

    private void resetPosition() {
        float x = ((float) Math.random()) * this.level.width;
        float y = this.level.depth + 3;
        float z = ((float) Math.random()) * this.level.height;
        setPosition(x, y, z);
    }

    public void turn(float x, float y) {
        this.yRotation += x * 0.15f;
        this.xRotation -= y * 0.15f;
        this.xRotation = Math.max(-90.0f, this.xRotation);
        this.xRotation = Math.min(90.0f, this.xRotation);
    }

    public void tick() {
        this.prevX = this.x;
        this.prevY = this.y;
        this.prevZ = this.z;
        float forward = 0.0f;
        float vertical = 0.0f;
        if (Keyboard.isKeyDown(19)) {
            resetPosition();
        }
        if (Keyboard.isKeyDown(200) || Keyboard.isKeyDown(17)) {
            forward = 0.0f - 1.0f;
        }
        if (Keyboard.isKeyDown(208) || Keyboard.isKeyDown(31)) {
            forward += 1.0f;
        }
        if (Keyboard.isKeyDown(203) || Keyboard.isKeyDown(30)) {
            vertical = 0.0f - 1.0f;
        }
        if (Keyboard.isKeyDown(205) || Keyboard.isKeyDown(32)) {
            vertical += 1.0f;
        }
        if ((Keyboard.isKeyDown(57) || Keyboard.isKeyDown(219)) && this.onGround) {
            this.motionY = 0.11999999731779099d;
        }
        moveRelative(vertical, forward, this.onGround ? 0.02f : 0.005f);
        this.motionY -= 0.005d;
        move(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9100000262260437d;
        this.motionY *= 0.9800000190734863d;
        this.motionZ *= 0.9100000262260437d;
        if (this.onGround) {
            this.motionX *= 0.800000011920929d;
            this.motionZ *= 0.800000011920929d;
        }
    }

    public void move(double x, double y, double z) {
        List<AABB> aABBs = this.level.getCubes(this.boundingBox.expand(x, y, z));
        for (AABB abb : aABBs) {
            y = abb.clipYCollide(this.boundingBox, y);
        }
        this.boundingBox.move(0.0d, y, 0.0d);
        for (AABB aABB : aABBs) {
            x = aABB.clipXCollide(this.boundingBox, x);
        }
        this.boundingBox.move(x, 0.0d, 0.0d);
        for (AABB aABB2 : aABBs) {
            z = aABB2.clipZCollide(this.boundingBox, z);
        }
        this.boundingBox.move(0.0d, 0.0d, z);
        this.onGround = y != y && y < 0.0d;
        if (x != x) {
            this.motionX = 0.0d;
        }
        if (y != y) {
            this.motionY = 0.0d;
        }
        if (z != z) {
            this.motionZ = 0.0d;
        }
        this.x = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0d;
        this.y = this.boundingBox.minY + 1.62d;
        this.z = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0d;
    }

    private void moveRelative(float x, float z, float speed) {
        float distance = (x * x) + (z * z);
        if (distance < 0.01f) {
            return;
        }
        float distance2 = speed / ((float) Math.sqrt(distance));
        float x2 = x * distance2;
        float z2 = z * distance2;
        double sin = Math.sin(Math.toRadians(this.yRotation));
        double cos = Math.cos(Math.toRadians(this.yRotation));
        this.motionX += (((double) x2) * cos) - (((double) z2) * sin);
        this.motionZ += (((double) z2) * cos) + (((double) x2) * sin);
    }
}
