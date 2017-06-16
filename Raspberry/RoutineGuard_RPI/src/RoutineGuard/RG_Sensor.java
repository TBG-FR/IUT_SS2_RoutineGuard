/*
 *
 */

package RoutineGuard;

import grovepi.GrovePi;
import grovepi.Pin;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public abstract class RG_Sensor {
    
    /* ----- Classe "Sensor" - Attributs ----- */
    protected GrovePi gp;
    protected int pin;
    
    /* ----- Classe "Sensor" - Constructeurs ----- */
    public RG_Sensor(int _pin) {
        if(_pin<9 && _pin>-1)
            this.pin=_pin;
            
        if(this.gp==null)
            this.gp=new GrovePi();
    }
    
    /* ----- Classe "Sensor" - Méthodes ----- */
    public abstract double getData();
 
    
    /* ----- Classe "Sensor" - Accesseurs ----- */    
    
    /* ----- Classe "Sensor" - Mutateurs ----- */
    
}