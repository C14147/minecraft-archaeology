package org.lwjgl.opencl.api;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/api/CLImageFormat.class */
public final class CLImageFormat {
    public static final int STRUCT_SIZE = 8;
    private final int channelOrder;
    private final int channelType;

    public CLImageFormat(int channelOrder, int channelType) {
        this.channelOrder = channelOrder;
        this.channelType = channelType;
    }

    public int getChannelOrder() {
        return this.channelOrder;
    }

    public int getChannelType() {
        return this.channelType;
    }
}
