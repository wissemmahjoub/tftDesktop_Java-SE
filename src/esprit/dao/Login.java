/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.config.DBconnexion;
import esprit.controllers.outils.Cryptage;
import esprit.entite.Arbitre;
import esprit.entite.Medecin;
import esprit.entite.Niveau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustapha
 */
public class Login {
    
    public static String findLoginAdmin(String pwd)
    {
     Connection connexion;
     Statement ste;
     PreparedStatement pre;
        
     try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
            
            
            
            
               String req= "select * from fos_user where username = 'Admin' ";
            
              
               try {
            ResultSet res =  ste.executeQuery(req);
            if (res.next()) {
              
                String pwdCrypted = Cryptage.cypterPHP(pwd,res.getString("salt"));
                
                if (pwdCrypted.equals(res.getString("password")))
                {
                    return "1";
                }else
                {
                    return "Mot de passe non valide ";
                }
            }else{
                return "Requete non valide ";
            }
            
        } catch (SQLException ex) {
            return "-1";
        }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
               
               return "";
    }
    public static String findLoginResponsable(String pwd)
    {
     Connection connexion;
     Statement ste;
     PreparedStatement pre;
        
     try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
            
            
            
            
               String req= "select * from fos_user where username = 'Responsable' ";
            
              
               try {
            ResultSet res =  ste.executeQuery(req);
            if (res.next()) {
              
                String pwdCrypted = Cryptage.cypterPHP(pwd,res.getString("salt"));
                
                if (pwdCrypted.equals(res.getString("password")))
                {
                    return "1";
                }else
                {
                    return "Mot de passe non valide ";
                }
            }else{
                return "Requete non valide ";
            }
            
        } catch (SQLException ex) {
            return "-1";
        }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
               
               return "";
    }
    
    
    
    public static Arbitre findLoginArbitre(String login, String pwd)
    {
     Connection connexion;
     Statement ste;
     PreparedStatement pre;
     Arbitre arbitre;
        
     try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
              String req= "select * from fos_user where roles = '{i:0;s:11:\"ROLE_ARBITRE\";}' and username = '"+ login+"'";
              try {
            ResultSet res =  ste.executeQuery(req);
            if (res.next()) {
                String pwdCrypted =  Cryptage.cypterPHP(pwd,res.getString("salt"));
                if (pwdCrypted.equals(res.getString("password")))
                {
                    String req2= "select * from personne where role = 'Arbitre' and login = '"+ login+"'"; 
                    ResultSet res2 =  ste.executeQuery(req2);
                    if (res.next()) {
                          arbitre= new Arbitre(res.getInt("idpersonne"),
                       res.getString("cin"),
                        res.getString("nom"),
                       res.getString("prenom"),
                       res.getString("adresse"),
                       res.getString("email"),
                       res.getString("sexe"),
                       res.getString("login"),
                       res.getString("password"),
                       res.getDate("datenaissance"),
                       res.getString("role"),
                       res.getString("avatar"),
                       res.getDate("datedestruction"),
                       res.getFloat("salaire"),
                       res.getInt("experience"),
                       Niveau.valueOf(res.getString("niveau"))
               );
                          return arbitre;
                    }
                    
                }else
                {
                    return null;
                }
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            return null;
        }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
               
               return null;
    }
    public static String findSalt(String role)
    {
        return null;
    }
    
      public static Medecin findLoginMedecin(String login, String pwd)
    {
     Connection connexion;
     Statement ste;
     PreparedStatement pre;
     Medecin medecin;
        
     try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
              String req= "select * from fos_user where roles = 'a:1:{i:0;s:12:\"ROLE_MEDECIN\";}' and username = '"+login+"'";
             
              try {
            ResultSet res3 =  ste.executeQuery(req);
            if (res3.next()) {
             
               String pwdCrypted =  Cryptage.cypterPHP(pwd,res3.getString("salt"));
                if (pwdCrypted.equals(res3.getString("password")))
                {
                    String req2= "select * from personne where role = 'Medecin' and login = '"+ login+"'"; 
                    ResultSet res2 =  ste.executeQuery(req2);
                    if (res2.next()) {
                           medecin = new Medecin(
                       res2.getInt("salaire"),
                        res2.getString("specialite"),
                        res2.getInt("idpersonne"),
                        res2.getString("cin"),
                        res2.getString("nom"),
                        res2.getString("prenom"),
                        res2.getString("adresse"),
                        res2.getString("email"),
                        res2.getString("sexe"),
                        res2.getString("login"),
                        res2.getString("password"),
                        res2.getDate("datenaissance"),
                       res2.getString("avatar")
                );
                           
                            return medecin;
                    }
                }else
                {
                    System.out.println("Mot de passe incorrecte");
                      return null;
                }
            }else{
                    System.out.println("REQUETE");
                  return null;
            }
            
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
            return null;
        }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
               
               return null;
    }
}
