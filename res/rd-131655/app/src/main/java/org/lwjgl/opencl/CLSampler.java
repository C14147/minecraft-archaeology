package org.lwjgl.opencl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLSampler.class */
public final class CLSampler extends CLObjectChild<CLContext> {
    private static final InfoUtil<CLSampler> util = CLPlatform.getInfoUtilInstance(CLSampler.class, "CL_SAMPLER_UTIL");

    CLSampler(long pointer, CLContext context) {
        super(pointer, context);
        if (isValid()) {
            context.getCLSamplerRegistry().registerObject(this);
        }
    }

    public int getInfoInt(int param_name) {
        return util.getInfoInt(this, param_name);
    }

    public long getInfoLong(int param_name) {
        return util.getInfoLong(this, param_name);
    }

    @Override // org.lwjgl.opencl.CLObjectRetainable
    int release() {
        try {
            int iRelease = super.release();
            if (!isValid()) {
                getParent().getCLSamplerRegistry().unregisterObject(this);
            }
            return iRelease;
        } catch (Throwable th) {
            if (!isValid()) {
                getParent().getCLSamplerRegistry().unregisterObject(this);
            }
            throw th;
        }
    }
}
