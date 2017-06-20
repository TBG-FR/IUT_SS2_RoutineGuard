/*
 * Enum 'ButtonState' : Here we define the possible states for a Button.
 *  ----- ------ ----- ------ ----- ------ ----- ------ ----- ------ ----- 
 * We could also use an int value with '-1' for 'ERROR', 0 for 'RELEASED' and 1 for 'PUSHED'.
 */

package com.routineguard.bracelet;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public enum ButtonState {
    PUSHED,     // Button is Pushed
    RELEASED,   // Button isn't Pushed
    ERROR,      // Can't get the state of the Button
}