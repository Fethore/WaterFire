/**
 * *****************************************************************************
 * Copyright 2018 Angel Fernandez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************
 */
package Ophelia.Tile.Components;

import Ophelia.Tile.Tile;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import java.util.Random;

/**
 * Created by Angel Fernandez on 12/13/2017.
 */
public class Movement {

    private Tile tile;
    private Random rand;
    public float distance;
    public float speed = 1f;

    public Movement(Tile Tile) {
        this.tile = Tile;
        rand = new Random();
        distance = 1;
    }

    public void moveUp(float Distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(0, Distance);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveDown(float Distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(0, -Distance);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveLeft(float Distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(-Distance, 0);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveRight(float Distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(Distance, 0);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveTo(float X, float Y) {
        if (rand.nextBoolean()) {
            moveToX(X);
        } else {
            moveToY(Y);
        }
    }

    public void moveToX(float X) {
        if (rand.nextBoolean()) {
            if (X > tile.getX()) {
                distance = X - tile.getX();
                moveRight(distance);
            }
        } else {
            if (X < tile.getX()) {
                distance = tile.getX() - X;
                moveLeft(distance);
            }
        }
    }

    public void moveToY(float Y) {
        if (rand.nextBoolean()) {
            if (Y > tile.getY()) {
                distance = Y - tile.getY();
                moveUp(distance);
            }
        } else {
            if (Y < tile.getY()) {
                distance = tile.getY() - Y;
                moveDown(distance);
            }
        }
    }

    public void followTile(Tile Tile) {
        followTileX(Tile);
        followTileY(Tile);
    }

    public void followTileX(Tile Tile) {
        if (rand.nextBoolean()) {
            if (tile.getCenterX() > Tile.getCenterX()) {
                moveLeft(distance);
            }
        }else{
            if (tile.getCenterX() < Tile.getCenterX()) {
                moveRight(distance);
            }
        }
    }

    public void followTileY(Tile Tile) {
        if (tile.getCenterY() > Tile.getCenterY()) {
            moveDown(distance);
        }
        if (tile.getCenterY() < Tile.getCenterY()) {
            moveUp(distance);
        }
    }

    public void followXY(float X, float Y) {
        if (rand.nextBoolean()) {
            followX(X);
        } else {
            followY(Y);
        }
    }

    public void followX(float X) {
        if (tile.getCenterX() > X) {
            moveLeft(distance);
        }
        if (tile.getCenterX() < X) {
            moveRight(distance);
        }

    }

    public void followY(float Y) {
        if (tile.getCenterY() > Y) {
            moveDown(distance);
        }
        if (tile.getCenterY() < Y) {
            moveUp(distance);
        }
    }

    public void moveRandomly(float Distance) {
        int index = rand.nextInt(4);
        switch (index) {
            case 0:
                moveUp(Distance);
                break;
            case 1:
                moveDown(Distance);
                break;
            case 2:
                moveLeft(Distance);
                break;
            case 3:
                moveRight(Distance);
                break;
        }
    }
}
