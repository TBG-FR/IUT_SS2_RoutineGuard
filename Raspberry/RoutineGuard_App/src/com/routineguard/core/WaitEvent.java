/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.routineguard.core;

/**
 *
 * @author dyvia
 */
public class WaitEvent {

    /* ----- Classe "WaitEvent" - Attributs ----- */
    private int eventID;
    private EventType typeEvent;
    private int eventState;
    
    /* ----- Classe "WaitEvent" - Constructeurs ----- */
    
    /* ----- Classe "WaitEvent" - Méthodes ----- */
        
    /* ----- Classe "WaitEvent" - Accesseurs ----- */    
    
    public int getEventID() {
        return eventID;
    }

    public EventType getTypeEvent() {
        return typeEvent;
    }

    public int getEventState() {
        return eventState;
    }

    /* ----- Classe "WaitEvent" - Mutateurs ----- */

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setTypeEvent(EventType typeEvent) {
        this.typeEvent = typeEvent;
    }

    public void setEventState(int eventState) {
        this.eventState = eventState;
    }

}
