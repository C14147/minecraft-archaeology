package com.mojang.minecraft.particle;

import com.mojang.minecraft.Player;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.renderer.Tesselator;
import com.mojang.minecraft.renderer.Textures;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/particle/ParticleEngine.class */
public class ParticleEngine {
    protected Level level;
    private List<Particle> particles = new ArrayList();
    private Textures textures;

    public ParticleEngine(Level level, Textures textures) {
        this.level = level;
        this.textures = textures;
    }

    public void add(Particle p) {
        this.particles.add(p);
    }

    public void tick() {
        int i = 0;
        while (i < this.particles.size()) {
            Particle p = this.particles.get(i);
            p.tick();
            if (p.removed) {
                int i2 = i;
                i--;
                this.particles.remove(i2);
            }
            i++;
        }
    }

    public void render(Player player, float a, int layer) {
        if (this.particles.size() == 0) {
            return;
        }
        GL11.glEnable(3553);
        int id = this.textures.loadTexture("/terrain.png", 9728);
        GL11.glBindTexture(3553, id);
        float xa = -((float) Math.cos((((double) player.yRot) * 3.141592653589793d) / 180.0d));
        float za = -((float) Math.sin((((double) player.yRot) * 3.141592653589793d) / 180.0d));
        float xa2 = (-za) * ((float) Math.sin((((double) player.xRot) * 3.141592653589793d) / 180.0d));
        float za2 = xa * ((float) Math.sin((((double) player.xRot) * 3.141592653589793d) / 180.0d));
        float ya = (float) Math.cos((((double) player.xRot) * 3.141592653589793d) / 180.0d);
        Tesselator t = Tesselator.instance;
        GL11.glColor4f(0.8f, 0.8f, 0.8f, 1.0f);
        t.begin();
        for (int i = 0; i < this.particles.size(); i++) {
            Particle p = this.particles.get(i);
            if (p.isLit() ^ (layer == 1)) {
                p.render(t, a, xa, ya, za, xa2, za2);
            }
        }
        t.end();
        GL11.glDisable(3553);
    }
}
