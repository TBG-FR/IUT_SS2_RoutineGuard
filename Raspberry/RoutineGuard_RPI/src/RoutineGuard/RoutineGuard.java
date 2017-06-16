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
        while(1<2){
            TemperatureSensor T1 = new TemperatureSensor(8);
            HumiditySensor H1=new HumiditySensor(8);
            System.out.println("Température : "+T1.getData());
            System.out.println("Humidité : "+H1.getData());

            MotionSensor MS1=new MotionSensor(7);
            for(int i=0;i<1000;i++){
                if(MS1.getData()==1){
                    System.out.println("Mouvement detecté");
                }
            }

            ContactSensor CS1=new ContactSensor(3);
            for(int i=0;i<1000;i++){
                if(CS1.getData()==1){
                    System.out.println("Bouton Appuyé");
                }
            }
        }
        
        
        
    }
    
}
