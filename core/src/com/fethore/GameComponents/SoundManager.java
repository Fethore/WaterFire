package com.fethore.GameComponents;

import Ophelia.Assets.Creators.SoundCreator;
import com.badlogic.gdx.audio.Sound;
import java.util.ArrayList;

/*
 * @author angel
 * 12/1/2018
 */
public class SoundManager {

    static ArrayList<Sound> list;

    public static void load() {
        list = new ArrayList<Sound>();
        add("GameSound/195912__acpascal__start-beep.wav");
    }

    static void add(String Location) {
        Sound sound = SoundCreator.create(Location);
        list.add(sound);
    }

    public static void start() {
        list.get(0).play();
    }
}
