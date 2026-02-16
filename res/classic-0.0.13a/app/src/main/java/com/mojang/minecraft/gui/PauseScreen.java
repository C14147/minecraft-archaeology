package com.mojang.minecraft.gui;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/gui/PauseScreen.class */
public class PauseScreen extends Screen {
    private List<Button> buttons = new ArrayList();

    @Override // com.mojang.minecraft.gui.Screen
    public void init() {
        this.buttons.add(new Button(0, (this.width / 2) - 100, (this.height / 3) + 0, 200, 20, "Generate new level"));
        this.buttons.add(new Button(1, (this.width / 2) - 100, (this.height / 3) + 32, 200, 20, "Save level.."));
        this.buttons.add(new Button(2, (this.width / 2) - 100, (this.height / 3) + 64, 200, 20, "Load level.."));
        this.buttons.add(new Button(3, (this.width / 2) - 100, (this.height / 3) + 96, 200, 20, "Back to game"));
    }

    @Override // com.mojang.minecraft.gui.Screen
    protected void keyPressed(char eventCharacter, int eventKey) {
    }

    @Override // com.mojang.minecraft.gui.Screen
    protected void mouseClicked(int x, int y, int buttonNum) {
        if (buttonNum == 0) {
            for (int i = 0; i < this.buttons.size(); i++) {
                Button button = this.buttons.get(i);
                if (x >= button.f25x && y >= button.f26y && x < button.f25x + button.f27w && y < button.f26y + button.f28h) {
                    buttonClicked(button);
                }
            }
        }
    }

    private void buttonClicked(Button button) {
        if (button.f29id == 0) {
            this.minecraft.generateNewLevel();
            this.minecraft.setScreen(null);
            this.minecraft.grabMouse();
        }
        if (button.f29id == 3) {
            this.minecraft.setScreen(null);
            this.minecraft.grabMouse();
        }
    }

    @Override // com.mojang.minecraft.gui.Screen
    public void render(int xm, int ym) {
        fillGradient(0, 0, this.width, this.height, 537199872, -1607454624);
        for (int i = 0; i < this.buttons.size(); i++) {
            Button button = this.buttons.get(i);
            fill(button.f25x - 1, button.f26y - 1, button.f25x + button.f27w + 1, button.f26y + button.f28h + 1, -16777216);
            if (xm >= button.f25x && ym >= button.f26y && xm < button.f25x + button.f27w && ym < button.f26y + button.f28h) {
                fill(button.f25x - 1, button.f26y - 1, button.f25x + button.f27w + 1, button.f26y + button.f28h + 1, -6250336);
                fill(button.f25x, button.f26y, button.f25x + button.f27w, button.f26y + button.f28h, -8355680);
                drawCenteredString(button.msg, button.f25x + (button.f27w / 2), button.f26y + ((button.f28h - 8) / 2), 16777120);
            } else {
                fill(button.f25x, button.f26y, button.f25x + button.f27w, button.f26y + button.f28h, -9408400);
                drawCenteredString(button.msg, button.f25x + (button.f27w / 2), button.f26y + ((button.f28h - 8) / 2), 14737632);
            }
        }
    }
}
