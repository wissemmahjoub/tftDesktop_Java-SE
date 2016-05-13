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
public class Joueur extends Personne {
    
    private Niveau niveau;
    private TrancheAge section;
    private int idclub;

    public Joueur() {}
    
    public Joueur(int idpersonne , String cin, String nom, String prenom )
    {super(idpersonne, cin, nom, prenom);}
    public Joueur(int idpersonne , String nom, String prenom )
    {super(idpersonne,  nom, prenom);}


    public Joueur(Niveau niveau, TrancheAge section, int idclub, int idpersonne, String cin, String nom, String prenom, String adresse, String email, String sexe, String login, String password, Date datenaissance, String role, String avatar, Date datedestruction) {
        super(idpersonne, cin, nom, prenom, adresse, email, sexe, login, password, datenaissance, role, avatar, datedestruction);
        this.niveau = niveau;
        this.section = section;
        this.idclub = idclub;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public TrancheAge getSection() {
        return section;
    }

    public void setSection(TrancheAge section) {
        this.section = section;
    }

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

    @Override
    public String toString() {
        return super.toString() + "Joueur{" + "niveau=" + niveau + ", section=" + section + ", idclub=" + idclub + '}';
    }
    
    
    
}
