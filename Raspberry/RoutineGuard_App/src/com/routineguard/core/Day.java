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
    private CurrentEvent currentEvent;
    
    /* ----- Classe "Day" - Constructeurs ----- */
    
    public Day(int currentHour, int currentTimeSlot, Routine routineToWatch) {
        this.currentHour=currentHour;
        this.currentTimeSlot=currentTimeSlot;
        this.routineToWatch= routineToWatch;
        initDay();
    }
    
    /* ----- Classe "Day" - Méthodes ----- */
    
    private void initDay() {
        currentEvent= new CurrentEvent();
        currentEvent.setDuration(-1);
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
            if(eventHour!=-1){
                for(int f=1; f< eventTolerance+1 ;f++){
                    model[(eventHour*6)+eventSlot-f].setEventID(i);
                    model[(eventHour*6)+eventSlot-f].setShouldBe(false);
                }
                for(int f=1; f< eventTolerance+1 ;f++){
                    model[(eventHour*6)+eventSlot+f].setEventID(i);
                    model[(eventHour*6)+eventSlot+f].setShouldBe(false);
                }

                model[(eventHour*6)+eventSlot].setEventID(i);
                model[(eventHour*6)+eventSlot].setShouldBe(true);

                /*if(eventDuration ==0){

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
                }*/
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
        currentTimeSlot=0;
        currentHour=0;
        respect=100;
        currentEvent.setDuration(-1);
        int nbEvents=routineToWatch.getRoutine().size();
        for(int i=0;i<nbEvents;i++) {
            routineToWatch.getRoutine().get(i).setAccomplished(false);
            int eventHour=routineToWatch.getRoutine().get(i).getBeginHour();
            int eventSlot=routineToWatch.getRoutine().get(i).getTimeSlot();
            int eventTolerance=routineToWatch.getRoutine().get(i).getTolerance();
            int eventDuration=routineToWatch.getRoutine().get(i).getDuration();
            if(eventHour!=-1){
                for(int f=1; f< eventTolerance+1 ;f++){
                    model[(eventHour*6)+eventSlot-f].setEventID(i);
                    model[(eventHour*6)+eventSlot-f].setShouldBe(false);
                }
                for(int f=1; f< eventTolerance+1 ;f++){
                    model[(eventHour*6)+eventSlot+f].setEventID(i);
                    model[(eventHour*6)+eventSlot+f].setShouldBe(false);
                }

                model[(eventHour*6)+eventSlot].setEventID(i);
                model[(eventHour*6)+eventSlot].setShouldBe(true);

            }
        }
        seekEvent();
    }

    public void compareRoutine() {
        
        if(currentEvent.getDuration()!=-1){
            System.out.println("current : " + currentEvent.getEventType());
            currentEvent.setDuration(currentEvent.getDuration()+1);
            if(currentEvent.getDuration()>currentEvent.getExpectedDuration()){
                System.out.println(currentEvent.getEventType() + " too long ");
            }
        }
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

    public void happen(EventType eventType,int begin){
        if(begin==-1||begin==0){
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
                if(begin==-1){
                    seekEvent();
                }
            } else {
                System.out.println( " Unexpected " + eventType );
            }
        } 
        if (begin==0) {
            currentEvent.setEventType(eventType);
            int nbEvents=routineToWatch.getRoutine().size();
            for(int i=0;i<nbEvents;i++) {
                if(routineToWatch.getRoutine().get(i).getEventType()==eventType){
                    currentEvent.setExpectedDuration(routineToWatch.getRoutine().get(i).getDuration());
                    currentEvent.setDuration(0);
                    currentEvent.setAlertLevel(routineToWatch.getRoutine().get(i).getEventImportance());
                }
            }
        } 
        if (begin !=0&&begin!=-1){
            seekEvent();
            currentEvent.setDuration(-1);
            System.out.println( " End of " + eventType );
        }
    }

    /* ----- Classe "Day" - Accesseurs ----- */    
    
    /* ----- Classe "Day" - Mutateurs ----- */

    

    

    

    


    
}