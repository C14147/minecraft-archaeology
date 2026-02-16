package org.lwjgl.opencl;

import org.lwjgl.opencl.CLObject;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/InfoUtil.class */
interface InfoUtil<T extends CLObject> {
    int getInfoInt(T t, int i);

    long getInfoSize(T t, int i);

    long[] getInfoSizeArray(T t, int i);

    long getInfoLong(T t, int i);

    String getInfoString(T t, int i);
}
