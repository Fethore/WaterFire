package com.fethore.GameComponents;

import Ophelia.Tile.ImageTile;
import Ophelia.Tools.Timer;
import com.badlogic.gdx.Gdx;
import com.fethore.screens.GameScreen;
import java.util.Random;

/*
 * @author angel
 * 11/30/2018
 */
public class TerritoryManager {

    GameScreen screen;
    ScoreTracker score;
    public ImageTile territory;
    Timer timer;
    Random rand;

    public TerritoryManager(GameScreen Screen) {
        screen = Screen;
        rand = new Random();
        territory = new ImageTile();
        territory.setBounds(screen.width / 2 - 32, screen.height / 2 - 32, 64, 64);
        territory.sprite = SpriteManager.getTerritory2();
        screen.setTile(territory, 0);
        loadTimer();
    }

    public void loadTimer() {
        timer = new Timer();
        timer.setEndSec(rand.nextInt(5) + 1);
        timer.start();
    }

    public void update() {
        updateColor();
        updateTimer();
    }
    
    void updateTimer() {
        if (timer.isDone()) {
            loadTimer();
            move();
            Gdx.app.log("T", "Moving " + timer.getNano());
        }
    }

    public void updateColor() {
        float p = score.percentage;
        if (p < .2) {
            territory.sprite = SpriteManager.getTerritory0();
        }
        if (p > .2 && p < .4) {
            territory.sprite = SpriteManager.getTerritory1();
        }
        if (p > .4 && p < .6) {
            territory.sprite = SpriteManager.getTerritory2();
        }
        if (p > .6 && p < .8) {
            territory.sprite = SpriteManager.getTerritory3();
        }
        if (p > .8 && p < 1) {
            territory.sprite = SpriteManager.getTerritory4();
        }
    }

    void move() {
        float X = rand.nextInt(Gdx.graphics.getWidth() - 64);
        float Y = rand.nextInt(Gdx.graphics.getHeight() - 64);
        territory.movement.moveTo(X, Y);
    }

}
