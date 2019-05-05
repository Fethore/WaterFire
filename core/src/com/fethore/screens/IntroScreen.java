package com.fethore.screens;

import Ophelia.Tile.ImageTile;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.controllers.Controllers;
import com.fethore.GameComponents.GameMessages;
import com.fethore.GameComponents.SpriteManager;

/*
 * @author angel 
 * 11/29/2018
 */
public class IntroScreen extends TemplateScreen {

    ImageTile controller1;
    ImageTile controller2;
    ImageTile playButton;
    ImageTile background;
    ImageTile logo;
    ImageTile message;
    boolean play;
    int controllerAmount;

    public IntroScreen(Game game) {
        start(game);
        loadTiles();
        controllerAmount = Controllers.getControllers().size;
    }

    void loadTiles() {
        loadGUI();
        loadBackground();
        loadLogo();
        loadMessage();
    }
    
    void loadGUI(){
        float X1 = width / 4;
        float X2 = width - X1;
        float Y = height / 2;

        int CW = 64;
        int CH = CW / 2;

        controller1 = new ImageTile();
        controller2 = new ImageTile();
        playButton = new ImageTile();
        controller1.setBounds(X1 - CH, Y, CW, CH);
        controller2.setBounds(X2 - CH, Y, CW, CH);
        playButton.setBounds(width / 2 - CH, height / 4, CW, CH);

        controller1.sprite = SpriteManager.getController0();
        controller2.sprite = SpriteManager.getController0();
        playButton.sprite = SpriteManager.getPlayInactive();

        setTile(controller1, 2);
        setTile(controller2, 2);
        setTile(playButton, 2);
    }
    
    void loadBackground(){
        background = new ImageTile();
        background.setBounds(0, 0, width, height);
        background.sprite = SpriteManager.getBackground();
        setTile(background, 0);
    }
    
    void loadLogo(){
        logo = new ImageTile();
        logo.setBounds(width / 2 - 128, height / 2 + 128, 256, 128);
        logo.sprite = SpriteManager.getLogo();
        setTile(logo,1);
    }
    
    void loadMessage(){
        message = new ImageTile();
        message.setBounds(width / 2 - 256, 0, 512, 32);
        setTile(message,2);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        updatePlay();
        pressPlayButton();
        updateControllers();
        updatePlayButton();
        updateMessage();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    void updatePlay() {
        if (controllerAmount >= 2) {
            play = true;
        } else {
            play = false;
        }
    }

    void pressPlayButton() {
        float X = Gdx.input.getX();
        float Y = height - Gdx.input.getY();
        if (playButton.collision.contact(X, Y) && Gdx.input.isTouched() && play) {
            Gdx.app.log("PlayButton", "Pressed");
            changeScreen();
        }
    }

    void updatePlayButton() {
        if (play) {
            playButton.sprite = SpriteManager.getPlayActive();
        }
    }

    void updateControllers() {
        if (controllerAmount >= 1) {
            controller1.sprite = SpriteManager.getController1();
        }
        if (controllerAmount == 2) {
            controller2.sprite = SpriteManager.getController2();
        }
    }
    
    void updateMessage(){
        if(!play){
            message.sprite = GameMessages.getConnectControllers();
        }else{
            message.movement.moveDown(32);
        }
    }

    void changeScreen() {
        game.setScreen(new GameScreen(game));
    }
}
