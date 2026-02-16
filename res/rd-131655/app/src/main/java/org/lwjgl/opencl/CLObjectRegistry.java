package org.lwjgl.opencl;

import org.lwjgl.LWJGLUtil;
import org.lwjgl.opencl.CLObjectChild;
import org.lwjgl.opencl.FastLongMap;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLObjectRegistry.class */
class CLObjectRegistry<T extends CLObjectChild> {
    private FastLongMap<T> registry;

    CLObjectRegistry() {
    }

    final boolean isEmpty() {
        return this.registry == null || this.registry.isEmpty();
    }

    final T getObject(long id) {
        if (this.registry == null) {
            return null;
        }
        return this.registry.get(id);
    }

    final boolean hasObject(long id) {
        return this.registry != null && this.registry.containsKey(id);
    }

    final Iterable<FastLongMap.Entry<T>> getAll() {
        return this.registry;
    }

    void registerObject(T object) {
        FastLongMap<T> map = getMap();
        Long key = Long.valueOf(object.getPointer());
        if (LWJGLUtil.DEBUG && map.containsKey(key.longValue())) {
            throw new IllegalStateException("Duplicate object found: " + object.getClass() + " - " + key);
        }
        getMap().put(object.getPointer(), object);
    }

    void unregisterObject(T object) {
        getMap().remove(object.getPointerUnsafe());
    }

    private FastLongMap<T> getMap() {
        if (this.registry == null) {
            this.registry = new FastLongMap<>();
        }
        return this.registry;
    }
}
