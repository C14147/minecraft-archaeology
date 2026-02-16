package org.lwjgl.opencl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLKernel.class */
public final class CLKernel extends CLObjectChild<CLProgram> {
    private static final CLKernelUtil util = (CLKernelUtil) CLPlatform.getInfoUtilInstance(CLKernel.class, "CL_KERNEL_UTIL");

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLKernel$CLKernelUtil.class */
    interface CLKernelUtil extends InfoUtil<CLKernel> {
        void setArg(CLKernel cLKernel, int i, byte b);

        void setArg(CLKernel cLKernel, int i, short s);

        void setArg(CLKernel cLKernel, int i, int i2);

        void setArg(CLKernel cLKernel, int i, long j);

        void setArg(CLKernel cLKernel, int i, float f);

        void setArg(CLKernel cLKernel, int i, double d);

        void setArg(CLKernel cLKernel, int i, CLObject cLObject);

        void setArgSize(CLKernel cLKernel, int i, long j);

        long getWorkGroupInfoSize(CLKernel cLKernel, CLDevice cLDevice, int i);

        long[] getWorkGroupInfoSizeArray(CLKernel cLKernel, CLDevice cLDevice, int i);

        long getWorkGroupInfoLong(CLKernel cLKernel, CLDevice cLDevice, int i);
    }

    CLKernel(long pointer, CLProgram program) {
        super(pointer, program);
        if (isValid()) {
            program.getCLKernelRegistry().registerObject(this);
        }
    }

    public CLKernel setArg(int index, byte value) {
        util.setArg(this, index, value);
        return this;
    }

    public CLKernel setArg(int index, short value) {
        util.setArg(this, index, value);
        return this;
    }

    public CLKernel setArg(int index, int value) {
        util.setArg(this, index, value);
        return this;
    }

    public CLKernel setArg(int index, long value) {
        util.setArg(this, index, value);
        return this;
    }

    public CLKernel setArg(int index, float value) {
        util.setArg(this, index, value);
        return this;
    }

    public CLKernel setArg(int index, double value) {
        util.setArg(this, index, value);
        return this;
    }

    public CLKernel setArg(int index, CLObject value) {
        util.setArg(this, index, value);
        return this;
    }

    public CLKernel setArgSize(int index, long size) {
        util.setArgSize(this, index, size);
        return this;
    }

    public String getInfoString(int param_name) {
        return util.getInfoString(this, param_name);
    }

    public int getInfoInt(int param_name) {
        return util.getInfoInt(this, param_name);
    }

    public long getWorkGroupInfoSize(CLDevice device, int param_name) {
        return util.getWorkGroupInfoSize(this, device, param_name);
    }

    public long[] getWorkGroupInfoSizeArray(CLDevice device, int param_name) {
        return util.getWorkGroupInfoSizeArray(this, device, param_name);
    }

    public long getWorkGroupInfoLong(CLDevice device, int param_name) {
        return util.getWorkGroupInfoLong(this, device, param_name);
    }

    @Override // org.lwjgl.opencl.CLObjectRetainable
    int release() {
        try {
            int iRelease = super.release();
            if (!isValid()) {
                getParent().getCLKernelRegistry().unregisterObject(this);
            }
            return iRelease;
        } catch (Throwable th) {
            if (!isValid()) {
                getParent().getCLKernelRegistry().unregisterObject(this);
            }
            throw th;
        }
    }
}
