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
public class Employe extends Personne {
 
    private Fonction fonction;

    public Employe() {

    }

    public Employe(Fonction fonction, int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, Date datenaissance, String role, String avatar, Date datedestruction) {
        super(idpersonne, cin, nom, prenom, adresse, email, sexe, login, password, datenaissance, role, avatar, datedestruction);
        this.fonction = fonction;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return super.toString() + "Employe{" + "fonction=" + fonction + '}';
    }
    
    
    
}
