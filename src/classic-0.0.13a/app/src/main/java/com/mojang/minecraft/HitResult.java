package com.mojang.minecraft;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/HitResult.class */
public class HitResult {
    public int type;

    /* JADX INFO: renamed from: x */
    public int f10x;

    /* JADX INFO: renamed from: y */
    public int f11y;

    /* JADX INFO: renamed from: z */
    public int f12z;

    /* JADX INFO: renamed from: f */
    public int f13f;

    public HitResult(int type, int x, int y, int z, int f) {
        this.type = type;
        this.f10x = x;
        this.f11y = y;
        this.f12z = z;
        this.f13f = f;
    }

    public boolean isCloserThan(Player player, HitResult o, int editMode) {
        float dist = distanceTo(player, 0);
        float dist2 = o.distanceTo(player, 0);
        if (dist < dist2) {
            return true;
        }
        float dist3 = distanceTo(player, editMode);
        float dist22 = o.distanceTo(player, editMode);
        return dist3 < dist22;
    }

    private float distanceTo(Player player, int editMode) {
        int xx = this.f10x;
        int yy = this.f11y;
        int zz = this.f12z;
        if (editMode == 1) {
            if (this.f13f == 0) {
                yy--;
            }
            if (this.f13f == 1) {
                yy++;
            }
            if (this.f13f == 2) {
                zz--;
            }
            if (this.f13f == 3) {
                zz++;
            }
            if (this.f13f == 4) {
                xx--;
            }
            if (this.f13f == 5) {
                xx++;
            }
        }
        float xd = xx - player.f3x;
        float yd = yy - player.f4y;
        float zd = zz - player.f5z;
        return (xd * xd) + (yd * yd) + (zd * zd);
    }
}
