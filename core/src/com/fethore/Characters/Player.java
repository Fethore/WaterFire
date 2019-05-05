package com.fethore.Characters;

import Ophelia.Tile.ImageTile;
import Ophelia.Tools.Timer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.fethore.screens.GameScreen;
import java.util.ArrayList;
import java.util.Random;

/*
 * @author angel 
 * 11/9/2018
 */
public class Player {

    public ImageTile queen;
    public boolean charged;
    public int direction;
    float speed;
    float distance;
    public ArrayList<Particle> particles;
    Timer timer;
    Random rand;
    GameScreen screen;
    public float range = 100;
    public float capacity = 500;
    public int dropRate = 10;
    public Sprite water;
    public Sprite fire;
    public boolean reversed = false;

    public void setScreen(GameScreen Screen) {
        screen = Screen;
    }

    public void load(float X, float Y, int Amount) {
        loadQueen(X, Y);
        rand = new Random();
        particles = new ArrayList<Particle>();
        setMovementTimer();
        create(Amount);
    }

    private void loadQueen(float X, float Y) {
        queen = new ImageTile();
        screen.setTile(queen, 1);
        queen.setBounds(X, Y, 16, 16);
    }

    public void printAll() {
        Gdx.app.log("Charged", "" + charged);
        Gdx.app.log("Direction", "" + direction);
        Gdx.app.log("Speed", "" + speed);
        Gdx.app.log("Distance", "" + distance);
        Gdx.app.log("Followers", "" + getFollowers());
        Gdx.app.log("Particles", "" + getSize());
        Gdx.app.log("Timer", "" + timer.getNano());
        Gdx.app.log("Range", "" + range);
        Gdx.app.log("Capacity", "" + capacity);
    }

    public void update() {
        updateMovement();
        updateSpeed();
        updatePosition();
    }

    private void updateParticles() {
        for (Particle P : particles) {
            P.update();
        }
    }

    private void updatePosition() {
        for (Particle P : particles) {
            if (P.following) {
                P.movement.followXY(queen.getCenterX(), queen.getCenterY());
            }
            if (P.tossed) {
                P.movement.followXY(P.tempX, P.tempY);
            }
            P.movement.moveRandomly(1);
        }
    }

    private void updateMovement() {
        if (timer.isDone()) {
            updateControls();
            updateParticles();
            timer.reset();
        }
    }

    private void setMovementTimer() {
        timer = new Timer();
        timer.setEndMilli(1000);
        timer.start();
    }

    private void updateSpeed() {
        queen.movement.speed = speed;
    }

    public void moveQueen(String Direction) {
            if (reversed) {
                moveReversed(Direction);
            } else {
                moveNormal(Direction);
            }
        
    }

    public void moveReversed(String Direction) {
        if (Direction.equals("north")) {
            moveDown();
        }
        if (Direction.equals("south")) {
            moveUp();
        }
        if (Direction.equals("west")) {
            moveRight();
        }
        if (Direction.equals("east")) {
            moveLeft();
        }
    }

    public void moveNormal(String Direction) {
        if (Direction.equals("north")) {
            moveUp();
        }
        if (Direction.equals("south")) {
            moveDown();
        }
        if (Direction.equals("west")) {
            moveLeft();
        }
        if (Direction.equals("east")) {
            moveRight();
        }
    }

    public void moveUp() {
        Gdx.app.log("PlayerClass", "MoveUp");
        queen.movement.moveUp(distance);
        direction = 0;
    }

    public void moveDown() {
        Gdx.app.log("PlayerClass", "MoveDown");
        queen.movement.moveDown(distance);
        direction = 1;
    }

    public void moveLeft() {
        Gdx.app.log("PlayerClass", "MoveLeft");
        queen.movement.moveLeft(distance);
        direction = 2;
    }

    public void moveRight() {
        Gdx.app.log("PlayerClass", "MoveRight");
        queen.movement.moveRight(distance);
        direction = 3;
    }

    void updateControls() {
        //to override
    }

    private Particle loadParticle() {
        Particle p = new Particle(queen.getCenterX(), queen.getCenterY());
        p.following = true;
        p.loadSprites(water, fire);
        screen.setTile(p, 2);
        return p;
    }

    public void create(int Amount) {
        if (particles.size() < capacity) {
            for (int i = 0; i < Amount; i++) {
                particles.add(loadParticle());
            }
        }
    }

    private void remove(int Amount) {
        for (int i = 0; i <= Amount; i++) {
            if (particles.size() > 30) {
                int index = rand.nextInt(particles.size());
                ImageTile particle = particles.get(index);
                particles.remove(particle);
                particle.remove();
            }
        }
    }

    public void charge(boolean State) {
        charged = State;
        for (Particle P : particles) {
            if (P.following) {
                P.setCharged(State);
            }
        }
    }

    private Particle randomParticle() {
        int size = getSize();
        int index = rand.nextInt(size);
        return particles.get(index);
    }

    public void drop() {
        if (!charged) {
            for (int i = 0; i <= dropRate; i++) {
                randomParticle().following = false;
            }
        }
    }

    public void pickUp(int Amount) {
        for (int i = 0; i <= Amount; i++) {
            Particle p = randomParticle();
            p.following = true;
            p.tossed = false;
        }
    }

    public void tossMultiple() {
        if (!charged) {
            for (int i = 0; i <= dropRate; i++) {
                toss();
            }
        }
    }

    private void toss() {
        float x = queen.getCenterX();
        float y = queen.getCenterY();
        Particle p = randomParticle();
        if (p.following) {
            switch (direction) {
                case 0:
                    p.tempY = y + range;
                    p.tempX = x;
                    p.tossed = true;
                    p.following = false;
                    break;
                case 1:
                    p.tempY = y - range;
                    p.tempX = x;
                    p.tossed = true;
                    p.following = false;
                    break;
                case 2:
                    p.tempX = x - range;
                    p.tempY = y;
                    p.tossed = true;
                    p.following = false;
                    break;
                case 3:
                    p.tempX = x + range;
                    p.tempY = y;
                    p.tossed = true;
                    p.following = false;
                    break;
            }
        }
    }

    public void setDistance(int Amount) {
        if (getSize() > 30) {
            distance = Amount - getFollowers() * .004f;
        } else {
            distance = Amount;
        }
    }

    public int getSize() {
        return particles.size();
    }

    public int getFollowers() {
        int count = 0;
        for (Particle P : particles) {
            if (P.following) {
                count++;
            }
        }
        return count;
    }
}
