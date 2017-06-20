/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.routineguard.core;

import com.routineguard.sensors.MotionSensor;

/**
 *
 * @author dyvia
 */
public class Captors {
     
    /* ----- Classe "Captors" - Attributs ----- */
    private MotionSensor bedroomMotion;
    private MotionSensor corridorMotion;
    private MotionSensor bathroomMotion;
    private MotionSensor kitchenMotion;
    private House house;
    
    /* ----- Classe "Captors" - Constructeurs ----- */
    
    public Captors(){
    initCaptors();
    }
    
    /* ----- Classe "Captors" - Méthodes ----- */
    
    private void initCaptors() {
        bedroomMotion=new MotionSensor(2);
        corridorMotion=new MotionSensor(3);
        bathroomMotion=new MotionSensor(4);
        kitchenMotion=new MotionSensor(5);
        house.addRoom(RoomType.KITCHEN);
        house.addRoom(RoomType.BEDROOM);
        house.addRoom(RoomType.BATHROOM);
        house.addRoom(RoomType.CORRIDOR);
    }
    
    public void checkCaptors(){
        if(corridorMotion.getData()==1){
            System.out.println("Dans le couloir");
            for(int i=0;i<house.getRooms().size();i++){
                if(house.getRooms().get(i).getRoomType()!=RoomType.CORRIDOR){
                    house.getRooms().get(i).setUserPresence(false);
                }
            }
        }
    }
    
    /* ----- Classe "Captors" - Accesseurs ----- */    
    
    /* ----- Classe "Captors" - Mutateurs ----- */

}
