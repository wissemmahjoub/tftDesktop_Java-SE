/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.config.DBconnexion;
import esprit.entite.Club;
import esprit.entite.Evenement;
import esprit.entite.Joueur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author ASUS
 */

public class EventDAO implements ICrudDAO<Evenement>{
  private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
    public EventDAO() {
         try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    @Override
    public Evenement find(Evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Evenement e) {
        
        
   String req1 = "insert into evenement (libelle,lieu,datedebut,datefin,video) VALUES (?,?,?,?,?)";
try {
        pre = connexion.prepareStatement(req1);     
           
           pre.setString(1, e.getLibelle());
           pre.setString(2, e.getLieu());
           pre.setDate(3,(java.sql.Date) e.getDatedebut());
           pre.setDate(4,(java.sql.Date) e.getDatefin());
           pre.setString(5, e.getVideo());

           
            pre.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Federation Tunisienne de Tennis");

            alert.setHeaderText("");
            alert.setContentText("l'evenement a été ajouté avec succès");
            alert.showAndWait();
           
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Evenement e) {
         Alert alert = new Alert(Alert.AlertType.WARNING, "Etes vous sur de vouloir supprimer ce Club ?  " , ButtonType.YES, ButtonType.CANCEL);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    


     try {
         ste.executeUpdate(" UPDATE evenement SET datedestruction = now()  where idevenement='"+e.getIdevenement()+"'");
        } catch (SQLException ex) {
         System.out.println(ex);
        }
    
}
    
     else if (alert.getResult() == ButtonType.CANCEL)
             {
             }
    return true;
    }

    @Override
    public boolean update(Evenement t) {
        return true;
    }

    @Override
    public List<Evenement> getList() {
       List<Evenement> levent = new ArrayList<>();
       // Evenement e ;
       
        String req= "select * from evenement where datedestruction is null";
    try {
            ResultSet res =  ste.executeQuery(req);
         
            while (res.next()) {
                // 
        //    public Evenement(int idevenement, String libelle, String lieu, Date datedebut, Date datefin, Date datedestruction) {


             //
               Evenement e= new Evenement(
                        res.getInt("idevenement"),
                       res.getString("libelle"),
                       res.getString("lieu"),
                       res.getDate("datedebut"),
                       res.getDate("datefin"),
                       res.getDate("datedestruction"),
                       res.getString("video")
                      );
               levent.add(e);
               System.out.println(e);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return levent;
    
    
    }
    }
    

