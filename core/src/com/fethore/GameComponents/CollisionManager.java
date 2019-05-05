package com.fethore.GameComponents;

import com.badlogic.gdx.Gdx;
import com.fethore.Characters.Particle;
import com.fethore.Characters.Player;
import java.util.Random;

/**
 * @author angel 11/28/2018
 */
public class CollisionManager {

    Player p1;
    Player p2;
    Random rand;
    ItemSpawner items;
    EffectManager effects;
    TerritoryManager territory;
    ScoreTracker score;

    public CollisionManager(Player playerOne, Player playerTwo) {
        rand = new Random();
        p1 = playerOne;
        p2 = playerTwo;
    }

    public void update() {
        if (rand.nextBoolean()) {
            updateParticles(p1, p2);
            updateTerritory(p1, 1);
            keepOnScreen(p1);
        } else {
            updateParticles(p2, p1);
            updateTerritory(p2, 2);
            keepOnScreen(p2);
        }
    }

    void updateParticles(Player A, Player B) {
        for (Particle a : A.particles) {
            for (Particle b : B.particles) {
                if (a.collision.contact(b)) {
                    if (a.following && a.charged && !b.charged) {
                        b.following = true;
                        b.tossed = false;
                    }
                }
            }
        }
    }

    void keepOnScreen(Player player) {
        float X = player.queen.getCenterX();
        float Y = player.queen.getCenterY();
        float size = player.queen.getWidth();
        int border = 10;

        if (X < border) {
            player.queen.movement.moveRight(size);
        }
        if (X > Gdx.graphics.getWidth() - border) {
            player.queen.movement.moveLeft(size);
        }
        if (Y < border) {
            player.queen.movement.moveUp(size);
        }
        if (Y > Gdx.graphics.getHeight() - border * 4) {
            player.queen.movement.moveDown(size);
        }
    }

    void updateTerritory(Player player, int ScoreIndex) {
        for (Particle P : player.particles) {
            if (territory.territory.collision.contact(P) && !P.following) {
                if (ScoreIndex == 1) {
                    score.score1 += .01;
                }
                if (ScoreIndex == 2) {
                    score.score2 += .01;
                }
            }
        }
    }
}
