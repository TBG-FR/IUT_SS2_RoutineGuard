/*
 *
 */

package com.routineguard.bracelet;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class Bracelet_Sensor {
    
    /* ----- Classe "Button" - Attributs ----- */
    protected Bracelet linkedBracelet;
    
    /* ----- Classe "Button" - Constructeurs ----- */
    public Bracelet_Sensor(Bracelet bracelet) {
        linkedBracelet = bracelet;
    }
    
    /* ----- Classe "Button" - Méthodes ----- */
        
    /* ----- Classe "Button" - Accesseurs ----- */
    public Bracelet getBracelet() {
        return linkedBracelet;
    }
    
    /* ----- Classe "Button" - Mutateurs ----- */
    
}
