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

public class RoutineGuard { /* MAIN */
     
    public static void main(String[] args) {
        
        TemperatureSensor T1 = new TemperatureSensor(0);
        System.out.println(T1.getData());

        MotionSensor MS1=new MotionSensor(1);
        for(int i=0;i<100;i++){
            System.out.println(MS1.getData());
        }
        
        
        
    }
    
}
