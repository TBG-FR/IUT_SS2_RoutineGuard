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

public class PulseSensor extends RG_Sensor {
    
    /* ----- Classe "PulseSensor" - Attributs ----- */
    private double BPMlist;
    private double IBIlist;
    private double BPMaverage;
    private double IBIaverage;
    /* ----- Classe "PulseSensor" - Constructeurs ----- */

    public PulseSensor(int id) {
        super(id);
    }
    
    /* ----- Classe "PulseSensor" - Méthodes ----- */
    public double averageCalculation(){
            
        
        
        return 0; /* TMP */
    }    
    
    public int cardiacAnalysis(){
            
        
        
        return 0; /* TMP */
    } 
    /* ----- Classe "PulseSensor" - Accesseurs ----- */    
    
    /* ----- Classe "PulseSensor" - Mutateurs ----- */

    @Override
    public double getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}