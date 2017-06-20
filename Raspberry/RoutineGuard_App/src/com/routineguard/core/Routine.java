/*
 *
 */

package com.routineguard.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
 * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
 * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
 * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
 */

public class Routine {
    
    /* ----- Classe "Routine" - Attributs ----- */

    private int globalRoutineFulfiltment;
    private int globalTolerance;
    private ArrayList <Event> timeTable;

    /* ----- Classe "Routine" - Constructeurs ----- */
    public Routine (){
        timeTable=new ArrayList<Event>();
        timeTable.add(new Event(-1,-1,1,0,EventType.TOILETS,2));
    }
    /* ----- Classe "Routine" - Méthodes ----- */
    
    public void addEvent (Event event){
        timeTable.add(new Event(event));
        Collections.sort(timeTable,Comparator.comparing(Event::getBeginHour));
    }
    
    public void deleteEvent(int index){
        timeTable.remove(index);
        Collections.sort(timeTable,Comparator.comparing(Event::getBeginHour));
    }

    public void display(){
        for(int i=0;i<timeTable.size();i++){
            System.out.println(timeTable.get(i).getEventType());
        }
    }

    /* ----- Classe "Routine" - Accesseurs ----- */    
    
    public ArrayList<Event> getRoutine(){
        return timeTable;
    }

    /* ----- Classe "Routine" - Mutateurs ----- */
    
}
