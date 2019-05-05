package com.fethore.screens;

import Ophelia.Tile.ImageTile;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.fethore.Characters.PlayerOne;
import com.fethore.Characters.PlayerTwo;
import com.fethore.GameComponents.GameManager;
import com.fethore.GameComponents.GameMusic;
import com.fethore.GameComponents.SpriteManager;

/*
 * @author angel
 * 2/13/2018
 */
public class GameScreen extends TemplateScreen {

    PlayerOne playerOne;
    PlayerTwo playerTwo;
    ImageTile background;
    ImageTile timeBar;
    ImageTile scoreTag;
    ImageTile scoreLine;

    GameManager gameManager;

    public GameScreen(Game game) {
        start(game);
        loadPlayers();
        loadParticles(500);
        loadBackground();
        loadGameManager();
        loadGUI();
    }

    void loadPlayers() {
        playerOne = new PlayerOne(this);
        playerTwo = new PlayerTwo(this);

        float X1 = Gdx.graphics.getWidth() / 4;
        float X2 = Gdx.graphics.getWidth() - X1;
        float Y = Gdx.graphics.getHeight() / 2;

        playerOne.load(X1, Y, 1);
        playerTwo.load(X2, Y, 1);
    }

    void loadGUI() {
        timeBar = new ImageTile();
        timeBar.setBounds(0, height - 10, width, 10);
        setTile(timeBar, 3);
        timeBar.sprite = SpriteManager.getTime();

        scoreLine = new ImageTile();
        scoreLine.setBounds(0, height - 20, width, 10);
        setTile(scoreLine, 3);
        scoreLine.sprite = SpriteManager.getLine();

        scoreTag = new ImageTile();
        scoreTag.setBounds(width / 2 - 10, height - 30, 20, 20);
        setTile(scoreTag, 3);
        scoreTag.sprite = SpriteManager.getTag();
    }

    void loadGameManager() {
        gameManager = new GameManager(this);
        gameManager.load(playerOne, playerTwo);
    }

    void loadBackground() {
        background = new ImageTile();
        background.setBounds(0, 0, width, height);
        background.sprite = SpriteManager.getBackground0();
        setTile(background, 0);
    }

    void loadParticles(int Amount) {
        for (int i = 0; i < Amount; i++) {
            playerOne.create(1);
            playerTwo.create(1);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    void updateTag() {
        float position = gameManager.scoreManager.getPosition();
        scoreTag.setX(position - 10);
    }

    void updateTime() {
        float percentage = gameManager.timeManager.getPercentage();
        float size = width - width * percentage;
        timeBar.setWidth(size);
    }

    void update() {
        if (!gameManager.timeManager.isDone()) {
            playerOne.update();
            playerTwo.update();
            gameManager.update();
            updateTag();
            updateTime();
        } else {
            int WinnerIndex = gameManager.scoreManager.getWinner();
            game.setScreen(new EndScreen(game, WinnerIndex));
        }
    }
}
