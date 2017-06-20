/*
 *
 */

package com.routineguard.core;

import com.routineguard.arduinolink.*;
import com.routineguard.gui.DisplayInterface;
import com.routineguard.sensors.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class RG_Core_Main { /* MAIN */
     
    public static void main(String[] args) {
       
        Routine routine = new Routine();
        DisplayInterface myInterface = new DisplayInterface(routine);
        myInterface.setVisible(true);
//            System.out.println("PARTIE DETECTEUR DE MOUVEMENT");      
//            MotionSensor MS1=new MotionSensor(7);
//            for(int i=0;i<1000;i++){
//                if(MS1.getData()==1){
//                    System.out.println("Mouvement detecté");
//                }
//                else{
//                    System.out.println("--------------");
//                }
//            }
//            
//            System.out.println("PARTIE APPUI BOUTON");
//
//            ContactSensor CS1=new ContactSensor(3);
//            for(int i=0;i<1000;i++){
//                if(CS1.getData()==1){
//                    System.out.println("Bouton Appuyé");
//                }
//                else{
//                    System.out.println("--------------");
//                }
//            }
//            
//            TemperatureSensor T1 = new TemperatureSensor(8);
//            HumiditySensor H1=new HumiditySensor(8);
//            System.out.println("Température : "+T1.getData()+" °C");
//            System.out.println("Humidité : "+H1.getData()+" %");
//            
//            BrightnessSensor BS=new BrightnessSensor(8);
//            System.out.println("Luminosité : "+BS.getData()+" %");
        
        
//        ArduinoLink AL1 = new ArduinoLink();
//        

        /*System.out.println("Tests Routine");
        Routine routine=new Routine();
        Event wakeUp=new Event(0,3,0,1,EventType.AWAKENING,2);
        Event eat=new Event(1,1,2,1,EventType.LUNCH,1);
        Event sleep=new Event(2,2,0,1,EventType.SLEEPING,2);
        
        routine.addEvent(sleep);
        routine.addEvent(wakeUp);
        routine.addEvent(eat);
        
        Day currentDay=new Day(0,0,routine);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.AWAKENING);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.LUNCH);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.SLEEPING);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.AWAKENING);
        currentDay.happen(EventType.SLEEPING);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();*/

        
    
        /*System.out.println("Tests DB");

        DataBase db=new DataBase();
        db.connection(); */
            
        }
    
}
