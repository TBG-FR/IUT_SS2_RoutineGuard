/*
 *
 */

package com.routineguard.bracelet;

import com.routineguard.arduinolink.*;
import com.routineguard.sensors.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class Bracelet {
    
    /* ----- Classe "Bracelet" - Attributs ----- */
    private int idBracelet; // Necessary in case of multiple Bracelets (could be useful to recharge one while using another one)
    private boolean isCarried;
    private AccelerometerSensor motionSensor;
    private PulseSensor heartSensor;
    private ArduinoConnection braceletConnection;
    private Button greenButton;
    private Button redButton;
    
    /* ----- Classe "Bracelet" - Constructeurs ----- */
    public Bracelet(int id, boolean carried, String[] MAC_address) {
        
        try {
            braceletConnection = new ArduinoConnection(MAC_address);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bracelet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.idBracelet = id;
        this.isCarried = carried;
        
        motionSensor = new AccelerometerSensor(this);
        heartSensor = new PulseSensor(this);
        
        // Adding the two Buttons of the Bracelet.
        greenButton = new Button(this);
        redButton = new Button(this);
        
        checkAll();
        
} 
    
    /* ----- Classe "Bracelet" - Méthodes ----- */
    
    public void checkAll() {
        
        //if(isCarried == true) ???
        
        greenButton.getState();
        redButton.getState();
        motionSensor.refresh();
        heartSensor.refresh();
        
    }
    
    //public boolean help(){
    //public int reply(){
    //public int vibrationLevel(){
    
    /* ----- Classe "Bracelet" - Accesseurs ----- */
    
    public boolean getCarried() {
        
       return isCarried;
    }
    
    public ArduinoConnection getArduinoConnection() {
        
        return braceletConnection;
    }
    
    /* ----- Classe "Bracelet" - Mutateurs ----- */
    
}