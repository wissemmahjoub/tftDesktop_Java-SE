/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import static java.lang.String.format;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import esprit.config.DBconnexion;
import esprit.controllers.outils.Cryptage;
import esprit.entite.Arbitre;
import esprit.entite.Niveau;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Mustapha
 */
public class ArbitreDAO implements ICrudDAO<Arbitre> {

    private Connection connexion;
    private Statement ste;
    private PreparedStatement pre;

    public ArbitreDAO() {
        try {
            connexion = DBconnexion.getConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean save(Arbitre t) {
        try {
             // public Arbitre(int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, 
            //Date datenaissance, String role, String avatar, Date datedestruction,float salaire, int experience, Niveau niveau) 
            //
            LocalDateTime timePoint = LocalDateTime.now();
            String format = "dd/MM/yyyy";
            System.out.println(timePoint.format(DateTimeFormatter.ISO_DATE));
            java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
            String req1 = "insert into personne (nom,prenom,adresse,sexe,login,password,role,niveau,cin,idpersonne,avatar) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
            String reqTofos = "insert into fos_user (username,username_canonical,email,email_canonical,enabled,salt,password,last_login,locked,expired,expires_at,confirmation_token,password_requested_at,roles,credentials_expired,credentials_expire_at,nom,prenom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            pre = connexion.prepareStatement(reqTofos);
            pre.setString(1, t.getLogin());
            pre.setString(2, t.getCin());
            pre.setString(3, "arbitre." + t.getLogin() + "@gmail.com");
            pre.setString(4, "arbitre." + t.getLogin() + "@gmail.com");
            pre.setInt(5, 1);
            pre.setString(6, "abcd");
            pre.setString(7, Cryptage.cypterPHP(t.getPassword(), "abcd"));
            pre.setInt(8, 0);
            pre.setInt(9, 0);
            pre.setInt(10, 0);
            pre.setDate(11, null);

            pre.setString(12, "");
            pre.setDate(13, null);
            pre.setString(14, "a:1:{i:0;s:12:\"ROLE_ARBITRE\";}");
            pre.setInt(15, 0);
            pre.setDate(16, null);

            pre.setString(17, t.getNom());
            pre.setString(18, t.getPrenom());
            pre.execute();

            pre = connexion.prepareStatement(req1);

            pre.setString(1, t.getNom());
            pre.setString(2, t.getPrenom());
            pre.setString(3, t.getAdresse());
            pre.setString(4, t.getSexe());
            pre.setString(5, t.getLogin());
            pre.setString(6, t.getPassword());
            pre.setString(7, "Arbitre");
            pre.setString(8, t.getNiveau().toString());
            pre.setString(9, t.getCin());
            pre.setInt(10, t.getIdpersonne());
            pre.setString(11, t.getAvatar());
            pre.execute();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Federation Tunisienne de Tennis");

            alert.setHeaderText("");
            alert.setContentText("L'arbitre a été ajouté avec succés");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Arbitre t) {
        LocalDateTime timePoint = LocalDateTime.now();
        String format = "dd/MM/yyyy";
        System.out.println(timePoint.format(DateTimeFormatter.ISO_DATE));
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
        try {
            String req = "update personne set datedestruction =  '" + timePoint.format(DateTimeFormatter.ISO_DATE) + "' where cin ='" + t.getCin() + "' and role='Arbitre'";
            String reqFos = "delete from fos_user where username = '"+t.getLogin()+"'";
           
            ste.executeUpdate(reqFos);
            ste.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Arbitre> getList() {
        List<Arbitre> LArbitre = new ArrayList<>();
        Arbitre arbitre;

        String req = "select * from personne where role = 'Arbitre' and datedestruction is null";
        try {
            ResultSet res = ste.executeQuery(req);

            while (res.next()) {
                // public Arbitre(int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, 
                //Date datenaissance, String role, String avatar, Date datedestruction,float salaire, int experience, Niveau niveau) 
                //
                arbitre = new Arbitre(res.getInt("idpersonne"),
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
                        res.getFloat("salaire"),
                        res.getInt("experience"),
                        Niveau.valueOf(res.getString("niveau"))
                );
                LArbitre.add(arbitre);
                System.out.println(arbitre);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LArbitre;
    }

    @Override
    public boolean update(Arbitre t) {

        try {
            String req = "update personne set nom = '" + t.getNom() + "', prenom ='"
                    + t.getPrenom() + "', email = '" + t.getEmail() + "',login='" + t.getLogin() + "',password='" + t.getPassword() + "'" + ",niveau='" + t.getNiveau().toString() + "'  where cin = '" + t.getCin() + "'";
             String reqTofos = "update  fos_user set username = '"+t.getLogin()+"', password='"+Cryptage.cypterPHP(t.getPassword(), "abcd")+"' where nom = '"+t.getCin()+"'";

                    //"
            //+ " where cin="+t.getCin()+" and role= 'Arbitre';";
             
            ste.executeUpdate(reqTofos);
            ste.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public Arbitre find(Arbitre t) {
        Arbitre arbitre;

        String req = "select * from personne where role = 'Arbitre' and datedestruction is null and login='" + t.getLogin() + "' ";
        try {
            ResultSet res = ste.executeQuery(req);
            if (res.next()) {
                arbitre = new Arbitre(res.getInt("idpersonne"),
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
                        res.getFloat("salaire"),
                        res.getInt("experience"),
                        Niveau.valueOf(res.getString("niveau"))
                );
                return arbitre;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }
    }

}
