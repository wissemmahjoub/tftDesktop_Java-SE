/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

/**
 *
 * @author CHAMS
 * 
 */
import esprit.config.DBconnexion;
import esprit.controllers.admin.FXMLAdminController;
import esprit.entite.Arbitre;
import esprit.entite.Club;
import esprit.entite.Joueur;
import esprit.entite.Niveau;
import esprit.entite.TrancheAge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class ClubDAO implements ICrudDAO <Club>{
     private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
int a=0;
String b;
    public ClubDAO() {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public boolean save(Club c) {
         try {
             //public Club(int idclub, String libellecode, String avatar, Date datecreation, Date datedestruction, String siege, String president, String tel) {

             //
             //
           
           String req1 = "insert into club (libelleclub,avatar,datecreation,siege,president,tel,video) VALUES (?,?,?,?,?,?,?)";
           pre = connexion.prepareStatement(req1);     
           
           pre.setString(1, c.getLibellecode());
           pre.setString(2, c.getAvatar());
           pre.setDate(3,(java.sql.Date) c.getDatecreation());
           pre.setString(4, c.getSiege());
           pre.setString(5, c.getPresident());
           pre.setString(6, c.getTel());
            pre.setString(7, c.getVideo());

            pre.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Federation Tunisienne de Tennis");

            alert.setHeaderText("");
            alert.setContentText("le club a été ajouté avec succès");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return true;
    }

   
    public boolean delete(Club c){
    
    Alert alert = new Alert(AlertType.WARNING, "Etes vous sur de vouloir supprimer ce Club ?  " , ButtonType.YES, ButtonType.CANCEL);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    


     try {
         ste.executeUpdate(" UPDATE club SET datedestruction = now()  where idclub='"+c.getIdclub()+"'");
        } catch (SQLException ex) {
         System.out.println(ex);
        }
    
}
    
     else if (alert.getResult() == ButtonType.CANCEL)
             {
             }
    
    return true;
    
    }



    
    public boolean update(Club c){
    
    try {
        
        
        
        String sql="update club set libelleclub=?,datecreation=?,siege=?,president=?,tel=? where idclub=?";
            PreparedStatement ps;
            ps = connexion.prepareStatement(sql);
            ps.setString(1, c.getLibellecode());
            ps.setDate(2, (java.sql.Date)c.getDatecreation());
            ps.setString(3, c.getSiege());
            ps.setString(4, c.getPresident());
            ps.setString(5, c.getTel());
            ps.setInt(6, c.getIdclub());
           
                 
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("------ ERREUURRRRRR ----------");
        }
    
    
    
    
    return true;
    }
    
   
    
    
    public List<Club> getList(){
       List<Club> lclub = new ArrayList<>();
        Joueur j ;
       
        String req= "select * from club where datedestruction is null";
    try {
            ResultSet res =  ste.executeQuery(req);
         
            while (res.next()) {
                // 
 // public Club(int idclub, String libellecode, String avatar, Date datecreation, Date datedestruction, String siege, String president, String tel) {

             //
               Club c= new Club(
                        res.getInt("idclub"),
                       res.getString("libelleclub"),
                       res.getString("avatar"),
                       res.getDate("datecreation"),
                       res.getDate("datedestruction"),
                       res.getString("siege"),
                       res.getString("president"),
                       res.getString("tel"),
                       res.getString("video")
               );
               lclub.add(c);
               System.out.println(c);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lclub;
    
    
    }
    

    @Override
    public Club find(Club c) {
        return c;
    }

    
}
