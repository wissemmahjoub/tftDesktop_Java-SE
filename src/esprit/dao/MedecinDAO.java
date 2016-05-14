/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;
import esprit.entite.Medecin;
import esprit.config.DBconnexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wissem
 */
public class MedecinDAO implements ICrudDAO<Medecin>{
    
    PreparedStatement pre;
    Connection cnx;
    Statement stmnt;
     public MedecinDAO()
     {
        try {
            cnx = DBconnexion.getConnexion();
            stmnt = cnx.createStatement();
            System.out.println("- Connected DB OK -  ");
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("----- Erreur Connexion base de données------");
        }
     }
 //################################################################
//################# AJOUTER     ###################################
//#################################################################  

    @Override
    public boolean save(Medecin m) {
  	 try {            
 String requette1 = "insert into personne (salaire ,specialite,cin,nom,prenom,adresse,email,sexe,login,password,datenaissance ,role,avatar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
           
           pre = cnx.prepareStatement(requette1);     
           pre.setFloat(1, m.getSalaire());
           pre.setString(2, m.getSpecialite());
           pre.setString(3, m.getCin());
           pre.setString(4, m.getNom());
           pre.setString(5, m.getPrenom());
           pre.setString(6, m.getAdresse());
           pre.setString(7, m.getEmail());
           pre.setString(8, m.getSexe());
           pre.setString(9, m.getLogin());
           pre.setString(10,m.getPassword()); 
           pre.setDate(11, (Date) m.getDatedestruction()); 
           pre.setString(12,"medecin"); 
           pre.setString(13,m.getAvatar()); 

       
           pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("--- Erreur Lors dajout du medecin ---------");
        }
        return false;
    }

    //###########################################################
//################# Modifier  ###################################
//###############################################################
    @Override
    public boolean update(Medecin m) {
        
        try {
            String req_modif="update personne set salaire=? "
                    + ",specialite=?"
                    + ",cin=?"
                    + ",nom=?"
                    + ",prenom=?"
                    + ",adresse=?"
                    + ",email=?"
                    + ",sexe=?"
                    + ",login=?"
                    + ",password=?"
                    + ",datenaissance=? "
                    + " where cin=?";
           
            PreparedStatement pre;
            pre = cnx.prepareStatement(req_modif);
        
           pre.setFloat(1, m.getSalaire());
           pre.setString(2, m.getSpecialite());
           pre.setString(3, m.getCin());
           pre.setString(4, m.getNom());
           pre.setString(5, m.getPrenom());
           pre.setString(6, m.getAdresse());
           pre.setString(7, m.getEmail());
           pre.setString(8, m.getSexe());
           pre.setString(9, m.getLogin());
           pre.setString(10,m.getPassword()); 
           pre.setDate(11, (Date) m.getDatenaissance()); 
           pre.setString(12, m.getCin());
            
          pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Medecin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUR MODIF medecin_DAO");
        }
        return false;
    }
    
    
    
    
//################################################################
//################# supprimer  ###################################
//################################################################
    @Override
    public boolean delete(Medecin m) {
         try {
         stmnt.executeUpdate(" UPDATE personne SET datedestruction  = now()  where cin='"+m.getCin()+"'");
        } catch (SQLException ex) {
         System.out.println(ex);
             System.out.println("erreur lors de suppression de medecin");
        }
        return false;
    }
//######################################################################
//################# Afficher Medecin ###################################
//######################################################################
    @Override
    public List<Medecin> getList() {
        List<Medecin> M = new ArrayList<>();
         
        String req4= "SELECT idpersonne,salaire ,specialite,cin,nom,prenom,adresse,email,sexe,login,password,datenaissance ,avatar FROM personne WHERE role = 'Medecin' and datedestruction is NULL";
        try {
            ResultSet res =  stmnt.executeQuery(req4);
            while (res.next()) {


  
               Medecin m = new Medecin(
                       res.getInt("salaire"),
                        res.getString("specialite"),
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
                       res.getString("avatar")
                );
              
               M.add(m);
             
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur daffichage medecin");
        }
       return M;
    }

    @Override
    public Medecin find(Medecin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    }


     
