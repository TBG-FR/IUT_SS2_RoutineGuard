/*
 *
 */

package com.routineguard.bracelet;

import grovepi.Pin;
import java.util.ArrayList;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class AccelerometerSensor extends Bracelet_Sensor {
    
    /* ----- Classe "AccelerometerSensor" - Attributs ----- */
    private ArrayList<Double> list_Accel;
    private double average_Accel;
    
    /* ----- Classe "AccelerometerSensor" - Constructeurs ----- */

    public AccelerometerSensor(Bracelet bracelet) {
        
        super(bracelet);
                
        list_Accel = new ArrayList<>();
        average_Accel = 0;
        
    }
    
    /* ----- Classe "AccelerometerSensor" - Méthodes ----- */
    public void refresh(){
        
        // [DEMO : Removed (No Arduino)]
        //double tempAccel = linkedBracelet.getArduinoConnection().getAccel();
        double tempAccel = Math.random()*35;
        
        double tempAvg = 0;
        
        list_Accel.add(tempAccel);
        
        for(int i=0; i<list_Accel.size(); i++)
            tempAvg = list_Accel.get(i);
        
        average_Accel = tempAvg / list_Accel.size();
    }
    
    public void clean() {
        
        for(int i=0; i<list_Accel.size()/2; i++) {
            list_Accel.remove(i);
        }
            
    }
    
    /* ----- Classe "AccelerometerSensor" - Accesseurs ----- */ 
    public double getAverage() {
        
        //analyse_Accel();
        return average_Accel;
    }
    
    public double getLast() {
        
        //analyse_Accel();
        return list_Accel.get(list_Accel.size()-1);
    }
    
    /* ----- Classe "AccelerometerSensor" - Mutateurs ----- */
    
    // [DEMO : Sensor Unexpected Value (No Arduino)]
    public void demo_PUSHBUTTON() {
        double tempAccel = 75;
        
        double tempAvg = 0;
        
        list_Accel.add(tempAccel);
        
        for(int i=0; i<list_Accel.size(); i++)
            tempAvg = list_Accel.get(i);
        
        average_Accel = tempAvg / list_Accel.size();
    }
    
}