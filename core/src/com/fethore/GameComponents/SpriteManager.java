package com.fethore.GameComponents;

import Ophelia.Assets.SpriteList;
import com.badlogic.gdx.graphics.g2d.Sprite;

/*
 * @author angel 
 * 11/9/2018
 */
public class SpriteManager {

    private static SpriteList list;

    public static void load() {
        list = new SpriteList();
        list.load();
        list.add("sprites/player1/water.png");
        list.add("sprites/player1/fire.png");
        list.add("sprites/player2/water.png");
        list.add("sprites/player2/fire.png");
        list.add("sprites/controller/controller.png");
        list.add("sprites/controller/controller1.png");
        list.add("sprites/controller/controller2.png");
        list.add("background.png");
        list.add("background0.png");
        list.add("PlayActive.png");
        list.add("PlayInactive.png");
        list.add("scoreline.png");
        list.add("scoreTag.png");
        list.add("time.png");
        list.add("GameLogo.png");
        list.add("territory0.png");
        list.add("territory1.png");
        list.add("territory2.png");
        list.add("territory3.png");
        list.add("territory4.png");
    }

    public static Sprite getWater1() {
        return list.get(0);
    }

    public static Sprite getFire1() {
        return list.get(1);
    }

    public static Sprite getWater2() {
        return list.get(2);
    }

    public static Sprite getFire2() {
        return list.get(3);
    }

    public static Sprite getController0() {
        return list.get(4);
    }

    public static Sprite getController1() {
        return list.get(5);
    }

    public static Sprite getController2() {
        return list.get(6);
    }

    public static Sprite getBackground() {
        return list.get(7);
    }

    public static Sprite getBackground0() {
        return list.get(8);
    }

    public static Sprite getPlayActive() {
        return list.get(9);
    }

    public static Sprite getPlayInactive() {
        return list.get(10);
    }

    public static Sprite getLine() {
        return list.get(11);
    }

    public static Sprite getTag() {
        return list.get(12);
    }

    public static Sprite getTime() {
        return list.get(13);
    }

    public static Sprite getLogo() {
        return list.get(14);
    }

    public static Sprite getTerritory0() {
        return list.get(15);
    }

    public static Sprite getTerritory1() {
        return list.get(16);
    }

    public static Sprite getTerritory2() {
        return list.get(17);
    }

    public static Sprite getTerritory3() {
        return list.get(18);
    }

    public static Sprite getTerritory4() {
        return list.get(19);
    }

}
