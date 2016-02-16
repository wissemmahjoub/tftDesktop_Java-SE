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
public class Medecin extends Personne {
    
        private float salaire;
        private String specialite;

    public Medecin() {

    }

    public Medecin(float salaire, String specialite, int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, Date datenaissance, String role, String avatar, Date datedestruction) {
        super(idpersonne, cin, nom, prenom, adresse, email, sexe, login, password, datenaissance, role, avatar, datedestruction);
        this.salaire = salaire;
        this.specialite = specialite;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return super.toString() + "Medecin{" + "salaire=" + salaire + ", specialite=" + specialite + '}';
    }
      
    
        
}
