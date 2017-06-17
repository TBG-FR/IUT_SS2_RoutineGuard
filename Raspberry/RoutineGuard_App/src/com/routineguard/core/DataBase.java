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

      String url = "jdbc:mysql://localhost:3306/bdd";
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


}
