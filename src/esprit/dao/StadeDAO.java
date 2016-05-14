/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.dao.*;
import esprit.config.DBconnexion;
import esprit.entite.Stade;
import esprit.entite.Surface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 *
 * @author yasmi
 */
public class StadeDAO implements ICrudDAO<Stade> {

    private static Connection con;
    private static Statement stat;
    private List<Stade> data;

    public StadeDAO() {

        try {
               con = DBconnexion.getConnexion();
               stat = con.createStatement();
            } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
                                      }

                       }

    @Override
    public boolean save(Stade t) {

        PreparedStatement prep;
        try {
            String req = "insert into stade (libellestade,latitude,longitude,ville,capacite,surface,datecreation) values (?,?,?,?,?,?,?)";
            prep = con.prepareStatement(req);
            

            System.out.println("MODIF ID stade est"+t.getIdstade());
            
            prep.setString(1, t.getLibellestade());
            prep.setFloat(2, t.getLatitude());
            prep.setFloat(3, t.getLongidute());
            prep.setString(4, t.getVille());
            prep.setInt(5, t.getCapacite());
            prep.setString(6, t.getSurface().name());
            prep.setDate(7, (Date) t.getDatecreation());

            
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Stade t) {

        try {
              stat.executeUpdate("update stade set datedestruction = now() where idstade=" + t.getIdstade());
              
              
            System.out.println("SUPP ID stade est"+t.getIdstade());
        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public List<Stade> getList() {

        try {

            data = FXCollections.observableArrayList();
            //String nom = Surface.class.getName();
            ResultSet res = stat.executeQuery("select * from stade where datedestruction is null");
            while (res.next()) {
                data.add(new Stade(
                        res.getInt("idstade"),
                        res.getString("libellestade"),
                        res.getFloat("latitude"),
                        res.getFloat("longitude"),
                        res.getString("ville"),
                        res.getInt("capacite"),
                        Surface.valueOf(res.getString("surface")),
                        res.getDate("datecreation")
                ));
                    
            }

        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public Stade find(Stade t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Stade t) {
        
      PreparedStatement prep; 
      //int result = 0 ;
        try {
    
            prep = con.prepareStatement("update stade set libellestade = ?,capacite = ?, surface = ? where idstade=" + t.getIdstade());
         
            System.out.println("MODIF ID stade est" +t.getIdstade());
            System.out.println("MODIF libelle" +t.getLibellestade());
            
            prep.setString(1, t.getLibellestade());
            prep.setInt(2, t.getCapacite());
            prep.setString(3, t.getSurface().name());

            prep.execute();
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return result==1;
        return false;

    }

    public Integer find(String t) throws SQLException {

       String sql = "select * from stade where libellestade = ?";
       PreparedStatement preparedStatement = con.prepareStatement(sql);
       preparedStatement.setString(1, t);
        Stade stade = new Stade();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
           stade.setIdstade(resultSet.getInt(1));
        }

        return stade.getIdstade();
    }



}
