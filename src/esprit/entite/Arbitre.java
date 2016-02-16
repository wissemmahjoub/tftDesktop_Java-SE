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
public class Arbitre extends Personne{
 
    private float salaire;
    private int experience;
    private Niveau niveau;

    public Arbitre() {
        super();
    }

    public Arbitre(int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, Date datenaissance, String role, String avatar, Date datedestruction,float salaire, int experience, Niveau niveau) {
        super();
        this.salaire = salaire;
        this.experience = experience;
        this.niveau = niveau;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return super.toString() + "Arbitre{" + "salaire=" + salaire + ", experience=" + experience + ", niveau=" + niveau + '}';
    }
    
    
    
    
    
}
