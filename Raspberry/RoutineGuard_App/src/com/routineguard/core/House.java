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

public class House {
    
    /* ----- Classe "House" - Attributs ----- */
    private ArrayList<Room> rooms;
    private boolean visitors;
    private boolean userPresence;
    private int timePassed=0;
    private RoomType formerType;
    private int passedInRoom=0;
    private EventType currentEvent=EventType.NONE;
    /* ----- Classe "House" - Constructeurs ----- */
    
        public House(){
            initHouse();
        }
    
    /* ----- Classe "House" - Méthodes ----- */
    public int intrusion(){
        
        
        
        return 0; /* TMP */
    }
    
    
    private void initHouse() {
        formerType=RoomType.NONE;
        rooms=new ArrayList<Room>();
        rooms.add(new Room(RoomType.KITCHEN));
        rooms.add(new Room(RoomType.BEDROOM));
        rooms.add(new Room(RoomType.BATHROOM));
        rooms.add(new Room(RoomType.CORRIDOR));
        rooms.get(getRoom(RoomType.KITCHEN)).addMotionSensor(5);
        rooms.get(getRoom(RoomType.KITCHEN)).addContactSensor(6);
        rooms.get(getRoom(RoomType.BEDROOM)).addMotionSensor(2);
        rooms.get(getRoom(RoomType.BATHROOM)).addMotionSensor(4);
        rooms.get(getRoom(RoomType.CORRIDOR)).addMotionSensor(3);
    }
    
    public void addRoom(RoomType roomType){
        rooms.add(new Room(roomType));
    }
    /* ----- Classe "House" - Accesseurs ----- */    
    
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    
    public int getRoom(RoomType roomType){
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomType()==roomType){
                return i;
            }
        }
        return -1;
    }
    
    public void checkCaptors(Day currentDay){
        
        
        
        if(rooms.get(getRoom(RoomType.CORRIDOR)).getMotionSensor().getData()==1){
            
            if(formerType==RoomType.CORRIDOR){
                timePassed++;
            } else {
                formerType=RoomType.CORRIDOR;
                timePassed=0;
            }
            
            if(timePassed==3){
                
                passedInRoom=0;
                System.out.println("Dans le couloir");
                
                if(rooms.get(getRoom(RoomType.BEDROOM)).isUserPresence()==true){
                    
                    if(currentEvent==EventType.SLEEPING){
                        currentDay.happen(EventType.AWAKENING, -1);
                        rooms.get(getRoom(RoomType.BEDROOM)).setUserPresence(false);
                        currentEvent=EventType.NONE;
                    }
                    
                }
                
                if(rooms.get(getRoom(RoomType.BATHROOM)).isUserPresence()==true){
                    currentDay.happen(EventType.SHOWER,1);
                    rooms.get(getRoom(RoomType.BATHROOM)).setUserPresence(false);
                }
                
                if(rooms.get(getRoom(RoomType.KITCHEN)).isUserPresence()==true){
                    currentDay.happen(EventType.LUNCH,1);
                    rooms.get(getRoom(RoomType.KITCHEN)).setUserPresence(false);
                }
            
                for(int i=0;i<rooms.size();i++){
                    
                    if(rooms.get(i).getRoomType()!=RoomType.CORRIDOR){
                        rooms.get(i).setUserPresence(false);
                    }
                }
            }
        }
        
        
        
        
        
        if (rooms.get(getRoom(RoomType.BEDROOM)).getMotionSensor().getData()==1){
            
            if (formerType==RoomType.BEDROOM){
                timePassed++;
            } else {
                formerType=RoomType.BEDROOM;
                timePassed=0;
            }
            
            if (timePassed==3){
                
                passedInRoom=0;
                System.out.println("Dans la chambre");
                rooms.get(getRoom(RoomType.BEDROOM)).setUserPresence(true);
                rooms.get(getRoom(RoomType.CORRIDOR)).setUserPresence(false);
                
            }
            
            for(int i=0;i<rooms.size();i++){
                
                if(rooms.get(i).getRoomType()!=RoomType.BEDROOM){
                    rooms.get(i).setUserPresence(false);
                }
            }
        }
        
        
        
        
        
        if(rooms.get(getRoom(RoomType.KITCHEN)).getMotionSensor().getData()==1){
            
            if(formerType==RoomType.KITCHEN){
                timePassed++;
            } else {
                formerType=RoomType.KITCHEN;
                timePassed=0;
            }
            
            if(timePassed==3){
                passedInRoom=0;
                System.out.println("Dans la cusine");
                rooms.get(getRoom(RoomType.KITCHEN)).setUserPresence(true);
                rooms.get(getRoom(RoomType.CORRIDOR)).setUserPresence(false);
                
                if(currentEvent==EventType.SHOWER){
                    currentDay.happen(EventType.SHOWER,1);
                    currentEvent=EventType.NONE;
                }
                
            }
            
            for(int i=0;i<rooms.size();i++){
                    if(rooms.get(i).getRoomType()!=RoomType.KITCHEN){
                        rooms.get(i).setUserPresence(false);
                    }
                }
        }
        
        
        
        
        
        if(rooms.get(getRoom(RoomType.BATHROOM)).getMotionSensor().getData()==1){
            
            if(formerType==RoomType.BATHROOM){
                timePassed++;
            } else {
                formerType=RoomType.BATHROOM;
                timePassed=0;
            }
            
            
            if(timePassed==3){
                passedInRoom=0;
                System.out.println("Dans la salle de bain");
                rooms.get(getRoom(RoomType.BATHROOM)).setUserPresence(true);
                rooms.get(getRoom(RoomType.CORRIDOR)).setUserPresence(false);
                
                if(currentEvent==EventType.LUNCH){
                    currentDay.happen(EventType.LUNCH,1);
                    currentEvent=EventType.NONE;
                }
            }
            
            for(int i=0;i<rooms.size();i++){
                    if(rooms.get(i).getRoomType()!=RoomType.BATHROOM){
                        rooms.get(i).setUserPresence(false);
                    }
                }
            
        }
        
        
        
        
        
        
        
        
        if (rooms.get(getRoom(RoomType.BEDROOM)).isUserPresence()==true){
            passedInRoom++;
            if(passedInRoom==30){
                System.out.println("endormi");
                currentEvent=EventType.SLEEPING;
            }
        }
        
        if (rooms.get(getRoom(RoomType.BATHROOM)).isUserPresence()==true){
            passedInRoom++;
            
            if (passedInRoom==30) {
                System.out.println("prends sa douche");
                currentDay.happen(EventType.SHOWER,0);
                currentEvent=EventType.SHOWER;
            }
        }
        
        if (rooms.get(getRoom(RoomType.KITCHEN)).isUserPresence()==true){
            passedInRoom++;
            
            if (rooms.get(getRoom(RoomType.KITCHEN)).getContactSensor().getData()==1&&currentEvent!=EventType.LUNCH){
                System.out.println("mange");
                currentDay.happen(EventType.LUNCH,0);
                currentEvent=EventType.LUNCH;
            }
        }
    }
    
    
    
    /* ----- Classe "House" - Mutateurs ----- */

    
    
}