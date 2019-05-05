package com.fethore.waterfire;

import com.fethore.GameComponents.SpriteManager;
import com.badlogic.gdx.Game;
import com.fethore.GameComponents.GameMessages;
import com.fethore.GameComponents.GameMusic;
import com.fethore.screens.IntroScreen;

public class Main extends Game {

    @Override
    public void create() {
        SpriteManager.load();
        GameMessages.load();
        GameMusic.load();
        setScreen(new IntroScreen(this));
    }

    @Override
    public void dispose() {

    }
}
