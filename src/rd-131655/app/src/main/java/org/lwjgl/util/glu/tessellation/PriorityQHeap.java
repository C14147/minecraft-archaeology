package org.lwjgl.util.glu.tessellation;

import net.java.games.input.IDirectInputDevice;
import org.lwjgl.util.glu.tessellation.PriorityQ;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/PriorityQHeap.class */
class PriorityQHeap extends PriorityQ {
    PriorityQ.PQhandleElem[] handles;
    int freeList;
    boolean initialized;
    PriorityQ.Leq leq;
    static final /* synthetic */ boolean $assertionsDisabled;
    int size = 0;
    int max = 32;
    PriorityQ.PQnode[] nodes = new PriorityQ.PQnode[33];

    static {
        $assertionsDisabled = !PriorityQHeap.class.desiredAssertionStatus();
    }

    PriorityQHeap(PriorityQ.Leq leq) {
        for (int i = 0; i < this.nodes.length; i++) {
            this.nodes[i] = new PriorityQ.PQnode();
        }
        this.handles = new PriorityQ.PQhandleElem[33];
        for (int i2 = 0; i2 < this.handles.length; i2++) {
            this.handles[i2] = new PriorityQ.PQhandleElem();
        }
        this.initialized = false;
        this.freeList = 0;
        this.leq = leq;
        this.nodes[1].handle = 1;
        this.handles[1].key = null;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    void pqDeletePriorityQ() {
        this.handles = null;
        this.nodes = null;
    }

    void FloatDown(int curr) {
        PriorityQ.PQnode[] n = this.nodes;
        PriorityQ.PQhandleElem[] h = this.handles;
        int hCurr = n[curr].handle;
        while (true) {
            int child = curr << 1;
            if (child < this.size && LEQ(this.leq, h[n[child + 1].handle].key, h[n[child].handle].key)) {
                child++;
            }
            if (!$assertionsDisabled && child > this.max) {
                throw new AssertionError();
            }
            int hChild = n[child].handle;
            if (child > this.size || LEQ(this.leq, h[hCurr].key, h[hChild].key)) {
                break;
            }
            n[curr].handle = hChild;
            h[hChild].node = curr;
            curr = child;
        }
        n[curr].handle = hCurr;
        h[hCurr].node = curr;
    }

    void FloatUp(int curr) {
        PriorityQ.PQnode[] n = this.nodes;
        PriorityQ.PQhandleElem[] h = this.handles;
        int hCurr = n[curr].handle;
        while (true) {
            int parent = curr >> 1;
            int hParent = n[parent].handle;
            if (parent == 0 || LEQ(this.leq, h[hParent].key, h[hCurr].key)) {
                break;
            }
            n[curr].handle = hParent;
            h[hParent].node = curr;
            curr = parent;
        }
        n[curr].handle = hCurr;
        h[hCurr].node = curr;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    boolean pqInit() {
        for (int i = this.size; i >= 1; i--) {
            FloatDown(i);
        }
        this.initialized = true;
        return true;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    int pqInsert(Object keyNew) {
        int free;
        int curr = this.size + 1;
        this.size = curr;
        if (curr * 2 > this.max) {
            PriorityQ.PQnode[] saveNodes = this.nodes;
            PriorityQ.PQhandleElem[] saveHandles = this.handles;
            this.max <<= 1;
            PriorityQ.PQnode[] pqNodes = new PriorityQ.PQnode[this.max + 1];
            System.arraycopy(this.nodes, 0, pqNodes, 0, this.nodes.length);
            for (int i = this.nodes.length; i < pqNodes.length; i++) {
                pqNodes[i] = new PriorityQ.PQnode();
            }
            this.nodes = pqNodes;
            if (this.nodes == null) {
                this.nodes = saveNodes;
                return IDirectInputDevice.DIPROPRANGE_NOMAX;
            }
            PriorityQ.PQhandleElem[] pqHandles = new PriorityQ.PQhandleElem[this.max + 1];
            System.arraycopy(this.handles, 0, pqHandles, 0, this.handles.length);
            for (int i2 = this.handles.length; i2 < pqHandles.length; i2++) {
                pqHandles[i2] = new PriorityQ.PQhandleElem();
            }
            this.handles = pqHandles;
            if (this.handles == null) {
                this.handles = saveHandles;
                return IDirectInputDevice.DIPROPRANGE_NOMAX;
            }
        }
        if (this.freeList == 0) {
            free = curr;
        } else {
            free = this.freeList;
            this.freeList = this.handles[free].node;
        }
        this.nodes[curr].handle = free;
        this.handles[free].node = curr;
        this.handles[free].key = keyNew;
        if (this.initialized) {
            FloatUp(curr);
        }
        if ($assertionsDisabled || free != Integer.MAX_VALUE) {
            return free;
        }
        throw new AssertionError();
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    Object pqExtractMin() {
        PriorityQ.PQnode[] n = this.nodes;
        PriorityQ.PQhandleElem[] h = this.handles;
        int hMin = n[1].handle;
        Object min = h[hMin].key;
        if (this.size > 0) {
            n[1].handle = n[this.size].handle;
            h[n[1].handle].node = 1;
            h[hMin].key = null;
            h[hMin].node = this.freeList;
            this.freeList = hMin;
            int i = this.size - 1;
            this.size = i;
            if (i > 0) {
                FloatDown(1);
            }
        }
        return min;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    void pqDelete(int hCurr) {
        PriorityQ.PQnode[] n = this.nodes;
        PriorityQ.PQhandleElem[] h = this.handles;
        if (!$assertionsDisabled && (hCurr < 1 || hCurr > this.max || h[hCurr].key == null)) {
            throw new AssertionError();
        }
        int curr = h[hCurr].node;
        n[curr].handle = n[this.size].handle;
        h[n[curr].handle].node = curr;
        int i = this.size - 1;
        this.size = i;
        if (curr <= i) {
            if (curr <= 1 || LEQ(this.leq, h[n[curr >> 1].handle].key, h[n[curr].handle].key)) {
                FloatDown(curr);
            } else {
                FloatUp(curr);
            }
        }
        h[hCurr].key = null;
        h[hCurr].node = this.freeList;
        this.freeList = hCurr;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    Object pqMinimum() {
        return this.handles[this.nodes[1].handle].key;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    boolean pqIsEmpty() {
        return this.size == 0;
    }
}
