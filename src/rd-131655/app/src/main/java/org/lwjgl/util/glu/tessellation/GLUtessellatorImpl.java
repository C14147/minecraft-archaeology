package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLUtessellator;
import org.lwjgl.util.glu.GLUtessellatorCallback;
import org.lwjgl.util.glu.GLUtessellatorCallbackAdapter;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/GLUtessellatorImpl.class */
public class GLUtessellatorImpl implements GLUtessellator {
    public static final int TESS_MAX_CACHE = 100;
    private GLUhalfEdge lastEdge;
    GLUmesh mesh;
    private double relTolerance;
    int windingRule;
    boolean fatalError;
    Dict dict;
    PriorityQ pq;
    GLUvertex event;
    boolean flagBoundary;
    boolean boundaryOnly;
    GLUface lonelyTriList;
    private boolean flushCacheOnNextVertex;
    int cacheCount;
    private Object polygonData;
    private GLUtessellatorCallback callBegin;
    private GLUtessellatorCallback callEdgeFlag;
    private GLUtessellatorCallback callVertex;
    private GLUtessellatorCallback callEnd;
    private GLUtessellatorCallback callError;
    private GLUtessellatorCallback callCombine;
    private GLUtessellatorCallback callBeginData;
    private GLUtessellatorCallback callEdgeFlagData;
    private GLUtessellatorCallback callVertexData;
    private GLUtessellatorCallback callEndData;
    private GLUtessellatorCallback callErrorData;
    private GLUtessellatorCallback callCombineData;
    private static final double GLU_TESS_DEFAULT_TOLERANCE = 0.0d;
    private static GLUtessellatorCallback NULL_CB;
    static final /* synthetic */ boolean $assertionsDisabled;
    double[] normal = new double[3];
    double[] sUnit = new double[3];
    double[] tUnit = new double[3];
    CachedVertex[] cache = new CachedVertex[100];
    private int state = 0;

    static {
        $assertionsDisabled = !GLUtessellatorImpl.class.desiredAssertionStatus();
        NULL_CB = new GLUtessellatorCallbackAdapter();
    }

    public GLUtessellatorImpl() {
        this.normal[0] = 0.0d;
        this.normal[1] = 0.0d;
        this.normal[2] = 0.0d;
        this.relTolerance = GLU_TESS_DEFAULT_TOLERANCE;
        this.windingRule = GLU.GLU_TESS_WINDING_ODD;
        this.flagBoundary = false;
        this.boundaryOnly = false;
        this.callBegin = NULL_CB;
        this.callEdgeFlag = NULL_CB;
        this.callVertex = NULL_CB;
        this.callEnd = NULL_CB;
        this.callError = NULL_CB;
        this.callCombine = NULL_CB;
        this.callBeginData = NULL_CB;
        this.callEdgeFlagData = NULL_CB;
        this.callVertexData = NULL_CB;
        this.callEndData = NULL_CB;
        this.callErrorData = NULL_CB;
        this.callCombineData = NULL_CB;
        this.polygonData = null;
        for (int i = 0; i < this.cache.length; i++) {
            this.cache[i] = new CachedVertex();
        }
    }

    public static GLUtessellator gluNewTess() {
        return new GLUtessellatorImpl();
    }

    private void makeDormant() {
        if (this.mesh != null) {
            Mesh.__gl_meshDeleteMesh(this.mesh);
        }
        this.state = 0;
        this.lastEdge = null;
        this.mesh = null;
    }

    private void requireState(int newState) {
        if (this.state != newState) {
            gotoState(newState);
        }
    }

    private void gotoState(int newState) {
        while (this.state != newState) {
            if (this.state < newState) {
                if (this.state == 0) {
                    callErrorOrErrorData(100151);
                    gluTessBeginPolygon(null);
                } else if (this.state == 1) {
                    callErrorOrErrorData(100152);
                    gluTessBeginContour();
                }
            } else if (this.state == 2) {
                callErrorOrErrorData(100154);
                gluTessEndContour();
            } else if (this.state == 1) {
                callErrorOrErrorData(100153);
                makeDormant();
            }
        }
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluDeleteTess() {
        requireState(0);
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessProperty(int which, double value) {
        switch (which) {
            case GLU.GLU_TESS_WINDING_RULE /* 100140 */:
                int windingRule = (int) value;
                if (windingRule == value) {
                    switch (windingRule) {
                        case GLU.GLU_TESS_WINDING_ODD /* 100130 */:
                        case GLU.GLU_TESS_WINDING_NONZERO /* 100131 */:
                        case GLU.GLU_TESS_WINDING_POSITIVE /* 100132 */:
                        case GLU.GLU_TESS_WINDING_NEGATIVE /* 100133 */:
                        case GLU.GLU_TESS_WINDING_ABS_GEQ_TWO /* 100134 */:
                            this.windingRule = windingRule;
                            break;
                    }
                }
                callErrorOrErrorData(100901);
            case GLU.GLU_TESS_BOUNDARY_ONLY /* 100141 */:
                this.boundaryOnly = value != GLU_TESS_DEFAULT_TOLERANCE;
                break;
            case GLU.GLU_TESS_TOLERANCE /* 100142 */:
                if (value >= GLU_TESS_DEFAULT_TOLERANCE && value <= 1.0d) {
                    this.relTolerance = value;
                }
                callErrorOrErrorData(100901);
                break;
            default:
                callErrorOrErrorData(100900);
                break;
        }
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluGetTessProperty(int which, double[] value, int value_offset) {
        switch (which) {
            case GLU.GLU_TESS_WINDING_RULE /* 100140 */:
                if (!$assertionsDisabled && this.windingRule != 100130 && this.windingRule != 100131 && this.windingRule != 100132 && this.windingRule != 100133 && this.windingRule != 100134) {
                    throw new AssertionError();
                }
                value[value_offset] = this.windingRule;
                return;
            case GLU.GLU_TESS_BOUNDARY_ONLY /* 100141 */:
                if (!$assertionsDisabled && !this.boundaryOnly && this.boundaryOnly) {
                    throw new AssertionError();
                }
                value[value_offset] = this.boundaryOnly ? 1.0d : GLU_TESS_DEFAULT_TOLERANCE;
                return;
            case GLU.GLU_TESS_TOLERANCE /* 100142 */:
                if (!$assertionsDisabled && (GLU_TESS_DEFAULT_TOLERANCE > this.relTolerance || this.relTolerance > 1.0d)) {
                    throw new AssertionError();
                }
                value[value_offset] = this.relTolerance;
                return;
            default:
                value[value_offset] = 0.0d;
                callErrorOrErrorData(100900);
                return;
        }
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessNormal(double x, double y, double z) {
        this.normal[0] = x;
        this.normal[1] = y;
        this.normal[2] = z;
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessCallback(int which, GLUtessellatorCallback aCallback) {
        switch (which) {
            case 100100:
                this.callBegin = aCallback == null ? NULL_CB : aCallback;
                break;
            case 100101:
                this.callVertex = aCallback == null ? NULL_CB : aCallback;
                break;
            case 100102:
                this.callEnd = aCallback == null ? NULL_CB : aCallback;
                break;
            case 100103:
                this.callError = aCallback == null ? NULL_CB : aCallback;
                break;
            case 100104:
                this.callEdgeFlag = aCallback == null ? NULL_CB : aCallback;
                this.flagBoundary = aCallback != null;
                break;
            case GLU.GLU_TESS_COMBINE /* 100105 */:
                this.callCombine = aCallback == null ? NULL_CB : aCallback;
                break;
            case GLU.GLU_TESS_BEGIN_DATA /* 100106 */:
                this.callBeginData = aCallback == null ? NULL_CB : aCallback;
                break;
            case GLU.GLU_TESS_VERTEX_DATA /* 100107 */:
                this.callVertexData = aCallback == null ? NULL_CB : aCallback;
                break;
            case GLU.GLU_TESS_END_DATA /* 100108 */:
                this.callEndData = aCallback == null ? NULL_CB : aCallback;
                break;
            case GLU.GLU_TESS_ERROR_DATA /* 100109 */:
                this.callErrorData = aCallback == null ? NULL_CB : aCallback;
                break;
            case GLU.GLU_TESS_EDGE_FLAG_DATA /* 100110 */:
                GLUtessellatorCallback gLUtessellatorCallback = aCallback == null ? NULL_CB : aCallback;
                this.callBegin = gLUtessellatorCallback;
                this.callEdgeFlagData = gLUtessellatorCallback;
                this.flagBoundary = aCallback != null;
                break;
            case GLU.GLU_TESS_COMBINE_DATA /* 100111 */:
                this.callCombineData = aCallback == null ? NULL_CB : aCallback;
                break;
            default:
                callErrorOrErrorData(100900);
                break;
        }
    }

    private boolean addVertex(double[] coords, Object vertexData) {
        GLUhalfEdge e;
        GLUhalfEdge e2 = this.lastEdge;
        if (e2 == null) {
            e = Mesh.__gl_meshMakeEdge(this.mesh);
            if (e == null || !Mesh.__gl_meshSplice(e, e.Sym)) {
                return false;
            }
        } else {
            if (Mesh.__gl_meshSplitEdge(e2) == null) {
                return false;
            }
            e = e2.Lnext;
        }
        e.Org.data = vertexData;
        e.Org.coords[0] = coords[0];
        e.Org.coords[1] = coords[1];
        e.Org.coords[2] = coords[2];
        e.winding = 1;
        e.Sym.winding = -1;
        this.lastEdge = e;
        return true;
    }

    private void cacheVertex(double[] coords, Object vertexData) {
        if (this.cache[this.cacheCount] == null) {
            this.cache[this.cacheCount] = new CachedVertex();
        }
        CachedVertex v = this.cache[this.cacheCount];
        v.data = vertexData;
        v.coords[0] = coords[0];
        v.coords[1] = coords[1];
        v.coords[2] = coords[2];
        this.cacheCount++;
    }

    private boolean flushCache() {
        CachedVertex[] v = this.cache;
        this.mesh = Mesh.__gl_meshNewMesh();
        if (this.mesh == null) {
            return false;
        }
        for (int i = 0; i < this.cacheCount; i++) {
            CachedVertex vertex = v[i];
            if (!addVertex(vertex.coords, vertex.data)) {
                return false;
            }
        }
        this.cacheCount = 0;
        this.flushCacheOnNextVertex = false;
        return true;
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessVertex(double[] coords, int coords_offset, Object vertexData) {
        boolean tooLarge = false;
        double[] clamped = new double[3];
        requireState(2);
        if (this.flushCacheOnNextVertex) {
            if (!flushCache()) {
                callErrorOrErrorData(100902);
                return;
            }
            this.lastEdge = null;
        }
        for (int i = 0; i < 3; i++) {
            double x = coords[i + coords_offset];
            if (x < -1.0E150d) {
                x = -1.0E150d;
                tooLarge = true;
            }
            if (x > 1.0E150d) {
                x = 1.0E150d;
                tooLarge = true;
            }
            clamped[i] = x;
        }
        if (tooLarge) {
            callErrorOrErrorData(100155);
        }
        if (this.mesh == null) {
            if (this.cacheCount < 100) {
                cacheVertex(clamped, vertexData);
                return;
            } else if (!flushCache()) {
                callErrorOrErrorData(100902);
                return;
            }
        }
        if (!addVertex(clamped, vertexData)) {
            callErrorOrErrorData(100902);
        }
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessBeginPolygon(Object data) {
        requireState(0);
        this.state = 1;
        this.cacheCount = 0;
        this.flushCacheOnNextVertex = false;
        this.mesh = null;
        this.polygonData = data;
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessBeginContour() {
        requireState(1);
        this.state = 2;
        this.lastEdge = null;
        if (this.cacheCount > 0) {
            this.flushCacheOnNextVertex = true;
        }
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessEndContour() {
        requireState(2);
        this.state = 1;
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluTessEndPolygon() {
        boolean rc;
        try {
            requireState(1);
            this.state = 0;
            if (this.mesh == null) {
                if (!this.flagBoundary && Render.__gl_renderCache(this)) {
                    this.polygonData = null;
                    return;
                } else if (!flushCache()) {
                    throw new RuntimeException();
                }
            }
            Normal.__gl_projectPolygon(this);
            if (!Sweep.__gl_computeInterior(this)) {
                throw new RuntimeException();
            }
            GLUmesh mesh = this.mesh;
            if (!this.fatalError) {
                if (this.boundaryOnly) {
                    rc = TessMono.__gl_meshSetWindingNumber(mesh, 1, true);
                } else {
                    rc = TessMono.__gl_meshTessellateInterior(mesh);
                }
                if (!rc) {
                    throw new RuntimeException();
                }
                Mesh.__gl_meshCheckMesh(mesh);
                if (this.callBegin != NULL_CB || this.callEnd != NULL_CB || this.callVertex != NULL_CB || this.callEdgeFlag != NULL_CB || this.callBeginData != NULL_CB || this.callEndData != NULL_CB || this.callVertexData != NULL_CB || this.callEdgeFlagData != NULL_CB) {
                    if (this.boundaryOnly) {
                        Render.__gl_renderBoundary(this, mesh);
                    } else {
                        Render.__gl_renderMesh(this, mesh);
                    }
                }
            }
            Mesh.__gl_meshDeleteMesh(mesh);
            this.polygonData = null;
        } catch (Exception e) {
            e.printStackTrace();
            callErrorOrErrorData(100902);
        }
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluBeginPolygon() {
        gluTessBeginPolygon(null);
        gluTessBeginContour();
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluNextContour(int type) {
        gluTessEndContour();
        gluTessBeginContour();
    }

    @Override // org.lwjgl.util.glu.GLUtessellator
    public void gluEndPolygon() {
        gluTessEndContour();
        gluTessEndPolygon();
    }

    void callBeginOrBeginData(int a) {
        if (this.callBeginData != NULL_CB) {
            this.callBeginData.beginData(a, this.polygonData);
        } else {
            this.callBegin.begin(a);
        }
    }

    void callVertexOrVertexData(Object a) {
        if (this.callVertexData != NULL_CB) {
            this.callVertexData.vertexData(a, this.polygonData);
        } else {
            this.callVertex.vertex(a);
        }
    }

    void callEdgeFlagOrEdgeFlagData(boolean a) {
        if (this.callEdgeFlagData != NULL_CB) {
            this.callEdgeFlagData.edgeFlagData(a, this.polygonData);
        } else {
            this.callEdgeFlag.edgeFlag(a);
        }
    }

    void callEndOrEndData() {
        if (this.callEndData != NULL_CB) {
            this.callEndData.endData(this.polygonData);
        } else {
            this.callEnd.end();
        }
    }

    void callCombineOrCombineData(double[] coords, Object[] vertexData, float[] weights, Object[] outData) {
        if (this.callCombineData != NULL_CB) {
            this.callCombineData.combineData(coords, vertexData, weights, outData, this.polygonData);
        } else {
            this.callCombine.combine(coords, vertexData, weights, outData);
        }
    }

    void callErrorOrErrorData(int a) {
        if (this.callErrorData != NULL_CB) {
            this.callErrorData.errorData(a, this.polygonData);
        } else {
            this.callError.error(a);
        }
    }
}
