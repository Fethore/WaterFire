package com.fethore.GamePads;

import com.fethore.GamePads.ControllerConfiguration;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

/*
 * @author angel 
 * 11/23/2018
 */
public class GamePad {

    public String DPAD_DIRECTION = "center";
    public boolean BUTTON_A;
    public boolean BUTTON_B;
    public boolean BUTTON_X;
    public boolean BUTTON_Y;

    Controller controller;
    ControllerConfiguration configuration;

    public GamePad(int index) {
        configuration = new ControllerConfiguration();
        controller = setController(index);
        controller.addListener(configuration);
    }

    public Controller setController(int index) {
        int amount = Controllers.getControllers().size - 1;
        if (amount >= index) {
            return Controllers.getControllers().get(index);
        }
        return Controllers.getControllers().get(0);
    }

    public void update() {
        BUTTON_A = configuration.BUTTON_A;
        BUTTON_B = configuration.BUTTON_B;
        BUTTON_X = configuration.BUTTON_X;
        BUTTON_Y = configuration.BUTTON_Y;
        setDPAD(configuration.DPAD_DIRECTION);
    }
    
    void setDPAD(String Direction){
        if(!Direction.equals("center")){
            DPAD_DIRECTION = Direction;
        }
    }

}
