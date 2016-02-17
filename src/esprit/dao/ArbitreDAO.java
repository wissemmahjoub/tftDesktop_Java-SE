/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;
import static java.lang.String.format;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import esprit.config.DBconnexion;
import esprit.entite.Arbitre;
import esprit.entite.Niveau;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Mustapha
 */
public class ArbitreDAO implements ICrudDAO<Arbitre>{
    
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
     public ArbitreDAO()
    {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Arbitre t) {
         try {
             // public Arbitre(int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, 
             //Date datenaissance, String role, String avatar, Date datedestruction,float salaire, int experience, Niveau niveau) 
             //
           String req1 = "insert into personne (nom,prenom,adresse,sexe,login,password,role,niveau,cin) VALUES (?,?,?,?,?,?,?,?,?) ";
           pre = connexion.prepareStatement(req1);     
           
           pre.setString(1, t.getNom());
           pre.setString(2, t.getPrenom());
           pre.setString(3, t.getAdresse());
           pre.setString(4, t.getSexe());
           pre.setString(5, t.getLogin());
           pre.setString(6, t.getPassword());
           pre.setString(7,"Arbitre");
           pre.setString(8, t.getNiveau().toString());
           pre.setString(9, t.getCin());
           
           pre.execute();
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Federation Tunisienne de Tennis");
    
    alert.setHeaderText("");
    alert.setContentText("L'arbitre a été ajouté avec succés");
    alert.showAndWait();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void delete(Arbitre t) {
         LocalDateTime timePoint = LocalDateTime.now(); 
         String format = "dd/MM/yyyy";
         System.out.println(timePoint.format(DateTimeFormatter.ISO_DATE));
         java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
       try {
            String req= "update personne set date_destruction =  '" + timePoint.format(DateTimeFormatter.ISO_DATE) +"' where cin ='"+t.getCin()+"' and role='Arbitre'" ; 
                    
                    //"
                    //+ " where cin="+t.getCin()+" and role= 'Arbitre';";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
         System.out.println(ex);
        }
    }

    @Override
    public List<Arbitre> getList() {
//        List<Arbitre> LArbitre = new ArrayList<>();
//        Arbitre arbitre ;
//       
//        String req= "select * from personne where role = 'Arbitre' and date_destruction is null";
//        try {
//            ResultSet res =  ste.executeQuery(req);
//           
//            while (res.next()) {
//                Niveau auxNiveau;
//               
//                if (  res.getString("niveau").equals(Niveau.Amateur.toString()))
//                {
//                    auxNiveau = Niveau.Amateur;
//                }else if (res.getString("niveau").equals(Niveau.International.toString()))
//                {
//                    auxNiveau = Niveau.International;
//                }else
//                {
//                     auxNiveau = Niveau.National;
//                }
//                
//                // public Arbitre(int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, 
//             //Date datenaissance, String role, String avatar, Date datedestruction,float salaire, int experience, Niveau niveau) 
//             //
//               arbitre= new Arbitre(res.getInt("idpersonne"),
//                       res.getString("cin"),
//                        res.getString("nom"),
//                res.getString("prenom"),
//                       res.getString("adresse"),
//                       res.getString("email"),
//                       res.getString("login"),
//                       res.getString("password"),
//                       res.getDate("datenaissance"),
//                       res.getString("role"),
//                       res.getString("avatar"),
//                       res.getString("datedestruction"),
//                       res.getString("salaire"),
//                       res.getInt("experience"),
//                      auxNiveau
//               );
//               LArbitre.add(arbitre);
//            }
//            
//        } catch (SQLException ex) {
//            
//        }
//        return LArbitre;
        return null;
    }

    @Override
    public void update(Arbitre t) {
        
        try {
            String req= "update personne set nom = '" + t.getNom()+"', prenom ='"
                    +t.getPrenom()+"', adresse = '"+t.getAdresse()+"',login='"+t.getLogin()+"',password='"+t.getPassword()+"'"+",niveau='"+t.getNiveau()+"'  where cin = '"+t.getCin()+"'";
                    
                    //"
                    //+ " where cin="+t.getCin()+" and role= 'Arbitre';";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
         //System.out.println(ex);
        }
        
    }

    @Override
    public Arbitre find(Arbitre t) {
//         Arbitre arbitre ;
//       
//        String req= "select * from personne where role = 'Arbitre' and date_destruction is null and login='"+t.getLogin()+"' ";
//            try {
//            ResultSet res =  ste.executeQuery(req);
//            if (res.next()) {
//               arbitre= new Arbitre(res.getString("nom"),
//                       res.getString("prenom"),
//                        res.getString("adresse"),
//                res.getString("sexe"),
//                       res.getString("cin"),
//                       res.getString("pwd"),
//                       res.getString("login"),
//                       res.getString("niveau"));
//               return arbitre;
//            }else{
//                return null;
//            }
//            
//        } catch (SQLException ex) {
//            return null;
//        } 
        return null;
    }
    
    
    
    
    
    
}
