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
public class Evenement {
    
    private int idevenement;
    private String libelle;
    private String lieu;
    private Date datedebut;
    private Date datefin;
    private Date datedestruction;

    public Evenement() {
    }

    public Evenement(int idevenement, String libelle, String lieu, Date datedebut, Date datefin, Date datedestruction) {
        this.idevenement = idevenement;
        this.libelle = libelle;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.datedestruction = datedestruction;
    }

    public int getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(int idevenement) {
        this.idevenement = idevenement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
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

    public Date getDatedestruction() {
        return datedestruction;
    }

    public void setDatedestruction(Date datedestruction) {
        this.datedestruction = datedestruction;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idevenement=" + idevenement + ", libelle=" + libelle + ", lieu=" + lieu + ", datedebut=" + datedebut + ", datefin=" + datefin + ", datedestruction=" + datedestruction + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idevenement;
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
        final Evenement other = (Evenement) obj;
        if (this.idevenement != other.idevenement) {
            return false;
        }
        return true;
    }
    
    
    
}
