/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mustapha
 */
public class DBconnexion {
    
    String url="jdbc:mysql://localhost:3306/tft";
    String login = "root";
    String pwd = "";
    
    static private Connection connexion;
    
    private DBconnexion()
    {
        try{
            
        connexion = DriverManager.getConnection(url,login,pwd);
        System.out.println("Connexion établie");
        }catch(Exception e)
        {
            
        }
    
    }
    
    public static Connection getConnexion() // Pseudo Constructeur
    {
        if (connexion == null)
        {
            new DBconnexion();
            return connexion;
            
        }else
        {
            return connexion;
        }
        
    }
        
}


