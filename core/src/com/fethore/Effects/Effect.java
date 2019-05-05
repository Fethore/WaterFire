package com.fethore.Effects;

import Ophelia.Tile.ImageTile;
import Ophelia.Tools.Timer;
import com.fethore.Characters.Player;
import com.fethore.screens.TemplateScreen;

/**
 * @author angel 11/30/2018
 */
public class Effect {

    TemplateScreen screen;
    Timer timer;
    Player player;
    public boolean active;

    public void loadTimer(int Seconds) {
        timer = new Timer();
        timer.setEndSec(Seconds);
        timer.start();
    }
    
    public void setPlayer(Player player){
        player = player;
    }

    public void update() {
        updateTimer();
        //to overide
    }

    void updateTimer() {
        if (timer.isDone()) {
            active = false;
        }
    }

}
