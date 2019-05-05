package com.fethore.Characters;

import com.fethore.GamePads.GamePad;
import com.fethore.GameComponents.SpriteManager;
import com.fethore.screens.GameScreen;

/*
 * @author angel
 * 11/23/2018
 */
public class PlayerOne extends Player {

    private GamePad controller;

    public PlayerOne(GameScreen screen) {
        setScreen(screen);
        controller = new GamePad(0);
        fire = SpriteManager.getFire1();
        water = SpriteManager.getWater1();
    }

    @Override
    void updateControls() {
        controller.update();
        move();
    }

    void move() {
        moveQueen(controller.DPAD_DIRECTION);
        if (controller.BUTTON_A || controller.BUTTON_Y) {
            charge(true);
            setDistance(8);
            pickUp(10);
        } else {
            charge(false);
            setDistance(4);
        }

        if (controller.BUTTON_B || controller.BUTTON_X) {
            tossMultiple();
        }

    }

}
