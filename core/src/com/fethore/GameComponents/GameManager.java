package com.fethore.GameComponents;

import com.fethore.Characters.Player;
import com.fethore.screens.GameScreen;

/*
 * @author angel
 * 11/30/2018
 */
public class GameManager {

    GameScreen screen;
    public Player playerOne;
    public Player playerTwo;

    public CollisionManager collisionManager;
    public ScoreTracker scoreManager;
    public TerritoryManager territoryManager;
    public GameTimer timeManager;

    public GameManager(GameScreen Screen) {
        screen = Screen;
    }

    public void load(Player Player1, Player Player2) {
        scoreManager = new ScoreTracker(screen);
        
        territoryManager = new TerritoryManager(screen);
        territoryManager.score = scoreManager;
        
        timeManager = new GameTimer();
        timeManager.start();
        
        collisionManager = new CollisionManager(Player1, Player2);
        collisionManager.territory = territoryManager;
        collisionManager.score = scoreManager;
    }

    public void update() {
        collisionManager.update();
        territoryManager.update();
        scoreManager.update();
    }
}
