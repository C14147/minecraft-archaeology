package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/GLUmesh.class */
class GLUmesh {
    GLUvertex vHead = new GLUvertex();
    GLUface fHead = new GLUface();
    GLUhalfEdge eHead = new GLUhalfEdge(true);
    GLUhalfEdge eHeadSym = new GLUhalfEdge(false);

    GLUmesh() {
    }
}
