/*
 *
 */

package RoutineGuard;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class RoutineGuard { /* MAIN */
     
    public static void main(String[] args) {
        
        ArduinoLink AL1 = new ArduinoLink();
        
//        try {
//            AL1.test();
//        } catch (Exception ex) {
//            Logger.getLogger(ArduinoLink.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            new ArduinoDiscover().go();
        } catch (Exception ex) {
            Logger.getLogger(ArduinoDiscover.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
