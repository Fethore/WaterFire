package com.fethore.Characters;

import Ophelia.Tile.ImageTile;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.fethore.GameComponents.SpriteManager;

/**
 * @author angel
 */
public class Particle extends ImageTile {

    float speed;
    float distance;
    float size;
    public boolean charged;
    private Sprite water;
    private Sprite fire;
    private Sprite currentImage;
    public boolean following;
    public boolean tossed;
    public float tempX;
    public float tempY;

    public Particle(float X, float Y) {
        setBounds(X, Y, size, size);
    }

    public void update() {
        updateMode();
        updateSize();
    }

    private void updateSize() {
        float x = getX();
        float y = getY();
        setBounds(x, y, size, size);
    }

    private void updateMode() {
        if (charged && following) {
            setSprite(fire);
            setSize(5);
            setDistance(20);
            setSpeed(.000001f);
        } else {
            setSprite(water);
            setSize(8);
            setDistance(10);
            setSpeed(.05f);
        }
    }

    private void setDistance(float Amount) {
        movement.distance = Amount;
    }

    private void setSpeed(float Amount) {
        movement.speed = Amount;
    }

    public void setCharged(boolean State) {
        charged = State;
    }

    private void setSprite(Sprite newSprite) {
        if (currentImage != sprite) {
            sprite = newSprite;
        }
    }

    public void loadSprites(Sprite Water, Sprite Fire) {
        SpriteManager sprites = new SpriteManager();
        water = Water;
        fire = Fire;
    }

    public void setSize(float Size) {
        if (Size != size) {
            size = Size;
            updateSize();
        }
    }

}
