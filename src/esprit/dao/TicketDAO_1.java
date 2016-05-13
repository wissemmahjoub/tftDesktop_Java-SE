/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.config.DBconnexion;
import esprit.entite.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wissem
 */
public class TicketDAO_1 implements ICrudDAO<Ticket>{
     private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;
   
    
   
    
    
     public TicketDAO_1()
    {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Ticket find(Ticket t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Ticket t) 
    {
          try {
             
    
           String req1 = "INSERT INTO `ticket` ( `nbrticket`, `prix`) VALUES (?,?);";
           pre = connexion.prepareStatement(req1);     
           pre.setInt(1, t.getNbrticket());
           pre.setFloat(2, t.getPrix());


           pre.execute();

        } catch (SQLException ex) {
              System.out.println(ex);
        }
        return false;
    }

  

    @Override
    public boolean delete(Ticket t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Ticket t) {
          try { 
            String req_modif="UPDATE `ticket` SET `nbrticket`=? ,`prix`=? WHERE `idticket` = ?";
           
            PreparedStatement pre;
            pre = connexion.prepareStatement(req_modif);
        
            pre.setInt(1,t.getNbrticket());
            pre.setFloat(2,t.getPrix());
            pre.setInt(3,t.getIdticket());
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUR MODIF TicketDAO");
        }
   return false; }

    @Override
    public List<Ticket> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    int x;
    
    public int id_dernier_Ticket() 
    {
    
         String req = "SELECT idticket FROM ticket ORDER BY idticket DESC LIMIT 1 ";
        try {
           
            ResultSet res =  ste.executeQuery(req);
            while (res.next())
            {
             x=  res.getInt("idticket");
            System.out.println("-------dernier Ticket selectionné avec succés----");
             
            }
        } catch (SQLException ex) {
            System.out.println("erreur de recuperation de dernierre ligne de ticket ");
        }
        
        return x;
        
        
    }

}
