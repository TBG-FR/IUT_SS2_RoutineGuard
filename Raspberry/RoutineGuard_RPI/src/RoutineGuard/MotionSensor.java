/*
 *
 */
package RoutineGuard;

import grovepi.sensors.ButtonSensor;
import grovepi.Pin;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class MotionSensor extends RG_Sensor {
    
    /* ----- Classe "MotionSensor" - Attributs ----- */
    ButtonSensor BS;
    /* ----- Classe "MotionSensor" - Constructeurs ----- */
    public MotionSensor(int id) {
        super(id);
        BS=new ButtonSensor(gp,Pin.DIGITAL_PIN_7);
    }
    /* ----- Classe "MotionSensor" - Méthodes ----- */
    public boolean motion(){
        
        
        
        return true; /* TMP */
    }    
    /* ----- Classe "MotionSensor" - Accesseurs ----- */    
    
    /* ----- Classe "MotionSensor" - Mutateurs ----- */

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