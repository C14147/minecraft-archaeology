package net.java.games.input;

import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxJoystickPOV.class */
public class LinuxJoystickPOV extends LinuxJoystickAxis {
    private LinuxJoystickAxis hatX;
    private LinuxJoystickAxis hatY;

    LinuxJoystickPOV(Component.Identifier.Axis id, LinuxJoystickAxis hatX, LinuxJoystickAxis hatY) {
        super(id, false);
        this.hatX = hatX;
        this.hatY = hatY;
    }

    protected LinuxJoystickAxis getXAxis() {
        return this.hatX;
    }

    protected LinuxJoystickAxis getYAxis() {
        return this.hatY;
    }

    protected void updateValue() {
        float last_x = this.hatX.getPollData();
        float last_y = this.hatY.getPollData();
        resetHasPolled();
        if (last_x == -1.0f && last_y == -1.0f) {
            setValue(0.125f);
            return;
        }
        if (last_x == -1.0f && last_y == 0.0f) {
            setValue(1.0f);
            return;
        }
        if (last_x == -1.0f && last_y == 1.0f) {
            setValue(0.875f);
            return;
        }
        if (last_x == 0.0f && last_y == -1.0f) {
            setValue(0.25f);
            return;
        }
        if (last_x == 0.0f && last_y == 0.0f) {
            setValue(0.0f);
            return;
        }
        if (last_x == 0.0f && last_y == 1.0f) {
            setValue(0.75f);
            return;
        }
        if (last_x == 1.0f && last_y == -1.0f) {
            setValue(0.375f);
            return;
        }
        if (last_x == 1.0f && last_y == 0.0f) {
            setValue(0.5f);
        } else if (last_x == 1.0f && last_y == 1.0f) {
            setValue(0.625f);
        } else {
            LinuxEnvironmentPlugin.logln(new StringBuffer().append("Unknown values x = ").append(last_x).append(" | y = ").append(last_y).toString());
            setValue(0.0f);
        }
    }
}
