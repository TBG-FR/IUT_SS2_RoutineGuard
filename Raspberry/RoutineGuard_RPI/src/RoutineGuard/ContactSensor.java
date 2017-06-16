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

public class ContactSensor extends RG_Sensor {
    
    /* ----- Classe "ContactSensor" - Attributs ----- */
    private int contact;
    /* ----- Classe "ContactSensor" - Constructeurs ----- */

    public ContactSensor(int id) {
        super(id);
    }
    
    /* ----- Classe "ContactSensor" - Méthodes ----- */
    private boolean contactDetection(){
                
        
        
        return false; /* TMP */
    }    
    /* ----- Classe "ContactSensor" - Accesseurs ----- */    
    
    /* ----- Classe "ContactSensor" - Mutateurs ----- */

    @Override
    public double getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}