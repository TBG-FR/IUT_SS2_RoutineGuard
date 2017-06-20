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

public class PulseSensor extends Bracelet_Sensor {
    
    /* ----- Classe "PulseSensor" - Attributs ----- */
    private ArrayList<Double> list_BPM;
    private double average_BPM;
    
    // IBI stands for Interbeat Interval and could be useful to check the Heart Rate Variability (HRV)
    // It's availability could depend on the Sensor. [ https://en.wikipedia.org/wiki/Interbeat_interval ]
    // private ArrayList<Double> list_IBI;
    // private double average_IBI;
    
    /* ----- Classe "PulseSensor" - Constructeurs ----- */

    public PulseSensor(Bracelet bracelet) {
        
        super(bracelet);
                
        list_BPM = new ArrayList<>();
        average_BPM = 80;
               
    }
    
    /* ----- Classe "PulseSensor" - Méthodes ----- */
    public void refresh(){
        
        // [DEMO : Removed (No Arduino)]
        //double tempBPM = linkedBracelet.getArduinoConnection().getPulse();
        double tempBPM = Math.random()*100;
        double tempAvg = 0;
        
        list_BPM.add(tempBPM);
        
        for(int i=0; i<list_BPM.size(); i++)
            tempAvg = list_BPM.get(i);
        
        average_BPM = tempAvg / list_BPM.size();
    }
    
    public void clean() {
        
        for(int i=0; i<list_BPM.size()/2; i++) {
            list_BPM.remove(i);
        }
            
    }
    
    /* ----- Classe "PulseSensor" - Accesseurs ----- */
    public double getAverage() {
        
        //analyse_Accel();
        return average_BPM;
    }
    
    public double getLast() {
        
        //analyse_Accel();
        return list_BPM.get(list_BPM.size()-1);
    }
    
    /* ----- Classe "PulseSensor" - Mutateurs ----- */
    
    // [DEMO : Sensor Unexpected Value (No Arduino)]
    public void demo_PUSHBUTTON() {
        double tempBPM = 0;
        double tempAvg = 0;
        
        list_BPM.add(tempBPM);
        
        for(int i=0; i<list_BPM.size(); i++)
            tempAvg = list_BPM.get(i);
        
        average_BPM = tempAvg / list_BPM.size();
    }
    
}