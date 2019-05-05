package com.fethore.Effects;

import com.fethore.Characters.Player;

/**
 * @author angel 11/30/2018
 */
public class ReverseControls extends Effect {

    public ReverseControls(Player player) {
        setPlayer(player);
    }

    @Override
    public void update() {
        super.update();
        if(timer.isDone()){
            player.reversed = false;
        }else{
            player.reversed = true;
        }
    }

}
