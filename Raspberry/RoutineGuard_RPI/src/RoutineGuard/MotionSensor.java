/*
 *
 */
package RoutineGuard;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class MotionSensor extends RG_Sensor {

    public MotionSensor(int id) {
        super(id);
    }
    
    /* ----- Classe "MotionSensor" - Attributs ----- */
    
    /* ----- Classe "MotionSensor" - Constructeurs ----- */
    
    /* ----- Classe "MotionSensor" - Méthodes ----- */
    public boolean motion(){
        
        
        
        return true; /* TMP */
    }    
    /* ----- Classe "MotionSensor" - Accesseurs ----- */    
    
    /* ----- Classe "MotionSensor" - Mutateurs ----- */

    @Override
    public double getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}