/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import esprit.config.DBconnexion;
import esprit.entite.Arbitre;
import esprit.entite.Categorie;
import esprit.entite.Competition;
import esprit.entite.Evenement;
import esprit.entite.Joueur;
import esprit.entite.Match;
import esprit.entite.Niveau;
import esprit.entite.Stade;
import esprit.entite.TrancheAge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author wissem
 */
public class MatchDAO implements ICrudDAO<Match>{
    
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
 
   
    
   
    
    
     public MatchDAO()
    {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @Override
    public Match find(Match M) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return null;
    }

    
    @Override
    public boolean save(Match M) {
          try {
             

           String req1 = "INSERT INTO `match` ( `idjoueur1`, `idjoueur2`,`idcompetition`, `idarbitre`, `idevenement`, `idstade`, `datematch`,`niveau`,`type`,`categorie`,`idticket`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
           pre = connexion.prepareStatement(req1);     
           pre.setInt(1, M.getIdjoueur1());
           pre.setInt(2, M.getIdjoueur2());
           pre.setInt(3, M.getIdcompetition());
           pre.setInt(4, M.getIdarbitre());
           pre.setInt(5, M.getIdevenement());
           pre.setInt(6,M.getIdstade());
           pre.setDate(7,(java.sql.Date) M.getDatematch());
           pre.setString(8,M.getNiveau().toString());
           pre.setString(9,M.getType().toString());
            pre.setString(10,M.getCategorie().toString());
           pre.setInt(11,M.getIdticket());

           pre.execute();
//   
        } catch (SQLException ex) {
              System.out.println(ex);
              System.out.println("erreur dajout match ");
        }
        return false;
    }

    @Override
    public boolean delete(Match t) {
        return false;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Match t) {
        return false;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Match> getList() {
    List<Match> M = new ArrayList<>();
         
     
     
        String req4= "SELECT `idmatch`, `idjoueur1`, `idjoueur2`, `categorie`, `idcompetition`, `idarbitre`, `idevenement`, `idstade`, `datematch`, `niveau`, `type`, `idscore`, `idticket` FROM `match` WHERE `datedestruction` is NULL ";
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {

               Match m = new Match
                (
                        res.getInt("idmatch"),
                        res.getInt("idjoueur1"),
                        res.getInt("idjoueur2"),
                        res.getInt("idcompetition"),
                        res.getInt("idarbitre"),
                        res.getInt("idevenement"),
                        res.getInt("idstade"),
                        res.getDate("datematch"),
                        Niveau.valueOf(res.getString("niveau")),
                        TrancheAge.valueOf(res.getString("type")),
                        Categorie.valueOf(res.getString("categorie")),
                        res.getInt("idscore"),
                        res.getInt("idticket")
                );
              
               M.add(m);
             
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println("erreur affichage match ");
        }
      
        return M;
    }
     
      //--------------------------------------------------------------------------
     //************************** Stade ***************************************** 
     //--------------------------------------------------------------------------
    public List<Competition> List_Competition_ForComboBox()
   {
       
    List<Competition> c = new ArrayList<>();
    String req= "SELECT * FROM competition  WHERE datedestruction is NULL";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
               Competition com = new Competition(
                       res.getInt("idcompetition"),
                       res.getString("libelle"),
                       res.getDate("datedebut"),
                       res.getDate("datefin"),
                       res.getInt("nbrpoints"),
                       res.getDate("datedestruction")
                );
               c.add(com);
               
   System.out.println("------- Competition selectionné avec succés----");
             
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : List_Competition_ForComboBox()------");
        }
        return c;
      
}
       //--------------------------------------------------------------------------
     //************************** GetIdByCin ***************************************** 
     //--------------------------------------------------------------------------
            public int GetIdByName (int cinn)
        {
            String req ="select idpersonne from personne where cin='"+cinn+"'";
            int a=0;
        try {     

              ste=connexion.createStatement();
              ResultSet res = ste.executeQuery(req);
                 while (res.next()) {
              a=res.getInt(1);
             
          
          }
        
          
             
    

        } catch (SQLException ex) {
            Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            return a;
        }
     //--------------------------------------------------------------------------
     //************************** Stade ***************************************** 
     //--------------------------------------------------------------------------
    public List<Stade> List_stade_ForComboBox()
   {
       //Niveau.valueOf(res.getString("niveau")),
       //ps.setString(4, j.getNiveau().toString());
    List<Stade> Sta = new ArrayList<>();
    String req= "SELECT * FROM stade  WHERE datedestruction is NULL";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
               Stade St = new Stade(
                        res.getInt("idstade"),
                        res.getString("libellestade"),
                        res.getString("avatar"),
                        res.getString("ville"),
                        res.getInt("capacite"),
                        res.getDate("datecreation"),
                        res.getDate("datedestruction")
                );
               Sta.add(St);
               
   System.out.println("------- Stade selectionné avec succés----");
             
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : List_stade()------");
        }
        return Sta;
      
}
     //--------------------------------------------------------------------------
     //************************** Evenement ***************************************** 
     //--------------------------------------------------------------------------
    
    public List<Evenement> List_evenementForComboBox() 
   {
    List<Evenement> Evenn = new ArrayList<>();
    String req= "SELECT * FROM evenement  WHERE datedestruction is NULL   ";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
            
               Evenement Ev = new Evenement(
                        res.getInt("idevenement"),
                        res.getString("libelle"),
                        res.getString("lieu"),
                        res.getDate("datedebut"),
                        res.getDate("datefin"),
                        res.getDate("datedestruction")
                );
               Evenn.add(Ev);
               
   System.out.println("------- Evenement selectionné avec succés----");
             
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : List_evenement()------");
        }
        return Evenn;
      
}
    
    
     //--------------------------------------------------------------------------
     //************************** Arbitre ***************************************** 
     //--------------------------------------------------------------------------
    
    public List<Arbitre> List_ArbitresForComboBox() 
   {
    List<Arbitre> Arbi = new ArrayList<>();
    String req= "SELECT * FROM personne  WHERE datedestruction is NULL and role = 'arbitre'  ";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
// public Arbitre(Niveau niveau, int idpersonne, String cin, String nom, String prenom)             
               Arbitre ar = new Arbitre(
                        res.getInt("idpersonne"),
                        res.getString("cin"),
                        res.getString("nom"),
                        res.getString("prenom")
                );
               Arbi.add(ar);
               
   System.out.println("------- arbitre selectionné avec succés----");
             
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : List_Arbitres()------");
        }
        return Arbi;
      
}
    
    //###################### Listes Joueurs [homme/femme/tous]####################################################""
   
     //--------------------------------------------------------------------------
     //************************** Homme ***************************************** 
     //--------------------------------------------------------------------------
    
    public List<Joueur> List_Joueur_HommesForComboBox() 
   {
    List<Joueur> j = new ArrayList<>();
    String req= "SELECT * FROM personne  WHERE datedestruction is NULL and role = 'joueur' and sexe='homme'  ";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
               
               Joueur Jou = new Joueur(
                        res.getInt("idpersonne"),
                        res.getString("cin"),
                        res.getString("nom"),
                        res.getString("prenom")
                );
               j.add(Jou);
               
   System.out.println("------- joueurs selectionné avec succés----");
             
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : List_Joueur_Hommes()------");
        }
        return j;
      
}
     //--------------------------------------------------------------------------
     //************************** femme ***************************************** 
     //--------------------------------------------------------------------------
    public List<Joueur> List_Joueur_FemmesForComboBox() 
   {
    List<Joueur> j = new ArrayList<>();
    String req= "SELECT * FROM personne  WHERE datedestruction is NULL and role = 'joueur' and sexe='femme'  ";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
               Joueur Jou = new Joueur(
                        res.getInt("idpersonne"),
                        res.getString("cin"),
                        res.getString("nom"),
                        res.getString("prenom")
                );
               j.add(Jou);       
   System.out.println("------- joueurs femme selectionné avec succés----");
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : List_Joueur_Femmes()------");
        }
        return j;
      
}

 
     //--------------------------------------------------------------------------
     //************************** tous ***************************************** 
     //--------------------------------------------------------------------------
    public List<Joueur> List_ALL_JoueurForComboBox() 
   {
    List<Joueur> j = new ArrayList<>();
    String req= "SELECT * FROM personne  WHERE datedestruction is NULL and role = 'joueur' ";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
               Joueur Jou = new Joueur(
                        res.getInt("idpersonne"),
                        res.getString("cin"),
                        res.getString("nom"),
                        res.getString("prenom")
                );
               j.add(Jou);       
   System.out.println("------- joueurs  selectionné avec succés----");
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : List_ALL_Joueur()------");
        }
        return j;
      
}   
    
    
}
