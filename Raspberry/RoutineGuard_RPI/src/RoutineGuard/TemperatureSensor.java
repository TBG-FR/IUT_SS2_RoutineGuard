/*
 *
 */

package RoutineGuard;

import grovepi.sensors.TemperatureAndHumiditySensor;
import grovepi.Pin;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class TemperatureSensor extends RG_Sensor {
    
    /* ----- Classe "TemperatureSensor" - Attributs ----- */
    TemperatureAndHumiditySensor T;
    
    /* ----- Classe "TemperatureSensor" - Constructeurs ----- */
    public TemperatureSensor(int id) {
        super(id);        
        T = new TemperatureAndHumiditySensor(gp,Pin.DIGITAL_PIN_8,TemperatureAndHumiditySensor.Model.DHT22);
        
    }
    
    /* ----- Classe "TemperatureSensor" - Méthodes ----- */

    /* ----- Classe "TemperatureSensor" - Accesseurs ----- */    
    
    /* ----- Classe "TemperatureSensor" - Mutateurs ----- */

    @Override
    public double getData() {
        T.update();
        return T.getTemperature();
    }
    
}