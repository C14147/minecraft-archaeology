package com.mojang.rubydung.phys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/phys/AABB.class */
public class AABB {
    private final double epsilon = 0.0d;
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;

    public AABB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AABB m4clone() {
        return new AABB(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    public AABB expand(double x, double y, double z) {
        double minX = this.minX;
        double minY = this.minY;
        double minZ = this.minZ;
        double maxX = this.maxX;
        double maxY = this.maxY;
        double maxZ = this.maxZ;
        if (x < 0.0d) {
            minX += x;
        } else {
            maxX += x;
        }
        if (y < 0.0d) {
            minY += y;
        } else {
            maxY += y;
        }
        if (z < 0.0d) {
            minZ += z;
        } else {
            maxZ += z;
        }
        return new AABB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public AABB grow(double x, double y, double z) {
        return new AABB(this.minX - x, this.minY - y, this.minZ - z, this.maxX + x, this.maxY + y, this.maxZ + z);
    }

    public double clipXCollide(AABB otherBoundingBox, double x) {
        if (otherBoundingBox.maxY <= this.minY || otherBoundingBox.minY >= this.maxY) {
            return x;
        }
        if (otherBoundingBox.maxZ <= this.minZ || otherBoundingBox.minZ >= this.maxZ) {
            return x;
        }
        if (x > 0.0d && otherBoundingBox.maxX <= this.minX) {
            double d = this.minX - otherBoundingBox.maxX;
            getClass();
            double max = d - 0.0d;
            if (max < x) {
                x = max;
            }
        }
        if (x < 0.0d && otherBoundingBox.minX >= this.maxX) {
            double d2 = this.maxX - otherBoundingBox.minX;
            getClass();
            double max2 = d2 + 0.0d;
            if (max2 > x) {
                x = max2;
            }
        }
        return x;
    }

    public double clipYCollide(AABB otherBoundingBox, double y) {
        if (otherBoundingBox.maxX <= this.minX || otherBoundingBox.minX >= this.maxX) {
            return y;
        }
        if (otherBoundingBox.maxZ <= this.minZ || otherBoundingBox.minZ >= this.maxZ) {
            return y;
        }
        if (y > 0.0d && otherBoundingBox.maxY <= this.minY) {
            double d = this.minY - otherBoundingBox.maxY;
            getClass();
            double max = d - 0.0d;
            if (max < y) {
                y = max;
            }
        }
        if (y < 0.0d && otherBoundingBox.minY >= this.maxY) {
            double d2 = this.maxY - otherBoundingBox.minY;
            getClass();
            double max2 = d2 + 0.0d;
            if (max2 > y) {
                y = max2;
            }
        }
        return y;
    }

    public double clipZCollide(AABB otherBoundingBox, double z) {
        if (otherBoundingBox.maxX <= this.minX || otherBoundingBox.minX >= this.maxX) {
            return z;
        }
        if (otherBoundingBox.maxY <= this.minY || otherBoundingBox.minY >= this.maxY) {
            return z;
        }
        if (z > 0.0d && otherBoundingBox.maxZ <= this.minZ) {
            double d = this.minZ - otherBoundingBox.maxZ;
            getClass();
            double max = d - 0.0d;
            if (max < z) {
                z = max;
            }
        }
        if (z < 0.0d && otherBoundingBox.minZ >= this.maxZ) {
            double d2 = this.maxZ - otherBoundingBox.minZ;
            getClass();
            double max2 = d2 + 0.0d;
            if (max2 > z) {
                z = max2;
            }
        }
        return z;
    }

    public boolean intersects(AABB otherBoundingBox) {
        return otherBoundingBox.maxX > this.minX && otherBoundingBox.minX < this.maxX && otherBoundingBox.maxY > this.minY && otherBoundingBox.minY < this.maxY && otherBoundingBox.maxZ > this.minZ && otherBoundingBox.minZ < this.maxZ;
    }

    public void move(double x, double y, double z) {
        this.minX += x;
        this.minY += y;
        this.minZ += z;
        this.maxX += x;
        this.maxY += y;
        this.maxZ += z;
    }

    public AABB offset(double x, double y, double z) {
        return new AABB(this.minX + x, this.minY + y, this.minZ + z, this.maxX + x, this.maxY + y, this.maxZ + z);
    }
}
