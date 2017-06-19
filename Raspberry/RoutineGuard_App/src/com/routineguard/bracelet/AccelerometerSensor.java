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
        
        double tempAccel = linkedBracelet.getArduinoConnection().getAccel();
        double tempAvg = 0;
        
        list_Accel.add(tempAccel);
        
        for(int i=0; i<list_Accel.size(); i++)
            tempAvg = list_Accel.get(i);
        
        average_Accel = tempAvg / list_Accel.size();
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
    
}