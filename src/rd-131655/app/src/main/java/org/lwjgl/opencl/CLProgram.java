package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.PointerBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLProgram.class */
public final class CLProgram extends CLObjectChild<CLContext> {
    private static final CLProgramUtil util = (CLProgramUtil) CLPlatform.getInfoUtilInstance(CLProgram.class, "CL_PROGRAM_UTIL");
    private final CLObjectRegistry<CLKernel> clKernels;

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLProgram$CLProgramUtil.class */
    interface CLProgramUtil extends InfoUtil<CLProgram> {
        CLKernel[] createKernelsInProgram(CLProgram cLProgram);

        CLDevice[] getInfoDevices(CLProgram cLProgram);

        ByteBuffer getInfoBinaries(CLProgram cLProgram, ByteBuffer byteBuffer);

        ByteBuffer[] getInfoBinaries(CLProgram cLProgram, ByteBuffer[] byteBufferArr);

        String getBuildInfoString(CLProgram cLProgram, CLDevice cLDevice, int i);

        int getBuildInfoInt(CLProgram cLProgram, CLDevice cLDevice, int i);
    }

    CLProgram(long pointer, CLContext context) {
        super(pointer, context);
        if (isValid()) {
            context.getCLProgramRegistry().registerObject(this);
            this.clKernels = new CLObjectRegistry<>();
        } else {
            this.clKernels = null;
        }
    }

    public CLKernel getCLKernel(long id) {
        return (CLKernel) this.clKernels.getObject(id);
    }

    public CLKernel[] createKernelsInProgram() {
        return util.createKernelsInProgram(this);
    }

    public String getInfoString(int param_name) {
        return util.getInfoString(this, param_name);
    }

    public int getInfoInt(int param_name) {
        return util.getInfoInt(this, param_name);
    }

    public long[] getInfoSizeArray(int param_name) {
        return util.getInfoSizeArray(this, param_name);
    }

    public CLDevice[] getInfoDevices() {
        return util.getInfoDevices(this);
    }

    public ByteBuffer getInfoBinaries(ByteBuffer target) {
        return util.getInfoBinaries(this, target);
    }

    public ByteBuffer[] getInfoBinaries(ByteBuffer[] target) {
        return util.getInfoBinaries(this, target);
    }

    public String getBuildInfoString(CLDevice device, int param_name) {
        return util.getBuildInfoString(this, device, param_name);
    }

    public int getBuildInfoInt(CLDevice device, int param_name) {
        return util.getBuildInfoInt(this, device, param_name);
    }

    CLObjectRegistry<CLKernel> getCLKernelRegistry() {
        return this.clKernels;
    }

    void registerCLKernels(PointerBuffer kernels) {
        for (int i = kernels.position(); i < kernels.limit(); i++) {
            long pointer = kernels.get(i);
            if (pointer != 0) {
                new CLKernel(pointer, this);
            }
        }
    }

    @Override // org.lwjgl.opencl.CLObjectRetainable
    int release() {
        try {
            int iRelease = super.release();
            if (!isValid()) {
                getParent().getCLProgramRegistry().unregisterObject(this);
            }
            return iRelease;
        } catch (Throwable th) {
            if (!isValid()) {
                getParent().getCLProgramRegistry().unregisterObject(this);
            }
            throw th;
        }
    }
}
