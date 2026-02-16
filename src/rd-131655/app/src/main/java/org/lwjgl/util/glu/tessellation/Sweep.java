package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.tessellation.Dict;
import org.lwjgl.util.glu.tessellation.PriorityQ;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Sweep.class */
class Sweep {
    private static final boolean TOLERANCE_NONZERO = false;
    private static final double SENTINEL_COORD = 4.0E150d;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Sweep.class.desiredAssertionStatus();
    }

    private Sweep() {
    }

    private static void DebugEvent(GLUtessellatorImpl tess) {
    }

    private static void AddWinding(GLUhalfEdge eDst, GLUhalfEdge eSrc) {
        eDst.winding += eSrc.winding;
        eDst.Sym.winding += eSrc.Sym.winding;
    }

    private static ActiveRegion RegionBelow(ActiveRegion r) {
        return (ActiveRegion) Dict.dictKey(Dict.dictPred(r.nodeUp));
    }

    private static ActiveRegion RegionAbove(ActiveRegion r) {
        return (ActiveRegion) Dict.dictKey(Dict.dictSucc(r.nodeUp));
    }

    static boolean EdgeLeq(GLUtessellatorImpl tess, ActiveRegion reg1, ActiveRegion reg2) {
        GLUvertex event = tess.event;
        GLUhalfEdge e1 = reg1.eUp;
        GLUhalfEdge e2 = reg2.eUp;
        if (e1.Sym.Org == event) {
            return e2.Sym.Org == event ? Geom.VertLeq(e1.Org, e2.Org) ? Geom.EdgeSign(e2.Sym.Org, e1.Org, e2.Org) <= 0.0d : Geom.EdgeSign(e1.Sym.Org, e2.Org, e1.Org) >= 0.0d : Geom.EdgeSign(e2.Sym.Org, event, e2.Org) <= 0.0d;
        }
        if (e2.Sym.Org == event) {
            return Geom.EdgeSign(e1.Sym.Org, event, e1.Org) >= 0.0d;
        }
        double t1 = Geom.EdgeEval(e1.Sym.Org, event, e1.Org);
        double t2 = Geom.EdgeEval(e2.Sym.Org, event, e2.Org);
        return t1 >= t2;
    }

    static void DeleteRegion(GLUtessellatorImpl tess, ActiveRegion reg) {
        if (reg.fixUpperEdge && !$assertionsDisabled && reg.eUp.winding != 0) {
            throw new AssertionError();
        }
        reg.eUp.activeRegion = null;
        Dict.dictDelete(tess.dict, reg.nodeUp);
    }

    static boolean FixUpperEdge(ActiveRegion reg, GLUhalfEdge newEdge) {
        if (!$assertionsDisabled && !reg.fixUpperEdge) {
            throw new AssertionError();
        }
        if (!Mesh.__gl_meshDelete(reg.eUp)) {
            return false;
        }
        reg.fixUpperEdge = false;
        reg.eUp = newEdge;
        newEdge.activeRegion = reg;
        return true;
    }

    static ActiveRegion TopLeftRegion(ActiveRegion reg) {
        GLUvertex org2 = reg.eUp.Org;
        do {
            reg = RegionAbove(reg);
        } while (reg.eUp.Org == org2);
        if (reg.fixUpperEdge) {
            GLUhalfEdge e = Mesh.__gl_meshConnect(RegionBelow(reg).eUp.Sym, reg.eUp.Lnext);
            if (e == null || !FixUpperEdge(reg, e)) {
                return null;
            }
            reg = RegionAbove(reg);
        }
        return reg;
    }

    static ActiveRegion TopRightRegion(ActiveRegion reg) {
        GLUvertex dst = reg.eUp.Sym.Org;
        do {
            reg = RegionAbove(reg);
        } while (reg.eUp.Sym.Org == dst);
        return reg;
    }

    static ActiveRegion AddRegionBelow(GLUtessellatorImpl tess, ActiveRegion regAbove, GLUhalfEdge eNewUp) {
        ActiveRegion regNew = new ActiveRegion();
        if (regNew == null) {
            throw new RuntimeException();
        }
        regNew.eUp = eNewUp;
        regNew.nodeUp = Dict.dictInsertBefore(tess.dict, regAbove.nodeUp, regNew);
        if (regNew.nodeUp == null) {
            throw new RuntimeException();
        }
        regNew.fixUpperEdge = false;
        regNew.sentinel = false;
        regNew.dirty = false;
        eNewUp.activeRegion = regNew;
        return regNew;
    }

    static boolean IsWindingInside(GLUtessellatorImpl tess, int n) {
        switch (tess.windingRule) {
            case GLU.GLU_TESS_WINDING_ODD /* 100130 */:
                return (n & 1) != 0;
            case GLU.GLU_TESS_WINDING_NONZERO /* 100131 */:
                return n != 0;
            case GLU.GLU_TESS_WINDING_POSITIVE /* 100132 */:
                return n > 0;
            case GLU.GLU_TESS_WINDING_NEGATIVE /* 100133 */:
                return n < 0;
            case GLU.GLU_TESS_WINDING_ABS_GEQ_TWO /* 100134 */:
                return n >= 2 || n <= -2;
            default:
                throw new InternalError();
        }
    }

    static void ComputeWinding(GLUtessellatorImpl tess, ActiveRegion reg) {
        reg.windingNumber = RegionAbove(reg).windingNumber + reg.eUp.winding;
        reg.inside = IsWindingInside(tess, reg.windingNumber);
    }

    static void FinishRegion(GLUtessellatorImpl tess, ActiveRegion reg) {
        GLUhalfEdge e = reg.eUp;
        GLUface f = e.Lface;
        f.inside = reg.inside;
        f.anEdge = e;
        DeleteRegion(tess, reg);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b6, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static org.lwjgl.util.glu.tessellation.GLUhalfEdge FinishLeftRegions(org.lwjgl.util.glu.tessellation.GLUtessellatorImpl r3, org.lwjgl.util.glu.tessellation.ActiveRegion r4, org.lwjgl.util.glu.tessellation.ActiveRegion r5) {
        /*
            r0 = r4
            r7 = r0
            r0 = r4
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.eUp
            r9 = r0
        L9:
            r0 = r7
            r1 = r5
            if (r0 == r1) goto Lb4
            r0 = r7
            r1 = 0
            r0.fixUpperEdge = r1
            r0 = r7
            org.lwjgl.util.glu.tessellation.ActiveRegion r0 = RegionBelow(r0)
            r6 = r0
            r0 = r6
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.eUp
            r8 = r0
            r0 = r8
            org.lwjgl.util.glu.tessellation.GLUvertex r0 = r0.Org
            r1 = r9
            org.lwjgl.util.glu.tessellation.GLUvertex r1 = r1.Org
            if (r0 == r1) goto L6e
            r0 = r6
            boolean r0 = r0.fixUpperEdge
            if (r0 != 0) goto L3e
            r0 = r3
            r1 = r7
            FinishRegion(r0, r1)
            goto Lb4
        L3e:
            r0 = r9
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.Onext
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.Sym
            r1 = r8
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r1 = r1.Sym
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = org.lwjgl.util.glu.tessellation.Mesh.__gl_meshConnect(r0, r1)
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L5d
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r1.<init>()
            throw r0
        L5d:
            r0 = r6
            r1 = r8
            boolean r0 = FixUpperEdge(r0, r1)
            if (r0 != 0) goto L6e
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r1.<init>()
            throw r0
        L6e:
            r0 = r9
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.Onext
            r1 = r8
            if (r0 == r1) goto La2
            r0 = r8
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.Sym
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.Lnext
            r1 = r8
            boolean r0 = org.lwjgl.util.glu.tessellation.Mesh.__gl_meshSplice(r0, r1)
            if (r0 != 0) goto L90
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r1.<init>()
            throw r0
        L90:
            r0 = r9
            r1 = r8
            boolean r0 = org.lwjgl.util.glu.tessellation.Mesh.__gl_meshSplice(r0, r1)
            if (r0 != 0) goto La2
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r1.<init>()
            throw r0
        La2:
            r0 = r3
            r1 = r7
            FinishRegion(r0, r1)
            r0 = r6
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r0 = r0.eUp
            r9 = r0
            r0 = r6
            r7 = r0
            goto L9
        Lb4:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.glu.tessellation.Sweep.FinishLeftRegions(org.lwjgl.util.glu.tessellation.GLUtessellatorImpl, org.lwjgl.util.glu.tessellation.ActiveRegion, org.lwjgl.util.glu.tessellation.ActiveRegion):org.lwjgl.util.glu.tessellation.GLUhalfEdge");
    }

    static void AddRightEdges(GLUtessellatorImpl tess, ActiveRegion regUp, GLUhalfEdge eFirst, GLUhalfEdge eLast, GLUhalfEdge eTopLeft, boolean cleanUp) {
        boolean firstTime = true;
        GLUhalfEdge e = eFirst;
        do {
            if (!$assertionsDisabled && !Geom.VertLeq(e.Org, e.Sym.Org)) {
                throw new AssertionError();
            }
            AddRegionBelow(tess, regUp, e.Sym);
            e = e.Onext;
        } while (e != eLast);
        if (eTopLeft == null) {
            eTopLeft = RegionBelow(regUp).eUp.Sym.Onext;
        }
        ActiveRegion regPrev = regUp;
        GLUhalfEdge gLUhalfEdge = eTopLeft;
        while (true) {
            GLUhalfEdge ePrev = gLUhalfEdge;
            ActiveRegion reg = RegionBelow(regPrev);
            GLUhalfEdge e2 = reg.eUp.Sym;
            if (e2.Org == ePrev.Org) {
                if (e2.Onext != ePrev) {
                    if (!Mesh.__gl_meshSplice(e2.Sym.Lnext, e2)) {
                        throw new RuntimeException();
                    }
                    if (!Mesh.__gl_meshSplice(ePrev.Sym.Lnext, e2)) {
                        throw new RuntimeException();
                    }
                }
                reg.windingNumber = regPrev.windingNumber - e2.winding;
                reg.inside = IsWindingInside(tess, reg.windingNumber);
                regPrev.dirty = true;
                if (!firstTime && CheckForRightSplice(tess, regPrev)) {
                    AddWinding(e2, ePrev);
                    DeleteRegion(tess, regPrev);
                    if (!Mesh.__gl_meshDelete(ePrev)) {
                        throw new RuntimeException();
                    }
                }
                firstTime = false;
                regPrev = reg;
                gLUhalfEdge = e2;
            } else {
                regPrev.dirty = true;
                if (!$assertionsDisabled && regPrev.windingNumber - e2.winding != reg.windingNumber) {
                    throw new AssertionError();
                }
                if (cleanUp) {
                    WalkDirtyRegions(tess, regPrev);
                    return;
                }
                return;
            }
        }
    }

    static void CallCombine(GLUtessellatorImpl tess, GLUvertex isect, Object[] data, float[] weights, boolean needed) {
        double[] coords = {isect.coords[0], isect.coords[1], isect.coords[2]};
        Object[] outData = new Object[1];
        tess.callCombineOrCombineData(coords, data, weights, outData);
        isect.data = outData[0];
        if (isect.data == null) {
            if (!needed) {
                isect.data = data[0];
            } else if (!tess.fatalError) {
                tess.callErrorOrErrorData(100156);
                tess.fatalError = true;
            }
        }
    }

    static void SpliceMergeVertices(GLUtessellatorImpl tess, GLUhalfEdge e1, GLUhalfEdge e2) {
        Object[] data = new Object[4];
        float[] weights = {0.5f, 0.5f, 0.0f, 0.0f};
        data[0] = e1.Org.data;
        data[1] = e2.Org.data;
        CallCombine(tess, e1.Org, data, weights, false);
        if (!Mesh.__gl_meshSplice(e1, e2)) {
            throw new RuntimeException();
        }
    }

    static void VertexWeights(GLUvertex isect, GLUvertex org2, GLUvertex dst, float[] weights) {
        double t1 = Geom.VertL1dist(org2, isect);
        double t2 = Geom.VertL1dist(dst, isect);
        weights[0] = (float) ((0.5d * t2) / (t1 + t2));
        weights[1] = (float) ((0.5d * t1) / (t1 + t2));
        double[] dArr = isect.coords;
        dArr[0] = dArr[0] + (((double) weights[0]) * org2.coords[0]) + (((double) weights[1]) * dst.coords[0]);
        double[] dArr2 = isect.coords;
        dArr2[1] = dArr2[1] + (((double) weights[0]) * org2.coords[1]) + (((double) weights[1]) * dst.coords[1]);
        double[] dArr3 = isect.coords;
        dArr3[2] = dArr3[2] + (((double) weights[0]) * org2.coords[2]) + (((double) weights[1]) * dst.coords[2]);
    }

    static void GetIntersectData(GLUtessellatorImpl tess, GLUvertex isect, GLUvertex orgUp, GLUvertex dstUp, GLUvertex orgLo, GLUvertex dstLo) {
        float[] weights = new float[4];
        float[] weights1 = new float[2];
        float[] weights2 = new float[2];
        Object[] data = {orgUp.data, dstUp.data, orgLo.data, dstLo.data};
        double[] dArr = isect.coords;
        double[] dArr2 = isect.coords;
        isect.coords[2] = 0.0d;
        dArr2[1] = 0.0d;
        dArr[0] = 0.0d;
        VertexWeights(isect, orgUp, dstUp, weights1);
        VertexWeights(isect, orgLo, dstLo, weights2);
        System.arraycopy(weights1, 0, weights, 0, 2);
        System.arraycopy(weights2, 0, weights, 2, 2);
        CallCombine(tess, isect, data, weights, true);
    }

    static boolean CheckForRightSplice(GLUtessellatorImpl tess, ActiveRegion regUp) {
        ActiveRegion regLo = RegionBelow(regUp);
        GLUhalfEdge eUp = regUp.eUp;
        GLUhalfEdge eLo = regLo.eUp;
        if (!Geom.VertLeq(eUp.Org, eLo.Org)) {
            if (Geom.EdgeSign(eUp.Sym.Org, eLo.Org, eUp.Org) < 0.0d) {
                return false;
            }
            ActiveRegion activeRegionRegionAbove = RegionAbove(regUp);
            regUp.dirty = true;
            activeRegionRegionAbove.dirty = true;
            if (Mesh.__gl_meshSplitEdge(eUp.Sym) == null) {
                throw new RuntimeException();
            }
            if (Mesh.__gl_meshSplice(eLo.Sym.Lnext, eUp)) {
                return true;
            }
            throw new RuntimeException();
        }
        if (Geom.EdgeSign(eLo.Sym.Org, eUp.Org, eLo.Org) > 0.0d) {
            return false;
        }
        if (!Geom.VertEq(eUp.Org, eLo.Org)) {
            if (Mesh.__gl_meshSplitEdge(eLo.Sym) == null) {
                throw new RuntimeException();
            }
            if (!Mesh.__gl_meshSplice(eUp, eLo.Sym.Lnext)) {
                throw new RuntimeException();
            }
            regLo.dirty = true;
            regUp.dirty = true;
            return true;
        }
        if (eUp.Org != eLo.Org) {
            tess.pq.pqDelete(eUp.Org.pqHandle);
            SpliceMergeVertices(tess, eLo.Sym.Lnext, eUp);
            return true;
        }
        return true;
    }

    static boolean CheckForLeftSplice(GLUtessellatorImpl tess, ActiveRegion regUp) {
        ActiveRegion regLo = RegionBelow(regUp);
        GLUhalfEdge eUp = regUp.eUp;
        GLUhalfEdge eLo = regLo.eUp;
        if (!$assertionsDisabled && Geom.VertEq(eUp.Sym.Org, eLo.Sym.Org)) {
            throw new AssertionError();
        }
        if (!Geom.VertLeq(eUp.Sym.Org, eLo.Sym.Org)) {
            if (Geom.EdgeSign(eLo.Sym.Org, eUp.Sym.Org, eLo.Org) > 0.0d) {
                return false;
            }
            regLo.dirty = true;
            regUp.dirty = true;
            GLUhalfEdge e = Mesh.__gl_meshSplitEdge(eLo);
            if (e == null) {
                throw new RuntimeException();
            }
            if (!Mesh.__gl_meshSplice(eUp.Lnext, eLo.Sym)) {
                throw new RuntimeException();
            }
            e.Sym.Lface.inside = regUp.inside;
            return true;
        }
        if (Geom.EdgeSign(eUp.Sym.Org, eLo.Sym.Org, eUp.Org) < 0.0d) {
            return false;
        }
        ActiveRegion activeRegionRegionAbove = RegionAbove(regUp);
        regUp.dirty = true;
        activeRegionRegionAbove.dirty = true;
        GLUhalfEdge e2 = Mesh.__gl_meshSplitEdge(eUp);
        if (e2 == null) {
            throw new RuntimeException();
        }
        if (!Mesh.__gl_meshSplice(eLo.Sym, e2)) {
            throw new RuntimeException();
        }
        e2.Lface.inside = regUp.inside;
        return true;
    }

    static boolean CheckForIntersect(GLUtessellatorImpl tess, ActiveRegion regUp) {
        ActiveRegion regLo = RegionBelow(regUp);
        GLUhalfEdge eUp = regUp.eUp;
        GLUhalfEdge eLo = regLo.eUp;
        GLUvertex orgUp = eUp.Org;
        GLUvertex orgLo = eLo.Org;
        GLUvertex dstUp = eUp.Sym.Org;
        GLUvertex dstLo = eLo.Sym.Org;
        GLUvertex isect = new GLUvertex();
        if (!$assertionsDisabled && Geom.VertEq(dstLo, dstUp)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && Geom.EdgeSign(dstUp, tess.event, orgUp) > 0.0d) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && Geom.EdgeSign(dstLo, tess.event, orgLo) < 0.0d) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && (orgUp == tess.event || orgLo == tess.event)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && (regUp.fixUpperEdge || regLo.fixUpperEdge)) {
            throw new AssertionError();
        }
        if (orgUp == orgLo) {
            return false;
        }
        double tMinUp = Math.min(orgUp.t, dstUp.t);
        double tMaxLo = Math.max(orgLo.t, dstLo.t);
        if (tMinUp > tMaxLo) {
            return false;
        }
        if (Geom.VertLeq(orgUp, orgLo)) {
            if (Geom.EdgeSign(dstLo, orgUp, orgLo) > 0.0d) {
                return false;
            }
        } else if (Geom.EdgeSign(dstUp, orgLo, orgUp) < 0.0d) {
            return false;
        }
        DebugEvent(tess);
        Geom.EdgeIntersect(dstUp, orgUp, dstLo, orgLo, isect);
        if (!$assertionsDisabled && Math.min(orgUp.t, dstUp.t) > isect.t) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && isect.t > Math.max(orgLo.t, dstLo.t)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && Math.min(dstLo.s, dstUp.s) > isect.s) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && isect.s > Math.max(orgLo.s, orgUp.s)) {
            throw new AssertionError();
        }
        if (Geom.VertLeq(isect, tess.event)) {
            isect.s = tess.event.s;
            isect.t = tess.event.t;
        }
        GLUvertex orgMin = Geom.VertLeq(orgUp, orgLo) ? orgUp : orgLo;
        if (Geom.VertLeq(orgMin, isect)) {
            isect.s = orgMin.s;
            isect.t = orgMin.t;
        }
        if (Geom.VertEq(isect, orgUp) || Geom.VertEq(isect, orgLo)) {
            CheckForRightSplice(tess, regUp);
            return false;
        }
        if ((!Geom.VertEq(dstUp, tess.event) && Geom.EdgeSign(dstUp, tess.event, isect) >= 0.0d) || (!Geom.VertEq(dstLo, tess.event) && Geom.EdgeSign(dstLo, tess.event, isect) <= 0.0d)) {
            if (dstLo == tess.event) {
                if (Mesh.__gl_meshSplitEdge(eUp.Sym) == null) {
                    throw new RuntimeException();
                }
                if (!Mesh.__gl_meshSplice(eLo.Sym, eUp)) {
                    throw new RuntimeException();
                }
                ActiveRegion regUp2 = TopLeftRegion(regUp);
                if (regUp2 == null) {
                    throw new RuntimeException();
                }
                GLUhalfEdge eUp2 = RegionBelow(regUp2).eUp;
                FinishLeftRegions(tess, RegionBelow(regUp2), regLo);
                AddRightEdges(tess, regUp2, eUp2.Sym.Lnext, eUp2, eUp2, true);
                return true;
            }
            if (dstUp == tess.event) {
                if (Mesh.__gl_meshSplitEdge(eLo.Sym) == null) {
                    throw new RuntimeException();
                }
                if (!Mesh.__gl_meshSplice(eUp.Lnext, eLo.Sym.Lnext)) {
                    throw new RuntimeException();
                }
                ActiveRegion regUp3 = TopRightRegion(regUp);
                GLUhalfEdge e = RegionBelow(regUp3).eUp.Sym.Onext;
                regUp.eUp = eLo.Sym.Lnext;
                AddRightEdges(tess, regUp3, FinishLeftRegions(tess, regUp, null).Onext, eUp.Sym.Onext, e, true);
                return true;
            }
            if (Geom.EdgeSign(dstUp, tess.event, isect) >= 0.0d) {
                ActiveRegion activeRegionRegionAbove = RegionAbove(regUp);
                regUp.dirty = true;
                activeRegionRegionAbove.dirty = true;
                if (Mesh.__gl_meshSplitEdge(eUp.Sym) == null) {
                    throw new RuntimeException();
                }
                eUp.Org.s = tess.event.s;
                eUp.Org.t = tess.event.t;
            }
            if (Geom.EdgeSign(dstLo, tess.event, isect) <= 0.0d) {
                regLo.dirty = true;
                regUp.dirty = true;
                if (Mesh.__gl_meshSplitEdge(eLo.Sym) == null) {
                    throw new RuntimeException();
                }
                eLo.Org.s = tess.event.s;
                eLo.Org.t = tess.event.t;
                return false;
            }
            return false;
        }
        if (Mesh.__gl_meshSplitEdge(eUp.Sym) == null) {
            throw new RuntimeException();
        }
        if (Mesh.__gl_meshSplitEdge(eLo.Sym) == null) {
            throw new RuntimeException();
        }
        if (!Mesh.__gl_meshSplice(eLo.Sym.Lnext, eUp)) {
            throw new RuntimeException();
        }
        eUp.Org.s = isect.s;
        eUp.Org.t = isect.t;
        eUp.Org.pqHandle = tess.pq.pqInsert(eUp.Org);
        if (eUp.Org.pqHandle == Long.MAX_VALUE) {
            tess.pq.pqDeletePriorityQ();
            tess.pq = null;
            throw new RuntimeException();
        }
        GetIntersectData(tess, eUp.Org, orgUp, dstUp, orgLo, dstLo);
        ActiveRegion activeRegionRegionAbove2 = RegionAbove(regUp);
        regLo.dirty = true;
        regUp.dirty = true;
        activeRegionRegionAbove2.dirty = true;
        return false;
    }

    static void WalkDirtyRegions(GLUtessellatorImpl tess, ActiveRegion regUp) {
        ActiveRegion regLo = RegionBelow(regUp);
        while (true) {
            if (regLo.dirty) {
                regUp = regLo;
                regLo = RegionBelow(regLo);
            } else {
                if (!regUp.dirty) {
                    regLo = regUp;
                    regUp = RegionAbove(regUp);
                    if (regUp == null || !regUp.dirty) {
                        return;
                    }
                }
                regUp.dirty = false;
                GLUhalfEdge eUp = regUp.eUp;
                GLUhalfEdge eLo = regLo.eUp;
                if (eUp.Sym.Org != eLo.Sym.Org && CheckForLeftSplice(tess, regUp)) {
                    if (regLo.fixUpperEdge) {
                        DeleteRegion(tess, regLo);
                        if (!Mesh.__gl_meshDelete(eLo)) {
                            throw new RuntimeException();
                        }
                        regLo = RegionBelow(regUp);
                        eLo = regLo.eUp;
                    } else if (regUp.fixUpperEdge) {
                        DeleteRegion(tess, regUp);
                        if (!Mesh.__gl_meshDelete(eUp)) {
                            throw new RuntimeException();
                        }
                        regUp = RegionAbove(regLo);
                        eUp = regUp.eUp;
                    }
                }
                if (eUp.Org != eLo.Org) {
                    if (eUp.Sym.Org != eLo.Sym.Org && !regUp.fixUpperEdge && !regLo.fixUpperEdge && (eUp.Sym.Org == tess.event || eLo.Sym.Org == tess.event)) {
                        if (CheckForIntersect(tess, regUp)) {
                            return;
                        }
                    } else {
                        CheckForRightSplice(tess, regUp);
                    }
                }
                if (eUp.Org == eLo.Org && eUp.Sym.Org == eLo.Sym.Org) {
                    AddWinding(eLo, eUp);
                    DeleteRegion(tess, regUp);
                    if (!Mesh.__gl_meshDelete(eUp)) {
                        throw new RuntimeException();
                    }
                    regUp = RegionAbove(regLo);
                }
            }
        }
    }

    static void ConnectRightVertex(GLUtessellatorImpl tess, ActiveRegion regUp, GLUhalfEdge eBottomLeft) {
        GLUhalfEdge eNew;
        GLUhalfEdge eTopLeft = eBottomLeft.Onext;
        ActiveRegion regLo = RegionBelow(regUp);
        GLUhalfEdge eUp = regUp.eUp;
        GLUhalfEdge eLo = regLo.eUp;
        boolean degenerate = false;
        if (eUp.Sym.Org != eLo.Sym.Org) {
            CheckForIntersect(tess, regUp);
        }
        if (Geom.VertEq(eUp.Org, tess.event)) {
            if (!Mesh.__gl_meshSplice(eTopLeft.Sym.Lnext, eUp)) {
                throw new RuntimeException();
            }
            regUp = TopLeftRegion(regUp);
            if (regUp == null) {
                throw new RuntimeException();
            }
            eTopLeft = RegionBelow(regUp).eUp;
            FinishLeftRegions(tess, RegionBelow(regUp), regLo);
            degenerate = true;
        }
        if (Geom.VertEq(eLo.Org, tess.event)) {
            if (!Mesh.__gl_meshSplice(eBottomLeft, eLo.Sym.Lnext)) {
                throw new RuntimeException();
            }
            eBottomLeft = FinishLeftRegions(tess, regLo, null);
            degenerate = true;
        }
        if (degenerate) {
            AddRightEdges(tess, regUp, eBottomLeft.Onext, eTopLeft, eTopLeft, true);
            return;
        }
        if (Geom.VertLeq(eLo.Org, eUp.Org)) {
            eNew = eLo.Sym.Lnext;
        } else {
            eNew = eUp;
        }
        GLUhalfEdge eNew2 = Mesh.__gl_meshConnect(eBottomLeft.Onext.Sym, eNew);
        if (eNew2 == null) {
            throw new RuntimeException();
        }
        AddRightEdges(tess, regUp, eNew2, eNew2.Onext, eNew2.Onext, false);
        eNew2.Sym.activeRegion.fixUpperEdge = true;
        WalkDirtyRegions(tess, regUp);
    }

    static void ConnectLeftDegenerate(GLUtessellatorImpl tess, ActiveRegion regUp, GLUvertex vEvent) {
        GLUhalfEdge e = regUp.eUp;
        if (Geom.VertEq(e.Org, vEvent)) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            SpliceMergeVertices(tess, e, vEvent.anEdge);
            return;
        }
        if (!Geom.VertEq(e.Sym.Org, vEvent)) {
            if (Mesh.__gl_meshSplitEdge(e.Sym) == null) {
                throw new RuntimeException();
            }
            if (regUp.fixUpperEdge) {
                if (!Mesh.__gl_meshDelete(e.Onext)) {
                    throw new RuntimeException();
                }
                regUp.fixUpperEdge = false;
            }
            if (!Mesh.__gl_meshSplice(vEvent.anEdge, e)) {
                throw new RuntimeException();
            }
            SweepEvent(tess, vEvent);
            return;
        }
        if (!$assertionsDisabled) {
            throw new AssertionError();
        }
        ActiveRegion regUp2 = TopRightRegion(regUp);
        ActiveRegion reg = RegionBelow(regUp2);
        GLUhalfEdge eTopRight = reg.eUp.Sym;
        GLUhalfEdge eLast = eTopRight.Onext;
        GLUhalfEdge eTopLeft = eLast;
        if (reg.fixUpperEdge) {
            if (!$assertionsDisabled && eTopLeft == eTopRight) {
                throw new AssertionError();
            }
            DeleteRegion(tess, reg);
            if (!Mesh.__gl_meshDelete(eTopRight)) {
                throw new RuntimeException();
            }
            eTopRight = eTopLeft.Sym.Lnext;
        }
        if (!Mesh.__gl_meshSplice(vEvent.anEdge, eTopRight)) {
            throw new RuntimeException();
        }
        if (!Geom.EdgeGoesLeft(eTopLeft)) {
            eTopLeft = null;
        }
        AddRightEdges(tess, regUp2, eTopRight.Onext, eLast, eTopLeft, true);
    }

    static void ConnectLeftVertex(GLUtessellatorImpl tess, GLUvertex vEvent) {
        GLUhalfEdge eNew;
        ActiveRegion tmp = new ActiveRegion();
        tmp.eUp = vEvent.anEdge.Sym;
        ActiveRegion regUp = (ActiveRegion) Dict.dictKey(Dict.dictSearch(tess.dict, tmp));
        ActiveRegion regLo = RegionBelow(regUp);
        GLUhalfEdge eUp = regUp.eUp;
        GLUhalfEdge eLo = regLo.eUp;
        if (Geom.EdgeSign(eUp.Sym.Org, vEvent, eUp.Org) == 0.0d) {
            ConnectLeftDegenerate(tess, regUp, vEvent);
            return;
        }
        ActiveRegion reg = Geom.VertLeq(eLo.Sym.Org, eUp.Sym.Org) ? regUp : regLo;
        if (regUp.inside || reg.fixUpperEdge) {
            if (reg == regUp) {
                eNew = Mesh.__gl_meshConnect(vEvent.anEdge.Sym, eUp.Lnext);
                if (eNew == null) {
                    throw new RuntimeException();
                }
            } else {
                GLUhalfEdge tempHalfEdge = Mesh.__gl_meshConnect(eLo.Sym.Onext.Sym, vEvent.anEdge);
                if (tempHalfEdge == null) {
                    throw new RuntimeException();
                }
                eNew = tempHalfEdge.Sym;
            }
            if (reg.fixUpperEdge) {
                if (!FixUpperEdge(reg, eNew)) {
                    throw new RuntimeException();
                }
            } else {
                ComputeWinding(tess, AddRegionBelow(tess, regUp, eNew));
            }
            SweepEvent(tess, vEvent);
            return;
        }
        AddRightEdges(tess, regUp, vEvent.anEdge, vEvent.anEdge, null, true);
    }

    static void SweepEvent(GLUtessellatorImpl tess, GLUvertex vEvent) {
        tess.event = vEvent;
        DebugEvent(tess);
        GLUhalfEdge e = vEvent.anEdge;
        while (e.activeRegion == null) {
            e = e.Onext;
            if (e == vEvent.anEdge) {
                ConnectLeftVertex(tess, vEvent);
                return;
            }
        }
        ActiveRegion regUp = TopLeftRegion(e.activeRegion);
        if (regUp == null) {
            throw new RuntimeException();
        }
        ActiveRegion reg = RegionBelow(regUp);
        GLUhalfEdge eTopLeft = reg.eUp;
        GLUhalfEdge eBottomLeft = FinishLeftRegions(tess, reg, null);
        if (eBottomLeft.Onext == eTopLeft) {
            ConnectRightVertex(tess, regUp, eBottomLeft);
        } else {
            AddRightEdges(tess, regUp, eBottomLeft.Onext, eTopLeft, eTopLeft, true);
        }
    }

    static void AddSentinel(GLUtessellatorImpl tess, double t) {
        ActiveRegion reg = new ActiveRegion();
        if (reg == null) {
            throw new RuntimeException();
        }
        GLUhalfEdge e = Mesh.__gl_meshMakeEdge(tess.mesh);
        if (e == null) {
            throw new RuntimeException();
        }
        e.Org.s = SENTINEL_COORD;
        e.Org.t = t;
        e.Sym.Org.s = -4.0E150d;
        e.Sym.Org.t = t;
        tess.event = e.Sym.Org;
        reg.eUp = e;
        reg.windingNumber = 0;
        reg.inside = false;
        reg.fixUpperEdge = false;
        reg.sentinel = true;
        reg.dirty = false;
        reg.nodeUp = Dict.dictInsert(tess.dict, reg);
        if (reg.nodeUp == null) {
            throw new RuntimeException();
        }
    }

    static void InitEdgeDict(final GLUtessellatorImpl tess) {
        tess.dict = Dict.dictNewDict(tess, new Dict.DictLeq() { // from class: org.lwjgl.util.glu.tessellation.Sweep.1
            @Override // org.lwjgl.util.glu.tessellation.Dict.DictLeq
            public boolean leq(Object frame, Object key1, Object key2) {
                return Sweep.EdgeLeq(tess, (ActiveRegion) key1, (ActiveRegion) key2);
            }
        });
        if (tess.dict == null) {
            throw new RuntimeException();
        }
        AddSentinel(tess, -4.0E150d);
        AddSentinel(tess, SENTINEL_COORD);
    }

    static void DoneEdgeDict(GLUtessellatorImpl tess) {
        int fixedEdges = 0;
        while (true) {
            ActiveRegion reg = (ActiveRegion) Dict.dictKey(Dict.dictMin(tess.dict));
            if (reg != null) {
                if (!reg.sentinel) {
                    if (!$assertionsDisabled && !reg.fixUpperEdge) {
                        throw new AssertionError();
                    }
                    if (!$assertionsDisabled) {
                        fixedEdges++;
                        if (fixedEdges != 1) {
                            throw new AssertionError();
                        }
                    }
                }
                if (!$assertionsDisabled && reg.windingNumber != 0) {
                    throw new AssertionError();
                }
                DeleteRegion(tess, reg);
            } else {
                Dict.dictDeleteDict(tess.dict);
                return;
            }
        }
    }

    static void RemoveDegenerateEdges(GLUtessellatorImpl tess) {
        GLUhalfEdge eHead = tess.mesh.eHead;
        GLUhalfEdge gLUhalfEdge = eHead.next;
        while (true) {
            GLUhalfEdge e = gLUhalfEdge;
            if (e != eHead) {
                GLUhalfEdge eNext = e.next;
                GLUhalfEdge eLnext = e.Lnext;
                if (Geom.VertEq(e.Org, e.Sym.Org) && e.Lnext.Lnext != e) {
                    SpliceMergeVertices(tess, eLnext, e);
                    if (!Mesh.__gl_meshDelete(e)) {
                        throw new RuntimeException();
                    }
                    e = eLnext;
                    eLnext = e.Lnext;
                }
                if (eLnext.Lnext == e) {
                    if (eLnext != e) {
                        if (eLnext == eNext || eLnext == eNext.Sym) {
                            eNext = eNext.next;
                        }
                        if (!Mesh.__gl_meshDelete(eLnext)) {
                            throw new RuntimeException();
                        }
                    }
                    if (e == eNext || e == eNext.Sym) {
                        eNext = eNext.next;
                    }
                    if (!Mesh.__gl_meshDelete(e)) {
                        throw new RuntimeException();
                    }
                }
                gLUhalfEdge = eNext;
            } else {
                return;
            }
        }
    }

    static boolean InitPriorityQ(GLUtessellatorImpl tess) {
        GLUvertex v;
        PriorityQ pq = PriorityQ.pqNewPriorityQ(new PriorityQ.Leq() { // from class: org.lwjgl.util.glu.tessellation.Sweep.2
            @Override // org.lwjgl.util.glu.tessellation.PriorityQ.Leq
            public boolean leq(Object key1, Object key2) {
                return Geom.VertLeq((GLUvertex) key1, (GLUvertex) key2);
            }
        });
        tess.pq = pq;
        if (pq == null) {
            return false;
        }
        GLUvertex vHead = tess.mesh.vHead;
        GLUvertex gLUvertex = vHead.next;
        while (true) {
            v = gLUvertex;
            if (v == vHead) {
                break;
            }
            v.pqHandle = pq.pqInsert(v);
            if (v.pqHandle == Long.MAX_VALUE) {
                break;
            }
            gLUvertex = v.next;
        }
        if (v != vHead || !pq.pqInit()) {
            tess.pq.pqDeletePriorityQ();
            tess.pq = null;
            return false;
        }
        return true;
    }

    static void DonePriorityQ(GLUtessellatorImpl tess) {
        tess.pq.pqDeletePriorityQ();
    }

    static boolean RemoveDegenerateFaces(GLUmesh mesh) {
        GLUface gLUface = mesh.fHead.next;
        while (true) {
            GLUface f = gLUface;
            if (f != mesh.fHead) {
                GLUface fNext = f.next;
                GLUhalfEdge e = f.anEdge;
                if (!$assertionsDisabled && e.Lnext == e) {
                    throw new AssertionError();
                }
                if (e.Lnext.Lnext == e) {
                    AddWinding(e.Onext, e);
                    if (!Mesh.__gl_meshDelete(e)) {
                        return false;
                    }
                }
                gLUface = fNext;
            } else {
                return true;
            }
        }
    }

    public static boolean __gl_computeInterior(GLUtessellatorImpl tess) {
        tess.fatalError = false;
        RemoveDegenerateEdges(tess);
        if (!InitPriorityQ(tess)) {
            return false;
        }
        InitEdgeDict(tess);
        while (true) {
            GLUvertex v = (GLUvertex) tess.pq.pqExtractMin();
            if (v == null) {
                break;
            }
            while (true) {
                GLUvertex vNext = (GLUvertex) tess.pq.pqMinimum();
                if (vNext == null || !Geom.VertEq(vNext, v)) {
                    break;
                }
                SpliceMergeVertices(tess, v.anEdge, ((GLUvertex) tess.pq.pqExtractMin()).anEdge);
            }
            SweepEvent(tess, v);
        }
        tess.event = ((ActiveRegion) Dict.dictKey(Dict.dictMin(tess.dict))).eUp.Org;
        DebugEvent(tess);
        DoneEdgeDict(tess);
        DonePriorityQ(tess);
        if (!RemoveDegenerateFaces(tess.mesh)) {
            return false;
        }
        Mesh.__gl_meshCheckMesh(tess.mesh);
        return true;
    }
}
