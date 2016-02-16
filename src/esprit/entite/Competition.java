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
public class Competition {
    
 
    private int idcompetition;
    private String libelle;
    private Date datedebut;
    private Date datefin;
    private Niveau niveau;
    private Categorie categorie;
    private int nbrpoint;
    private Date datedestruction;

    public Competition() {
    }

    public Competition(int idcompetition, String libelle, Date datedebut, Date datefin, Niveau niveau, Categorie categorie, int nbrpoint, Date datedestruction) {
        this.idcompetition = idcompetition;
        this.libelle = libelle;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.niveau = niveau;
        this.categorie = categorie;
        this.nbrpoint = nbrpoint;
        this.datedestruction = datedestruction;
    }

    @Override
    public String toString() {
        return "Competition{" + "idcompetition=" + idcompetition + ", libelle=" + libelle + ", datedebut=" + datedebut + ", datefin=" + datefin + ", niveau=" + niveau + ", categorie=" + categorie + ", nbrpoint=" + nbrpoint + ", datedestruction=" + datedestruction + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idcompetition;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Competition other = (Competition) obj;
        if (this.idcompetition != other.idcompetition) {
            return false;
        }
        return true;
    }
    
    
    
    
}
