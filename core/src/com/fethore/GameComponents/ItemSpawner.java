package com.fethore.GameComponents;

import com.fethore.Effects.Item;
import com.fethore.screens.GameScreen;
import java.util.ArrayList;

/*
 * @author angel
 * 11/30/2018
 */
public class ItemSpawner {
    
    public ArrayList<Item> list;
    GameScreen screen;
    GameTimer timer;
    
    public ItemSpawner(GameScreen Screen){
        screen = Screen;
        list = new ArrayList<Item>();
    }
    
    public void setGameTimer(GameTimer Timer){
        timer = Timer;
    }
    
    public void update(){
        if(list.size() == 0){
            spawnItem();
        }
    }
    
    public void spawnItem(){
        float X = screen.width / 2;
        float Y = screen.height / 2;
        Item item = new Item(screen);
        item.load(X, Y);
    }
    
    
}
