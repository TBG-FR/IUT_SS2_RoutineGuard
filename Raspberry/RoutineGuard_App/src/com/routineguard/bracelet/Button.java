/*
 *
 */

package com.routineguard.bracelet;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class Button extends Bracelet_Sensor {
    
    /* ----- Classe "Button" - Attributs ----- */
    private ButtonState state;
    private boolean color; // Helps identifying the type of button (true: Green, false: Red)
    
    /* ----- Classe "Button" - Constructeurs ----- */
    public Button(Bracelet bracelet) {
        
        super(bracelet);        
        state = ButtonState.RELEASED;
        
    }
    
    /* ----- Classe "Button" - Méthodes ----- */
        
    /* ----- Classe "Button" - Accesseurs ----- */
    public ButtonState getState() {
        
        // [DEMO : Removed (No Arduino)]
        //state = linkedBracelet.getArduinoConnection().getButtonState(color);
        
        return state;
    }
    
    /* ----- Classe "Button" - Mutateurs ----- */
    
    // [DEMO : Button Push (No Arduino)]
    public void demo_PUSHBUTTON() {
        state = ButtonState.PUSHED;
    }
    
}
