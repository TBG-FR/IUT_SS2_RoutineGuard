/*
 *
 */

package com.routineguard.core;

import com.routineguard.sensors.ContactSensor;
import com.routineguard.sensors.MotionSensor;
import java.util.logging.Logger;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */



public class Room {
    
    /* ----- Classe "Room" - Attributs ----- */
    private boolean userPresence;
    private RoomType roomType;
    private MotionSensor motionSensor;
    private ContactSensor contactSensor;
    
    /* ----- Classe "Room" - Constructeurs ----- */
    
    public Room(RoomType roomType){
        this.roomType=roomType;
        userPresence=false;
    }
    
    /* ----- Classe "Room" - Méthodes ----- */
    public int presenceDetection(){
        
        
        
        return 0; /* TMP */ 
    }    
    
    public void addMotionSensor(int i){
        motionSensor=new MotionSensor(i);
    }
    
    public void addContactSensor(int i){
        contactSensor=new ContactSensor(i);
    }
    /* ----- Classe "Room" - Accesseurs ----- */    
    
    public boolean isUserPresence() {
        return userPresence;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public MotionSensor getMotionSensor() {
        return motionSensor;
    }

    public ContactSensor getContactSensor() {
        return contactSensor;
    }
    
    /* ----- Classe "Room" - Mutateurs ----- */

    public void setUserPresence(boolean userPresence) {
        this.userPresence = userPresence;
    }    
}