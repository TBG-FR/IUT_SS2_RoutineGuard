/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.routineguard.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dyvia
 */
public class DataBase {
    
    public void connection () {
    Connection conn=null;
    Statement st= null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver O.K.");

      String url = "jdbc:mysql://localhost:3306/RoutineGuard";
      String user = "root";
      String passwd = "";

      conn = DriverManager.getConnection(url, user, passwd);
      System.out.println("Connexion effective !");
      st= conn.createStatement();
      String requete = "SELECT * FROM news";
      
      ResultSet resultat=st.executeQuery(requete);
      
      while (resultat.next()){
       System.out.println(resultat.getString("texte")); 
      }
      
         
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
        try {
        conn.close();
        st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }  
    

    

}

 public void saveDay (Day currentDay) {
    Date aujourdhui = new Date();
    SimpleDateFormat formater = null;
    formater = new SimpleDateFormat("dd-MM-yy");

    Connection conn=null;
    Statement st= null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver O.K.");

      String url = "jdbc:mysql://localhost:3306/RoutineGuard";
      String user = "root";
      String passwd = "";

      conn = DriverManager.getConnection(url, user, passwd);
      System.out.println("Connexion effective !");
      st= conn.createStatement();
      String requete = "INSERT INTO Journee(date,respectRoutine,nbAlertes) VALUES ("+formater.format(aujourdhui)+ "," + currentDay.getRespect() + "," + currentDay.getNbAlertes() +")";
      
      st.executeUpdate(requete);
      
         
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
        try {
        conn.close();
        st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
}
