package org.lwjgl.util.mapped;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.java.games.input.NativeDefinitions;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.Analyzer;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;
import org.objectweb.asm.tree.analysis.SimpleVerifier;
import org.objectweb.asm.util.TraceClassVisitor;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedObjectTransformer.class */
public class MappedObjectTransformer {
    static final boolean PRINT_ACTIVITY;
    static final boolean PRINT_TIMING;
    static final boolean PRINT_BYTECODE;
    static final Map<String, MappedSubtypeInfo> className_to_subtype;
    static final String MAPPED_OBJECT_JVM;
    static final String MAPPED_HELPER_JVM;
    static final String MAPPEDSET_PREFIX;
    static final String MAPPED_SET2_JVM;
    static final String MAPPED_SET3_JVM;
    static final String MAPPED_SET4_JVM;
    static final String CACHE_LINE_PAD_JVM;
    static final String VIEWADDRESS_METHOD_NAME = "getViewAddress";
    static final String NEXT_METHOD_NAME = "next";
    static final String ALIGN_METHOD_NAME = "getAlign";
    static final String SIZEOF_METHOD_NAME = "getSizeof";
    static final String CAPACITY_METHOD_NAME = "capacity";
    static final String VIEW_CONSTRUCTOR_NAME = "constructView$LWJGL";
    static final Map<Integer, String> OPCODE_TO_NAME;
    static final Map<Integer, String> INSNTYPE_TO_NAME;
    static boolean is_currently_computing_frames;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !MappedObjectTransformer.class.desiredAssertionStatus();
        PRINT_ACTIVITY = LWJGLUtil.DEBUG && LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.mapped.PrintActivity");
        PRINT_TIMING = PRINT_ACTIVITY && LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.mapped.PrintTiming");
        PRINT_BYTECODE = LWJGLUtil.DEBUG && LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.mapped.PrintBytecode");
        MAPPED_OBJECT_JVM = jvmClassName(MappedObject.class);
        MAPPED_HELPER_JVM = jvmClassName(MappedHelper.class);
        MAPPEDSET_PREFIX = jvmClassName(MappedSet.class);
        MAPPED_SET2_JVM = jvmClassName(MappedSet2.class);
        MAPPED_SET3_JVM = jvmClassName(MappedSet3.class);
        MAPPED_SET4_JVM = jvmClassName(MappedSet4.class);
        CACHE_LINE_PAD_JVM = "L" + jvmClassName(CacheLinePad.class) + ";";
        OPCODE_TO_NAME = new HashMap();
        INSNTYPE_TO_NAME = new HashMap();
        getClassEnums(Opcodes.class, OPCODE_TO_NAME, "V1_", "ACC_", "T_", "F_", "MH_");
        getClassEnums(AbstractInsnNode.class, INSNTYPE_TO_NAME, new String[0]);
        className_to_subtype = new HashMap();
        className_to_subtype.put(MAPPED_OBJECT_JVM, new MappedSubtypeInfo(MAPPED_OBJECT_JVM, null, -1, -1, -1, false));
        String vmName = System.getProperty("java.vm.name");
        if (vmName != null && !vmName.contains("Server")) {
            System.err.println("Warning: " + MappedObject.class.getSimpleName() + "s have inferiour performance on Client VMs, please consider switching to a Server VM.");
        }
    }

    public static void register(Class<? extends MappedObject> type) {
        if (MappedObjectClassLoader.FORKED) {
            return;
        }
        MappedType mapped = (MappedType) type.getAnnotation(MappedType.class);
        if (mapped != null && mapped.padding() < 0) {
            throw new ClassFormatError("Invalid mapped type padding: " + mapped.padding());
        }
        if (type.getEnclosingClass() != null && !Modifier.isStatic(type.getModifiers())) {
            throw new InternalError("only top-level or static inner classes are allowed");
        }
        String className = jvmClassName(type);
        Map<String, FieldInfo> fields = new HashMap<>();
        long sizeof = 0;
        Field[] arr$ = type.getDeclaredFields();
        for (Field field : arr$) {
            FieldInfo fieldInfo = registerField(mapped == null || mapped.autoGenerateOffsets(), className, sizeof, field);
            if (fieldInfo != null) {
                fields.put(field.getName(), fieldInfo);
                sizeof = Math.max(sizeof, fieldInfo.offset + fieldInfo.lengthPadded);
            }
        }
        int align = 4;
        int padding = 0;
        boolean cacheLinePadded = false;
        if (mapped != null) {
            align = mapped.align();
            if (mapped.cacheLinePadding()) {
                if (mapped.padding() != 0) {
                    throw new ClassFormatError("Mapped type padding cannot be specified together with cacheLinePadding.");
                }
                int cacheLineMod = (int) (sizeof % ((long) CacheUtil.getCacheLineSize()));
                if (cacheLineMod != 0) {
                    padding = CacheUtil.getCacheLineSize() - cacheLineMod;
                }
                cacheLinePadded = true;
            } else {
                padding = mapped.padding();
            }
        }
        MappedSubtypeInfo mappedType = new MappedSubtypeInfo(className, fields, (int) (sizeof + ((long) padding)), align, padding, cacheLinePadded);
        if (className_to_subtype.put(className, mappedType) != null) {
            throw new InternalError("duplicate mapped type: " + mappedType.className);
        }
    }

    private static FieldInfo registerField(boolean autoGenerateOffsets, String className, long advancingOffset, Field field) {
        long byteLength;
        if (Modifier.isStatic(field.getModifiers())) {
            return null;
        }
        if (!field.getType().isPrimitive() && field.getType() != ByteBuffer.class) {
            throw new ClassFormatError("field '" + className + "." + field.getName() + "' not supported: " + field.getType());
        }
        MappedField meta = (MappedField) field.getAnnotation(MappedField.class);
        if (meta == null && !autoGenerateOffsets) {
            throw new ClassFormatError("field '" + className + "." + field.getName() + "' missing annotation " + MappedField.class.getName() + ": " + className);
        }
        Pointer pointer = (Pointer) field.getAnnotation(Pointer.class);
        if (pointer != null && field.getType() != Long.TYPE) {
            throw new ClassFormatError("The @Pointer annotation can only be used on long fields. @Pointer field found: " + className + "." + field.getName() + ": " + field.getType());
        }
        if (Modifier.isVolatile(field.getModifiers()) && (pointer != null || field.getType() == ByteBuffer.class)) {
            throw new ClassFormatError("The volatile keyword is not supported for @Pointer or ByteBuffer fields. Volatile field found: " + className + "." + field.getName() + ": " + field.getType());
        }
        if (field.getType() == Long.TYPE || field.getType() == Double.TYPE) {
            if (pointer == null) {
                byteLength = 8;
            } else {
                byteLength = MappedObjectUnsafe.INSTANCE.addressSize();
            }
        } else if (field.getType() == Double.TYPE) {
            byteLength = 8;
        } else if (field.getType() == Integer.TYPE || field.getType() == Float.TYPE) {
            byteLength = 4;
        } else if (field.getType() == Character.TYPE || field.getType() == Short.TYPE) {
            byteLength = 2;
        } else if (field.getType() == Byte.TYPE) {
            byteLength = 1;
        } else if (field.getType() == ByteBuffer.class) {
            byteLength = meta.byteLength();
            if (byteLength < 0) {
                throw new IllegalStateException("invalid byte length for mapped ByteBuffer field: " + className + "." + field.getName() + " [length=" + byteLength + "]");
            }
        } else {
            throw new ClassFormatError(field.getType().getName());
        }
        if (field.getType() != ByteBuffer.class && advancingOffset % byteLength != 0) {
            throw new IllegalStateException("misaligned mapped type: " + className + "." + field.getName());
        }
        CacheLinePad pad = (CacheLinePad) field.getAnnotation(CacheLinePad.class);
        long byteOffset = advancingOffset;
        if (meta != null && meta.byteOffset() != -1) {
            if (meta.byteOffset() < 0) {
                throw new ClassFormatError("Invalid field byte offset: " + className + "." + field.getName() + " [byteOffset=" + meta.byteOffset() + "]");
            }
            if (pad != null) {
                throw new ClassFormatError("A field byte offset cannot be specified together with cache-line padding: " + className + "." + field.getName());
            }
            byteOffset = meta.byteOffset();
        }
        long byteLengthPadded = byteLength;
        if (pad != null) {
            if (pad.before() && byteOffset % ((long) CacheUtil.getCacheLineSize()) != 0) {
                byteOffset += ((long) CacheUtil.getCacheLineSize()) - (byteOffset & ((long) (CacheUtil.getCacheLineSize() - 1)));
            }
            if (pad.after() && (byteOffset + byteLength) % ((long) CacheUtil.getCacheLineSize()) != 0) {
                byteLengthPadded += ((long) CacheUtil.getCacheLineSize()) - ((byteOffset + byteLength) % ((long) CacheUtil.getCacheLineSize()));
            }
            if (!$assertionsDisabled && pad.before() && byteOffset % ((long) CacheUtil.getCacheLineSize()) != 0) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && pad.after() && (byteOffset + byteLengthPadded) % ((long) CacheUtil.getCacheLineSize()) != 0) {
                throw new AssertionError();
            }
        }
        if (PRINT_ACTIVITY) {
            LWJGLUtil.log(MappedObjectTransformer.class.getSimpleName() + ": " + className + "." + field.getName() + " [type=" + field.getType().getSimpleName() + ", offset=" + byteOffset + "]");
        }
        return new FieldInfo(byteOffset, byteLength, byteLengthPadded, Type.getType(field.getType()), Modifier.isVolatile(field.getModifiers()), pointer != null);
    }

    static byte[] transformMappedObject(byte[] bytecode) {
        ClassWriter cw = new ClassWriter(0);
        new ClassReader(bytecode).accept(new ClassAdapter(cw) { // from class: org.lwjgl.util.mapped.MappedObjectTransformer.1
            private final String[] DEFINALIZE_LIST = {MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, MappedObjectTransformer.NEXT_METHOD_NAME, MappedObjectTransformer.ALIGN_METHOD_NAME, MappedObjectTransformer.SIZEOF_METHOD_NAME, MappedObjectTransformer.CAPACITY_METHOD_NAME};

            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                String[] arr$ = this.DEFINALIZE_LIST;
                int len$ = arr$.length;
                int i$ = 0;
                while (true) {
                    if (i$ >= len$) {
                        break;
                    }
                    String method = arr$[i$];
                    if (!name.equals(method)) {
                        i$++;
                    } else {
                        access &= -17;
                        break;
                    }
                }
                return super.visitMethod(access, name, desc, signature, exceptions);
            }
        }, 0);
        return cw.toByteArray();
    }

    static byte[] transformMappedAPI(String className, byte[] bytecode) {
        ClassWriter cw = new ClassWriter(2) { // from class: org.lwjgl.util.mapped.MappedObjectTransformer.2
            protected String getCommonSuperClass(String a, String b) {
                if ((MappedObjectTransformer.is_currently_computing_frames && !a.startsWith("java/")) || !b.startsWith("java/")) {
                    return "java/lang/Object";
                }
                return super.getCommonSuperClass(a, b);
            }
        };
        ClassVisitor transformationAdapter = new TransformationAdapter(cw, className);
        ClassVisitor cv = transformationAdapter;
        if (className_to_subtype.containsKey(className)) {
            cv = getMethodGenAdapter(className, cv);
        }
        new ClassReader(bytecode).accept(cv, 4);
        if (!transformationAdapter.transformed) {
            return bytecode;
        }
        byte[] bytecode2 = cw.toByteArray();
        if (PRINT_BYTECODE) {
            printBytecode(bytecode2);
        }
        return bytecode2;
    }

    private static ClassAdapter getMethodGenAdapter(final String className, ClassVisitor cv) {
        return new ClassAdapter(cv) { // from class: org.lwjgl.util.mapped.MappedObjectTransformer.3
            public void visitEnd() {
                MappedSubtypeInfo mappedSubtype = MappedObjectTransformer.className_to_subtype.get(className);
                generateViewAddressGetter();
                generateCapacity();
                generateAlignGetter(mappedSubtype);
                generateSizeofGetter();
                generateNext();
                for (String fieldName : mappedSubtype.fields.keySet()) {
                    FieldInfo field = mappedSubtype.fields.get(fieldName);
                    if (field.type.getDescriptor().length() > 1) {
                        generateByteBufferGetter(fieldName, field);
                    } else {
                        generateFieldGetter(fieldName, field);
                        generateFieldSetter(fieldName, field);
                    }
                }
                super.visitEnd();
            }

            private void generateViewAddressGetter() {
                MethodVisitor mv = super.visitMethod(1, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J", (String) null, (String[]) null);
                mv.visitCode();
                mv.visitVarInsn(25, 0);
                mv.visitFieldInsn(180, MappedObjectTransformer.MAPPED_OBJECT_JVM, "baseAddress", "J");
                mv.visitVarInsn(21, 1);
                mv.visitFieldInsn(178, className, "SIZEOF", "I");
                mv.visitInsn(104);
                mv.visitInsn(133);
                mv.visitInsn(97);
                if (MappedObject.CHECKS) {
                    mv.visitInsn(92);
                    mv.visitVarInsn(25, 0);
                    mv.visitMethodInsn(184, MappedObjectTransformer.MAPPED_HELPER_JVM, "checkAddress", "(JL" + MappedObjectTransformer.MAPPED_OBJECT_JVM + ";)V");
                }
                mv.visitInsn(173);
                mv.visitMaxs(3, 2);
                mv.visitEnd();
            }

            private void generateCapacity() {
                MethodVisitor mv = super.visitMethod(1, MappedObjectTransformer.CAPACITY_METHOD_NAME, "()I", (String) null, (String[]) null);
                mv.visitCode();
                mv.visitVarInsn(25, 0);
                mv.visitMethodInsn(182, MappedObjectTransformer.MAPPED_OBJECT_JVM, "backingByteBuffer", "()L" + MappedObjectTransformer.jvmClassName(ByteBuffer.class) + ";");
                mv.visitInsn(89);
                mv.visitMethodInsn(182, MappedObjectTransformer.jvmClassName(ByteBuffer.class), MappedObjectTransformer.CAPACITY_METHOD_NAME, "()I");
                mv.visitInsn(95);
                mv.visitMethodInsn(184, MappedObjectTransformer.jvmClassName(MemoryUtil.class), "getAddress0", "(L" + MappedObjectTransformer.jvmClassName(Buffer.class) + ";)J");
                mv.visitVarInsn(25, 0);
                mv.visitFieldInsn(180, MappedObjectTransformer.MAPPED_OBJECT_JVM, "baseAddress", "J");
                mv.visitInsn(101);
                mv.visitInsn(NativeDefinitions.KEY_FIND);
                mv.visitInsn(96);
                mv.visitFieldInsn(178, className, "SIZEOF", "I");
                mv.visitInsn(108);
                mv.visitInsn(172);
                mv.visitMaxs(3, 1);
                mv.visitEnd();
            }

            private void generateAlignGetter(MappedSubtypeInfo mappedSubtype) {
                MethodVisitor mv = super.visitMethod(1, MappedObjectTransformer.ALIGN_METHOD_NAME, "()I", (String) null, (String[]) null);
                mv.visitCode();
                MappedObjectTransformer.visitIntNode(mv, mappedSubtype.sizeof);
                mv.visitInsn(172);
                mv.visitMaxs(1, 1);
                mv.visitEnd();
            }

            private void generateSizeofGetter() {
                MethodVisitor mv = super.visitMethod(1, MappedObjectTransformer.SIZEOF_METHOD_NAME, "()I", (String) null, (String[]) null);
                mv.visitCode();
                mv.visitFieldInsn(178, className, "SIZEOF", "I");
                mv.visitInsn(172);
                mv.visitMaxs(1, 1);
                mv.visitEnd();
            }

            private void generateNext() {
                MethodVisitor mv = super.visitMethod(1, MappedObjectTransformer.NEXT_METHOD_NAME, "()V", (String) null, (String[]) null);
                mv.visitCode();
                mv.visitVarInsn(25, 0);
                mv.visitInsn(89);
                mv.visitFieldInsn(180, MappedObjectTransformer.MAPPED_OBJECT_JVM, "viewAddress", "J");
                mv.visitFieldInsn(178, className, "SIZEOF", "I");
                mv.visitInsn(133);
                mv.visitInsn(97);
                mv.visitMethodInsn(182, className, "setViewAddress", "(J)V");
                mv.visitInsn(177);
                mv.visitMaxs(3, 1);
                mv.visitEnd();
            }

            private void generateByteBufferGetter(String fieldName, FieldInfo field) {
                MethodVisitor mv = super.visitMethod(9, MappedObjectTransformer.getterName(fieldName), "(L" + className + ";I)" + field.type.getDescriptor(), (String) null, (String[]) null);
                mv.visitCode();
                mv.visitVarInsn(25, 0);
                mv.visitVarInsn(21, 1);
                mv.visitMethodInsn(182, className, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J");
                MappedObjectTransformer.visitIntNode(mv, (int) field.offset);
                mv.visitInsn(133);
                mv.visitInsn(97);
                MappedObjectTransformer.visitIntNode(mv, (int) field.length);
                mv.visitMethodInsn(184, MappedObjectTransformer.MAPPED_HELPER_JVM, "newBuffer", "(JI)L" + MappedObjectTransformer.jvmClassName(ByteBuffer.class) + ";");
                mv.visitInsn(176);
                mv.visitMaxs(3, 2);
                mv.visitEnd();
            }

            private void generateFieldGetter(String fieldName, FieldInfo field) {
                MethodVisitor mv = super.visitMethod(9, MappedObjectTransformer.getterName(fieldName), "(L" + className + ";I)" + field.type.getDescriptor(), (String) null, (String[]) null);
                mv.visitCode();
                mv.visitVarInsn(25, 0);
                mv.visitVarInsn(21, 1);
                mv.visitMethodInsn(182, className, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J");
                MappedObjectTransformer.visitIntNode(mv, (int) field.offset);
                mv.visitInsn(133);
                mv.visitInsn(97);
                mv.visitMethodInsn(184, MappedObjectTransformer.MAPPED_HELPER_JVM, field.getAccessType() + "get", "(J)" + field.type.getDescriptor());
                mv.visitInsn(field.type.getOpcode(172));
                mv.visitMaxs(3, 2);
                mv.visitEnd();
            }

            private void generateFieldSetter(String fieldName, FieldInfo field) {
                MethodVisitor mv = super.visitMethod(9, MappedObjectTransformer.setterName(fieldName), "(L" + className + ";I" + field.type.getDescriptor() + ")V", (String) null, (String[]) null);
                mv.visitCode();
                int load = 0;
                switch (field.type.getSort()) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        load = 21;
                        break;
                    case 6:
                        load = 23;
                        break;
                    case 7:
                        load = 22;
                        break;
                    case 8:
                        load = 24;
                        break;
                }
                mv.visitVarInsn(load, 2);
                mv.visitVarInsn(25, 0);
                mv.visitVarInsn(21, 1);
                mv.visitMethodInsn(182, className, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J");
                MappedObjectTransformer.visitIntNode(mv, (int) field.offset);
                mv.visitInsn(133);
                mv.visitInsn(97);
                mv.visitMethodInsn(184, MappedObjectTransformer.MAPPED_HELPER_JVM, field.getAccessType() + "put", "(" + field.type.getDescriptor() + "J)V");
                mv.visitInsn(177);
                mv.visitMaxs(4, 4);
                mv.visitEnd();
            }
        };
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedObjectTransformer$TransformationAdapter.class */
    private static class TransformationAdapter extends ClassAdapter {
        final String className;
        boolean transformed;

        TransformationAdapter(ClassVisitor cv, String className) {
            super(cv);
            this.className = className;
        }

        public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
            MappedSubtypeInfo mappedSubtype = MappedObjectTransformer.className_to_subtype.get(this.className);
            if (mappedSubtype != null && mappedSubtype.fields.containsKey(name)) {
                if (MappedObjectTransformer.PRINT_ACTIVITY) {
                    LWJGLUtil.log(MappedObjectTransformer.class.getSimpleName() + ": discarding field: " + this.className + "." + name + ":" + desc);
                    return null;
                }
                return null;
            }
            if ((access & 8) == 0) {
                return new FieldNode(access, name, desc, signature, value) { // from class: org.lwjgl.util.mapped.MappedObjectTransformer.TransformationAdapter.1
                    public void visitEnd() {
                        if (this.visibleAnnotations == null) {
                            accept(TransformationAdapter.this.cv);
                            return;
                        }
                        boolean before = false;
                        boolean after = false;
                        int byteLength = 0;
                        Iterator i$ = this.visibleAnnotations.iterator();
                        while (true) {
                            if (!i$.hasNext()) {
                                break;
                            }
                            AnnotationNode pad = (AnnotationNode) i$.next();
                            if (MappedObjectTransformer.CACHE_LINE_PAD_JVM.equals(pad.desc)) {
                                if ("J".equals(this.desc) || "D".equals(this.desc)) {
                                    byteLength = 8;
                                } else if ("I".equals(this.desc) || "F".equals(this.desc)) {
                                    byteLength = 4;
                                } else if ("S".equals(this.desc) || "C".equals(this.desc)) {
                                    byteLength = 2;
                                } else if ("B".equals(this.desc) || "Z".equals(this.desc)) {
                                    byteLength = 1;
                                } else {
                                    throw new ClassFormatError("The @CacheLinePad annotation cannot be used on non-primitive fields: " + TransformationAdapter.this.className + "." + this.name);
                                }
                                TransformationAdapter.this.transformed = true;
                                after = true;
                                if (pad.values != null) {
                                    for (int i = 0; i < pad.values.size(); i += 2) {
                                        boolean value2 = pad.values.get(i + 1).equals(Boolean.TRUE);
                                        if ("before".equals(pad.values.get(i))) {
                                            before = value2;
                                        } else {
                                            after = value2;
                                        }
                                    }
                                }
                            }
                        }
                        if (before) {
                            int count = (CacheUtil.getCacheLineSize() / byteLength) - 1;
                            for (int i2 = count; i2 >= 1; i2--) {
                                TransformationAdapter.this.cv.visitField(this.access | 1 | 4096, this.name + "$PAD_" + i2, this.desc, this.signature, (Object) null);
                            }
                        }
                        accept(TransformationAdapter.this.cv);
                        if (after) {
                            int count2 = (CacheUtil.getCacheLineSize() / byteLength) - 1;
                            for (int i3 = 1; i3 <= count2; i3++) {
                                TransformationAdapter.this.cv.visitField(this.access | 1 | 4096, this.name + "$PAD" + i3, this.desc, this.signature, (Object) null);
                            }
                        }
                    }
                };
            }
            return super.visitField(access, name, desc, signature, value);
        }

        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if ("<init>".equals(name)) {
                MappedSubtypeInfo mappedSubtype = MappedObjectTransformer.className_to_subtype.get(this.className);
                if (mappedSubtype != null) {
                    if (!"()V".equals(desc)) {
                        throw new ClassFormatError(this.className + " can only have a default constructor, found: " + desc);
                    }
                    MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                    mv.visitVarInsn(25, 0);
                    mv.visitMethodInsn(183, MappedObjectTransformer.MAPPED_OBJECT_JVM, "<init>", "()V");
                    mv.visitInsn(177);
                    mv.visitMaxs(0, 0);
                    name = MappedObjectTransformer.VIEW_CONSTRUCTOR_NAME;
                }
            }
            final MethodVisitor mv2 = super.visitMethod(access, name, desc, signature, exceptions);
            return new MethodNode(access, name, desc, signature, exceptions) { // from class: org.lwjgl.util.mapped.MappedObjectTransformer.TransformationAdapter.2
                boolean needsTransformation;

                public void visitMaxs(int a, int b) {
                    try {
                        MappedObjectTransformer.is_currently_computing_frames = true;
                        super.visitMaxs(a, b);
                        MappedObjectTransformer.is_currently_computing_frames = false;
                    } catch (Throwable th) {
                        MappedObjectTransformer.is_currently_computing_frames = false;
                        throw th;
                    }
                }

                public void visitFieldInsn(int opcode, String owner, String name2, String desc2) {
                    if (MappedObjectTransformer.className_to_subtype.containsKey(owner) || owner.startsWith(MappedObjectTransformer.MAPPEDSET_PREFIX)) {
                        this.needsTransformation = true;
                    }
                    super.visitFieldInsn(opcode, owner, name2, desc2);
                }

                public void visitMethodInsn(int opcode, String owner, String name2, String desc2) {
                    if (MappedObjectTransformer.className_to_subtype.containsKey(owner)) {
                        this.needsTransformation = true;
                    }
                    super.visitMethodInsn(opcode, owner, name2, desc2);
                }

                public void visitEnd() {
                    if (this.needsTransformation) {
                        TransformationAdapter.this.transformed = true;
                        try {
                            transformMethod(analyse());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    accept(mv2);
                }

                private Frame<BasicValue>[] analyse() throws AnalyzerException {
                    Analyzer<BasicValue> a = new Analyzer<>(new SimpleVerifier());
                    a.analyze(TransformationAdapter.this.className, this);
                    return a.getFrames();
                }

                private void transformMethod(Frame<BasicValue>[] frames) {
                    InsnList instructions = this.instructions;
                    Map<Integer, MappedSubtypeInfo> arrayVars = new HashMap<>();
                    Map<AbstractInsnNode, Frame<BasicValue>> frameMap = new HashMap<>();
                    for (int i = 0; i < frames.length; i++) {
                        frameMap.put(instructions.get(i), frames[i]);
                    }
                    int i2 = 0;
                    while (i2 < instructions.size()) {
                        VarInsnNode varInsnNode = instructions.get(i2);
                        switch (varInsnNode.getType()) {
                            case 2:
                                if (varInsnNode.getOpcode() == 25) {
                                    VarInsnNode varInsn = varInsnNode;
                                    MappedSubtypeInfo mappedSubtype2 = arrayVars.get(Integer.valueOf(varInsn.var));
                                    if (mappedSubtype2 != null) {
                                        i2 = MappedObjectTransformer.transformArrayAccess(instructions, i2, frameMap, varInsn, mappedSubtype2, varInsn.var);
                                    }
                                }
                                break;
                            case 4:
                                FieldInsnNode fieldInsn = (FieldInsnNode) varInsnNode;
                                InsnList list = MappedObjectTransformer.transformFieldAccess(fieldInsn);
                                if (list != null) {
                                    i2 = MappedObjectTransformer.replace(instructions, i2, varInsnNode, list);
                                }
                                break;
                            case 5:
                                MethodInsnNode methodInsn = (MethodInsnNode) varInsnNode;
                                MappedSubtypeInfo mappedType = MappedObjectTransformer.className_to_subtype.get(methodInsn.owner);
                                if (mappedType != null) {
                                    i2 = MappedObjectTransformer.transformMethodCall(instructions, i2, frameMap, methodInsn, mappedType, arrayVars);
                                }
                                break;
                        }
                        i2++;
                    }
                }
            };
        }
    }

    static int transformMethodCall(InsnList instructions, int i, Map<AbstractInsnNode, Frame<BasicValue>> frameMap, MethodInsnNode methodInsn, MappedSubtypeInfo mappedType, Map<Integer, MappedSubtypeInfo> arrayVars) {
        switch (methodInsn.getOpcode()) {
            case 182:
                if ("asArray".equals(methodInsn.name) && methodInsn.desc.equals("()[L" + MAPPED_OBJECT_JVM + ";")) {
                    AbstractInsnNode nextInstruction = methodInsn.getNext();
                    checkInsnAfterIsArray(nextInstruction, 192);
                    VarInsnNode next = nextInstruction.getNext();
                    checkInsnAfterIsArray(next, 58);
                    Frame<BasicValue> frame = frameMap.get(next);
                    String targetType = frame.getStack(frame.getStackSize() - 1).getType().getElementType().getInternalName();
                    if (!methodInsn.owner.equals(targetType)) {
                        throw new ClassCastException("Source: " + methodInsn.owner + " - Target: " + targetType);
                    }
                    VarInsnNode varInstruction = next;
                    arrayVars.put(Integer.valueOf(varInstruction.var), mappedType);
                    instructions.remove(methodInsn.getNext());
                    instructions.remove(methodInsn);
                }
                if ("dup".equals(methodInsn.name) && methodInsn.desc.equals("()L" + MAPPED_OBJECT_JVM + ";")) {
                    i = replace(instructions, i, methodInsn, generateDupInstructions(methodInsn));
                } else if ("slice".equals(methodInsn.name) && methodInsn.desc.equals("()L" + MAPPED_OBJECT_JVM + ";")) {
                    i = replace(instructions, i, methodInsn, generateSliceInstructions(methodInsn));
                } else if ("runViewConstructor".equals(methodInsn.name) && "()V".equals(methodInsn.desc)) {
                    i = replace(instructions, i, methodInsn, generateRunViewConstructorInstructions(methodInsn));
                } else if ("copyTo".equals(methodInsn.name) && methodInsn.desc.equals("(L" + MAPPED_OBJECT_JVM + ";)V")) {
                    i = replace(instructions, i, methodInsn, generateCopyToInstructions(mappedType));
                } else if ("copyRange".equals(methodInsn.name) && methodInsn.desc.equals("(L" + MAPPED_OBJECT_JVM + ";I)V")) {
                    i = replace(instructions, i, methodInsn, generateCopyRangeInstructions(mappedType));
                }
                break;
            case 183:
                if (methodInsn.owner.equals(MAPPED_OBJECT_JVM) && "<init>".equals(methodInsn.name) && "()V".equals(methodInsn.desc)) {
                    instructions.remove(methodInsn.getPrevious());
                    instructions.remove(methodInsn);
                    i -= 2;
                }
                break;
            case 184:
                boolean isMapDirectMethod = "map".equals(methodInsn.name) && methodInsn.desc.equals(new StringBuilder().append("(JI)L").append(MAPPED_OBJECT_JVM).append(";").toString());
                boolean isMapBufferMethod = "map".equals(methodInsn.name) && methodInsn.desc.equals(new StringBuilder().append("(Ljava/nio/ByteBuffer;)L").append(MAPPED_OBJECT_JVM).append(";").toString());
                boolean isMallocMethod = "malloc".equals(methodInsn.name) && methodInsn.desc.equals(new StringBuilder().append("(I)L").append(MAPPED_OBJECT_JVM).append(";").toString());
                if (isMapDirectMethod || isMapBufferMethod || isMallocMethod) {
                    i = replace(instructions, i, methodInsn, generateMapInstructions(mappedType, methodInsn.owner, isMapDirectMethod, isMallocMethod));
                }
                break;
        }
        return i;
    }

    private static InsnList generateCopyRangeInstructions(MappedSubtypeInfo mappedType) {
        InsnList list = new InsnList();
        list.add(getIntNode(mappedType.sizeof));
        list.add(new InsnNode(104));
        list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "copy", "(L" + MAPPED_OBJECT_JVM + ";L" + MAPPED_OBJECT_JVM + ";I)V"));
        return list;
    }

    private static InsnList generateCopyToInstructions(MappedSubtypeInfo mappedType) {
        InsnList list = new InsnList();
        list.add(getIntNode(mappedType.sizeof - mappedType.padding));
        list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "copy", "(L" + MAPPED_OBJECT_JVM + ";L" + MAPPED_OBJECT_JVM + ";I)V"));
        return list;
    }

    private static InsnList generateRunViewConstructorInstructions(MethodInsnNode methodInsn) {
        InsnList list = new InsnList();
        list.add(new InsnNode(89));
        list.add(new MethodInsnNode(182, methodInsn.owner, VIEW_CONSTRUCTOR_NAME, "()V"));
        return list;
    }

    private static InsnList generateSliceInstructions(MethodInsnNode methodInsn) {
        InsnList list = new InsnList();
        list.add(new TypeInsnNode(187, methodInsn.owner));
        list.add(new InsnNode(89));
        list.add(new MethodInsnNode(183, methodInsn.owner, "<init>", "()V"));
        list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "slice", "(L" + MAPPED_OBJECT_JVM + ";L" + MAPPED_OBJECT_JVM + ";)L" + MAPPED_OBJECT_JVM + ";"));
        return list;
    }

    private static InsnList generateDupInstructions(MethodInsnNode methodInsn) {
        InsnList list = new InsnList();
        list.add(new TypeInsnNode(187, methodInsn.owner));
        list.add(new InsnNode(89));
        list.add(new MethodInsnNode(183, methodInsn.owner, "<init>", "()V"));
        list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "dup", "(L" + MAPPED_OBJECT_JVM + ";L" + MAPPED_OBJECT_JVM + ";)L" + MAPPED_OBJECT_JVM + ";"));
        return list;
    }

    private static InsnList generateMapInstructions(MappedSubtypeInfo mappedType, String className, boolean mapDirectMethod, boolean mallocMethod) {
        InsnList trg = new InsnList();
        if (mallocMethod) {
            trg.add(getIntNode(mappedType.sizeof));
            trg.add(new InsnNode(104));
            trg.add(new MethodInsnNode(184, mappedType.cacheLinePadded ? jvmClassName(CacheUtil.class) : jvmClassName(BufferUtils.class), "createByteBuffer", "(I)L" + jvmClassName(ByteBuffer.class) + ";"));
        } else if (mapDirectMethod) {
            trg.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "newBuffer", "(JI)L" + jvmClassName(ByteBuffer.class) + ";"));
        }
        trg.add(new TypeInsnNode(187, className));
        trg.add(new InsnNode(89));
        trg.add(new MethodInsnNode(183, className, "<init>", "()V"));
        trg.add(new InsnNode(90));
        trg.add(new InsnNode(95));
        trg.add(getIntNode(mappedType.align));
        trg.add(getIntNode(mappedType.sizeof));
        trg.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "setup", "(L" + MAPPED_OBJECT_JVM + ";Ljava/nio/ByteBuffer;II)V"));
        return trg;
    }

    static InsnList transformFieldAccess(FieldInsnNode fieldInsn) {
        MappedSubtypeInfo mappedSubtype = className_to_subtype.get(fieldInsn.owner);
        if (mappedSubtype == null) {
            if ("view".equals(fieldInsn.name) && fieldInsn.owner.startsWith(MAPPEDSET_PREFIX)) {
                return generateSetViewInstructions(fieldInsn);
            }
            return null;
        }
        if ("SIZEOF".equals(fieldInsn.name)) {
            return generateSIZEOFInstructions(fieldInsn, mappedSubtype);
        }
        if ("view".equals(fieldInsn.name)) {
            return generateViewInstructions(fieldInsn, mappedSubtype);
        }
        if ("baseAddress".equals(fieldInsn.name) || "viewAddress".equals(fieldInsn.name)) {
            return generateAddressInstructions(fieldInsn);
        }
        FieldInfo field = mappedSubtype.fields.get(fieldInsn.name);
        if (field == null) {
            return null;
        }
        if (fieldInsn.desc.equals("L" + jvmClassName(ByteBuffer.class) + ";")) {
            return generateByteBufferInstructions(fieldInsn, mappedSubtype, field.offset);
        }
        return generateFieldInstructions(fieldInsn, field);
    }

    private static InsnList generateSetViewInstructions(FieldInsnNode fieldInsn) {
        if (fieldInsn.getOpcode() == 180) {
            throwAccessErrorOnReadOnlyField(fieldInsn.owner, fieldInsn.name);
        }
        if (fieldInsn.getOpcode() != 181) {
            throw new InternalError();
        }
        InsnList list = new InsnList();
        if (MAPPED_SET2_JVM.equals(fieldInsn.owner)) {
            list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_views", "(L" + MAPPED_SET2_JVM + ";I)V"));
        } else if (MAPPED_SET3_JVM.equals(fieldInsn.owner)) {
            list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_views", "(L" + MAPPED_SET3_JVM + ";I)V"));
        } else if (MAPPED_SET4_JVM.equals(fieldInsn.owner)) {
            list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_views", "(L" + MAPPED_SET4_JVM + ";I)V"));
        } else {
            throw new InternalError();
        }
        return list;
    }

    private static InsnList generateSIZEOFInstructions(FieldInsnNode fieldInsn, MappedSubtypeInfo mappedSubtype) {
        if (!"I".equals(fieldInsn.desc)) {
            throw new InternalError();
        }
        InsnList list = new InsnList();
        if (fieldInsn.getOpcode() == 178) {
            list.add(getIntNode(mappedSubtype.sizeof));
            return list;
        }
        if (fieldInsn.getOpcode() == 179) {
            throwAccessErrorOnReadOnlyField(fieldInsn.owner, fieldInsn.name);
        }
        throw new InternalError();
    }

    private static InsnList generateViewInstructions(FieldInsnNode fieldInsn, MappedSubtypeInfo mappedSubtype) {
        if (!"I".equals(fieldInsn.desc)) {
            throw new InternalError();
        }
        InsnList list = new InsnList();
        if (fieldInsn.getOpcode() == 180) {
            if (mappedSubtype.sizeof_shift != 0) {
                list.add(getIntNode(mappedSubtype.sizeof_shift));
                list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "get_view_shift", "(L" + MAPPED_OBJECT_JVM + ";I)I"));
            } else {
                list.add(getIntNode(mappedSubtype.sizeof));
                list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "get_view", "(L" + MAPPED_OBJECT_JVM + ";I)I"));
            }
            return list;
        }
        if (fieldInsn.getOpcode() == 181) {
            if (mappedSubtype.sizeof_shift != 0) {
                list.add(getIntNode(mappedSubtype.sizeof_shift));
                list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_view_shift", "(L" + MAPPED_OBJECT_JVM + ";II)V"));
            } else {
                list.add(getIntNode(mappedSubtype.sizeof));
                list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_view", "(L" + MAPPED_OBJECT_JVM + ";II)V"));
            }
            return list;
        }
        throw new InternalError();
    }

    private static InsnList generateAddressInstructions(FieldInsnNode fieldInsn) {
        if (!"J".equals(fieldInsn.desc)) {
            throw new IllegalStateException();
        }
        if (fieldInsn.getOpcode() == 180) {
            return null;
        }
        if (fieldInsn.getOpcode() == 181) {
            throwAccessErrorOnReadOnlyField(fieldInsn.owner, fieldInsn.name);
        }
        throw new InternalError();
    }

    private static InsnList generateByteBufferInstructions(FieldInsnNode fieldInsn, MappedSubtypeInfo mappedSubtype, long fieldOffset) {
        if (fieldInsn.getOpcode() == 181) {
            throwAccessErrorOnReadOnlyField(fieldInsn.owner, fieldInsn.name);
        }
        if (fieldInsn.getOpcode() == 180) {
            InsnList list = new InsnList();
            list.add(new FieldInsnNode(180, mappedSubtype.className, "viewAddress", "J"));
            list.add(new LdcInsnNode(Long.valueOf(fieldOffset)));
            list.add(new InsnNode(97));
            list.add(new LdcInsnNode(Long.valueOf(mappedSubtype.fields.get(fieldInsn.name).length)));
            list.add(new InsnNode(NativeDefinitions.KEY_FIND));
            list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, "newBuffer", "(JI)L" + jvmClassName(ByteBuffer.class) + ";"));
            return list;
        }
        throw new InternalError();
    }

    private static InsnList generateFieldInstructions(FieldInsnNode fieldInsn, FieldInfo field) {
        InsnList list = new InsnList();
        if (fieldInsn.getOpcode() == 181) {
            list.add(getIntNode((int) field.offset));
            list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, field.getAccessType() + "put", "(L" + MAPPED_OBJECT_JVM + ";" + fieldInsn.desc + "I)V"));
            return list;
        }
        if (fieldInsn.getOpcode() == 180) {
            list.add(getIntNode((int) field.offset));
            list.add(new MethodInsnNode(184, MAPPED_HELPER_JVM, field.getAccessType() + "get", "(L" + MAPPED_OBJECT_JVM + ";I)" + fieldInsn.desc));
            return list;
        }
        throw new InternalError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0219, code lost:
    
        r10.remove(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0220, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int transformArrayAccess(org.objectweb.asm.tree.InsnList r10, int r11, java.util.Map<org.objectweb.asm.tree.AbstractInsnNode, org.objectweb.asm.tree.analysis.Frame<org.objectweb.asm.tree.analysis.BasicValue>> r12, org.objectweb.asm.tree.VarInsnNode r13, org.lwjgl.util.mapped.MappedObjectTransformer.MappedSubtypeInfo r14, int r15) {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.mapped.MappedObjectTransformer.transformArrayAccess(org.objectweb.asm.tree.InsnList, int, java.util.Map, org.objectweb.asm.tree.VarInsnNode, org.lwjgl.util.mapped.MappedObjectTransformer$MappedSubtypeInfo, int):int");
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedObjectTransformer$FieldInfo.class */
    private static class FieldInfo {
        final long offset;
        final long length;
        final long lengthPadded;
        final Type type;
        final boolean isVolatile;
        final boolean isPointer;

        FieldInfo(long offset, long length, long lengthPadded, Type type, boolean isVolatile, boolean isPointer) {
            this.offset = offset;
            this.length = length;
            this.lengthPadded = lengthPadded;
            this.type = type;
            this.isVolatile = isVolatile;
            this.isPointer = isPointer;
        }

        String getAccessType() {
            if (this.isPointer) {
                return "a";
            }
            return this.type.getDescriptor().toLowerCase() + (this.isVolatile ? "v" : "");
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedObjectTransformer$MappedSubtypeInfo.class */
    private static class MappedSubtypeInfo {
        final String className;
        final int sizeof;
        final int sizeof_shift;
        final int align;
        final int padding;
        final boolean cacheLinePadded;
        final Map<String, FieldInfo> fields;

        MappedSubtypeInfo(String className, Map<String, FieldInfo> fields, int sizeof, int align, int padding, boolean cacheLinePadded) {
            this.className = className;
            this.sizeof = sizeof;
            if (((sizeof - 1) & sizeof) == 0) {
                this.sizeof_shift = getPoT(sizeof);
            } else {
                this.sizeof_shift = 0;
            }
            this.align = align;
            this.padding = padding;
            this.cacheLinePadded = cacheLinePadded;
            this.fields = fields;
        }

        private static int getPoT(int value) {
            int pot = -1;
            while (value > 0) {
                pot++;
                value >>= 1;
            }
            return pot;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        if (r5.put((java.lang.Integer) r0.get(null), r0.getName()) == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
    
        throw new java.lang.IllegalStateException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void getClassEnums(java.lang.Class r4, java.util.Map<java.lang.Integer, java.lang.String> r5, java.lang.String... r6) {
        /*
            r0 = r4
            java.lang.reflect.Field[] r0 = r0.getFields()     // Catch: java.lang.Exception -> L89
            r7 = r0
            r0 = r7
            int r0 = r0.length     // Catch: java.lang.Exception -> L89
            r8 = r0
            r0 = 0
            r9 = r0
        Lc:
            r0 = r9
            r1 = r8
            if (r0 >= r1) goto L86
            r0 = r7
            r1 = r9
            r0 = r0[r1]     // Catch: java.lang.Exception -> L89
            r10 = r0
            r0 = r10
            int r0 = r0.getModifiers()     // Catch: java.lang.Exception -> L89
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L80
            r0 = r10
            java.lang.Class r0 = r0.getType()     // Catch: java.lang.Exception -> L89
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L89
            if (r0 == r1) goto L32
            goto L80
        L32:
            r0 = r6
            r11 = r0
            r0 = r11
            int r0 = r0.length     // Catch: java.lang.Exception -> L89
            r12 = r0
            r0 = 0
            r13 = r0
        L3d:
            r0 = r13
            r1 = r12
            if (r0 >= r1) goto L61
            r0 = r11
            r1 = r13
            r0 = r0[r1]     // Catch: java.lang.Exception -> L89
            r14 = r0
            r0 = r10
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Exception -> L89
            r1 = r14
            boolean r0 = r0.startsWith(r1)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L5b
            goto L80
        L5b:
            int r13 = r13 + 1
            goto L3d
        L61:
            r0 = r5
            r1 = r10
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Exception -> L89
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Exception -> L89
            r2 = r10
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L89
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L80
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Exception -> L89
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L89
            throw r0     // Catch: java.lang.Exception -> L89
        L80:
            int r9 = r9 + 1
            goto Lc
        L86:
            goto L8e
        L89:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.mapped.MappedObjectTransformer.getClassEnums(java.lang.Class, java.util.Map, java.lang.String[]):void");
    }

    static String getOpcodeName(AbstractInsnNode insn) {
        String op = OPCODE_TO_NAME.get(Integer.valueOf(insn.getOpcode()));
        return INSNTYPE_TO_NAME.get(Integer.valueOf(insn.getType())) + ": " + insn.getOpcode() + (op == null ? "" : " [" + OPCODE_TO_NAME.get(Integer.valueOf(insn.getOpcode())) + "]");
    }

    static String jvmClassName(Class<?> type) {
        return type.getName().replace('.', '/');
    }

    static String getterName(String fieldName) {
        return "get$" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1) + "$LWJGL";
    }

    static String setterName(String fieldName) {
        return "set$" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1) + "$LWJGL";
    }

    private static void checkInsnAfterIsArray(AbstractInsnNode instruction, int opcode) {
        if (instruction == null) {
            throw new ClassFormatError("Unexpected end of instructions after .asArray() method.");
        }
        if (instruction.getOpcode() != opcode) {
            throw new ClassFormatError("The result of .asArray() must be stored to a local variable. Found: " + getOpcodeName(instruction));
        }
    }

    static AbstractInsnNode getIntNode(int value) {
        if (value <= 5 && -1 <= value) {
            return new InsnNode(2 + value + 1);
        }
        if (value >= -128 && value <= 127) {
            return new IntInsnNode(16, value);
        }
        if (value >= -32768 && value <= 32767) {
            return new IntInsnNode(17, value);
        }
        return new LdcInsnNode(Integer.valueOf(value));
    }

    static void visitIntNode(MethodVisitor mv, int value) {
        if (value <= 5 && -1 <= value) {
            mv.visitInsn(2 + value + 1);
            return;
        }
        if (value >= -128 && value <= 127) {
            mv.visitIntInsn(16, value);
        } else if (value >= -32768 && value <= 32767) {
            mv.visitIntInsn(17, value);
        } else {
            mv.visitLdcInsn(Integer.valueOf(value));
        }
    }

    static int replace(InsnList instructions, int i, AbstractInsnNode location, InsnList list) {
        int size = list.size();
        instructions.insert(location, list);
        instructions.remove(location);
        return i + (size - 1);
    }

    private static void throwAccessErrorOnReadOnlyField(String className, String fieldName) {
        throw new IllegalAccessError("The " + className + "." + fieldName + " field is final.");
    }

    private static void printBytecode(byte[] bytecode) {
        StringWriter sw = new StringWriter();
        new ClassReader(bytecode).accept(new TraceClassVisitor(new ClassWriter(0), new PrintWriter(sw)), 0);
        String dump = sw.toString();
        LWJGLUtil.log(dump);
    }
}
