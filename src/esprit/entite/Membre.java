/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entite;

import java.util.Date;

/**
 *
 * @author yasmi
 */
public class Membre extends Personne {
    
    private float credit;
    private int nbrjeton;

    public Membre() {

    }

    public Membre(float credit, int nbrjeton, int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, Date datenaissance, String role, String avatar, Date datedestruction) {
        super(idpersonne, cin, nom, prenom, adresse, email, sexe, login, password, datenaissance, role, avatar, datedestruction);
        this.credit = credit;
        this.nbrjeton = nbrjeton;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public int getNbrjeton() {
        return nbrjeton;
    }

    public void setNbrjeton(int nbrjeton) {
        this.nbrjeton = nbrjeton;
    }

    @Override
    public String toString() {
        return super.toString() + "Membre{" + "credit=" + credit + ", nbrjeton=" + nbrjeton + '}';
    }
    
    
}
