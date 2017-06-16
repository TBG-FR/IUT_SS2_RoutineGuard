/*
 *
 */

package com.routineguard.core;

import java.util.ArrayList;



/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class Day {
    
    /* ----- Classe "Day" - Attributs ----- */
    protected ArrayList<Event> Events;
    
    /* ----- Classe "Day" - Constructeurs ----- */
    
    public Day() {
        Events = new ArrayList<Event>();
    }
    
    /* ----- Classe "Day" - Méthodes ----- */
        
    public void addEvent(Event e){
        Events.add(e);
    }
    
    /* ----- Classe "Day" - Accesseurs ----- */    
    
    /* ----- Classe "Day" - Mutateurs ----- */


    
}