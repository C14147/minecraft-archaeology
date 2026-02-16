package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Geom.class */
class Geom {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Geom.class.desiredAssertionStatus();
    }

    private Geom() {
    }

    static double EdgeEval(GLUvertex u, GLUvertex v, GLUvertex w) {
        if (!$assertionsDisabled && (!VertLeq(u, v) || !VertLeq(v, w))) {
            throw new AssertionError();
        }
        double gapL = v.s - u.s;
        double gapR = w.s - v.s;
        if (gapL + gapR <= 0.0d) {
            return 0.0d;
        }
        if (gapL < gapR) {
            return (v.t - u.t) + ((u.t - w.t) * (gapL / (gapL + gapR)));
        }
        return (v.t - w.t) + ((w.t - u.t) * (gapR / (gapL + gapR)));
    }

    static double EdgeSign(GLUvertex u, GLUvertex v, GLUvertex w) {
        if (!$assertionsDisabled && (!VertLeq(u, v) || !VertLeq(v, w))) {
            throw new AssertionError();
        }
        double gapL = v.s - u.s;
        double gapR = w.s - v.s;
        if (gapL + gapR > 0.0d) {
            return ((v.t - w.t) * gapL) + ((v.t - u.t) * gapR);
        }
        return 0.0d;
    }

    static double TransEval(GLUvertex u, GLUvertex v, GLUvertex w) {
        if (!$assertionsDisabled && (!TransLeq(u, v) || !TransLeq(v, w))) {
            throw new AssertionError();
        }
        double gapL = v.t - u.t;
        double gapR = w.t - v.t;
        if (gapL + gapR <= 0.0d) {
            return 0.0d;
        }
        if (gapL < gapR) {
            return (v.s - u.s) + ((u.s - w.s) * (gapL / (gapL + gapR)));
        }
        return (v.s - w.s) + ((w.s - u.s) * (gapR / (gapL + gapR)));
    }

    static double TransSign(GLUvertex u, GLUvertex v, GLUvertex w) {
        if (!$assertionsDisabled && (!TransLeq(u, v) || !TransLeq(v, w))) {
            throw new AssertionError();
        }
        double gapL = v.t - u.t;
        double gapR = w.t - v.t;
        if (gapL + gapR > 0.0d) {
            return ((v.s - w.s) * gapL) + ((v.s - u.s) * gapR);
        }
        return 0.0d;
    }

    static boolean VertCCW(GLUvertex u, GLUvertex v, GLUvertex w) {
        return ((u.s * (v.t - w.t)) + (v.s * (w.t - u.t))) + (w.s * (u.t - v.t)) >= 0.0d;
    }

    static double Interpolate(double a, double x, double b, double y) {
        double a2 = a < 0.0d ? 0.0d : a;
        double b2 = b < 0.0d ? 0.0d : b;
        if (a2 > b2) {
            return y + ((x - y) * (b2 / (a2 + b2)));
        }
        if (b2 == 0.0d) {
            return (x + y) / 2.0d;
        }
        return x + ((y - x) * (a2 / (a2 + b2)));
    }

    static void EdgeIntersect(GLUvertex o1, GLUvertex d1, GLUvertex o2, GLUvertex d2, GLUvertex v) {
        if (!VertLeq(o1, d1)) {
            o1 = d1;
            d1 = o1;
        }
        if (!VertLeq(o2, d2)) {
            o2 = d2;
            d2 = o2;
        }
        if (!VertLeq(o1, o2)) {
            GLUvertex temp = o1;
            o1 = o2;
            o2 = temp;
            GLUvertex temp2 = d1;
            d1 = d2;
            d2 = temp2;
        }
        if (!VertLeq(o2, d1)) {
            v.s = (o2.s + d1.s) / 2.0d;
        } else if (VertLeq(d1, d2)) {
            double z1 = EdgeEval(o1, o2, d1);
            double z2 = EdgeEval(o2, d1, d2);
            if (z1 + z2 < 0.0d) {
                z1 = -z1;
                z2 = -z2;
            }
            v.s = Interpolate(z1, o2.s, z2, d1.s);
        } else {
            double z12 = EdgeSign(o1, o2, d1);
            double z22 = -EdgeSign(o1, d2, d1);
            if (z12 + z22 < 0.0d) {
                z12 = -z12;
                z22 = -z22;
            }
            v.s = Interpolate(z12, o2.s, z22, d2.s);
        }
        if (!TransLeq(o1, d1)) {
            GLUvertex temp3 = o1;
            o1 = d1;
            d1 = temp3;
        }
        if (!TransLeq(o2, d2)) {
            GLUvertex temp4 = o2;
            o2 = d2;
            d2 = temp4;
        }
        if (!TransLeq(o1, o2)) {
            GLUvertex temp5 = o2;
            o2 = o1;
            o1 = temp5;
            GLUvertex temp6 = d2;
            d2 = d1;
            d1 = temp6;
        }
        if (!TransLeq(o2, d1)) {
            v.t = (o2.t + d1.t) / 2.0d;
            return;
        }
        if (TransLeq(d1, d2)) {
            double z13 = TransEval(o1, o2, d1);
            double z23 = TransEval(o2, d1, d2);
            if (z13 + z23 < 0.0d) {
                z13 = -z13;
                z23 = -z23;
            }
            v.t = Interpolate(z13, o2.t, z23, d1.t);
            return;
        }
        double z14 = TransSign(o1, o2, d1);
        double z24 = -TransSign(o1, d2, d1);
        if (z14 + z24 < 0.0d) {
            z14 = -z14;
            z24 = -z24;
        }
        v.t = Interpolate(z14, o2.t, z24, d2.t);
    }

    static boolean VertEq(GLUvertex u, GLUvertex v) {
        return u.s == v.s && u.t == v.t;
    }

    static boolean VertLeq(GLUvertex u, GLUvertex v) {
        return u.s < v.s || (u.s == v.s && u.t <= v.t);
    }

    static boolean TransLeq(GLUvertex u, GLUvertex v) {
        return u.t < v.t || (u.t == v.t && u.s <= v.s);
    }

    static boolean EdgeGoesLeft(GLUhalfEdge e) {
        return VertLeq(e.Sym.Org, e.Org);
    }

    static boolean EdgeGoesRight(GLUhalfEdge e) {
        return VertLeq(e.Org, e.Sym.Org);
    }

    static double VertL1dist(GLUvertex u, GLUvertex v) {
        return Math.abs(u.s - v.s) + Math.abs(u.t - v.t);
    }
}
