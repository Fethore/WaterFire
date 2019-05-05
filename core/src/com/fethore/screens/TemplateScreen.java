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
package com.fethore.screens;

import Ophelia.Screen.SuperScreen;
import com.badlogic.gdx.Game;

/*
 * Angel Fernandez
 * 1/28/2018
 */
public class TemplateScreen extends SuperScreen {

    @Override
    public void start(Game game) {
        super.start(game);
    }

    public void toMainScreen() {
        game.setScreen(new GameScreen(game));
        dispose();
    }

}
