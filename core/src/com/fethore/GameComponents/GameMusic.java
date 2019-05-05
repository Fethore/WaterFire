package com.fethore.GameComponents;

import Ophelia.Assets.Creators.MusicCreator;
import com.badlogic.gdx.audio.Music;

/*
 * @author angel
 * 12/5/2018
 */
public class GameMusic {
    
    public static Music song;
    
    public static void load(){
        Music song = MusicCreator.create("GameSounds/music.ogg");
    }
    
    public static void play(){
        song.play();
    }
    
    
}
