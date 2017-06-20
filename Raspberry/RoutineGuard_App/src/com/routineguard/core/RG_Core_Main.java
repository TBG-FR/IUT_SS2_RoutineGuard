/*
 *
 */

package com.routineguard.core;

import com.routineguard.arduinolink.ArduinoConnection;
import com.routineguard.bracelet.*;
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
//            BrightnessSensor BS=new BrightnessSensor(5);
//            System.out.println("Luminosité : "+BS.getData()+" %");
        
        
//        ArduinoLink AL1 = new ArduinoLink();
//        

        /*System.out.println("Tests Routine");
        Routine routine=new Routine();
        Event wakeUp=new Event(0,3,0,1,EventType.AWAKENING,2);
        Event eat=new Event(1,1,2,1,EventType.LUNCH,1);
        Event sleep=new Event(2,2,0,1,EventType.SLEEPING,2);
        Event shower=new Event(-1,-1,1,0,EventType.SHOWER,2);
        
        routine.addEvent(sleep);
        routine.addEvent(wakeUp);
        routine.addEvent(eat);
        routine.addEvent(shower);
        
        Day currentDay=new Day(0,0,routine);
        currentDay.displayModel();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.AWAKENING,-1);
        currentDay.timePass();
        currentDay.happen(EventType.SHOWER,0);
        currentDay.timePass();
        currentDay.happen(EventType.SHOWER,1);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.LUNCH,0);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.LUNCH,1);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.SLEEPING,-1);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.happen(EventType.AWAKENING,-1);
        currentDay.happen(EventType.SLEEPING,-1);
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();
        currentDay.timePass();*/

        
    
        /*System.out.println("Tests DB");

        DataBase db=new DataBase();
        db.connection(); */
        
        String[] MAC = { "AA11BB22CC33" };
        
        Bracelet B1 = new Bracelet(0,MAC);
        
        DisplayInterface D1 = new DisplayInterface();
        D1.addBracelet(B1);
        
        
        for(int j =0; j<5; j++) {
        for(int i=0; i<150; i++) {
        B1.checkAll();
        B1.checkAll();
        B1.checkAll();
        B1.checkAll();
        B1.checkAll();
        B1.checkAll();
        B1.checkAll();
        B1.checkAll();
        }
        B1.cleanAll();
        }
        }
    
}
