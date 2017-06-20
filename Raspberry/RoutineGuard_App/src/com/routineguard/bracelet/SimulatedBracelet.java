/*
 *
 */

package com.routineguard.bracelet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class SimulatedBracelet implements KeyListener {
    
    /* ----- Classe "PulseSensor" - Attributs ----- */
    private Bracelet simulatedBracelet;
    
    /* ----- Classe "PulseSensor" - Constructeurs ----- */

    public SimulatedBracelet(Bracelet simulatedBracelet) {
        this.simulatedBracelet = simulatedBracelet;
    }
    
    
    /* ----- Classe "PulseSensor" - Méthodes ----- */
    
    /* ----- Classe "PulseSensor" - Accesseurs ----- */
    
    /* ----- Classe "PulseSensor" - Mutateurs ----- */

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_V)
            simulatedBracelet.getGreenButton().demo_PUSHBUTTON();
        if(e.getKeyCode()==KeyEvent.VK_X)
            simulatedBracelet.getRedButton().demo_PUSHBUTTON();
        if(e.getKeyCode()==KeyEvent.VK_P)
            simulatedBracelet.getPulseSensor().demo_PUSHBUTTON();
        if(e.getKeyCode()==KeyEvent.VK_M)
            simulatedBracelet.getAccelSensor().demo_PUSHBUTTON();
    }
    
}
