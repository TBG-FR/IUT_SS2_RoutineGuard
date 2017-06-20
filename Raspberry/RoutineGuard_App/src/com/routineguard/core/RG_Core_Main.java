/*
 *
 */

package com.routineguard.core;

import com.routineguard.arduinolink.ArduinoConnection;
import com.routineguard.bracelet.*;
import com.routineguard.gui.DisplayInterface;
import com.routineguard.sensors.*;
import java.util.Timer;
import java.util.TimerTask;
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
        
        Routine routine=new Routine();
        DisplayInterface myInterface = new DisplayInterface(routine);
        myInterface.setVisible(true);
//            System.out.println("PARTIE DETECTEUR DE MOUVEMENT");      
//            MotionSensor MS1=new MotionSensor(2);
//            MotionSensor MS2=new MotionSensor(3);
//            MotionSensor MS3=new MotionSensor(4);
//            MotionSensor MS4=new MotionSensor(5);
//            for(int i=0;i<1000;i++){
//                if(MS1.getData()==1){
//                    System.out.println("Mouvement chambre");
//                }
//                else{
//                    System.out.println("--------------");
//                }
//                if(MS2.getData()==1){
//                    System.out.println("Mouvement couloir");
//                }
//                else{
//                    System.out.println("--------------");
//                }
//                if(MS3.getData()==1){
//                    System.out.println("Mouvement sdb");
//                }
//                else{
//                    System.out.println("--------------");
//                }
//                if(MS4.getData()==1){
//                    System.out.println("Mouvement cuisine");
//                }
//                else{
//                    System.out.println("--------------");
//                }
//            }
//            
//            System.out.println("PARTIE APPUI BOUTON");
//
//            ContactSensor CS1=new ContactSensor(6);
//            ContactSensor CS2=new ContactSensor(7);
//            for(int i=0;i<1000;i++){
//                if(CS1.getData()==1){
//                    System.out.println("Bouton Cuisine");
//                }
//                if(CS2.getData()==1){
//                    System.out.println("Bouton WC");
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

        System.out.println("Tests Routine");
        
        House house=new House();
        Event wakeUp=new Event(0,3,0,1,EventType.AWAKENING,2);
        Event eat=new Event(1,1,2,1,EventType.LUNCH,1);
        Event sleep=new Event(2,2,0,1,EventType.SLEEPING,2);
        Event shower=new Event(-1,-1,1,0,EventType.SHOWER,2);
        
        routine.addEvent(sleep);
        routine.addEvent(wakeUp);
        routine.addEvent(eat);
        routine.addEvent(shower);
        
        Day currentDay=new Day(0,0,routine);
        
        /*currentDay.displayModel();
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
        
        Timer minuteur = new Timer();
        TimerTask tache = new TimerTask() {
            int iteration=0;
            public void run() {
                iteration++;
                house.checkCaptors(currentDay);
                if(iteration==100){
                    currentDay.timePass();
                    iteration=0;
                }
                
            }
        };
        minuteur.schedule(tache, 0, 100);
 
    
        /*System.out.println("Tests DB");

        DataBase db=new DataBase();
        db.connection(); */
        /*
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
        }*/
    
}
