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
package Ophelia.Entities.Components;

import java.util.ArrayList;

/**
 * Angel Fernandez 
 * 6/12/2018
 */
public class StatList {
    
    ArrayList<StatValue> game;
    
    StatList(){
        game = new ArrayList<StatValue>();
    }
    
    public void newInt(String Name, int Value, int MaxValue){
        StatValue stat = new StatValue();
        game.add(stat);
    }
    
}
