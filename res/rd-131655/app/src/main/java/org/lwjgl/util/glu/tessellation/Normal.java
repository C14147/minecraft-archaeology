package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Normal.class */
class Normal {
    static boolean SLANTED_SWEEP;
    static double S_UNIT_X;
    static double S_UNIT_Y;
    private static final boolean TRUE_PROJECT = false;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Normal.class.desiredAssertionStatus();
        if (SLANTED_SWEEP) {
            S_UNIT_X = 0.5094153956495538d;
            S_UNIT_Y = 0.8605207462201063d;
        } else {
            S_UNIT_X = 1.0d;
            S_UNIT_Y = 0.0d;
        }
    }

    private Normal() {
    }

    private static double Dot(double[] u, double[] v) {
        return (u[0] * v[0]) + (u[1] * v[1]) + (u[2] * v[2]);
    }

    static void Normalize(double[] v) {
        double len = (v[0] * v[0]) + (v[1] * v[1]) + (v[2] * v[2]);
        if (!$assertionsDisabled && len <= 0.0d) {
            throw new AssertionError();
        }
        double len2 = Math.sqrt(len);
        v[0] = v[0] / len2;
        v[1] = v[1] / len2;
        v[2] = v[2] / len2;
    }

    static int LongAxis(double[] v) {
        int i = 0;
        if (Math.abs(v[1]) > Math.abs(v[0])) {
            i = 1;
        }
        if (Math.abs(v[2]) > Math.abs(v[i])) {
            i = 2;
        }
        return i;
    }

    static void ComputeNormal(GLUtessellatorImpl tess, double[] norm) {
        GLUvertex vHead = tess.mesh.vHead;
        double[] maxVal = new double[3];
        double[] minVal = new double[3];
        GLUvertex[] minVert = new GLUvertex[3];
        GLUvertex[] maxVert = new GLUvertex[3];
        double[] d1 = new double[3];
        double[] d2 = new double[3];
        double[] tNorm = new double[3];
        maxVal[2] = -2.0E150d;
        maxVal[1] = -2.0E150d;
        maxVal[0] = -2.0E150d;
        minVal[2] = 2.0E150d;
        minVal[1] = 2.0E150d;
        minVal[0] = 2.0E150d;
        GLUvertex gLUvertex = vHead.next;
        while (true) {
            GLUvertex v = gLUvertex;
            if (v == vHead) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                double c = v.coords[i];
                if (c < minVal[i]) {
                    minVal[i] = c;
                    minVert[i] = v;
                }
                if (c > maxVal[i]) {
                    maxVal[i] = c;
                    maxVert[i] = v;
                }
            }
            gLUvertex = v.next;
        }
        int i2 = 0;
        if (maxVal[1] - minVal[1] > maxVal[0] - minVal[0]) {
            i2 = 1;
        }
        if (maxVal[2] - minVal[2] > maxVal[i2] - minVal[i2]) {
            i2 = 2;
        }
        if (minVal[i2] >= maxVal[i2]) {
            norm[0] = 0.0d;
            norm[1] = 0.0d;
            norm[2] = 1.0d;
            return;
        }
        double maxLen2 = 0.0d;
        GLUvertex v1 = minVert[i2];
        GLUvertex v2 = maxVert[i2];
        d1[0] = v1.coords[0] - v2.coords[0];
        d1[1] = v1.coords[1] - v2.coords[1];
        d1[2] = v1.coords[2] - v2.coords[2];
        GLUvertex gLUvertex2 = vHead.next;
        while (true) {
            GLUvertex v3 = gLUvertex2;
            if (v3 == vHead) {
                break;
            }
            d2[0] = v3.coords[0] - v2.coords[0];
            d2[1] = v3.coords[1] - v2.coords[1];
            d2[2] = v3.coords[2] - v2.coords[2];
            tNorm[0] = (d1[1] * d2[2]) - (d1[2] * d2[1]);
            tNorm[1] = (d1[2] * d2[0]) - (d1[0] * d2[2]);
            tNorm[2] = (d1[0] * d2[1]) - (d1[1] * d2[0]);
            double tLen2 = (tNorm[0] * tNorm[0]) + (tNorm[1] * tNorm[1]) + (tNorm[2] * tNorm[2]);
            if (tLen2 > maxLen2) {
                maxLen2 = tLen2;
                norm[0] = tNorm[0];
                norm[1] = tNorm[1];
                norm[2] = tNorm[2];
            }
            gLUvertex2 = v3.next;
        }
        if (maxLen2 <= 0.0d) {
            norm[2] = 0.0d;
            norm[1] = 0.0d;
            norm[0] = 0.0d;
            norm[LongAxis(d1)] = 1.0d;
        }
    }

    static void CheckOrientation(GLUtessellatorImpl tess) {
        GLUface fHead = tess.mesh.fHead;
        GLUvertex vHead = tess.mesh.vHead;
        double area = 0.0d;
        GLUface gLUface = fHead.next;
        while (true) {
            GLUface f = gLUface;
            if (f == fHead) {
                break;
            }
            GLUhalfEdge e = f.anEdge;
            if (e.winding > 0) {
                do {
                    area += (e.Org.s - e.Sym.Org.s) * (e.Org.t + e.Sym.Org.t);
                    e = e.Lnext;
                } while (e != f.anEdge);
            }
            gLUface = f.next;
        }
        if (area < 0.0d) {
            GLUvertex gLUvertex = vHead.next;
            while (true) {
                GLUvertex v = gLUvertex;
                if (v != vHead) {
                    v.t = -v.t;
                    gLUvertex = v.next;
                } else {
                    tess.tUnit[0] = -tess.tUnit[0];
                    tess.tUnit[1] = -tess.tUnit[1];
                    tess.tUnit[2] = -tess.tUnit[2];
                    return;
                }
            }
        }
    }

    public static void __gl_projectPolygon(GLUtessellatorImpl tess) {
        GLUvertex vHead = tess.mesh.vHead;
        boolean computedNormal = false;
        double[] norm = {tess.normal[0], tess.normal[1], tess.normal[2]};
        if (norm[0] == 0.0d && norm[1] == 0.0d && norm[2] == 0.0d) {
            ComputeNormal(tess, norm);
            computedNormal = true;
        }
        double[] sUnit = tess.sUnit;
        double[] tUnit = tess.tUnit;
        int i = LongAxis(norm);
        sUnit[i] = 0.0d;
        sUnit[(i + 1) % 3] = S_UNIT_X;
        sUnit[(i + 2) % 3] = S_UNIT_Y;
        tUnit[i] = 0.0d;
        tUnit[(i + 1) % 3] = norm[i] > 0.0d ? -S_UNIT_Y : S_UNIT_Y;
        tUnit[(i + 2) % 3] = norm[i] > 0.0d ? S_UNIT_X : -S_UNIT_X;
        GLUvertex gLUvertex = vHead.next;
        while (true) {
            GLUvertex v = gLUvertex;
            if (v == vHead) {
                break;
            }
            v.s = Dot(v.coords, sUnit);
            v.t = Dot(v.coords, tUnit);
            gLUvertex = v.next;
        }
        if (computedNormal) {
            CheckOrientation(tess);
        }
    }
}
