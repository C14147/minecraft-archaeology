package org.lwjgl.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/input/Controller.class */
public interface Controller {
    String getName();

    int getIndex();

    int getButtonCount();

    String getButtonName(int i);

    boolean isButtonPressed(int i);

    void poll();

    float getPovX();

    float getPovY();

    float getDeadZone(int i);

    void setDeadZone(int i, float f);

    int getAxisCount();

    String getAxisName(int i);

    float getAxisValue(int i);

    float getXAxisValue();

    float getXAxisDeadZone();

    void setXAxisDeadZone(float f);

    float getYAxisValue();

    float getYAxisDeadZone();

    void setYAxisDeadZone(float f);

    float getZAxisValue();

    float getZAxisDeadZone();

    void setZAxisDeadZone(float f);

    float getRXAxisValue();

    float getRXAxisDeadZone();

    void setRXAxisDeadZone(float f);

    float getRYAxisValue();

    float getRYAxisDeadZone();

    void setRYAxisDeadZone(float f);

    float getRZAxisValue();

    float getRZAxisDeadZone();

    void setRZAxisDeadZone(float f);

    int getRumblerCount();

    String getRumblerName(int i);

    void setRumblerStrength(int i, float f);
}
