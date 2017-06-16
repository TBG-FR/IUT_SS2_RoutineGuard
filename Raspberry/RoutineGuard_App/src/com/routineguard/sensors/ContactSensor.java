/*
 *
 */

package com.routineguard.sensors;

import grovepi.sensors.ButtonSensor;
import grovepi.Pin;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class ContactSensor extends RG_Sensor {
    
    /* ----- Classe "ContactSensor" - Attributs ----- */
    ButtonSensor BS;
    /* ----- Classe "ContactSensor" - Constructeurs ----- */
    public ContactSensor(int _pin) {
        super(_pin);
        BS = new ButtonSensor(gp,pin);
    }
    
    /* ----- Classe "ContactSensor" - Méthodes ----- */
     
    /* ----- Classe "ContactSensor" - Accesseurs ----- */    
    
    /* ----- Classe "ContactSensor" - Mutateurs ----- */

    @Override
    public double getData() {
        if(BS.getState()==true){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}