package org.lwjgl.util.glu.tessellation;

import net.java.games.input.IDirectInputDevice;
import org.lwjgl.util.glu.tessellation.PriorityQ;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/PriorityQSort.class */
class PriorityQSort extends PriorityQ {
    PriorityQHeap heap;
    int[] order;
    PriorityQ.Leq leq;
    static final /* synthetic */ boolean $assertionsDisabled;
    Object[] keys = new Object[32];
    int size = 0;
    int max = 32;
    boolean initialized = false;

    static {
        $assertionsDisabled = !PriorityQSort.class.desiredAssertionStatus();
    }

    PriorityQSort(PriorityQ.Leq leq) {
        this.heap = new PriorityQHeap(leq);
        this.leq = leq;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    void pqDeletePriorityQ() {
        if (this.heap != null) {
            this.heap.pqDeletePriorityQ();
        }
        this.order = null;
        this.keys = null;
    }

    private static boolean LT(PriorityQ.Leq leq, Object x, Object y) {
        return !PriorityQHeap.LEQ(leq, y, x);
    }

    private static boolean GT(PriorityQ.Leq leq, Object x, Object y) {
        return !PriorityQHeap.LEQ(leq, x, y);
    }

    private static void Swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/PriorityQSort$Stack.class */
    private static class Stack {
        int p;
        int r;

        private Stack() {
        }
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    boolean pqInit() {
        Stack[] stack = new Stack[50];
        for (int k = 0; k < stack.length; k++) {
            stack[k] = new Stack();
        }
        int seed = 2016473283;
        this.order = new int[this.size + 1];
        int r = this.size - 1;
        int piv = 0;
        for (int i = 0; i <= r; i++) {
            this.order[i] = piv;
            piv++;
        }
        stack[0].p = 0;
        stack[0].r = r;
        int top = 0 + 1;
        while (true) {
            top--;
            if (top >= 0) {
                int p = stack[top].p;
                int r2 = stack[top].r;
                while (r2 > p + 10) {
                    seed = Math.abs((seed * 1539415821) + 1);
                    int i2 = p + (seed % ((r2 - p) + 1));
                    int piv2 = this.order[i2];
                    this.order[i2] = this.order[p];
                    this.order[p] = piv2;
                    int i3 = p - 1;
                    int j = r2 + 1;
                    while (true) {
                        i3++;
                        if (!GT(this.leq, this.keys[this.order[i3]], this.keys[piv2])) {
                            do {
                                j--;
                            } while (LT(this.leq, this.keys[this.order[j]], this.keys[piv2]));
                            Swap(this.order, i3, j);
                            if (i3 >= j) {
                                break;
                            }
                        }
                    }
                    Swap(this.order, i3, j);
                    if (i3 - p < r2 - j) {
                        stack[top].p = j + 1;
                        stack[top].r = r2;
                        top++;
                        r2 = i3 - 1;
                    } else {
                        stack[top].p = p;
                        stack[top].r = i3 - 1;
                        top++;
                        p = j + 1;
                    }
                }
                for (int i4 = p + 1; i4 <= r2; i4++) {
                    int piv3 = this.order[i4];
                    int j2 = i4;
                    while (j2 > p && LT(this.leq, this.keys[this.order[j2 - 1]], this.keys[piv3])) {
                        this.order[j2] = this.order[j2 - 1];
                        j2--;
                    }
                    this.order[j2] = piv3;
                }
            } else {
                this.max = this.size;
                this.initialized = true;
                this.heap.pqInit();
                return true;
            }
        }
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    int pqInsert(Object keyNew) {
        if (this.initialized) {
            return this.heap.pqInsert(keyNew);
        }
        int curr = this.size;
        int i = this.size + 1;
        this.size = i;
        if (i >= this.max) {
            Object[] saveKey = this.keys;
            this.max <<= 1;
            Object[] pqKeys = new Object[this.max];
            System.arraycopy(this.keys, 0, pqKeys, 0, this.keys.length);
            this.keys = pqKeys;
            if (this.keys == null) {
                this.keys = saveKey;
                return IDirectInputDevice.DIPROPRANGE_NOMAX;
            }
        }
        if (!$assertionsDisabled && curr == Integer.MAX_VALUE) {
            throw new AssertionError();
        }
        this.keys[curr] = keyNew;
        return -(curr + 1);
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    Object pqExtractMin() {
        if (this.size == 0) {
            return this.heap.pqExtractMin();
        }
        Object sortMin = this.keys[this.order[this.size - 1]];
        if (!this.heap.pqIsEmpty()) {
            Object heapMin = this.heap.pqMinimum();
            if (LEQ(this.leq, heapMin, sortMin)) {
                return this.heap.pqExtractMin();
            }
        }
        do {
            this.size--;
            if (this.size <= 0) {
                break;
            }
        } while (this.keys[this.order[this.size - 1]] == null);
        return sortMin;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    Object pqMinimum() {
        if (this.size == 0) {
            return this.heap.pqMinimum();
        }
        Object sortMin = this.keys[this.order[this.size - 1]];
        if (!this.heap.pqIsEmpty()) {
            Object heapMin = this.heap.pqMinimum();
            if (PriorityQHeap.LEQ(this.leq, heapMin, sortMin)) {
                return heapMin;
            }
        }
        return sortMin;
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    boolean pqIsEmpty() {
        return this.size == 0 && this.heap.pqIsEmpty();
    }

    @Override // org.lwjgl.util.glu.tessellation.PriorityQ
    void pqDelete(int curr) {
        if (curr >= 0) {
            this.heap.pqDelete(curr);
            return;
        }
        int curr2 = -(curr + 1);
        if (!$assertionsDisabled && (curr2 >= this.max || this.keys[curr2] == null)) {
            throw new AssertionError();
        }
        this.keys[curr2] = null;
        while (this.size > 0 && this.keys[this.order[this.size - 1]] == null) {
            this.size--;
        }
    }
}
