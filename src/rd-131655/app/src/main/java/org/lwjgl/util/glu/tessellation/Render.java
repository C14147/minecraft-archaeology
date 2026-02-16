package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Render.class */
class Render {
    private static final boolean USE_OPTIMIZED_CODE_PATH = false;
    private static final RenderFan renderFan;
    private static final RenderStrip renderStrip;
    private static final RenderTriangle renderTriangle;
    private static final int SIGN_INCONSISTENT = 2;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Render$renderCallBack.class */
    private interface renderCallBack {
        void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long j);
    }

    static {
        $assertionsDisabled = !Render.class.desiredAssertionStatus();
        renderFan = new RenderFan();
        renderStrip = new RenderStrip();
        renderTriangle = new RenderTriangle();
    }

    private Render() {
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Render$FaceCount.class */
    private static class FaceCount {
        long size;
        GLUhalfEdge eStart;
        renderCallBack render;

        private FaceCount() {
        }

        private FaceCount(long size, GLUhalfEdge eStart, renderCallBack render) {
            this.size = size;
            this.eStart = eStart;
            this.render = render;
        }
    }

    public static void __gl_renderMesh(GLUtessellatorImpl tess, GLUmesh mesh) {
        tess.lonelyTriList = null;
        GLUface gLUface = mesh.fHead.next;
        while (true) {
            GLUface f = gLUface;
            if (f == mesh.fHead) {
                break;
            }
            f.marked = false;
            gLUface = f.next;
        }
        GLUface gLUface2 = mesh.fHead.next;
        while (true) {
            GLUface f2 = gLUface2;
            if (f2 != mesh.fHead) {
                if (f2.inside && !f2.marked) {
                    RenderMaximumFaceGroup(tess, f2);
                    if (!$assertionsDisabled && !f2.marked) {
                        throw new AssertionError();
                    }
                }
                gLUface2 = f2.next;
            } else {
                if (tess.lonelyTriList != null) {
                    RenderLonelyTriangles(tess, tess.lonelyTriList);
                    tess.lonelyTriList = null;
                    return;
                }
                return;
            }
        }
    }

    static void RenderMaximumFaceGroup(GLUtessellatorImpl tess, GLUface fOrig) {
        GLUhalfEdge e = fOrig.anEdge;
        FaceCount max = new FaceCount();
        max.size = 1L;
        max.eStart = e;
        max.render = renderTriangle;
        if (!tess.flagBoundary) {
            FaceCount newFace = MaximumFan(e);
            if (newFace.size > max.size) {
                max = newFace;
            }
            FaceCount newFace2 = MaximumFan(e.Lnext);
            if (newFace2.size > max.size) {
                max = newFace2;
            }
            FaceCount newFace3 = MaximumFan(e.Onext.Sym);
            if (newFace3.size > max.size) {
                max = newFace3;
            }
            FaceCount newFace4 = MaximumStrip(e);
            if (newFace4.size > max.size) {
                max = newFace4;
            }
            FaceCount newFace5 = MaximumStrip(e.Lnext);
            if (newFace5.size > max.size) {
                max = newFace5;
            }
            FaceCount newFace6 = MaximumStrip(e.Onext.Sym);
            if (newFace6.size > max.size) {
                max = newFace6;
            }
        }
        max.render.render(tess, max.eStart, max.size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Marked(GLUface f) {
        return !f.inside || f.marked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GLUface AddToTrail(GLUface f, GLUface t) {
        f.trail = t;
        f.marked = true;
        return f;
    }

    private static void FreeTrail(GLUface t) {
        while (t != null) {
            t.marked = false;
            t = t.trail;
        }
    }

    static FaceCount MaximumFan(GLUhalfEdge eOrig) {
        FaceCount newFace = new FaceCount(0L, null, renderFan);
        GLUface trail = null;
        GLUhalfEdge gLUhalfEdge = eOrig;
        while (true) {
            GLUhalfEdge e = gLUhalfEdge;
            if (Marked(e.Lface)) {
                break;
            }
            trail = AddToTrail(e.Lface, trail);
            newFace.size++;
            gLUhalfEdge = e.Onext;
        }
        GLUhalfEdge gLUhalfEdge2 = eOrig;
        while (true) {
            GLUhalfEdge e2 = gLUhalfEdge2;
            if (!Marked(e2.Sym.Lface)) {
                trail = AddToTrail(e2.Sym.Lface, trail);
                newFace.size++;
                gLUhalfEdge2 = e2.Sym.Lnext;
            } else {
                newFace.eStart = e2;
                FreeTrail(trail);
                return newFace;
            }
        }
    }

    private static boolean IsEven(long n) {
        return (n & 1) == 0;
    }

    static FaceCount MaximumStrip(GLUhalfEdge eOrig) {
        GLUhalfEdge e;
        GLUhalfEdge e2;
        FaceCount newFace = new FaceCount(0L, null, renderStrip);
        long headSize = 0;
        long tailSize = 0;
        GLUface trail = null;
        GLUhalfEdge gLUhalfEdge = eOrig;
        while (true) {
            e = gLUhalfEdge;
            if (Marked(e.Lface)) {
                break;
            }
            trail = AddToTrail(e.Lface, trail);
            tailSize++;
            e = e.Lnext.Sym;
            if (Marked(e.Lface)) {
                break;
            }
            trail = AddToTrail(e.Lface, trail);
            tailSize++;
            gLUhalfEdge = e.Onext;
        }
        GLUhalfEdge eTail = e;
        GLUhalfEdge gLUhalfEdge2 = eOrig;
        while (true) {
            e2 = gLUhalfEdge2;
            if (Marked(e2.Sym.Lface)) {
                break;
            }
            trail = AddToTrail(e2.Sym.Lface, trail);
            headSize++;
            e2 = e2.Sym.Lnext;
            if (Marked(e2.Sym.Lface)) {
                break;
            }
            trail = AddToTrail(e2.Sym.Lface, trail);
            headSize++;
            gLUhalfEdge2 = e2.Sym.Onext.Sym;
        }
        GLUhalfEdge eHead = e2;
        newFace.size = tailSize + headSize;
        if (IsEven(tailSize)) {
            newFace.eStart = eTail.Sym;
        } else if (IsEven(headSize)) {
            newFace.eStart = eHead;
        } else {
            newFace.size--;
            newFace.eStart = eHead.Onext;
        }
        FreeTrail(trail);
        return newFace;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Render$RenderTriangle.class */
    private static class RenderTriangle implements renderCallBack {
        static final /* synthetic */ boolean $assertionsDisabled;

        private RenderTriangle() {
        }

        static {
            $assertionsDisabled = !Render.class.desiredAssertionStatus();
        }

        @Override // org.lwjgl.util.glu.tessellation.Render.renderCallBack
        public void render(GLUtessellatorImpl tess, GLUhalfEdge e, long size) {
            if (!$assertionsDisabled && size != 1) {
                throw new AssertionError();
            }
            tess.lonelyTriList = Render.AddToTrail(e.Lface, tess.lonelyTriList);
        }
    }

    static void RenderLonelyTriangles(GLUtessellatorImpl tess, GLUface f) {
        int edgeState = -1;
        tess.callBeginOrBeginData(4);
        while (f != null) {
            GLUhalfEdge e = f.anEdge;
            do {
                if (tess.flagBoundary) {
                    int newState = !e.Sym.Lface.inside ? 1 : 0;
                    if (edgeState != newState) {
                        edgeState = newState;
                        tess.callEdgeFlagOrEdgeFlagData(edgeState != 0);
                    }
                }
                tess.callVertexOrVertexData(e.Org.data);
                e = e.Lnext;
            } while (e != f.anEdge);
            f = f.trail;
        }
        tess.callEndOrEndData();
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Render$RenderFan.class */
    private static class RenderFan implements renderCallBack {
        static final /* synthetic */ boolean $assertionsDisabled;

        private RenderFan() {
        }

        static {
            $assertionsDisabled = !Render.class.desiredAssertionStatus();
        }

        @Override // org.lwjgl.util.glu.tessellation.Render.renderCallBack
        public void render(GLUtessellatorImpl tess, GLUhalfEdge e, long size) {
            tess.callBeginOrBeginData(6);
            tess.callVertexOrVertexData(e.Org.data);
            tess.callVertexOrVertexData(e.Sym.Org.data);
            while (!Render.Marked(e.Lface)) {
                e.Lface.marked = true;
                size--;
                e = e.Onext;
                tess.callVertexOrVertexData(e.Sym.Org.data);
            }
            if (!$assertionsDisabled && size != 0) {
                throw new AssertionError();
            }
            tess.callEndOrEndData();
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Render$RenderStrip.class */
    private static class RenderStrip implements renderCallBack {
        static final /* synthetic */ boolean $assertionsDisabled;

        private RenderStrip() {
        }

        static {
            $assertionsDisabled = !Render.class.desiredAssertionStatus();
        }

        @Override // org.lwjgl.util.glu.tessellation.Render.renderCallBack
        public void render(GLUtessellatorImpl tess, GLUhalfEdge e, long size) {
            tess.callBeginOrBeginData(5);
            tess.callVertexOrVertexData(e.Org.data);
            tess.callVertexOrVertexData(e.Sym.Org.data);
            while (!Render.Marked(e.Lface)) {
                e.Lface.marked = true;
                size--;
                GLUhalfEdge e2 = e.Lnext.Sym;
                tess.callVertexOrVertexData(e2.Org.data);
                if (Render.Marked(e2.Lface)) {
                    break;
                }
                e2.Lface.marked = true;
                size--;
                e = e2.Onext;
                tess.callVertexOrVertexData(e.Sym.Org.data);
            }
            if (!$assertionsDisabled && size != 0) {
                throw new AssertionError();
            }
            tess.callEndOrEndData();
        }
    }

    public static void __gl_renderBoundary(GLUtessellatorImpl tess, GLUmesh mesh) {
        GLUface gLUface = mesh.fHead.next;
        while (true) {
            GLUface f = gLUface;
            if (f != mesh.fHead) {
                if (f.inside) {
                    tess.callBeginOrBeginData(2);
                    GLUhalfEdge e = f.anEdge;
                    do {
                        tess.callVertexOrVertexData(e.Org.data);
                        e = e.Lnext;
                    } while (e != f.anEdge);
                    tess.callEndOrEndData();
                }
                gLUface = f.next;
            } else {
                return;
            }
        }
    }

    static int ComputeNormal(GLUtessellatorImpl tess, double[] norm, boolean check) {
        CachedVertex[] v = tess.cache;
        int vn = tess.cacheCount;
        double[] n = new double[3];
        int sign = 0;
        if (!check) {
            norm[2] = 0.0d;
            norm[1] = 0.0d;
            norm[0] = 0.0d;
        }
        int vc = 1;
        double xc = v[1].coords[0] - v[0].coords[0];
        double yc = v[1].coords[1] - v[0].coords[1];
        double zc = v[1].coords[2] - v[0].coords[2];
        while (true) {
            vc++;
            if (vc < vn) {
                double xp = xc;
                double yp = yc;
                double zp = zc;
                xc = v[vc].coords[0] - v[0].coords[0];
                yc = v[vc].coords[1] - v[0].coords[1];
                zc = v[vc].coords[2] - v[0].coords[2];
                n[0] = (yp * zc) - (zp * yc);
                n[1] = (zp * xc) - (xp * zc);
                n[2] = (xp * yc) - (yp * xc);
                double dot = (n[0] * norm[0]) + (n[1] * norm[1]) + (n[2] * norm[2]);
                if (check) {
                    if (dot == 0.0d) {
                        continue;
                    } else if (dot > 0.0d) {
                        if (sign < 0) {
                            return 2;
                        }
                        sign = 1;
                    } else {
                        if (sign > 0) {
                            return 2;
                        }
                        sign = -1;
                    }
                } else if (dot >= 0.0d) {
                    norm[0] = norm[0] + n[0];
                    norm[1] = norm[1] + n[1];
                    norm[2] = norm[2] + n[2];
                } else {
                    norm[0] = norm[0] - n[0];
                    norm[1] = norm[1] - n[1];
                    norm[2] = norm[2] - n[2];
                }
            } else {
                return sign;
            }
        }
    }

    public static boolean __gl_renderCache(GLUtessellatorImpl tess) {
        CachedVertex[] cachedVertexArr = tess.cache;
        int i = tess.cacheCount;
        double[] norm = new double[3];
        if (tess.cacheCount < 3) {
            return true;
        }
        norm[0] = tess.normal[0];
        norm[1] = tess.normal[1];
        norm[2] = tess.normal[2];
        if (norm[0] == 0.0d && norm[1] == 0.0d && norm[2] == 0.0d) {
            ComputeNormal(tess, norm, false);
        }
        int sign = ComputeNormal(tess, norm, true);
        if (sign != 2 && sign == 0) {
            return true;
        }
        return false;
    }
}
