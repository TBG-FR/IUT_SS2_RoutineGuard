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
    private int idBracelet;         // idBracelet & isCarried are necessary in case of multiple Bracelets
    //private boolean isCarried;    // (could be useful to recharge one while using another one)
    private final AccelerometerSensor motionSensor;
    private final PulseSensor heartSensor;
    private ArduinoConnection braceletConnection;
    private final Button greenButton;
    private final Button redButton;
    boolean waitingUser;
    
    /* ----- Classe "Bracelet" - Constructeurs ----- */
    public Bracelet(int id, boolean carried, String[] MAC_address) {
        
        try {
            braceletConnection = new ArduinoConnection(MAC_address);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bracelet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.idBracelet = id;
        waitingUser = false;
        
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
        buttonsBehavior();
        motionSensor.refresh();
        heartSensor.refresh();
        sensorsBehavior();
        
    }
    
    public void cleanAll() {
        
        //if(isCarried == true) ???
        motionSensor.clean();
        heartSensor.clean();
        
    }
    
    public void buttonsBehavior() {
        
        if(greenButton.getState() == ButtonState.ERROR || redButton.getState() == ButtonState.ERROR) {
            // ERREUR
        }
        
        if(waitingUser == false && redButton.getState() == ButtonState.PUSHED) {
            waitingUser = true;
            // CONFIRMATION ?
        }
        else if(waitingUser == true && redButton.getState() == ButtonState.PUSHED) {
            //REPLY RED
            // APPEL ASSISTANCE
        }
        else if(waitingUser == true && greenButton.getState() == ButtonState.PUSHED) {
            //REPLY GREEN
            // ACQUITTEMENT
        }
        
    }
    
    public void sensorsBehavior() {
        
        if(heartSensor.getLast() < 60 && heartSensor.getLast() > 100) {
            System.out.println("[!] Beats-per-Minutes Alert !"); // UNEXPECTED BPM
            waitingUser = true; // The User should now answer on the Bracelet
        }
        else {
            System.out.println("[I] Average BPM : "+heartSensor.getAverage());
        }
        
        
        if(motionSensor.getLast() > 50) {
            System.out.println("[!] Movement Alert ! (User felt down ?)"); // UNEXPECTED BPM
            waitingUser = true; // The User should now answer on the Bracelet
        }
        else {
            System.out.println("[I] Average Acceleration : "+motionSensor.getAverage());
        }
        
        
        
    }
    
    
    
    //public boolean help(){
    //public int reply(){
    //public int vibrationLevel(){
    
    /* ----- Classe "Bracelet" - Accesseurs ----- */
    
    //public boolean getCarried() { return isCarried; }
    
    public ArduinoConnection getArduinoConnection() {
        
        return braceletConnection;
    }
    
    public Button getGreenButton() {
        
        return greenButton;
    }
    
    public Button getRedButton() {
        
        return redButton;
    }
    
    public PulseSensor getPulseSensor () {
        
        return heartSensor;
    }
    
    public AccelerometerSensor getAccelSensor () {
        
        return motionSensor;
    }
    
    /* ----- Classe "Bracelet" - Mutateurs ----- */
    
}