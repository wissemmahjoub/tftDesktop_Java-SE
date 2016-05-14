/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

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
        
/**
 *
 * @author ASUS
 */
public class JoueurDAO implements ICrudDAO<Joueur>{
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
int a=0;
String b;
    public JoueurDAO() {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public boolean save(Joueur j) {
         try {
             // public Joueur(String tel, Date date_naiss, String role, int id_club, String niv, int id, int cin, String nom, String prenom, String adresse, String email, String sexe, String login, String pwd)
             //
             //
           
           String req1 = "insert into personne (cin,nom,prenom,adresse,email,sexe,login,password,datenaissance,section,role,idclub,niveau,avatar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
           pre = connexion.prepareStatement(req1);     
           
           pre.setString(1, j.getCin());
           pre.setString(2, j.getNom());
           pre.setString(3, j.getPrenom());
           pre.setString(4, j.getAdresse());
           pre.setString(5, j.getEmail());
           pre.setString(6, j.getSexe());
           pre.setString(7,j.getLogin());
           pre.setString(8,j.getPassword());
           pre.setDate(9,(java.sql.Date) j.getDatenaissance());
           pre.setString(10, j.getSection().toString());
           pre.setString(11, j.getRole());
           pre.setInt(12, j.getIdclub());
           pre.setString(13, j.getNiveau().toString());
           pre.setString(14, j.getAvatar());



            
            pre.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Federation Tunisienne de Tennis");

            alert.setHeaderText("");
            alert.setContentText("le joueur a été ajouté avec succès");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

   
    public boolean delete(Joueur j){
    
    Alert alert = new Alert(AlertType.WARNING, "Etes vous sur de vouloir supprimer ce joueur ?  " , ButtonType.YES, ButtonType.CANCEL);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    


     try {
         ste.executeUpdate(" UPDATE personne SET datedestruction = now()  where cin='"+j.getCin()+"'");
        } catch (SQLException ex) {
         System.out.println(ex);
        }
    
}
    
     else if (alert.getResult() == ButtonType.CANCEL)
             {
             }
    
    return true;
    
    }



    
    public boolean update(Joueur j){
    
    try {
        //select `idpersonne`, `cin`, `nom`, `prenom`, `adresse`, `email`, `sexe`, `login`, `password`, `datenaissance`, `salaire`, `specialite`, `experience`, `section`, `role`, `idclub`, `credit`, `nbrjeton`, `datedestruction`, `niveau`, `avatar` from personne
        
        
        
        String sql="update personne set nom=?,prenom=?,cin=?,niveau=?,datenaissance=?,idclub=?,adresse=?,email=?,sexe=?,section=? where cin=?";
            PreparedStatement ps;
            ps = connexion.prepareStatement(sql);
            ps.setString(1, j.getNom());
            ps.setString(2, j.getPrenom());
            ps.setString(3, j.getCin());
            ps.setString(4, j.getNiveau().toString());
            ps.setDate(5, (java.sql.Date)j.getDatenaissance());
            ps.setInt(6, j.getIdclub());
            ps.setString(7, j.getAdresse());
            ps.setString(8, j.getEmail());
            ps.setString(9, j.getSexe());
            ps.setString(10, j.getSection().toString());     
            ps.setString(11, j.getCin());
                 
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("------ ERREUURRRRRR ----------");
        }
    
    
    
    return true;
    
    }
    
   
    
    
//    public List<Joueur> getList(){
//       List<Joueur> LJoueur = new ArrayList<>();
//        Joueur j ;
//       
//        String req= "select * from personne where role = 'joueur' and datedestruction is null";
//    try {
//            ResultSet res =  ste.executeQuery(req);
//         
//            while (res.next()) {
//                // 
//             //public Joueur(Niveau niveau, TrancheAge section, int idclub, int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, Date datenaissance, String role, String avatar, Date datedestruction)
//             //
//               j= new Joueur(Niveau.valueOf(res.getString("niveau")),
//                       TrancheAge.valueOf(res.getString("section")),
//                        res.getInt("idclub"),
//                       res.getInt("idpersonne"),
//                       res.getString("cin"),
//                       res.getString("nom"),
//                       res.getString("prenom"),
//                       res.getString("adresse"),
//                       res.getString("email"),
//                       res.getString("sexe"),
//                       res.getString("login"),
//                       res.getString("password"),
//                       res.getDate("datenaissance"),
//                       res.getString("role"),
//                       res.getString("avatar"),
//                       res.getDate("datedestruction")
//               );
//               LJoueur.add(j);
//               System.out.println(j);
//            }
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return LJoueur;
//    
//    
//    }
    
        public Joueur find(Joueur j){ return j; }

        public int rechIdClubParNom (String nom)
        {
            String req ="select idclub from club where libelleclub='"+nom+"'";
            
        try {     
//            pre = connexion.prepareStatement(req);
//          pre.setString(1, nom);
              ste=connexion.createStatement();
                  ResultSet res = ste.executeQuery(req);

          while (res.next()) {
           a=res.getInt("idclub");
              System.out.println("le club ayant pout nom :  "+nom + "  est  :  "+a);
          
          }

        } catch (SQLException ex) {
            Logger.getLogger(JoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            return a;
        }
        
         public String rechnomclubparid(int id)
        {
            String req ="select libelleclub from club where idclub='"+id+"'";
            
        try {     
//            pre = connexion.prepareStatement(req);
//          pre.setString(1, nom);
              ste=connexion.createStatement();
                  ResultSet res = ste.executeQuery(req);

          while (res.next()) {
           b=res.getString("libelleclub");
          //    System.out.println("le club ayant pout nom :  "+nom + "  est  :  "+a);
          
          }

        } catch (SQLException ex) {
            Logger.getLogger(JoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            return b;
        }
        
        public List<Club> getClub(){
       List<Club> lclub = new ArrayList<>();
        Club c ;
       
        String req= "select * from club where datedestruction is null";
    try {
            ResultSet res =  ste.executeQuery(req);
         
            while (res.next()) {
                // 
     //   public Club(int idclub, String libellecode, String avatar, Date datecreation, Date datedestruction) 

             //
               c= new Club(
                        res.getInt("idclub"),
                       res.getString("libelleclub"),
                       res.getString("avatar"),
                       res.getDate("datecreation"),
                       res.getDate("datedestruction")
                      
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
                public List<Joueur> getList(){
                     List<Joueur> LJoueur = new ArrayList<>();
        Joueur j ;
       
        String req= "select idpersonne,personne.idclub,cin,nom,prenom,adresse,email,sexe,login,password,datenaissance,personne.datedestruction,section,libelleclub,role,personne.avatar,niveau from personne,club where personne.idclub=club.idclub and role = 'joueur' and personne.datedestruction is null";
    try {
            ResultSet res =  ste.executeQuery(req);
         
            while (res.next()) {
                // 
             //public Joueur(Niveau niveau, TrancheAge section, int idclub, int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, Date datenaissance, String role, String avatar, Date datedestruction)
             //
               j= new Joueur(Niveau.valueOf(res.getString("niveau")),
                       TrancheAge.valueOf(res.getString("section")),
                        res.getInt("idclub"),
                       res.getInt("idpersonne"),
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
                       res.getString("libelleclub")
               );
               LJoueur.add(j);
               System.out.println(j);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LJoueur;
    
}
}