package com.fethore.waterfire.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fethore.waterfire.Main;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new Main(), config);
        config.height = 500;
        config.width = 630;
        config.fullscreen = true;
    }
}
