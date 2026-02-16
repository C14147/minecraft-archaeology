package com.mojang.minecraft.character;

/* JADX INFO: loaded from: pre-Classic rd-20090515.jar:com/mojang/minecraft/character/ZombieModel.class */
public class ZombieModel {
    public Cube head = new Cube(0, 0);
    public Cube body;
    public Cube arm0;
    public Cube arm1;
    public Cube leg0;
    public Cube leg1;

    public ZombieModel() {
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.body = new Cube(16, 16);
        this.body.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.arm0 = new Cube(40, 16);
        this.arm0.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.arm0.setPos(-5.0f, 2.0f, 0.0f);
        this.arm1 = new Cube(40, 16);
        this.arm1.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.arm1.setPos(5.0f, 2.0f, 0.0f);
        this.leg0 = new Cube(0, 16);
        this.leg0.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg0.setPos(-2.0f, 12.0f, 0.0f);
        this.leg1 = new Cube(0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg1.setPos(2.0f, 12.0f, 0.0f);
    }

    public void render(float time) {
        this.head.yRot = ((float) Math.sin(((double) time) * 0.83d)) * 1.0f;
        this.head.xRot = ((float) Math.sin(time)) * 0.8f;
        this.arm0.xRot = ((float) Math.sin((((double) time) * 0.6662d) + 3.141592653589793d)) * 2.0f;
        this.arm0.zRot = ((float) (Math.sin(((double) time) * 0.2312d) + 1.0d)) * 1.0f;
        this.arm1.xRot = ((float) Math.sin(((double) time) * 0.6662d)) * 2.0f;
        this.arm1.zRot = ((float) (Math.sin(((double) time) * 0.2812d) - 1.0d)) * 1.0f;
        this.leg0.xRot = ((float) Math.sin(((double) time) * 0.6662d)) * 1.4f;
        this.leg1.xRot = ((float) Math.sin((((double) time) * 0.6662d) + 3.141592653589793d)) * 1.4f;
        this.head.render();
        this.body.render();
        this.arm0.render();
        this.arm1.render();
        this.leg0.render();
        this.leg1.render();
    }
}
