package com.mojang.minecraft.particle;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p001a.C0003a;
import com.mojang.minecraft.p001a.C0005c;
import com.mojang.minecraft.player.Player;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.particle.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/particle/a.class */
public final class C0049a {

    /* JADX INFO: renamed from: a */
    public List f290a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private C0003a f291b;

    public C0049a(Level level, C0003a c0003a) {
        this.f291b = c0003a;
    }

    /* JADX INFO: renamed from: a */
    public final void m127a(Player player, float f) {
        if (this.f290a.size() == 0) {
            return;
        }
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f291b.m4a("/terrain.png", 9728));
        float f2 = -((float) Math.cos((((double) player.yRot) * 3.141592653589793d) / 180.0d));
        float f3 = -((float) Math.sin((((double) player.yRot) * 3.141592653589793d) / 180.0d));
        float fSin = (-f3) * ((float) Math.sin((((double) player.xRot) * 3.141592653589793d) / 180.0d));
        float fSin2 = f2 * ((float) Math.sin((((double) player.xRot) * 3.141592653589793d) / 180.0d));
        float fCos = (float) Math.cos((((double) player.xRot) * 3.141592653589793d) / 180.0d);
        C0005c c0005c = C0005c.f35a;
        c0005c.m7b();
        for (int i = 0; i < this.f290a.size(); i++) {
            Particle particle = (Particle) this.f290a.get(i);
            float brightness = 0.8f * particle.getBrightness();
            c0005c.m8a(brightness, brightness, brightness);
            particle.render(c0005c, f, f2, fCos, f3, fSin, fSin2);
        }
        c0005c.m5a();
        GL11.glDisable(3553);
    }
}
