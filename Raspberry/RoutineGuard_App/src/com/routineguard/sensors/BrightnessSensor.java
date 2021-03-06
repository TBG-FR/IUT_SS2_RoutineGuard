/*
 * This sensor enable us to get the brightness of a room and display it on the Raspberry
 *
 * In this case, we do not have any Brightness Sensor so we simulated it by the hours of the day
 */

package com.routineguard.sensors;

import grovepi.Pin;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    public BrightnessSensor(int _pin) {
        super(_pin);
    }
    
    /* ----- Classe "BrightnessSensor" - Méthodes ----- */
       
    /* ----- Classe "BrightnessSensor" - Accesseurs ----- */    
    
    /* ----- Classe "BrightnessSensor" - Mutateurs ----- */

    @Override
    public double getData() {      //This method simulate the brightness by the hours of the day
        
        double bright_calc=0;
        
        String txtDate=new SimpleDateFormat("HH", Locale.FRANCE).format(new Date());
        if(Integer.parseInt(txtDate)<12){
            bright_calc=Integer.parseInt(txtDate)*8;
        }
        else{
            bright_calc=96.1-((Integer.parseInt(txtDate)-12)*8);
        }
        return bright_calc;
    }
    
}
