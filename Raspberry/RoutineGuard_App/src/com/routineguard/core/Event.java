/*
 *
 */
package com.routineguard.core;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class Event {
    
    /* ----- Classe "Event" - Attributs ----- */
    private int beginHour;
    private int duration;
    private int tolerance;
    private EventType eventType;
    private int eventImportance;
    private String eventDescription;
    
    /* ----- Classe "Event" - Constructeurs ----- */
    
    public Event(int beginHour, int duration, int tolerance, EventType eventType, int eventImportance, String eventDescription) {
        this.beginHour = beginHour;
        this.duration = duration;
        this.tolerance = tolerance;
        this.eventType = eventType;
        this.eventImportance = eventImportance;
        this.eventDescription = eventDescription;
    }
    
    public Event(int beginHour, int duration, int tolerance, EventType eventType, int eventImportance) {
        this.beginHour = beginHour;
        this.duration = duration;
        this.tolerance = tolerance;
        this.eventType = eventType;
        this.eventImportance = eventImportance;
    }
    
    /* ----- Classe "Event" - Méthodes ----- */
        
    /* ----- Classe "Event" - Accesseurs ----- */

    public int getTolerance() {
        return tolerance;
    }

    public EventType getEventType() {
        return eventType;
    }
    
    public String getStringEventType(){
        return "" + eventType;
    }

    public int getEventImportance() {
        return eventImportance;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getDuration() {
        return duration;
    }

    public int getBeginHour() {
        return beginHour;
    }
    
    /* ----- Classe "Event" - Mutateurs ----- */

    public void setBeginHour(int beginHour) {
        this.beginHour = beginHour;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventImportance(int eventImportance) {
        this.eventImportance = eventImportance;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setTolerance(int tolerance) {
        this.tolerance = tolerance;
    }    
}