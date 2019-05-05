package com.fethore.screens;

import Ophelia.Tile.ImageTile;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.fethore.GameComponents.GameMessages;
import com.fethore.GameComponents.SpriteManager;

/*
 * @author angel 
 * 11/30/2018
 */
public class EndScreen extends TemplateScreen {

    ImageTile winner;
    ImageTile playButton;
    ImageTile background;

    EndScreen(Game game, int WinnerIndex) {
        start(game);
        setWinner(WinnerIndex);
        loadPlayButton();
        loadBackground();
    }

    void setWinner(int WinnerIndex) {
        float X = width / 2 - 256;
        float Y = height / 2 + 64;

        winner = new ImageTile();
        winner.setBounds(X, Y, 512, 32);

        if (WinnerIndex == 1) {
            winner.sprite = GameMessages.getPlayerOneWon();
        }
        if (WinnerIndex == 2) {
            winner.sprite = GameMessages.getPlayerTwoWon();
        }
        setTile(winner, 1);
    }

    void loadPlayButton() {
        int CW = 64;
        int CH = CW / 2;
        playButton = new ImageTile();
        playButton.setBounds(width / 2 - CH, height / 4, CW, CH);
        playButton.sprite = SpriteManager.getPlayActive();
        setTile(playButton, 2);
    }

    void loadBackground() {
        background = new ImageTile();
        background.setBounds(0, 0, width, height);
        background.sprite = SpriteManager.getBackground();
        setTile(background, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pressPlayButton();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    void pressPlayButton() {
        float X = Gdx.input.getX();
        float Y = height - Gdx.input.getY();
        if (playButton.collision.contact(X, Y) && Gdx.input.isTouched()) {
            Gdx.app.log("PlayButton", "Pressed");
            game.setScreen(new GameScreen(game));
        }
    }

}