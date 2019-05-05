package com.fethore.GamePads;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

/*
 * @author angel
 * 11/24/2018
 */
public class ControllerConfiguration extends ApplicationAdapter implements ControllerListener {

    String DPAD_DIRECTION = "center";
    boolean BUTTON_A;
    boolean BUTTON_B;
    boolean BUTTON_X;
    boolean BUTTON_Y;
    boolean MOVING;

    @Override
    public void connected(com.badlogic.gdx.controllers.Controller cntrlr) {
        Gdx.app.log("Controller", "connected");
    }

    @Override
    public void disconnected(com.badlogic.gdx.controllers.Controller cntrlr) {
        Gdx.app.log("Controller", "disconnected");
    }

    @Override
    public boolean buttonDown(com.badlogic.gdx.controllers.Controller cntrlr, int i) {
        Gdx.app.log("Controller", "ButtonDown" + ":" + i);
        setButton(i);
        return false;
    }

    void setButton(int Button) {
        switch (Button) {
            case 0:
                BUTTON_A = true;
                break;
            case 1:
                BUTTON_B = true;
                break;
            case 2:
                BUTTON_X = true;
                break;
            case 3:
                BUTTON_Y = true;
                break;
        }
    }

    @Override
    public boolean buttonUp(com.badlogic.gdx.controllers.Controller cntrlr, int i) {
        Gdx.app.log("Controller", "ButtonUp" + ":" + i);
        unsetButton(i);
        return false;
    }

    void unsetButton(int Button) {
        switch (Button) {
            case 0:
                BUTTON_A = false;
                break;
            case 1:
                BUTTON_B = false;
                break;
            case 2:
                BUTTON_X = false;
                break;
            case 3:
                BUTTON_Y = false;
                break;
            case 4:

        }
    }

    @Override
    public boolean axisMoved(com.badlogic.gdx.controllers.Controller cntrlr, int i, float f) {
        Gdx.app.log("Controller", "Axis" + ":" + i + ":" + f);
        updateAnalog(i, f);
        MOVING = true;
        return false;
    }

    void updateAnalog(int i, float f) {
        if (i == 2) {
            if (f == -1) {
                DPAD_DIRECTION = "north";
            }
            if (f == 1) {
                DPAD_DIRECTION = "south";
            }
        } else if (i == 3) {
            if (f == -1) {
                DPAD_DIRECTION = "west";
            }
            if (f == 1) {
                DPAD_DIRECTION = "east";
            }
        }
    }

    @Override
    public boolean povMoved(com.badlogic.gdx.controllers.Controller cntrlr, int i, PovDirection pd) {
        Gdx.app.log("Controller", "DPAD:" + ":" + pd);
        DPAD_DIRECTION = "" + pd;
        return false;
    }

    @Override
    public boolean xSliderMoved(com.badlogic.gdx.controllers.Controller cntrlr, int i, boolean bln) {
        Gdx.app.log("Controller", "SliderX" + ":" + i + ":" + bln);
        return false;
    }

    @Override
    public boolean ySliderMoved(com.badlogic.gdx.controllers.Controller cntrlr, int i, boolean bln) {
        Gdx.app.log("Controller", "SliderY" + ":" + i + ":" + bln);
        return false;
    }

    @Override
    public boolean accelerometerMoved(com.badlogic.gdx.controllers.Controller cntrlr, int i, Vector3 vctr) {
        Gdx.app.log("Controller", "Accelerometer" + ":" + i);
        return false;
    }
}
