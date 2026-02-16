package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/PriorityQ.class */
abstract class PriorityQ {
    public static final int INIT_SIZE = 32;

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/PriorityQ$Leq.class */
    public interface Leq {
        boolean leq(Object obj, Object obj2);
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/PriorityQ$PQhandleElem.class */
    public static class PQhandleElem {
        Object key;
        int node;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/PriorityQ$PQnode.class */
    public static class PQnode {
        int handle;
    }

    abstract void pqDeletePriorityQ();

    abstract boolean pqInit();

    abstract int pqInsert(Object obj);

    abstract Object pqExtractMin();

    abstract void pqDelete(int i);

    abstract Object pqMinimum();

    abstract boolean pqIsEmpty();

    PriorityQ() {
    }

    public static boolean LEQ(Leq leq, Object x, Object y) {
        return Geom.VertLeq((GLUvertex) x, (GLUvertex) y);
    }

    static PriorityQ pqNewPriorityQ(Leq leq) {
        return new PriorityQSort(leq);
    }
}
