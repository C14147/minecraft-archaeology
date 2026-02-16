package org.lwjgl.opencl;

import java.util.Iterator;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/FastLongMap.class */
final class FastLongMap<V> implements Iterable<Entry<V>> {
    private Entry[] table;
    private int size;
    private int mask;
    private int capacity;
    private int threshold;

    FastLongMap() {
        this(16, 0.75f);
    }

    FastLongMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    FastLongMap(int initialCapacity, float loadFactor) {
        if (initialCapacity > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large.");
        }
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity must be greater than zero.");
        }
        if (loadFactor <= 0.0f) {
            throw new IllegalArgumentException("initialCapacity must be greater than zero.");
        }
        this.capacity = 1;
        while (this.capacity < initialCapacity) {
            this.capacity <<= 1;
        }
        this.threshold = (int) (this.capacity * loadFactor);
        this.table = new Entry[this.capacity];
        this.mask = this.capacity - 1;
    }

    private int index(long key) {
        return index(key, this.mask);
    }

    private static int index(long key, int mask) {
        int hash = (int) (key ^ (key >>> 32));
        return hash & mask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V put(long j, V v) {
        Entry[] entryArr = this.table;
        int iIndex = index(j);
        Entry entry = entryArr[iIndex];
        while (true) {
            Entry entry2 = entry;
            if (entry2 == null) {
                entryArr[iIndex] = new Entry(j, v, entryArr[iIndex]);
                int i = this.size;
                this.size = i + 1;
                if (i >= this.threshold) {
                    rehash(entryArr);
                    return null;
                }
                return null;
            }
            if (entry2.key != j) {
                entry = entry2.next;
            } else {
                V v2 = (V) entry2.value;
                entry2.value = v;
                return v2;
            }
        }
    }

    private void rehash(Entry<V>[] table) {
        int newCapacity = 2 * this.capacity;
        int newMask = newCapacity - 1;
        Entry[] entryArr = new Entry[newCapacity];
        for (Entry entry : table) {
            if (entry != null) {
                do {
                    Entry entry2 = entry.next;
                    int index = index(entry.key, newMask);
                    entry.next = entryArr[index];
                    entryArr[index] = entry;
                    entry = entry2;
                } while (entry != null);
            }
        }
        this.table = entryArr;
        this.capacity = newCapacity;
        this.mask = newMask;
        this.threshold *= 2;
    }

    public V get(long j) {
        Entry entry = this.table[index(j)];
        while (true) {
            Entry entry2 = entry;
            if (entry2 == null) {
                return null;
            }
            if (entry2.key == j) {
                return (V) entry2.value;
            }
            entry = entry2.next;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        r6 = r6 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean containsValue(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = r3
            org.lwjgl.opencl.FastLongMap$Entry[] r0 = r0.table
            r5 = r0
            r0 = r5
            int r0 = r0.length
            r1 = 1
            int r0 = r0 - r1
            r6 = r0
        La:
            r0 = r6
            if (r0 < 0) goto L36
            r0 = r5
            r1 = r6
            r0 = r0[r1]
            r7 = r0
        L13:
            r0 = r7
            if (r0 == 0) goto L30
            r0 = r7
            T r0 = r0.value
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L26
            r0 = 1
            return r0
        L26:
            r0 = r7
            org.lwjgl.opencl.FastLongMap$Entry<T> r0 = r0.next
            r7 = r0
            goto L13
        L30:
            int r6 = r6 + (-1)
            goto La
        L36:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.FastLongMap.containsValue(java.lang.Object):boolean");
    }

    public boolean containsKey(long key) {
        int index = index(key);
        Entry entry = this.table[index];
        while (true) {
            Entry entry2 = entry;
            if (entry2 == null) {
                return false;
            }
            if (entry2.key == key) {
                return true;
            }
            entry = entry2.next;
        }
    }

    public V remove(long j) {
        int iIndex = index(j);
        Entry entry = this.table[iIndex];
        Entry entry2 = entry;
        while (true) {
            Entry entry3 = entry2;
            if (entry3 != null) {
                Entry entry4 = entry3.next;
                if (entry3.key == j) {
                    this.size--;
                    if (entry == entry3) {
                        this.table[iIndex] = entry4;
                    } else {
                        entry.next = entry4;
                    }
                    return (V) entry3.value;
                }
                entry = entry3;
                entry2 = entry4;
            } else {
                return null;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        Entry<V>[] table = this.table;
        for (int index = table.length - 1; index >= 0; index--) {
            table[index] = null;
        }
        this.size = 0;
    }

    @Override // java.lang.Iterable
    public FastLongMap<V>.EntryIterator iterator() {
        return new EntryIterator();
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/FastLongMap$EntryIterator.class */
    public class EntryIterator implements Iterator<Entry<V>> {
        private int nextIndex;
        private Entry<V> current;

        EntryIterator() {
            reset();
        }

        public void reset() {
            this.current = null;
            Entry<V>[] table = FastLongMap.this.table;
            int i = table.length - 1;
            while (i >= 0 && table[i] == null) {
                i--;
            }
            this.nextIndex = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex >= 0) {
                return true;
            }
            Entry<V> entry = this.current;
            return (entry == null || entry.next == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Entry<V> next() {
            Entry<V> e;
            Entry<V> e2 = this.current;
            if (e2 == null || (e = e2.next) == null) {
                Entry<V>[] table = FastLongMap.this.table;
                int i = this.nextIndex;
                Entry<V> e3 = table[i];
                this.current = e3;
                do {
                    i--;
                    if (i < 0) {
                        break;
                    }
                } while (table[i] == null);
                this.nextIndex = i;
                return e3;
            }
            this.current = e;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            FastLongMap.this.remove(this.current.key);
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/FastLongMap$Entry.class */
    static final class Entry<T> {
        final long key;
        T value;
        Entry<T> next;

        Entry(long key, T value, Entry<T> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public long getKey() {
            return this.key;
        }

        public T getValue() {
            return this.value;
        }
    }
}
