package com.fethore.Effects;

import Ophelia.Tile.AnimationTile;
import com.fethore.screens.GameScreen;

/**
 * @author angel
 * 11/30/2018
 */
public class Item extends AnimationTile{
    
    GameScreen screen;
    
    public Item(GameScreen Screen){
        screen = Screen;
        setAnimation("ItemAnimation.png");
    }
    
    public void load(float X, float Y){
        setBounds(X, Y, 32, 32);
        screen.setTile(this, 1);
    }
    
}
