package org.lwjgl.util.glu;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/GLUtessellator.class */
public interface GLUtessellator {
    void gluDeleteTess();

    void gluTessProperty(int i, double d);

    void gluGetTessProperty(int i, double[] dArr, int i2);

    void gluTessNormal(double d, double d2, double d3);

    void gluTessCallback(int i, GLUtessellatorCallback gLUtessellatorCallback);

    void gluTessVertex(double[] dArr, int i, Object obj);

    void gluTessBeginPolygon(Object obj);

    void gluTessBeginContour();

    void gluTessEndContour();

    void gluTessEndPolygon();

    void gluBeginPolygon();

    void gluNextContour(int i);

    void gluEndPolygon();
}
