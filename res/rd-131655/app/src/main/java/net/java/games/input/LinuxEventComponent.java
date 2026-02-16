package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxEventComponent.class */
final class LinuxEventComponent {
    private final LinuxEventDevice device;
    private final Component.Identifier identifier;
    private final Controller.Type button_trait;
    private final boolean is_relative;
    private final LinuxAxisDescriptor descriptor;
    private final int min;
    private final int max;
    private final int flat;
    static final boolean $assertionsDisabled;
    static Class class$net$java$games$input$LinuxEventComponent;

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    static {
        Class clsClass$;
        if (class$net$java$games$input$LinuxEventComponent == null) {
            clsClass$ = class$("net.java.games.input.LinuxEventComponent");
            class$net$java$games$input$LinuxEventComponent = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$LinuxEventComponent;
        }
        $assertionsDisabled = !clsClass$.desiredAssertionStatus();
    }

    public LinuxEventComponent(LinuxEventDevice device, Component.Identifier identifier, boolean is_relative, int native_type, int native_code) throws IOException {
        this.device = device;
        this.identifier = identifier;
        if (native_type == 1) {
            this.button_trait = LinuxNativeTypesMap.guessButtonTrait(native_code);
        } else {
            this.button_trait = Controller.Type.UNKNOWN;
        }
        this.is_relative = is_relative;
        this.descriptor = new LinuxAxisDescriptor();
        this.descriptor.set(native_type, native_code);
        if (native_type == 3) {
            LinuxAbsInfo abs_info = new LinuxAbsInfo();
            getAbsInfo(abs_info);
            this.min = abs_info.getMin();
            this.max = abs_info.getMax();
            this.flat = abs_info.getFlat();
            return;
        }
        this.min = Integer.MIN_VALUE;
        this.max = IDirectInputDevice.DIPROPRANGE_NOMAX;
        this.flat = 0;
    }

    public final LinuxEventDevice getDevice() {
        return this.device;
    }

    public final void getAbsInfo(LinuxAbsInfo abs_info) throws IOException {
        if (!$assertionsDisabled && this.descriptor.getType() != 3) {
            throw new AssertionError();
        }
        this.device.getAbsInfo(this.descriptor.getCode(), abs_info);
    }

    public final Controller.Type getButtonTrait() {
        return this.button_trait;
    }

    public final Component.Identifier getIdentifier() {
        return this.identifier;
    }

    public final LinuxAxisDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final boolean isRelative() {
        return this.is_relative;
    }

    public final boolean isAnalog() {
        return (this.identifier instanceof Component.Identifier.Axis) && this.identifier != Component.Identifier.Axis.POV;
    }

    final float convertValue(float value) {
        if ((this.identifier instanceof Component.Identifier.Axis) && !this.is_relative) {
            if (this.min == this.max) {
                return 0.0f;
            }
            if (value > this.max) {
                value = this.max;
            } else if (value < this.min) {
                value = this.min;
            }
            return ((2.0f * (value - this.min)) / (this.max - this.min)) - 1.0f;
        }
        return value;
    }

    final float getDeadZone() {
        return this.flat / (2.0f * (this.max - this.min));
    }
}
