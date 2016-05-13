/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import esprit.config.DBconnexion;
import esprit.entite.Categorie;

import esprit.entite.Competition;
import esprit.entite.Niveau;
import esprit.entite.TrancheAge;

/**
 *
 * @author malox94
 */
public class CompetitionDAO implements ICrudDAO<Competition>{
    
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
     public CompetitionDAO()
    {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CompetitionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean save(Competition t) {
  try {
            String req1 = "insert into competition (libelle,datedebut,datefin,niveau,categorie,type,nbrpoints) VALUES (?,?,?,?,?,?,?)";
                    pre = connexion.prepareStatement(req1);
                    
      
            pre.setString(1, t.getLibelle());
            pre.setDate(2, (Date) t.getDatedebut());
            pre.setDate(3, (Date) t.getDatefin());
            pre.setString(4, t.getNiveau().toString());
            pre.setString(5, t.getCategorie().toString());
             pre.setString(6, t.getType().toString());
            pre.setInt(7, t.getNbrpoint());
            pre.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetitionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return true;}

    @Override
    public boolean delete(Competition t) {
   try {
    
            String req3= "update competition set datedestruction = now() where idcompetition like '" + t.getIdcompetition() + "'";
            ste.executeUpdate(req3);
        } catch (SQLException ex) {
         System.out.println(ex);
        }   
    return true;}


        @Override
    public boolean update(Competition c) {
        
        try { 
            String req_modif="update competition set "
                    + "libelle=? "
                    + ",datedebut=? "
                    + ",datefin=? "
                    + ",niveau=? "
                    + ",categorie=? "
                    + ",type=? "
                    + ",nbrpoints=?"
                    + " where idcompetition=?";
           
            PreparedStatement pre;
            pre = connexion.prepareStatement(req_modif);
        
            pre.setString(1,c.getLibelle());
            pre.setDate(2, (Date) c.getDatedebut());
            pre.setDate(3, (Date) c.getDatefin());
            pre.setString(4, c.getNiveau().toString());
            pre.setString(5, c.getCategorie().toString());
            pre.setString(6, c.getType().toString());
            pre.setInt(7, c.getNbrpoint());
           pre.setInt(8, c.getIdcompetition());
          
            
          pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUR MODIF COmpertitionDAO");
        }
        return false;
    }
    
    
    @Override
    public List<Competition> getList() {
   List<Competition> ListCompetition = new ArrayList<>();
        Competition co ;
        String req4= "select idcompetition,libelle,type,datedebut,datefin,niveau,categorie,nbrpoints from competition where datedestruction is null";
        try {
            
            ResultSet res =  ste.executeQuery(req4);
           
              while (res.next()) {
               co= new Competition(
               res.getInt("idcompetition"),
               res.getString("libelle"),
               TrancheAge.valueOf(res.getString("type")),
               res.getDate("datedebut"),
               res.getDate("datefin"),
               Niveau.valueOf(res.getString("niveau")),
               Categorie.valueOf(res.getString("categorie")),
               res.getInt("nbrpoints"));
               ListCompetition.add(co);
               
            }
     
           
        } catch (SQLException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la select de liste compettion");
        }
      
        return  ListCompetition; }

    
    
    
    
     public List<Competition> getListCompetition(String ch, Date x) {
   List<Competition> ListCompetition = new ArrayList<>();
        Competition co ;
        String req4= "select idcompetition,libelle,datedebut,datefin,type,niveau,categorie,nbrpoints from competition where datedestruction is null and libelle like '"+ ch + "' and datedebut like '" + x + "'"  ;
        try {
            
            ResultSet res =  ste.executeQuery(req4);
           
              while (res.next()) {
               co= new Competition(
              res.getInt("idcompetition"),
               res.getString("libelle"),
               TrancheAge.valueOf(res.getString("type")),
               res.getDate("datedebut"),
               res.getDate("datefin"),
               Niveau.valueOf(res.getString("niveau")),
               Categorie.valueOf(res.getString("categorie")),
               
               res.getInt("nbrpoints"));
               ListCompetition.add(co);
               
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return  ListCompetition; }
    
    
    @Override
    public Competition find(Competition t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
     public void DeleteCompetition(String ch, Date x) {
   try { 
            String req_modif="DELETE FROM `competition` WHERE libelle= '"+ch+"' AND datedebut ='"+x+"'";
           
            PreparedStatement pre;
            pre = connexion.prepareStatement(req_modif);
  
          pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUR DeletCompetition");
        }
      
    }
    
     
  
  
}
