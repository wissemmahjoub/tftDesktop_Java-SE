/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yasmi
 */
public class SessionFormation {
    
    private int idsession;
    private String libellesession;
    private String lieu;
    private Date datedebut;
    private Date datefin;
    private Date datedestruction;
    private Cible cible;
    private int capacite;
    private Niveau niveau;
    private TrancheAge section;

    public SessionFormation() {
    }

    public SessionFormation(int idsession, String libellesession, String lieu, Date datedebut, Date datefin,Cible cible, int capacite, Niveau niveau, TrancheAge section) {
        this.idsession = idsession;
        this.libellesession = libellesession;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.cible = cible;
        this.capacite = capacite;
        this.section = section;
    }

    public SessionFormation(int idsession,String libelesession, String lieu, Date datedebut, Date datefin,int capacite, Niveau niveau) {
        this.idsession = idsession;
        this.libellesession = libelesession;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.capacite = capacite;
        this.niveau = niveau;
    }

    public SessionFormation(int idsession, String libellesession, String lieu, Date datedebut, Date datefin, int capacite,TrancheAge section) {
        this.idsession = idsession;
        this.libellesession = libellesession;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.capacite = capacite;
        this.section = section;
    }

    
    
    
    public int getIdsession() {
        return idsession;
    }

    public void setIdsession(int idsession) {
        this.idsession = idsession;
    }

    public String getLibellesession() {
        return libellesession;
    }

    public void setLibellesession(String libellesession) {
        this.libellesession = libellesession;
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

    public Cible getCible() {
        return cible;
    }

    public void setCible(Cible cible) {
        this.cible = cible;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
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

    @Override
    public String toString() {
        return "SessionFormation{" + "idsession=" + idsession + ", libelesession=" + libellesession + ", lieu=" + lieu + ", datedebut=" + datedebut + ", datefin=" + datefin + ", datedestruction=" + datedestruction + ", cible=" + cible + ", capacite=" + capacite + ", niveau=" + niveau + ", section=" + section + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idsession;
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
        final SessionFormation other = (SessionFormation) obj;
        if (this.idsession != other.idsession) {
            return false;
        }
        return true;
    }

    
    

    
    
    
    
    
    
    
}
