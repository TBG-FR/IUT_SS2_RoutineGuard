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
    private WaitEvent followingEvent;
    
    /* ----- Classe "Day" - Constructeurs ----- */
    
    public Day(int currentHour, int currentTimeSlot, Routine routineToWatch) {
        this.currentHour=currentHour;
        this.currentTimeSlot=currentTimeSlot;
        this.routineToWatch= routineToWatch;
        initDay();
    }
    
    /* ----- Classe "Day" - Méthodes ----- */
    
    private void initDay() {
        followingEvent=new WaitEvent();
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
        seekEvent();
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
        System.out.println(currentHour + " : " + (currentTimeSlot*10) );
        compareRoutine();
    }

    public void ResetDay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void compareRoutine() {

        if(model[(currentHour*6)+currentTimeSlot].getEventID()!=-1 && model[(currentHour*6)+currentTimeSlot].getEventID()==followingEvent.getEventID()){

            if(followingEvent.getEventState()==0){

                if(model[(currentHour*6)+currentTimeSlot].getShouldBe()==false){
                    followingEvent.setEventState(1);
                } else {
                    followingEvent.setEventState(2);
                }

            } else if ( followingEvent.getEventState()==1){

                if(model[(currentHour*6)+currentTimeSlot].getShouldBe()==false){

                } else {
                    followingEvent.setEventState(2);
                }

            } else if ( followingEvent.getEventState()==2){

                if(model[(currentHour*6)+currentTimeSlot].getShouldBe()==false){
                    followingEvent.setEventState(3);
                } else {
                }

            }
            
        } else {
            if(followingEvent.getEventState()==3){
                followingEvent.setEventState(4);
            }
        }

    System.out.println(followingEvent.getEventState() + " " + followingEvent.getTypeEvent());

    }
    
    public void displayModel(){
        for(int i=0;i<24*6;i++){
            System.out.println("Hour : " + i/6 + " | Slot : " + i%6 + " | EventID : " + model[i].getEventID() + " | shouldBE : " + model[i].getShouldBe());
        }
    }

    private void seekEvent() {

        for(int i=(currentHour*6)+currentTimeSlot;i<24*6;i++){
            if(model[i].getEventID()!=-1){
                if(routineToWatch.getRoutine().get(model[i].getEventID()).isAccomplished()==false){
                    followingEvent.setEventID(model[i].getEventID());
                    followingEvent.setTypeEvent(routineToWatch.getRoutine().get(model[i].getEventID()).getEventType());
                    if(model[(currentHour*6)+currentTimeSlot].getEventID()==followingEvent.getEventID()){
                        if(model[(currentHour*6)+currentTimeSlot].getShouldBe()==false){
                            followingEvent.setEventState(1);
                            break;
                        } else {
                            followingEvent.setEventState(2);
                            break;
                        }
                    } else {
                        followingEvent.setEventState(0);
                        break;
                    }
                }
            }
            else {
                followingEvent.setEventID(-1);
                followingEvent.setTypeEvent(EventType.NONE);
                followingEvent.setEventState(0);
            }
        }
        System.out.println("Next event : " + followingEvent.getTypeEvent());
    }

    public void happen(EventType eventType){
        if(eventType==followingEvent.getTypeEvent()){
            if(followingEvent.getEventState()==0){
                System.out.println(eventType + " very early ");
            }
            if(followingEvent.getEventState()==1){
                System.out.println(eventType + " little early ");
            }
            if(followingEvent.getEventState()==2){
                System.out.println(eventType + " right on time ");
            }
            if(followingEvent.getEventState()==3){
                System.out.println(eventType + " little late ");
            }
            if(followingEvent.getEventState()==4){
                System.out.println(eventType + " very late ");
            }
        routineToWatch.getRoutine().get(followingEvent.getEventID()).setAccomplished(true);
        seekEvent();
        } else {
            System.out.println( " Unexpected " + eventType );
        }
    
    }

    /* ----- Classe "Day" - Accesseurs ----- */    
    
    /* ----- Classe "Day" - Mutateurs ----- */

    

    

    

    


    
}