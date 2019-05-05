package com.fethore.GameComponents;

import com.fethore.screens.GameScreen;

/*
 * @author angel 
 * 11/30/2018
 */
public class ScoreTracker {

    GameScreen screen;
    float score1 = 100;
    float score2 = 100;
    float total;
    float percentage;
    float position;

    public ScoreTracker(GameScreen Screen) {
        screen = Screen;
    }

    public void update() {
        total = score1 + score2;
        percentage = score2 / total;
        position = screen.width * percentage;
    }

    public float getPosition() {
        return position;
    }

    public int getWinner() {
        if (score1 > score2) {
            return 1;
        }
        return 2;
    }
}
