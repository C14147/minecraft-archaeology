package org.lwjgl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import org.lwjgl.MemoryUtil;
import sun.misc.Unsafe;
import sun.reflect.FieldAccessor;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/MemoryUtilSun.class */
final class MemoryUtilSun {
    private MemoryUtilSun() {
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/MemoryUtilSun$AccessorUnsafe.class */
    private static class AccessorUnsafe implements MemoryUtil.Accessor {
        private final Unsafe unsafe;
        private final long address;

        AccessorUnsafe() {
            try {
                this.unsafe = getUnsafeInstance();
                this.address = this.unsafe.objectFieldOffset(MemoryUtil.getAddressField());
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }

        @Override // org.lwjgl.MemoryUtil.Accessor
        public long getAddress(Buffer buffer) {
            return this.unsafe.getLong(buffer, this.address);
        }

        private static Unsafe getUnsafeInstance() {
            Field[] fields = Unsafe.class.getDeclaredFields();
            int len$ = fields.length;
            int i$ = 0;
            while (true) {
                if (i$ >= len$) {
                    break;
                }
                Field field = fields[i$];
                if (field.getType().equals(Unsafe.class)) {
                    int modifiers = field.getModifiers();
                    if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                        field.setAccessible(true);
                        try {
                            return (Unsafe) field.get(null);
                        } catch (IllegalAccessException e) {
                            throw new UnsupportedOperationException();
                        }
                    }
                }
                i$++;
            }
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/MemoryUtilSun$AccessorReflectFast.class */
    private static class AccessorReflectFast implements MemoryUtil.Accessor {
        private final FieldAccessor addressAccessor;

        AccessorReflectFast() {
            try {
                Field address = MemoryUtil.getAddressField();
                address.setAccessible(true);
                try {
                    Method m = Field.class.getDeclaredMethod("acquireFieldAccessor", Boolean.TYPE);
                    m.setAccessible(true);
                    this.addressAccessor = (FieldAccessor) m.invoke(address, true);
                } catch (Exception e) {
                    throw new UnsupportedOperationException(e);
                }
            } catch (NoSuchFieldException e2) {
                throw new UnsupportedOperationException(e2);
            }
        }

        @Override // org.lwjgl.MemoryUtil.Accessor
        public long getAddress(Buffer buffer) {
            return this.addressAccessor.getLong(buffer);
        }
    }
}
