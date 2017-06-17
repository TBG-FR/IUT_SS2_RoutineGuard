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
class Slot {
    /* ----- Classe "Slot" - Attributs ----- */
    private int eventID;
    private boolean shouldBe;
    private boolean accomplished;
    
    /* ----- Classe "Slot" - Constructeurs ----- */
    
    public Slot(){
        eventID=-1;
        accomplished=false;
    }

    /* ----- Classe "Slot" - Méthodes ----- */
        
    /* ----- Classe "Slot" - Accesseurs ----- */    

    public int getEventID() {
        return eventID;
    }

    public boolean getShouldBe() {
        return shouldBe;
    }

    public boolean isAccomplished() {
        return accomplished;
    }

    /* ----- Classe "Slot" - Mutateurs ----- */

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setShouldBe(boolean shouldBe) {
        this.shouldBe = shouldBe;
    }

    public void setAccomplished(boolean accomplished) {
        this.accomplished = accomplished;
    }

    
}
