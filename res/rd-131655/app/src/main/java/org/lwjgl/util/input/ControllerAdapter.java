package org.lwjgl.util.input;

import org.lwjgl.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/input/ControllerAdapter.class */
public class ControllerAdapter implements Controller {
    @Override // org.lwjgl.input.Controller
    public String getName() {
        return "Dummy Controller";
    }

    @Override // org.lwjgl.input.Controller
    public int getIndex() {
        return 0;
    }

    @Override // org.lwjgl.input.Controller
    public int getButtonCount() {
        return 0;
    }

    @Override // org.lwjgl.input.Controller
    public String getButtonName(int index) {
        return "button n/a";
    }

    @Override // org.lwjgl.input.Controller
    public boolean isButtonPressed(int index) {
        return false;
    }

    @Override // org.lwjgl.input.Controller
    public void poll() {
    }

    @Override // org.lwjgl.input.Controller
    public float getPovX() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getPovY() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getDeadZone(int index) {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public void setDeadZone(int index, float zone) {
    }

    @Override // org.lwjgl.input.Controller
    public int getAxisCount() {
        return 0;
    }

    @Override // org.lwjgl.input.Controller
    public String getAxisName(int index) {
        return "axis n/a";
    }

    @Override // org.lwjgl.input.Controller
    public float getAxisValue(int index) {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getXAxisValue() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getXAxisDeadZone() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public void setXAxisDeadZone(float zone) {
    }

    @Override // org.lwjgl.input.Controller
    public float getYAxisValue() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getYAxisDeadZone() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public void setYAxisDeadZone(float zone) {
    }

    @Override // org.lwjgl.input.Controller
    public float getZAxisValue() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getZAxisDeadZone() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public void setZAxisDeadZone(float zone) {
    }

    @Override // org.lwjgl.input.Controller
    public float getRXAxisValue() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getRXAxisDeadZone() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public void setRXAxisDeadZone(float zone) {
    }

    @Override // org.lwjgl.input.Controller
    public float getRYAxisValue() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getRYAxisDeadZone() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public void setRYAxisDeadZone(float zone) {
    }

    @Override // org.lwjgl.input.Controller
    public float getRZAxisValue() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getRZAxisDeadZone() {
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public void setRZAxisDeadZone(float zone) {
    }

    @Override // org.lwjgl.input.Controller
    public int getRumblerCount() {
        return 0;
    }

    @Override // org.lwjgl.input.Controller
    public String getRumblerName(int index) {
        return "rumber n/a";
    }

    @Override // org.lwjgl.input.Controller
    public void setRumblerStrength(int index, float strength) {
    }
}
