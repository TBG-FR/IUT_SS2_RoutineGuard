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

    private int beginHour; //from 0 to 23
    private int timeSlot; //from 0 to 5
    private int duration; 
    private int tolerance;
    private EventType eventType;
    private int eventImportance;
    private String eventDescription;
    
    /* ----- Classe "Event" - Constructeurs ----- */
    
    public Event(Event event) {
        this.beginHour = event.getBeginHour(); //Implements the calc's LATER
        this.timeSlot = event.getTimeSlot(); //Implements the calc's LATER
        this.duration = event.getDuration();
        this.tolerance = event.getTolerance();
        this.eventType = event.getEventType();
        this.eventImportance = event.getEventImportance();
        this.eventDescription = event.getEventDescription();
    }

    public Event(int beginHour,int timeSlot, int duration, int tolerance, EventType eventType, int eventImportance, String eventDescription) {
        this.beginHour = beginHour; //Implements the calc's LATER
        this.timeSlot = timeSlot; //Implements the calc's LATER
        this.duration = duration;
        this.tolerance = tolerance;
        this.eventType = eventType;
        this.eventImportance = eventImportance;
        this.eventDescription = eventDescription;
    }
    
    public Event(int beginHour, int timeSlot, int duration, int tolerance, EventType eventType, int eventImportance) {
        this.beginHour = beginHour;
        this.timeSlot = timeSlot;
        this.duration = duration;
        this.tolerance = tolerance;
        this.eventType = eventType;
        this.eventImportance = eventImportance;
    }
    
    public Event(int hour, int duration, int tolerance, EventType eventType, int eventImportance, String eventDescription) {
        this.beginHour = hourToInt(hour);
        this.timeSlot = hourToSlot(hour);
        this.duration = duration;
        this.tolerance = tolerance;
        this.eventType = eventType;
        this.eventImportance = eventImportance;
        this.eventDescription = eventDescription;
    }
    
    public Event(int hour, int duration, int tolerance, EventType eventType, int eventImportance) {
        this.beginHour = hourToInt(hour);
        this.timeSlot = hourToSlot(hour);
        this.duration = duration;
        this.tolerance = tolerance;
        this.eventType = eventType;
        this.eventImportance = eventImportance;
    }

    /* ----- Classe "Event" - Méthodes ----- */

    public int hourToInt (int hour){
        return 0;
    }
    
    public int hourToSlot (int hour){
        return 0;
    }

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

    public int getTimeSlot () {
        return timeSlot;
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
   
    public void setTimeSlot(int timeSlot){
        this.timeSlot=timeSlot;
    }

}