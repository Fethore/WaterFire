package com.fethore.GameComponents;

import Ophelia.Assets.SpriteList;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author angel 11/30/2018
 */
public class GameMessages {

    private static SpriteList list;

    public static void load() {
        list = new SpriteList();
        list.load();
        list.add("sprites/messages/PlayerOneWon.png");
        list.add("sprites/messages/PlayerTwoWon.png");
        list.add("sprites/messages/ConnectControllers.png");
    }

    public static Sprite getPlayerOneWon() {
        return list.get(0);
    }

    public static Sprite getPlayerTwoWon() {
        return list.get(1);
    }

    public static Sprite getConnectControllers() {
        return list.get(2);
    }

}
