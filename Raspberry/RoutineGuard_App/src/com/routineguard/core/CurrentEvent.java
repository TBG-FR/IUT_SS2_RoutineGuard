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
public class CurrentEvent {

    /* ----- Classe "CurrentEvent" - Attributs ----- */

    private int duration;
    private EventType eventType;
    private int expectedDuration;
    private int alertLevel;

    
    /* ----- Classe "CurrentEvent" - Constructeurs ----- */
    
    /* ----- Classe "CurrentEvent" - Méthodes ----- */
    
    /* ----- Classe "CurrentEvent" - Accesseurs ----- */    
    
    public int getDuration() {
        return duration;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public int getAlertLevel() {
        return alertLevel;
    }

    public EventType getEventType() {
        return eventType;
    }
    
    /* ----- Classe "CurrentEvent" - Mutateurs ----- */

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public void setAlertLevel(int alertLevel) {
        this.alertLevel = alertLevel;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    

}
