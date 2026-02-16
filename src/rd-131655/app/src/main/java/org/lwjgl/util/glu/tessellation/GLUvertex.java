package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/GLUvertex.class */
class GLUvertex {
    public GLUvertex next;
    public GLUvertex prev;
    public GLUhalfEdge anEdge;
    public Object data;
    public double[] coords = new double[3];
    public double s;
    public double t;
    public int pqHandle;

    GLUvertex() {
    }
}
