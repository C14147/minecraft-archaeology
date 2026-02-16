package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/TessMono.class */
class TessMono {
    static final /* synthetic */ boolean $assertionsDisabled;

    TessMono() {
    }

    static {
        $assertionsDisabled = !TessMono.class.desiredAssertionStatus();
    }

    static boolean __gl_meshTessellateMonoRegion(GLUface face) {
        GLUhalfEdge up = face.anEdge;
        if (!$assertionsDisabled && (up.Lnext == up || up.Lnext.Lnext == up)) {
            throw new AssertionError();
        }
        while (Geom.VertLeq(up.Sym.Org, up.Org)) {
            up = up.Onext.Sym;
        }
        while (Geom.VertLeq(up.Org, up.Sym.Org)) {
            up = up.Lnext;
        }
        GLUhalfEdge lo = up.Onext.Sym;
        while (up.Lnext != lo) {
            if (Geom.VertLeq(up.Sym.Org, lo.Org)) {
                while (lo.Lnext != up && (Geom.EdgeGoesLeft(lo.Lnext) || Geom.EdgeSign(lo.Org, lo.Sym.Org, lo.Lnext.Sym.Org) <= 0.0d)) {
                    GLUhalfEdge tempHalfEdge = Mesh.__gl_meshConnect(lo.Lnext, lo);
                    if (tempHalfEdge == null) {
                        return false;
                    }
                    lo = tempHalfEdge.Sym;
                }
                lo = lo.Onext.Sym;
            } else {
                while (lo.Lnext != up && (Geom.EdgeGoesRight(up.Onext.Sym) || Geom.EdgeSign(up.Sym.Org, up.Org, up.Onext.Sym.Org) >= 0.0d)) {
                    GLUhalfEdge tempHalfEdge2 = Mesh.__gl_meshConnect(up, up.Onext.Sym);
                    if (tempHalfEdge2 == null) {
                        return false;
                    }
                    up = tempHalfEdge2.Sym;
                }
                up = up.Lnext;
            }
        }
        if (!$assertionsDisabled && lo.Lnext == up) {
            throw new AssertionError();
        }
        while (lo.Lnext.Lnext != up) {
            GLUhalfEdge tempHalfEdge3 = Mesh.__gl_meshConnect(lo.Lnext, lo);
            if (tempHalfEdge3 == null) {
                return false;
            }
            lo = tempHalfEdge3.Sym;
        }
        return true;
    }

    public static boolean __gl_meshTessellateInterior(GLUmesh mesh) {
        GLUface gLUface = mesh.fHead.next;
        while (true) {
            GLUface f = gLUface;
            if (f != mesh.fHead) {
                GLUface next = f.next;
                if (f.inside && !__gl_meshTessellateMonoRegion(f)) {
                    return false;
                }
                gLUface = next;
            } else {
                return true;
            }
        }
    }

    public static void __gl_meshDiscardExterior(GLUmesh mesh) {
        GLUface gLUface = mesh.fHead.next;
        while (true) {
            GLUface f = gLUface;
            if (f != mesh.fHead) {
                GLUface next = f.next;
                if (!f.inside) {
                    Mesh.__gl_meshZapFace(f);
                }
                gLUface = next;
            } else {
                return;
            }
        }
    }

    public static boolean __gl_meshSetWindingNumber(GLUmesh mesh, int value, boolean keepOnlyBoundary) {
        GLUhalfEdge gLUhalfEdge = mesh.eHead.next;
        while (true) {
            GLUhalfEdge e = gLUhalfEdge;
            if (e != mesh.eHead) {
                GLUhalfEdge eNext = e.next;
                if (e.Sym.Lface.inside != e.Lface.inside) {
                    e.winding = e.Lface.inside ? value : -value;
                } else if (!keepOnlyBoundary) {
                    e.winding = 0;
                } else if (!Mesh.__gl_meshDelete(e)) {
                    return false;
                }
                gLUhalfEdge = eNext;
            } else {
                return true;
            }
        }
    }
}
