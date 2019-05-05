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

/**
 * Angel Fernandez 
 * 6/12/2018
 */
public class StatValue {
    
    int value;
    int maxValue;
    
    public void setValue(int Value){}
    public void setMaxValue(int Value){}
    
    public void addValue(int Value){}
    public void addMaxValue(int Value){}
    
    public void removeValue(int Value){}
    public void removeMaxValue(int Value){}
    
    public int getValue(){ return value; }
    public int getMaxValue(){ return maxValue; }
}
