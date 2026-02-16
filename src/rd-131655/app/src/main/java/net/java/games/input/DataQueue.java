package net.java.games.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DataQueue.class */
final class DataQueue {
    private final Object[] elements;
    private int position;
    private int limit;
    static final boolean $assertionsDisabled;
    static Class class$net$java$games$input$DataQueue;

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    static {
        Class clsClass$;
        if (class$net$java$games$input$DataQueue == null) {
            clsClass$ = class$("net.java.games.input.DataQueue");
            class$net$java$games$input$DataQueue = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$DataQueue;
        }
        $assertionsDisabled = !clsClass$.desiredAssertionStatus();
    }

    public DataQueue(int size, Class element_type) {
        this.elements = new Object[size];
        for (int i = 0; i < this.elements.length; i++) {
            try {
                this.elements[i] = element_type.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException(e2);
            }
        }
        clear();
    }

    public final void clear() {
        this.position = 0;
        this.limit = this.elements.length;
    }

    public final int position() {
        return this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final Object get(int index) {
        if ($assertionsDisabled || index < this.limit) {
            return this.elements[index];
        }
        throw new AssertionError();
    }

    public final Object get() {
        if (!hasRemaining()) {
            return null;
        }
        int i = this.position;
        this.position = i + 1;
        return get(i);
    }

    public final void compact() {
        int index = 0;
        while (hasRemaining()) {
            swap(this.position, index);
            this.position++;
            index++;
        }
        this.position = index;
        this.limit = this.elements.length;
    }

    private final void swap(int index1, int index2) {
        Object temp = this.elements[index1];
        this.elements[index1] = this.elements[index2];
        this.elements[index2] = temp;
    }

    public final void flip() {
        this.limit = this.position;
        this.position = 0;
    }

    public final boolean hasRemaining() {
        return remaining() > 0;
    }

    public final int remaining() {
        return this.limit - this.position;
    }

    public final void position(int position) {
        this.position = position;
    }

    public final Object[] getElements() {
        return this.elements;
    }
}
