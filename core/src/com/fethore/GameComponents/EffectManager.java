package com.fethore.GameComponents;

import com.fethore.Characters.Player;
import com.fethore.Effects.Effect;
import com.fethore.Effects.ReverseControls;
import com.fethore.screens.GameScreen;
import java.util.ArrayList;

/*
 * @author angel 
 * 11/30/2018
 */
public class EffectManager {

    GameScreen screen;
    ArrayList<Effect> effects;

    public EffectManager(GameScreen Screen) {
        screen = Screen;
        effects = new ArrayList<Effect>();
    }

    public void genEffect(Player player){
        Effect e = new ReverseControls(player);
        e.loadTimer(10);
        addEffect(e);
    }
    
    public void addEffect(Effect effect) {
        effects.add(effect);
    }

    public void update() {
        if (effects.size() > 0) {
            updateEffects();
        }
    }

    void updateEffects() {
        for (Effect E : effects) {
            if (E.active) {
                E.update();
            }
        }
    }

    void removeEffects() {
        for (Effect E : effects) {
            if (!E.active) {
                effects.remove(E);
            }
        }
    }

}
