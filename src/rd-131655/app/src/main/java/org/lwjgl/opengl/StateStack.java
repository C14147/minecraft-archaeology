package org.lwjgl.opengl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/StateStack.class */
class StateStack {
    private int[] state_stack = new int[1];
    private int stack_pos = 0;

    public int getState() {
        return this.state_stack[this.stack_pos];
    }

    public void pushState(int new_state) {
        int pos = this.stack_pos + 1;
        this.stack_pos = pos;
        if (pos == this.state_stack.length) {
            growState();
        }
        this.state_stack[pos] = new_state;
    }

    public int popState() {
        int[] iArr = this.state_stack;
        int i = this.stack_pos;
        this.stack_pos = i - 1;
        return iArr[i];
    }

    public void growState() {
        int[] new_state_stack = new int[this.state_stack.length + 1];
        System.arraycopy(this.state_stack, 0, new_state_stack, 0, this.state_stack.length);
        this.state_stack = new_state_stack;
    }

    StateStack(int initial_value) {
        this.state_stack[this.stack_pos] = initial_value;
    }
}
