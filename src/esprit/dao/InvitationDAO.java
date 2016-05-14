/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.config.DBconnexion;
import esprit.entite.Invitation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import esprit.entite.Joueur;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wissem
 */
public class InvitationDAO implements ICrudDAO<Invitation>{

    private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
    TestDAO ttDao = new TestDAO();
    
     public InvitationDAO()
    {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Invitation find(Invitation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Invitation t) {
       try {
             
           String req1 = "insert into invitation (idtest_invitation,idjoueur,dateinvitation)VALUES (?,?,NOW())";
          
           pre = connexion.prepareStatement(req1);   
           
           pre.setInt(1, ttDao.id_dernier_test());
           pre.setInt(2, t.getIdjoueur());
        
           pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("########### Erreur D_insertion ###erreur DAO#####");
        }
        return false;
       
 
    }
    
    @Override
    public boolean  delete(Invitation t) {
        return false;
       
    }

    @Override
    public boolean  update(Invitation t) {
         try {
             
          String req2="update personne t, invitation i set  t.etat_invit = '1' where t.idpersonne=i.idjoueur";
          
           pre = connexion.prepareStatement(req2);   

           pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("########### Erreur modification ########");
        }
        return false;
    }
//############## LISTE Joueur invités ########################################"
    
    @Override
    public List<Invitation> getList(){
    return null;
    }
    
    public List<Joueur> getListinviteee(){
  List<Joueur> jinvite = new ArrayList<>();
    String req= "SELECT idpersonne,cin , nom , prenom from invitation I , personne P where I.idjoueur=P.idpersonne and P.datedestruction is NULL";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
             
               Joueur joueurrr = new Joueur(
                        res.getInt("idpersonne"),
                        res.getString("cin"),
                        res.getString("nom"),
                        res.getString("prenom")
                );
               jinvite.add(joueurrr);
              
               
   System.out.println("------- Liste joueurs invités electionné avec succés----");
             
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : getListinviteee()------");
        }
        return jinvite;
       
    }
    
    //################### methode liste_joueur_hasard#############################
    public  List<Joueur>liste_joueur_hasard()
    {
    List<Joueur> j = new ArrayList<>();
    String req= "SELECT idpersonne,cin,nom,prenom FROM personne  WHERE datedestruction is NULL and role = 'Joueur' and etat_invit is NULL ORDER BY rand() LIMIT 3 ";
        try {
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {
              
               Joueur Jhasard = new Joueur(
                        res.getInt("idpersonne"),
                        res.getString("cin"),
                        res.getString("nom"),
                        res.getString("prenom")
                );
               j.add(Jhasard);
               
   System.out.println("------- joueurs par hasard selectionné avec succés----");
             
            }
            
        } catch (SQLException ex) {
            System.out.println("----------Erreur lors methode : liste_joueur_hasard()------");
        }
        return j;
    }
    
    
    
}
