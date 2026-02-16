package com.mojang.minecraft.particle;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p000a.C0002a;
import com.mojang.minecraft.p000a.C0004c;
import com.mojang.minecraft.player.Player;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.particle.a */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/particle/a.class */
public final class C0041a {

    /* JADX INFO: renamed from: a */
    public List f229a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private C0002a f230b;

    public C0041a(Level level, C0002a c0002a) {
        this.f230b = c0002a;
    }

    /* JADX INFO: renamed from: a */
    public final void m111a(Player player, float f) {
        if (this.f229a.size() == 0) {
            return;
        }
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f230b.m0a("/terrain.png", 9728));
        float f2 = -((float) Math.cos((((double) player.yRot) * 3.141592653589793d) / 180.0d));
        float f3 = -((float) Math.sin((((double) player.yRot) * 3.141592653589793d) / 180.0d));
        float fSin = (-f3) * ((float) Math.sin((((double) player.xRot) * 3.141592653589793d) / 180.0d));
        float fSin2 = f2 * ((float) Math.sin((((double) player.xRot) * 3.141592653589793d) / 180.0d));
        float fCos = (float) Math.cos((((double) player.xRot) * 3.141592653589793d) / 180.0d);
        C0004c c0004c = C0004c.f27a;
        c0004c.m3b();
        for (int i = 0; i < this.f229a.size(); i++) {
            Particle particle = (Particle) this.f229a.get(i);
            float brightness = 0.8f * particle.getBrightness();
            c0004c.m4a(brightness, brightness, brightness);
            particle.render(c0004c, f, f2, fCos, f3, fSin, fSin2);
        }
        c0004c.m1a();
        GL11.glDisable(3553);
    }
}
