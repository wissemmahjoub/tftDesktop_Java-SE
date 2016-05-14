/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.config.DBconnexion;
import esprit.entite.Cible;
import esprit.entite.Niveau;
import esprit.entite.SessionFormation;
import esprit.entite.Stade;
import esprit.entite.Surface;
import esprit.entite.TrancheAge;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;

/**
 *
 * @author yasmi
 */
public class SessionFormationDAO implements ICrudDAO<SessionFormation>, ISessionFormation<SessionFormation>{

    private static Connection con;
    private static Statement stat;
    private List<SessionFormation> data;

    public SessionFormationDAO() {
        
        try {
               con = DBconnexion.getConnexion();
               stat = con.createStatement();
            } catch (SQLException ex) {
            Logger.getLogger(SessionFormationDAO.class.getName()).log(Level.SEVERE, null, ex);
                                      }
                                 }
    
    
    
    @Override
    public SessionFormation find(SessionFormation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(SessionFormation t) {
        
        PreparedStatement prep;
        try {
            String req = "insert into sessionformation (libellesession,lieu,datedebut,datefin,cible,capacite,niveau,section) values (?,?,?,?,?,?,?,?)";
            prep = con.prepareStatement(req);
            prep.setString(1, t.getLibellesession());
            prep.setString(2, t.getLieu());
            prep.setDate(3, (Date)t.getDatedebut());
            prep.setDate(4, (Date)t.getDatefin());
            prep.setString(5, t.getCible().name());
            prep.setInt(6, t.getCapacite()); 
            prep.setString(7, t.getNiveau().name());
            prep.setString(8,t.getSection().name());


            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SessionFormationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(SessionFormation t) {
        try {
              stat.executeUpdate("update sessionformation set datedestruction = now() where idsession=" + t.getIdsession());

        } catch (SQLException ex) {
            Logger.getLogger(SessionFormationDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    @Override
    public boolean update(SessionFormation t) {
        PreparedStatement prep; 
      //int result = 0 ;
        try {
    
            prep = con.prepareStatement("update sessionformation set libellesession = ?,lieu = ?, datedebut = ?, datefin = ?, capacite = ? where idsession=" + t.getIdsession());
         
            System.out.println("MODIF ID session est" +t.getIdsession());
            System.out.println("MODIF libelle" +t.getLibellesession());
            
            prep.setString(1, t.getLibellesession());
            prep.setString(2, t.getLieu());
            prep.setDate(3, (Date) t.getDatedebut());
            prep.setDate(4, (Date) t.getDatefin());
            prep.setInt(5, t.getCapacite());

            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(SessionFormationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return result==1;
        return false;
    }

    @Override
    public List<SessionFormation> getList() {
        try {

            data = FXCollections.observableArrayList();
            ResultSet res = stat.executeQuery("select * from sessionformation where datedestruction IS NULL AND cible='Arbitre'");
            while (res.next()) {
                data.add(new SessionFormation(
                        res.getInt("idsession"),
                        res.getString("libellesession"),                       
                        res.getString("lieu"),
                        res.getDate("datedebut"),
                        res.getDate("datefin"),
                        res.getInt("capacite"),                                   
                        Niveau.valueOf(res.getString("niveau"))     
                                 ));
                        System.out.println(res.getInt("idsession"));
                        System.out.println(res.getString("libellesession"));
                                }

        } catch (SQLException ex) {
            Logger.getLogger(SessionFormationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public List<SessionFormation> getListJoueurs() {
        try {

            data = FXCollections.observableArrayList();
            ResultSet res = stat.executeQuery("select * from sessionformation where datedestruction IS NULL AND cible='Joueur'");
            while (res.next()) {
                data.add(new SessionFormation(
                        res.getInt("idsession"),
                        res.getString("libellesession"),                       
                        res.getString("lieu"),
                        res.getDate("datedebut"),
                        res.getDate("datefin"),
                        res.getInt("capacite"),                                   
                        TrancheAge.valueOf(res.getString("section"))     
                                 ));
                        System.out.println(res.getInt("idsession"));
                        System.out.println(res.getString("libellesession"));
                                }

        } catch (SQLException ex) {
            Logger.getLogger(SessionFormationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    
}
}
