/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.config.DBconnexion;
import esprit.entite.Joueur;
import esprit.entite.Test;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author wissem
 */
public class TestDAO implements ICrudDAO<Test>{
    
     
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
     
    
    
  public TestDAO()
    {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
int x;
    
    public int id_dernier_test() 
    {
    
         String req = "SELECT idtest FROM test ORDER BY idtest DESC LIMIT 1 ";
        try {
           
            ResultSet res =  ste.executeQuery(req);
            while (res.next())
            {
             x=  res.getInt("idtest");
            System.out.println("-------dernier test selectionné avec succés----");
             
            }
        } catch (SQLException ex) {
            System.out.println("erreur de recuperation de dernierre ligne de test ");
        }
        
        return x;
        
        
    }

    @Override
    public boolean  save(Test t) {
        try {
             
           String req1 = "insert into test (libelletest,datetest)VALUES (?,?)";
           pre = connexion.prepareStatement(req1);     
           pre.setString(1, t.getLibelletest());
           pre.setDate(2, (Date) t.getDatetest());
           pre.executeUpdate();
       
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Federation Tunisienne de Tennis");
    
    alert.setHeaderText("");
    alert.setContentText("Le Test a été ajouté avec succés");
    alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println("########### Erreur D_insertion ########");
        }
        return false;
    }

    @Override
    public boolean  delete(Test t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean  update(Test t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Test> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Test find(Test t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    }
    

