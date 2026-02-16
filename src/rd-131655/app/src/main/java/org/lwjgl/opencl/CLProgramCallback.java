package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLProgramCallback.class */
abstract class CLProgramCallback extends PointerWrapperAbstract {
    private CLContext context;

    protected abstract void handleMessage(CLProgram cLProgram);

    protected CLProgramCallback() {
        super(CallbackUtil.getProgramCallback());
    }

    final void setContext(CLContext context) {
        this.context = context;
    }

    private void handleMessage(long program_address) {
        handleMessage(this.context.getCLProgram(program_address));
    }
}
