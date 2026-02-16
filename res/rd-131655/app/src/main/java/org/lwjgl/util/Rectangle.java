package org.lwjgl.util;

import java.io.Serializable;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/Rectangle.class */
public final class Rectangle implements ReadableRectangle, WritableRectangle, Serializable {
    static final long serialVersionUID = 1;
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public Rectangle(ReadablePoint p, ReadableDimension d) {
        this.x = p.getX();
        this.y = p.getY();
        this.width = d.getWidth();
        this.height = d.getHeight();
    }

    public Rectangle(ReadableRectangle r) {
        this.x = r.getX();
        this.y = r.getY();
        this.width = r.getWidth();
        this.height = r.getHeight();
    }

    @Override // org.lwjgl.util.WritablePoint
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override // org.lwjgl.util.WritablePoint
    public void setLocation(ReadablePoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    @Override // org.lwjgl.util.WritableDimension
    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }

    @Override // org.lwjgl.util.WritableDimension
    public void setSize(ReadableDimension d) {
        this.width = d.getWidth();
        this.height = d.getHeight();
    }

    @Override // org.lwjgl.util.WritableRectangle
    public void setBounds(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    @Override // org.lwjgl.util.WritableRectangle
    public void setBounds(ReadablePoint p, ReadableDimension d) {
        this.x = p.getX();
        this.y = p.getY();
        this.width = d.getWidth();
        this.height = d.getHeight();
    }

    @Override // org.lwjgl.util.WritableRectangle
    public void setBounds(ReadableRectangle r) {
        this.x = r.getX();
        this.y = r.getY();
        this.width = r.getWidth();
        this.height = r.getHeight();
    }

    @Override // org.lwjgl.util.ReadableRectangle
    public void getBounds(WritableRectangle dest) {
        dest.setBounds(this.x, this.y, this.width, this.height);
    }

    @Override // org.lwjgl.util.ReadablePoint
    public void getLocation(WritablePoint dest) {
        dest.setLocation(this.x, this.y);
    }

    @Override // org.lwjgl.util.ReadableDimension
    public void getSize(WritableDimension dest) {
        dest.setSize(this.width, this.height);
    }

    public void translate(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void translate(ReadablePoint point) {
        this.x += point.getX();
        this.y += point.getY();
    }

    public void untranslate(ReadablePoint point) {
        this.x -= point.getX();
        this.y -= point.getY();
    }

    public boolean contains(ReadablePoint p) {
        return contains(p.getX(), p.getY());
    }

    public boolean contains(int X, int Y) {
        int w = this.width;
        int h = this.height;
        if ((w | h) < 0) {
            return false;
        }
        int x = this.x;
        int y = this.y;
        if (X < x || Y < y) {
            return false;
        }
        int w2 = w + x;
        int h2 = h + y;
        return (w2 < x || w2 > X) && (h2 < y || h2 > Y);
    }

    public boolean contains(ReadableRectangle r) {
        return contains(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    public boolean contains(int X, int Y, int W, int H) {
        int w = this.width;
        int h = this.height;
        if ((w | h | W | H) < 0) {
            return false;
        }
        int x = this.x;
        int y = this.y;
        if (X < x || Y < y) {
            return false;
        }
        int w2 = w + x;
        int W2 = W + X;
        if (W2 <= X) {
            if (w2 >= x || W2 > w2) {
                return false;
            }
        } else if (w2 >= x && W2 > w2) {
            return false;
        }
        int h2 = h + y;
        int H2 = H + Y;
        if (H2 <= Y) {
            if (h2 >= y || H2 > h2) {
                return false;
            }
            return true;
        }
        if (h2 >= y && H2 > h2) {
            return false;
        }
        return true;
    }

    public boolean intersects(ReadableRectangle r) {
        int tw = this.width;
        int th = this.height;
        int rw = r.getWidth();
        int rh = r.getHeight();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = r.getX();
        int ry = r.getY();
        int rw2 = rw + rx;
        int rh2 = rh + ry;
        int tw2 = tw + tx;
        int th2 = th + ty;
        return (rw2 < rx || rw2 > tx) && (rh2 < ry || rh2 > ty) && ((tw2 < tx || tw2 > rx) && (th2 < ty || th2 > ry));
    }

    public Rectangle intersection(ReadableRectangle r, Rectangle dest) {
        int tx1 = this.x;
        int ty1 = this.y;
        int rx1 = r.getX();
        int ry1 = r.getY();
        long tx2 = ((long) tx1) + ((long) this.width);
        long ty2 = ((long) ty1) + ((long) this.height);
        long rx2 = ((long) rx1) + ((long) r.getWidth());
        long ry2 = ((long) ry1) + ((long) r.getHeight());
        if (tx1 < rx1) {
            tx1 = rx1;
        }
        if (ty1 < ry1) {
            ty1 = ry1;
        }
        if (tx2 > rx2) {
            tx2 = rx2;
        }
        if (ty2 > ry2) {
            ty2 = ry2;
        }
        long tx22 = tx2 - ((long) tx1);
        long ty22 = ty2 - ((long) ty1);
        if (tx22 < -2147483648L) {
            tx22 = -2147483648L;
        }
        if (ty22 < -2147483648L) {
            ty22 = -2147483648L;
        }
        if (dest == null) {
            dest = new Rectangle(tx1, ty1, (int) tx22, (int) ty22);
        } else {
            dest.setBounds(tx1, ty1, (int) tx22, (int) ty22);
        }
        return dest;
    }

    public WritableRectangle union(ReadableRectangle r, WritableRectangle dest) {
        int x1 = Math.min(this.x, r.getX());
        int x2 = Math.max(this.x + this.width, r.getX() + r.getWidth());
        int y1 = Math.min(this.y, r.getY());
        int y2 = Math.max(this.y + this.height, r.getY() + r.getHeight());
        dest.setBounds(x1, y1, x2 - x1, y2 - y1);
        return dest;
    }

    public void add(int newx, int newy) {
        int x1 = Math.min(this.x, newx);
        int x2 = Math.max(this.x + this.width, newx);
        int y1 = Math.min(this.y, newy);
        int y2 = Math.max(this.y + this.height, newy);
        this.x = x1;
        this.y = y1;
        this.width = x2 - x1;
        this.height = y2 - y1;
    }

    public void add(ReadablePoint pt) {
        add(pt.getX(), pt.getY());
    }

    public void add(ReadableRectangle r) {
        int x1 = Math.min(this.x, r.getX());
        int x2 = Math.max(this.x + this.width, r.getX() + r.getWidth());
        int y1 = Math.min(this.y, r.getY());
        int y2 = Math.max(this.y + this.height, r.getY() + r.getHeight());
        this.x = x1;
        this.y = y1;
        this.width = x2 - x1;
        this.height = y2 - y1;
    }

    public void grow(int h, int v) {
        this.x -= h;
        this.y -= v;
        this.width += h * 2;
        this.height += v * 2;
    }

    public boolean isEmpty() {
        return this.width <= 0 || this.height <= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle r = (Rectangle) obj;
            return this.x == r.x && this.y == r.y && this.width == r.width && this.height == r.height;
        }
        return super.equals(obj);
    }

    public String toString() {
        return getClass().getName() + "[x=" + this.x + ",y=" + this.y + ",width=" + this.width + ",height=" + this.height + "]";
    }

    @Override // org.lwjgl.util.ReadableDimension
    public int getHeight() {
        return this.height;
    }

    @Override // org.lwjgl.util.WritableDimension
    public void setHeight(int height) {
        this.height = height;
    }

    @Override // org.lwjgl.util.ReadableDimension
    public int getWidth() {
        return this.width;
    }

    @Override // org.lwjgl.util.WritableDimension
    public void setWidth(int width) {
        this.width = width;
    }

    @Override // org.lwjgl.util.ReadablePoint
    public int getX() {
        return this.x;
    }

    @Override // org.lwjgl.util.WritablePoint
    public void setX(int x) {
        this.x = x;
    }

    @Override // org.lwjgl.util.ReadablePoint
    public int getY() {
        return this.y;
    }

    @Override // org.lwjgl.util.WritablePoint
    public void setY(int y) {
        this.y = y;
    }
}
