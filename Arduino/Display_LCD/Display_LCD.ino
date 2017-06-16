/*
  LiquidCrystal Library - display() and noDisplay()

 Demonstrates the use a 16x2 LCD display.  The LiquidCrystal
 library works with all LCD displays that are compatible with the
 Hitachi HD44780 driver. There are many of them out there, and you
 can usually tell them by the 16-pin interface.

 This sketch prints "Hello World!" to the LCD and uses the
 display() and noDisplay() functions to turn on and off
 the display.

 The circuit:
 * LCD RS pin to digital pin 12 -> CHECK
 * LCD Enable pin to digital pin 11 -> CHECK
 * LCD D4 pin to digital pin 5 -> PIN 6
 * LCD D5 pin to digital pin 4 -> PIN 5
 * LCD D6 pin to digital pin 3 -> CHECK
 * LCD D7 pin to digital pin 2 -> CHECK
 * LCD R/W pin to ground -> CHECK
 * 
 * 10K resistor:
 *     ends to +5V and ground
 *     wiper to LCD VO pin (pin 3)

 This example code is in the public domain.

 http://www.arduino.cc/en/Tutorial/LiquidCrystalDisplay

 */

// include the library code:
#include <LiquidCrystal.h>

// initialize the library with the numbers of the interface pins
LiquidCrystal lcd(12, 11, 6, 5, 3, 2);

void setup() {
  // set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  
  // Print a message to3 the LCD.
  lcd.print("hello, world!");
}

void loop() {
  lcd.setCursor(0, 1);
  lcd.print(millis() / 1000);
}

