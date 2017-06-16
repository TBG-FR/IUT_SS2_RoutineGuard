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

public class AccelerometerSensor extends RG_Sensor {
    
    /* ----- Classe "AccelerometerSensor" - Attributs ----- */
    private int tabAccelerometer;
    /* ----- Classe "AccelerometerSensor" - Constructeurs ----- */

    public AccelerometerSensor(int id) {
        super(id);
    }
    
    /* ----- Classe "AccelerometerSensor" - Méthodes ----- */
    public int accelerometerAnalysis(){
        
        
        
        return 0; /* TMP */ 
    }
    /* ----- Classe "AccelerometerSensor" - Accesseurs ----- */    
    
    /* ----- Classe "AccelerometerSensor" - Mutateurs ----- */

    @Override
    public double getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}