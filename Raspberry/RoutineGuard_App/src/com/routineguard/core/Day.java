/*
 *
 */

package com.routineguard.core;

import java.util.ArrayList;



/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class Day {
    
    /* ----- Classe "Day" - Attributs ----- */

    protected int currentHour;
    protected int currentTimeSlot;
    protected Routine routineToWatch=new Routine();
    protected int respect;
    private Slot[] model;
    private Slot[] actualDay;
    
    /* ----- Classe "Day" - Constructeurs ----- */
    
    public Day(int currentHour, int currentTimeSlot, Routine routineToWatch) {
        this.currentHour=currentHour;
        this.currentTimeSlot=currentTimeSlot;
        this.routineToWatch= routineToWatch;
        initDay();
    }
    
    /* ----- Classe "Day" - Méthodes ----- */
    
    private void initDay() {
        respect=100;
        model=new Slot[24*6];
        actualDay=new Slot[24*6];
        for(int i=0;i<24*6;i++){
            model[i]=new Slot();
            actualDay[i]=new Slot();
        }
        int nbEvents=routineToWatch.getRoutine().size();
        for(int i=0;i<nbEvents;i++) {

            int eventHour=routineToWatch.getRoutine().get(i).getBeginHour();
            int eventSlot=routineToWatch.getRoutine().get(i).getTimeSlot();
            int eventTolerance=routineToWatch.getRoutine().get(i).getTolerance();
            int eventDuration=routineToWatch.getRoutine().get(i).getDuration();
            
            for(int f=1; f< eventTolerance+1 ;f++){
                model[(eventHour*6)+eventSlot-f].setEventID(i);
                model[(eventHour*6)+eventSlot-f].setShouldBe(false);
            }

            if(eventDuration ==0){

                for(int f=1; f< eventTolerance+1 ;f++){
                    model[(eventHour*6)+eventSlot+f].setEventID(i);
                    model[(eventHour*6)+eventSlot+f].setShouldBe(false);
                }
                
                model[(eventHour*6)+eventSlot].setEventID(i);
                model[(eventHour*6)+eventSlot].setShouldBe(true);
            
            } else {

                for(int f=1; f< eventTolerance+1 ;f++){
                    model[(eventHour*6)+eventDuration-1+eventSlot+f].setEventID(i);
                    model[(eventHour*6)+eventDuration-1+eventSlot+f].setShouldBe(false);
                }

                for(int f=0; f< eventDuration ;f++){
                    model[(eventHour*6)+eventSlot+f].setEventID(i);
                    model[(eventHour*6)+eventSlot+f].setShouldBe(true);
                }
                
                
            }
            
            

            
            
        }
        
    }

    public void timePass(){
        if(currentTimeSlot==5){
            if(currentHour==23){
                ResetDay();
            }
            else {
                currentTimeSlot=0;
                currentHour++;
            }
        }
        else {
            currentTimeSlot++;
        }
        compareRoutine();
    }

    public void ResetDay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void compareRoutine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void afficheModele(){
        for(int i=0;i<24*6;i++){
            System.out.println("Hour : " + i/6 + " | Slot : " + i%6 + " | EventID : " + model[i].getEventID() + " | shouldBE : " + model[i].getShouldBe());
        }
    }

    /* ----- Classe "Day" - Accesseurs ----- */    
    
    /* ----- Classe "Day" - Mutateurs ----- */

    

    

    


    
}