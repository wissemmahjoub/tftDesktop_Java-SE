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
    private TrancheAge type;
    private Date datedebut;
    private Date datefin;
    private Niveau niveau;
    private Categorie categorie;
    private int nbrpoint;

    public TrancheAge getType() {
        return type;
    }

    public void setType(TrancheAge type) {
        this.type = type;
    }
    private Date datedestruction;

    public Competition(String libelle, TrancheAge type, Date datedebut, Date datefin, Niveau niveau, Categorie categorie, int nbrpoint) {
        this.libelle = libelle;
        this.type = type;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.niveau = niveau;
        this.categorie = categorie;
        this.nbrpoint = nbrpoint;
    }

    public Competition() {
    }

    public Competition(int idcompetition) {
        this.idcompetition = idcompetition;
    }

    public Competition(int idcompetition, String libelle, TrancheAge type, Date datedebut, Date datefin, Niveau niveau, Categorie categorie, int nbrpoint) {
        this.idcompetition = idcompetition;
        this.libelle = libelle;
        this.type = type;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.niveau = niveau;
        this.categorie = categorie;
        this.nbrpoint = nbrpoint;
   
    }

    public Competition(int idcompetition, String libelle, Date datedebut, Date datefin, Niveau niveau, Categorie categorie, int nbrpoint) {
        this.idcompetition = idcompetition;
        this.libelle = libelle;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.niveau = niveau;
        this.categorie = categorie;
        this.nbrpoint = nbrpoint;
       
    }
 public Competition(int idcompetition, String libelle, Date datedebut, Date datefin, int nbrpoint, Date datedestruction) {
        this.idcompetition = idcompetition;
        this.libelle = libelle;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbrpoint = nbrpoint;
        this.datedestruction = datedestruction;
    }

    public int getIdcompetition() {
        return idcompetition;
    }

    public void setIdcompetition(int idcompetition) {
        this.idcompetition = idcompetition;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getNbrpoint() {
        return nbrpoint;
    }

    public void setNbrpoint(int nbrpoint) {
        this.nbrpoint = nbrpoint;
    }

    public Date getDatedestruction() {
        return datedestruction;
    }

    public void setDatedestruction(Date datedestruction) {
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
