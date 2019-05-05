package com.fethore.GameComponents;

import Ophelia.Tools.Timer;

/*
 * @author angel 
 * 11/30/2018
 */
public class GameTimer {

    Timer timer;

    public GameTimer() {
        timer = new Timer();
    }

    public void start() {
        timer = new Timer();
        timer.setEndSec(180); //180
        timer.start();
    }

    public boolean isDone() {
        return timer.isDone();
    }

    public float getPercentage() {
        return timer.getPercentage();
    }

}
