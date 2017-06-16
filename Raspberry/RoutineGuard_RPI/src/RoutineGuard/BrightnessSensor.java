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

public class BrightnessSensor  extends RG_Sensor {
    
    /* ----- Classe "BrightnessSensor" - Attributs ----- */
    private double brightness;
    private double threshold;
    /* ----- Classe "BrightnessSensor" - Constructeurs ----- */

    public BrightnessSensor(int id) {
        super(id);
    }
    
    /* ----- Classe "BrightnessSensor" - Méthodes ----- */
    public double brightnessCalculation(){
            
        
        
        return 0; /* TMP */
    }     
    /* ----- Classe "BrightnessSensor" - Accesseurs ----- */    
    
    /* ----- Classe "BrightnessSensor" - Mutateurs ----- */

    @Override
    public double getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}