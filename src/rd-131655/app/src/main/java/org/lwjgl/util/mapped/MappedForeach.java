package org.lwjgl.util.mapped;

import java.util.Iterator;
import org.lwjgl.util.mapped.MappedObject;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedForeach.class */
final class MappedForeach<T extends MappedObject> implements Iterable<T> {
    final T mapped;
    final int elementCount;

    MappedForeach(T mapped, int elementCount) {
        this.mapped = mapped;
        this.elementCount = elementCount;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return (Iterator<T>) new Iterator<T>() { // from class: org.lwjgl.util.mapped.MappedForeach.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < MappedForeach.this.elementCount;
            }

            @Override // java.util.Iterator
            public T next() {
                T t = MappedForeach.this.mapped;
                T t2 = MappedForeach.this.mapped;
                int i = this.index;
                this.index = i + 1;
                t.setViewAddress(t2.getViewAddress(i));
                return MappedForeach.this.mapped;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
